package com.github.wezzen.bmp.container;

import com.github.wezzen.bmp.container.types.Type;
import com.github.wezzen.bmp.container.types.Types;

import java.io.IOException;
import java.io.InputStream;

public class RGBQuad implements BMPReader{
    private Type blue = new Type(Types.BYTE);
    private Type green = new Type(Types.BYTE);
    private Type red = new Type(Types.BYTE);
    private Type reserved = new Type(Types.BYTE);
    private InputStream stream = null;

    public Type getBlue() {
        return blue;
    }

    public Type getGreen() {
        return green;
    }

    public Type getRed() {
        return red;
    }

    public Type getReserved() {
        return reserved;
    }

    private void readBlue() throws IOException {
        if (stream.read(blue.getValue()) != blue.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readGreen() throws IOException {
        if (stream.read(green.getValue()) != green.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readRed() throws IOException {
        if (stream.read(red.getValue()) != red.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readReserved() throws IOException {
        if (stream.read(reserved.getValue()) != reserved.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    @Override
    public void read(final InputStream stream) throws IOException {
        if (stream == null)
            throw new NullPointerException("stream is null.");
        this.stream = stream;
        readBlue();
        readGreen();
        readRed();
        readReserved();
    }
}
