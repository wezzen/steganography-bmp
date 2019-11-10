package com.github.wezzen.bmp.container.interfaces;

import java.io.IOException;
import java.io.InputStream;

public interface BMPReader {
    void read(final InputStream stream) throws IOException;
}
