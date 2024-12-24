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
import org.chromium.chrome.browser.ntp.ntp_hp.adapter.MisesNewsFeedAdapter;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesCategoryModel;
import org.chromium.chrome.browser.ntp.ntp_hp.database.model.MisesNewsFeedModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnNewsClickListener;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesUrlPropertyModel;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesNetworkHelper;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesRestInterface;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesIdentity;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MisesNewsV2Fragment extends Fragment {
    private final String Log_msg_content = "mises news v2 fragment ,position :";

    public static MisesNewsV2Fragment newInstance(MisesCategoryModel categoryModel, int viewpagerIndex) {
        MisesNewsV2Fragment fragment = new MisesNewsV2Fragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("category", categoryModel);
        bundle.putInt("position", viewpagerIndex);
        fragment.setArguments(bundle);
        return fragment;
    }

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;

    private MisesOnNewsClickListener mOnNewsClickListener;
    private MisesNewsFeedAdapter mNewsAdapter;

    private int position = 0;
    private String mCategoryUrl = "";
    private MisesCategoryModel mCategory ;
    private int mOffset = 0;
    private final String[] linkParamsKey = new String[]{"cty", "lang", "session", "cc", "offset", "limit", "ts"};
    private int firstReqCount = 0;
    private final int allowReqMaxCount = 3;

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
            MisesCategoryModel category = arguments.getParcelable("category");
            mCategory = category;
            position = arguments.getInt("position");
            Log.i("mises_log", Log_msg_content + position + ", category : " + new Gson().toJson(category));
            if (category != null) {
                mCategoryUrl = category.getUrl();
                Log.i("mises_log", Log_msg_content + position + "newsfragment categoryUrl is : " + mCategoryUrl + " and start getData.");
                mRefreshLayout.post(() -> {
                    mRefreshLayout.setRefreshing(true);
                });
                refreshData();
            }
        }
    }

    private void getData(String mCategoryUrl, boolean isRefresh) {
        Log.i("mises_log", Log_msg_content + position + "newsfragment start getdata.");
        if (isRefresh && !mRefreshLayout.isRefreshing()) {
            Log.i("mises_log", Log_msg_content + position + "newsfragment showRefresh().");
            showRefresh();
        }
        if (TextUtils.isEmpty(mCategoryUrl)) {
            Log.i("mises_log", Log_msg_content + position + "newsfragment mCategoryUrl is empty and hideRefresh.");
            hideRefresh();
            return;
        }

        long curTs = System.currentTimeMillis() / 1000;
        Log.i("mises_log", Log_msg_content + position + "mises news feed offset: " + mOffset);

        MisesUrlPropertyModel urlPropertyModel = new MisesUrlPropertyModel(mCategoryUrl, linkParamsKey);
        String api = urlPropertyModel.getFull_host();
        String fullPath = urlPropertyModel.getFull_path();
        Log.i("mises_log", Log_msg_content + position + "newsfragment convertUrl-api=" + api + ",fullpath =" + fullPath);

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

        Log.i("mises_log", Log_msg_content + position + "newsfragment request params json is =" + new Gson().toJson(additionalParams));
        MisesRestInterface cusApiInterface = MisesNetworkHelper.getInstance().getInterface(api);
        Call<MisesNewsFeedModel> newsList = cusApiInterface.getNewsList(fullPath, additionalParams);
        Log.i("mises_log", Log_msg_content + position + "newsfragment start enqueue.");
        newsList.enqueue(new Callback<MisesNewsFeedModel>() {
            @Override
            public void onResponse(@NonNull Call<MisesNewsFeedModel> call, @NonNull Response<MisesNewsFeedModel> response) {
                Log.i("mises_log", Log_msg_content + position + "newsfragment onResponse.");
                mRecyclerView.post(() -> {
                    hideRefresh();
                    if (response.isSuccessful()) {
                        MisesNewsFeedModel body = response.body();
                        Log.i("mises_log", Log_msg_content + position + "response.body() : " + response.body());
                        if (body != null && body.getAds() != null && !body.getAds().isEmpty()) {
                            List<MisesNewsFeedModel.AdsModel> ads = body.getAds();
                            Log.i("mises_log", Log_msg_content + position + "mises news feed result size: " + ads.size());
                            Log.i("mises_log", Log_msg_content + position + "mises news feed result : " + new Gson().toJson(ads));
                            mOffset += limit;

                            mNewsAdapter.hideFooter(); // 隐藏FooterView

                            if (isRefresh) {
                                Log.i("mises_log", Log_msg_content + position + "mises news feed set newData ");
                                mNewsAdapter.setNewData(ads);
                            } else {
                                Log.i("mises_log", Log_msg_content + position + "mises news feed add data. ");
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
                                if (body.getAds().isEmpty() && firstReqCount < allowReqMaxCount && mNewsAdapter.getData().isEmpty()) {
                                    firstReqCount++;
                                    refreshData();
                                } else {
                                    Toast.makeText(requireContext(), requireContext().getString(R.string.mises_no_result_found), Toast.LENGTH_SHORT).show();
                                }
                                Log.i("mises_log", Log_msg_content + position + "requestCount=" + firstReqCount + ", body.getAds() json:  " + new Gson().toJson(body.getAds()));
                                Log.i("mises_log", Log_msg_content + position + "requestCount=" + firstReqCount + ", mises news feed result empty.");
                            } else {
                                Toast.makeText(requireContext(), requireContext().getString(R.string.mises_no_result_found), Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Log.i("mises_log", Log_msg_content + position + "mises news feed result failed.");
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<MisesNewsFeedModel> call, @NonNull Throwable t) {
                hideRefresh();
                Log.i("mises_log", Log_msg_content + position + "mises news feed failed : " + t.getMessage());
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
                if (!mRefreshLayout.isRefreshing()) {
                    List<MisesNewsFeedModel.AdsModel> data = mNewsAdapter.data;
                    if (!data.isEmpty() && position < data.size()) {
                        MisesNewsFeedModel.AdsModel adsModel = data.get(position);
                        StringBuilder linkHost = new StringBuilder("https://taitunews.com/");
                        String id = adsModel.getId();
                        String language = adsModel.getLanguage();
                        String categoryName = getCategoryName().toLowerCase(Locale.US);
                        linkHost.append("h5/").append(categoryName).append("/");
                        if (TextUtils.equals(adsModel.getType(), "boseai-news")) {
                            linkHost.append("detail2").append("?");
                        } else {
                            linkHost.append("detail").append("?");
                        }
                        linkHost.append("id=").append(id).append("&")
                                .append("language=").append(language).append("&")
                                .append("type=").append(categoryName);

                        Log.i("mises_log", "点击新闻链接：" + linkHost);
                        if (mOnNewsClickListener != null) {
                            mOnNewsClickListener.onClick(linkHost.toString());
                        }
                    }
                }
            });
        }

        mRefreshLayout.setOnRefreshListener(() -> {
            firstReqCount = 0;
            refreshData();
        });

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
                            Log.i("mises_log", Log_msg_content + position + " , guddd onScrolled....categoryUrl : " + mCategoryUrl);
                            getData(mCategoryUrl, false);
                        }
                    }
                }
            }
        });
    }

    private String getCategoryName(){
        if (mCategory != null) {
            return mCategory.getTitle();
        }
        return "";
    }

    private void refreshData() {
        mOffset = 0;
        Log.i("mises_log", Log_msg_content + position + ", refreshData.");
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
