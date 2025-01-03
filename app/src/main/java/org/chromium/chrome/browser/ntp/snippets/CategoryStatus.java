
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../components/ntp_snippets/category_status.h

package org.chromium.chrome.browser.ntp.snippets;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    CategoryStatus.INITIALIZING, CategoryStatus.AVAILABLE, CategoryStatus.AVAILABLE_LOADING,
    CategoryStatus.NOT_PROVIDED, CategoryStatus.ALL_SUGGESTIONS_EXPLICITLY_DISABLED,
    CategoryStatus.CATEGORY_EXPLICITLY_DISABLED, CategoryStatus.LOADING_ERROR
})
@Retention(RetentionPolicy.SOURCE)
public @interface CategoryStatus {
  /**
   * The provider is still initializing and it is not yet determined whether content suggestions
   * will be available or not.
   */
  int INITIALIZING = 0;
  /**
   * Content suggestions are available (though the list of available suggestions may be empty simply
   * because there are no reasonable suggestions to be made at the moment).
   */
  int AVAILABLE = 1;
  /**
   * Content suggestions are provided but not yet loaded.
   */
  int AVAILABLE_LOADING = 2;
  /**
   * There is no provider that provides suggestions for this category.
   */
  int NOT_PROVIDED = 3;
  /**
   * The entire content suggestions feature has explicitly been disabled as part of the service
   * configuration.
   */
  int ALL_SUGGESTIONS_EXPLICITLY_DISABLED = 4;
  /**
   * Content suggestions from a specific category have been disabled as part of the service
   * configuration. Any suggestions from this category should be removed from the UI immediately.
   */
  int CATEGORY_EXPLICITLY_DISABLED = 5;
  /**
   * Content suggestions are not available because an error occurred when loading or updating them.
   * Any suggestions from this category should be removed from the UI immediately.
   */
  int LOADING_ERROR = 6;
}
