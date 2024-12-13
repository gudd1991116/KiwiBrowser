package org.chromium.chrome.browser.ntp.ntp_hp.fragment.currency;

import static org.chromium.chrome.browser.ntp.ntp_hp.model.MisesSortTypeEnum.PRICE_ASC;
import static org.chromium.chrome.browser.ntp.ntp_hp.model.MisesSortTypeEnum.PRICE_DESC;
import static org.chromium.chrome.browser.ntp.ntp_hp.model.MisesSortTypeEnum.RATE_ASC;
import static org.chromium.chrome.browser.ntp.ntp_hp.model.MisesSortTypeEnum.RATE_DESC;
import static org.chromium.chrome.browser.ntp.ntp_hp.model.MisesSortTypeEnum.UNSORTED;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesCryptoAdapter;
import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesMultiItemEntity;
import org.chromium.chrome.browser.ntp.ntp_hp.fragment.currency.model.MisesCurrencyBasicModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesBaseModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesBitCoinModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesCategoryModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesNewsFeedModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnNewsClickListener;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesSortTypeEnum;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesUrlPropertyModel;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesMD5Util;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesNetworkHelper;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesRestInterface;
import org.chromium.chrome.browser.ntp.ntp_hp.provider.MisesFavoriteCoinListProvider;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesAppUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesAssetsUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesGsonUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesIdentity;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesNumberUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesSharedPreferenceUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.view.MisesCryptoSortView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gudd on 2024/11/25.
 */
public class MisesCryptoFragment extends Fragment {

    public static MisesCryptoFragment newInstance() {
        return new MisesCryptoFragment();
    }

    private MediaType mediaType;

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;

    private MisesFavoriteCoinListProvider mFavoriteCoinProvider;
    private MisesOnNewsClickListener mOnNewsClickListener;
    private MisesCryptoAdapter mCryptoAdapter;

    private final List<String> favoriteList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaType = MediaType.parse("application/json; charset=utf-8");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = LayoutInflater.from(requireContext()).inflate(R.layout.mises_fragment_news_feed, container);
        mRecyclerView = root.findViewById(R.id.rv);
        mRefreshLayout = root.findViewById(R.id.swipeRefresh);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRefreshLayout.setColorSchemeColors(Color.parseColor("#7E57C2"), Color.parseColor("#673AB7"), Color.parseColor("#512DA8"), Color.parseColor("#6200EA"));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        mRecyclerView.setHasFixedSize(true);

