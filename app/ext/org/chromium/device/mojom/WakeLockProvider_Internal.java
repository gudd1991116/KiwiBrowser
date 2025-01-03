
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/device/public/mojom/wake_lock_provider.mojom
//

package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class WakeLockProvider_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<WakeLockProvider, WakeLockProvider.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<WakeLockProvider, WakeLockProvider.Proxy>() {

        @Override
        public String getName() {
            return "device.mojom.WakeLockProvider";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, WakeLockProvider impl) {
            return new Stub(core, impl);
        }

        @Override
        public WakeLockProvider[] buildArray(int size) {
          return new WakeLockProvider[size];
        }
    };


    private static final int GET_WAKE_LOCK_CONTEXT_FOR_ID_ORDINAL = 0;

    private static final int GET_WAKE_LOCK_WITHOUT_CONTEXT_ORDINAL = 1;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements WakeLockProvider.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void getWakeLockContextForId(
int contextId, org.chromium.mojo.bindings.InterfaceRequest<WakeLockContext> context) {

            WakeLockProviderGetWakeLockContextForIdParams _message = new WakeLockProviderGetWakeLockContextForIdParams();

            _message.contextId = contextId;

            _message.context = context;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(GET_WAKE_LOCK_CONTEXT_FOR_ID_ORDINAL)));

        }


        @Override
        public void getWakeLockWithoutContext(
int type, int reason, String description, org.chromium.mojo.bindings.InterfaceRequest<WakeLock> wakeLock) {

            WakeLockProviderGetWakeLockWithoutContextParams _message = new WakeLockProviderGetWakeLockWithoutContextParams();

            _message.type = type;

            _message.reason = reason;

            _message.description = description;

            _message.wakeLock = wakeLock;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(GET_WAKE_LOCK_WITHOUT_CONTEXT_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<WakeLockProvider> {

        Stub(org.chromium.mojo.system.Core core, WakeLockProvider impl) {
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
                                WakeLockProvider_Internal.MANAGER, messageWithHeader);





                    case GET_WAKE_LOCK_CONTEXT_FOR_ID_ORDINAL: {

                        WakeLockProviderGetWakeLockContextForIdParams data =
                                WakeLockProviderGetWakeLockContextForIdParams.deserialize(messageWithHeader.getPayload());

                        getImpl().getWakeLockContextForId(data.contextId, data.context);
                        return true;
                    }





                    case GET_WAKE_LOCK_WITHOUT_CONTEXT_ORDINAL: {

                        WakeLockProviderGetWakeLockWithoutContextParams data =
                                WakeLockProviderGetWakeLockWithoutContextParams.deserialize(messageWithHeader.getPayload());

                        getImpl().getWakeLockWithoutContext(data.type, data.reason, data.description, data.wakeLock);
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
                                getCore(), WakeLockProvider_Internal.MANAGER, messageWithHeader, receiver);






                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class WakeLockProviderGetWakeLockContextForIdParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int contextId;
        public org.chromium.mojo.bindings.InterfaceRequest<WakeLockContext> context;

        private WakeLockProviderGetWakeLockContextForIdParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WakeLockProviderGetWakeLockContextForIdParams() {
            this(0);
        }

        public static WakeLockProviderGetWakeLockContextForIdParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WakeLockProviderGetWakeLockContextForIdParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WakeLockProviderGetWakeLockContextForIdParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WakeLockProviderGetWakeLockContextForIdParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderGetWakeLockContextForIdParams(elementsOrVersion);
                    {
                        
                    result.contextId = decoder0.readInt(8);
                    }
                    {
                        
                    result.context = decoder0.readInterfaceRequest(12, false);
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
            
            encoder0.encode(this.contextId, 8);
            
            encoder0.encode(this.context, 12, false);
        }
    }



    
    static final class WakeLockProviderGetWakeLockWithoutContextParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 32;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;
        public int reason;
        public String description;
        public org.chromium.mojo.bindings.InterfaceRequest<WakeLock> wakeLock;

        private WakeLockProviderGetWakeLockWithoutContextParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public WakeLockProviderGetWakeLockWithoutContextParams() {
            this(0);
        }

        public static WakeLockProviderGetWakeLockWithoutContextParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WakeLockProviderGetWakeLockWithoutContextParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static WakeLockProviderGetWakeLockWithoutContextParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WakeLockProviderGetWakeLockWithoutContextParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new WakeLockProviderGetWakeLockWithoutContextParams(elementsOrVersion);
                    {
                        
                    result.type = decoder0.readInt(8);
                        WakeLockType.validate(result.type);
                    }
                    {
                        
                    result.reason = decoder0.readInt(12);
                        WakeLockReason.validate(result.reason);
                    }
                    {
                        
                    result.description = decoder0.readString(16, false);
                    }
                    {
                        
                    result.wakeLock = decoder0.readInterfaceRequest(24, false);
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
            
            encoder0.encode(this.type, 8);
            
            encoder0.encode(this.reason, 12);
            
            encoder0.encode(this.description, 16, false);
            
            encoder0.encode(this.wakeLock, 24, false);
        }
    }



}
