package org.chromium.chrome.browser.ntp.ntp_hp.view.topsite;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesTopSiteAdapter;
import org.chromium.chrome.browser.ntp.ntp_hp.helper.MisesAddTopSiteDialog;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesBaseModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesTopSiteModel;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesMD5Util;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesNetworkHelper;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesAppUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesIdentity;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesSharedPreferenceUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.view.topsite.gridlayoutmanager.MisesPagerGridLayoutManager;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gudd on 2024/12/10.
 * total height 80dp
 */
public class MisesHorizontalTopsiteView extends LinearLayout implements MisesPagerGridLayoutManager.PagerChangedListener {
    private final static String DEF_ICON_URL = "https://service.bosebrowser.com/img/web3.png";
    private final Context mContext;
    private final RecyclerView mRecyclerView;
    private MisesTopSiteAdapter mAdapter;
    //    private IBrowserDelegate mDelegate;
    private MisesPagerGridLayoutManager mLayoutManager;
    private LinearLayout mIndicatorView;

    private final List<MisesTopSiteModel> topSiteModels = new ArrayList<>();

    private int mCurrentPage = 0;
    private final MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

    private MisesOnWebsiteClickListener mOnWebsiteClickListener;

    public MisesHorizontalTopsiteView(Context context) {
        this(context, null);
    }

