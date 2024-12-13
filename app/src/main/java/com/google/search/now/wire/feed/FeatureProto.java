// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/search/now/proto/wire/feed/feature.proto

package com.google.search.now.wire.feed;

public final class FeatureProto {
  private FeatureProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface FeatureOrBuilder extends 
      // @@protoc_insertion_point(interface_extends:search.now.proto.wire.feed.Feature)
       com.google.protobuf.GeneratedMessageLite.
            ExtendableMessageOrBuilder<
                Feature, Feature.Builder> {

    /**
     * <pre>
     * The ContentId identifying the parent feature for this feature.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
     */
    boolean hasParentId();
    /**
     * <pre>
     * The ContentId identifying the parent feature for this feature.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
     */
    com.google.search.now.wire.feed.ContentIdProto.ContentId getParentId();

    /**
     * <code>optional .search.now.proto.wire.feed.Feature.RenderableUnit renderable_unit = 2;</code>
     */
    boolean hasRenderableUnit();
    /**
     * <code>optional .search.now.proto.wire.feed.Feature.RenderableUnit renderable_unit = 2;</code>
     */
    com.google.search.now.wire.feed.FeatureProto.Feature.RenderableUnit getRenderableUnit();
  }
  /**
   * <pre>
   * Features define both the structure and content found in the Stream.
   * </pre>
   *
   * Protobuf type {@code search.now.proto.wire.feed.Feature}
   */
  public  static final class Feature extends
      com.google.protobuf.GeneratedMessageLite.ExtendableMessage<
        Feature, Feature.Builder> implements
      // @@protoc_insertion_point(message_implements:search.now.proto.wire.feed.Feature)
      FeatureOrBuilder {
    private Feature() {
    }
    /**
     * <pre>
     * Enum denoting which extension containing the renderable data is associated
     * with this Feature.
     * </pre>
     *
     * Protobuf enum {@code search.now.proto.wire.feed.Feature.RenderableUnit}
     */
    public enum RenderableUnit
        implements com.google.protobuf.Internal.EnumLite {
      /**
       * <code>UNKNOWN_RENDERABLE_UNIT = 0;</code>
       */
      UNKNOWN_RENDERABLE_UNIT(0),
      /**
       * <code>STREAM = 1;</code>
       */
      STREAM(1),
      /**
       * <code>CARD = 2;</code>
       */
      CARD(2),
      /**
       * <code>CONTENT = 3;</code>
       */
      CONTENT(3),
      /**
       * <code>CLUSTER = 4;</code>
       */
      CLUSTER(4),
      /**
       * <code>TOKEN = 5;</code>
       */
      TOKEN(5),
      ;

      /**
       * <code>UNKNOWN_RENDERABLE_UNIT = 0;</code>
       */
      public static final int UNKNOWN_RENDERABLE_UNIT_VALUE = 0;
      /**
       * <code>STREAM = 1;</code>
       */
      public static final int STREAM_VALUE = 1;
      /**
       * <code>CARD = 2;</code>
       */
      public static final int CARD_VALUE = 2;
      /**
       * <code>CONTENT = 3;</code>
       */
      public static final int CONTENT_VALUE = 3;
      /**
       * <code>CLUSTER = 4;</code>
       */
      public static final int CLUSTER_VALUE = 4;
      /**
       * <code>TOKEN = 5;</code>
       */
      public static final int TOKEN_VALUE = 5;


      public final int getNumber() {
        return value;
      }

      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static RenderableUnit valueOf(int value) {
        return forNumber(value);
      }

      public static RenderableUnit forNumber(int value) {
        switch (value) {
          case 0: return UNKNOWN_RENDERABLE_UNIT;
          case 1: return STREAM;
          case 2: return CARD;
          case 3: return CONTENT;
          case 4: return CLUSTER;
          case 5: return TOKEN;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<RenderableUnit>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          RenderableUnit> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<RenderableUnit>() {
              public RenderableUnit findValueByNumber(int number) {
                return RenderableUnit.forNumber(number);
              }
            };

      private final int value;

      private RenderableUnit(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:search.now.proto.wire.feed.Feature.RenderableUnit)
    }

    private int bitField0_;
    public static final int PARENT_ID_FIELD_NUMBER = 1;
    private com.google.search.now.wire.feed.ContentIdProto.ContentId parentId_;
    /**
     * <pre>
     * The ContentId identifying the parent feature for this feature.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
     */
    public boolean hasParentId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * The ContentId identifying the parent feature for this feature.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
     */
    public com.google.search.now.wire.feed.ContentIdProto.ContentId getParentId() {
      return parentId_ == null ? com.google.search.now.wire.feed.ContentIdProto.ContentId.getDefaultInstance() : parentId_;
    }
    /**
     * <pre>
     * The ContentId identifying the parent feature for this feature.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
     */
    private void setParentId(com.google.search.now.wire.feed.ContentIdProto.ContentId value) {
      if (value == null) {
        throw new NullPointerException();
      }
      parentId_ = value;
      bitField0_ |= 0x00000001;
      }
    /**
     * <pre>
     * The ContentId identifying the parent feature for this feature.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
     */
    private void setParentId(
        com.google.search.now.wire.feed.ContentIdProto.ContentId.Builder builderForValue) {
      parentId_ = builderForValue.build();
      bitField0_ |= 0x00000001;
    }
    /**
     * <pre>
     * The ContentId identifying the parent feature for this feature.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
     */
    private void mergeParentId(com.google.search.now.wire.feed.ContentIdProto.ContentId value) {
      if (parentId_ != null &&
          parentId_ != com.google.search.now.wire.feed.ContentIdProto.ContentId.getDefaultInstance()) {
        parentId_ =
          com.google.search.now.wire.feed.ContentIdProto.ContentId.newBuilder(parentId_).mergeFrom(value).buildPartial();
      } else {
        parentId_ = value;
      }
      bitField0_ |= 0x00000001;
    }
    /**
     * <pre>
     * The ContentId identifying the parent feature for this feature.
     * </pre>
     *
     * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
     */
    private void clearParentId() {  parentId_ = null;
      bitField0_ = (bitField0_ & ~0x00000001);
    }

    public static final int RENDERABLE_UNIT_FIELD_NUMBER = 2;
    private int renderableUnit_;
    /**
     * <code>optional .search.now.proto.wire.feed.Feature.RenderableUnit renderable_unit = 2;</code>
     */
    public boolean hasRenderableUnit() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional .search.now.proto.wire.feed.Feature.RenderableUnit renderable_unit = 2;</code>
     */
    public com.google.search.now.wire.feed.FeatureProto.Feature.RenderableUnit getRenderableUnit() {
      com.google.search.now.wire.feed.FeatureProto.Feature.RenderableUnit result = com.google.search.now.wire.feed.FeatureProto.Feature.RenderableUnit.forNumber(renderableUnit_);
      return result == null ? com.google.search.now.wire.feed.FeatureProto.Feature.RenderableUnit.UNKNOWN_RENDERABLE_UNIT : result;
    }
    /**
     * <code>optional .search.now.proto.wire.feed.Feature.RenderableUnit renderable_unit = 2;</code>
     */
    private void setRenderableUnit(com.google.search.now.wire.feed.FeatureProto.Feature.RenderableUnit value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      renderableUnit_ = value.getNumber();
    }
    /**
     * <code>optional .search.now.proto.wire.feed.Feature.RenderableUnit renderable_unit = 2;</code>
     */
    private void clearRenderableUnit() {
      bitField0_ = (bitField0_ & ~0x00000002);
      renderableUnit_ = 0;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      com.google.protobuf.GeneratedMessageLite
        .ExtendableMessage<com.google.search.now.wire.feed.FeatureProto.Feature, com.google.search.now.wire.feed.FeatureProto.Feature.Builder>
          .ExtensionWriter extensionWriter =
            newExtensionWriter();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeMessage(1, getParentId());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeEnum(2, renderableUnit_);
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
          .computeMessageSize(1, getParentId());
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(2, renderableUnit_);
      }
      size += extensionsSerializedSize();
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    public static com.google.search.now.wire.feed.FeatureProto.Feature parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.wire.feed.FeatureProto.Feature parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.google.search.now.wire.feed.FeatureProto.Feature prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * <pre>
     * Features define both the structure and content found in the Stream.
     * </pre>
     *
     * Protobuf type {@code search.now.proto.wire.feed.Feature}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.ExtendableBuilder<
          com.google.search.now.wire.feed.FeatureProto.Feature, Builder> implements
        // @@protoc_insertion_point(builder_implements:search.now.proto.wire.feed.Feature)
        com.google.search.now.wire.feed.FeatureProto.FeatureOrBuilder {
      // Construct using com.google.search.now.wire.feed.FeatureProto.Feature.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <pre>
       * The ContentId identifying the parent feature for this feature.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
       */
      public boolean hasParentId() {
        return instance.hasParentId();
      }
      /**
       * <pre>
       * The ContentId identifying the parent feature for this feature.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
       */
      public com.google.search.now.wire.feed.ContentIdProto.ContentId getParentId() {
        return instance.getParentId();
      }
      /**
       * <pre>
       * The ContentId identifying the parent feature for this feature.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
       */
      public Builder setParentId(com.google.search.now.wire.feed.ContentIdProto.ContentId value) {
        copyOnWrite();
        instance.setParentId(value);
        return this;
        }
      /**
       * <pre>
       * The ContentId identifying the parent feature for this feature.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
       */
      public Builder setParentId(
          com.google.search.now.wire.feed.ContentIdProto.ContentId.Builder builderForValue) {
        copyOnWrite();
        instance.setParentId(builderForValue);
        return this;
      }
      /**
       * <pre>
       * The ContentId identifying the parent feature for this feature.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
       */
      public Builder mergeParentId(com.google.search.now.wire.feed.ContentIdProto.ContentId value) {
        copyOnWrite();
        instance.mergeParentId(value);
        return this;
      }
      /**
       * <pre>
       * The ContentId identifying the parent feature for this feature.
       * </pre>
       *
       * <code>optional .search.now.proto.wire.feed.ContentId parent_id = 1;</code>
       */
      public Builder clearParentId() {  copyOnWrite();
        instance.clearParentId();
        return this;
      }

      /**
       * <code>optional .search.now.proto.wire.feed.Feature.RenderableUnit renderable_unit = 2;</code>
       */
      public boolean hasRenderableUnit() {
        return instance.hasRenderableUnit();
      }
      /**
       * <code>optional .search.now.proto.wire.feed.Feature.RenderableUnit renderable_unit = 2;</code>
       */
      public com.google.search.now.wire.feed.FeatureProto.Feature.RenderableUnit getRenderableUnit() {
        return instance.getRenderableUnit();
      }
      /**
       * <code>optional .search.now.proto.wire.feed.Feature.RenderableUnit renderable_unit = 2;</code>
       */
      public Builder setRenderableUnit(com.google.search.now.wire.feed.FeatureProto.Feature.RenderableUnit value) {
        copyOnWrite();
        instance.setRenderableUnit(value);
        return this;
      }
      /**
       * <code>optional .search.now.proto.wire.feed.Feature.RenderableUnit renderable_unit = 2;</code>
       */
      public Builder clearRenderableUnit() {
        copyOnWrite();
        instance.clearRenderableUnit();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:search.now.proto.wire.feed.Feature)
    }
    private byte memoizedIsInitialized = -1;
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0, java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new com.google.search.now.wire.feed.FeatureProto.Feature();
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
          com.google.search.now.wire.feed.FeatureProto.Feature other = (com.google.search.now.wire.feed.FeatureProto.Feature) arg1;
          parentId_ = visitor.visitMessage(parentId_, other.parentId_);
          renderableUnit_ = visitor.visitInt(hasRenderableUnit(), renderableUnit_,
              other.hasRenderableUnit(), other.renderableUnit_);
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
                case 10: {
                  com.google.search.now.wire.feed.ContentIdProto.ContentId.Builder subBuilder = null;
                  if (((bitField0_ & 0x00000001) == 0x00000001)) {
                    subBuilder = parentId_.toBuilder();
                  }
                  parentId_ = input.readMessage(com.google.search.now.wire.feed.ContentIdProto.ContentId.parser(), extensionRegistry);
                  if (subBuilder != null) {
                    subBuilder.mergeFrom(parentId_);
                    parentId_ = subBuilder.buildPartial();
                  }
                  bitField0_ |= 0x00000001;
                  break;
                }
                case 16: {
                  int rawValue = input.readEnum();
                  com.google.search.now.wire.feed.FeatureProto.Feature.RenderableUnit value = com.google.search.now.wire.feed.FeatureProto.Feature.RenderableUnit.forNumber(rawValue);
                  if (value == null) {
                    super.mergeVarintField(2, rawValue);
                  } else {
                    bitField0_ |= 0x00000002;
                    renderableUnit_ = rawValue;
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
          if (PARSER == null) {    synchronized (com.google.search.now.wire.feed.FeatureProto.Feature.class) {
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


    // @@protoc_insertion_point(class_scope:search.now.proto.wire.feed.Feature)
    private static final com.google.search.now.wire.feed.FeatureProto.Feature DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Feature();
      DEFAULT_INSTANCE.makeImmutable();
    }

    public static com.google.search.now.wire.feed.FeatureProto.Feature getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<Feature> PARSER;

    public static com.google.protobuf.Parser<Feature> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
