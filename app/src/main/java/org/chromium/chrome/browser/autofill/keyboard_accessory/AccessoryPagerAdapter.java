// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.autofill.keyboard_accessory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.chromium.chrome.browser.modelutil.SimpleListObservable;

import java.util.HashMap;
import java.util.Map;

/**
 * This {@link PagerAdapter} renders an observable list of {@link KeyboardAccessoryData.Tab}s into a
 * {@link ViewPager}. It instantiates the tab views based on the layout they provide.
 */
class AccessoryPagerAdapter extends PagerAdapter {
    private final SimpleListObservable<KeyboardAccessoryData.Tab> mTabList;
    private final Map<KeyboardAccessoryData.Tab, ViewGroup> mViews;

    /**
     * Creates the PagerAdapter that populates a ViewPager based on a held list of tabs.
     * @param tabList The list that contains the tabs to instantiate.
     */
    public AccessoryPagerAdapter(SimpleListObservable<KeyboardAccessoryData.Tab> tabList) {
        mTabList = tabList;
        mViews = new HashMap<>(mTabList.getItemCount());
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        KeyboardAccessoryData.Tab tab = mTabList.get(position);
        ViewGroup layout = mViews.get(tab);
        if (layout == null) {
            layout = (ViewGroup) LayoutInflater.from(container.getContext())
                             .inflate(tab.getTabLayout(), container, false);
            mViews.put(tab, layout);
            if (container.indexOfChild(layout) == -1) container.addView(layout);
            if (tab.getListener() != null) {
                tab.getListener().onTabCreated(layout);
            }
        }
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @Nullable Object object) {
        if (mViews.get(mTabList.get(position)) == null) return;
        ViewGroup layout = mViews.get(mTabList.get(position));
        if (container.indexOfChild(layout) != -1) container.removeView(layout);
    }

    @Override
    public int getCount() {
        return mTabList.getItemCount();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
