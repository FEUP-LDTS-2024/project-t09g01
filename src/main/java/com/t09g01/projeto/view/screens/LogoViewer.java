package com.t09g01.projeto.view.screens;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.view.ImageLoader;
import com.t09g01.projeto.view.Viewer;

import java.io.IOException;

public class LogoViewer {
    private final Viewer viewer;

    public LogoViewer(ImageLoader imageLoader) throws IOException {
        this.viewer = imageLoader.get("fonts/logo.png");
    }

    public void draw(GUI gui, int x, int y) {
        viewer.draw(gui, x, y);
    }

}
