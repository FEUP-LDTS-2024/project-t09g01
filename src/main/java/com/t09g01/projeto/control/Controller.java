package com.t09g01.projeto.control;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.gui.ACTION;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;
    public Controller(T model){
        this.model = model;
    }
    public T getModel(){return model;}
    public abstract void step(Game game, ACTION action, long time) throws IOException;

}
