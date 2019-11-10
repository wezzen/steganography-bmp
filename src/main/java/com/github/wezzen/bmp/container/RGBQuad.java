package com.github.wezzen.bmp.container;

import com.github.wezzen.bmp.container.interfaces.BMPReader;
import com.github.wezzen.bmp.container.interfaces.BMPWriter;
import com.github.wezzen.bmp.container.types.Type;
import com.github.wezzen.bmp.container.types.Types;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.OutputStream;

public class RGBQuad extends BMP implements BMPReader, BMPWriter {
    private Type blue = new Type(Types.BYTE);
    private Type green = new Type(Types.BYTE);
    private Type red = new Type(Types.BYTE);
    private Type reserved = new Type(Types.BYTE);

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

    public void setBlue(final Type blue) throws InvalidObjectException {
        checkVariable(blue, Types.BYTE);
        this.blue = blue;
    }

    public void setGreen(final Type green) throws InvalidObjectException {
        checkVariable(green, Types.BYTE);
        this.green = green;
    }

    public void setRed(final Type red) throws InvalidObjectException {
        checkVariable(red, Types.BYTE);
        this.red = red;
    }

    public void setReserved(final Type reserved) throws InvalidObjectException {
        checkVariable(reserved, Types.BYTE);
        this.reserved = reserved;
    }

    private void readBlue() throws IOException {
        if (inputStream.read(blue.getValue()) != blue.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readGreen() throws IOException {
        if (inputStream.read(green.getValue()) != green.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readRed() throws IOException {
        if (inputStream.read(red.getValue()) != red.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readReserved() throws IOException {
        if (inputStream.read(reserved.getValue()) != reserved.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    @Override
    public void read(final InputStream stream) throws IOException {
        if (stream == null)
            throw new NullPointerException("stream is null.");
        this.inputStream = stream;
        readBlue();
        readGreen();
        readRed();
        readReserved();
    }

    @Override
    public void write(final OutputStream stream) throws IOException {
        if (stream == null)
            throw new NullPointerException("stream is null.");
        this.outputStream = stream;
        writeBlue();
        writeGreen();
        writeRed();
        writeReserved();
    }

    private void writeReserved() throws IOException {
        outputStream.write(reserved.getValue());
    }

    private void writeRed() throws IOException {
        outputStream.write(red.getValue());
    }

    private void writeGreen() throws IOException {
        outputStream.write(green.getValue());
    }

    private void writeBlue() throws IOException {
        outputStream.write(blue.getValue());
    }
}
