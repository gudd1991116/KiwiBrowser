
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/tcp_socket.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class TcpServerSocket_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<TcpServerSocket, TcpServerSocket.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<TcpServerSocket, TcpServerSocket.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.TCPServerSocket";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, TcpServerSocket impl) {
            return new Stub(core, impl);
        }

        @Override
        public TcpServerSocket[] buildArray(int size) {
          return new TcpServerSocket[size];
        }
    };


    private static final int ACCEPT_ORDINAL = 0;

    private static final int GET_LOCAL_ADDRESS_ORDINAL = 1;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements TcpServerSocket.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void accept(
SocketObserver observer, 
AcceptResponse callback) {

            TcpServerSocketAcceptParams _message = new TcpServerSocketAcceptParams();

            _message.observer = observer;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    ACCEPT_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new TcpServerSocketAcceptResponseParamsForwardToCallback(callback));

        }


        @Override
        public void getLocalAddress(

GetLocalAddressResponse callback) {

            TcpServerSocketGetLocalAddressParams _message = new TcpServerSocketGetLocalAddressParams();


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    GET_LOCAL_ADDRESS_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new TcpServerSocketGetLocalAddressResponseParamsForwardToCallback(callback));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<TcpServerSocket> {

        Stub(org.chromium.mojo.system.Core core, TcpServerSocket impl) {
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
                                TcpServerSocket_Internal.MANAGER, messageWithHeader);






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
                                getCore(), TcpServerSocket_Internal.MANAGER, messageWithHeader, receiver);







                    case ACCEPT_ORDINAL: {

                        TcpServerSocketAcceptParams data =
                                TcpServerSocketAcceptParams.deserialize(messageWithHeader.getPayload());

                        getImpl().accept(data.observer, new TcpServerSocketAcceptResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }







                    case GET_LOCAL_ADDRESS_ORDINAL: {

                        TcpServerSocketGetLocalAddressParams.deserialize(messageWithHeader.getPayload());

                        getImpl().getLocalAddress(new TcpServerSocketGetLocalAddressResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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


    
    static final class TcpServerSocketAcceptParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public SocketObserver observer;

        private TcpServerSocketAcceptParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TcpServerSocketAcceptParams() {
            this(0);
        }

        public static TcpServerSocketAcceptParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TcpServerSocketAcceptParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TcpServerSocketAcceptParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TcpServerSocketAcceptParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TcpServerSocketAcceptParams(elementsOrVersion);
                    {
                        
                    result.observer = decoder0.readServiceInterface(8, true, SocketObserver.MANAGER);
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
            
            encoder0.encode(this.observer, 8, true, SocketObserver.MANAGER);
        }
    }



    
    static final class TcpServerSocketAcceptResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;
        public org.chromium.net.interfaces.IpEndPoint remoteAddr;
        public TcpConnectedSocket connectedSocket;
        public org.chromium.mojo.system.DataPipe.ConsumerHandle sendStream;
        public org.chromium.mojo.system.DataPipe.ProducerHandle receiveStream;

        private TcpServerSocketAcceptResponseParams(int version) {
            super(STRUCT_SIZE, version);
            this.sendStream = org.chromium.mojo.system.InvalidHandle.INSTANCE;
            this.receiveStream = org.chromium.mojo.system.InvalidHandle.INSTANCE;
        }

        public TcpServerSocketAcceptResponseParams() {
            this(0);
        }

        public static TcpServerSocketAcceptResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TcpServerSocketAcceptResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TcpServerSocketAcceptResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TcpServerSocketAcceptResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TcpServerSocketAcceptResponseParams(elementsOrVersion);
                    {
                        
                    result.netError = decoder0.readInt(8);
                    }
                    {
                        
                    result.sendStream = decoder0.readConsumerHandle(12, true);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                    result.remoteAddr = org.chromium.net.interfaces.IpEndPoint.decode(decoder1);
                    }
                    {
                        
                    result.connectedSocket = decoder0.readServiceInterface(24, true, TcpConnectedSocket.MANAGER);
                    }
                    {
                        
                    result.receiveStream = decoder0.readProducerHandle(32, true);
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
            
            encoder0.encode(this.netError, 8);
            
            encoder0.encode(this.sendStream, 12, true);
            
            encoder0.encode(this.remoteAddr, 16, true);
            
            encoder0.encode(this.connectedSocket, 24, true, TcpConnectedSocket.MANAGER);
            
            encoder0.encode(this.receiveStream, 32, true);
        }
    }

    static class TcpServerSocketAcceptResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final TcpServerSocket.AcceptResponse mCallback;

        TcpServerSocketAcceptResponseParamsForwardToCallback(TcpServerSocket.AcceptResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(ACCEPT_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                TcpServerSocketAcceptResponseParams response = TcpServerSocketAcceptResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.netError, response.remoteAddr, response.connectedSocket, response.sendStream, response.receiveStream);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class TcpServerSocketAcceptResponseParamsProxyToResponder implements TcpServerSocket.AcceptResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TcpServerSocketAcceptResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer netError, org.chromium.net.interfaces.IpEndPoint remoteAddr, TcpConnectedSocket connectedSocket, org.chromium.mojo.system.DataPipe.ConsumerHandle sendStream, org.chromium.mojo.system.DataPipe.ProducerHandle receiveStream) {
            TcpServerSocketAcceptResponseParams _response = new TcpServerSocketAcceptResponseParams();

            _response.netError = netError;

            _response.remoteAddr = remoteAddr;

            _response.connectedSocket = connectedSocket;

            _response.sendStream = sendStream;

            _response.receiveStream = receiveStream;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    ACCEPT_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class TcpServerSocketGetLocalAddressParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private TcpServerSocketGetLocalAddressParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TcpServerSocketGetLocalAddressParams() {
            this(0);
        }

        public static TcpServerSocketGetLocalAddressParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TcpServerSocketGetLocalAddressParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TcpServerSocketGetLocalAddressParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TcpServerSocketGetLocalAddressParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TcpServerSocketGetLocalAddressParams(elementsOrVersion);
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



    
    static final class TcpServerSocketGetLocalAddressResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int netError;
        public org.chromium.net.interfaces.IpEndPoint localAddr;

        private TcpServerSocketGetLocalAddressResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TcpServerSocketGetLocalAddressResponseParams() {
            this(0);
        }

        public static TcpServerSocketGetLocalAddressResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TcpServerSocketGetLocalAddressResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TcpServerSocketGetLocalAddressResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TcpServerSocketGetLocalAddressResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TcpServerSocketGetLocalAddressResponseParams(elementsOrVersion);
                    {
                        
                    result.netError = decoder0.readInt(8);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                    result.localAddr = org.chromium.net.interfaces.IpEndPoint.decode(decoder1);
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
            
            encoder0.encode(this.netError, 8);
            
            encoder0.encode(this.localAddr, 16, true);
        }
    }

    static class TcpServerSocketGetLocalAddressResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final TcpServerSocket.GetLocalAddressResponse mCallback;

        TcpServerSocketGetLocalAddressResponseParamsForwardToCallback(TcpServerSocket.GetLocalAddressResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(GET_LOCAL_ADDRESS_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                TcpServerSocketGetLocalAddressResponseParams response = TcpServerSocketGetLocalAddressResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.netError, response.localAddr);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class TcpServerSocketGetLocalAddressResponseParamsProxyToResponder implements TcpServerSocket.GetLocalAddressResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        TcpServerSocketGetLocalAddressResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer netError, org.chromium.net.interfaces.IpEndPoint localAddr) {
            TcpServerSocketGetLocalAddressResponseParams _response = new TcpServerSocketGetLocalAddressResponseParams();

            _response.netError = netError;

            _response.localAddr = localAddr;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    GET_LOCAL_ADDRESS_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



}
