package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;

public class FireboyController extends Controller<Temple> {
    public FireboyController(Temple temple){
        super(temple);
    }
    public void moveFireboy(Position position) {this.getModel().getFireboy().setPosition(position);}

    public void moveFireboyRight(){
        moveFireboy(getModel().getFireboy().getPosition().getRight());
    }
    public void moveFireboyLeft(){
        moveFireboy(getModel().getFireboy().getPosition().getLeft());
    }
    public void moveFireboyUp(){
        moveFireboy(getModel().getFireboy().getPosition().getUp());
    }
    public void moveFireboyDown(){
        moveFireboy(getModel().getFireboy().getPosition().getDown());
    }

    @Override
    public void step(Game game, ACTION action, long time) {

    }
}
