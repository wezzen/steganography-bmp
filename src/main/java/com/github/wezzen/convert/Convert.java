package com.github.wezzen.convert;

public class Convert {
    private final static int INVALID_DATA = -1;


    public static int readInt(final byte[] bytes) {
        if (bytes.length != 4) {
            return INVALID_DATA;
        }
        int value = 0;
        value += (bytes[3] & 0x000000FF) << 24;
        value += (bytes[2] & 0x000000FF) << 16;
        value += (bytes[1] & 0x000000FF) << 8;
        value += (bytes[0] & 0x000000FF);
        return value;
    }

    public static long readLong(final byte[] bytes) {
        if (bytes.length != 8) {
            return INVALID_DATA;
        }
        long value = 0;
        value += (long) (bytes[7] & 0x000000FF) << 56;
        value += (long) (bytes[6] & 0x000000FF) << 48;
        value += (long) (bytes[5] & 0x000000FF) << 40;
        value += (long) (bytes[4] & 0x000000FF) << 32;
        value += (bytes[3] & 0x000000FF) << 24;
        value += (bytes[2] & 0x000000FF) << 16;
        value += (bytes[1] & 0x000000FF) << 8;
        value += (bytes[0] & 0x000000FF);
        return value;
    }

    public static double readDouble(final byte[] bytes) {
        long value = readLong(bytes);
        if (value != INVALID_DATA) {
            return Double.longBitsToDouble(value);
        }
        return INVALID_DATA;
    }
}
