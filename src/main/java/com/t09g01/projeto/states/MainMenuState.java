package com.t09g01.projeto.states;

import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.control.screens.EntryController;
import com.t09g01.projeto.control.screens.MainMenuController;
import com.t09g01.projeto.control.screens.MenuController;
import com.t09g01.projeto.model.menu.MainMenu;
import com.t09g01.projeto.view.ImageLoader;
import com.t09g01.projeto.view.game.ScreenViewer;
import com.t09g01.projeto.view.screens.MenuViewer;
import com.t09g01.projeto.view.text.ViewerProvider;

import java.io.IOException;

public class MainMenuState extends State<MainMenu>{
    public MainMenuState(MainMenu menu, ImageLoader imageLoader) throws IOException {
        super(menu, imageLoader);
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel(), new EntryController(getModel()));
    }

    @Override
    protected ScreenViewer<MainMenu> getScreenViewer(ViewerProvider viewerProvider) {
        return new MenuViewer<>(getModel(), viewerProvider);
    }
}
