package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;

import java.util.Set;

public class WatergirlController extends Controller<Temple> {
    public WatergirlController(Temple temple){
        super(temple);
    }

    public void moveWatergirl(Position position) {
        getModel().getWatergirl().setPosition(position);
        getModel().retrieveBlueDiamonds(position);
    }

    public void moveWatergirlRight(){
        if (!getModel().collidesRight(getModel().getWatergirl().getPosition().getRight(), getModel().getBlocks())){
            moveWatergirl(getModel().getWatergirl().getPosition().getRight());
        }
    }
    public void moveWatergirlLeft(){
        if (!getModel().collidesLeft(getModel().getWatergirl().getPosition().getLeft(), getModel().getBlocks())){
            moveWatergirl(getModel().getWatergirl().getPosition().getLeft());
        }
    }
    public void moveWatergirlUp(){
        if (!getModel().collidesUp(getModel().getWatergirl().getPosition().getUp(), getModel().getBlocks())){
            moveWatergirl(getModel().getWatergirl().getPosition().getUp());
        }
    }
    public void moveWatergirlDown(){
        if (!getModel().collidesDown(getModel().getWatergirl().getPosition().getDown(), getModel().getBlocks())){
            moveWatergirl(getModel().getWatergirl().getPosition().getDown());
        }
    }
    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) {
        for (ACTION action : currentActions){
            switch (action){
                case WATERGIRL_UP:
                    moveWatergirlUp();
                    break;
                case WATERGIRL_DOWN:
                    moveWatergirlDown();
                    break;
                case WATERGIRL_LEFT:
                    moveWatergirlLeft();
                    break;
                case WATERGIRL_RIGHT:
                    moveWatergirlRight();
                    break;
            }
        }
    }
}
