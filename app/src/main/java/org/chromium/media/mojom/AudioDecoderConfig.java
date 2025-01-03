
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


public final class AudioDecoderConfig extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 56;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(56, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int codec;
    public int sampleFormat;
    public int channelLayout;
    public int samplesPerSecond;
    public byte[] extraData;
    public org.chromium.mojo_base.mojom.TimeDelta seekPreroll;
    public int codecDelay;
    public EncryptionScheme encryptionScheme;

    private AudioDecoderConfig(int version) {
        super(STRUCT_SIZE, version);
    }

    public AudioDecoderConfig() {
        this(0);
    }

    public static AudioDecoderConfig deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static AudioDecoderConfig deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static AudioDecoderConfig decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        AudioDecoderConfig result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new AudioDecoderConfig(elementsOrVersion);
                {
                    
                result.codec = decoder0.readInt(8);
                    AudioCodec.validate(result.codec);
                }
                {
                    
                result.sampleFormat = decoder0.readInt(12);
                    SampleFormat.validate(result.sampleFormat);
                }
                {
                    
                result.channelLayout = decoder0.readInt(16);
                    ChannelLayout.validate(result.channelLayout);
                }
                {
                    
                result.samplesPerSecond = decoder0.readInt(20);
                }
                {
                    
                result.extraData = decoder0.readBytes(24, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                result.seekPreroll = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
                }
                {
                    
                result.codecDelay = decoder0.readInt(40);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(48, false);
                result.encryptionScheme = EncryptionScheme.decode(decoder1);
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
        
        encoder0.encode(this.codec, 8);
        
        encoder0.encode(this.sampleFormat, 12);
        
        encoder0.encode(this.channelLayout, 16);
        
        encoder0.encode(this.samplesPerSecond, 20);
        
        encoder0.encode(this.extraData, 24, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        
        encoder0.encode(this.seekPreroll, 32, false);
        
        encoder0.encode(this.codecDelay, 40);
        
        encoder0.encode(this.encryptionScheme, 48, false);
    }
}