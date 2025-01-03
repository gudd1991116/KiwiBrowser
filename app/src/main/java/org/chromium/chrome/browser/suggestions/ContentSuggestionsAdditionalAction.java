
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../components/ntp_snippets/category_info.h

package org.chromium.chrome.browser.suggestions;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    ContentSuggestionsAdditionalAction.NONE, ContentSuggestionsAdditionalAction.FETCH,
    ContentSuggestionsAdditionalAction.VIEW_ALL
})
@Retention(RetentionPolicy.SOURCE)
public @interface ContentSuggestionsAdditionalAction {
  /**
   * No additional action available.
   */
  int NONE = 0;
  /**
   * More suggestions can be fetched using the Fetch methods with this category.
   */
  int FETCH = 1;
  /**
   * Open a new surface dedicated to the content related to this category. The UI has to choose
   * which surface to open.
   */
  int VIEW_ALL = 2;
}