        mCryptoAdapter = new MisesCryptoAdapter();
        mRecyclerView.setAdapter(mCryptoAdapter);
        initDefaultData();
        getData(true);
        initListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("mises_log", "mises crypto fragment onResumt.");
        if (mFavoriteCoinProvider != null) {
            List<String> favoriteCoinUidList = mFavoriteCoinProvider.getFavoriteCoinUidList();
            if (favoriteCoinUidList != null && !favoriteCoinUidList.isEmpty()) {
                favoriteList.clear();
                favoriteList.addAll(favoriteCoinUidList);
                List<MisesBitCoinModel.CryptoModel> data = mCryptoAdapter.getData();
                // 判断列表中是否已经存在数据
                if (!data.isEmpty()) {
                    // 过滤出推荐列表中包含的收藏货币uid列表（uid是唯一识别号）
                    List<MisesBitCoinModel.CryptoModel> collect =
                            data.stream()
                                    .filter(cryptoModel -> favoriteList.contains(cryptoModel.getUid()))
                                    .sorted((o1, o2) -> MisesNumberUtil.comparePrices(o2.getPrice(), o1.getPrice()))
                                    .collect(Collectors.toList());
                    // 判断是否包含收藏标题
                    List<MisesMultiItemEntity> favoriteTitleObjList = data.stream()
                            .filter(cryptoModel -> cryptoModel.getItemType() == MisesCryptoAdapter.TYPE_FAVORITE_TITLE)
                            .collect(Collectors.toList());
                    boolean empty = favoriteTitleObjList.isEmpty();
                    Log.i("mises_log", empty ? "列表中还没有收藏标题" : "列表中有收藏标题");

                    // 如果列表中未添加收藏数据则手动插入
                    if (empty) {
                        Log.i("mises_log", "添加收藏标题");
                        // 新建收藏货币头标题
                        MisesBitCoinModel.CryptoModel suggestCurrencyHeader = new MisesBitCoinModel.CryptoModel();
                        suggestCurrencyHeader.setName(requireContext().getString(R.string.mises_currency_list_header_favorite));
                        suggestCurrencyHeader.setItemType(MisesCryptoAdapter.TYPE_FAVORITE_TITLE);
                        suggestCurrencyHeader.setGroupId(MisesCryptoAdapter.GROUP_ID_FAVORITE);
                        mCryptoAdapter.addData(suggestCurrencyHeader);
                        Log.i("mises_log", "收藏列表修中对象状态修改为：收藏和收藏分组");
                        collect.forEach(cryptoModel -> {
                            cryptoModel.setItemType(MisesCryptoAdapter.TYPE_FAVORITE_COIN);
                            cryptoModel.setGroupId(MisesCryptoAdapter.GROUP_ID_FAVORITE);
                        });
                        // 添加所有收藏货币列表
                        mCryptoAdapter.addData(1, collect);
                    } else {
                        Log.i("mises_log", "按收藏标题组更新收藏列表");
                        // 如果列表存在收藏数据，则更新收藏数据
                        mCryptoAdapter.updateGroup(MisesCryptoAdapter.GROUP_ID_FAVORITE, collect);
                    }
                }
            }
        }
    }

    public void setMisesFavoriteCoinListProvider(MisesFavoriteCoinListProvider provider) {
        this.mFavoriteCoinProvider = provider;
        // 这里会比onResume和onViewCreated先执行，所以先取出所有收藏uid并保存到变量中方便后续使用
        Log.i("mises_log", "执行设置收藏列表方法");
        if (mFavoriteCoinProvider != null) {
            List<String> favoriteCoinUidList = mFavoriteCoinProvider.getFavoriteCoinUidList();
            if (favoriteCoinUidList != null && !favoriteCoinUidList.isEmpty()) {
                Log.i("mises_log", "收藏列表不为空："+new Gson().toJson(favoriteList));
                favoriteList.addAll(favoriteCoinUidList);
            }else{
                Log.i("mises_log", "收藏列表为空");
            }
        }
    }

    /**
     * 首次进入界面时，判断本地内存是否存在缓存数据。
     * 如果存在缓存数据，先从缓存数据中过滤出匹配收藏的货币列表的uid相关数据，并插入到列表前面，最后将缓存数据按默认排序进行排列插入列表
     */
    private void initDefaultData(/*List<MisesBitCoinModel.CryptoModel> cryptoModels*/) {
        Log.i("mises_log", "go into initDefaultData()");
        mCryptoAdapter.mData.clear();
        mCryptoAdapter.notifyDataSetChanged();
        // 获取推荐货币缓存列表
        String cryptoListJsonOfCache = MisesSharedPreferenceUtil.getInstance(getContext()).getString(MisesSharedPreferenceUtil.KEY_CRYPTO_LIST_CACHE, "");
        Log.i("mises_log", "缓存货币列表：" + cryptoListJsonOfCache);
        if (!TextUtils.isEmpty(cryptoListJsonOfCache)) {
            Log.i("mises_log", "缓存货币列表不为空");
            Gson gson = new Gson();
            Type type = new TypeToken<List<MisesBitCoinModel.CryptoModel>>() {
            }.getType();

            // 将缓存列表json数据转换为对象列表
            List<MisesBitCoinModel.CryptoModel> mSuggestCurrencyList = gson.fromJson(cryptoListJsonOfCache, type);
            Log.i("mises_log", "转换缓存货币json数据为对象列表。");
            if (mSuggestCurrencyList != null && !mSuggestCurrencyList.isEmpty()) {
                Log.i("mises_log", "缓存货币列表对象size=" + mSuggestCurrencyList.size());
                // 过滤出推荐列表中包含的收藏货币uid列表（uid是唯一识别号），并按price价格排序
                List<MisesBitCoinModel.CryptoModel> collect =
                        mSuggestCurrencyList.stream()
                                .filter(cryptoModel -> favoriteList.contains(cryptoModel.getUid()))
                                .sorted((o1, o2) -> MisesNumberUtil.comparePrices(o2.getPrice(), o1.getPrice()))
                                .collect(Collectors.toList());

                Log.i("mises_log", "过滤收藏对应列表");
                if (!collect.isEmpty()) {
                    Log.i("mises_log", "收藏列表不为空，添加收藏列表标题");
                    // 创建收藏货币头标题
                    MisesBitCoinModel.CryptoModel favoriteCurrencyHeader = new MisesBitCoinModel.CryptoModel();
                    favoriteCurrencyHeader.setName("My Favorite");
                    favoriteCurrencyHeader.setItemType(MisesCryptoAdapter.TYPE_FAVORITE_TITLE);
                    favoriteCurrencyHeader.setGroupId(MisesCryptoAdapter.GROUP_ID_FAVORITE);
                    List<MisesBitCoinModel.CryptoModel> favoriteCurrencies = new ArrayList<>();
                    favoriteCurrencies.add(favoriteCurrencyHeader);
                    mCryptoAdapter.addData(favoriteCurrencies);
                    // 设置收藏数据类型和分组类型
                    Log.i("mises_log", "收藏列表对象设置分组状态：收藏和收藏组");
                    collect.forEach(cryptoModel -> {
                        cryptoModel.setItemType(MisesCryptoAdapter.TYPE_FAVORITE_COIN);
                        cryptoModel.setGroupId(MisesCryptoAdapter.GROUP_ID_FAVORITE);
                    });
                    Log.i("mises_log", "收藏列表添加到分组");
                    // 收藏货币列表插入到列表
                    mCryptoAdapter.addData(collect);
                }

                Log.i("mises_log", "添加默认推荐货币标题头");
                // 创建推荐默认货币头标题
                MisesBitCoinModel.CryptoModel suggestCurrencyHeader = new MisesBitCoinModel.CryptoModel();
                suggestCurrencyHeader.setName("All");
                suggestCurrencyHeader.setItemType(MisesCryptoAdapter.TYPE_ALL_CURRENCY_TITLE);
                suggestCurrencyHeader.setGroupId(MisesCryptoAdapter.GROUP_ID_SUGGEST);
                Log.i("mises_log", "插入推荐标题头");
                List<MisesBitCoinModel.CryptoModel> suggestHeaderCurrencies = new ArrayList<>();
                suggestHeaderCurrencies.add(suggestCurrencyHeader);
                mCryptoAdapter.addData(suggestHeaderCurrencies);

                /*mSuggestCurrencyList.forEach(cryptoModel -> {
                    cryptoModel.setItemType(MisesCryptoAdapter.TYPE_ALL_CURRENCY_COIN);
                    cryptoModel.setGroupId(MisesCryptoAdapter.GROUP_ID_SUGGEST);
                });*/

                List<MisesBitCoinModel.CryptoModel> suggestCurrencies = new ArrayList<>();
                for (int i = 0; i < mSuggestCurrencyList.size(); i++) {
                    MisesBitCoinModel.CryptoModel originalModel = mSuggestCurrencyList.get(i);
                    MisesBitCoinModel.CryptoModel cryptoModel = originalModel.clone();
                    cryptoModel.setItemType(MisesCryptoAdapter.TYPE_ALL_CURRENCY_COIN);
                    cryptoModel.setGroupId(MisesCryptoAdapter.GROUP_ID_SUGGEST);
                    suggestCurrencies.add(cryptoModel);
                }

                int sortType = mCryptoAdapter.getSortType();
                Log.i("mises_log", "当前排序类型：" + sortType + ", 并开始排序。");
                sortWithCryptoList(sortType, suggestCurrencies);
                // 添加所有默认推荐货币列表
                Log.i("mises_log", "将推荐货币列表插入到列表中");
                mCryptoAdapter.addData(suggestCurrencies);
            }
        }
    }

    private void getData(boolean isRefresh) {
        Log.i("mises_log", "start get data.");
        if (isRefresh && mCryptoAdapter.getData().isEmpty()) {
            showRefresh();
        }

        String time = String.valueOf(System.currentTimeMillis());
        String header = MisesMD5Util.to32BitMD5(MisesAppUtil.getAppVersionName(requireContext()) + MisesIdentity.getCid() + "1" + MisesNetworkHelper.getInstance().API2_KEY + time);
        Log.i("mises_log","mises crypto list req header : " + header);

        RequestBody requestBody = RequestBody.create(generateCryptoListReqParams(MisesIdentity.getCid(),time),mediaType);
        Call<MisesBaseModel<MisesCurrencyBasicModel>> currencyList = MisesNetworkHelper.getInstance().getBaseApi2Interface().getCurrencyList(header, requestBody);
        currencyList.enqueue(new Callback<MisesBaseModel<MisesCurrencyBasicModel>>() {
            @Override
            public void onResponse(@NonNull Call<MisesBaseModel<MisesCurrencyBasicModel>> call, @NonNull Response<MisesBaseModel<MisesCurrencyBasicModel>> response) {
                Log.i("mises_log", "fetch data into onResponse.");
                hideRefresh();
                if (response.isSuccessful()){
                    Log.i("mises_log", "请求货币列表接口响应成功");
                    MisesBaseModel<MisesCurrencyBasicModel> body = response.body();
                    if (body != null){
                        List<MisesCurrencyBasicModel> data = body.getData();
                        Log.i("mises_log", "请求货币列表接口响应成功");
                        List<MisesBitCoinModel.CryptoModel> models = convertCurrencyListToCryptoList(
                                data, MisesCryptoAdapter.TYPE_ALL_CURRENCY_COIN, MisesCryptoAdapter.GROUP_ID_SUGGEST);
                        saveToCache(models);
                        Log.i("mises_log", "保存从服务器获取的的货币列表到缓存。");

                        initDefaultData();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<MisesBaseModel<MisesCurrencyBasicModel>> call, @NonNull Throwable t) {
                hideRefresh();
                Log.i("mises_log", "获取货币列表请求接口失败 ,error message : " + t.getMessage());
            }
        });
    }

    private void initListener() {
        mRefreshLayout.setOnRefreshListener(() -> {
            getData(true);
        });

        if (mCryptoAdapter != null) {
            mCryptoAdapter.setOnItemClickListener(position -> {
                String coinUidKey = "";
                if (!mCryptoAdapter.mData.isEmpty()) {
                    MisesBitCoinModel.CryptoModel cryptoModel = mCryptoAdapter.mData.get(position);
                    if (cryptoModel != null) {
                        coinUidKey = cryptoModel.getUid();
                    }
                }

                if (TextUtils.isEmpty(coinUidKey)) {
                    return;
                }

                if (mOnNewsClickListener != null) {
                    mOnNewsClickListener.onClickCrypto(coinUidKey);
                }
            });

            mCryptoAdapter.setSortCurrencyListener(new MisesCryptoAdapter.OnSortCurrencyListener() {
                @Override
                public void onPriceSort(int position, int type) {
                    MisesBitCoinModel.CryptoModel itemData = mCryptoAdapter.getItemData(position);
                    if (itemData != null) {
                        int groupId = itemData.getGroupId();
                        int sortType;
                        if (type == MisesCryptoSortView.SortType.DESC) {
                            sortType = PRICE_DESC;
                        } else {
                            sortType = PRICE_ASC;
                        }
                        sortGroup(groupId, sortType);
                    }
                }

                @Override
                public void onTwentyFourHour(int position, int type) {
                    MisesBitCoinModel.CryptoModel itemData = mCryptoAdapter.getItemData(position);
                    if (itemData != null) {
                        int groupId = itemData.getGroupId();
                        int sortType;
                        if (type == MisesCryptoSortView.SortType.DESC) {
                            sortType = RATE_DESC;
                        } else {
                            sortType = RATE_ASC;
                        }
                        sortGroup(groupId, sortType);
                    }
                }
            });
        }
    }

    private void sortGroup(int groupId, @MisesSortTypeEnum int sortType) {
        List<MisesBitCoinModel.CryptoModel> groupItems = new ArrayList<>();
        int startIndex = -1;
        List<MisesBitCoinModel.CryptoModel> data = mCryptoAdapter.getData();
        for (int i = 0; i < data.size(); i++) {
            MisesBitCoinModel.CryptoModel cryptoModel = data.get(i);
            if (cryptoModel != null) {
                if (cryptoModel.getGroupId() == groupId) {
                    if (cryptoModel.getItemType() == MisesCryptoAdapter.TYPE_ALL_CURRENCY_COIN) {
                        groupItems.add(cryptoModel);
                    } else if (cryptoModel.getItemType() == MisesCryptoAdapter.TYPE_ALL_CURRENCY_TITLE && startIndex == -1) {
                        startIndex = i;
                    }
                }
            }
        }
        // 对列表进行排序
        sortWithCryptoList(sortType, groupItems);

        Log.i("mises_log", "rangeIndex adapter data size : " + mCryptoAdapter.getData().size()+" , groupSize = "+ groupItems.size());
        for (int i = 0; i < groupItems.size(); i++) {
            int rangeIndex = startIndex + 1 + i;
            Log.i("mises_log", "rangeIndex = " + rangeIndex+", i = "+i);
            mCryptoAdapter.getData().set(rangeIndex, groupItems.get(i));
        }
        /*int displaySize = mCryptoAdapter.getData().size();
        mCryptoAdapter.mData.subList(startIndex+1,displaySize).clear();
        mCryptoAdapter.notifyItemRangeRemoved(startIndex+1,displaySize);
        mCryptoAdapter.mData.addAll(groupItems);*/
        mCryptoAdapter.notifyItemRangeChanged(startIndex + 1, groupItems.size());
    }

    private void sortWithCryptoList(@MisesSortTypeEnum int sortType, List<MisesBitCoinModel.CryptoModel> groupItems) {
        // 对列表进行排序
        Comparator<MisesBitCoinModel.CryptoModel> comparator = null;
        switch (sortType) {
            case PRICE_DESC:
                comparator = (o1, o2) -> MisesNumberUtil.comparePrices(o2.getPrice(), o1.getPrice());
                break;
            case PRICE_ASC:
                comparator = (o1, o2) -> MisesNumberUtil.comparePrices(o1.getPrice(), o2.getPrice());
                break;
            case RATE_DESC:
                comparator = Comparator.comparingDouble(MisesBitCoinModel.CryptoModel::getTwentyFourHour).reversed();// Comparator.comparingDouble(o -> o.getRate()); // Assuming `rate` is a double
                break;
            case RATE_ASC:
                comparator = Comparator.comparingDouble(MisesBitCoinModel.CryptoModel::getTwentyFourHour); // Assuming `rate` is a double
                break;
            case UNSORTED:
                break;
            default:
                throw new IllegalArgumentException("Invalid sort type");
        }
        if (comparator != null) {
            groupItems.sort(comparator);
        }
    }

    private List<MisesBitCoinModel.CryptoModel> convertCurrencyListToCryptoList(List<MisesCurrencyBasicModel> list, int itemType, int groupId) {
        Log.i("mises_log", "guddd convert currency list to crypto to list ");
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<MisesBitCoinModel.CryptoModel> resultList = new ArrayList<>();
        for (MisesCurrencyBasicModel currency : list) {
            MisesBitCoinModel.CryptoModel cryptoModel = new MisesBitCoinModel.CryptoModel();
            cryptoModel.setUid(currency.getUid());
            cryptoModel.setName(currency.getName());
            cryptoModel.setPrice(currency.getPrice());
            cryptoModel.setTwentyFourHour(Double.parseDouble(currency.getPrice_change_24h()));//(MisesNumberUtil.parseToBigDecimal(currency.getPrice_change_24h()));
            cryptoModel.setSymbol(currency.getCode());
            cryptoModel.setImage(currency.getImage());
            cryptoModel.setGroupId(groupId);
            cryptoModel.setItemType(itemType);
            resultList.add(cryptoModel);
        }
        return resultList;
    }

    private String generateCryptoListReqParams(String channel, String time) {
        HashMap<String, String> params = new HashMap<>();
        params.put("channel", channel);
        params.put("platform", "1");
        params.put("versionName", MisesAppUtil.getAppVersionName(requireContext()));
        params.put("time", time);
        return new Gson().toJson(params);
    }

    private void hideRefresh() {
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
    }

    private void showRefresh() {
        if (!mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(true);
        }
    }

    private void saveToCache(List<MisesBitCoinModel.CryptoModel> list) {
        if (list != null && !list.isEmpty()) {
            String convertListToJsonString = new Gson().toJson(list);
            MisesSharedPreferenceUtil.getInstance(getContext()).putString(MisesSharedPreferenceUtil.KEY_CRYPTO_LIST_CACHE, convertListToJsonString);
        }
    }

    public void setOnItemClickListener(MisesOnNewsClickListener listener) {
        mOnNewsClickListener = listener;
    }

}