    public MisesHorizontalTopsiteView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MisesHorizontalTopsiteView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.mises_horizontal_topsite_view, this);
        mContext = context;
        mRecyclerView = findViewById(R.id.rv);
        initGridLayoutManager();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        initAdapter();
        setAdapterData();
        fetchTopSitesFromServer();
    }

    public void setOnWebsiteClickListener(MisesOnWebsiteClickListener listener) {
        this.mOnWebsiteClickListener = listener;
    }


    private void initGridLayoutManager() {
        mLayoutManager = new MisesPagerGridLayoutManager(1, 5, MisesPagerGridLayoutManager.HORIZONTAL);
        mLayoutManager.setMillisecondPreInch(70);
        mLayoutManager.setMaxScrollOnFlingDuration(200);
        mLayoutManager.setPagerChangedListener(this);
    }

    public void destroy() {
    }

    private void initAdapter() {
        mAdapter = new MisesTopSiteAdapter();
        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.bindToRecyclerView(mRecyclerView);

        mAdapter.setOnItemClickListener(position -> {
            List<MisesTopSiteModel> data = mAdapter.getData();
            if (position >= 0 && position < data.size()) {
                MisesTopSiteModel website = data.get(position);
                if ("-1".equals(website.getType())) {
                    MisesAddTopSiteDialog dialog = new MisesAddTopSiteDialog(getContext());
                    dialog.setOnAddResult((name, url) -> {
                        MisesTopSiteModel model = new MisesTopSiteModel();
                        model.setText(name);
                        model.setUrl(url);
                        model.setImgUrl(getDefaultTopSiteIconUrl());
                        model.setType(System.currentTimeMillis() + "");
                        saveTopSitesFromManual(model);
                        mAdapter.addManualData(model);
                    }).showDialog();
                }else{
                    if (mOnWebsiteClickListener != null) {
                        mOnWebsiteClickListener.onWebsiteItemClick(website);
                    }
                }
            }
        });

    }

    private void setAdapterData() {
        getTopSites();
    }

    @Override
    public void onPagerCountChanged(int pagerCount) {
    }

    @Override
    public void onPagerIndexSelected(int prePagerIndex, int currentPagerIndex) {
        mCurrentPage = currentPagerIndex;
    }

    private void getTopSites() {
        String topSitesFromSp = getTopSitesFromSp();
        Log.i("mises_log", "SP内名站数据：" + topSitesFromSp);
        String topSiteOfManualFromSp = getTopSiteOfManualFromSp();
        List<MisesTopSiteModel> list = convertTopSiteStrToList(topSitesFromSp);
        List<MisesTopSiteModel> manualAddList = convertTopSiteStrToList(topSiteOfManualFromSp);
        if (list != null && !list.isEmpty()) {
            list.addAll(manualAddList);
            // 排队type=1的对象，将type=-1的对象移动到列表末尾
            // todo临时将"+"对象去掉
            List<MisesTopSiteModel> defaultList = list.stream().filter(misesTopSiteModel -> !"1".equals(misesTopSiteModel.getType()) && !"-1".equals(misesTopSiteModel.getType()))
                    .sorted(((o1, o2) -> {
                        // 先按 type 升序排序，但将 type == "-1" 的对象放到最后
                        if ("-1".equals(o1.getType())) return 1;
                        if ("-1".equals(o2.getType())) return -1;
                        return o1.getType().compareTo(o2.getType());
                    }/* TextUtils.equals(o1.getType(), "-1") ? 0 : -1*/))
                    .collect(Collectors.toList());
            // 只提取type == 1的默认值
            MisesTopSiteModel defaultIconModel = list.stream().filter(misesTopSiteModel -> "1".equals(misesTopSiteModel.getType())).findFirst().orElse(null);
            if (defaultIconModel != null) {
                String imgUrl = defaultIconModel.getImgUrl();
                saveDefaultTopSiteIconUrl(imgUrl);
            }

            topSiteModels.clear();
            topSiteModels.addAll(defaultList);
            mAdapter.setNewData(topSiteModels);
        }
    }

    private void fetchTopSitesFromServer() {
        String channel = MisesIdentity.getCid();
        String time = String.valueOf(System.currentTimeMillis());
        String header = MisesMD5Util.to32BitMD5(MisesAppUtil.getAppVersionName(getContext()) + MisesIdentity.getCid() + "1" + MisesNetworkHelper.getInstance().API2_KEY + time);
        // 从服务器获取名站列表，并保存到本地内存数据中
        RequestBody requestBody = RequestBody.create(generateCategoriesReqParams(channel, time), mediaType);
        Call<MisesBaseModel<MisesTopSiteModel>> topSites = MisesNetworkHelper.getInstance().getBaseApi2Interface().getTopSites(header, requestBody);
        topSites.enqueue(new Callback<MisesBaseModel<MisesTopSiteModel>>() {
            @Override
            public void onResponse(@NonNull Call<MisesBaseModel<MisesTopSiteModel>> call, @NonNull Response<MisesBaseModel<MisesTopSiteModel>> response) {
                if (response.isSuccessful()) {
                    Log.i("mises_log", "mises categories on fetch success");
                    MisesBaseModel<MisesTopSiteModel> body = response.body();
                    if (body != null) {
                        Log.i("mises_log", "mises categories body is not null.");
                        List<MisesTopSiteModel> data = body.getData();
                        if (data != null && !data.isEmpty()) {
                            saveTopSitesFromServer(data);
                            getTopSites();
                        }
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<MisesBaseModel<MisesTopSiteModel>> call, @NonNull Throwable t) {
                Log.i("mises_log", "mises categories fetch top site failed : " + t.getMessage());
            }
        });
    }

    private String getTopSitesFromSp() {
        return MisesSharedPreferenceUtil.getInstance(getContext()).getString(MisesSharedPreferenceUtil.mKey_NtpTopSitesForSP, "");
    }

    private String getTopSiteOfManualFromSp() {
        return MisesSharedPreferenceUtil.getInstance(getContext()).getString(MisesSharedPreferenceUtil.mKey_NtpTopSitesManualAdd, "");
    }

    private String getDefaultTopSiteIconUrl() {
        return MisesSharedPreferenceUtil.getInstance(getContext()).getString(MisesSharedPreferenceUtil.mKey_NtpTopSitesDefIconUrl, DEF_ICON_URL);
    }

    // 保存从服务器获取的名站内容
    private void saveTopSitesFromServer(List<MisesTopSiteModel> list) {
        if (!list.isEmpty()) {
            String json = new Gson().toJson(list);
            Log.i("mises_log", "保存服务器获取的名站配置 : " + json);
            MisesSharedPreferenceUtil.getInstance(getContext()).putString(MisesSharedPreferenceUtil.mKey_NtpTopSitesForSP, json);
        }
    }

    // 保存手动添加的名站内容
    private void saveTopSitesFromManual(MisesTopSiteModel topSite) {
        String topSiteOfManualFromSp = getTopSiteOfManualFromSp();
        List<MisesTopSiteModel> list = convertTopSiteStrToList(topSiteOfManualFromSp);
        if (list != null) {
            list.add(topSite);
        } else {
            list = new ArrayList<>();
            list.add(topSite);
        }
        String json = new Gson().toJson(list);
        MisesSharedPreferenceUtil.getInstance(getContext()).putString(MisesSharedPreferenceUtil.mKey_NtpTopSitesManualAdd, json);
    }

    private void saveDefaultTopSiteIconUrl(String defaultIconUrl) {
        if (TextUtils.isEmpty(defaultIconUrl)) {
            defaultIconUrl = DEF_ICON_URL;
        }
        MisesSharedPreferenceUtil.getInstance(getContext()).putString(MisesSharedPreferenceUtil.mKey_NtpTopSitesDefIconUrl, defaultIconUrl);
    }

    private List<MisesTopSiteModel> convertTopSiteStrToList(String topSiteStr) {
        if (!TextUtils.isEmpty(topSiteStr)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<MisesTopSiteModel>>() {
            }.getType();
            return gson.fromJson(topSiteStr, type);
        }
        return new ArrayList<>();
    }

    private String generateCategoriesReqParams(String channel, String time) {
        HashMap<String, String> params = new HashMap<>();
        params.put("channel", channel);
        params.put("platform", "1");
        params.put("versionName", MisesAppUtil.getAppVersionName(getContext()));
        params.put("type", String.valueOf(MisesSharedPreferenceUtil.mNtpType));
        params.put("time", time);
        return new Gson().toJson(params);
    }

}
