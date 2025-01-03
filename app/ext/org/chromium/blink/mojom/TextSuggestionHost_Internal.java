
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/platform/input_host.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


class TextSuggestionHost_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<TextSuggestionHost, TextSuggestionHost.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<TextSuggestionHost, TextSuggestionHost.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.TextSuggestionHost";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, TextSuggestionHost impl) {
            return new Stub(core, impl);
        }

        @Override
        public TextSuggestionHost[] buildArray(int size) {
          return new TextSuggestionHost[size];
        }
    };


    private static final int START_SUGGESTION_MENU_TIMER_ORDINAL = 0;

    private static final int SHOW_SPELL_CHECK_SUGGESTION_MENU_ORDINAL = 1;

    private static final int SHOW_TEXT_SUGGESTION_MENU_ORDINAL = 2;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements TextSuggestionHost.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void startSuggestionMenuTimer(
) {

            TextSuggestionHostStartSuggestionMenuTimerParams _message = new TextSuggestionHostStartSuggestionMenuTimerParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(START_SUGGESTION_MENU_TIMER_ORDINAL)));

        }


        @Override
        public void showSpellCheckSuggestionMenu(
double caretX, double caretY, String markedText, SpellCheckSuggestion[] suggestions) {

            TextSuggestionHostShowSpellCheckSuggestionMenuParams _message = new TextSuggestionHostShowSpellCheckSuggestionMenuParams();

            _message.caretX = caretX;

            _message.caretY = caretY;

            _message.markedText = markedText;

            _message.suggestions = suggestions;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SHOW_SPELL_CHECK_SUGGESTION_MENU_ORDINAL)));

        }


        @Override
        public void showTextSuggestionMenu(
double caretX, double caretY, String markedText, TextSuggestion[] suggestions) {

            TextSuggestionHostShowTextSuggestionMenuParams _message = new TextSuggestionHostShowTextSuggestionMenuParams();

            _message.caretX = caretX;

            _message.caretY = caretY;

            _message.markedText = markedText;

            _message.suggestions = suggestions;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SHOW_TEXT_SUGGESTION_MENU_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<TextSuggestionHost> {

        Stub(org.chromium.mojo.system.Core core, TextSuggestionHost impl) {
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
                                TextSuggestionHost_Internal.MANAGER, messageWithHeader);





                    case START_SUGGESTION_MENU_TIMER_ORDINAL: {

                        TextSuggestionHostStartSuggestionMenuTimerParams.deserialize(messageWithHeader.getPayload());

                        getImpl().startSuggestionMenuTimer();
                        return true;
                    }





                    case SHOW_SPELL_CHECK_SUGGESTION_MENU_ORDINAL: {

                        TextSuggestionHostShowSpellCheckSuggestionMenuParams data =
                                TextSuggestionHostShowSpellCheckSuggestionMenuParams.deserialize(messageWithHeader.getPayload());

                        getImpl().showSpellCheckSuggestionMenu(data.caretX, data.caretY, data.markedText, data.suggestions);
                        return true;
                    }





                    case SHOW_TEXT_SUGGESTION_MENU_ORDINAL: {

                        TextSuggestionHostShowTextSuggestionMenuParams data =
                                TextSuggestionHostShowTextSuggestionMenuParams.deserialize(messageWithHeader.getPayload());

                        getImpl().showTextSuggestionMenu(data.caretX, data.caretY, data.markedText, data.suggestions);
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
                                getCore(), TextSuggestionHost_Internal.MANAGER, messageWithHeader, receiver);








                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class TextSuggestionHostStartSuggestionMenuTimerParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private TextSuggestionHostStartSuggestionMenuTimerParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TextSuggestionHostStartSuggestionMenuTimerParams() {
            this(0);
        }

        public static TextSuggestionHostStartSuggestionMenuTimerParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TextSuggestionHostStartSuggestionMenuTimerParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TextSuggestionHostStartSuggestionMenuTimerParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TextSuggestionHostStartSuggestionMenuTimerParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionHostStartSuggestionMenuTimerParams(elementsOrVersion);
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



    
    static final class TextSuggestionHostShowSpellCheckSuggestionMenuParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public double caretX;
        public double caretY;
        public String markedText;
        public SpellCheckSuggestion[] suggestions;

        private TextSuggestionHostShowSpellCheckSuggestionMenuParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TextSuggestionHostShowSpellCheckSuggestionMenuParams() {
            this(0);
        }

        public static TextSuggestionHostShowSpellCheckSuggestionMenuParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TextSuggestionHostShowSpellCheckSuggestionMenuParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TextSuggestionHostShowSpellCheckSuggestionMenuParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TextSuggestionHostShowSpellCheckSuggestionMenuParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionHostShowSpellCheckSuggestionMenuParams(elementsOrVersion);
                    {
                        
                    result.caretX = decoder0.readDouble(8);
                    }
                    {
                        
                    result.caretY = decoder0.readDouble(16);
                    }
                    {
                        
                    result.markedText = decoder0.readString(24, false);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                    {
                        org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                        result.suggestions = new SpellCheckSuggestion[si1.elementsOrVersion];
                        for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                            
                            org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                            result.suggestions[i1] = SpellCheckSuggestion.decode(decoder2);
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
            
            encoder0.encode(this.caretX, 8);
            
            encoder0.encode(this.caretY, 16);
            
            encoder0.encode(this.markedText, 24, false);
            
            if (this.suggestions == null) {
                encoder0.encodeNullPointer(32, false);
            } else {
                org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.suggestions.length, 32, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i0 = 0; i0 < this.suggestions.length; ++i0) {
                    
                    encoder1.encode(this.suggestions[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
                }
            }
        }
    }



    
    static final class TextSuggestionHostShowTextSuggestionMenuParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 40;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(40, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public double caretX;
        public double caretY;
        public String markedText;
        public TextSuggestion[] suggestions;

        private TextSuggestionHostShowTextSuggestionMenuParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public TextSuggestionHostShowTextSuggestionMenuParams() {
            this(0);
        }

        public static TextSuggestionHostShowTextSuggestionMenuParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static TextSuggestionHostShowTextSuggestionMenuParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static TextSuggestionHostShowTextSuggestionMenuParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            TextSuggestionHostShowTextSuggestionMenuParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new TextSuggestionHostShowTextSuggestionMenuParams(elementsOrVersion);
                    {
                        
                    result.caretX = decoder0.readDouble(8);
                    }
                    {
                        
                    result.caretY = decoder0.readDouble(16);
                    }
                    {
                        
                    result.markedText = decoder0.readString(24, false);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                    {
                        org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                        result.suggestions = new TextSuggestion[si1.elementsOrVersion];
                        for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                            
                            org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                            result.suggestions[i1] = TextSuggestion.decode(decoder2);
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
            
            encoder0.encode(this.caretX, 8);
            
            encoder0.encode(this.caretY, 16);
            
            encoder0.encode(this.markedText, 24, false);
            
            if (this.suggestions == null) {
                encoder0.encodeNullPointer(32, false);
            } else {
                org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.suggestions.length, 32, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i0 = 0; i0 < this.suggestions.length; ++i0) {
                    
                    encoder1.encode(this.suggestions[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
                }
            }
        }
    }



}
