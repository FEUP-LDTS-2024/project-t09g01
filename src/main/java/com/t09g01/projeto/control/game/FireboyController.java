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
            getModel().retrieveRedDiamonds(position);
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

    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) {
//        Fireboy fireboy = getModel().getFireboy();
//        for (ACTION action : currentActions){
//            switch (action){
//                case FIREBOY_UP:
//                    if (fireboy.isOnGround()){
//                        fireboy.startJump();
//                        fireboy.jump(System.currentTimeMillis());
//                    }
//
//                    break;
//                case FIREBOY_DOWN:
//                    moveFireboyDown();
//                    break;
//                case FIREBOY_LEFT:
//                    moveFireboyLeft();
//                    break;
//                case FIREBOY_RIGHT:
//                    moveFireboyRight();
//                    break;
//            }
//        }
//        //fireboy.defyingGravity();
//        //fireboy.update();
        Fireboy fireboy = getModel().getFireboy();
        double x = fireboy.getPosition().getX(), y = fireboy.getPosition().getY();
        double vx = fireboy.getVelocity().getX(), vy = fireboy.getVelocity().getY();
        vy += getModel().getGravity();
        for (ACTION action : currentActions) {

            switch (action) {
                case FIREBOY_LEFT:
                    vx = Math.max(vx - fireboy.getAcceleration(), -fireboy.getMaxVelocity().getX());
                    break;
                case FIREBOY_RIGHT:
                    vx = Math.min(vx + fireboy.getAcceleration(), fireboy.getMaxVelocity().getX());
                    break;
                case FIREBOY_UP:
                    if (fireboy.hasLanded()) {
                        vy = -fireboy.getJumpBoost();
                        fireboy.setHasLanded(false);
                    }
                    break;
                case FIREBOY_DOWN:
                    // Handle down action if needed
                    break;
            }
        }

            if (vy > 0) {
                fireboy.setFalling(true);
                fireboy.setHasLanded(false);
                fireboy.setJumping(false);

                vy = Math.min(vy, fireboy.getMaxVelocity().getY());
                if (getModel().floorCollision(new Position(x, y + vy))) {
                    fireboy.setHasLanded(true);
                    fireboy.setFalling(false);
                    do {
                        vy = Math.max(vy - 1, 0);
                    } while (getModel().floorCollision(new Position(x, y + vy)) && vy > 0);
                }
            } else if (vy < 0) {
                fireboy.setJumping(true);
                while (getModel().checkCollisionUp(new Position(x, y + vy)) && vy < 0) {
                    vy = Math.min(vy + 1, 0);
                }
            }

            if (vx < 0) {
                vx = Math.max(vx, -fireboy.getMaxVelocity().getX());
                while (getModel().checkCollisionLeft(new Position(x + vx, y + vy)) && vx < 0) {
                    vx = Math.min(vx + 1, 0);
                }
            } else if (vx > 0) {
                vx = Math.min(vx, fireboy.getMaxVelocity().getY());
                while (getModel().checkCollisionRight(new Position(x + vx, y + vy)) && vx > 0) {
                    vx = Math.max(vx - 1, 0);
                }
            }

            if (Math.abs(vx) < 0.2)
                vx = 0;
            x += vx;
            y += vy;

            fireboy.setVelocity(new Position(vx, vy));
            fireboy.setPosition(new Position(x, y));




    }


}
