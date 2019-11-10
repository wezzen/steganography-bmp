package com.github.wezzen.bmp.container;

import com.github.wezzen.bmp.container.interfaces.BMPReader;
import com.github.wezzen.bmp.container.interfaces.BMPWriter;
import com.github.wezzen.bmp.container.types.Type;
import com.github.wezzen.bmp.container.types.Types;

import java.io.*;

public class BMPHeader implements BMPReader, BMPWriter {
    private Type type = new Type(Types.WORD);
    private Type size = new Type(Types.DWORD);
    private Type reserved1 = new Type(Types.WORD);
    private Type reserved2 = new Type(Types.WORD);
    private Type offsetBits = new Type(Types.DWORD);

    private InputStream inputStream = null;
    private OutputStream outputStream = null;

    public Type getType() {
        return type;
    }

    public Type getSize() {
        return size;
    }

    public Type getReserved1() {
        return reserved1;
    }

    public Type getReserved2() {
        return reserved2;
    }

    public Type getOffsetBits() {
        return offsetBits;
    }

    private void readType() throws IOException {
        if (inputStream.read(type.getValue()) != type.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readSize() throws IOException {
        if (inputStream.read(size.getValue()) != size.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readReserved1() throws IOException {
        if (inputStream.read(reserved1.getValue()) != reserved1.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readReserved2() throws IOException {
        if (inputStream.read(reserved2.getValue()) != reserved2.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readOffsetBits() throws IOException {
        if (inputStream.read(offsetBits.getValue()) != offsetBits.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    @Override
    public void read(final InputStream stream) throws IOException {
        if (stream == null)
            throw new NullPointerException("stream is null.");
        this.inputStream = stream;
        readType();
        readSize();
        readReserved1();
        readReserved2();
        readOffsetBits();
    }

    @Override
    public void write(final OutputStream stream) throws IOException {
        if (stream == null)
            throw new NullPointerException("stream is null.");
        this.outputStream = stream;
        writeType();
        writeSize();
        writeReserved1();
        writeReserved2();
        writeOffsetBits();
    }

    private void writeOffsetBits() throws IOException {
        outputStream.write(offsetBits.getValue());
    }

    private void writeReserved2() throws IOException {
        outputStream.write(reserved2.getValue());
    }

    private void writeReserved1() throws IOException {
        outputStream.write(reserved1.getValue());
    }

    private void writeSize() throws IOException {
        outputStream.write(size.getValue());
    }

    private void writeType() throws IOException {
        outputStream.write(type.getValue());
    }
}
