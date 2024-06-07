
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/android/instantapps/instant_apps_settings.cc

package org.chromium.chrome.browser.instantapps;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    AiaBannerReason.SHOULD_SHOW, AiaBannerReason.ALREADY_INSTALLED,
    AiaBannerReason.RECENTLY_BLOCKED, AiaBannerReason.RECENTLY_IGNORED,
    AiaBannerReason.IN_DOMAIN_NAVIGATION, AiaBannerReason.COUNT
})
@Retention(RetentionPolicy.SOURCE)
public @interface AiaBannerReason {
  int SHOULD_SHOW = 0;
  int ALREADY_INSTALLED = 1;
  int RECENTLY_BLOCKED = 2;
  int RECENTLY_IGNORED = 3;
  int IN_DOMAIN_NAVIGATION = 4;
  int COUNT = 5;
}
