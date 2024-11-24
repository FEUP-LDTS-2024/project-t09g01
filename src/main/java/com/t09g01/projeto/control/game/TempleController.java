package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.game.temple.Temple;

import static com.t09g01.projeto.gui.ACTION.QUIT;

public class TempleController extends Controller<Temple> {
    private final FireboyController fireboyController;
    private final WatergirlController watergirlController;

    public TempleController(Temple temple){
        super(temple);
        this.fireboyController = new FireboyController(temple);
        this.watergirlController = new WatergirlController(temple);
    }

    @Override
    public void step(Game game, ACTION action, long time) {
        if (action == QUIT){
            game.setState(null);
        }
        else{
            fireboyController.step(game, action, time);
            watergirlController.step(game, action, time);
        }
    }

}
