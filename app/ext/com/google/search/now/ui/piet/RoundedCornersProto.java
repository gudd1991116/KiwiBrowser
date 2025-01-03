// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/main/proto/search/now/proto/ui/piet/rounded_corners.proto

package com.google.search.now.ui.piet;

public final class RoundedCornersProto {
  private RoundedCornersProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface RoundedCornersOrBuilder extends 
      // @@protoc_insertion_point(interface_extends:search.now.ui.piet.RoundedCorners)
       com.google.protobuf.GeneratedMessageLite.
            ExtendableMessageOrBuilder<
                RoundedCorners, RoundedCorners.Builder> {

    /**
     * <pre>
     * A bitmask representing which corners should be rounded. Bit values are
     * defined by the `Corners` enum. If no corners are specified, then this will
     * be applied to all corners.
     * </pre>
     *
     * <code>optional int32 bitmask = 1;</code>
     */
    boolean hasBitmask();
    /**
     * <pre>
     * A bitmask representing which corners should be rounded. Bit values are
     * defined by the `Corners` enum. If no corners are specified, then this will
     * be applied to all corners.
     * </pre>
     *
     * <code>optional int32 bitmask = 1;</code>
     */
    int getBitmask();

    /**
     * <pre>
     * The radius of the rounding applied to the specified corners, specified in
     * DP. This value must be non-zero, otherwise it’s a no-op.
     * </pre>
     *
     * <code>optional int32 radius = 2;</code>
     */
    boolean hasRadius();
    /**
     * <pre>
     * The radius of the rounding applied to the specified corners, specified in
     * DP. This value must be non-zero, otherwise it’s a no-op.
     * </pre>
     *
     * <code>optional int32 radius = 2;</code>
     */
    int getRadius();
  }
  /**
   * <pre>
   * Rounded corners for Views, expressed as a bit mask. If a container view has
   * rounded corners applied to it, then the contents of that view SHOULD also be
   * cropped to fit within the rounded rectangle bounding box established by the
   * container. Specifically, content within such a view SHOULD be cropped too,
   * without having to explicitly specify rounded corners on the child content.
   * Check [INTERNAL LINK] for any client-specific limitations that apply to the
   * current version of the implementation.
   * </pre>
   *
   * Protobuf type {@code search.now.ui.piet.RoundedCorners}
   */
  public  static final class RoundedCorners extends
      com.google.protobuf.GeneratedMessageLite.ExtendableMessage<
        RoundedCorners, RoundedCorners.Builder> implements
      // @@protoc_insertion_point(message_implements:search.now.ui.piet.RoundedCorners)
      RoundedCornersOrBuilder {
    private RoundedCorners() {
    }
    /**
     * <pre>
     * Represents the set of values for a bitmask to specify which corners should
     * be rounded. Values start at top-left and continue clock-wise.
     * </pre>
     *
     * Protobuf enum {@code search.now.ui.piet.RoundedCorners.Corners}
     */
    public enum Corners
        implements com.google.protobuf.Internal.EnumLite {
      /**
       * <pre>
       * If unspecified, then all corners will be rounded.
       * </pre>
       *
       * <code>CORNERS_UNSPECIFIED = 0;</code>
       */
      CORNERS_UNSPECIFIED(0),
      /**
       * <pre>
       * Indicates that the top left corner should be rounded.
       * </pre>
       *
       * <code>TOP_LEFT = 1;</code>
       */
      TOP_LEFT(1),
      /**
       * <pre>
       * Indicates that the top right corner should be rounded.
       * </pre>
       *
       * <code>TOP_RIGHT = 2;</code>
       */
      TOP_RIGHT(2),
      /**
       * <pre>
       * Indicates that the bottom right corner should be rounded.
       * </pre>
       *
       * <code>BOTTOM_RIGHT = 4;</code>
       */
      BOTTOM_RIGHT(4),
      /**
       * <pre>
       * Indicates that the bottom left corner should be rounded.
       * </pre>
       *
       * <code>BOTTOM_LEFT = 8;</code>
       */
      BOTTOM_LEFT(8),
      ;

      /**
       * <pre>
       * If unspecified, then all corners will be rounded.
       * </pre>
       *
       * <code>CORNERS_UNSPECIFIED = 0;</code>
       */
      public static final int CORNERS_UNSPECIFIED_VALUE = 0;
      /**
       * <pre>
       * Indicates that the top left corner should be rounded.
       * </pre>
       *
       * <code>TOP_LEFT = 1;</code>
       */
      public static final int TOP_LEFT_VALUE = 1;
      /**
       * <pre>
       * Indicates that the top right corner should be rounded.
       * </pre>
       *
       * <code>TOP_RIGHT = 2;</code>
       */
      public static final int TOP_RIGHT_VALUE = 2;
      /**
       * <pre>
       * Indicates that the bottom right corner should be rounded.
       * </pre>
       *
       * <code>BOTTOM_RIGHT = 4;</code>
       */
      public static final int BOTTOM_RIGHT_VALUE = 4;
      /**
       * <pre>
       * Indicates that the bottom left corner should be rounded.
       * </pre>
       *
       * <code>BOTTOM_LEFT = 8;</code>
       */
      public static final int BOTTOM_LEFT_VALUE = 8;


      public final int getNumber() {
        return value;
      }

      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static Corners valueOf(int value) {
        return forNumber(value);
      }

      public static Corners forNumber(int value) {
        switch (value) {
          case 0: return CORNERS_UNSPECIFIED;
          case 1: return TOP_LEFT;
          case 2: return TOP_RIGHT;
          case 4: return BOTTOM_RIGHT;
          case 8: return BOTTOM_LEFT;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<Corners>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          Corners> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<Corners>() {
              public Corners findValueByNumber(int number) {
                return Corners.forNumber(number);
              }
            };

      private final int value;

      private Corners(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:search.now.ui.piet.RoundedCorners.Corners)
    }

    private int bitField0_;
    public static final int BITMASK_FIELD_NUMBER = 1;
    private int bitmask_;
    /**
     * <pre>
     * A bitmask representing which corners should be rounded. Bit values are
     * defined by the `Corners` enum. If no corners are specified, then this will
     * be applied to all corners.
     * </pre>
     *
     * <code>optional int32 bitmask = 1;</code>
     */
    public boolean hasBitmask() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <pre>
     * A bitmask representing which corners should be rounded. Bit values are
     * defined by the `Corners` enum. If no corners are specified, then this will
     * be applied to all corners.
     * </pre>
     *
     * <code>optional int32 bitmask = 1;</code>
     */
    public int getBitmask() {
      return bitmask_;
    }
    /**
     * <pre>
     * A bitmask representing which corners should be rounded. Bit values are
     * defined by the `Corners` enum. If no corners are specified, then this will
     * be applied to all corners.
     * </pre>
     *
     * <code>optional int32 bitmask = 1;</code>
     */
    private void setBitmask(int value) {
      bitField0_ |= 0x00000001;
      bitmask_ = value;
    }
    /**
     * <pre>
     * A bitmask representing which corners should be rounded. Bit values are
     * defined by the `Corners` enum. If no corners are specified, then this will
     * be applied to all corners.
     * </pre>
     *
     * <code>optional int32 bitmask = 1;</code>
     */
    private void clearBitmask() {
      bitField0_ = (bitField0_ & ~0x00000001);
      bitmask_ = 0;
    }

    public static final int RADIUS_FIELD_NUMBER = 2;
    private int radius_;
    /**
     * <pre>
     * The radius of the rounding applied to the specified corners, specified in
     * DP. This value must be non-zero, otherwise it’s a no-op.
     * </pre>
     *
     * <code>optional int32 radius = 2;</code>
     */
    public boolean hasRadius() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <pre>
     * The radius of the rounding applied to the specified corners, specified in
     * DP. This value must be non-zero, otherwise it’s a no-op.
     * </pre>
     *
     * <code>optional int32 radius = 2;</code>
     */
    public int getRadius() {
      return radius_;
    }
    /**
     * <pre>
     * The radius of the rounding applied to the specified corners, specified in
     * DP. This value must be non-zero, otherwise it’s a no-op.
     * </pre>
     *
     * <code>optional int32 radius = 2;</code>
     */
    private void setRadius(int value) {
      bitField0_ |= 0x00000002;
      radius_ = value;
    }
    /**
     * <pre>
     * The radius of the rounding applied to the specified corners, specified in
     * DP. This value must be non-zero, otherwise it’s a no-op.
     * </pre>
     *
     * <code>optional int32 radius = 2;</code>
     */
    private void clearRadius() {
      bitField0_ = (bitField0_ & ~0x00000002);
      radius_ = 0;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      com.google.protobuf.GeneratedMessageLite
        .ExtendableMessage<com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners, com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners.Builder>
          .ExtensionWriter extensionWriter =
            newExtensionWriter();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, bitmask_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, radius_);
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
          .computeInt32Size(1, bitmask_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, radius_);
      }
      size += extensionsSerializedSize();
      size += unknownFields.getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, data, extensionRegistry);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input);
    }
    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageLite.parseFrom(
          DEFAULT_INSTANCE, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    /**
     * <pre>
     * Rounded corners for Views, expressed as a bit mask. If a container view has
     * rounded corners applied to it, then the contents of that view SHOULD also be
     * cropped to fit within the rounded rectangle bounding box established by the
     * container. Specifically, content within such a view SHOULD be cropped too,
     * without having to explicitly specify rounded corners on the child content.
     * Check [INTERNAL LINK] for any client-specific limitations that apply to the
     * current version of the implementation.
     * </pre>
     *
     * Protobuf type {@code search.now.ui.piet.RoundedCorners}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.ExtendableBuilder<
          com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners, Builder> implements
        // @@protoc_insertion_point(builder_implements:search.now.ui.piet.RoundedCorners)
        com.google.search.now.ui.piet.RoundedCornersProto.RoundedCornersOrBuilder {
      // Construct using com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners.newBuilder()
      private Builder() {
        super(DEFAULT_INSTANCE);
      }


      /**
       * <pre>
       * A bitmask representing which corners should be rounded. Bit values are
       * defined by the `Corners` enum. If no corners are specified, then this will
       * be applied to all corners.
       * </pre>
       *
       * <code>optional int32 bitmask = 1;</code>
       */
      public boolean hasBitmask() {
        return instance.hasBitmask();
      }
      /**
       * <pre>
       * A bitmask representing which corners should be rounded. Bit values are
       * defined by the `Corners` enum. If no corners are specified, then this will
       * be applied to all corners.
       * </pre>
       *
       * <code>optional int32 bitmask = 1;</code>
       */
      public int getBitmask() {
        return instance.getBitmask();
      }
      /**
       * <pre>
       * A bitmask representing which corners should be rounded. Bit values are
       * defined by the `Corners` enum. If no corners are specified, then this will
       * be applied to all corners.
       * </pre>
       *
       * <code>optional int32 bitmask = 1;</code>
       */
      public Builder setBitmask(int value) {
        copyOnWrite();
        instance.setBitmask(value);
        return this;
      }
      /**
       * <pre>
       * A bitmask representing which corners should be rounded. Bit values are
       * defined by the `Corners` enum. If no corners are specified, then this will
       * be applied to all corners.
       * </pre>
       *
       * <code>optional int32 bitmask = 1;</code>
       */
      public Builder clearBitmask() {
        copyOnWrite();
        instance.clearBitmask();
        return this;
      }

      /**
       * <pre>
       * The radius of the rounding applied to the specified corners, specified in
       * DP. This value must be non-zero, otherwise it’s a no-op.
       * </pre>
       *
       * <code>optional int32 radius = 2;</code>
       */
      public boolean hasRadius() {
        return instance.hasRadius();
      }
      /**
       * <pre>
       * The radius of the rounding applied to the specified corners, specified in
       * DP. This value must be non-zero, otherwise it’s a no-op.
       * </pre>
       *
       * <code>optional int32 radius = 2;</code>
       */
      public int getRadius() {
        return instance.getRadius();
      }
      /**
       * <pre>
       * The radius of the rounding applied to the specified corners, specified in
       * DP. This value must be non-zero, otherwise it’s a no-op.
       * </pre>
       *
       * <code>optional int32 radius = 2;</code>
       */
      public Builder setRadius(int value) {
        copyOnWrite();
        instance.setRadius(value);
        return this;
      }
      /**
       * <pre>
       * The radius of the rounding applied to the specified corners, specified in
       * DP. This value must be non-zero, otherwise it’s a no-op.
       * </pre>
       *
       * <code>optional int32 radius = 2;</code>
       */
      public Builder clearRadius() {
        copyOnWrite();
        instance.clearRadius();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:search.now.ui.piet.RoundedCorners)
    }
    private byte memoizedIsInitialized = -1;
    @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
    protected final java.lang.Object dynamicMethod(
        com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
        java.lang.Object arg0, java.lang.Object arg1) {
      switch (method) {
        case NEW_MUTABLE_INSTANCE: {
          return new com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners();
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
          com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners other = (com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners) arg1;
          bitmask_ = visitor.visitInt(
              hasBitmask(), bitmask_,
              other.hasBitmask(), other.bitmask_);
          radius_ = visitor.visitInt(
              hasRadius(), radius_,
              other.hasRadius(), other.radius_);
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
                  bitField0_ |= 0x00000001;
                  bitmask_ = input.readInt32();
                  break;
                }
                case 16: {
                  bitField0_ |= 0x00000002;
                  radius_ = input.readInt32();
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
          if (PARSER == null) {    synchronized (com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners.class) {
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


    // @@protoc_insertion_point(class_scope:search.now.ui.piet.RoundedCorners)
    private static final com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new RoundedCorners();
      DEFAULT_INSTANCE.makeImmutable();
    }

    public static com.google.search.now.ui.piet.RoundedCornersProto.RoundedCorners getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static volatile com.google.protobuf.Parser<RoundedCorners> PARSER;

    public static com.google.protobuf.Parser<RoundedCorners> parser() {
      return DEFAULT_INSTANCE.getParserForType();
    }
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}
