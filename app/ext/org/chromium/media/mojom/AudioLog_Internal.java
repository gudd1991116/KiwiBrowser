
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/interfaces/audio_logging.mojom
//

package org.chromium.media.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class AudioLog_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<AudioLog, AudioLog.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<AudioLog, AudioLog.Proxy>() {

        @Override
        public String getName() {
            return "media.mojom.AudioLog";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, AudioLog impl) {
            return new Stub(core, impl);
        }

        @Override
        public AudioLog[] buildArray(int size) {
          return new AudioLog[size];
        }
    };


    private static final int ON_CREATED_ORDINAL = 0;

    private static final int ON_STARTED_ORDINAL = 1;

    private static final int ON_STOPPED_ORDINAL = 2;

    private static final int ON_CLOSED_ORDINAL = 3;

    private static final int ON_ERROR_ORDINAL = 4;

    private static final int ON_SET_VOLUME_ORDINAL = 5;

    private static final int ON_LOG_MESSAGE_ORDINAL = 6;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements AudioLog.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void onCreated(
AudioParameters params, String deviceId) {

            AudioLogOnCreatedParams _message = new AudioLogOnCreatedParams();

            _message.params = params;

            _message.deviceId = deviceId;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_CREATED_ORDINAL)));

        }


        @Override
        public void onStarted(
) {

            AudioLogOnStartedParams _message = new AudioLogOnStartedParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_STARTED_ORDINAL)));

        }


        @Override
        public void onStopped(
) {

            AudioLogOnStoppedParams _message = new AudioLogOnStoppedParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_STOPPED_ORDINAL)));

        }


        @Override
        public void onClosed(
) {

            AudioLogOnClosedParams _message = new AudioLogOnClosedParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_CLOSED_ORDINAL)));

        }


        @Override
        public void onError(
) {

            AudioLogOnErrorParams _message = new AudioLogOnErrorParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_ERROR_ORDINAL)));

        }


        @Override
        public void onSetVolume(
double volume) {

            AudioLogOnSetVolumeParams _message = new AudioLogOnSetVolumeParams();

            _message.volume = volume;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_SET_VOLUME_ORDINAL)));

        }


        @Override
        public void onLogMessage(
String message) {

            AudioLogOnLogMessageParams _message = new AudioLogOnLogMessageParams();

            _message.message = message;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ON_LOG_MESSAGE_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<AudioLog> {

        Stub(org.chromium.mojo.system.Core core, AudioLog impl) {
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
                                AudioLog_Internal.MANAGER, messageWithHeader);





                    case ON_CREATED_ORDINAL: {

                        AudioLogOnCreatedParams data =
                                AudioLogOnCreatedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onCreated(data.params, data.deviceId);
                        return true;
                    }





                    case ON_STARTED_ORDINAL: {

                        AudioLogOnStartedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onStarted();
                        return true;
                    }





                    case ON_STOPPED_ORDINAL: {

                        AudioLogOnStoppedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onStopped();
                        return true;
                    }





                    case ON_CLOSED_ORDINAL: {

                        AudioLogOnClosedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onClosed();
                        return true;
                    }





                    case ON_ERROR_ORDINAL: {

                        AudioLogOnErrorParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onError();
                        return true;
                    }





                    case ON_SET_VOLUME_ORDINAL: {

                        AudioLogOnSetVolumeParams data =
                                AudioLogOnSetVolumeParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onSetVolume(data.volume);
                        return true;
                    }





                    case ON_LOG_MESSAGE_ORDINAL: {

                        AudioLogOnLogMessageParams data =
                                AudioLogOnLogMessageParams.deserialize(messageWithHeader.getPayload());

                        getImpl().onLogMessage(data.message);
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
                                getCore(), AudioLog_Internal.MANAGER, messageWithHeader, receiver);
















                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class AudioLogOnCreatedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public AudioParameters params;
        public String deviceId;

        private AudioLogOnCreatedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AudioLogOnCreatedParams() {
            this(0);
        }

        public static AudioLogOnCreatedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AudioLogOnCreatedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AudioLogOnCreatedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AudioLogOnCreatedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnCreatedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.params = AudioParameters.decode(decoder1);
                    }
                    {
                        
                    result.deviceId = decoder0.readString(16, false);
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
            
            encoder0.encode(this.params, 8, false);
            
            encoder0.encode(this.deviceId, 16, false);
        }
    }



    
    static final class AudioLogOnStartedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioLogOnStartedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AudioLogOnStartedParams() {
            this(0);
        }

        public static AudioLogOnStartedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AudioLogOnStartedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AudioLogOnStartedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AudioLogOnStartedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnStartedParams(elementsOrVersion);
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



    
    static final class AudioLogOnStoppedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioLogOnStoppedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AudioLogOnStoppedParams() {
            this(0);
        }

        public static AudioLogOnStoppedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AudioLogOnStoppedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AudioLogOnStoppedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AudioLogOnStoppedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnStoppedParams(elementsOrVersion);
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



    
    static final class AudioLogOnClosedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioLogOnClosedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AudioLogOnClosedParams() {
            this(0);
        }

        public static AudioLogOnClosedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AudioLogOnClosedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AudioLogOnClosedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AudioLogOnClosedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnClosedParams(elementsOrVersion);
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



    
    static final class AudioLogOnErrorParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AudioLogOnErrorParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AudioLogOnErrorParams() {
            this(0);
        }

        public static AudioLogOnErrorParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AudioLogOnErrorParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AudioLogOnErrorParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AudioLogOnErrorParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnErrorParams(elementsOrVersion);
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



    
    static final class AudioLogOnSetVolumeParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public double volume;

        private AudioLogOnSetVolumeParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AudioLogOnSetVolumeParams() {
            this(0);
        }

        public static AudioLogOnSetVolumeParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AudioLogOnSetVolumeParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AudioLogOnSetVolumeParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AudioLogOnSetVolumeParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnSetVolumeParams(elementsOrVersion);
                    {
                        
                    result.volume = decoder0.readDouble(8);
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
            
            encoder0.encode(this.volume, 8);
        }
    }



    
    static final class AudioLogOnLogMessageParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public String message;

        private AudioLogOnLogMessageParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AudioLogOnLogMessageParams() {
            this(0);
        }

        public static AudioLogOnLogMessageParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AudioLogOnLogMessageParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AudioLogOnLogMessageParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AudioLogOnLogMessageParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AudioLogOnLogMessageParams(elementsOrVersion);
                    {
                        
                    result.message = decoder0.readString(8, false);
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
            
            encoder0.encode(this.message, 8, false);
        }
    }



}
