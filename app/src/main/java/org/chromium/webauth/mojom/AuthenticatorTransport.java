
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/platform/modules/webauth/authenticator.mojom
//

package org.chromium.webauth.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class AuthenticatorTransport {


    public static final int USB = 0;

    public static final int NFC = USB + 1;

    public static final int BLE = NFC + 1;


    private static final boolean IS_EXTENSIBLE = false;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private AuthenticatorTransport() {}

}