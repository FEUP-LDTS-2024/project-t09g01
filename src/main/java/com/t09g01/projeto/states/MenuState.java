package com.t09g01.projeto.states;

import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.control.menu.MenuController;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.view.game.ScreenViewer;
import com.t09g01.projeto.view.menu.MenuViewer;

public class MenuState extends State<Menu>{
    public MenuState(Menu menu) {super(menu);}

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }

    @Override
    protected ScreenViewer<Menu> getScreenViewer() {
        return new MenuViewer(getModel());
    }
}
