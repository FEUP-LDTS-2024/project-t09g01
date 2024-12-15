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

public class GameOverController extends Controller<GameOver> {
    //private final Temple temple;
    public GameOverController(GameOver gameOver) {
        super(gameOver);
        //this.temple = temple;
    }

    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) throws IOException {
        for (ACTION action : currentActions){
            switch (action){
                case FIREBOY_UP:
                    getModel().previousEntry();
                    break;
                case FIREBOY_DOWN:
                    getModel().nextEntry();
                    break;
                case SELECT:
                    if(getModel().isSelectedPlayAgain()){
                        game.setState(new GameState(new TempleBuilder(1).createTemple()));
                    }
                    if (getModel().isSelectedExit()){
                        game.setState(null);
                    }
            }

        }
    }
}
