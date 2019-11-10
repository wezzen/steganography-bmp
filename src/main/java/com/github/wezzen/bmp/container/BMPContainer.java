package com.github.wezzen.bmp.container;

import com.github.wezzen.convert.Convert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.LinkedList;
import java.util.List;

public class BMPContainer {
    private BMPHeader header;
    private BMPInfoHeader infoHeader;
    private List<RGBQuad> quad;

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

    public void readFile(final FileInputStream stream) throws IOException {
        header.read(stream);
        checkBMPFile();
        infoHeader.read(stream);
        final long size = Convert.readInt(infoHeader.getSizeImage().getValue()) / 4;
        for (int i = 0; i < size; i++) {
            final RGBQuad rgbQuad = new RGBQuad();
            rgbQuad.read(stream);
            quad.add(rgbQuad);
        }
    }


}
