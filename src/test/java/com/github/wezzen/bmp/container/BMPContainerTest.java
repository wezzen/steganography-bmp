package com.github.wezzen.bmp.container;

import com.github.wezzen.bmp.Reader;
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
        Reader reader = new Reader(FILENAME);
        reader.readFile();
        assertEquals(-1, reader.getStream().read());
    }

    @Test
    void readFileTestException() {
        assertThrows(FileNotFoundException.class, () -> {
           Reader reader = new Reader(WRONG_FILENAME);
        });
    }
}