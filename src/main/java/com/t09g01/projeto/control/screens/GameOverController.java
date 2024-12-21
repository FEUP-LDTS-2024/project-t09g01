package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.model.screens.GameOver;

public class GameOverController extends MenuController<GameOver> {
    public GameOverController(GameOver gameOver, EntryController entryController) {super(gameOver, entryController);}

    @Override
    protected void quit(Game game) {
        game.setState(null);
    }
}
