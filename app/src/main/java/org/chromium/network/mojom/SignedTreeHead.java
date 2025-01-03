
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/signed_tree_head.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class SignedTreeHead extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 56;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(56, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int version;
    public org.chromium.mojo_base.mojom.Time timestamp;
    public long treeSize;
    public byte[] sha256RootHash;
    public DigitallySigned signature;
    public String logId;

    private SignedTreeHead(int version) {
        super(STRUCT_SIZE, version);
    }

    public SignedTreeHead() {
        this(0);
    }

    public static SignedTreeHead deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static SignedTreeHead deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static SignedTreeHead decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        SignedTreeHead result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new SignedTreeHead(elementsOrVersion);
                {
                    
                result.version = decoder0.readInt(8);
                    SignedTreeHeadVersion.validate(result.version);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                result.timestamp = org.chromium.mojo_base.mojom.Time.decode(decoder1);
                }
                {
                    
                result.treeSize = decoder0.readLong(24);
                }
                {
                    
                result.sha256RootHash = decoder0.readBytes(32, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, 32);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(40, false);
                result.signature = DigitallySigned.decode(decoder1);
                }
                {
                    
                result.logId = decoder0.readString(48, false);
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
        
        encoder0.encode(this.version, 8);
        
        encoder0.encode(this.timestamp, 16, false);
        
        encoder0.encode(this.treeSize, 24);
        
        encoder0.encode(this.sha256RootHash, 32, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, 32);
        
        encoder0.encode(this.signature, 40, false);
        
        encoder0.encode(this.logId, 48, false);
    }
}