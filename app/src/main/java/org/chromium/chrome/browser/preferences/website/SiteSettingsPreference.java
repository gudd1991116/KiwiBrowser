// Copyright 2016 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.preferences.website;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.chrome.R;

import android.view.View;
import org.chromium.base.ContextUtils;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;
import android.widget.ListView;

/**
 * A custom preference for drawing Site Settings entries.
 */
public class SiteSettingsPreference extends Preference {
    /**
     * Constructor for inflating from XML.
     */
    public SiteSettingsPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);

        int padding = getContext().getResources().getDimensionPixelSize(R.dimen.pref_icon_padding);
        ImageView icon = (ImageView) view.findViewById(android.R.id.icon);
        ApiCompatibilityUtils.setPaddingRelative(
                icon, padding, icon.getPaddingTop(), 0, icon.getPaddingBottom());
        if (ContextUtils.getAppSharedPreferences().getBoolean("user_night_mode_enabled", false) || ContextUtils.getAppSharedPreferences().getString("active_theme", "").equals("Diamond Black")) {
            if (((TextView) view.findViewById(android.R.id.title)) != null)
              ((TextView) view.findViewById(android.R.id.title)).setTextColor(Color.WHITE);
            if (((TextView) view.findViewById(android.R.id.summary)) != null)
              ((TextView) view.findViewById(android.R.id.summary)).setTextColor(Color.GRAY);
        }
    }
}
