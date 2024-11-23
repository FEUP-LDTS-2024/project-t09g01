package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;

public class WatergirlController extends Controller<Temple> {
    public WatergirlController(Temple temple){
        super(temple);
    }
    public void moveWatergirl(Position position) {this.getModel().getWatergirl().setPosition(position);}

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

    @Override
    public void step(Game game, ACTION action, long time) {
        switch (action) {
            case WATERGIRL_UP -> moveWatergirlUp();
            case WATERGIRL_DOWN -> moveWatergirlDown();
            case WATERGIRL_LEFT -> moveWatergirlLeft();
            case WATERGIRL_RIGHT -> moveWatergirlRight();
        }
    }
}
