
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


public final class VideoColorSpace extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 24;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    public static final class PrimaryId {



        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (IS_EXTENSIBLE || isKnownValue(value))
                return;

            throw new DeserializationException("Invalid enum value.");
        }

        private PrimaryId() {}

    }

    public static final class TransferId {



        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (IS_EXTENSIBLE || isKnownValue(value))
                return;

            throw new DeserializationException("Invalid enum value.");
        }

        private TransferId() {}

    }

    public static final class MatrixId {



        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (IS_EXTENSIBLE || isKnownValue(value))
                return;

            throw new DeserializationException("Invalid enum value.");
        }

        private MatrixId() {}

    }

    public static final class RangeId {



        private static final boolean IS_EXTENSIBLE = false;

        public static boolean isKnownValue(int value) {
            return false;
        }

        public static void validate(int value) {
            if (IS_EXTENSIBLE || isKnownValue(value))
                return;

            throw new DeserializationException("Invalid enum value.");
        }

        private RangeId() {}

    }
    public int primaries;
    public int transfer;
    public int matrix;
    public int range;

    private VideoColorSpace(int version) {
        super(STRUCT_SIZE, version);
    }

    public VideoColorSpace() {
        this(0);
    }

    public static VideoColorSpace deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static VideoColorSpace deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static VideoColorSpace decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        VideoColorSpace result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new VideoColorSpace(elementsOrVersion);
                {
                    
                result.primaries = decoder0.readInt(8);
                    VideoColorSpace.PrimaryId.validate(result.primaries);
                }
                {
                    
                result.transfer = decoder0.readInt(12);
                    VideoColorSpace.TransferId.validate(result.transfer);
                }
                {
                    
                result.matrix = decoder0.readInt(16);
                    VideoColorSpace.MatrixId.validate(result.matrix);
                }
                {
                    
                result.range = decoder0.readInt(20);
                    VideoColorSpace.RangeId.validate(result.range);
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
        
        encoder0.encode(this.primaries, 8);
        
        encoder0.encode(this.transfer, 12);
        
        encoder0.encode(this.matrix, 16);
        
        encoder0.encode(this.range, 20);
    }
}