package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.model.game.temple.TempleBuilder;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.states.GameState;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

public class EntryController extends Controller<Menu>{

    public EntryController(Menu model) {super(model);}

    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) throws IOException, URISyntaxException, FontFormatException {
        for (ACTION action : currentActions){
            switch(getModel().getCurrentEntry().getType()) {
                case PLAY:
                    if(action == ACTION.SELECT) {
                        game.setState( new GameState(new TempleBuilder(1).createTemple(), game.getImageLoader() ));
                    }
                    break;

                case EXIT:
                    if(action==ACTION.SELECT) {
                        game.setState(null);
                    }
            }

        }
    }
}
