package com.t09g01.projeto.states;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.control.game.FireboyController;
import com.t09g01.projeto.control.game.TempleController;
import com.t09g01.projeto.control.game.WatergirlController;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.model.game.temple.TempleBuilder;
import com.t09g01.projeto.view.ImageLoader;
import com.t09g01.projeto.view.game.GameViewer;
import com.t09g01.projeto.view.game.ScreenViewer;
import com.t09g01.projeto.view.text.ViewerProvider;

import java.io.IOException;

public class GameState extends State<Temple>{
    public GameState(Temple temple, ImageLoader imageLoader) throws IOException {
        super(temple, imageLoader);}

    @Override
    protected Controller<Temple> getController() {
        return new TempleController(getModel(), new FireboyController(getModel()), new WatergirlController(getModel()));
    }

    @Override
    protected ScreenViewer<Temple> getScreenViewer(ViewerProvider viewerProvider) {
        return new GameViewer(getModel(), viewerProvider);
    }
}
