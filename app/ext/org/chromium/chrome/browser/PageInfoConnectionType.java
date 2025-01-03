
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/ui/android/page_info/page_info_controller_android.h

package org.chromium.chrome.browser;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    PageInfoConnectionType.CONNECTION_UNKNOWN, PageInfoConnectionType.CONNECTION_ENCRYPTED,
    PageInfoConnectionType.CONNECTION_MIXED_CONTENT, PageInfoConnectionType.CONNECTION_UNENCRYPTED,
    PageInfoConnectionType.CONNECTION_ENCRYPTED_ERROR,
    PageInfoConnectionType.CONNECTION_INTERNAL_PAGE
})
@Retention(RetentionPolicy.SOURCE)
public @interface PageInfoConnectionType {
  int CONNECTION_UNKNOWN = 0;
  int CONNECTION_ENCRYPTED = 1;
  int CONNECTION_MIXED_CONTENT = 2;
  int CONNECTION_UNENCRYPTED = 3;
  int CONNECTION_ENCRYPTED_ERROR = 4;
  int CONNECTION_INTERNAL_PAGE = 5;
}
