
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/leak_detector/leak_detector.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class LeakDetectionResult extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 56;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(56, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int numberOfLiveAudioNodes;
    public int numberOfLiveDocuments;
    public int numberOfLiveNodes;
    public int numberOfLiveLayoutObjects;
    public int numberOfLiveResources;
    public int numberOfLivePausableObjects;
    public int numberOfLiveScriptPromises;
    public int numberOfLiveFrames;
    public int numberOfLiveV8PerContextData;
    public int numberOfWorkerGlobalScopes;
    public int numberOfLiveUaCssResources;
    public int numberOfLiveResourceFetchers;

    private LeakDetectionResult(int version) {
        super(STRUCT_SIZE, version);
    }

    public LeakDetectionResult() {
        this(0);
    }

    public static LeakDetectionResult deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static LeakDetectionResult deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static LeakDetectionResult decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        LeakDetectionResult result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new LeakDetectionResult(elementsOrVersion);
                {
                    
                result.numberOfLiveAudioNodes = decoder0.readInt(8);
                }
                {
                    
                result.numberOfLiveDocuments = decoder0.readInt(12);
                }
                {
                    
                result.numberOfLiveNodes = decoder0.readInt(16);
                }
                {
                    
                result.numberOfLiveLayoutObjects = decoder0.readInt(20);
                }
                {
                    
                result.numberOfLiveResources = decoder0.readInt(24);
                }
                {
                    
                result.numberOfLivePausableObjects = decoder0.readInt(28);
                }
                {
                    
                result.numberOfLiveScriptPromises = decoder0.readInt(32);
                }
                {
                    
                result.numberOfLiveFrames = decoder0.readInt(36);
                }
                {
                    
                result.numberOfLiveV8PerContextData = decoder0.readInt(40);
                }
                {
                    
                result.numberOfWorkerGlobalScopes = decoder0.readInt(44);
                }
                {
                    
                result.numberOfLiveUaCssResources = decoder0.readInt(48);
                }
                {
                    
                result.numberOfLiveResourceFetchers = decoder0.readInt(52);
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
        
        encoder0.encode(this.numberOfLiveAudioNodes, 8);
        
        encoder0.encode(this.numberOfLiveDocuments, 12);
        
        encoder0.encode(this.numberOfLiveNodes, 16);
        
        encoder0.encode(this.numberOfLiveLayoutObjects, 20);
        
        encoder0.encode(this.numberOfLiveResources, 24);
        
        encoder0.encode(this.numberOfLivePausableObjects, 28);
        
        encoder0.encode(this.numberOfLiveScriptPromises, 32);
        
        encoder0.encode(this.numberOfLiveFrames, 36);
        
        encoder0.encode(this.numberOfLiveV8PerContextData, 40);
        
        encoder0.encode(this.numberOfWorkerGlobalScopes, 44);
        
        encoder0.encode(this.numberOfLiveUaCssResources, 48);
        
        encoder0.encode(this.numberOfLiveResourceFetchers, 52);
    }
}