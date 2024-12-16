package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.Fireboy;
import com.t09g01.projeto.model.game.elements.Watergirl;
import com.t09g01.projeto.model.game.temple.Temple;

import java.util.Set;

public class WatergirlController extends Controller<Temple> {
    public WatergirlController(Temple temple){
        super(temple);
    }

//    public void moveWatergirl(Position position) {
//        if (!getModel().checkCollision(position, getModel().getBlocks())) {
//            getModel().getWatergirl().setPosition(position);
//            getModel().retrieveBlueDiamonds(position);
//        }
//    }
//
//
//    public void moveWatergirlRight(){
//        moveWatergirl(getModel().getWatergirl().getPosition().getRight());
//    }
//    public void moveWatergirlLeft(){
//        moveWatergirl(getModel().getWatergirl().getPosition().getLeft());
//    }
//    public void moveWatergirlUp(){
//        moveWatergirl(getModel().getWatergirl().getPosition().getUp());
//    }
//    public void moveWatergirlDown(){
//        moveWatergirl(getModel().getWatergirl().getPosition().getDown());
//    }

//    public void jumpWatergirl(){
//        Watergirl watergirl = getModel().getWatergirl();
//        watergirl.jump();
//
//    }
    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) {
        Watergirl watergirl = getModel().getWatergirl();
        double x = watergirl.getPosition().getX(), y = watergirl.getPosition().getY();
        double vx = watergirl.getVelocity().getX(), vy = watergirl.getVelocity().getY();
        vy += getModel().getGravity();
        for (ACTION action : currentActions) {

            switch (action) {
                case WATERGIRL_LEFT:
                    vx = Math.max(vx - watergirl.getAcceleration(), -watergirl.getMaxVelocity().getX());
                    break;
                case WATERGIRL_RIGHT:
                    vx = Math.min(vx + watergirl.getAcceleration(), watergirl.getMaxVelocity().getX());
                    break;
                case WATERGIRL_UP:
                    if (watergirl.hasLanded()) {
                        vy = -watergirl.getJumpBoost();
                        watergirl.setHasLanded(false);
                    }
                    break;
                default:
                    break;
            }
        }

        if (vy > 0) {
            watergirl.setFalling(true);
            watergirl.setHasLanded(false);
            watergirl.setJumping(false);

            vy = Math.min(vy, watergirl.getMaxVelocity().getY());
            if (getModel().collidesDown(new Position(x, y + vy), getModel().getBlocks())) {
                watergirl.setHasLanded(true);
                watergirl.setFalling(false);
                do {
                    vy = Math.max(vy - 1, 0);
                } while (getModel().collidesDown(new Position(x, y + vy), getModel().getBlocks()) && vy > 0);
            }
        } else if (vy < 0) {
            watergirl.setJumping(true);
            while (getModel().collidesUp(new Position(x, y + vy), getModel().getBlocks()) && vy < 0) {
                vy = Math.min(vy + 1, 0);
            }
        }

        if (vx < 0) {
            vx = Math.max(vx, -watergirl.getMaxVelocity().getX());
            while (getModel().collidesLeft(new Position(x + vx, y + vy), getModel().getBlocks()) && vx < 0) {
                vx = Math.min(vx + 1, 0);
            }
        } else if (vx > 0) {
            vx = Math.min(vx, watergirl.getMaxVelocity().getY());
            while (getModel().collidesRight(new Position(x + vx, y + vy), getModel().getBlocks()) && vx > 0) {
                vx = Math.max(vx - 1, 0);
            }
        }

        x += vx;
        y += vy;

        watergirl.setVelocity(new Position(vx, vy));
        watergirl.setPosition(new Position(x, y));
    }
}
