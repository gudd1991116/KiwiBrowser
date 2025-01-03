
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/android/vr/vr_shell_delegate.h

package org.chromium.chrome.browser.vr_shell;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    VrSupportLevel.VR_NOT_AVAILABLE, VrSupportLevel.VR_CARDBOARD, VrSupportLevel.VR_DAYDREAM
})
@Retention(RetentionPolicy.SOURCE)
public @interface VrSupportLevel {
  int VR_NOT_AVAILABLE = 0;
  int VR_CARDBOARD = 1;
  int VR_DAYDREAM = 2;
}
