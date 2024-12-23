package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;

import java.util.Set;


public class FireboyController extends Controller<Temple> {
    public FireboyController(Temple temple){
        super(temple);
    }

    public void moveFireboy(Position position) {
            getModel().getFireboy().setPosition(position);
            getModel().retrieveRedDiamonds(position);
    }

    public void moveFireboyRight(){
        if (!getModel().collidesRight(getModel().getFireboy().getPosition().getRight(), getModel().getBlocks())){
            moveFireboy(getModel().getFireboy().getPosition().getRight());
        }
    }
    public void moveFireboyLeft(){
        if (!getModel().collidesLeft(getModel().getFireboy().getPosition().getLeft(), getModel().getBlocks())){
            moveFireboy(getModel().getFireboy().getPosition().getLeft());
        }
    }
    public void moveFireboyUp(){
        if (!getModel().collidesUp(getModel().getFireboy().getPosition().getUp(), getModel().getBlocks())){
            moveFireboy(getModel().getFireboy().getPosition().getUp());
        }
    }
    public void moveFireboyDown(){
        if (!getModel().collidesDown(getModel().getFireboy().getPosition().getDown(), getModel().getBlocks())){
            moveFireboy(getModel().getFireboy().getPosition().getDown());
        }
    }

    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) {
        for (ACTION action : currentActions){
            switch (action){
                case FIREBOY_UP:
                    moveFireboyUp();
                    break;
                case FIREBOY_DOWN:
                    moveFireboyDown();
                    break;
                case FIREBOY_LEFT:
                    moveFireboyLeft();
                    break;
                case FIREBOY_RIGHT:
                    moveFireboyRight();
                    break;
            }
        }

    }
}
