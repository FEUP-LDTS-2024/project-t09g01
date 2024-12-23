package com.t09g01.projeto.view.image;

import com.t09g01.projeto.view.Viewer;

import java.io.IOException;

public interface ImageLoader {
    Viewer get(String filepath) throws IOException;
}
