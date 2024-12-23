package com.t09g01.projeto.states;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.view.image.ImageLoader;
import com.t09g01.projeto.view.screens.ScreenViewer;
import com.t09g01.projeto.view.text.ViewerProvider;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final ScreenViewer<T> screenViewer;

    public State(T model, ImageLoader imageLoader) throws IOException {
        this.model = model;
        this.controller = getController();
        this.screenViewer = getScreenViewer(new ViewerProvider(imageLoader));
    }

    protected abstract Controller<T> getController();
    protected abstract ScreenViewer<T> getScreenViewer(ViewerProvider viewerProvider);

    public T getModel(){
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> currentActions = gui.getCurrentActions();
        controller.step(game, currentActions, time);
        screenViewer.draw(gui);
    }

}
