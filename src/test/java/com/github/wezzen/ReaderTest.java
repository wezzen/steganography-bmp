package com.github.wezzen;

import com.github.wezzen.bmp.Reader;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class ReaderTest {

    private final static String FILENAME = "in.bmp";
    private File file = null;

    @Before
    public void initialize() throws Exception{
        file = new File(FILENAME);
        if (!file.exists()) {
            throw new Exception("file " + FILENAME + " doesn't exist");
        }

    }


    @Test(expected = NullPointerException.class)
    public void nullPointerTest() throws IOException {
        final Reader reader = new Reader(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotExistsTest() throws IOException {
        final String fileName = "e.q";
        final Reader reader = new Reader(fileName);
    }

}
