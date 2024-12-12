package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.game.temple.Temple;

import java.util.Set;

import static com.t09g01.projeto.gui.ACTION.QUIT;

public class TempleController extends Controller<Temple> {
    private final FireboyController fireboyController;
    private final WatergirlController watergirlController;

    public TempleController(Temple temple, FireboyController fireboyController, WatergirlController watergirlController){
        super(temple);
        this.fireboyController = fireboyController;
        this.watergirlController = watergirlController;
    }

    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) {
        for (ACTION action : currentActions){
            if (action == QUIT){
                game.setState(null);
            }
            else{
                fireboyController.step(game, currentActions, time);
                watergirlController.step(game, currentActions, time);
            }
        }

    }

}
