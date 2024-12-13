package org.chromium.chrome.browser.ntp.ntp_hp.model;

import com.google.android.material.appbar.AppBarLayout;

/**
 * Created by gudd on 2024/11/14.
 */
public interface MisesOnExpandListener {
    void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset);
}
