package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.model.menu.MainMenu;

public class MainMenuController extends MenuController<MainMenu>{
    public MainMenuController(MainMenu menu, EntryController entryController) {
        super(menu, entryController);
    }

    @Override
    protected void quit(Game game) {
        game.setState(null);
    }
}
