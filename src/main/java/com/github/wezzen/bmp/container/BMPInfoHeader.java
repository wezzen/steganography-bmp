package com.github.wezzen.bmp.container;

import com.github.wezzen.bmp.container.types.*;

import java.io.IOException;
import java.io.InputStream;

public class BMPInfoHeader implements BMPReader{
    private Type size = new Type(Types.DWORD);
    private Type width = new Type(Types.LONG);
    private Type height = new Type(Types.LONG);
    private Type planes = new Type(Types.WORD);
    private Type bitCount = new Type(Types.WORD);
    private Type compression = new Type(Types.DWORD);
    private Type sizeImage = new Type(Types.DWORD);
    private Type xPelsPerMeter = new Type(Types.LONG);
    private Type yPelsPerMeter = new Type(Types.LONG);
    private Type clrUsed = new Type(Types.DWORD);
    private Type clrImportant = new Type(Types.DWORD);
    private InputStream stream = null;

    public Type getSize() {
        return size;
    }

    public Type getWidth() {
        return width;
    }

    public Type getHeight() {
        return height;
    }

    public Type getPlanes() {
        return planes;
    }

    public Type getBitCount() {
        return bitCount;
    }

    public Type getCompression() {
        return compression;
    }

    public Type getSizeImage() {
        return sizeImage;
    }

    public Type getxPelsPerMeter() {
        return xPelsPerMeter;
    }

    public Type getyPelsPerMeter() {
        return yPelsPerMeter;
    }

    public Type getClrUsed() {
        return clrUsed;
    }

    public Type getClrImportant() {
        return clrImportant;
    }

    @Override
    public void read(final InputStream stream) throws IOException {
        if (stream == null) {
            throw new NullPointerException("stream is null.");
        }
        this.stream = stream;
        readSize();
        readWidth();
        readHeight();
        readPlanes();
        readBitCount();
        readCompression();
        readSizeImage();
        readXPelsPerMeter();
        readYPelsPerMeter();
        readClrUser();
        readClrImportant();
    }

    private void readClrImportant() throws IOException {
        if (stream.read(clrImportant.getValue()) != clrImportant.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }


    private void readClrUser() throws IOException  {
        if (stream.read(clrUsed.getValue()) != clrUsed.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readYPelsPerMeter() throws IOException  {
        if (stream.read(yPelsPerMeter.getValue()) != yPelsPerMeter.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readXPelsPerMeter() throws IOException  {
        if (stream.read(xPelsPerMeter.getValue()) != xPelsPerMeter.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readSizeImage() throws IOException  {
        if (stream.read(sizeImage.getValue()) != sizeImage.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readCompression() throws IOException  {
        if (stream.read(compression.getValue()) != compression.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readBitCount() throws IOException  {
        if (stream.read(bitCount.getValue()) != bitCount.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readPlanes() throws IOException  {
        if (stream.read(planes.getValue()) != planes.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readHeight() throws IOException  {
        if (stream.read(height.getValue()) != height.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readWidth() throws IOException  {
        if (stream.read(width.getValue()) != width.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readSize() throws IOException  {
        if (stream.read(size.getValue()) != size.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }
}
