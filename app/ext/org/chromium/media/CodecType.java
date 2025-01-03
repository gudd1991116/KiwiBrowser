
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../media/base/android/media_codec_bridge.h

package org.chromium.media;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    CodecType.ANY, CodecType.SECURE, CodecType.SOFTWARE
})
@Retention(RetentionPolicy.SOURCE)
public @interface CodecType {
  int ANY = 0;
  int SECURE = 1;
  int SOFTWARE = 2;
}
