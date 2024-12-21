package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.model.gameover.Credits;

public class CreditsController extends MenuController<Credits> {
    public CreditsController(Credits credits, EntryController entryController) {super(credits, entryController);}

    @Override
    protected void quit(Game game) {
        game.setState(null);
    }
}
