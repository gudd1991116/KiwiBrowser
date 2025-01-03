// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/search/now/proto/wire/feed/request.proto

package com.google.search.now.wire.feed;

public final class RequestProto {
  private RequestProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface RequestOrBuilder extends 
      // @@protoc_insertion_point(interface_extends:search.now.proto.wire.feed.Request)
       com.google.protobuf.GeneratedMessageLite.
            ExtendableMessageOrBuilder<
                Request, Request.Builder> {

    /**
     * <code>optional .search.now.proto.wire.feed.Request.RequestVersion request_version = 1;</code>
     */
    boolean hasRequestVersion();
    /**
     * <code>optional .search.now.proto.wire.feed.Request.RequestVersion request_version = 1;</code>
     */
    com.google.search.now.wire.feed.RequestProto.Request.RequestVersion getRequestVersion();
  }
  /**
   * <pre>
   * Top level request message.
   * </pre>
   *
   * Protobuf type {@code search.now.proto.wire.feed.Request}
   */
  public  static final class Request extends
      com.google.protobuf.GeneratedMessageLite.ExtendableMessage<
        Request, Request.Builder> implements
      // @@protoc_insertion_point(message_implements:search.now.proto.wire.feed.Request)
      RequestOrBuilder {
    private Request() {
    }
    /**
     * <pre>
     * Supported versions of request messages are specified as extensions to
     * the top-level request message.  An enum is used to denote the expected
     * extensions for this request.
     * </pre>
     *
     * Protobuf enum {@code search.now.proto.wire.feed.Request.RequestVersion}
     */
    public enum RequestVersion
        implements com.google.protobuf.Internal.EnumLite {
      /**
       * <code>UNKNOWN_REQUEST_VERSION = 0;</code>
       */
      UNKNOWN_REQUEST_VERSION(0),
      /**
       * <code>FEED_QUERY = 1;</code>
       */
      FEED_QUERY(1),
      ;

      /**
       * <code>UNKNOWN_REQUEST_VERSION = 0;</code>
       */
      public static final int UNKNOWN_REQUEST_VERSION_VALUE = 0;
      /**
       * <code>FEED_QUERY = 1;</code>
       */
      public static final int FEED_QUERY_VALUE = 1;


      public final int getNumber() {
        return value;
      }

      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static RequestVersion valueOf(int value) {
        return forNumber(value);
      }

      public static RequestVersion forNumber(int value) {
        switch (value) {
          case 0: return UNKNOWN_REQUEST_VERSION;
          case 1: return FEED_QUERY;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<RequestVersion>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          RequestVersion> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<RequestVersion>() {
              public RequestVersion findValueByNumber(int number) {
                return RequestVersion.forNumber(number);
              }
            };

      private final int value;

      private RequestVersion(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:search.now.proto.wire.feed.Request.RequestVersion)
    }

    private int bitField0_;
    public static final int REQUEST_VERSION_FIELD_NUMBER = 1;
    private int requestVersion_;
    /**
     * <code>optional .search.now.proto.wire.feed.Request.RequestVersion request_version = 1;</code>
     */
    public boolean hasRequestVersion() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional .search.now.proto.wire.feed.Request.RequestVersion request_version = 1;</code>
     */
    public com.google.search.now.wire.feed.RequestProto.Request.RequestVersion getRequestVersion() {
      com.google.search.now.wire.feed.RequestProto.Request.RequestVersion result = com.google.search.now.wire.feed.RequestProto.Request.RequestVersion.forNumber(requestVersion_);
      return result == null ? com.google.search.now.wire.feed.RequestProto.Request.RequestVersion.UNKNOWN_REQUEST_VERSION : result;
    }
    /**
     * <code>optional .search.now.proto.wire.feed.Request.RequestVersion request_version = 1;</code>
     */
    private void setRequestVersion(com.google.search.now.wire.feed.RequestProto.Request.RequestVersion value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      requestVersion_ = value.getNumber();
    }
    /**
     * <code>optional .search.now.proto.wire.feed.Request.RequestVersion request_version = 1;</code>
     */
    private void clearRequestVersion() {
      bitField0_ = (bitField0_ & ~0x00000001);
      requestVersion_ = 0;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      com.google.protobuf.GeneratedMessageLite
        .ExtendableMessage<com.google.search.now.wire.feed.RequestProto.Request, com.google.search.now.wire.feed.RequestProto.Request.Builder>
          .ExtensionWriter extensionWriter =
            newExtensionWriter();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeEnum(1, requestVersion_);
      }
      extensionWriter.writeUntil(536870912, output);
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, requestVersion_);
      }
      size += extensionsSerializedSize();
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    public static com.google.search.now.wire.feed.RequestProto.Request parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.RequestProto.Request parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.google.search.now.wire.feed.RequestProto.Request prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * <pre>
     * Top level request message.
     * </pre>
     *
     * Protobuf type {@code search.now.proto.wire.feed.Request}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.ExtendableBuilder<
          com.google.search.now.wire.feed.RequestProto.Request, Builder> implements
        // @@protoc_insertion_point(builder_implements:search.now.proto.wire.feed.Request)
        com.google.search.now.wire.feed.RequestProto.RequestOrBuilder {
      // Construct using com.google.search.now.wire.feed.RequestProto.Request.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <code>optional .search.now.proto.wire.feed.Request.RequestVersion request_version = 1;</code>
       */
      public boolean hasRequestVersion() {
        return instance.hasRequestVersion();
      }
      /**
       * <code>optional .search.now.proto.wire.feed.Request.RequestVersion request_version = 1;</code>
       */
      public com.google.search.now.wire.feed.RequestProto.Request.RequestVersion getRequestVersion() {
        return instance.getRequestVersion();
      }
      /**
       * <code>optional .search.now.proto.wire.feed.Request.RequestVersion request_version = 1;</code>
       */
      public Builder setRequestVersion(com.google.search.now.wire.feed.RequestProto.Request.RequestVersion value) {
        copyOnWrite();
        instance.setRequestVersion(value);
        return this;
      }
      /**
       * <code>optional .search.now.proto.wire.feed.Request.RequestVersion request_version = 1;</code>
       */
      public Builder clearRequestVersion() {
        copyOnWrite();
        instance.clearRequestVersion();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:search.now.proto.wire.feed.Request)
    }
    private byte memoizedIsInitialized = -1;
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0, java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new com.google.search.now.wire.feed.RequestProto.Request();
        }
        case IS_INITIALIZED: {
          byte isInitialized = memoizedIsInitialized;
          if (isInitialized == 1) return DEFAULT_INSTANCE;
          if (isInitialized == 0) return null;

          boolean shouldMemoize = ((Boolean) arg0).booleanValue();
          if (!extensionsAreInitialized()) {
            if (shouldMemoize) {
              memoizedIsInitialized = 0;
            }
            return null;
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
          com.google.search.now.wire.feed.RequestProto.Request other = (com.google.search.now.wire.feed.RequestProto.Request) arg1;
          requestVersion_ = visitor.visitInt(hasRequestVersion(), requestVersion_,
              other.hasRequestVersion(), other.requestVersion_);
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
                  if (!parseUnknownField(getDefaultInstanceForType(),
                      input, extensionRegistry, tag)) {
                    done = true;
                  }
                  break;
                }
                case 8: {
                  int rawValue = input.readEnum();
                  com.google.search.now.wire.feed.RequestProto.Request.RequestVersion value = com.google.search.now.wire.feed.RequestProto.Request.RequestVersion.forNumber(rawValue);
                  if (value == null) {
                    super.mergeVarintField(1, rawValue);
                  } else {
                    bitField0_ |= 0x00000001;
                    requestVersion_ = rawValue;
                  }
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
          if (PARSER == null) {    synchronized (com.google.search.now.wire.feed.RequestProto.Request.class) {
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


    // @@protoc_insertion_point(class_scope:search.now.proto.wire.feed.Request)
    private static final com.google.search.now.wire.feed.RequestProto.Request DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Request();
      DEFAULT_INSTANCE.makeImmutable();
    }

    public static com.google.search.now.wire.feed.RequestProto.Request getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<Request> PARSER;

    public static com.google.protobuf.Parser<Request> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
