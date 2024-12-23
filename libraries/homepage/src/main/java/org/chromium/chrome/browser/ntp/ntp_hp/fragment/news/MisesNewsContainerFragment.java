package org.chromium.chrome.browser.ntp.ntp_hp.fragment.news;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;

import org.chromium.chrome.browser.R;
import org.chromium.chrome.browser.ntp.ntp_hp.MisesHomePageView;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesCategoryModel;
import org.chromium.chrome.browser.ntp.ntp_hp.model.MisesOnNewsClickListener;
import org.chromium.chrome.browser.ntp.ntp_hp.utils.MisesDensityUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gudd on 2024/12/23.
 */
public class MisesNewsContainerFragment extends Fragment {

    public static MisesNewsContainerFragment newInstance(ArrayList<MisesCategoryModel> categoryModels) {
        MisesNewsContainerFragment fragment = new MisesNewsContainerFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("categories", categoryModels);
        fragment.setArguments(bundle);
        return fragment;
    }

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;

    private final ArrayList<MisesCategoryModel> mCategoriesList = new ArrayList<>();

    private MisesOnNewsClickListener mOnNewsClickListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = LayoutInflater.from(requireContext()).inflate(R.layout.mises_fragment_news, container);
        initView(root);
        return root;
    }

    public void initView(View view) {
        mTabLayout = view.findViewById(R.id.category_tab);
        mViewPager = view.findViewById(R.id.news_vp);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initViewPager();
        initTabLayout();
    }

    private void initData() {
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
                                !misesCategoryModel.getTitle().equals(MisesHomePageView.CRYPTO_DEFAULT) /*&& !misesCategoryModel.getTitle().toLowerCase().equals(targetName)*/
                        ).sorted((model1, model2) -> model1.getTitle().toLowerCase().equals(targetName) ? -1 : model2.getTitle().toLowerCase().equals(targetName) ? 1 : 0)
                        .collect(Collectors.toList());
                Log.i("mises_log", "newsfragment filter and sorted data : " + new Gson().toJson(collect));
                mCategoriesList.clear();
                mCategoriesList.addAll(collect);
            }
        }
    }

    private void initViewPager() {
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new FragmentStateAdapter(requireActivity()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                MisesCategoryModel misesCategoryModel = mCategoriesList.get(position);
                Log.i("mises_log", "newsfragment misesCategoryModel = " + new Gson().toJson(misesCategoryModel));
                MisesNewsV2Fragment fragment = MisesNewsV2Fragment.newInstance(misesCategoryModel, position);
                fragment.setOnItemClickListener(mOnNewsClickListener);
                return fragment;
            }

            @Override
            public int getItemCount() {
                Log.i("mises_log", "newsfragment misesCategoryModel size = " + mCategoriesList.size());
                return mCategoriesList.size();
            }
        });
    }

    private void initTabLayout() {
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager, true, (tab, position) -> {
            View view = LayoutInflater.from(getContext())
                    .inflate(R.layout.mises_news_category_item, mTabLayout, false);
            AppCompatTextView textView = view.findViewById(R.id.category);
            String title = mCategoriesList.get(position).getTitle();
            if (TextUtils.equals(title.toLowerCase(), "Headline".toLowerCase())) {
                title = "All";
            }
            textView.setText(title);
            tab.setCustomView(view);
            if (position == 0) {
                setTabItemTexParams(textView, R.color.mises_tab_selected);
            } else {
                setTabItemTexParams(textView, R.color.mises_tab_unselected);
            }
        });
        tabLayoutMediator.attach();

        // 设置tabLayout的custom中的每个item的padding
        int dp10 = MisesDensityUtil.dip2px(requireContext(), 10);
        int dp5 = MisesDensityUtil.dip2px(requireContext(), 5);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            TabLayout.Tab tabAt = mTabLayout.getTabAt(i);
            if (tabAt != null) {
                View customView = tabAt.getCustomView();
                if (customView != null) {
                    if (i == 0) {
                        customView.setPadding(dp10, 0, dp5, 0);
                    } else if (i == mTabLayout.getTabCount() - 1) {
                        customView.setPadding(dp5, 0, dp10, 0);
                    } else {
                        customView.setPadding(dp5, 0, dp5, 0);
                    }
                }
            }
        }

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView != null) {
                    AppCompatTextView textView = customView.findViewById(R.id.category);
                    setTabItemTexParams(textView, R.color.mises_tab_selected);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView != null) {
                    AppCompatTextView textView = customView.findViewById(R.id.category);
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

    public void setOnItemClickListener(MisesOnNewsClickListener listener) {
        mOnNewsClickListener = listener;
    }

}
