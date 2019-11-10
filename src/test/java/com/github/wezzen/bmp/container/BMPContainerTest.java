package com.github.wezzen.bmp.container;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class BMPContainerTest {

    private final static String FILENAME = "in.bmp";
    private final static String WRONG_FILENAME = "some.some";
    private BMPContainer container = new BMPContainer();
    private File file = new File(FILENAME);
    private File wrongFile = new File(WRONG_FILENAME);

    @Test
    void readFileTest() throws IOException {
        final FileInputStream stream = new FileInputStream(file);
        container.readFile(stream);
        assertEquals(-1, stream.read());
    }

    @Test
    void readFileTestException() {
        assertThrows(IOException.class, () ->
           container.readFile(new FileInputStream(wrongFile))
        );
    }
}