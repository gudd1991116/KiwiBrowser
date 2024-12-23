package org.chromium.chrome.browser.ntp.ntp_hp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.behavior.MisesContentBehavior;
import org.chromium.chrome.browser.ntp.ntp_hp.behavior.MisesHeaderBehavior;
import org.chromium.chrome.browser.ntp.ntp_hp.common.MisesConstants;
import org.chromium.chrome.browser.ntp.ntp_hp.fragment.dapp.MisesDAPPFragment;
import org.chromium.chrome.browser.ntp.ntp_hp.fragment.news.MisesNewsContainerFragment;
import org.chromium.chrome.browser.ntp.ntp_hp.fragment.news.MisesNewsFragment;
import org.chromium.chrome.browser.ntp.ntp_hp.fragment.currency.MisesCryptoFragment;
import org.chromium.chrome.browser.ntp.ntp_hp.fragment.events.MisesEventsFragment;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesBaseModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesCategoryModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnExpandListener;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnNewsClickListener;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnNtpListener;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesMD5Util;
import org.chromium.chrome.browser.ntp.ntp_hp.net.MisesNetworkHelper;
import org.chromium.chrome.browser.ntp.ntp_hp.provider.MisesFavoriteCoinListProvider;
import org.chromium.chrome.browser.ntp.ntp_hp.provider.MisesTabSelectorProvider;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesAppUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesAssetsUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesIdentity;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesSharedPreferenceUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesStatusBarUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.view.MisesSearchBoxView;
import org.chromium.chrome.browser.ntp.ntp_hp.view.toolbar.MisesToolbarView;
import org.chromium.chrome.browser.ntp.ntp_hp.view.MisesWalletEntranceView;
import org.chromium.chrome.browser.ntp.ntp_hp.view.topsite.MisesHorizontalTopsiteView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gudd on 2024/11/7.
 */
public class MisesHomePageView extends LinearLayout implements View.OnClickListener, MisesOnNewsClickListener, MisesFavoriteCoinListProvider, DefaultLifecycleObserver {
    public final static String CRYPTO_DEFAULT = "Currency";
    private final String mKey_NtpCategoryForSp;
    private final int mNtpType;// Native page 的数据源类型，1:web2; 2:web3

//    private TabCreatorManager.TabCreator mTabCreator;

    private MisesHeaderBehavior mHeaderBehavior;

    private View mMainCoordinator;
    private final MediaType mediaType;
    private AppCompatImageView mGradientBgIV;
    private ConstraintLayout mMisesSearchBox;
    private MisesToolbarView mToolbarView;
    private MisesSearchBoxView mSearchBoxView;
    private MisesWalletEntranceView mWalletEntranceView;
    private MisesHorizontalTopsiteView mTopSiteView;
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;

    private MisesTabSelectorProvider mTabSelectorProvider;
    private MisesFavoriteCoinListProvider mFavoriteCoinProvider;
    private MisesOnNtpListener mMisesNtpListener;
    private MisesOnNewsClickListener mNewsClickListener;
    private MisesOnExpandListener mExpandListener;

    private int mHeaderHeight;//总高度
    private int mContentOffset;//新闻偏移量
    private int mToolbarOffset;//首页toolbar偏移量
    private int mSearchBoxHeight;// searchBox的高度
    private int mTopSiteOffset;//名站偏移量

    private final ArrayList<MisesCategoryModel> mNewsCategories = new ArrayList<>();

    private final List<String> mCategories = new ArrayList<>();

    public MisesHomePageView(Context context) {
        this(context, null);
    }

    public MisesHomePageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (context instanceof LifecycleObserver) {
            ((LifecycleOwner) context).getLifecycle().addObserver(this);
        }

        LayoutInflater mInflater = LayoutInflater.from(context);
        mInflater.inflate(R.layout.mises_home_page_view, this, true);

        MisesSharedPreferenceUtil.init(getContext(), MisesSharedPreferenceUtil.SP_NAME);

        mediaType = MediaType.parse("application/json; charset=utf-8");
        mNtpType = 2;// 当前默认先设置为web3
        mKey_NtpCategoryForSp = mNtpType + "ntp_category";

