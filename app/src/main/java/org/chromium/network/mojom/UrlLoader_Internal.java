
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/url_loader.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class UrlLoader_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<UrlLoader, UrlLoader.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<UrlLoader, UrlLoader.Proxy>() {

        @Override
        public String getName() {
            return "network.mojom.URLLoader";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, UrlLoader impl) {
            return new Stub(core, impl);
        }

        @Override
        public UrlLoader[] buildArray(int size) {
          return new UrlLoader[size];
        }
    };


    private static final int FOLLOW_REDIRECT_ORDINAL = 0;

    private static final int PROCEED_WITH_RESPONSE_ORDINAL = 1;

    private static final int SET_PRIORITY_ORDINAL = 2;

    private static final int PAUSE_READING_BODY_FROM_NET_ORDINAL = 3;

    private static final int RESUME_READING_BODY_FROM_NET_ORDINAL = 4;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements UrlLoader.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void followRedirect(
HttpRequestHeaders modifiedRequestHeaders) {

            UrlLoaderFollowRedirectParams _message = new UrlLoaderFollowRedirectParams();

            _message.modifiedRequestHeaders = modifiedRequestHeaders;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(FOLLOW_REDIRECT_ORDINAL)));

        }


        @Override
        public void proceedWithResponse(
) {

            UrlLoaderProceedWithResponseParams _message = new UrlLoaderProceedWithResponseParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(PROCEED_WITH_RESPONSE_ORDINAL)));

        }


        @Override
        public void setPriority(
int priority, int intraPriorityValue) {

            UrlLoaderSetPriorityParams _message = new UrlLoaderSetPriorityParams();

            _message.priority = priority;

            _message.intraPriorityValue = intraPriorityValue;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SET_PRIORITY_ORDINAL)));

        }


        @Override
        public void pauseReadingBodyFromNet(
) {

            UrlLoaderPauseReadingBodyFromNetParams _message = new UrlLoaderPauseReadingBodyFromNetParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(PAUSE_READING_BODY_FROM_NET_ORDINAL)));

        }


        @Override
        public void resumeReadingBodyFromNet(
) {

            UrlLoaderResumeReadingBodyFromNetParams _message = new UrlLoaderResumeReadingBodyFromNetParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(RESUME_READING_BODY_FROM_NET_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<UrlLoader> {

        Stub(org.chromium.mojo.system.Core core, UrlLoader impl) {
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
                                UrlLoader_Internal.MANAGER, messageWithHeader);





                    case FOLLOW_REDIRECT_ORDINAL: {

                        UrlLoaderFollowRedirectParams data =
                                UrlLoaderFollowRedirectParams.deserialize(messageWithHeader.getPayload());

                        getImpl().followRedirect(data.modifiedRequestHeaders);
                        return true;
                    }





                    case PROCEED_WITH_RESPONSE_ORDINAL: {

                        UrlLoaderProceedWithResponseParams.deserialize(messageWithHeader.getPayload());

                        getImpl().proceedWithResponse();
                        return true;
                    }





                    case SET_PRIORITY_ORDINAL: {

                        UrlLoaderSetPriorityParams data =
                                UrlLoaderSetPriorityParams.deserialize(messageWithHeader.getPayload());

                        getImpl().setPriority(data.priority, data.intraPriorityValue);
                        return true;
                    }





                    case PAUSE_READING_BODY_FROM_NET_ORDINAL: {

                        UrlLoaderPauseReadingBodyFromNetParams.deserialize(messageWithHeader.getPayload());

                        getImpl().pauseReadingBodyFromNet();
                        return true;
                    }





                    case RESUME_READING_BODY_FROM_NET_ORDINAL: {

                        UrlLoaderResumeReadingBodyFromNetParams.deserialize(messageWithHeader.getPayload());

                        getImpl().resumeReadingBodyFromNet();
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
                                getCore(), UrlLoader_Internal.MANAGER, messageWithHeader, receiver);












                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class UrlLoaderFollowRedirectParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public HttpRequestHeaders modifiedRequestHeaders;

        private UrlLoaderFollowRedirectParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public UrlLoaderFollowRedirectParams() {
            this(0);
        }

        public static UrlLoaderFollowRedirectParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static UrlLoaderFollowRedirectParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static UrlLoaderFollowRedirectParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            UrlLoaderFollowRedirectParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UrlLoaderFollowRedirectParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
                    result.modifiedRequestHeaders = HttpRequestHeaders.decode(decoder1);
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
            
            encoder0.encode(this.modifiedRequestHeaders, 8, true);
        }
    }



    
    static final class UrlLoaderProceedWithResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UrlLoaderProceedWithResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public UrlLoaderProceedWithResponseParams() {
            this(0);
        }

        public static UrlLoaderProceedWithResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static UrlLoaderProceedWithResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static UrlLoaderProceedWithResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            UrlLoaderProceedWithResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UrlLoaderProceedWithResponseParams(elementsOrVersion);
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



    
    static final class UrlLoaderSetPriorityParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int priority;
        public int intraPriorityValue;

        private UrlLoaderSetPriorityParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public UrlLoaderSetPriorityParams() {
            this(0);
        }

        public static UrlLoaderSetPriorityParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static UrlLoaderSetPriorityParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static UrlLoaderSetPriorityParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            UrlLoaderSetPriorityParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UrlLoaderSetPriorityParams(elementsOrVersion);
                    {
                        
                    result.priority = decoder0.readInt(8);
                        RequestPriority.validate(result.priority);
                    }
                    {
                        
                    result.intraPriorityValue = decoder0.readInt(12);
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
            
            encoder0.encode(this.priority, 8);
            
            encoder0.encode(this.intraPriorityValue, 12);
        }
    }



    
    static final class UrlLoaderPauseReadingBodyFromNetParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UrlLoaderPauseReadingBodyFromNetParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public UrlLoaderPauseReadingBodyFromNetParams() {
            this(0);
        }

        public static UrlLoaderPauseReadingBodyFromNetParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static UrlLoaderPauseReadingBodyFromNetParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static UrlLoaderPauseReadingBodyFromNetParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            UrlLoaderPauseReadingBodyFromNetParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UrlLoaderPauseReadingBodyFromNetParams(elementsOrVersion);
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



    
    static final class UrlLoaderResumeReadingBodyFromNetParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private UrlLoaderResumeReadingBodyFromNetParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public UrlLoaderResumeReadingBodyFromNetParams() {
            this(0);
        }

        public static UrlLoaderResumeReadingBodyFromNetParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static UrlLoaderResumeReadingBodyFromNetParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static UrlLoaderResumeReadingBodyFromNetParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            UrlLoaderResumeReadingBodyFromNetParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new UrlLoaderResumeReadingBodyFromNetParams(elementsOrVersion);
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



}
