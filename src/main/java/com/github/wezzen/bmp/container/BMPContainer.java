package com.github.wezzen.bmp.container;

import com.github.wezzen.convert.Convert;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class BMPContainer {
    private BMPHeader header;
    private BMPInfoHeader infoHeader;
    private List<RGBQuad> quad;
    private long quadSize;

    private void checkBMPFile() throws InvalidObjectException {
        final byte first = header.getType().getValue()[0]; //B
        final byte second = header.getType().getValue()[1]; //M
        if (first != 66 || second != 77) {
            throw new InvalidObjectException("the file is not a BMP file");
        }
    }

    public BMPContainer() {
        header = new BMPHeader();
        infoHeader = new BMPInfoHeader();
        quad = new LinkedList<>();
    }

    public void readFile(final InputStream stream) throws IOException {
        header.read(stream);
        checkBMPFile();
        infoHeader.read(stream);
        quadSize = Convert.readInt(infoHeader.getSizeImage().getValue()) / 4;
        for (int i = 0; i < quadSize; i++) {
            final RGBQuad rgbQuad = new RGBQuad();
            rgbQuad.read(stream);
            quad.add(rgbQuad);
        }
    }

    public void writeFile(final OutputStream stream) throws IOException {
        checkBMPFile();
        header.write(stream);
        infoHeader.write(stream);
        for (RGBQuad elem : quad) {
            elem.write(stream);
        }
    }


}
