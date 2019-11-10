package com.github.wezzen.bmp.container.types;

public enum Types {

    WORD(2),
    DWORD(4),
    BYTE(1),
    INT(4),
    LONG(4),
    UINT(4);

    private final int bytes;
    Types(final int bytes) {
        this.bytes = bytes;
    }
    public int getBytes() {
        return bytes;
    }
}
