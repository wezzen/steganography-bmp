package com.github.wezzen.bmp.container;

import com.github.wezzen.bmp.container.interfaces.BMPReader;
import com.github.wezzen.bmp.container.interfaces.BMPWriter;
import com.github.wezzen.bmp.container.types.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.OutputStream;

public class BMPInfoHeader extends BMP implements BMPReader, BMPWriter {
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

    public void setSize(final Type size) throws InvalidObjectException {
        checkVariable(size, Types.DWORD);
        this.size = size;
    }

    public void setWidth(final Type width) throws InvalidObjectException {
        checkVariable(width, Types.LONG);
        this.width = width;
    }

    public void setHeight(final Type height) throws InvalidObjectException {
        checkVariable(height, Types.LONG);
        this.height = height;
    }

    public void setPlanes(final Type planes) throws InvalidObjectException {
        checkVariable(planes, Types.WORD);
        this.planes = planes;
    }

    public void setBitCount(final Type bitCount) throws InvalidObjectException {
        checkVariable(bitCount, Types.WORD);
        this.bitCount = bitCount;
    }

    public void setCompression(final Type compression) throws InvalidObjectException {
        checkVariable(compression, Types.DWORD);
        this.compression = compression;
    }

    public void setSizeImage(final Type sizeImage) throws InvalidObjectException {
        checkVariable(sizeImage, Types.DWORD);
        this.sizeImage = sizeImage;
    }

    public void setxPelsPerMeter(final Type xPelsPerMeter) throws InvalidObjectException {
        checkVariable(xPelsPerMeter, Types.LONG);
        this.xPelsPerMeter = xPelsPerMeter;
    }

    public void setyPelsPerMeter(final Type yPelsPerMeter) throws InvalidObjectException {
        checkVariable(yPelsPerMeter, Types.LONG);
        this.yPelsPerMeter = yPelsPerMeter;
    }

    public void setClrUsed(final Type clrUsed) throws InvalidObjectException {
        checkVariable(clrUsed, Types.DWORD);
        this.clrUsed = clrUsed;
    }

    public void setClrImportant(final Type clrImportant) throws InvalidObjectException {
        checkVariable(clrImportant, Types.DWORD);
        this.clrImportant = clrImportant;
    }

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
        this.inputStream = stream;
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
        if (inputStream.read(clrImportant.getValue()) != clrImportant.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }


    private void readClrUser() throws IOException  {
        if (inputStream.read(clrUsed.getValue()) != clrUsed.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readYPelsPerMeter() throws IOException  {
        if (inputStream.read(yPelsPerMeter.getValue()) != yPelsPerMeter.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readXPelsPerMeter() throws IOException  {
        if (inputStream.read(xPelsPerMeter.getValue()) != xPelsPerMeter.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readSizeImage() throws IOException  {
        if (inputStream.read(sizeImage.getValue()) != sizeImage.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readCompression() throws IOException  {
        if (inputStream.read(compression.getValue()) != compression.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readBitCount() throws IOException  {
        if (inputStream.read(bitCount.getValue()) != bitCount.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readPlanes() throws IOException  {
        if (inputStream.read(planes.getValue()) != planes.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readHeight() throws IOException  {
        if (inputStream.read(height.getValue()) != height.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readWidth() throws IOException  {
        if (inputStream.read(width.getValue()) != width.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    private void readSize() throws IOException  {
        if (inputStream.read(size.getValue()) != size.getType().getBytes()) {
            throw new IOException("Invalid read");
        }
    }

    @Override
    public void write(final OutputStream stream) throws IOException {
        if (stream == null) {
            throw new NullPointerException("stream is null.");
        }
        this.outputStream = stream;
        writeSize();
        writeWidth();
        writeHeight();
        writePlanes();
        writeBitCount();
        writeCompression();
        writeSizeImage();
        writeXPelsPerMeter();
        writeYPelsPerMeter();
        writeClrUser();
        writeClrImportant();
    }

    private void writeClrImportant() throws IOException {
        outputStream.write(clrImportant.getValue());
    }

    private void writeClrUser() throws IOException {
        outputStream.write(clrUsed.getValue());
    }

    private void writeYPelsPerMeter() throws IOException {
        outputStream.write(yPelsPerMeter.getValue());
    }

    private void writeXPelsPerMeter() throws IOException {
        outputStream.write(xPelsPerMeter.getValue());
    }

    private void writeSizeImage() throws IOException {
        outputStream.write(sizeImage.getValue());
    }

    private void writeCompression() throws IOException {
        outputStream.write(compression.getValue());
    }

    private void writeBitCount() throws IOException {
        outputStream.write(bitCount.getValue());
    }

    private void writePlanes() throws IOException {
        outputStream.write(planes.getValue());
    }

    private void writeHeight() throws IOException {
        outputStream.write(height.getValue());
    }

    private void writeWidth() throws IOException {
        outputStream.write(width.getValue());
    }

    private void writeSize() throws IOException {
        outputStream.write(size.getValue());
    }
}
