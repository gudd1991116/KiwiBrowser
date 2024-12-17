package org.chromium.chrome.browser.ntp.ntp_hp;

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
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.fragment.MisesDAPPFragment;
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
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesAppUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesAssetsUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesDensityUtil;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesIdentity;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesSharedPreferenceUtil;
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
    private static final String TAG = "MisesHomePageView";
    public final static String CRYPTO_DEFAULT = "Currency";
    private final String mKey_NtpCategoryForSp;
    private final int mNtpType;// Native page 的数据源类型，1:web2; 2:web3

//    private TabCreatorManager.TabCreator mTabCreator;

    private final MediaType mediaType;
    private Toolbar mToolbarPlace;
    private AppCompatImageView mGradientBgIV;
    private ConstraintLayout mMisesSearchBox, mSearchBox;
    private ConstraintLayout mWalletBtnRoot;
    private AppCompatTextView mMisesSearchBoxText;
    private MisesHorizontalTopsiteView mTopSiteView;
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private AppBarLayout mAppBarLayout;

    private MisesFavoriteCoinListProvider mFavoriteCoinProvider;
    //    private OnMisesNtpListener mMisesNtpListener;
    private MisesOnNtpListener mMisesNtpListener;
    private MisesOnNewsClickListener mNewsClickListener;
    private MisesOnExpandListener mExpandListener;

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

        initView();
        initData();
        initViewPager();
        initTabLayout();
        initListener();
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        /*if (mFavoriteCoinProvider != null) {
            List<String> favoriteCoinUidList = mFavoriteCoinProvider.getFavoriteCoinUidList();
            if (favoriteCoinUidList != null && favoriteCoinUidList.isEmpty()){

            }
        }*/
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getContext() instanceof LifecycleOwner) {
            ((LifecycleOwner) getContext()).getLifecycle().removeObserver(this);
        }
    }

    private void initView() {
        mToolbarPlace = findViewById(R.id.toolBarPlace);
        mGradientBgIV = findViewById(R.id.gradientBg);
        mMisesSearchBox = findViewById(R.id.mises_search_box_layout);
        mSearchBox = findViewById(R.id.mises_search_box_place);
        mWalletBtnRoot = findViewById(R.id.walletBtnRoot);
        mMisesSearchBoxText = findViewById(R.id.mises_search_box_text);
        mTopSiteView = findViewById(R.id.topSiteView);
        mMisesSearchBox.setOnClickListener(this);
        mSearchBox.setOnClickListener(this);
        mWalletBtnRoot.setOnClickListener(this);
        mMisesSearchBoxText.setOnClickListener(this);
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);
        mAppBarLayout = findViewById(R.id.appbarLayout);
    }

    private void initViewPager() {
        mViewPager.setOffscreenPageLimit(3);
        if (getContext() instanceof FragmentActivity) {
            mViewPager.setAdapter(new FragmentStateAdapter((FragmentActivity) getContext()) {
                @NonNull
                @Override
                public Fragment createFragment(int position) {
                    Fragment fragment = null;
                    String cat = mCategories.get(position);
                    if (getResources().getString(R.string.mises_category_market).equals(cat)) {
                        fragment = MisesCryptoFragment.newInstance();
                        ((MisesCryptoFragment) fragment).setOnItemClickListener(MisesHomePageView.this);
                        ((MisesCryptoFragment) fragment).setMisesFavoriteCoinListProvider(MisesHomePageView.this);
                    } else if (getResources().getString(R.string.mises_category_news).equals(cat)) {
                        fragment = MisesNewsFragment.newInstance(mNewsCategories);
                        ((MisesNewsFragment) fragment).setOnItemClickListener(MisesHomePageView.this);
                    } else if (getResources().getString(R.string.mises_category_dapp).equals(cat)) {
                        fragment = MisesDAPPFragment.newInstance();
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
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
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

    private void initListener() {
        mTopSiteView.setOnWebsiteClickListener(misesTopSiteModel -> {
            if (mNewsClickListener != null) {
                mNewsClickListener.onClick(misesTopSiteModel.getUrl());
            }
        });
        mAppBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            int fiftySix = MisesDensityUtil.dip2px(getContext(), 56);// 固定占位高度
            int fortySix = MisesDensityUtil.dip2px(getContext(), 46);// 搜索框高度

            // 根据appbarLayout滑动的距离设置图片背景是否透明
            // 最大可滑动距离
            int maxScrollHeight = mAppBarLayout.getTotalScrollRange() - fiftySix;
            Log.i("mises_log", "maxScrollHeight=" + maxScrollHeight);
            float gradientImgAlpha = 1 - (float) Math.abs(verticalOffset) / (maxScrollHeight + fiftySix);
            gradientImgAlpha = Math.max(0, Math.min(gradientImgAlpha, 1));
            mGradientBgIV.setAlpha(gradientImgAlpha);

            int startScrollThreshold = fiftySix + fortySix;
            int offScreenViewHeight = mMisesSearchBox.getHeight();// 留下的搜索框高度

            // 滑动偏移值为正数
            int absoluteOffset = Math.abs(verticalOffset);
            // 如果滑动到指定位置则开始将mMisesSearchBox从顶部往下移动
            if (absoluteOffset >= startScrollThreshold) {
                mMisesSearchBox.setVisibility(VISIBLE);
                // 剩余滑动距离
                int remainingScroll = maxScrollHeight - absoluteOffset ;
                // 剩余比例
                float remainingScrollRatio = coerceIn((float) remainingScroll / (maxScrollHeight - startScrollThreshold ), 0f, 1f);
                // 动态调整屏幕外 View 的滑动位置
                float translationY = offScreenViewHeight * (1 - remainingScrollRatio);
                float ty = -offScreenViewHeight + translationY;
                mMisesSearchBox.setTranslationY(ty);

                float gradientToolbarAlpha = 1 - remainingScrollRatio;
                Log.i("mises_log", "remainingScroll="+remainingScroll+", translationY="+translationY+", ty="+ty+", gradientToolbarAlpha = "+ gradientToolbarAlpha+", maxScrollHeight="+maxScrollHeight+", absoluteOffset="+absoluteOffset+", fifitySix="+fiftySix+", fourtySix="+fortySix);
//                mToolbarPlace.setAlpha(gradientToolbarAlpha);
                mWalletBtnRoot.setAlpha(remainingScrollRatio);
            } else {
                Log.i("mises_log","translationY="+-offScreenViewHeight);
                mMisesSearchBox.setTranslationY(-offScreenViewHeight);
                mMisesSearchBox.setVisibility(GONE);
//                mToolbarPlace.setAlpha(0);
                mWalletBtnRoot.setAlpha(1);
            }



            // 设置滑动距离回调
            /*if (mExpandListener != null) {
                mExpandListener.onOffsetChanged(appBarLayout, verticalOffset);
            }*/
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
        if (getContext() != null){
            int screenWidth = MisesDensityUtil.screenWidth(getContext());
//            CoordinatorLayout.LayoutParams cl =
//            mGradientBgIV.
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
    }

    public void setOnNewsClickListener(MisesOnNewsClickListener listener) {
        mNewsClickListener = listener;
    }

    public void setOnExpandListener(MisesOnExpandListener listener) {
        mExpandListener = listener;
    }

    public void setOnFavoriteCoinListProvider(MisesFavoriteCoinListProvider provider) {
        mFavoriteCoinProvider = provider;
    }

    @Override
    public void onClick(View v) {
        if (v == mMisesSearchBox || v == mMisesSearchBoxText || v == mSearchBox) {
            if (mMisesNtpListener != null) {
                mMisesNtpListener.focusSearchBox();
            }
        } else if (v == mWalletBtnRoot) {
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
