
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/ui/android/infobars/infobar_android.h

package org.chromium.chrome.browser.infobar;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    ActionType.NONE, ActionType.OK, ActionType.CANCEL, ActionType.TRANSLATE,
    ActionType.TRANSLATE_SHOW_ORIGINAL
})
@Retention(RetentionPolicy.SOURCE)
public @interface ActionType {
  int NONE = 0;
  /**
   * Confirm infobar
   */
  int OK = 1;
  int CANCEL = 2;
  /**
   * Translate infobar
   */
  int TRANSLATE = 3;
  int TRANSLATE_SHOW_ORIGINAL = 4;
}
