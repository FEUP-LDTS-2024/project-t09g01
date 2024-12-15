package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.game.temple.TempleBuilder;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.states.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

public abstract class MenuController<T extends Menu> extends Controller<T> {
    private final EntryController entryController;

    public MenuController(T menu, EntryController entryController) {
        super(menu);
        this.entryController = entryController;
    }

    @Override
    public void step(Game game, Set<ACTION> currentActions, long time) throws IOException, URISyntaxException, FontFormatException {
        for (ACTION action : currentActions){
            switch (action){
                case FIREBOY_UP:
                    getModel().previousEntry();
                    break;
                case FIREBOY_DOWN:
                    getModel().nextEntry();
                    break;
                case SELECT:
                    try {
                        quit(game);
                    } catch(FontFormatException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    entryController.step(game, currentActions, time);
            }
        }
    }

    protected abstract void quit(Game game) throws IOException, FontFormatException, URISyntaxException;
}
