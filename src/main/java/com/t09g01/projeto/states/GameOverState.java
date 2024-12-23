package com.t09g01.projeto.states;

import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.control.screens.EntryController;
import com.t09g01.projeto.control.screens.GameOverController;
import com.t09g01.projeto.model.screens.GameOver;
import com.t09g01.projeto.view.image.ImageLoader;
import com.t09g01.projeto.view.screens.ScreenViewer;
import com.t09g01.projeto.view.screens.GameOverViewer;
import com.t09g01.projeto.view.text.ViewerProvider;

import java.io.IOException;

public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver gameOver, ImageLoader imageLoader) throws IOException {
        super(gameOver, imageLoader);
    }

    @Override
    protected Controller<GameOver> getController(){
        return new GameOverController(getModel(),  new EntryController(getModel()));}

    @Override
    protected ScreenViewer<GameOver> getScreenViewer(ViewerProvider viewerProvider) {
        return new GameOverViewer<>(getModel(), viewerProvider);
    }
}
