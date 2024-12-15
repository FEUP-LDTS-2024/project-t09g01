package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.model.game.temple.TempleBuilder;
import com.t09g01.projeto.model.gameover.GameOver;
import com.t09g01.projeto.states.GameState;

import java.io.IOException;
import java.util.Set;

public class GameOverController extends MenuController<GameOver> {
    public GameOverController(GameOver gameOver, EntryController entryController) {super(gameOver, entryController);}

    @Override
    protected void quit(Game game) {
        game.setState(null);
    }
}
