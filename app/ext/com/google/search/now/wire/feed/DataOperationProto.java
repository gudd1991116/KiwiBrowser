// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/search/now/proto/wire/feed/data_operation.proto

package com.google.search.now.wire.feed;

public final class DataOperationProto {
  private DataOperationProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface DataOperationOrBuilder extends
      // @@protoc_insertion_point(interface_extends:search.now.proto.wire.feed.DataOperation)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     * The operation to perform on the data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.DataOperation.Operation operation = 1;</code>
     */
    boolean hasOperation();
    /**
     * <pre>
     * The operation to perform on the data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.DataOperation.Operation operation = 1;</code>
     */
    com.google.search.now.wire.feed.DataOperationProto.DataOperation.Operation getOperation();

    /**
     * <pre>
     * Data common to all payload types.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
     */
    boolean hasMetadata();
    /**
     * <pre>
     * Data common to all payload types.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
     */
    com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata getMetadata();

    /**
     * <pre>
     * A stream UI level feature such as a cluster or card.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
     */
    boolean hasFeature();
    /**
     * <pre>
     * A stream UI level feature such as a cluster or card.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
     */
    com.google.search.now.wire.feed.FeatureProto.Feature getFeature();

    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
     */
    boolean hasPietSharedState();
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
     */
    com.google.search.now.ui.piet.PietProto.PietSharedState getPietSharedState();

