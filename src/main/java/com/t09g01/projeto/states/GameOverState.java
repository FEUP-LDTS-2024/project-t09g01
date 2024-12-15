package com.t09g01.projeto.states;

import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.control.game.TempleController;
import com.t09g01.projeto.control.screens.GameOverController;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.model.gameover.GameOver;
import com.t09g01.projeto.view.game.ScreenViewer;
import com.t09g01.projeto.view.screens.GameOverViewer;

public class GameOverState extends State<GameOver> {
//    private final Temple temple;
    public GameOverState(GameOver gameOver) {
        super(gameOver);
        //this.temple = temple;
    }

    @Override
    protected Controller<GameOver> getController(){
        return new GameOverController(getModel());}

    @Override
    protected ScreenViewer<GameOver> getScreenViewer() {return new GameOverViewer(getModel());}
}
