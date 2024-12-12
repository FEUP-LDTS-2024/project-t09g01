package com.t09g01.projeto.states;

import com.googlecode.lanterna.screen.Screen;
import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.temple.TempleBuilder;
import com.t09g01.projeto.view.game.ScreenViewer;

import java.io.IOException;
import java.util.Set;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final ScreenViewer<T> screenViewer;

    public State(T model){
        this.model = model;
        this.controller = getController();
        this.screenViewer = getScreenViewer();
    }

    protected abstract Controller<T> getController();
    protected abstract ScreenViewer<T> getScreenViewer();

    public T getModel(){
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        Set<ACTION> currentActions = gui.getCurrentActions();
        controller.step(game, currentActions, time);
        screenViewer.draw(gui);
    }

}
