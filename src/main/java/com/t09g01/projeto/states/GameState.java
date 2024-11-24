package com.t09g01.projeto.states;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.control.game.TempleController;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.model.game.temple.TempleBuilder;
import com.t09g01.projeto.view.game.GameViewer;
import com.t09g01.projeto.view.game.ScreenViewer;

import java.io.IOException;

public class GameState extends State<Temple>{
    public GameState(Temple temple) {super(temple);}

    @Override
    protected Controller<Temple> getController() {
        return new TempleController(getModel());
    }

    @Override
    protected ScreenViewer<Temple> getScreenViewer() {
        return new GameViewer(getModel());
    }



}
