// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/search/now/proto/wire/feed/feed_stream.proto

package com.google.search.now.wire.feed;

public final class FeedStreamProto {
  private FeedStreamProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface FeedStreamOrBuilder extends
      // @@protoc_insertion_point(interface_extends:search.now.proto.wire.feed.FeedStream)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
     */
    boolean hasPietSharedState();
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
     */
    com.google.search.now.ui.piet.PietProto.PietSharedState getPietSharedState();

    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    java.util.List<com.google.search.now.wire.feed.FeedCardProto.FeedCard> 
        getCardsList();
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    com.google.search.now.wire.feed.FeedCardProto.FeedCard getCards(int index);
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    int getCardsCount();
  }
  /**
   * <pre>
   * Representation of the entire stream of data in the feed
   * </pre>
   *
   * Protobuf type {@code search.now.proto.wire.feed.FeedStream}
   */
  public  static final class FeedStream extends
      com.google.protobuf.GeneratedMessageLite<
          FeedStream, FeedStream.Builder> implements
      // @@protoc_insertion_point(message_implements:search.now.proto.wire.feed.FeedStream)
      FeedStreamOrBuilder {
    private FeedStream() {
      cards_ = emptyProtobufList();
    }
    private int bitField0_;
    public static final int PIET_SHARED_STATE_FIELD_NUMBER = 1;
    private com.google.search.now.ui.piet.PietProto.PietSharedState pietSharedState_;
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
     */
    public boolean hasPietSharedState() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
     */
    public com.google.search.now.ui.piet.PietProto.PietSharedState getPietSharedState() {
      return pietSharedState_ == null ? com.google.search.now.ui.piet.PietProto.PietSharedState.getDefaultInstance() : pietSharedState_;
    }
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
     */
    private void setPietSharedState(com.google.search.now.ui.piet.PietProto.PietSharedState value) {
      if (value == null) {
        throw new NullPointerException();
      }
      pietSharedState_ = value;
      bitField0_ |= 0x00000001;
      }
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
     */
    private void setPietSharedState(
        com.google.search.now.ui.piet.PietProto.PietSharedState.Builder builderForValue) {
      pietSharedState_ = builderForValue.build();
      bitField0_ |= 0x00000001;
    }
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
     */
    private void mergePietSharedState(com.google.search.now.ui.piet.PietProto.PietSharedState value) {
      if (pietSharedState_ != null &&
          pietSharedState_ != com.google.search.now.ui.piet.PietProto.PietSharedState.getDefaultInstance()) {
        pietSharedState_ =
          com.google.search.now.ui.piet.PietProto.PietSharedState.newBuilder(pietSharedState_).mergeFrom(value).buildPartial();
      } else {
        pietSharedState_ = value;
      }
      bitField0_ |= 0x00000001;
    }
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
     */
    private void clearPietSharedState() {  pietSharedState_ = null;
      bitField0_ = (bitField0_ & ~0x00000001);
    }

    public static final int CARDS_FIELD_NUMBER = 2;
    private com.google.protobuf.Internal.ProtobufList<com.google.search.now.wire.feed.FeedCardProto.FeedCard> cards_;
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    public java.util.List<com.google.search.now.wire.feed.FeedCardProto.FeedCard> getCardsList() {
      return cards_;
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    public java.util.List<? extends com.google.search.now.wire.feed.FeedCardProto.FeedCardOrBuilder> 
        getCardsOrBuilderList() {
      return cards_;
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    public int getCardsCount() {
      return cards_.size();
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    public com.google.search.now.wire.feed.FeedCardProto.FeedCard getCards(int index) {
      return cards_.get(index);
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    public com.google.search.now.wire.feed.FeedCardProto.FeedCardOrBuilder getCardsOrBuilder(
        int index) {
      return cards_.get(index);
    }
    private void ensureCardsIsMutable() {
      if (!cards_.isModifiable()) {
        cards_ =
            com.google.protobuf.GeneratedMessageLite.mutableCopy(cards_);
       }
    }

    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    private void setCards(
        int index, com.google.search.now.wire.feed.FeedCardProto.FeedCard value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureCardsIsMutable();
      cards_.set(index, value);
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    private void setCards(
        int index, com.google.search.now.wire.feed.FeedCardProto.FeedCard.Builder builderForValue) {
      ensureCardsIsMutable();
      cards_.set(index, builderForValue.build());
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    private void addCards(com.google.search.now.wire.feed.FeedCardProto.FeedCard value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureCardsIsMutable();
      cards_.add(value);
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    private void addCards(
        int index, com.google.search.now.wire.feed.FeedCardProto.FeedCard value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureCardsIsMutable();
      cards_.add(index, value);
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    private void addCards(
        com.google.search.now.wire.feed.FeedCardProto.FeedCard.Builder builderForValue) {
      ensureCardsIsMutable();
      cards_.add(builderForValue.build());
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    private void addCards(
        int index, com.google.search.now.wire.feed.FeedCardProto.FeedCard.Builder builderForValue) {
      ensureCardsIsMutable();
      cards_.add(index, builderForValue.build());
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    private void addAllCards(
        java.lang.Iterable<? extends com.google.search.now.wire.feed.FeedCardProto.FeedCard> values) {
      ensureCardsIsMutable();
      com.google.protobuf.AbstractMessageLite.addAll(
          values, cards_);
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    private void clearCards() {
      cards_ = emptyProtobufList();
    }
    /**
     * <pre>
     * List of cards within the stream
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
     */
    private void removeCards(int index) {
      ensureCardsIsMutable();
      cards_.remove(index);
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeMessage(1, getPietSharedState());
      }
      for (int i = 0; i < cards_.size(); i++) {
        output.writeMessage(2, cards_.get(i));
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getPietSharedState());
      }
      for (int i = 0; i < cards_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, cards_.get(i));
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.google.search.now.wire.feed.FeedStreamProto.FeedStream prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * <pre>
     * Representation of the entire stream of data in the feed
     * </pre>
     *
     * Protobuf type {@code search.now.proto.wire.feed.FeedStream}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.google.search.now.wire.feed.FeedStreamProto.FeedStream, Builder> implements
        // @@protoc_insertion_point(builder_implements:search.now.proto.wire.feed.FeedStream)
        com.google.search.now.wire.feed.FeedStreamProto.FeedStreamOrBuilder {
      // Construct using com.google.search.now.wire.feed.FeedStreamProto.FeedStream.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <pre>
       * Shared state for all Piet cards
       * </pre>
       *
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
       */
      public boolean hasPietSharedState() {
        return instance.hasPietSharedState();
      }
      /**
       * <pre>
       * Shared state for all Piet cards
       * </pre>
       *
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
       */
      public com.google.search.now.ui.piet.PietProto.PietSharedState getPietSharedState() {
        return instance.getPietSharedState();
      }
      /**
       * <pre>
       * Shared state for all Piet cards
       * </pre>
       *
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
       */
      public Builder setPietSharedState(com.google.search.now.ui.piet.PietProto.PietSharedState value) {
        copyOnWrite();
        instance.setPietSharedState(value);
        return this;
        }
      /**
       * <pre>
       * Shared state for all Piet cards
       * </pre>
       *
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
       */
      public Builder setPietSharedState(
          com.google.search.now.ui.piet.PietProto.PietSharedState.Builder builderForValue) {
        copyOnWrite();
        instance.setPietSharedState(builderForValue);
        return this;
      }
      /**
       * <pre>
       * Shared state for all Piet cards
       * </pre>
       *
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
       */
      public Builder mergePietSharedState(com.google.search.now.ui.piet.PietProto.PietSharedState value) {
        copyOnWrite();
        instance.mergePietSharedState(value);
        return this;
      }
      /**
       * <pre>
       * Shared state for all Piet cards
       * </pre>
       *
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 1;</code>
       */
      public Builder clearPietSharedState() {  copyOnWrite();
        instance.clearPietSharedState();
        return this;
      }

      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public java.util.List<com.google.search.now.wire.feed.FeedCardProto.FeedCard> getCardsList() {
        return java.util.Collections.unmodifiableList(
            instance.getCardsList());
      }
      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public int getCardsCount() {
        return instance.getCardsCount();
      }/**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public com.google.search.now.wire.feed.FeedCardProto.FeedCard getCards(int index) {
        return instance.getCards(index);
      }
      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public Builder setCards(
          int index, com.google.search.now.wire.feed.FeedCardProto.FeedCard value) {
        copyOnWrite();
        instance.setCards(index, value);
        return this;
      }
      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public Builder setCards(
          int index, com.google.search.now.wire.feed.FeedCardProto.FeedCard.Builder builderForValue) {
        copyOnWrite();
        instance.setCards(index, builderForValue);
        return this;
      }
      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public Builder addCards(com.google.search.now.wire.feed.FeedCardProto.FeedCard value) {
        copyOnWrite();
        instance.addCards(value);
        return this;
      }
      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public Builder addCards(
          int index, com.google.search.now.wire.feed.FeedCardProto.FeedCard value) {
        copyOnWrite();
        instance.addCards(index, value);
        return this;
      }
      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public Builder addCards(
          com.google.search.now.wire.feed.FeedCardProto.FeedCard.Builder builderForValue) {
        copyOnWrite();
        instance.addCards(builderForValue);
        return this;
      }
      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public Builder addCards(
          int index, com.google.search.now.wire.feed.FeedCardProto.FeedCard.Builder builderForValue) {
        copyOnWrite();
        instance.addCards(index, builderForValue);
        return this;
      }
      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public Builder addAllCards(
          java.lang.Iterable<? extends com.google.search.now.wire.feed.FeedCardProto.FeedCard> values) {
        copyOnWrite();
        instance.addAllCards(values);
        return this;
      }
      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public Builder clearCards() {
        copyOnWrite();
        instance.clearCards();
        return this;
      }
      /**
       * <pre>
       * List of cards within the stream
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedCard cards = 2;</code>
       */
      public Builder removeCards(int index) {
        copyOnWrite();
        instance.removeCards(index);
        return this;
      }

      // @@protoc_insertion_point(builder_scope:search.now.proto.wire.feed.FeedStream)
    }
    private byte memoizedIsInitialized = -1;
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0, java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new com.google.search.now.wire.feed.FeedStreamProto.FeedStream();
        }
        case IS_INITIALIZED: {
          byte isInitialized = memoizedIsInitialized;
          if (isInitialized == 1) return DEFAULT_INSTANCE;
          if (isInitialized == 0) return null;

          boolean shouldMemoize = ((Boolean) arg0).booleanValue();
          if (hasPietSharedState()) {
            if (!getPietSharedState().isInitialized()) {
              if (shouldMemoize) {
                memoizedIsInitialized = 0;
              }
              return null;
            }
          }
          for (int i = 0; i < getCardsCount(); i++) {
            if (!getCards(i).isInitialized()) {
              if (shouldMemoize) {
                memoizedIsInitialized = 0;
              }
              return null;
            }
          }
          if (shouldMemoize) memoizedIsInitialized = 1;
          return DEFAULT_INSTANCE;

        }
        case MAKE_IMMUTABLE: {
          cards_.makeImmutable();
          return null;
        }
        case NEW_BUILDER: {
          return new Builder();
        }
        case VISIT: {
          Visitor visitor = (Visitor) arg0;
          com.google.search.now.wire.feed.FeedStreamProto.FeedStream other = (com.google.search.now.wire.feed.FeedStreamProto.FeedStream) arg1;
          pietSharedState_ = visitor.visitMessage(pietSharedState_, other.pietSharedState_);
          cards_= visitor.visitList(cards_, other.cards_);
          if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
              .INSTANCE) {
            bitField0_ |= other.bitField0_;
          }
          return this;
        }
        case MERGE_FROM_STREAM: {
          com.google.protobuf.CodedInputStream input =
              (com.google.protobuf.CodedInputStream) arg0;
          com.google.protobuf.ExtensionRegistryLite extensionRegistry =
              (com.google.protobuf.ExtensionRegistryLite) arg1;
          try {
            boolean done = false;
            while (!done) {
              int tag = input.readTag();
              switch (tag) {
                case 0:
                  done = true;
                  break;
                default: {
                  if (!parseUnknownField(tag, input)) {
                    done = true;
                  }
                  break;
                }
                case 10: {
                  com.google.search.now.ui.piet.PietProto.PietSharedState.Builder subBuilder = null;
                  if (((bitField0_ & 0x00000001) == 0x00000001)) {
                    subBuilder = pietSharedState_.toBuilder();
                  }
                  pietSharedState_ = input.readMessage(com.google.search.now.ui.piet.PietProto.PietSharedState.parser(), extensionRegistry);
                  if (subBuilder != null) {
                    subBuilder.mergeFrom(pietSharedState_);
                    pietSharedState_ = subBuilder.buildPartial();
                  }
                  bitField0_ |= 0x00000001;
                  break;
                }
                case 18: {
                  if (!cards_.isModifiable()) {
                    cards_ =
                        com.google.protobuf.GeneratedMessageLite.mutableCopy(cards_);
                  }
                  cards_.add(
                      input.readMessage(com.google.search.now.wire.feed.FeedCardProto.FeedCard.parser(), extensionRegistry));
                  break;
                }
              }
            }
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw new RuntimeException(e.setUnfinishedMessage(this));
          } catch (java.io.IOException e) {
            throw new RuntimeException(
                new com.google.protobuf.InvalidProtocolBufferException(
                    e.getMessage()).setUnfinishedMessage(this));
          } finally {
          }
        }
        // fall through
        case GET_DEFAULT_INSTANCE: {
          return DEFAULT_INSTANCE;
        }
        case GET_PARSER: {
          if (PARSER == null) {    synchronized (com.google.search.now.wire.feed.FeedStreamProto.FeedStream.class) {
              if (PARSER == null) {
                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
              }
            }
          }
          return PARSER;
        }
      }
      throw new UnsupportedOperationException();
    }


    // @@protoc_insertion_point(class_scope:search.now.proto.wire.feed.FeedStream)
    private static final com.google.search.now.wire.feed.FeedStreamProto.FeedStream DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new FeedStream();
      DEFAULT_INSTANCE.makeImmutable();
    }

    public static com.google.search.now.wire.feed.FeedStreamProto.FeedStream getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<FeedStream> PARSER;

    public static com.google.protobuf.Parser<FeedStream> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
