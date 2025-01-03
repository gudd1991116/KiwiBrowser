
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/proxy_resolver/public/mojom/proxy_resolver.mojom
//

package org.chromium.proxy_resolver.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class ProxyResolverFactoryRequestClient_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<ProxyResolverFactoryRequestClient, ProxyResolverFactoryRequestClient.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<ProxyResolverFactoryRequestClient, ProxyResolverFactoryRequestClient.Proxy>() {

        @Override
        public String getName() {
            return "proxy_resolver.mojom.ProxyResolverFactoryRequestClient";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, ProxyResolverFactoryRequestClient impl) {
            return new Stub(core, impl);
        }

        @Override
        public ProxyResolverFactoryRequestClient[] buildArray(int size) {
          return new ProxyResolverFactoryRequestClient[size];
        }
    };


    private static final int REPORT_RESULT_ORDINAL = 0;

    private static final int ALERT_ORDINAL = 1;

    private static final int ON_ERROR_ORDINAL = 2;

    private static final int RESOLVE_DNS_ORDINAL = 3;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements ProxyResolverFactoryRequestClient.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void reportResult(
int error) {

            ProxyResolverFactoryRequestClientReportResultParams _message = new ProxyResolverFactoryRequestClientReportResultParams();

            _message.error = error;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(REPORT_RESULT_ORDINAL)));

        }


        @Override
        public void alert(
String error) {

            ProxyResolverFactoryRequestClientAlertParams _message = new ProxyResolverFactoryRequestClientAlertParams();

            _message.error = error;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ALERT_ORDINAL)));

        }


        @Override
        public void onError(
int lineNumber, String error) {

            ProxyResolverFactoryRequestClientOnErrorParams _message = new ProxyResolverFactoryRequestClientOnErrorParams();

            _message.lineNumber = lineNumber;

            _message.error = error;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_ERROR_ORDINAL)));

        }


        @Override
        public void resolveDns(
org.chromium.net.interfaces.HostResolverRequestInfo requestInfo, org.chromium.net.interfaces.HostResolverRequestClient client) {

            ProxyResolverFactoryRequestClientResolveDnsParams _message = new ProxyResolverFactoryRequestClientResolveDnsParams();

            _message.requestInfo = requestInfo;

            _message.client = client;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(RESOLVE_DNS_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<ProxyResolverFactoryRequestClient> {

        Stub(org.chromium.mojo.system.Core core, ProxyResolverFactoryRequestClient impl) {
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
                                ProxyResolverFactoryRequestClient_Internal.MANAGER, messageWithHeader);





                    case REPORT_RESULT_ORDINAL: {

                        ProxyResolverFactoryRequestClientReportResultParams data =
                                ProxyResolverFactoryRequestClientReportResultParams.deserialize(messageWithHeader.getPayload());

                        getImpl().reportResult(data.error);
                        return true;
                    }





                    case ALERT_ORDINAL: {

                        ProxyResolverFactoryRequestClientAlertParams data =
                                ProxyResolverFactoryRequestClientAlertParams.deserialize(messageWithHeader.getPayload());

                        getImpl().alert(data.error);
                        return true;
                    }





                    case ON_ERROR_ORDINAL: {

                        ProxyResolverFactoryRequestClientOnErrorParams data =
                                ProxyResolverFactoryRequestClientOnErrorParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onError(data.lineNumber, data.error);
                        return true;
                    }





                    case RESOLVE_DNS_ORDINAL: {

                        ProxyResolverFactoryRequestClientResolveDnsParams data =
                                ProxyResolverFactoryRequestClientResolveDnsParams.deserialize(messageWithHeader.getPayload());

                        getImpl().resolveDns(data.requestInfo, data.client);
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
                                getCore(), ProxyResolverFactoryRequestClient_Internal.MANAGER, messageWithHeader, receiver);










                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class ProxyResolverFactoryRequestClientReportResultParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int error;

        private ProxyResolverFactoryRequestClientReportResultParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public ProxyResolverFactoryRequestClientReportResultParams() {
            this(0);
        }

        public static ProxyResolverFactoryRequestClientReportResultParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static ProxyResolverFactoryRequestClientReportResultParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static ProxyResolverFactoryRequestClientReportResultParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            ProxyResolverFactoryRequestClientReportResultParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ProxyResolverFactoryRequestClientReportResultParams(elementsOrVersion);
                    {
                        
                    result.error = decoder0.readInt(8);
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
            
            encoder0.encode(this.error, 8);
        }
    }



    
    static final class ProxyResolverFactoryRequestClientAlertParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String error;

        private ProxyResolverFactoryRequestClientAlertParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public ProxyResolverFactoryRequestClientAlertParams() {
            this(0);
        }

        public static ProxyResolverFactoryRequestClientAlertParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static ProxyResolverFactoryRequestClientAlertParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static ProxyResolverFactoryRequestClientAlertParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            ProxyResolverFactoryRequestClientAlertParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ProxyResolverFactoryRequestClientAlertParams(elementsOrVersion);
                    {
                        
                    result.error = decoder0.readString(8, false);
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
            
            encoder0.encode(this.error, 8, false);
        }
    }



    
    static final class ProxyResolverFactoryRequestClientOnErrorParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int lineNumber;
        public String error;

        private ProxyResolverFactoryRequestClientOnErrorParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public ProxyResolverFactoryRequestClientOnErrorParams() {
            this(0);
        }

        public static ProxyResolverFactoryRequestClientOnErrorParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static ProxyResolverFactoryRequestClientOnErrorParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static ProxyResolverFactoryRequestClientOnErrorParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            ProxyResolverFactoryRequestClientOnErrorParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ProxyResolverFactoryRequestClientOnErrorParams(elementsOrVersion);
                    {
                        
                    result.lineNumber = decoder0.readInt(8);
                    }
                    {
                        
                    result.error = decoder0.readString(16, false);
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
            
            encoder0.encode(this.lineNumber, 8);
            
            encoder0.encode(this.error, 16, false);
        }
    }



    
    static final class ProxyResolverFactoryRequestClientResolveDnsParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.net.interfaces.HostResolverRequestInfo requestInfo;
        public org.chromium.net.interfaces.HostResolverRequestClient client;

        private ProxyResolverFactoryRequestClientResolveDnsParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public ProxyResolverFactoryRequestClientResolveDnsParams() {
            this(0);
        }

        public static ProxyResolverFactoryRequestClientResolveDnsParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static ProxyResolverFactoryRequestClientResolveDnsParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static ProxyResolverFactoryRequestClientResolveDnsParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            ProxyResolverFactoryRequestClientResolveDnsParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new ProxyResolverFactoryRequestClientResolveDnsParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.requestInfo = org.chromium.net.interfaces.HostResolverRequestInfo.decode(decoder1);
                    }
                    {
                        
                    result.client = decoder0.readServiceInterface(16, false, org.chromium.net.interfaces.HostResolverRequestClient.MANAGER);
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
            
            encoder0.encode(this.requestInfo, 8, false);
            
            encoder0.encode(this.client, 16, false, org.chromium.net.interfaces.HostResolverRequestClient.MANAGER);
        }
    }



}
