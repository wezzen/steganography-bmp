package com.github.wezzen.bmp.container.types;

public class Type {
    private byte[] bytes;
    private final Types type;

    public Type(final Types type) {
        bytes = new byte[type.getBytes()];
        this.type = type;
    }

    public void setBytes (final byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getValue() {
        return bytes;
    }

    public Types getType() {
        return type;
    }

}
