
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/android/vr/vr_core_info.h

package org.chromium.chrome.browser.vr_shell;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    VrCoreCompatibility.VR_NOT_SUPPORTED, VrCoreCompatibility.VR_NOT_AVAILABLE,
    VrCoreCompatibility.VR_OUT_OF_DATE, VrCoreCompatibility.VR_READY, VrCoreCompatibility.LAST
})
@Retention(RetentionPolicy.SOURCE)
public @interface VrCoreCompatibility {
  int VR_NOT_SUPPORTED = 0;
  int VR_NOT_AVAILABLE = 1;
  int VR_OUT_OF_DATE = 2;
  int VR_READY = 3;
  int LAST = VR_READY;
}
