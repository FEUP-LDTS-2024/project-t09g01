package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.game.elements.Fireboy;
import com.t09g01.projeto.model.game.elements.Watergirl;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.model.game.temple.TempleBuilder;
import com.t09g01.projeto.model.gameover.GameOver;
import com.t09g01.projeto.model.menu.MainMenu;
import com.t09g01.projeto.states.GameOverState;
import com.t09g01.projeto.states.GameState;
import com.t09g01.projeto.states.MainMenuState;

import java.io.IOException;
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
    public void step(Game game, Set<ACTION> currentActions, long time) throws IOException {
        Fireboy fireboy = getModel().getFireboy();
        Watergirl watergirl = getModel().getWatergirl();
        for (ACTION action : currentActions){
            if (action == QUIT){
                quit(game);
                break;
            }
            else{
                fireboyController.step(game, currentActions, time);
                watergirlController.step(game, currentActions, time);
            }

            if (watergirl.isDead() || fireboy.isDead()){
                game.setState(new GameOverState(new GameOver(), game.getImageLoader()));
            }

            if (watergirl.isOnDoor() && fireboy.isOnDoor() && getModel().allDiamondsCollected()){
                System.out.println(getModel().getLevel());
                TempleBuilder templeBuilder = new TempleBuilder((getModel().getLevel() + 1));
                Temple newTemple = templeBuilder.createTemple();
                game.setState(new GameState(newTemple, game.getImageLoader()));
            }
        }
    }

    private void quit(Game game) throws IOException {
        game.setState(new MainMenuState(new MainMenu(), game.getImageLoader()));
    }

}
