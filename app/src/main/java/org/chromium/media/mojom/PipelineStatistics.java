
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/media_types.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class PipelineStatistics extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 48;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(48, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public long audioBytesDecoded;
    public long videoBytesDecoded;
    public int videoFramesDecoded;
    public int videoFramesDropped;
    public long audioMemoryUsage;
    public long videoMemoryUsage;

    private PipelineStatistics(int version) {
        super(STRUCT_SIZE, version);
    }

    public PipelineStatistics() {
        this(0);
    }

    public static PipelineStatistics deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static PipelineStatistics deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static PipelineStatistics decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        PipelineStatistics result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new PipelineStatistics(elementsOrVersion);
                {
                    
                result.audioBytesDecoded = decoder0.readLong(8);
                }
                {
                    
                result.videoBytesDecoded = decoder0.readLong(16);
                }
                {
                    
                result.videoFramesDecoded = decoder0.readInt(24);
                }
                {
                    
                result.videoFramesDropped = decoder0.readInt(28);
                }
                {
                    
                result.audioMemoryUsage = decoder0.readLong(32);
                }
                {
                    
                result.videoMemoryUsage = decoder0.readLong(40);
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
        
        encoder0.encode(this.audioBytesDecoded, 8);
        
        encoder0.encode(this.videoBytesDecoded, 16);
        
        encoder0.encode(this.videoFramesDecoded, 24);
        
        encoder0.encode(this.videoFramesDropped, 28);
        
        encoder0.encode(this.audioMemoryUsage, 32);
        
        encoder0.encode(this.videoMemoryUsage, 40);
    }
}