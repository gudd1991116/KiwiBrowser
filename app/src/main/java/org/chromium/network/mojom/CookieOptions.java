
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/cookie_manager.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class CookieOptions extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 24;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public boolean excludeHttponly;
    public int cookieSameSiteFilter;
    public boolean updateAccessTime;
    public org.chromium.mojo_base.mojom.Time serverTime;

    private CookieOptions(int version) {
        super(STRUCT_SIZE, version);
        this.excludeHttponly = (boolean) true;
        this.cookieSameSiteFilter = (int) CookieSameSiteFilter.DO_NOT_INCLUDE;
        this.updateAccessTime = (boolean) true;
    }

    public CookieOptions() {
        this(0);
    }

    public static CookieOptions deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static CookieOptions deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static CookieOptions decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        CookieOptions result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new CookieOptions(elementsOrVersion);
                {
                    
                result.excludeHttponly = decoder0.readBoolean(8, 0);
                }
                {
                    
                result.updateAccessTime = decoder0.readBoolean(8, 1);
                }
                {
                    
                result.cookieSameSiteFilter = decoder0.readInt(12);
                    CookieSameSiteFilter.validate(result.cookieSameSiteFilter);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                result.serverTime = org.chromium.mojo_base.mojom.Time.decode(decoder1);
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
        
        encoder0.encode(this.excludeHttponly, 8, 0);
        
        encoder0.encode(this.updateAccessTime, 8, 1);
        
        encoder0.encode(this.cookieSameSiteFilter, 12);
        
        encoder0.encode(this.serverTime, 16, true);
    }
}