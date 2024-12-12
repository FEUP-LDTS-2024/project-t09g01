package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.Fireboy;
import com.t09g01.projeto.model.game.temple.Temple;

import java.util.Set;

public class FireboyController extends Controller<Temple> {
    public FireboyController(Temple temple){
        super(temple);
    }

    public void moveFireboy(Position position) {
        if (!getModel().checkCollisions(position)){
            getModel().getFireboy().setPosition(position);
        }
    }

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
    public void jumpFireboy(){
        Fireboy fireboy = getModel().getFireboy();
        if (fireboy.isOnGround()){
            fireboy.jump();
        }
    }

    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) {
        for (ACTION action : currentActions){
            Fireboy fireboy = getModel().getFireboy();
            switch (action){
                case FIREBOY_UP -> moveFireboyUp();
                case FIREBOY_DOWN -> moveFireboyDown();
                case FIREBOY_LEFT -> moveFireboyLeft();
                case FIREBOY_RIGHT -> moveFireboyRight();
            }

        }

    }


}
