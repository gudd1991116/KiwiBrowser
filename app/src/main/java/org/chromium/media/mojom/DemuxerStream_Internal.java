
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/demuxer_stream.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class DemuxerStream_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<DemuxerStream, DemuxerStream.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<DemuxerStream, DemuxerStream.Proxy>() {

        @Override
        public String getName() {
            return "media.mojom.DemuxerStream";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, DemuxerStream impl) {
            return new Stub(core, impl);
        }

        @Override
        public DemuxerStream[] buildArray(int size) {
          return new DemuxerStream[size];
        }
    };


    private static final int INITIALIZE_ORDINAL = 0;

    private static final int READ_ORDINAL = 1;

    private static final int ENABLE_BITSTREAM_CONVERTER_ORDINAL = 2;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements DemuxerStream.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void initialize(

InitializeResponse callback) {

            DemuxerStreamInitializeParams _message = new DemuxerStreamInitializeParams();


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    INITIALIZE_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new DemuxerStreamInitializeResponseParamsForwardToCallback(callback));

        }


        @Override
        public void read(

ReadResponse callback) {

            DemuxerStreamReadParams _message = new DemuxerStreamReadParams();


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    READ_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new DemuxerStreamReadResponseParamsForwardToCallback(callback));

        }


        @Override
        public void enableBitstreamConverter(
) {

            DemuxerStreamEnableBitstreamConverterParams _message = new DemuxerStreamEnableBitstreamConverterParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ENABLE_BITSTREAM_CONVERTER_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<DemuxerStream> {

        Stub(org.chromium.mojo.system.Core core, DemuxerStream impl) {
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
                                DemuxerStream_Internal.MANAGER, messageWithHeader);









                    case ENABLE_BITSTREAM_CONVERTER_ORDINAL: {

                        DemuxerStreamEnableBitstreamConverterParams.deserialize(messageWithHeader.getPayload());

                        getImpl().enableBitstreamConverter();
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
                                getCore(), DemuxerStream_Internal.MANAGER, messageWithHeader, receiver);







                    case INITIALIZE_ORDINAL: {

                        DemuxerStreamInitializeParams.deserialize(messageWithHeader.getPayload());

                        getImpl().initialize(new DemuxerStreamInitializeResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }







                    case READ_ORDINAL: {

                        DemuxerStreamReadParams.deserialize(messageWithHeader.getPayload());

                        getImpl().read(new DemuxerStreamReadResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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


    
    static final class DemuxerStreamInitializeParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DemuxerStreamInitializeParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public DemuxerStreamInitializeParams() {
            this(0);
        }

        public static DemuxerStreamInitializeParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static DemuxerStreamInitializeParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static DemuxerStreamInitializeParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            DemuxerStreamInitializeParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DemuxerStreamInitializeParams(elementsOrVersion);
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



    
    static final class DemuxerStreamInitializeResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 32;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int type;
        public org.chromium.mojo.system.DataPipe.ConsumerHandle pipe;
        public AudioDecoderConfig audioConfig;
        public VideoDecoderConfig videoConfig;

        private DemuxerStreamInitializeResponseParams(int version) {
            super(STRUCT_SIZE, version);
            this.pipe = org.chromium.mojo.system.InvalidHandle.INSTANCE;
        }

        public DemuxerStreamInitializeResponseParams() {
            this(0);
        }

        public static DemuxerStreamInitializeResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static DemuxerStreamInitializeResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static DemuxerStreamInitializeResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            DemuxerStreamInitializeResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DemuxerStreamInitializeResponseParams(elementsOrVersion);
                    {
                        
                    result.type = decoder0.readInt(8);
                        DemuxerStream.Type.validate(result.type);
                    }
                    {
                        
                    result.pipe = decoder0.readConsumerHandle(12, false);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                    result.audioConfig = AudioDecoderConfig.decode(decoder1);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, true);
                    result.videoConfig = VideoDecoderConfig.decode(decoder1);
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
            
            encoder0.encode(this.pipe, 12, false);
            
            encoder0.encode(this.audioConfig, 16, true);
            
            encoder0.encode(this.videoConfig, 24, true);
        }
    }

    static class DemuxerStreamInitializeResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final DemuxerStream.InitializeResponse mCallback;

        DemuxerStreamInitializeResponseParamsForwardToCallback(DemuxerStream.InitializeResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(INITIALIZE_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                DemuxerStreamInitializeResponseParams response = DemuxerStreamInitializeResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.type, response.pipe, response.audioConfig, response.videoConfig);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class DemuxerStreamInitializeResponseParamsProxyToResponder implements DemuxerStream.InitializeResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DemuxerStreamInitializeResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer type, org.chromium.mojo.system.DataPipe.ConsumerHandle pipe, AudioDecoderConfig audioConfig, VideoDecoderConfig videoConfig) {
            DemuxerStreamInitializeResponseParams _response = new DemuxerStreamInitializeResponseParams();

            _response.type = type;

            _response.pipe = pipe;

            _response.audioConfig = audioConfig;

            _response.videoConfig = videoConfig;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    INITIALIZE_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class DemuxerStreamReadParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DemuxerStreamReadParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public DemuxerStreamReadParams() {
            this(0);
        }

        public static DemuxerStreamReadParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static DemuxerStreamReadParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static DemuxerStreamReadParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            DemuxerStreamReadParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DemuxerStreamReadParams(elementsOrVersion);
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



    
    static final class DemuxerStreamReadResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;
        public DecoderBuffer buffer;
        public AudioDecoderConfig audioConfig;
        public VideoDecoderConfig videoConfig;

        private DemuxerStreamReadResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public DemuxerStreamReadResponseParams() {
            this(0);
        }

        public static DemuxerStreamReadResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static DemuxerStreamReadResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static DemuxerStreamReadResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            DemuxerStreamReadResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DemuxerStreamReadResponseParams(elementsOrVersion);
                    {
                        
                    result.status = decoder0.readInt(8);
                        DemuxerStream.Status.validate(result.status);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                    result.buffer = DecoderBuffer.decode(decoder1);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, true);
                    result.audioConfig = AudioDecoderConfig.decode(decoder1);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, true);
                    result.videoConfig = VideoDecoderConfig.decode(decoder1);
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
            
            encoder0.encode(this.status, 8);
            
            encoder0.encode(this.buffer, 16, true);
            
            encoder0.encode(this.audioConfig, 24, true);
            
            encoder0.encode(this.videoConfig, 32, true);
        }
    }

    static class DemuxerStreamReadResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final DemuxerStream.ReadResponse mCallback;

        DemuxerStreamReadResponseParamsForwardToCallback(DemuxerStream.ReadResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(READ_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                DemuxerStreamReadResponseParams response = DemuxerStreamReadResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.status, response.buffer, response.audioConfig, response.videoConfig);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class DemuxerStreamReadResponseParamsProxyToResponder implements DemuxerStream.ReadResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        DemuxerStreamReadResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer status, DecoderBuffer buffer, AudioDecoderConfig audioConfig, VideoDecoderConfig videoConfig) {
            DemuxerStreamReadResponseParams _response = new DemuxerStreamReadResponseParams();

            _response.status = status;

            _response.buffer = buffer;

            _response.audioConfig = audioConfig;

            _response.videoConfig = videoConfig;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    READ_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class DemuxerStreamEnableBitstreamConverterParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private DemuxerStreamEnableBitstreamConverterParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public DemuxerStreamEnableBitstreamConverterParams() {
            this(0);
        }

        public static DemuxerStreamEnableBitstreamConverterParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static DemuxerStreamEnableBitstreamConverterParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static DemuxerStreamEnableBitstreamConverterParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            DemuxerStreamEnableBitstreamConverterParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new DemuxerStreamEnableBitstreamConverterParams(elementsOrVersion);
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
