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

//    public void moveFireboy(Position position) {
//        if (!getModel().checkCollisions(position)){
//            getModel().getFireboy().setPosition(position);
//            getModel().retrieveRedDiamonds(position);
//        }
//    }
//
//    public void moveFireboyRight(){
//        moveFireboy(getModel().getFireboy().getPosition().getRight());
//    }
//    public void moveFireboyLeft(){
//        moveFireboy(getModel().getFireboy().getPosition().getLeft());
//    }
//    public void moveFireboyUp(){
//        moveFireboy(getModel().getFireboy().getPosition().getUp());
//    }
//    public void moveFireboyDown(){
//        moveFireboy(getModel().getFireboy().getPosition().getDown());
//    }

    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) {
//        Fireboy fireboy = getModel().getFireboy();
//        if (!isJumping) checkLanding();
//        else canJump = true;
//        for (ACTION action : currentActions) {
//            switch (action) {
//                case FIREBOY_UP:
//                    if (!isJumping && canJump) {
//                        getModel().getFireboy().setPosition(new Position(getModel().getFireboy().getPosition().getX(), groundY - 1));
//                        jump(time);
//                    }
//                    break;
//                case FIREBOY_LEFT:
//                    moveLEFT();
//                    break;
//                case FIREBOY_RIGHT:
//                    moveRIGHT();
//                    break;
//                default:
//
//            }
//
//        }
//        System.out.println("Current Actions: " + currentActions);
//        System.out.println("Fireboy Position: x:" + fireboy.getPosition().getX() + " y:" + fireboy.getPosition().getY());
//        System.out.println("Is Jumping: " + isJumping + ", Can Jump: " + canJump);
//        System.out.println("----------------------");
//
//        if (isJumping) jumpUpdate(time);
//    }
//
//    public void lookForFloorCollision() {
//        for (Block block : getModel().getBlocks()) {
////            if (getModel().floorCollision(getModel().getFireboy().getPosition())){
////                isJumping = false;
////                canJump = true;
////                break;
////            }
//            if (getModel().getFireboy().getPolygon().intersects(block.getPolygon().getBounds2D())) {
//                groundY = (int) block.getPolygon().getBounds().getMinY();
//                getModel().getFireboy().setPosition(new Position(getModel().getFireboy().getPosition().getX(), groundY - 2));
//                isJumping = false;
//                canJump = true;
//                break; // Exit the loop after the first collision
//            }
//        }
//    }
//
//    public void checkLanding() {
//        canJump = false;
//        lookForFloorCollision();
//        if (!isJumping){
//            int y = (int) (getModel().getFireboy().getPosition().getY() + (getModel().getFireboy().getVelocity() * 0.01 - 0.5 * getModel().getFireboy().getGravity() * 0.001));
//            getModel().getFireboy().setPosition(new Position(getModel().getFireboy().getPosition().getX(), y));
//        }
//    }
//
//    public void jump(long time) {
//        isJumping = true;
//        jumpStartTime = time;
//        canJump = false;
//        groundY = getModel().getFireboy().getPosition().getY();
//    }
//
//    public void jumpUpdate(long time) {
//        double x = getModel().getFireboy().getPosition().getX();
//
//        double elapsedTime = (time - jumpStartTime) / 1000.0;
//
//        int y = (int) (groundY - (getModel().getFireboy().getVelocity() * elapsedTime - 0.5 * getModel().getFireboy().getGravity() * elapsedTime * elapsedTime));
//
//        getModel().getFireboy().setPosition(new Position(x, y));
//
//        if (y > previousY) lookForFloorCollision();
//        previousY = y;
//
//    }
//
//    public void moveLEFT() {
//        Fireboy fireboy = getModel().getFireboy();
//        double x = fireboy.getPosition().getX();
//        double y = fireboy.getPosition().getY();
//        Position newPosition = new Position(x - fireboy.getHorizontalSpeed(), y);
//
//        if (!getModel().checkCollisions(newPosition)) {
//            fireboy.setPosition(newPosition);
//            fireboy.setDirection(false);
//        }
//    }
//
//    public void moveRIGHT() {
//        Fireboy fireboy = getModel().getFireboy();
//        double x = fireboy.getPosition().getX();
//        double y = fireboy.getPosition().getY();
//        Position newPosition = new Position(x + fireboy.getHorizontalSpeed(), y);
//
//        if (!getModel().checkCollisions(newPosition)) {
//            fireboy.setPosition(newPosition);
//            fireboy.setDirection(true);
//        }
//    }


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
                default:
                    break;
            }
        }

        if (vy > 0) {
            fireboy.setFalling(true);
            fireboy.setHasLanded(false);
            fireboy.setJumping(false);

            vy = Math.min(vy, fireboy.getMaxVelocity().getY());
            if (getModel().collidesDown(new Position(x, y + vy), getModel().getBlocks())) {
                fireboy.setHasLanded(true);
                fireboy.setFalling(false);
                do {
                    vy = Math.max(vy - 1, 0);
                } while (getModel().collidesDown(new Position(x, y + vy), getModel().getBlocks()) && vy > 0);
            }
        } else if (vy < 0) {
            fireboy.setJumping(true);
            while (getModel().collidesUp(new Position(x, y + vy), getModel().getBlocks()) && vy < 0) {
                vy = Math.min(vy + 1, 0);
            }
        }

        if (vx < 0) {
            vx = Math.max(vx, -fireboy.getMaxVelocity().getX());
            while (getModel().collidesLeft(new Position(x + vx, y + vy), getModel().getBlocks()) && vx < 0) {
                vx = Math.min(vx + 1, 0);
            }
        } else if (vx > 0) {
            vx = Math.min(vx, fireboy.getMaxVelocity().getY());
            while (getModel().collidesRight(new Position(x + vx, y + vy), getModel().getBlocks()) && vx > 0) {
                vx = Math.max(vx - 1, 0);
            }
        }

        x += vx;
        y += vy;

        fireboy.setVelocity(new Position(vx, vy));
        fireboy.setPosition(new Position(x, y));


    }




}
