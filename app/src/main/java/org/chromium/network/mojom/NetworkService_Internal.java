
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_service.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class NetworkService_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<NetworkService, NetworkService.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<NetworkService, NetworkService.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.NetworkService";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, NetworkService impl) {
            return new Stub(core, impl);
        }

        @Override
        public NetworkService[] buildArray(int size) {
          return new NetworkService[size];
        }
    };


    private static final int SET_CLIENT_ORDINAL = 0;

    private static final int CREATE_NETWORK_CONTEXT_ORDINAL = 1;

    private static final int DISABLE_QUIC_ORDINAL = 2;

    private static final int SET_RAW_HEADERS_ACCESS_ORDINAL = 3;

    private static final int GET_NETWORK_CHANGE_MANAGER_ORDINAL = 4;

    private static final int GET_TOTAL_NETWORK_USAGES_ORDINAL = 5;

    private static final int UPDATE_SIGNED_TREE_HEAD_ORDINAL = 6;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements NetworkService.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void setClient(
NetworkServiceClient client) {

            NetworkServiceSetClientParams _message = new NetworkServiceSetClientParams();

            _message.client = client;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SET_CLIENT_ORDINAL)));

        }


        @Override
        public void createNetworkContext(
org.chromium.mojo.bindings.InterfaceRequest<NetworkContext> context, NetworkContextParams params) {

            NetworkServiceCreateNetworkContextParams _message = new NetworkServiceCreateNetworkContextParams();

            _message.context = context;

            _message.params = params;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CREATE_NETWORK_CONTEXT_ORDINAL)));

        }


        @Override
        public void disableQuic(
) {

            NetworkServiceDisableQuicParams _message = new NetworkServiceDisableQuicParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(DISABLE_QUIC_ORDINAL)));

        }


        @Override
        public void setRawHeadersAccess(
int processId, boolean allow) {

            NetworkServiceSetRawHeadersAccessParams _message = new NetworkServiceSetRawHeadersAccessParams();

            _message.processId = processId;

            _message.allow = allow;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SET_RAW_HEADERS_ACCESS_ORDINAL)));

        }


        @Override
        public void getNetworkChangeManager(
org.chromium.mojo.bindings.InterfaceRequest<NetworkChangeManager> networkChangeManager) {

            NetworkServiceGetNetworkChangeManagerParams _message = new NetworkServiceGetNetworkChangeManagerParams();

            _message.networkChangeManager = networkChangeManager;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(GET_NETWORK_CHANGE_MANAGER_ORDINAL)));

        }


        @Override
        public void getTotalNetworkUsages(

GetTotalNetworkUsagesResponse callback) {

            NetworkServiceGetTotalNetworkUsagesParams _message = new NetworkServiceGetTotalNetworkUsagesParams();


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    GET_TOTAL_NETWORK_USAGES_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new NetworkServiceGetTotalNetworkUsagesResponseParamsForwardToCallback(callback));

        }


        @Override
        public void updateSignedTreeHead(
SignedTreeHead signedTreeHead) {

            NetworkServiceUpdateSignedTreeHeadParams _message = new NetworkServiceUpdateSignedTreeHeadParams();

            _message.signedTreeHead = signedTreeHead;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(UPDATE_SIGNED_TREE_HEAD_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<NetworkService> {

        Stub(org.chromium.mojo.system.Core core, NetworkService impl) {
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
                                NetworkService_Internal.MANAGER, messageWithHeader);





                    case SET_CLIENT_ORDINAL: {

                        NetworkServiceSetClientParams data =
                                NetworkServiceSetClientParams.deserialize(messageWithHeader.getPayload());

                        getImpl().setClient(data.client);
                        return true;
                    }





                    case CREATE_NETWORK_CONTEXT_ORDINAL: {

                        NetworkServiceCreateNetworkContextParams data =
                                NetworkServiceCreateNetworkContextParams.deserialize(messageWithHeader.getPayload());

                        getImpl().createNetworkContext(data.context, data.params);
                        return true;
                    }





                    case DISABLE_QUIC_ORDINAL: {

                        NetworkServiceDisableQuicParams.deserialize(messageWithHeader.getPayload());

                        getImpl().disableQuic();
                        return true;
                    }





                    case SET_RAW_HEADERS_ACCESS_ORDINAL: {

                        NetworkServiceSetRawHeadersAccessParams data =
                                NetworkServiceSetRawHeadersAccessParams.deserialize(messageWithHeader.getPayload());

                        getImpl().setRawHeadersAccess(data.processId, data.allow);
                        return true;
                    }





                    case GET_NETWORK_CHANGE_MANAGER_ORDINAL: {

                        NetworkServiceGetNetworkChangeManagerParams data =
                                NetworkServiceGetNetworkChangeManagerParams.deserialize(messageWithHeader.getPayload());

                        getImpl().getNetworkChangeManager(data.networkChangeManager);
                        return true;
                    }







                    case UPDATE_SIGNED_TREE_HEAD_ORDINAL: {

                        NetworkServiceUpdateSignedTreeHeadParams data =
                                NetworkServiceUpdateSignedTreeHeadParams.deserialize(messageWithHeader.getPayload());

                        getImpl().updateSignedTreeHead(data.signedTreeHead);
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
                                getCore(), NetworkService_Internal.MANAGER, messageWithHeader, receiver);

















                    case GET_TOTAL_NETWORK_USAGES_ORDINAL: {

                        NetworkServiceGetTotalNetworkUsagesParams.deserialize(messageWithHeader.getPayload());

                        getImpl().getTotalNetworkUsages(new NetworkServiceGetTotalNetworkUsagesResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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


    
    static final class NetworkServiceSetClientParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public NetworkServiceClient client;

        private NetworkServiceSetClientParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public NetworkServiceSetClientParams() {
            this(0);
        }

        public static NetworkServiceSetClientParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static NetworkServiceSetClientParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static NetworkServiceSetClientParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            NetworkServiceSetClientParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NetworkServiceSetClientParams(elementsOrVersion);
                    {
                        
                    result.client = decoder0.readServiceInterface(8, false, NetworkServiceClient.MANAGER);
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
            
            encoder0.encode(this.client, 8, false, NetworkServiceClient.MANAGER);
        }
    }



    
    static final class NetworkServiceCreateNetworkContextParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<NetworkContext> context;
        public NetworkContextParams params;

        private NetworkServiceCreateNetworkContextParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public NetworkServiceCreateNetworkContextParams() {
            this(0);
        }

        public static NetworkServiceCreateNetworkContextParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static NetworkServiceCreateNetworkContextParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static NetworkServiceCreateNetworkContextParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            NetworkServiceCreateNetworkContextParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NetworkServiceCreateNetworkContextParams(elementsOrVersion);
                    {
                        
                    result.context = decoder0.readInterfaceRequest(8, false);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                    result.params = NetworkContextParams.decode(decoder1);
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
            
            encoder0.encode(this.context, 8, false);
            
            encoder0.encode(this.params, 16, false);
        }
    }



    
    static final class NetworkServiceDisableQuicParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceDisableQuicParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public NetworkServiceDisableQuicParams() {
            this(0);
        }

        public static NetworkServiceDisableQuicParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static NetworkServiceDisableQuicParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static NetworkServiceDisableQuicParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            NetworkServiceDisableQuicParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NetworkServiceDisableQuicParams(elementsOrVersion);
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



    
    static final class NetworkServiceSetRawHeadersAccessParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int processId;
        public boolean allow;

        private NetworkServiceSetRawHeadersAccessParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public NetworkServiceSetRawHeadersAccessParams() {
            this(0);
        }

        public static NetworkServiceSetRawHeadersAccessParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static NetworkServiceSetRawHeadersAccessParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static NetworkServiceSetRawHeadersAccessParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            NetworkServiceSetRawHeadersAccessParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NetworkServiceSetRawHeadersAccessParams(elementsOrVersion);
                    {
                        
                    result.processId = decoder0.readInt(8);
                    }
                    {
                        
                    result.allow = decoder0.readBoolean(12, 0);
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
            
            encoder0.encode(this.processId, 8);
            
            encoder0.encode(this.allow, 12, 0);
        }
    }



    
    static final class NetworkServiceGetNetworkChangeManagerParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<NetworkChangeManager> networkChangeManager;

        private NetworkServiceGetNetworkChangeManagerParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public NetworkServiceGetNetworkChangeManagerParams() {
            this(0);
        }

        public static NetworkServiceGetNetworkChangeManagerParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static NetworkServiceGetNetworkChangeManagerParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static NetworkServiceGetNetworkChangeManagerParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            NetworkServiceGetNetworkChangeManagerParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NetworkServiceGetNetworkChangeManagerParams(elementsOrVersion);
                    {
                        
                    result.networkChangeManager = decoder0.readInterfaceRequest(8, false);
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
            
            encoder0.encode(this.networkChangeManager, 8, false);
        }
    }



    
    static final class NetworkServiceGetTotalNetworkUsagesParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private NetworkServiceGetTotalNetworkUsagesParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public NetworkServiceGetTotalNetworkUsagesParams() {
            this(0);
        }

        public static NetworkServiceGetTotalNetworkUsagesParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static NetworkServiceGetTotalNetworkUsagesParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static NetworkServiceGetTotalNetworkUsagesParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            NetworkServiceGetTotalNetworkUsagesParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NetworkServiceGetTotalNetworkUsagesParams(elementsOrVersion);
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



    
    static final class NetworkServiceGetTotalNetworkUsagesResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public NetworkUsage[] totalNetworkUsages;

        private NetworkServiceGetTotalNetworkUsagesResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public NetworkServiceGetTotalNetworkUsagesResponseParams() {
            this(0);
        }

        public static NetworkServiceGetTotalNetworkUsagesResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static NetworkServiceGetTotalNetworkUsagesResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static NetworkServiceGetTotalNetworkUsagesResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            NetworkServiceGetTotalNetworkUsagesResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NetworkServiceGetTotalNetworkUsagesResponseParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    {
                        org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                        result.totalNetworkUsages = new NetworkUsage[si1.elementsOrVersion];
                        for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                            
                            org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                            result.totalNetworkUsages[i1] = NetworkUsage.decode(decoder2);
                        }
                    }
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
            
            if (this.totalNetworkUsages == null) {
                encoder0.encodeNullPointer(8, false);
            } else {
                org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.totalNetworkUsages.length, 8, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i0 = 0; i0 < this.totalNetworkUsages.length; ++i0) {
                    
                    encoder1.encode(this.totalNetworkUsages[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
                }
            }
        }
    }

    static class NetworkServiceGetTotalNetworkUsagesResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final NetworkService.GetTotalNetworkUsagesResponse mCallback;

        NetworkServiceGetTotalNetworkUsagesResponseParamsForwardToCallback(NetworkService.GetTotalNetworkUsagesResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(GET_TOTAL_NETWORK_USAGES_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                NetworkServiceGetTotalNetworkUsagesResponseParams response = NetworkServiceGetTotalNetworkUsagesResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.totalNetworkUsages);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class NetworkServiceGetTotalNetworkUsagesResponseParamsProxyToResponder implements NetworkService.GetTotalNetworkUsagesResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        NetworkServiceGetTotalNetworkUsagesResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(NetworkUsage[] totalNetworkUsages) {
            NetworkServiceGetTotalNetworkUsagesResponseParams _response = new NetworkServiceGetTotalNetworkUsagesResponseParams();

            _response.totalNetworkUsages = totalNetworkUsages;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    GET_TOTAL_NETWORK_USAGES_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class NetworkServiceUpdateSignedTreeHeadParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public SignedTreeHead signedTreeHead;

        private NetworkServiceUpdateSignedTreeHeadParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public NetworkServiceUpdateSignedTreeHeadParams() {
            this(0);
        }

        public static NetworkServiceUpdateSignedTreeHeadParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static NetworkServiceUpdateSignedTreeHeadParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static NetworkServiceUpdateSignedTreeHeadParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            NetworkServiceUpdateSignedTreeHeadParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new NetworkServiceUpdateSignedTreeHeadParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.signedTreeHead = SignedTreeHead.decode(decoder1);
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
            
            encoder0.encode(this.signedTreeHead, 8, false);
        }
    }



}
