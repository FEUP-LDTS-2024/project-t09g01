package com.t09g01.projeto.view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.t09g01.projeto.gui.GUI;

import java.io.IOException;

public abstract class ScreenViewer <T> {
    private final T model;

    public ScreenViewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void draw(GUI gui) throws IOException;

    protected void drawBackground(GUI gui, TextColor backgroundColor) {
        TextGraphics textGraphics = gui.getScreen().newTextGraphics();
        textGraphics.setBackgroundColor(backgroundColor);
        textGraphics.fill(' ');
    }
}
