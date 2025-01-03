
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../third_party/blink/public/platform/web_focus_type.h

package org.chromium.blink_public.web;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    WebFocusType.NONE, WebFocusType.FORWARD, WebFocusType.BACKWARD, WebFocusType.UP,
    WebFocusType.DOWN, WebFocusType.LEFT, WebFocusType.RIGHT, WebFocusType.MOUSE, WebFocusType.PAGE,
    WebFocusType.LAST
})
@Retention(RetentionPolicy.SOURCE)
public @interface WebFocusType {
  /**
   * Element::focus(), etc.
   */
  int NONE = 0;
  /**
   * Sequential navigation with TAB, or Shift + TAB.
   */
  int FORWARD = 1;
  int BACKWARD = 2;
  /**
   * Spatial navigation.
   */
  int UP = 3;
  int DOWN = 4;
  int LEFT = 5;
  int RIGHT = 6;
  /**
   * Mouse press
   */
  int MOUSE = 7;
  /**
   * Re-focus by a page focus
   */
  int PAGE = 8;
  int LAST = 8;
}
