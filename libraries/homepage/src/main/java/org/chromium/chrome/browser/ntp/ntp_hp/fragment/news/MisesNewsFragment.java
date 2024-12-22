package org.chromium.chrome.browser.ntp.ntp_hp.fragment.news;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.MisesHomePageView;
import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesNewsFeedAdapter;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesCategoryModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesNewsFeedModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnNewsClickListener;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesUrlPropertyModel;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesNetworkHelper;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesRestInterface;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesIdentity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gudd on 2024/11/25.
 */
public class MisesNewsFragment extends Fragment {
    private static final String TAG = "MisesNewsFragment";

    public static MisesNewsFragment newInstance(ArrayList<MisesCategoryModel> categoryModels) {
        MisesNewsFragment fragment = new MisesNewsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("categories", categoryModels);
        fragment.setArguments(bundle);
        return fragment;
    }

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;

    private MisesOnNewsClickListener mOnNewsClickListener;
    private MisesNewsFeedAdapter mNewsAdapter;

    private String mCategoryUrl = "";
    private final ArrayList<MisesCategoryModel> mCategoriesList = new ArrayList<>();
    private int mOffset = 0;
    private final String[] linkParamsKey = new String[]{"cty", "lang", "session", "cc", "offset", "limit", "ts"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = LayoutInflater.from(requireContext()).inflate(R.layout.mises_fragment_news_feed, container);
//        mCategoryRV = root.findViewById(R.id.category_rv);
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

        mNewsAdapter = new MisesNewsFeedAdapter();
        mRecyclerView.setAdapter(mNewsAdapter);
        initListener();
        getCategories();
    }

