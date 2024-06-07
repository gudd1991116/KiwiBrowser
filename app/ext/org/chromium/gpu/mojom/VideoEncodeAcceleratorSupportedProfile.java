
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     gpu/ipc/common/gpu_info.mojom
//

package org.chromium.gpu.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class VideoEncodeAcceleratorSupportedProfile extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 32;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int profile;
    public org.chromium.gfx.mojom.Size maxResolution;
    public int maxFramerateNumerator;
    public int maxFramerateDenominator;

    private VideoEncodeAcceleratorSupportedProfile(int version) {
        super(STRUCT_SIZE, version);
    }

    public VideoEncodeAcceleratorSupportedProfile() {
        this(0);
    }

    public static VideoEncodeAcceleratorSupportedProfile deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static VideoEncodeAcceleratorSupportedProfile deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static VideoEncodeAcceleratorSupportedProfile decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        VideoEncodeAcceleratorSupportedProfile result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new VideoEncodeAcceleratorSupportedProfile(elementsOrVersion);
                {
                    
                result.profile = decoder0.readInt(8);
                    VideoCodecProfile.validate(result.profile);
                }
                {
                    
                result.maxFramerateNumerator = decoder0.readInt(12);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.maxResolution = org.chromium.gfx.mojom.Size.decode(decoder1);
                }
                {
                    
                result.maxFramerateDenominator = decoder0.readInt(24);
                }
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
        org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        
        encoder0.encode(this.profile, 8);
        
        encoder0.encode(this.maxFramerateNumerator, 12);
        
        encoder0.encode(this.maxResolution, 16, false);
        
        encoder0.encode(this.maxFramerateDenominator, 24);
    }
}