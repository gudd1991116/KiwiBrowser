// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.preferences;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import org.chromium.chrome.R;
import org.chromium.chrome.browser.partnercustomizations.HomepageManager;
import org.chromium.base.ContextUtils;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Fragment that allows the user to configure homepage related preferences.
 */
public class HomepageSelectPreferences extends PreferenceFragment {
    private ListView mListView;
    private HomePageAdapter mHomepageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.options_homepage_title);
        mHomepageAdapter = new HomePageAdapter(getActivity());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListView = (ListView) getView().findViewById(android.R.id.list);
        int marginTop = getActivity().getResources().getDimensionPixelSize(
                R.dimen.search_engine_list_margin_top);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mListView.getLayoutParams();
        layoutParams.setMargins(0, marginTop, 0, 0);
        mListView.setLayoutParams(layoutParams);
        mListView.setAdapter(mHomepageAdapter);
        mListView.setDivider(null);
    }

    @Override
    public void onStart() {
        super.onStart();
        mHomepageAdapter.start();
    }
    @Override
    public void onStop() {
        super.onStop();
        mHomepageAdapter.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (ContextUtils.getAppSharedPreferences().getBoolean("user_night_mode_enabled", false) || ContextUtils.getAppSharedPreferences().getString("active_theme", "").equals("Diamond Black")) {
            view.setBackgroundColor(Color.BLACK);
            ListView list = (ListView) view.findViewById(android.R.id.list);
            if (list != null){
                list.setDivider(new ColorDrawable(Color.GRAY));
                list.setDividerHeight((int) getResources().getDisplayMetrics().density);
            }
        }
    }
}
