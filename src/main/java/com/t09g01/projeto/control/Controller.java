package com.t09g01.projeto.control;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.gui.ACTION;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model){
        this.model = model;
    }
    public T getModel(){return model;}
    public abstract void step(Game game, Set<ACTION> currentActions, long time) throws IOException, URISyntaxException, FontFormatException;

}
