
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/download/download_prompt_status.h

package org.chromium.chrome.browser.download;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    DownloadPromptStatus.SHOW_INITIAL, DownloadPromptStatus.SHOW_PREFERENCE,
    DownloadPromptStatus.DONT_SHOW
})
@Retention(RetentionPolicy.SOURCE)
public @interface DownloadPromptStatus {
  int SHOW_INITIAL = 0;
  int SHOW_PREFERENCE = 1;
  int DONT_SHOW = 2;
}
