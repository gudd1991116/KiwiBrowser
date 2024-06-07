// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/search/now/proto/wire/feed/feed_request.proto

package com.google.search.now.wire.feed;

public final class FeedRequestProto {
  private FeedRequestProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
    registry.add(com.google.search.now.wire.feed.FeedRequestProto.FeedRequest.feedRequest);
  }
  public interface FeedRequestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:search.now.proto.wire.feed.FeedRequest)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     * Information about the client making the request.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
     */
    boolean hasClientInfo();
    /**
     * <pre>
     * Information about the client making the request.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
     */
    com.google.search.now.wire.feed.ClientInfoProto.ClientInfo getClientInfo();

    /**
     * <pre>
     * Query parameters to fetch feed data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
     */
    boolean hasFeedQuery();
    /**
     * <pre>
     * Query parameters to fetch feed data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
     */
    com.google.search.now.wire.feed.FeedQueryProto.FeedQuery getFeedQuery();

    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    java.util.List<com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData> 
        getFeedActionQueryDataList();
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData getFeedActionQueryData(int index);
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    int getFeedActionQueryDataCount();
  }
  /**
   * <pre>
   * Request to fetch new data for the feed
   * </pre>
   *
   * Protobuf type {@code search.now.proto.wire.feed.FeedRequest}
   */
  public  static final class FeedRequest extends
      com.google.protobuf.GeneratedMessageLite<
          FeedRequest, FeedRequest.Builder> implements
      // @@protoc_insertion_point(message_implements:search.now.proto.wire.feed.FeedRequest)
      FeedRequestOrBuilder {
    private FeedRequest() {
      feedActionQueryData_ = emptyProtobufList();
    }
    private int bitField0_;
    public static final int CLIENT_INFO_FIELD_NUMBER = 1;
    private com.google.search.now.wire.feed.ClientInfoProto.ClientInfo clientInfo_;
    /**
     * <pre>
     * Information about the client making the request.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
     */
    public boolean hasClientInfo() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * Information about the client making the request.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
     */
    public com.google.search.now.wire.feed.ClientInfoProto.ClientInfo getClientInfo() {
      return clientInfo_ == null ? com.google.search.now.wire.feed.ClientInfoProto.ClientInfo.getDefaultInstance() : clientInfo_;
    }
    /**
     * <pre>
     * Information about the client making the request.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
     */
    private void setClientInfo(com.google.search.now.wire.feed.ClientInfoProto.ClientInfo value) {
      if (value == null) {
        throw new NullPointerException();
      }
      clientInfo_ = value;
      bitField0_ |= 0x00000001;
      }
    /**
     * <pre>
     * Information about the client making the request.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
     */
    private void setClientInfo(
        com.google.search.now.wire.feed.ClientInfoProto.ClientInfo.Builder builderForValue) {
      clientInfo_ = builderForValue.build();
      bitField0_ |= 0x00000001;
    }
    /**
     * <pre>
     * Information about the client making the request.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
     */
    private void mergeClientInfo(com.google.search.now.wire.feed.ClientInfoProto.ClientInfo value) {
      if (clientInfo_ != null &&
          clientInfo_ != com.google.search.now.wire.feed.ClientInfoProto.ClientInfo.getDefaultInstance()) {
        clientInfo_ =
          com.google.search.now.wire.feed.ClientInfoProto.ClientInfo.newBuilder(clientInfo_).mergeFrom(value).buildPartial();
      } else {
        clientInfo_ = value;
      }
      bitField0_ |= 0x00000001;
    }
    /**
     * <pre>
     * Information about the client making the request.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
     */
    private void clearClientInfo() {  clientInfo_ = null;
      bitField0_ = (bitField0_ & ~0x00000001);
    }

    public static final int FEED_QUERY_FIELD_NUMBER = 2;
    private com.google.search.now.wire.feed.FeedQueryProto.FeedQuery feedQuery_;
    /**
     * <pre>
     * Query parameters to fetch feed data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
     */
    public boolean hasFeedQuery() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * Query parameters to fetch feed data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
     */
    public com.google.search.now.wire.feed.FeedQueryProto.FeedQuery getFeedQuery() {
      return feedQuery_ == null ? com.google.search.now.wire.feed.FeedQueryProto.FeedQuery.getDefaultInstance() : feedQuery_;
    }
    /**
     * <pre>
     * Query parameters to fetch feed data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
     */
    private void setFeedQuery(com.google.search.now.wire.feed.FeedQueryProto.FeedQuery value) {
      if (value == null) {
        throw new NullPointerException();
      }
      feedQuery_ = value;
      bitField0_ |= 0x00000002;
      }
    /**
     * <pre>
     * Query parameters to fetch feed data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
     */
    private void setFeedQuery(
        com.google.search.now.wire.feed.FeedQueryProto.FeedQuery.Builder builderForValue) {
      feedQuery_ = builderForValue.build();
      bitField0_ |= 0x00000002;
    }
    /**
     * <pre>
     * Query parameters to fetch feed data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
     */
    private void mergeFeedQuery(com.google.search.now.wire.feed.FeedQueryProto.FeedQuery value) {
      if (feedQuery_ != null &&
          feedQuery_ != com.google.search.now.wire.feed.FeedQueryProto.FeedQuery.getDefaultInstance()) {
        feedQuery_ =
          com.google.search.now.wire.feed.FeedQueryProto.FeedQuery.newBuilder(feedQuery_).mergeFrom(value).buildPartial();
      } else {
        feedQuery_ = value;
      }
      bitField0_ |= 0x00000002;
    }
    /**
     * <pre>
     * Query parameters to fetch feed data.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
     */
    private void clearFeedQuery() {  feedQuery_ = null;
      bitField0_ = (bitField0_ & ~0x00000002);
    }

    public static final int FEED_ACTION_QUERY_DATA_FIELD_NUMBER = 3;
    private com.google.protobuf.Internal.ProtobufList<com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData> feedActionQueryData_;
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    public java.util.List<com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData> getFeedActionQueryDataList() {
      return feedActionQueryData_;
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    public java.util.List<? extends com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryDataOrBuilder> 
        getFeedActionQueryDataOrBuilderList() {
      return feedActionQueryData_;
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    public int getFeedActionQueryDataCount() {
      return feedActionQueryData_.size();
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    public com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData getFeedActionQueryData(int index) {
      return feedActionQueryData_.get(index);
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    public com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryDataOrBuilder getFeedActionQueryDataOrBuilder(
        int index) {
      return feedActionQueryData_.get(index);
    }
    private void ensureFeedActionQueryDataIsMutable() {
      if (!feedActionQueryData_.isModifiable()) {
        feedActionQueryData_ =
            com.google.protobuf.GeneratedMessageLite.mutableCopy(feedActionQueryData_);
       }
    }

    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    private void setFeedActionQueryData(
        int index, com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureFeedActionQueryDataIsMutable();
      feedActionQueryData_.set(index, value);
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    private void setFeedActionQueryData(
        int index, com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData.Builder builderForValue) {
      ensureFeedActionQueryDataIsMutable();
      feedActionQueryData_.set(index, builderForValue.build());
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    private void addFeedActionQueryData(com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureFeedActionQueryDataIsMutable();
      feedActionQueryData_.add(value);
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    private void addFeedActionQueryData(
        int index, com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData value) {
      if (value == null) {
        throw new NullPointerException();
      }
      ensureFeedActionQueryDataIsMutable();
      feedActionQueryData_.add(index, value);
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    private void addFeedActionQueryData(
        com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData.Builder builderForValue) {
      ensureFeedActionQueryDataIsMutable();
      feedActionQueryData_.add(builderForValue.build());
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    private void addFeedActionQueryData(
        int index, com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData.Builder builderForValue) {
      ensureFeedActionQueryDataIsMutable();
      feedActionQueryData_.add(index, builderForValue.build());
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    private void addAllFeedActionQueryData(
        java.lang.Iterable<? extends com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData> values) {
      ensureFeedActionQueryDataIsMutable();
      com.google.protobuf.AbstractMessageLite.addAll(
          values, feedActionQueryData_);
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    private void clearFeedActionQueryData() {
      feedActionQueryData_ = emptyProtobufList();
    }
    /**
     * <pre>
     * Data related to actions performed on the client.
     * </pre>
     *
     * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
     */
    private void removeFeedActionQueryData(int index) {
      ensureFeedActionQueryDataIsMutable();
      feedActionQueryData_.remove(index);
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeMessage(1, getClientInfo());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeMessage(2, getFeedQuery());
      }
      for (int i = 0; i < feedActionQueryData_.size(); i++) {
        output.writeMessage(3, feedActionQueryData_.get(i));
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getClientInfo());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, getFeedQuery());
      }
      for (int i = 0; i < feedActionQueryData_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(3, feedActionQueryData_.get(i));
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.google.search.now.wire.feed.FeedRequestProto.FeedRequest prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * <pre>
     * Request to fetch new data for the feed
     * </pre>
     *
     * Protobuf type {@code search.now.proto.wire.feed.FeedRequest}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.google.search.now.wire.feed.FeedRequestProto.FeedRequest, Builder> implements
        // @@protoc_insertion_point(builder_implements:search.now.proto.wire.feed.FeedRequest)
        com.google.search.now.wire.feed.FeedRequestProto.FeedRequestOrBuilder {
      // Construct using com.google.search.now.wire.feed.FeedRequestProto.FeedRequest.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <pre>
       * Information about the client making the request.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
       */
      public boolean hasClientInfo() {
        return instance.hasClientInfo();
      }
      /**
       * <pre>
       * Information about the client making the request.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
       */
      public com.google.search.now.wire.feed.ClientInfoProto.ClientInfo getClientInfo() {
        return instance.getClientInfo();
      }
      /**
       * <pre>
       * Information about the client making the request.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
       */
      public Builder setClientInfo(com.google.search.now.wire.feed.ClientInfoProto.ClientInfo value) {
        copyOnWrite();
        instance.setClientInfo(value);
        return this;
        }
      /**
       * <pre>
       * Information about the client making the request.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
       */
      public Builder setClientInfo(
          com.google.search.now.wire.feed.ClientInfoProto.ClientInfo.Builder builderForValue) {
        copyOnWrite();
        instance.setClientInfo(builderForValue);
        return this;
      }
      /**
       * <pre>
       * Information about the client making the request.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
       */
      public Builder mergeClientInfo(com.google.search.now.wire.feed.ClientInfoProto.ClientInfo value) {
        copyOnWrite();
        instance.mergeClientInfo(value);
        return this;
      }
      /**
       * <pre>
       * Information about the client making the request.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ClientInfo client_info = 1;</code>
       */
      public Builder clearClientInfo() {  copyOnWrite();
        instance.clearClientInfo();
        return this;
      }

      /**
       * <pre>
       * Query parameters to fetch feed data.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
       */
      public boolean hasFeedQuery() {
        return instance.hasFeedQuery();
      }
      /**
       * <pre>
       * Query parameters to fetch feed data.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
       */
      public com.google.search.now.wire.feed.FeedQueryProto.FeedQuery getFeedQuery() {
        return instance.getFeedQuery();
      }
      /**
       * <pre>
       * Query parameters to fetch feed data.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
       */
      public Builder setFeedQuery(com.google.search.now.wire.feed.FeedQueryProto.FeedQuery value) {
        copyOnWrite();
        instance.setFeedQuery(value);
        return this;
        }
      /**
       * <pre>
       * Query parameters to fetch feed data.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
       */
      public Builder setFeedQuery(
          com.google.search.now.wire.feed.FeedQueryProto.FeedQuery.Builder builderForValue) {
        copyOnWrite();
        instance.setFeedQuery(builderForValue);
        return this;
      }
      /**
       * <pre>
       * Query parameters to fetch feed data.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
       */
      public Builder mergeFeedQuery(com.google.search.now.wire.feed.FeedQueryProto.FeedQuery value) {
        copyOnWrite();
        instance.mergeFeedQuery(value);
        return this;
      }
      /**
       * <pre>
       * Query parameters to fetch feed data.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.FeedQuery feed_query = 2;</code>
       */
      public Builder clearFeedQuery() {  copyOnWrite();
        instance.clearFeedQuery();
        return this;
      }

      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public java.util.List<com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData> getFeedActionQueryDataList() {
        return java.util.Collections.unmodifiableList(
            instance.getFeedActionQueryDataList());
      }
      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public int getFeedActionQueryDataCount() {
        return instance.getFeedActionQueryDataCount();
      }/**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData getFeedActionQueryData(int index) {
        return instance.getFeedActionQueryData(index);
      }
      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public Builder setFeedActionQueryData(
          int index, com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData value) {
        copyOnWrite();
        instance.setFeedActionQueryData(index, value);
        return this;
      }
      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public Builder setFeedActionQueryData(
          int index, com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData.Builder builderForValue) {
        copyOnWrite();
        instance.setFeedActionQueryData(index, builderForValue);
        return this;
      }
      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public Builder addFeedActionQueryData(com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData value) {
        copyOnWrite();
        instance.addFeedActionQueryData(value);
        return this;
      }
      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public Builder addFeedActionQueryData(
          int index, com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData value) {
        copyOnWrite();
        instance.addFeedActionQueryData(index, value);
        return this;
      }
      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public Builder addFeedActionQueryData(
          com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData.Builder builderForValue) {
        copyOnWrite();
        instance.addFeedActionQueryData(builderForValue);
        return this;
      }
      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public Builder addFeedActionQueryData(
          int index, com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData.Builder builderForValue) {
        copyOnWrite();
        instance.addFeedActionQueryData(index, builderForValue);
        return this;
      }
      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public Builder addAllFeedActionQueryData(
          java.lang.Iterable<? extends com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData> values) {
        copyOnWrite();
        instance.addAllFeedActionQueryData(values);
        return this;
      }
      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public Builder clearFeedActionQueryData() {
        copyOnWrite();
        instance.clearFeedActionQueryData();
        return this;
      }
      /**
       * <pre>
       * Data related to actions performed on the client.
       * </pre>
       *
       * <code>repeated .search.now.proto.wire.feed.FeedActionQueryData feed_action_query_data = 3;</code>
       */
      public Builder removeFeedActionQueryData(int index) {
        copyOnWrite();
        instance.removeFeedActionQueryData(index);
        return this;
      }

      // @@protoc_insertion_point(builder_scope:search.now.proto.wire.feed.FeedRequest)
    }
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0, java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new com.google.search.now.wire.feed.FeedRequestProto.FeedRequest();
        }
        case IS_INITIALIZED: {
          return DEFAULT_INSTANCE;
        }
        case MAKE_IMMUTABLE: {
          feedActionQueryData_.makeImmutable();
          return null;
        }
        case NEW_BUILDER: {
          return new Builder();
        }
        case VISIT: {
          Visitor visitor = (Visitor) arg0;
          com.google.search.now.wire.feed.FeedRequestProto.FeedRequest other = (com.google.search.now.wire.feed.FeedRequestProto.FeedRequest) arg1;
          clientInfo_ = visitor.visitMessage(clientInfo_, other.clientInfo_);
          feedQuery_ = visitor.visitMessage(feedQuery_, other.feedQuery_);
          feedActionQueryData_= visitor.visitList(feedActionQueryData_, other.feedActionQueryData_);
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
                  com.google.search.now.wire.feed.ClientInfoProto.ClientInfo.Builder subBuilder = null;
                  if (((bitField0_ & 0x00000001) == 0x00000001)) {
                    subBuilder = clientInfo_.toBuilder();
                  }
                  clientInfo_ = input.readMessage(com.google.search.now.wire.feed.ClientInfoProto.ClientInfo.parser(), extensionRegistry);
                  if (subBuilder != null) {
                    subBuilder.mergeFrom(clientInfo_);
                    clientInfo_ = subBuilder.buildPartial();
                  }
                  bitField0_ |= 0x00000001;
                  break;
                }
                case 18: {
                  com.google.search.now.wire.feed.FeedQueryProto.FeedQuery.Builder subBuilder = null;
                  if (((bitField0_ & 0x00000002) == 0x00000002)) {
                    subBuilder = feedQuery_.toBuilder();
                  }
                  feedQuery_ = input.readMessage(com.google.search.now.wire.feed.FeedQueryProto.FeedQuery.parser(), extensionRegistry);
                  if (subBuilder != null) {
                    subBuilder.mergeFrom(feedQuery_);
                    feedQuery_ = subBuilder.buildPartial();
                  }
                  bitField0_ |= 0x00000002;
                  break;
                }
                case 26: {
                  if (!feedActionQueryData_.isModifiable()) {
                    feedActionQueryData_ =
                        com.google.protobuf.GeneratedMessageLite.mutableCopy(feedActionQueryData_);
                  }
                  feedActionQueryData_.add(
                      input.readMessage(com.google.search.now.wire.feed.FeedActionQueryDataProto.FeedActionQueryData.parser(), extensionRegistry));
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
          if (PARSER == null) {    synchronized (com.google.search.now.wire.feed.FeedRequestProto.FeedRequest.class) {
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


    // @@protoc_insertion_point(class_scope:search.now.proto.wire.feed.FeedRequest)
    private static final com.google.search.now.wire.feed.FeedRequestProto.FeedRequest DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new FeedRequest();
      DEFAULT_INSTANCE.makeImmutable();
    }

    public static com.google.search.now.wire.feed.FeedRequestProto.FeedRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<FeedRequest> PARSER;

    public static com.google.protobuf.Parser<FeedRequest> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
    public static final int FEED_REQUEST_FIELD_NUMBER = 1000;
    /**
     * <code>extend .search.now.proto.wire.feed.Request { ... }</code>
     */
    public static final
      com.google.protobuf.GeneratedMessageLite.GeneratedExtension<
        com.google.search.now.wire.feed.RequestProto.Request,
        com.google.search.now.wire.feed.FeedRequestProto.FeedRequest> feedRequest = com.google.protobuf.GeneratedMessageLite
            .newSingularGeneratedExtension(
          com.google.search.now.wire.feed.RequestProto.Request.getDefaultInstance(),
          com.google.search.now.wire.feed.FeedRequestProto.FeedRequest.getDefaultInstance(),
          com.google.search.now.wire.feed.FeedRequestProto.FeedRequest.getDefaultInstance(),
          null,
          1000,
          com.google.protobuf.WireFormat.FieldType.MESSAGE,
          com.google.search.now.wire.feed.FeedRequestProto.FeedRequest.class);
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
