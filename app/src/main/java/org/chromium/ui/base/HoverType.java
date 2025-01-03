
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../ui/base/touch/touch_device.h

package org.chromium.ui.base;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    HoverType.NONE, HoverType.FIRST, HoverType.HOVER, HoverType.LAST
})
@Retention(RetentionPolicy.SOURCE)
public @interface HoverType {
  int NONE = 1 << 0;
  int FIRST = NONE;
  int HOVER = 1 << 1;
  int LAST = HOVER;
}
