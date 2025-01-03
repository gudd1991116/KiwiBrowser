
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/geolocation_config.mojom
//

package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class GeolocationConfig_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<GeolocationConfig, GeolocationConfig.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<GeolocationConfig, GeolocationConfig.Proxy>() {

        @Override
        public String getName() {
            return "device.mojom.GeolocationConfig";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Proxy buildProxy(org.chromium.mojo.system.Core core,
                                org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(org.chromium.mojo.system.Core core, GeolocationConfig impl) {
            return new Stub(core, impl);
        }

        @Override
        public GeolocationConfig[] buildArray(int size) {
          return new GeolocationConfig[size];
        }
    };


    private static final int IS_HIGH_ACCURACY_LOCATION_BEING_CAPTURED_ORDINAL = 0;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements GeolocationConfig.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void isHighAccuracyLocationBeingCaptured(

IsHighAccuracyLocationBeingCapturedResponse callback) {

            GeolocationConfigIsHighAccuracyLocationBeingCapturedParams _message = new GeolocationConfigIsHighAccuracyLocationBeingCapturedParams();


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    IS_HIGH_ACCURACY_LOCATION_BEING_CAPTURED_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsForwardToCallback(callback));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<GeolocationConfig> {

        Stub(org.chromium.mojo.system.Core core, GeolocationConfig impl) {
            super(core, impl);
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(org.chromium.mojo.bindings.MessageHeader.NO_FLAG)) {
                    return false;
                }
                switch(header.getType()) {

                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_OR_CLOSE_PIPE_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRunOrClosePipe(
                                GeolocationConfig_Internal.MANAGER, messageWithHeader);




                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override
        public boolean acceptWithResponder(org.chromium.mojo.bindings.Message message, org.chromium.mojo.bindings.MessageReceiver receiver) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG)) {
                    return false;
                }
                switch(header.getType()) {

                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRun(
                                getCore(), GeolocationConfig_Internal.MANAGER, messageWithHeader, receiver);







                    case IS_HIGH_ACCURACY_LOCATION_BEING_CAPTURED_ORDINAL: {

                        GeolocationConfigIsHighAccuracyLocationBeingCapturedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().isHighAccuracyLocationBeingCaptured(new GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }


                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class GeolocationConfigIsHighAccuracyLocationBeingCapturedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private GeolocationConfigIsHighAccuracyLocationBeingCapturedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public GeolocationConfigIsHighAccuracyLocationBeingCapturedParams() {
            this(0);
        }

        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            GeolocationConfigIsHighAccuracyLocationBeingCapturedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationConfigIsHighAccuracyLocationBeingCapturedParams(elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }



    
    static final class GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean highAccuracy;

        private GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams() {
            this(0);
        }

        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams(elementsOrVersion);
                    {
                        
                    result.highAccuracy = decoder0.readBoolean(8, 0);
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
            
            encoder0.encode(this.highAccuracy, 8, 0);
        }
    }

    static class GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final GeolocationConfig.IsHighAccuracyLocationBeingCapturedResponse mCallback;

        GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsForwardToCallback(GeolocationConfig.IsHighAccuracyLocationBeingCapturedResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(IS_HIGH_ACCURACY_LOCATION_BEING_CAPTURED_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams response = GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.highAccuracy);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsProxyToResponder implements GeolocationConfig.IsHighAccuracyLocationBeingCapturedResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Boolean highAccuracy) {
            GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams _response = new GeolocationConfigIsHighAccuracyLocationBeingCapturedResponseParams();

            _response.highAccuracy = highAccuracy;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    IS_HIGH_ACCURACY_LOCATION_BEING_CAPTURED_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



}