    private void getCategories() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            ArrayList<MisesCategoryModel> categories = arguments.getParcelableArrayList("categories");
            if (categories != null && !categories.isEmpty()) {
                // 将headline排序到第一位并过滤出非Currency的列表内容
                String targetName = "headline";
                List<MisesCategoryModel> collect = categories.stream().filter(misesCategoryModel ->
                                !misesCategoryModel.getTitle().equals(MisesHomePageView.CRYPTO_DEFAULT) && !misesCategoryModel.getTitle().toLowerCase().equals(targetName)
                        ).sorted((model1, model2) -> model1.getTitle().toLowerCase().equals(targetName) ? -1 : model2.getTitle().toLowerCase().equals(targetName) ? 1 : 0)
                        .collect(Collectors.toList());
                Log.i("mises_log", "newsfragment filter and sorted data : " + new Gson().toJson(collect));
                mCategoriesList.clear();
                mCategoriesList.addAll(collect);
                mNewsAdapter.setHeaderList(mCategoriesList);

                if (mCategoriesList.get(0) != null) {
                    Log.i("mises_log", "newsfragment categories find first data is not empty.");
                    MisesCategoryModel misesCategoryModel = mCategoriesList.get(0);
                    Log.i("mises_log", "newsfragment first data is : " + new Gson().toJson(misesCategoryModel));
                    if (misesCategoryModel != null) {
                        mCategoryUrl = misesCategoryModel.getUrl();
                        Log.i("mises_log","newsfragment categoryUrl is : "+ mCategoryUrl+" and start getData.");
                        mRefreshLayout.post(() -> {
                            mRefreshLayout.setRefreshing(true);
                        });

                    }
                }
            }
        }
    }

    private void getData(String mCategoryUrl, boolean isRefresh) {
        Log.i("mises_log", "newsfragment start getdata.");
        if (isRefresh && !mRefreshLayout.isRefreshing()) {
            Log.i("mises_log", "newsfragment showRefresh().");
            showRefresh();
        }
        if (TextUtils.isEmpty(mCategoryUrl)) {
            Log.i("mises_log", "newsfragment mCategoryUrl is empty and hideRefresh.");
            hideRefresh();
            return;
        }

        long curTs = System.currentTimeMillis() / 1000;
        Log.i("mises_log","mises news feed offset: " + mOffset);

        MisesUrlPropertyModel urlPropertyModel = new MisesUrlPropertyModel(mCategoryUrl, linkParamsKey);
        String api = urlPropertyModel.getFull_host();
        String fullPath = urlPropertyModel.getFull_path();
        Log.i("mises_log", "newsfragment convertUrl-api=" + api + ",fullpath =" + fullPath);

        // 获取通用数据
        String cty = Locale.getDefault().getCountry();
        String lang = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(cty)) {
            cty = "US";
            lang = "en";
        }
        int limit = 10;
        int offset = mOffset;

        Map<String, String> additionalParams = new HashMap<>();
        additionalParams.put("cty", cty);
        additionalParams.put("lang", lang);
        additionalParams.put("session", "init");
        additionalParams.put("cc", MisesIdentity.getCid());
        additionalParams.put("ts", curTs + "");
        additionalParams.put("limit", String.valueOf(limit));
        additionalParams.put("offset", String.valueOf(offset));

        Log.i("mises_log", "newsfragment request params json is =" + new Gson().toJson(additionalParams));
        MisesRestInterface cusApiInterface = MisesNetworkHelper.getInstance().getInterface(api);
        Call<MisesNewsFeedModel> newsList = cusApiInterface.getNewsList(fullPath, additionalParams);
        Log.i("mises_log", "newsfragment start enqueue.");
        newsList.enqueue(new Callback<MisesNewsFeedModel>() {
            @Override
            public void onResponse(@NonNull Call<MisesNewsFeedModel> call, @NonNull Response<MisesNewsFeedModel> response) {
                Log.i("mises_log", "newsfragment onResponse.");
                mRecyclerView.post(() -> {
                    hideRefresh();
                    if (response.isSuccessful()) {
                        MisesNewsFeedModel body = response.body();
                        Log.i("mises_log","response.body() : "+ response.body());
                        if (body != null && body.getAds() != null && !body.getAds().isEmpty()) {
                            List<MisesNewsFeedModel.AdsModel> ads = body.getAds();
                            Log.i("mises_log","mises news feed result size: " + ads.size());
                            Log.i("mises_log","mises news feed result : " + new Gson().toJson(ads));
                            mOffset += limit;

                            mNewsAdapter.hideFooter(); // 隐藏FooterView

                            if (isRefresh) {
                                Log.i("mises_log","mises news feed set newData ");
                                mNewsAdapter.setNewData(ads);
                            } else {
                                Log.i("mises_log","mises news feed add data. ");
//                                mNewsAdapter.hideFooter(); // 隐藏FooterView
                                if (ads.size() < limit) {
                                    mNewsAdapter.loadFinish();
                                }
                                mNewsAdapter.addData(ads);
                            }
                        } else {
                            mNewsAdapter.hideFooter(); // 隐藏FooterView
                            mNewsAdapter.loadFinish();
                            if (body != null && body.getAds() != null) {
                                Log.i("mises_log","body.getAds() json:  "+ new Gson().toJson(body.getAds()));
                            }
                            Log.i("mises_log","body != null : "+ (body != null)+", body.getAds() != null : "+(body.getAds() != null)+", body.getAds().isEmpty() : "+(body.getAds().isEmpty()));
                            Log.i("mises_log","mises news feed result empty.");
                            Toast.makeText(requireContext(), requireContext().getString(R.string.mises_no_result_found), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Log.i("mises_log","mises news feed result failed.");
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<MisesNewsFeedModel> call, @NonNull Throwable t) {
                hideRefresh();
                Log.i("mises_log","mises news feed failed : " + t.getMessage());
            }
        });

    }

    private void initListener() {
        if (mNewsAdapter != null) {
            mNewsAdapter.setOnHeaderItemClickListener(item -> {
                if (item != null) {
                    String url = item.getUrl();
                    mCategoryUrl = url;
                    mOffset = 0;
                    getData(url, true);
                }
            });
            mNewsAdapter.setOnItemClickListener(position -> {
                if (!mRefreshLayout.isRefreshing()){
                    List<MisesNewsFeedModel.AdsModel> data = mNewsAdapter.data;
                    if (!data.isEmpty() && position < data.size()) {
                        MisesNewsFeedModel.AdsModel adsModel = data.get(position);
                        StringBuilder linkHost = new StringBuilder("https://taitunews.com/");
                        String id = adsModel.getId();
                        String language = adsModel.getLanguage();
                        String type = "";
                        MisesNewsFeedAdapter.HeaderViewHolder headerView = mNewsAdapter.getHeaderView();
                        if (headerView != null) {
                            type = headerView.getSelectedChannelName().toLowerCase(Locale.US);
                           /* if (TextUtils.equals(type,"crypto")){
                                type = "crypto1";
                            }*/
                        }
                        linkHost.append("h5/").append(type).append("/");
                        if (TextUtils.equals(adsModel.getType(),"boseai-news")){
                            linkHost.append("detail2").append("?");
                        }else{
                            linkHost.append("detail").append("?");
                        }
                        linkHost.append("id=").append(id).append("&")
                                .append("language=").append(language).append("&")
                                .append("type=").append(type);

                        Log.i("mises_log", "点击新闻链接：" + linkHost);
                        if (mOnNewsClickListener != null) {
                            mOnNewsClickListener.onClick(linkHost.toString());
                        }
                        /*if (!TextUtils.isEmpty(adsModel.getId()) && TextUtils.equals(MisesNewsFeedAdapter.AI_NEWS, adsModel.getType())) {
                            MisesAiNewsDetailActivity.startActivity(getContext(), adsModel);
                        } else {
                            Log.d(TAG, String.format("click news: link=%s", adsModel.getLink()));
                            if (mOnNewsClickListener != null) {
                                mOnNewsClickListener.onClick(adsModel.getLink());
                            }
                        }*/
                    }
                }
            });
        }

        mRefreshLayout.setOnRefreshListener(this::refreshData);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (mNewsAdapter != null) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    if (layoutManager != null && !mNewsAdapter.isLoadingFooter) {
                        int visibleItemCount = layoutManager.getChildCount();
                        int totalItemCount = layoutManager.getItemCount();
                        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                        // 判断是否接近底部
                        if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0 && !mRefreshLayout.isRefreshing()) {
                            // 显示Footer并加载更多数据
                            mNewsAdapter.showFooter();
                            Log.i("mises_log","guddd onScrolled....categoryUrl : " + mCategoryUrl);
                            getData(mCategoryUrl, false);
                        }
                    }
                }
            }
        });
    }

    private void refreshData() {
        mOffset = 0;
        getData(mCategoryUrl, true);
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

    public void setOnItemClickListener(MisesOnNewsClickListener listener) {
        mOnNewsClickListener = listener;
    }
}
