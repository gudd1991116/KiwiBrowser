
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../components/version_info/channel.h

package org.chromium.components.version_info;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    Channel.UNKNOWN, Channel.DEFAULT, Channel.CANARY, Channel.DEV, Channel.BETA, Channel.STABLE
})
@Retention(RetentionPolicy.SOURCE)
public @interface Channel {
  int UNKNOWN = 0;
  /**
   * DEFAULT is an alias for UNKNOWN because the build files use DEFAULT but the code uses UNKNOWN.
   * TODO(paulmiller): Combine DEFAULT & UNKNOWN.
   */
  int DEFAULT = UNKNOWN;
  int CANARY = 1;
  int DEV = 2;
  int BETA = 3;
  int STABLE = 4;
}
