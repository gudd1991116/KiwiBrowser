
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/media_metrics_provider.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class MediaMetricsProvider_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<MediaMetricsProvider, MediaMetricsProvider.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<MediaMetricsProvider, MediaMetricsProvider.Proxy>() {

        @Override
        public String getName() {
            return "media.mojom.MediaMetricsProvider";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, MediaMetricsProvider impl) {
            return new Stub(core, impl);
        }

        @Override
        public MediaMetricsProvider[] buildArray(int size) {
          return new MediaMetricsProvider[size];
        }
    };


    private static final int INITIALIZE_ORDINAL = 0;

    private static final int ON_ERROR_ORDINAL = 1;

    private static final int SET_IS_EME_ORDINAL = 2;

    private static final int SET_TIME_TO_METADATA_ORDINAL = 3;

    private static final int SET_TIME_TO_FIRST_FRAME_ORDINAL = 4;

    private static final int SET_TIME_TO_PLAY_READY_ORDINAL = 5;

    private static final int ACQUIRE_WATCH_TIME_RECORDER_ORDINAL = 6;

    private static final int ACQUIRE_VIDEO_DECODE_STATS_RECORDER_ORDINAL = 7;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements MediaMetricsProvider.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void initialize(
boolean isMse, boolean isTopFrame, org.chromium.url.mojom.Origin untrustedTopOrigin) {

            MediaMetricsProviderInitializeParams _message = new MediaMetricsProviderInitializeParams();

            _message.isMse = isMse;

            _message.isTopFrame = isTopFrame;

            _message.untrustedTopOrigin = untrustedTopOrigin;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(INITIALIZE_ORDINAL)));

        }


        @Override
        public void onError(
int status) {

            MediaMetricsProviderOnErrorParams _message = new MediaMetricsProviderOnErrorParams();

            _message.status = status;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_ERROR_ORDINAL)));

        }


        @Override
        public void setIsEme(
) {

            MediaMetricsProviderSetIsEmeParams _message = new MediaMetricsProviderSetIsEmeParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SET_IS_EME_ORDINAL)));

        }


        @Override
        public void setTimeToMetadata(
org.chromium.mojo_base.mojom.TimeDelta elapsed) {

            MediaMetricsProviderSetTimeToMetadataParams _message = new MediaMetricsProviderSetTimeToMetadataParams();

            _message.elapsed = elapsed;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SET_TIME_TO_METADATA_ORDINAL)));

        }


        @Override
        public void setTimeToFirstFrame(
org.chromium.mojo_base.mojom.TimeDelta elapsed) {

            MediaMetricsProviderSetTimeToFirstFrameParams _message = new MediaMetricsProviderSetTimeToFirstFrameParams();

            _message.elapsed = elapsed;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SET_TIME_TO_FIRST_FRAME_ORDINAL)));

        }


        @Override
        public void setTimeToPlayReady(
org.chromium.mojo_base.mojom.TimeDelta elapsed) {

            MediaMetricsProviderSetTimeToPlayReadyParams _message = new MediaMetricsProviderSetTimeToPlayReadyParams();

            _message.elapsed = elapsed;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SET_TIME_TO_PLAY_READY_ORDINAL)));

        }


        @Override
        public void acquireWatchTimeRecorder(
PlaybackProperties properties, org.chromium.mojo.bindings.InterfaceRequest<WatchTimeRecorder> recorder) {

            MediaMetricsProviderAcquireWatchTimeRecorderParams _message = new MediaMetricsProviderAcquireWatchTimeRecorderParams();

            _message.properties = properties;

            _message.recorder = recorder;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ACQUIRE_WATCH_TIME_RECORDER_ORDINAL)));

        }


        @Override
        public void acquireVideoDecodeStatsRecorder(
org.chromium.mojo.bindings.InterfaceRequest<VideoDecodeStatsRecorder> recorder) {

            MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams _message = new MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams();

            _message.recorder = recorder;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ACQUIRE_VIDEO_DECODE_STATS_RECORDER_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<MediaMetricsProvider> {

        Stub(org.chromium.mojo.system.Core core, MediaMetricsProvider impl) {
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
                                MediaMetricsProvider_Internal.MANAGER, messageWithHeader);





                    case INITIALIZE_ORDINAL: {

                        MediaMetricsProviderInitializeParams data =
                                MediaMetricsProviderInitializeParams.deserialize(messageWithHeader.getPayload());

                        getImpl().initialize(data.isMse, data.isTopFrame, data.untrustedTopOrigin);
                        return true;
                    }





                    case ON_ERROR_ORDINAL: {

                        MediaMetricsProviderOnErrorParams data =
                                MediaMetricsProviderOnErrorParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onError(data.status);
                        return true;
                    }





                    case SET_IS_EME_ORDINAL: {

                        MediaMetricsProviderSetIsEmeParams.deserialize(messageWithHeader.getPayload());

                        getImpl().setIsEme();
                        return true;
                    }





                    case SET_TIME_TO_METADATA_ORDINAL: {

                        MediaMetricsProviderSetTimeToMetadataParams data =
                                MediaMetricsProviderSetTimeToMetadataParams.deserialize(messageWithHeader.getPayload());

                        getImpl().setTimeToMetadata(data.elapsed);
                        return true;
                    }





                    case SET_TIME_TO_FIRST_FRAME_ORDINAL: {

                        MediaMetricsProviderSetTimeToFirstFrameParams data =
                                MediaMetricsProviderSetTimeToFirstFrameParams.deserialize(messageWithHeader.getPayload());

                        getImpl().setTimeToFirstFrame(data.elapsed);
                        return true;
                    }





                    case SET_TIME_TO_PLAY_READY_ORDINAL: {

                        MediaMetricsProviderSetTimeToPlayReadyParams data =
                                MediaMetricsProviderSetTimeToPlayReadyParams.deserialize(messageWithHeader.getPayload());

                        getImpl().setTimeToPlayReady(data.elapsed);
                        return true;
                    }





                    case ACQUIRE_WATCH_TIME_RECORDER_ORDINAL: {

                        MediaMetricsProviderAcquireWatchTimeRecorderParams data =
                                MediaMetricsProviderAcquireWatchTimeRecorderParams.deserialize(messageWithHeader.getPayload());

                        getImpl().acquireWatchTimeRecorder(data.properties, data.recorder);
                        return true;
                    }





                    case ACQUIRE_VIDEO_DECODE_STATS_RECORDER_ORDINAL: {

                        MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams data =
                                MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams.deserialize(messageWithHeader.getPayload());

                        getImpl().acquireVideoDecodeStatsRecorder(data.recorder);
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
                                getCore(), MediaMetricsProvider_Internal.MANAGER, messageWithHeader, receiver);


















                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class MediaMetricsProviderInitializeParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean isMse;
        public boolean isTopFrame;
        public org.chromium.url.mojom.Origin untrustedTopOrigin;

        private MediaMetricsProviderInitializeParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaMetricsProviderInitializeParams() {
            this(0);
        }

        public static MediaMetricsProviderInitializeParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaMetricsProviderInitializeParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaMetricsProviderInitializeParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaMetricsProviderInitializeParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaMetricsProviderInitializeParams(elementsOrVersion);
                    {
                        
                    result.isMse = decoder0.readBoolean(8, 0);
                    }
                    {
                        
                    result.isTopFrame = decoder0.readBoolean(8, 1);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                    result.untrustedTopOrigin = org.chromium.url.mojom.Origin.decode(decoder1);
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
            
            encoder0.encode(this.isMse, 8, 0);
            
            encoder0.encode(this.isTopFrame, 8, 1);
            
            encoder0.encode(this.untrustedTopOrigin, 16, false);
        }
    }



    
    static final class MediaMetricsProviderOnErrorParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;

        private MediaMetricsProviderOnErrorParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaMetricsProviderOnErrorParams() {
            this(0);
        }

        public static MediaMetricsProviderOnErrorParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaMetricsProviderOnErrorParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaMetricsProviderOnErrorParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaMetricsProviderOnErrorParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaMetricsProviderOnErrorParams(elementsOrVersion);
                    {
                        
                    result.status = decoder0.readInt(8);
                        PipelineStatus.validate(result.status);
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
        }
    }



    
    static final class MediaMetricsProviderSetIsEmeParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private MediaMetricsProviderSetIsEmeParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaMetricsProviderSetIsEmeParams() {
            this(0);
        }

        public static MediaMetricsProviderSetIsEmeParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaMetricsProviderSetIsEmeParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaMetricsProviderSetIsEmeParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaMetricsProviderSetIsEmeParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaMetricsProviderSetIsEmeParams(elementsOrVersion);
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



    
    static final class MediaMetricsProviderSetTimeToMetadataParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo_base.mojom.TimeDelta elapsed;

        private MediaMetricsProviderSetTimeToMetadataParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaMetricsProviderSetTimeToMetadataParams() {
            this(0);
        }

        public static MediaMetricsProviderSetTimeToMetadataParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaMetricsProviderSetTimeToMetadataParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaMetricsProviderSetTimeToMetadataParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaMetricsProviderSetTimeToMetadataParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaMetricsProviderSetTimeToMetadataParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.elapsed = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
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
            
            encoder0.encode(this.elapsed, 8, false);
        }
    }



    
    static final class MediaMetricsProviderSetTimeToFirstFrameParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo_base.mojom.TimeDelta elapsed;

        private MediaMetricsProviderSetTimeToFirstFrameParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaMetricsProviderSetTimeToFirstFrameParams() {
            this(0);
        }

        public static MediaMetricsProviderSetTimeToFirstFrameParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaMetricsProviderSetTimeToFirstFrameParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaMetricsProviderSetTimeToFirstFrameParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaMetricsProviderSetTimeToFirstFrameParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaMetricsProviderSetTimeToFirstFrameParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.elapsed = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
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
            
            encoder0.encode(this.elapsed, 8, false);
        }
    }



    
    static final class MediaMetricsProviderSetTimeToPlayReadyParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo_base.mojom.TimeDelta elapsed;

        private MediaMetricsProviderSetTimeToPlayReadyParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaMetricsProviderSetTimeToPlayReadyParams() {
            this(0);
        }

        public static MediaMetricsProviderSetTimeToPlayReadyParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaMetricsProviderSetTimeToPlayReadyParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaMetricsProviderSetTimeToPlayReadyParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaMetricsProviderSetTimeToPlayReadyParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaMetricsProviderSetTimeToPlayReadyParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.elapsed = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
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
            
            encoder0.encode(this.elapsed, 8, false);
        }
    }



    
    static final class MediaMetricsProviderAcquireWatchTimeRecorderParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PlaybackProperties properties;
        public org.chromium.mojo.bindings.InterfaceRequest<WatchTimeRecorder> recorder;

        private MediaMetricsProviderAcquireWatchTimeRecorderParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaMetricsProviderAcquireWatchTimeRecorderParams() {
            this(0);
        }

        public static MediaMetricsProviderAcquireWatchTimeRecorderParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaMetricsProviderAcquireWatchTimeRecorderParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaMetricsProviderAcquireWatchTimeRecorderParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaMetricsProviderAcquireWatchTimeRecorderParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaMetricsProviderAcquireWatchTimeRecorderParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.properties = PlaybackProperties.decode(decoder1);
                    }
                    {
                        
                    result.recorder = decoder0.readInterfaceRequest(16, false);
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
            
            encoder0.encode(this.properties, 8, false);
            
            encoder0.encode(this.recorder, 16, false);
        }
    }



    
    static final class MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<VideoDecodeStatsRecorder> recorder;

        private MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams() {
            this(0);
        }

        public static MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaMetricsProviderAcquireVideoDecodeStatsRecorderParams(elementsOrVersion);
                    {
                        
                    result.recorder = decoder0.readInterfaceRequest(8, false);
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
            
            encoder0.encode(this.recorder, 8, false);
        }
    }



}
