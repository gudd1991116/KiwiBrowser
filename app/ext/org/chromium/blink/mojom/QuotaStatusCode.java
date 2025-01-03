
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/quota/quota_types.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class QuotaStatusCode {


    public static final int OK = (int) (0L);

    public static final int ERROR_NOT_SUPPORTED = (int) (7L);

    public static final int ERROR_INVALID_MODIFICATION = (int) (11L);

    public static final int ERROR_INVALID_ACCESS = (int) (13L);

    public static final int ERROR_ABORT = (int) (17L);

    public static final int UNKNOWN = (int) (-1L);


    private static final boolean IS_EXTENSIBLE = false;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case -1:
            case 0:
            case 7:
            case 11:
            case 13:
            case 17:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private QuotaStatusCode() {}

}