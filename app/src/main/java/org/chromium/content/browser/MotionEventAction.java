
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../content/public/browser/android/motion_event_action.h

package org.chromium.content.browser;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    MotionEventAction.INVALID, MotionEventAction.START, MotionEventAction.MOVE,
    MotionEventAction.CANCEL, MotionEventAction.END, MotionEventAction.SCROLL,
    MotionEventAction.HOVER_ENTER, MotionEventAction.HOVER_EXIT, MotionEventAction.HOVER_MOVE
})
@Retention(RetentionPolicy.SOURCE)
public @interface MotionEventAction {
  int INVALID = -1;
  int START = 0;
  int MOVE = 1;
  int CANCEL = 2;
  int END = 3;
  int SCROLL = 4;
  int HOVER_ENTER = 5;
  int HOVER_EXIT = 6;
  int HOVER_MOVE = 7;
}
