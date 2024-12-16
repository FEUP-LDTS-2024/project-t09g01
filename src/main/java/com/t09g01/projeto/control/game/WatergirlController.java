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

    public void moveWatergirl(Position position) {
        if (!getModel().checkCollisions(position)) {
            getModel().getWatergirl().setPosition(position);
            getModel().retrieveBlueDiamonds(position);
        }
    }


    public void moveWatergirlRight(){
        moveWatergirl(getModel().getWatergirl().getPosition().getRight());
    }
    public void moveWatergirlLeft(){
        moveWatergirl(getModel().getWatergirl().getPosition().getLeft());
    }
    public void moveWatergirlUp(){
        moveWatergirl(getModel().getWatergirl().getPosition().getUp());
    }
    public void moveWatergirlDown(){
        moveWatergirl(getModel().getWatergirl().getPosition().getDown());
    }

//    public void jumpWatergirl(){
//        Watergirl watergirl = getModel().getWatergirl();
//        watergirl.jump();
//
//    }
    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) {
        Watergirl watergirl = getModel().getWatergirl();
        for (ACTION action : currentActions){
            switch (action) {
                case WATERGIRL_UP -> moveWatergirlUp();
                case WATERGIRL_DOWN -> moveWatergirlDown();
                case WATERGIRL_LEFT -> moveWatergirlLeft();
                case WATERGIRL_RIGHT -> moveWatergirlRight();
            }
        }
        //watergirl.defyingGravity();
        //watergirl.update();
    }
}
