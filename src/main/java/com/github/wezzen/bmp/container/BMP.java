package com.github.wezzen.bmp.container;

import com.github.wezzen.bmp.container.types.Type;
import com.github.wezzen.bmp.container.types.Types;

import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.OutputStream;

public abstract class BMP {

    protected InputStream inputStream = null;
    protected OutputStream outputStream = null;

    protected void checkVariable(final Type variable, final Types avialableType) throws InvalidObjectException {
        if (variable == null) {
            throw new NullPointerException("variable is null.");
        }
        if (variable.getType() != avialableType) {
            throw new InvalidObjectException("Invalid type of variable: extected - " + avialableType + " actual - " + variable.getType());
        }
    }
}
