
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../ui/android/resources/resource_manager.h

package org.chromium.ui.resources;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    AndroidResourceType.STATIC, AndroidResourceType.DYNAMIC, AndroidResourceType.DYNAMIC_BITMAP,
    AndroidResourceType.SYSTEM, AndroidResourceType.COUNT, AndroidResourceType.FIRST,
    AndroidResourceType.LAST
})
@Retention(RetentionPolicy.SOURCE)
public @interface AndroidResourceType {
  int STATIC = 0;
  int DYNAMIC = 1;
  int DYNAMIC_BITMAP = 2;
  int SYSTEM = 3;
  int COUNT = 4;
  int FIRST = 0;
  int LAST = 3;
}
