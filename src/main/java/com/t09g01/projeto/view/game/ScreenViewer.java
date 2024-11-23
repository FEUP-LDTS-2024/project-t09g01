package com.t09g01.projeto.view.game;

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

    public void draw(GUI gui) throws IOException {
    }
}
