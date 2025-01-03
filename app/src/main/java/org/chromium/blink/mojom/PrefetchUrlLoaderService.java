
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/loader/prefetch_url_loader_service.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface PrefetchUrlLoaderService extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends PrefetchUrlLoaderService, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<PrefetchUrlLoaderService, PrefetchUrlLoaderService.Proxy> MANAGER = PrefetchUrlLoaderService_Internal.MANAGER;


    void getFactory(
org.chromium.mojo.bindings.InterfaceRequest<org.chromium.network.mojom.UrlLoaderFactory> factory);


}
