
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/android/webapk/webapk_types.h

package org.chromium.chrome.browser.webapps;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    WebApkUpdateReason.NONE, WebApkUpdateReason.OLD_SHELL_APK,
    WebApkUpdateReason.PRIMARY_ICON_HASH_DIFFERS, WebApkUpdateReason.BADGE_ICON_HASH_DIFFERS,
    WebApkUpdateReason.SCOPE_DIFFERS, WebApkUpdateReason.START_URL_DIFFERS,
    WebApkUpdateReason.SHORT_NAME_DIFFERS, WebApkUpdateReason.NAME_DIFFERS,
    WebApkUpdateReason.BACKGROUND_COLOR_DIFFERS, WebApkUpdateReason.THEME_COLOR_DIFFERS,
    WebApkUpdateReason.ORIENTATION_DIFFERS, WebApkUpdateReason.DISPLAY_MODE_DIFFERS
})
@Retention(RetentionPolicy.SOURCE)
public @interface WebApkUpdateReason {
  int NONE = 0;
  int OLD_SHELL_APK = 1;
  int PRIMARY_ICON_HASH_DIFFERS = 2;
  int BADGE_ICON_HASH_DIFFERS = 3;
  int SCOPE_DIFFERS = 4;
  int START_URL_DIFFERS = 5;
  int SHORT_NAME_DIFFERS = 6;
  int NAME_DIFFERS = 7;
  int BACKGROUND_COLOR_DIFFERS = 8;
  int THEME_COLOR_DIFFERS = 9;
  int ORIENTATION_DIFFERS = 10;
  int DISPLAY_MODE_DIFFERS = 11;
}
