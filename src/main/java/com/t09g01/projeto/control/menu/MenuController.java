package com.t09g01.projeto.control.menu;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.game.temple.TempleBuilder;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {super(menu);}

    @Override
    public void step(Game game, ACTION action, long time) throws IOException {
        switch (action){
            case FIREBOY_UP:
                getModel().previousEntry();
                break;
            case FIREBOY_DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if(getModel().isSelectedStart()){
                    game.setState(new GameState(new TempleBuilder().createTemple()));
                }
                if (getModel().isSelectedExit()){
                    game.setState(null);
                }
        }
    }
}
