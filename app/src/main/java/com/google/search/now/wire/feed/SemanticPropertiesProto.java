// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/search/now/proto/wire/feed/semantic_properties.proto

package com.google.search.now.wire.feed;

public final class SemanticPropertiesProto {
  private SemanticPropertiesProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface SemanticPropertiesOrBuilder extends
      // @@protoc_insertion_point(interface_extends:search.now.proto.wire.feed.SemanticProperties)
      com.google.protobuf.MessageLiteOrBuilder {

    /**
     * <pre>
     * This is kept opaque to Feed - we want to keep it and send it alongside
     * content ids in requests
     * </pre>
     *
     * <code>optional bytes semantic_properties_data = 1;</code>
     */
    boolean hasSemanticPropertiesData();
    /**
     * <pre>
     * This is kept opaque to Feed - we want to keep it and send it alongside
     * content ids in requests
     * </pre>
     *
     * <code>optional bytes semantic_properties_data = 1;</code>
     */
    com.google.protobuf.ByteString getSemanticPropertiesData();
  }
  /**
   * <pre>
   * SemanticProperties hold semantic information that we want to attach to
   * features for subsequent comparisons. For example, a feature might be
   * associated with a specific "mid".
   * </pre>
   *
   * Protobuf type {@code search.now.proto.wire.feed.SemanticProperties}
   */
  public  static final class SemanticProperties extends
      com.google.protobuf.GeneratedMessageLite<
          SemanticProperties, SemanticProperties.Builder> implements
      // @@protoc_insertion_point(message_implements:search.now.proto.wire.feed.SemanticProperties)
      SemanticPropertiesOrBuilder {
    private SemanticProperties() {
      semanticPropertiesData_ = com.google.protobuf.ByteString.EMPTY;
    }
    private int bitField0_;
    public static final int SEMANTIC_PROPERTIES_DATA_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString semanticPropertiesData_;
    /**
     * <pre>
     * This is kept opaque to Feed - we want to keep it and send it alongside
     * content ids in requests
     * </pre>
     *
     * <code>optional bytes semantic_properties_data = 1;</code>
     */
    public boolean hasSemanticPropertiesData() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * This is kept opaque to Feed - we want to keep it and send it alongside
     * content ids in requests
     * </pre>
     *
     * <code>optional bytes semantic_properties_data = 1;</code>
     */
    public com.google.protobuf.ByteString getSemanticPropertiesData() {
      return semanticPropertiesData_;
    }
    /**
     * <pre>
     * This is kept opaque to Feed - we want to keep it and send it alongside
     * content ids in requests
     * </pre>
     *
     * <code>optional bytes semantic_properties_data = 1;</code>
     */
    private void setSemanticPropertiesData(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
      semanticPropertiesData_ = value;
    }
    /**
     * <pre>
     * This is kept opaque to Feed - we want to keep it and send it alongside
     * content ids in requests
     * </pre>
     *
     * <code>optional bytes semantic_properties_data = 1;</code>
     */
    private void clearSemanticPropertiesData() {
      bitField0_ = (bitField0_ & ~0x00000001);
      semanticPropertiesData_ = getDefaultInstance().getSemanticPropertiesData();
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, semanticPropertiesData_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, semanticPropertiesData_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * <pre>
     * SemanticProperties hold semantic information that we want to attach to
     * features for subsequent comparisons. For example, a feature might be
     * associated with a specific "mid".
     * </pre>
     *
     * Protobuf type {@code search.now.proto.wire.feed.SemanticProperties}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties, Builder> implements
        // @@protoc_insertion_point(builder_implements:search.now.proto.wire.feed.SemanticProperties)
        com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticPropertiesOrBuilder {
      // Construct using com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <pre>
       * This is kept opaque to Feed - we want to keep it and send it alongside
       * content ids in requests
       * </pre>
       *
       * <code>optional bytes semantic_properties_data = 1;</code>
       */
      public boolean hasSemanticPropertiesData() {
        return instance.hasSemanticPropertiesData();
      }
      /**
       * <pre>
       * This is kept opaque to Feed - we want to keep it and send it alongside
       * content ids in requests
       * </pre>
       *
       * <code>optional bytes semantic_properties_data = 1;</code>
       */
      public com.google.protobuf.ByteString getSemanticPropertiesData() {
        return instance.getSemanticPropertiesData();
      }
      /**
       * <pre>
       * This is kept opaque to Feed - we want to keep it and send it alongside
       * content ids in requests
       * </pre>
       *
       * <code>optional bytes semantic_properties_data = 1;</code>
       */
      public Builder setSemanticPropertiesData(com.google.protobuf.ByteString value) {
        copyOnWrite();
        instance.setSemanticPropertiesData(value);
        return this;
      }
      /**
       * <pre>
       * This is kept opaque to Feed - we want to keep it and send it alongside
       * content ids in requests
       * </pre>
       *
       * <code>optional bytes semantic_properties_data = 1;</code>
       */
      public Builder clearSemanticPropertiesData() {
        copyOnWrite();
        instance.clearSemanticPropertiesData();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:search.now.proto.wire.feed.SemanticProperties)
    }
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0, java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties();
        }
        case IS_INITIALIZED: {
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
          com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties other = (com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties) arg1;
          semanticPropertiesData_ = visitor.visitByteString(
              hasSemanticPropertiesData(), semanticPropertiesData_,
              other.hasSemanticPropertiesData(), other.semanticPropertiesData_);
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
                  bitField0_ |= 0x00000001;
                  semanticPropertiesData_ = input.readBytes();
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
          if (PARSER == null) {    synchronized (com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties.class) {
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


    // @@protoc_insertion_point(class_scope:search.now.proto.wire.feed.SemanticProperties)
    private static final com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new SemanticProperties();
      DEFAULT_INSTANCE.makeImmutable();
    }

    public static com.google.search.now.wire.feed.SemanticPropertiesProto.SemanticProperties getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<SemanticProperties> PARSER;

    public static com.google.protobuf.Parser<SemanticProperties> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
