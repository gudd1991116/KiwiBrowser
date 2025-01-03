
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/video_encode_accelerator.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface VideoEncodeAcceleratorClient extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends VideoEncodeAcceleratorClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<VideoEncodeAcceleratorClient, VideoEncodeAcceleratorClient.Proxy> MANAGER = VideoEncodeAcceleratorClient_Internal.MANAGER;


    void requireBitstreamBuffers(
int inputCount, org.chromium.gfx.mojom.Size inputCodedSize, int outputBufferSize);



    void bitstreamBufferReady(
int bitstreamBufferId, int payloadSize, boolean keyFrame, org.chromium.mojo_base.mojom.TimeDelta timestamp);



    void notifyError(
int error);


}
