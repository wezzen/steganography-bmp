package com.github.wezzen.bmp;

import com.github.wezzen.bmp.container.BMPContainer;

import java.io.*;

public class Reader {
    private static final String EXTENSION = ".bmp";

    private final String fileName;
    private final BMPContainer container;
    private final File file;

    private void checkFile(final String fileName) throws FileNotFoundException {
        if (fileName == null) {
            throw new NullPointerException("filename is null.");
        }
        if (!fileName.endsWith(EXTENSION)) {
            throw new FileNotFoundException("file " + fileName + " has an invalid extension.");
        }
    }

    public Reader(final String fileName) throws NullPointerException, IOException {
        checkFile(fileName);
        this.fileName = fileName;
        file = new File(fileName);
        container = new BMPContainer();
    }

    public void readFile() throws IOException {
        container.readFile(new FileInputStream(file));
    }
}
