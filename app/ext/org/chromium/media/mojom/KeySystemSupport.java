
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/key_system_support.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface KeySystemSupport extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends KeySystemSupport, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<KeySystemSupport, KeySystemSupport.Proxy> MANAGER = KeySystemSupport_Internal.MANAGER;


    void isKeySystemSupported(
String keySystem, 
IsKeySystemSupportedResponse callback);

    interface IsKeySystemSupportedResponse extends org.chromium.mojo.bindings.Callbacks.Callback4<Boolean, int[], Boolean, int[]> { }


}