        /*if (context instanceof Activity){
            if (context instanceof TabCreatorManager tabCreatorManager){
                mTabCreator = tabCreatorManager.getTabCreator(false);
            }
        }*/
        if (getContext() instanceof LifecycleOwner) {
            ((LifecycleOwner) getContext()).getLifecycle().addObserver(this);
        }

        initHeight();
        initBehavior();
        initView();
        initData();
        initViewPager();
        initTabLayout();
        initListener();
    }

    private void initHeight() {
        int mStatusBarHeight = 0;//MisesDensityUtil.statusBarHeight(getContext());
//        mTopSiteOffset = MisesDensityUtil.dip2px(getContext(), R.dimen.mises_search_box_height);
        mTopSiteOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.mises_search_box_height);
        mToolbarOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.mises_tool_bar_height);
        mSearchBoxHeight = getContext().getResources().getDimensionPixelOffset(R.dimen.mises_search_box_height);
        mHeaderHeight = getContext().getResources().getDimensionPixelOffset(R.dimen.mises_homepage_header_total_height) + mStatusBarHeight;
        mContentOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.mises_tool_bar_height) + mStatusBarHeight;
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onResume(owner);
        Log.i("mises_log","MisesHomePageView onResume()");
        if(mTabSelectorProvider != null){
            Log.i("mises_log","MisesHomePageView onResume() mTabSelectorProvider != null");
            updateTabCountVisuals(mTabSelectorProvider.getTabCount());
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getContext() instanceof LifecycleOwner) {
            ((LifecycleOwner) getContext()).getLifecycle().removeObserver(this);
        }
    }

    private void initBehavior() {
        mHeaderBehavior = (MisesHeaderBehavior) ((CoordinatorLayout.LayoutParams) findViewById(R.id.headerPart).getLayoutParams()).getBehavior();
        if (mHeaderBehavior != null) {


            mHeaderBehavior.setPagerStateListener(new MisesHeaderBehavior.OnPagerStateListener() {
                @Override
                public void onPagerClosed() {
                    mHeaderBehavior.resetLastScrollY(mHeaderBehavior.getHeaderOffsetRange());
                }

                @Override
                public void onScrollChange(boolean isUp, int dy, int type) {
                    int absDy = Math.abs(dy);
                    // 计算 header 滚动的偏移量
                    int headerOffset = mHeaderHeight - mContentOffset - absDy;
                    float gradientImgAlpha;// 默认0-1范围的值
                    int statusBarAlpha = 0;// 转换成0-255范围的值
                    // 计算背景的透明度
                    if (headerOffset > 0) {
                        gradientImgAlpha = 1.0f * headerOffset / mHeaderHeight;
                        statusBarAlpha = (int) (gradientImgAlpha * 255);
                        mGradientBgIV.setAlpha(gradientImgAlpha);
                    } else {
                        mGradientBgIV.setAlpha(0.0f);
                    }
                    // 计算状态栏透明度
                    if (mMainCoordinator != null) {
                        Log.i("mises_log", "mMainCoordinator is not Null, alphaValue = " + statusBarAlpha);
                        mMainCoordinator.getBackground().setAlpha(statusBarAlpha);
                        if (getContext() != null && getContext() instanceof Activity) {
                            if (statusBarAlpha < 0.5) {
                                MisesStatusBarUtil.setSystemUiStatusBarFontColor((Activity) getContext(), MisesStatusBarUtil.MisesSystemTheme.THEME_LIGHT);
                            } else {
                                MisesStatusBarUtil.setSystemUiStatusBarFontColor((Activity) getContext(), MisesStatusBarUtil.MisesSystemTheme.THEME_DARK);
                            }
                        }
                    }

                    // 计算名站的透明度
                    int websiteOffset = absDy - mToolbarOffset;
                    Log.i("mises_log", "ddddd--websiteOffset=" + websiteOffset);
                    if (websiteOffset > 0 && websiteOffset <= mTopSiteOffset) {
                        Log.i("mises_log", "ddddd--1111=" + (1.0f - 1.0f * websiteOffset / mTopSiteOffset));
                        mTopSiteView.setAlpha(1.0f - 1.0f * websiteOffset / mTopSiteOffset);
                    } else if (websiteOffset > 0) {
                        Log.i("mises_log", "ddddd--2222=0.0");
                        mTopSiteView.setAlpha(0.0f);
                    } else {
                        if (!mHeaderBehavior.isClosed()) {
                            Log.i("mises_log", "ddddd--7777=0.0");
                            mTopSiteView.setAlpha(1f);
                        }
                    }
                    // 计算钱包入口的透明度
                    int walletEntranceOffset = absDy - (mToolbarOffset + mSearchBoxHeight);
                    Log.i("mises_log", "ddddd--walletEntranceOffset=" + walletEntranceOffset);
                    if (walletEntranceOffset > 0 && walletEntranceOffset <= mTopSiteOffset) {
                        Log.i("mises_log", "ddddd--4444=" + (1.0f - 1.0f * walletEntranceOffset / mTopSiteOffset));
                        mWalletEntranceView.setAlpha(1.0f - 1.0f * walletEntranceOffset / mTopSiteOffset);
                    } else if (walletEntranceOffset > 0) {
                        Log.i("mises_log", "ddddd--5555=0.0");
                        mWalletEntranceView.setAlpha(0.0f);
                    } else {
                        if (!mHeaderBehavior.isClosed()) {
                            Log.i("mises_log", "ddddd--66666=0.0");
                            mWalletEntranceView.setAlpha(1f);
                        }
                    }
                }

                @Override
                public void onPagerOpened() {
                    mHeaderBehavior.resetLastScrollY(0);
                }

                @Override
                public void onStopScroll(int dy, int type, boolean fling) {
                    int absY = Math.abs(dy);
                    int offset = Math.abs(mHeaderBehavior.getHeaderOffsetRange());
                    Log.i("mises_log", "onStopScroll");
                    if (absY <= 0 || absY >= offset) {
                        return;
                    }
                    // 计算钱包入口视图的位置
                    int walletEntranceOffset = mToolbarOffset + mSearchBoxHeight;
                    Log.i("mises_log", "MisesHomePageView scroll, absDy = " + absY + ", walletEntranceOffset = " + walletEntranceOffset);
                    if (fling) {
                        if (type == ViewCompat.TYPE_NON_TOUCH) {
                            setNewsExpand(absY > walletEntranceOffset);
                        }
                    } else {
                        setNewsExpand(absY > walletEntranceOffset);
                    }
                }
            });
            // 设置为 header height 的相反数
            mHeaderBehavior.setHeaderOffsetRange(-(mHeaderHeight - mContentOffset));
            // 设置 header close 的时候是否能够通过滑动打开
            mHeaderBehavior.setCouldScrollOpen(true);
        }
        MisesContentBehavior mContentBehavior = (MisesContentBehavior) ((CoordinatorLayout.LayoutParams) findViewById(R.id.contentPart).getLayoutParams()).getBehavior();
        if (mContentBehavior != null) {
            // 设置依赖于哪一个 id，这里要设置为 Header layout id
            mContentBehavior.setDependsLayoutId(R.id.headerPart);
            // 设置 content 部分最终停留的位置
            mContentBehavior.setFinalY(mContentOffset);
        }
    }

    private void initView() {
        mGradientBgIV = findViewById(R.id.gradientBg);
        mMisesSearchBox = findViewById(R.id.mises_search_box_layout);
        mToolbarView = findViewById(R.id.mises_hp_toolbar);
        mSearchBoxView = findViewById(R.id.mises_search_box_view);
        mWalletEntranceView = findViewById(R.id.mises_wallet_entrance_view);
        mTopSiteView = findViewById(R.id.topSiteView);
        mMisesSearchBox.setOnClickListener(this);
        mSearchBoxView.setOnClickListener(this);
        mWalletEntranceView.setOnClickListener(this);
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);

        if (getContext() != null && getContext() instanceof Activity) {
            Activity activity = (Activity) getContext();
            mMainCoordinator = activity.findViewById(R.id.coordinator);
            Log.i("mises_log", "mMainCoordinator is null ?= " + (mMainCoordinator == null));
        }
    }

    private void initViewPager() {
        mViewPager.setOffscreenPageLimit(3);
        if (getContext() instanceof FragmentActivity) {
            mViewPager.setAdapter(new FragmentStateAdapter((FragmentActivity) getContext()) {
                @NonNull
                @Override
                public Fragment createFragment(int position) {
                    Fragment fragment;
                    String cat = mCategories.get(position);
                    if (getResources().getString(R.string.mises_category_market).equals(cat)) {
                        fragment = MisesCryptoFragment.newInstance();
                        ((MisesCryptoFragment) fragment).setOnItemClickListener(MisesHomePageView.this);
                        ((MisesCryptoFragment) fragment).setMisesFavoriteCoinListProvider(MisesHomePageView.this);
                    } else if (getResources().getString(R.string.mises_category_news).equals(cat)) {
                        fragment = MisesNewsContainerFragment.newInstance(mNewsCategories);
                        ((MisesNewsContainerFragment) fragment).setOnItemClickListener(MisesHomePageView.this);
                    } else if (getResources().getString(R.string.mises_category_dapp).equals(cat)) {
                        fragment = MisesDAPPFragment.newInstance();
//                        fragment = MisesNewsFragment.newInstance(mNewsCategories);
//                        ((MisesNewsFragment)fragment).setOnItemClickListener(MisesHomePageView.this);
                    } else /*if (getResources().getString(R.string.mises_category_events).equals(cat))*/ {
                        MisesCategoryModel categoryOfCrypto = new MisesCategoryModel(0, "Crypto", "https://innews.infohubnews.app/ad/mixnews?cty=CN&lang=zh&session=init&platform=web&c=crypto1&cc=test1&offset=0&limit=10&ts=17236873901&only_ai_news=true");
                        for (MisesCategoryModel categoryModel : mNewsCategories) {
                            if (TextUtils.equals(categoryModel.getTitle(), "Crypto")) {
                                categoryOfCrypto = categoryModel;
                            }
                        }
                        fragment = MisesEventsFragment.newInstance(categoryOfCrypto);
                        ((MisesEventsFragment) fragment).setOnItemClickListener(MisesHomePageView.this);
                    }
                    return fragment;

                    /*if (CRYPTO_DEFAULT.equals(mNewsCategories.get(position).getTitle())) {
                        fragment = MisesCryptoFragment.newInstance();
                        ((MisesCryptoFragment) fragment).setOnItemClickListener(MisesHomePageView.this);
                    } else {
                        fragment = MisesNewsFeedFragment.newInstance(mNewsCategories.get(position));
                        ((MisesNewsFeedFragment) fragment).setOnItemClickListener(MisesHomePageView.this);
                    }
                    return fragment;*/
                }

                @Override
                public int getItemCount() {
//                    return mNewsCategories.size();
                    return mCategories.size();
                }
            });
        }
    }

    private void initTabLayout() {
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager, true, (tab, position) -> {
            View view = LayoutInflater.from(getContext())
                    .inflate(R.layout.mises_tab_view, MisesHomePageView.this, false);
            AppCompatTextView textView = view.findViewById(R.id.tab_text);
//                textView.setText(mNewsCategories.get(position).getTitle());
            textView.setText(mCategories.get(position));
            tab.setCustomView(textView);
            if (position == 0) {
                setTabItemTexParams(textView, R.color.mises_tab_selected);
            } else {
                setTabItemTexParams(textView, R.color.mises_tab_unselected);
            }
        });
        tabLayoutMediator.attach();
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView != null) {
                    AppCompatTextView textView = customView.findViewById(R.id.tab_text);
                    setTabItemTexParams(textView, R.color.mises_tab_selected);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView != null) {
                    AppCompatTextView textView = customView.findViewById(R.id.tab_text);
                    setTabItemTexParams(textView, R.color.mises_tab_unselected);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setTabItemTexParams(AppCompatTextView textView, int textColor) {
//        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), textColor));
    }

    /**
     * 更新tab选择器数量
     */
    private void updateTabCountVisuals(int tabCount){
        if (mToolbarView != null){
            mToolbarView.updateTabCountVisuals(tabCount);
        }
    }

    private void initListener() {
        mTopSiteView.setOnWebsiteClickListener(misesTopSiteModel -> {
            if (mNewsClickListener != null) {
                mNewsClickListener.onClick(misesTopSiteModel.getUrl());
            }
        });
    }

    public static float coerceIn(float value, float min, float max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    private void initData() {
        // 从本地sp内获取频道列表，初始化对象
        getCategories();
        // 从服务器获取频道列表，并更新本地内存中数据
        String channel = MisesIdentity.getCid();
        String time = String.valueOf(System.currentTimeMillis());
        String header = MisesMD5Util.to32BitMD5(MisesAppUtil.getAppVersionName(getContext()) + MisesIdentity.getCid() + "1" + MisesNetworkHelper.getInstance().API2_KEY + time);
        Log.i("mises_log", "开始获取频道请求，header : " + header);

        RequestBody requestBody = RequestBody.create(generateCategoriesReqParams(channel, time), mediaType);
        Call<MisesBaseModel<MisesCategoryModel>> categories = MisesNetworkHelper.getInstance().getBaseApi2Interface().getCategories(header, requestBody);
        categories.enqueue(new Callback<MisesBaseModel<MisesCategoryModel>>() {
            @Override
            public void onResponse(@NonNull Call<MisesBaseModel<MisesCategoryModel>> call, @NonNull Response<MisesBaseModel<MisesCategoryModel>> response) {
                if (response.isSuccessful()) {
                    Log.i("mises_log", "频道数据接口请求成功");
                    MisesBaseModel<MisesCategoryModel> body = response.body();
                    if (body != null) {
                        Log.i("mises_log", "频道数据body不为null.");
                        List<MisesCategoryModel> data = body.getData();
                        saveCategoriesFromServer(data);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<MisesBaseModel<MisesCategoryModel>> call, @NonNull Throwable t) {
                Log.i("mises_log", "频道数据接口请求失败 : " + t.getMessage());
            }
        });
    }

    private void getCategories() {
        // 获取默认频道
        String[] stringArray = getContext().getResources().getStringArray(R.array.home_category);
        List<String> categoryNames = Arrays.asList(stringArray);
        mCategories.clear();
        mCategories.addAll(categoryNames);

        boolean fromSp = true;
        String categoriesFromSp = getCategoriesFromSp();
        Log.i("mises_log", "从SP获取上次保存的频道列表。");
        if (TextUtils.isEmpty(categoriesFromSp)) {
            Log.i("mises_log", "SP中没有频道列表。开始获取本地默认频道JSON列表。");
            fromSp = false;
            categoriesFromSp = MisesAssetsUtil.loadJSONFromAsset(getContext(), "category/mises_categories.json");
        }
        Log.i("mises_log", "mises categories ,getfrom sp: " + fromSp + "get data : " + categoriesFromSp);
        if (!TextUtils.isEmpty(categoriesFromSp)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<MisesCategoryModel>>() {
            }.getType();
            List<MisesCategoryModel> list = gson.fromJson(categoriesFromSp, type);
            if (list != null) {
                String[] categories = new String[list.size()];
                list.sort((o1, o2) -> {
                    int o1id = o1.getSort();
                    int o2id = o2.getSort();
                    return o1id - o2id;
                });
                /*for (int i = 0; i < list.size(); i++) {
                    MisesCategoryModel model = list.get(i);
                    categories[i] = model.getTitle();
                }
                mNewsCategories = categories;*/
                mNewsCategories.clear();
                mNewsCategories.addAll(list);
            }
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getContext() != null && getContext() instanceof Activity) {
            Activity activity = (Activity) getContext();
            mMainCoordinator = activity.findViewById(R.id.coordinator);
        }
    }

    public void setNewsExpand(boolean expend) {
        if (expend) {
            mHeaderBehavior.closePager();
            Log.i("mises_log", "set news expand : close");
            MisesStatusBarUtil.setSystemUiStatusBarFontColor((Activity) getContext(), MisesStatusBarUtil.MisesSystemTheme.THEME_LIGHT);
            mGradientBgIV.setAlpha(0f);
            mTopSiteView.setAlpha(0f);
            mWalletEntranceView.setAlpha(0f);
            if (mMainCoordinator != null) {
                mMainCoordinator.getBackground().setAlpha(0);
            }
        } else {
            mHeaderBehavior.openPager();
            Log.i("mises_log", "set news expand : openPager");
            MisesStatusBarUtil.setSystemUiStatusBarFontColor((Activity) getContext(), MisesStatusBarUtil.MisesSystemTheme.THEME_DARK);
            mGradientBgIV.setAlpha(1f);
            mTopSiteView.setAlpha(1f);
            mWalletEntranceView.setAlpha(1f);
            if (mMainCoordinator != null) {
                mMainCoordinator.getBackground().setAlpha(255);
            }
        }
    }

    private String generateCategoriesReqParams(String channel, String time) {
        HashMap<String, String> params = new HashMap<>();
        params.put("channel", channel);
        params.put("platform", "1");
        params.put("versionName", MisesAppUtil.getAppVersionName(getContext()));
        params.put("type", String.valueOf(mNtpType));
        params.put("time", time);
        return new Gson().toJson(params);
    }

    private void saveCategoriesFromServer(List<MisesCategoryModel> list) {
        if (list != null && !list.isEmpty()) {
            String json = new Gson().toJson(list);
            Log.i("mises_log", "保存服务器获取的新闻频道配置 : " + json);
            MisesSharedPreferenceUtil.getInstance(getContext()).putString(mKey_NtpCategoryForSp, json);
        }
    }

    private String getCategoriesFromSp() {
        return MisesSharedPreferenceUtil.getInstance(getContext()).getString(mKey_NtpCategoryForSp, "");
    }

    public void setOnMisesNtpListener(MisesOnNtpListener listener) {
        mMisesNtpListener = listener;
        if (mToolbarView != null) {
            mToolbarView.setOnMisesNtpListener(listener);
        }
    }

    public void setOnNewsClickListener(MisesOnNewsClickListener listener) {
        mNewsClickListener = listener;
        if (mToolbarView != null) {
            mToolbarView.setOnNewsClickListener(listener);
        }
    }

    public void setOnExpandListener(MisesOnExpandListener listener) {
        mExpandListener = listener;
    }

    public void setOnFavoriteCoinListProvider(MisesFavoriteCoinListProvider provider) {
        mFavoriteCoinProvider = provider;
    }

    public void setOnTabSelectorProvider(MisesTabSelectorProvider provider){
        mTabSelectorProvider = provider;
        if (mTabSelectorProvider != null){
            updateTabCountVisuals(mTabSelectorProvider.getTabCount());
        }
    }

    @Override
    public void onClick(View v) {
        if (v == mMisesSearchBox || v == mSearchBoxView) {
            if (mMisesNtpListener != null) {
                mMisesNtpListener.focusSearchBox();
            }
        } else if (v == mWalletEntranceView) {
            if (mMisesNtpListener != null) {
                mMisesNtpListener.launchWallet();
            }
        }
    }

    @Override
    public void onClick(String link) {
        if (mNewsClickListener != null) {
            mNewsClickListener.onClick(link);
        }
    }

    @Override
    public void onClickCrypto(String coin_name) {
        if (mNewsClickListener != null) {
            mNewsClickListener.onClickCrypto(coin_name);
        }
    }

    @Override
    public List<String> getFavoriteCoinUidList() {
        if (mFavoriteCoinProvider != null) {
            return mFavoriteCoinProvider.getFavoriteCoinUidList();
        }
        return Collections.emptyList();
        /*String[] uids = new String[]{"algorand", "aave",
                "avalanche-2",
                "bitcoin",
                "binancecoin",
                "bitcoin-cash",
                "cardano"};
        return Arrays.asList(uids);*/
    }
}
