
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/audio_output_stream.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface AudioOutputStreamProviderClient extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends AudioOutputStreamProviderClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<AudioOutputStreamProviderClient, AudioOutputStreamProviderClient.Proxy> MANAGER = AudioOutputStreamProviderClient_Internal.MANAGER;


    void created(
AudioOutputStream stream, AudioDataPipe dataPipe);


}
