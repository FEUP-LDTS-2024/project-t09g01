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

public class EntryController extends Controller<Menu>{

    public EntryController(Menu model) {super(model);}

    @Override
    public void step(Game game, ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch(getModel().getCurrentEntry().getType()) {
            case PLAY:
                if(action==ACTION.SELECT) {
                    game.setState( new GameState(new TempleBuilder().createTemple() ));
                }
                break;

            case EXIT:
                if(action==ACTION.SELECT) {
                    game.setState(new GameState(new Game(), game.getImageLoader()));
                }
        }
    }
}
