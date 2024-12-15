package com.t09g01.projeto.view;

import java.io.IOException;

public interface ImageLoader {
    Viewer get(String filepath) throws IOException;
}
