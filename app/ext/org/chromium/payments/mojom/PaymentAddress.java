
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     components/payments/mojom/payment_request_data.mojom
//

package org.chromium.payments.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class PaymentAddress extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 104;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(104, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public String country;
    public String[] addressLine;
    public String region;
    public String city;
    public String dependentLocality;
    public String postalCode;
    public String sortingCode;
    public String languageCode;
    public String scriptCode;
    public String organization;
    public String recipient;
    public String phone;

    private PaymentAddress(int version) {
        super(STRUCT_SIZE, version);
    }

    public PaymentAddress() {
        this(0);
    }

    public static PaymentAddress deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static PaymentAddress deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static PaymentAddress decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        PaymentAddress result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new PaymentAddress(elementsOrVersion);
                {
                    
                result.country = decoder0.readString(8, false);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.addressLine = new String[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        result.addressLine[i1] = decoder1.readString(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                    }
                }
                }
                {
                    
                result.region = decoder0.readString(24, false);
                }
                {
                    
                result.city = decoder0.readString(32, false);
                }
                {
                    
                result.dependentLocality = decoder0.readString(40, false);
                }
                {
                    
                result.postalCode = decoder0.readString(48, false);
                }
                {
                    
                result.sortingCode = decoder0.readString(56, false);
                }
                {
                    
                result.languageCode = decoder0.readString(64, false);
                }
                {
                    
                result.scriptCode = decoder0.readString(72, false);
                }
                {
                    
                result.organization = decoder0.readString(80, false);
                }
                {
                    
                result.recipient = decoder0.readString(88, false);
                }
                {
                    
                result.phone = decoder0.readString(96, false);
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
        
        encoder0.encode(this.country, 8, false);
        
        if (this.addressLine == null) {
            encoder0.encodeNullPointer(16, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.addressLine.length, 16, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.addressLine.length; ++i0) {
                
                encoder1.encode(this.addressLine[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.region, 24, false);
        
        encoder0.encode(this.city, 32, false);
        
        encoder0.encode(this.dependentLocality, 40, false);
        
        encoder0.encode(this.postalCode, 48, false);
        
        encoder0.encode(this.sortingCode, 56, false);
        
        encoder0.encode(this.languageCode, 64, false);
        
        encoder0.encode(this.scriptCode, 72, false);
        
        encoder0.encode(this.organization, 80, false);
        
        encoder0.encode(this.recipient, 88, false);
        
        encoder0.encode(this.phone, 96, false);
    }
}