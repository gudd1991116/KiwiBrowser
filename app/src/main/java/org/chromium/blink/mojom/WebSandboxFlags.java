
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/feature_policy/feature_policy.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;

public final class WebSandboxFlags {


    public static final int NONE = (int) (0L);

    public static final int NAVIGATION = (int) (1L);

    public static final int PLUGINS = (int) (2L);

    public static final int ORIGIN = (int) (4L);

    public static final int FORMS = (int) (8L);

    public static final int SCRIPTS = (int) (16L);

    public static final int TOP_NAVIGATION = (int) (32L);

    public static final int POPUPS = (int) (64L);

    public static final int AUTOMATIC_FEATURES = (int) (128L);

    public static final int POINTER_LOCK = (int) (256L);

    public static final int DOCUMENT_DOMAIN = (int) (512L);

    public static final int ORIENTATION_LOCK = (int) (1024L);

    public static final int PROPAGATES_TO_AUXILIARY_BROWSING_CONTEXTS = (int) (2048L);

    public static final int MODALS = (int) (4096L);

    public static final int PRESENTATION_CONTROLLER = (int) (8192L);

    public static final int TOP_NAVIGATION_BY_USER_ACTIVATION = (int) (16384L);

    public static final int DOWNLOADS = (int) (32768L);


    private static final boolean IS_EXTENSIBLE = true;

    public static boolean isKnownValue(int value) {
        switch (value) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 8:
            case 16:
            case 32:
            case 64:
            case 128:
            case 256:
            case 512:
            case 1024:
            case 2048:
            case 4096:
            case 8192:
            case 16384:
            case 32768:
                return true;
        }
        return false;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value))
            return;

        throw new DeserializationException("Invalid enum value.");
    }

    private WebSandboxFlags() {}

}