    public com.google.search.now.wire.feed.DataOperationProto.DataOperation.PayloadCase getPayloadCase();
  }
  /**
   * <pre>
   * An extensible operation to change the state of data on the client.
   * </pre>
   *
   * Protobuf type {@code search.now.proto.wire.feed.DataOperation}
   */
  public  static final class DataOperation extends
      com.google.protobuf.GeneratedMessageLite<
          DataOperation, DataOperation.Builder> implements
      // @@protoc_insertion_point(message_implements:search.now.proto.wire.feed.DataOperation)
      DataOperationOrBuilder {
    private DataOperation() {
    }
    /**
     * Protobuf enum {@code search.now.proto.wire.feed.DataOperation.Operation}
     */
    public enum Operation
        implements com.google.protobuf.Internal.EnumLite {
      /**
       * <code>UNKNOWN_OPERATION = 0;</code>
       */
      UNKNOWN_OPERATION(0),
      /**
       * <pre>
       * Remove all stored content of all types
       * </pre>
       *
       * <code>CLEAR_ALL = 1;</code>
       */
      CLEAR_ALL(1),
      /**
       * <pre>
       * Update content if it exists, else append to the bottom of the feed
       * </pre>
       *
       * <code>UPDATE_OR_APPEND = 2;</code>
       */
      UPDATE_OR_APPEND(2),
      /**
       * <pre>
       * Remove the item from the stream
       * </pre>
       *
       * <code>REMOVE = 3;</code>
       */
      REMOVE(3),
      ;

      /**
       * <code>UNKNOWN_OPERATION = 0;</code>
       */
      public static final int UNKNOWN_OPERATION_VALUE = 0;
      /**
       * <pre>
       * Remove all stored content of all types
       * </pre>
       *
       * <code>CLEAR_ALL = 1;</code>
       */
      public static final int CLEAR_ALL_VALUE = 1;
      /**
       * <pre>
       * Update content if it exists, else append to the bottom of the feed
       * </pre>
       *
       * <code>UPDATE_OR_APPEND = 2;</code>
       */
      public static final int UPDATE_OR_APPEND_VALUE = 2;
      /**
       * <pre>
       * Remove the item from the stream
       * </pre>
       *
       * <code>REMOVE = 3;</code>
       */
      public static final int REMOVE_VALUE = 3;


      public final int getNumber() {
        return value;
      }

      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static Operation valueOf(int value) {
        return forNumber(value);
      }

      public static Operation forNumber(int value) {
        switch (value) {
          case 0: return UNKNOWN_OPERATION;
          case 1: return CLEAR_ALL;
          case 2: return UPDATE_OR_APPEND;
          case 3: return REMOVE;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<Operation>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          Operation> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<Operation>() {
              public Operation findValueByNumber(int number) {
                return Operation.forNumber(number);
              }
            };

      private final int value;

      private Operation(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:search.now.proto.wire.feed.DataOperation.Operation)
    }

    private int bitField0_;
    private int payloadCase_ = 0;
    private java.lang.Object payload_;
    public enum PayloadCase
        implements com.google.protobuf.Internal.EnumLite {
      FEATURE(3),
      PIET_SHARED_STATE(4),
      PAYLOAD_NOT_SET(0);
      private final int value;
      private PayloadCase(int value) {
        this.value = value;
      }
      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static PayloadCase valueOf(int value) {
        return forNumber(value);
      }

      public static PayloadCase forNumber(int value) {
        switch (value) {
          case 3: return FEATURE;
          case 4: return PIET_SHARED_STATE;
          case 0: return PAYLOAD_NOT_SET;
          default: return null;
        }
      }
      public int getNumber() {
        return this.value;
      }
    };

    public PayloadCase
    getPayloadCase() {
      return PayloadCase.forNumber(
          payloadCase_);
    }

    private void clearPayload() {
      payloadCase_ = 0;
      payload_ = null;
    }

    public static final int OPERATION_FIELD_NUMBER = 1;
    private int operation_;
    /**
     * <pre>
     * The operation to perform on the data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.DataOperation.Operation operation = 1;</code>
     */
    public boolean hasOperation() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * The operation to perform on the data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.DataOperation.Operation operation = 1;</code>
     */
    public com.google.search.now.wire.feed.DataOperationProto.DataOperation.Operation getOperation() {
      com.google.search.now.wire.feed.DataOperationProto.DataOperation.Operation result = com.google.search.now.wire.feed.DataOperationProto.DataOperation.Operation.forNumber(operation_);
      return result == null ? com.google.search.now.wire.feed.DataOperationProto.DataOperation.Operation.UNKNOWN_OPERATION : result;
    }
    /**
     * <pre>
     * The operation to perform on the data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.DataOperation.Operation operation = 1;</code>
     */
    private void setOperation(com.google.search.now.wire.feed.DataOperationProto.DataOperation.Operation value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      operation_ = value.getNumber();
    }
    /**
     * <pre>
     * The operation to perform on the data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.DataOperation.Operation operation = 1;</code>
     */
    private void clearOperation() {
      bitField0_ = (bitField0_ & ~0x00000001);
      operation_ = 0;
    }

    public static final int METADATA_FIELD_NUMBER = 2;
    private com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata metadata_;
    /**
     * <pre>
     * Data common to all payload types.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
     */
    public boolean hasMetadata() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * Data common to all payload types.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
     */
    public com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata getMetadata() {
      return metadata_ == null ? com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata.getDefaultInstance() : metadata_;
    }
    /**
     * <pre>
     * Data common to all payload types.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
     */
    private void setMetadata(com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata value) {
      if (value == null) {
        throw new NullPointerException();
      }
      metadata_ = value;
      bitField0_ |= 0x00000002;
      }
    /**
     * <pre>
     * Data common to all payload types.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
     */
    private void setMetadata(
        com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata.Builder builderForValue) {
      metadata_ = builderForValue.build();
      bitField0_ |= 0x00000002;
    }
    /**
     * <pre>
     * Data common to all payload types.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
     */
    private void mergeMetadata(com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata value) {
      if (metadata_ != null &&
          metadata_ != com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata.getDefaultInstance()) {
        metadata_ =
          com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata.newBuilder(metadata_).mergeFrom(value).buildPartial();
      } else {
        metadata_ = value;
      }
      bitField0_ |= 0x00000002;
    }
    /**
     * <pre>
     * Data common to all payload types.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
     */
    private void clearMetadata() {  metadata_ = null;
      bitField0_ = (bitField0_ & ~0x00000002);
    }

    public static final int FEATURE_FIELD_NUMBER = 3;
    /**
     * <pre>
     * A stream UI level feature such as a cluster or card.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
     */
    public boolean hasFeature() {
      return payloadCase_ == 3;
    }
    /**
     * <pre>
     * A stream UI level feature such as a cluster or card.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
     */
    public com.google.search.now.wire.feed.FeatureProto.Feature getFeature() {
      if (payloadCase_ == 3) {
         return (com.google.search.now.wire.feed.FeatureProto.Feature) payload_;
      }
      return com.google.search.now.wire.feed.FeatureProto.Feature.getDefaultInstance();
    }
    /**
     * <pre>
     * A stream UI level feature such as a cluster or card.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
     */
    private void setFeature(com.google.search.now.wire.feed.FeatureProto.Feature value) {
      if (value == null) {
        throw new NullPointerException();
      }
      payload_ = value;
      payloadCase_ = 3;
    }
    /**
     * <pre>
     * A stream UI level feature such as a cluster or card.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
     */
    private void setFeature(
        com.google.search.now.wire.feed.FeatureProto.Feature.Builder builderForValue) {
      payload_ = builderForValue.build();
      payloadCase_ = 3;
    }
    /**
     * <pre>
     * A stream UI level feature such as a cluster or card.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
     */
    private void mergeFeature(com.google.search.now.wire.feed.FeatureProto.Feature value) {
      if (payloadCase_ == 3 &&
          payload_ != com.google.search.now.wire.feed.FeatureProto.Feature.getDefaultInstance()) {
        payload_ = com.google.search.now.wire.feed.FeatureProto.Feature.newBuilder((com.google.search.now.wire.feed.FeatureProto.Feature) payload_)
            .mergeFrom(value).buildPartial();
      } else {
        payload_ = value;
      }
      payloadCase_ = 3;
    }
    /**
     * <pre>
     * A stream UI level feature such as a cluster or card.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
     */
    private void clearFeature() {
      if (payloadCase_ == 3) {
        payloadCase_ = 0;
        payload_ = null;
      }
    }

    public static final int PIET_SHARED_STATE_FIELD_NUMBER = 4;
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
     */
    public boolean hasPietSharedState() {
      return payloadCase_ == 4;
    }
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
     */
    public com.google.search.now.ui.piet.PietProto.PietSharedState getPietSharedState() {
      if (payloadCase_ == 4) {
         return (com.google.search.now.ui.piet.PietProto.PietSharedState) payload_;
      }
      return com.google.search.now.ui.piet.PietProto.PietSharedState.getDefaultInstance();
    }
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
     */
    private void setPietSharedState(com.google.search.now.ui.piet.PietProto.PietSharedState value) {
      if (value == null) {
        throw new NullPointerException();
      }
      payload_ = value;
      payloadCase_ = 4;
    }
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
     */
    private void setPietSharedState(
        com.google.search.now.ui.piet.PietProto.PietSharedState.Builder builderForValue) {
      payload_ = builderForValue.build();
      payloadCase_ = 4;
    }
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
     */
    private void mergePietSharedState(com.google.search.now.ui.piet.PietProto.PietSharedState value) {
      if (payloadCase_ == 4 &&
          payload_ != com.google.search.now.ui.piet.PietProto.PietSharedState.getDefaultInstance()) {
        payload_ = com.google.search.now.ui.piet.PietProto.PietSharedState.newBuilder((com.google.search.now.ui.piet.PietProto.PietSharedState) payload_)
            .mergeFrom(value).buildPartial();
      } else {
        payload_ = value;
      }
      payloadCase_ = 4;
    }
    /**
     * <pre>
     * Shared state for all Piet cards
     * </pre>
     *
     * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
     */
    private void clearPietSharedState() {
      if (payloadCase_ == 4) {
        payloadCase_ = 0;
        payload_ = null;
      }
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, operation_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeMessage(2, getMetadata());
      }
      if (payloadCase_ == 3) {
        output.writeMessage(3, (com.google.search.now.wire.feed.FeatureProto.Feature) payload_);
      }
      if (payloadCase_ == 4) {
        output.writeMessage(4, (com.google.search.now.ui.piet.PietProto.PietSharedState) payload_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, operation_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getMetadata());
      }
      if (payloadCase_ == 3) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, (com.google.search.now.wire.feed.FeatureProto.Feature) payload_);
      }
      if (payloadCase_ == 4) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(4, (com.google.search.now.ui.piet.PietProto.PietSharedState) payload_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.google.search.now.wire.feed.DataOperationProto.DataOperation prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * <pre>
     * An extensible operation to change the state of data on the client.
     * </pre>
     *
     * Protobuf type {@code search.now.proto.wire.feed.DataOperation}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.google.search.now.wire.feed.DataOperationProto.DataOperation, Builder> implements
        // @@protoc_insertion_point(builder_implements:search.now.proto.wire.feed.DataOperation)
        com.google.search.now.wire.feed.DataOperationProto.DataOperationOrBuilder {
      // Construct using com.google.search.now.wire.feed.DataOperationProto.DataOperation.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }

      public PayloadCase
          getPayloadCase() {
        return instance.getPayloadCase();
      }

      public Builder clearPayload() {
        copyOnWrite();
        instance.clearPayload();
        return this;
      }


      /**
       * <pre>
       * The operation to perform on the data.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.DataOperation.Operation operation = 1;</code>
       */
      public boolean hasOperation() {
        return instance.hasOperation();
      }
      /**
       * <pre>
       * The operation to perform on the data.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.DataOperation.Operation operation = 1;</code>
       */
      public com.google.search.now.wire.feed.DataOperationProto.DataOperation.Operation getOperation() {
        return instance.getOperation();
      }
      /**
       * <pre>
       * The operation to perform on the data.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.DataOperation.Operation operation = 1;</code>
       */
      public Builder setOperation(com.google.search.now.wire.feed.DataOperationProto.DataOperation.Operation value) {
        copyOnWrite();
        instance.setOperation(value);
        return this;
      }
      /**
       * <pre>
       * The operation to perform on the data.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.DataOperation.Operation operation = 1;</code>
       */
      public Builder clearOperation() {
        copyOnWrite();
        instance.clearOperation();
        return this;
      }

      /**
       * <pre>
       * Data common to all payload types.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
       */
      public boolean hasMetadata() {
        return instance.hasMetadata();
      }
      /**
       * <pre>
       * Data common to all payload types.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
       */
      public com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata getMetadata() {
        return instance.getMetadata();
      }
      /**
       * <pre>
       * Data common to all payload types.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
       */
      public Builder setMetadata(com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata value) {
        copyOnWrite();
        instance.setMetadata(value);
        return this;
        }
      /**
       * <pre>
       * Data common to all payload types.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
       */
      public Builder setMetadata(
          com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata.Builder builderForValue) {
        copyOnWrite();
        instance.setMetadata(builderForValue);
        return this;
      }
      /**
       * <pre>
       * Data common to all payload types.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
       */
      public Builder mergeMetadata(com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata value) {
        copyOnWrite();
        instance.mergeMetadata(value);
        return this;
      }
      /**
       * <pre>
       * Data common to all payload types.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.PayloadMetadata metadata = 2;</code>
       */
      public Builder clearMetadata() {  copyOnWrite();
        instance.clearMetadata();
        return this;
      }

      /**
       * <pre>
       * A stream UI level feature such as a cluster or card.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
       */
      public boolean hasFeature() {
        return instance.hasFeature();
      }
      /**
       * <pre>
       * A stream UI level feature such as a cluster or card.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
       */
      public com.google.search.now.wire.feed.FeatureProto.Feature getFeature() {
        return instance.getFeature();
      }
      /**
       * <pre>
       * A stream UI level feature such as a cluster or card.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
       */
      public Builder setFeature(com.google.search.now.wire.feed.FeatureProto.Feature value) {
        copyOnWrite();
        instance.setFeature(value);
        return this;
      }
      /**
       * <pre>
       * A stream UI level feature such as a cluster or card.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
       */
      public Builder setFeature(
          com.google.search.now.wire.feed.FeatureProto.Feature.Builder builderForValue) {
        copyOnWrite();
        instance.setFeature(builderForValue);
        return this;
      }
      /**
       * <pre>
       * A stream UI level feature such as a cluster or card.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
       */
      public Builder mergeFeature(com.google.search.now.wire.feed.FeatureProto.Feature value) {
        copyOnWrite();
        instance.mergeFeature(value);
        return this;
      }
      /**
       * <pre>
       * A stream UI level feature such as a cluster or card.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.Feature feature = 3;</code>
       */
      public Builder clearFeature() {
        copyOnWrite();
        instance.clearFeature();
        return this;
      }

      /**
       * <pre>
       * Shared state for all Piet cards
       * </pre>
       *
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
       */
      public boolean hasPietSharedState() {
        return instance.hasPietSharedState();
      }
      /**
       * <pre>
       * Shared state for all Piet cards
       * </pre>
       *
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
       */
      public com.google.search.now.ui.piet.PietProto.PietSharedState getPietSharedState() {
        return instance.getPietSharedState();
      }
      /**
       * <pre>
       * Shared state for all Piet cards
       * </pre>
       *
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
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
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
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
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
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
       * <code>optional .search.now.ui.piet.PietSharedState piet_shared_state = 4;</code>
       */
      public Builder clearPietSharedState() {
        copyOnWrite();
        instance.clearPietSharedState();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:search.now.proto.wire.feed.DataOperation)
    }
    private byte memoizedIsInitialized = -1;
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0, java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new com.google.search.now.wire.feed.DataOperationProto.DataOperation();
        }
        case IS_INITIALIZED: {
          byte isInitialized = memoizedIsInitialized;
          if (isInitialized == 1) return DEFAULT_INSTANCE;
          if (isInitialized == 0) return null;

          boolean shouldMemoize = ((Boolean) arg0).booleanValue();
          if (hasFeature()) {
            if (!getFeature().isInitialized()) {
              if (shouldMemoize) {
                memoizedIsInitialized = 0;
              }
              return null;
            }
          }
          if (hasPietSharedState()) {
            if (!getPietSharedState().isInitialized()) {
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
          return null;
        }
        case NEW_BUILDER: {
          return new Builder();
        }
        case VISIT: {
          Visitor visitor = (Visitor) arg0;
          com.google.search.now.wire.feed.DataOperationProto.DataOperation other = (com.google.search.now.wire.feed.DataOperationProto.DataOperation) arg1;
          operation_ = visitor.visitInt(hasOperation(), operation_,
              other.hasOperation(), other.operation_);
          metadata_ = visitor.visitMessage(metadata_, other.metadata_);
          switch (other.getPayloadCase()) {
            case FEATURE: {
              payload_ = visitor.visitOneofMessage(
                  payloadCase_ == 3,
                  payload_,
                  other.payload_);
              break;
            }
            case PIET_SHARED_STATE: {
              payload_ = visitor.visitOneofMessage(
                  payloadCase_ == 4,
                  payload_,
                  other.payload_);
              break;
            }
            case PAYLOAD_NOT_SET: {
              visitor.visitOneofNotSet(payloadCase_ != 0);
              break;
            }
          }
          if (visitor == com.google.protobuf.GeneratedMessageLite.MergeFromVisitor
              .INSTANCE) {
            if (other.payloadCase_ != 0) {
              payloadCase_ = other.payloadCase_;
            }
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
                case 8: {
                  int rawValue = input.readEnum();
                  com.google.search.now.wire.feed.DataOperationProto.DataOperation.Operation value = com.google.search.now.wire.feed.DataOperationProto.DataOperation.Operation.forNumber(rawValue);
                  if (value == null) {
                    super.mergeVarintField(1, rawValue);
                  } else {
                    bitField0_ |= 0x00000001;
                    operation_ = rawValue;
                  }
                  break;
                }
                case 18: {
                  com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata.Builder subBuilder = null;
                  if (((bitField0_ & 0x00000002) == 0x00000002)) {
                    subBuilder = metadata_.toBuilder();
                  }
                  metadata_ = input.readMessage(com.google.search.now.wire.feed.PayloadMetadataProto.PayloadMetadata.parser(), extensionRegistry);
                  if (subBuilder != null) {
                    subBuilder.mergeFrom(metadata_);
                    metadata_ = subBuilder.buildPartial();
                  }
                  bitField0_ |= 0x00000002;
                  break;
                }
                case 26: {
                  com.google.search.now.wire.feed.FeatureProto.Feature.Builder subBuilder = null;
                  if (payloadCase_ == 3) {
                    subBuilder = ((com.google.search.now.wire.feed.FeatureProto.Feature) payload_).toBuilder();
                  }
                  payload_ =
                       input.readMessage(com.google.search.now.wire.feed.FeatureProto.Feature.parser(), extensionRegistry);
                  if (subBuilder != null) {
                    subBuilder.mergeFrom((com.google.search.now.wire.feed.FeatureProto.Feature) payload_);
                    payload_ = subBuilder.buildPartial();
                  }
                  payloadCase_ = 3;
                  break;
                }
                case 34: {
                  com.google.search.now.ui.piet.PietProto.PietSharedState.Builder subBuilder = null;
                  if (payloadCase_ == 4) {
                    subBuilder = ((com.google.search.now.ui.piet.PietProto.PietSharedState) payload_).toBuilder();
                  }
                  payload_ =
                       input.readMessage(com.google.search.now.ui.piet.PietProto.PietSharedState.parser(), extensionRegistry);
                  if (subBuilder != null) {
                    subBuilder.mergeFrom((com.google.search.now.ui.piet.PietProto.PietSharedState) payload_);
                    payload_ = subBuilder.buildPartial();
                  }
                  payloadCase_ = 4;
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
          if (PARSER == null) {    synchronized (com.google.search.now.wire.feed.DataOperationProto.DataOperation.class) {
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


    // @@protoc_insertion_point(class_scope:search.now.proto.wire.feed.DataOperation)
    private static final com.google.search.now.wire.feed.DataOperationProto.DataOperation DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new DataOperation();
      DEFAULT_INSTANCE.makeImmutable();
    }

    public static com.google.search.now.wire.feed.DataOperationProto.DataOperation getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<DataOperation> PARSER;

    public static com.google.protobuf.Parser<DataOperation> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
