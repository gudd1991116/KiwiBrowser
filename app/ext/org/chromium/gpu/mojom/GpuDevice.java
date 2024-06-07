
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


public final class GpuDevice extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 64;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(64, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int vendorId;
    public int deviceId;
    public boolean active;
    public String vendorString;
    public String deviceString;
    public String driverVendor;
    public String driverVersion;
    public String driverDate;

    private GpuDevice(int version) {
        super(STRUCT_SIZE, version);
    }

    public GpuDevice() {
        this(0);
    }

    public static GpuDevice deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static GpuDevice deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static GpuDevice decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        GpuDevice result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new GpuDevice(elementsOrVersion);
                {
                    
                result.vendorId = decoder0.readInt(8);
                }
                {
                    
                result.deviceId = decoder0.readInt(12);
                }
                {
                    
                result.active = decoder0.readBoolean(16, 0);
                }
                {
                    
                result.vendorString = decoder0.readString(24, false);
                }
                {
                    
                result.deviceString = decoder0.readString(32, false);
                }
                {
                    
                result.driverVendor = decoder0.readString(40, false);
                }
                {
                    
                result.driverVersion = decoder0.readString(48, false);
                }
                {
                    
                result.driverDate = decoder0.readString(56, false);
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
        
        encoder0.encode(this.vendorId, 8);
        
        encoder0.encode(this.deviceId, 12);
        
        encoder0.encode(this.active, 16, 0);
        
        encoder0.encode(this.vendorString, 24, false);
        
        encoder0.encode(this.deviceString, 32, false);
        
        encoder0.encode(this.driverVendor, 40, false);
        
        encoder0.encode(this.driverVersion, 48, false);
        
        encoder0.encode(this.driverDate, 56, false);
    }
}