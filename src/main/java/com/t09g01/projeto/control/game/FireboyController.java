package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.Block;
import com.t09g01.projeto.model.game.elements.Fireboy;
import com.t09g01.projeto.model.game.temple.Temple;

import java.util.Set;


public class FireboyController extends Controller<Temple> {
    boolean isJumping;
    boolean canJump;
    long jumpStartTime = 0;
    double groundY;
    double previousY;

    public FireboyController(Temple temple){
        super(temple);
        this.isJumping = false;
        this.canJump = false;
        this.groundY = getModel().getFireboy().getPosition().getY();
        this.previousY = this.groundY;
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

        Fireboy fireboy = getModel().getFireboy();
        for (ACTION action : currentActions){
            switch (action){
                case FIREBOY_UP:
//                    if (fireboy.isOnGround()){
//                        fireboy.startJump();
//                        fireboy.jump(System.currentTimeMillis());
//                    }
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
//        //fireboy.defyingGravity();
//        //fireboy.update();



//        Fireboy fireboy = getModel().getFireboy();
//        double x = fireboy.getPosition().getX(), y = fireboy.getPosition().getY();
//        double vx = fireboy.getVelocity().getX(), vy = fireboy.getVelocity().getY();
//        vy += getModel().getGravity();
//        for (ACTION action : currentActions) {
//
//            switch (action) {
//                case FIREBOY_LEFT:
//                    vx = Math.max(vx - fireboy.getAcceleration(), -fireboy.getMaxVelocity().getX());
//                    break;
//                case FIREBOY_RIGHT:
//                    vx = Math.min(vx + fireboy.getAcceleration(), fireboy.getMaxVelocity().getX());
//                    break;
//                case FIREBOY_UP:
//                    if (fireboy.hasLanded()) {
//                        vy = -fireboy.getJumpBoost();
//                        fireboy.setHasLanded(false);
//                    }
//                    break;
//                default:
//                    break;
//            }
//        }
//
//        if (vy > 0) {
//            fireboy.setFalling(true);
//            fireboy.setHasLanded(false);
//            fireboy.setJumping(false);
//
//            vy = Math.min(vy, fireboy.getMaxVelocity().getY());
//            if (getModel().collidesDown(new Position(x, y + vy), getModel().getBlocks())) {
//                fireboy.setHasLanded(true);
//                fireboy.setFalling(false);
//                do {
//                    vy = Math.max(vy - 1, 0);
//                } while (getModel().collidesDown(new Position(x, y + vy), getModel().getBlocks()) && vy > 0);
//            }
//        } else if (vy < 0) {
//            fireboy.setJumping(true);
//            while (getModel().collidesUp(new Position(x, y + vy), getModel().getBlocks()) && vy < 0) {
//                vy = Math.min(vy + 1, 0);
//            }
//        }
//
//        if (vx < 0) {
//            vx = Math.max(vx, -fireboy.getMaxVelocity().getX());
//            while (getModel().collidesLeft(new Position(x + vx, y + vy), getModel().getBlocks()) && vx < 0) {
//                vx = Math.min(vx + 1, 0);
//            }
//        } else if (vx > 0) {
//            vx = Math.min(vx, fireboy.getMaxVelocity().getY());
//            while (getModel().collidesRight(new Position(x + vx, y + vy), getModel().getBlocks()) && vx > 0) {
//                vx = Math.max(vx - 1, 0);
//            }
//        }
//
//        x += vx;
//        y += vy;
//
//        fireboy.setVelocity(new Position(vx, vy));
//        fireboy.setPosition(new Position(x, y));
//

    }




}
