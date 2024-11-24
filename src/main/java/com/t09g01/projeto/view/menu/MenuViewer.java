package com.t09g01.projeto.view.menu;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.view.game.ScreenViewer;

import java.io.IOException;

public class MenuViewer extends ScreenViewer<Menu> {
    public MenuViewer (Menu menu){super(menu);}

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.drawText(new Position(4, 4), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getEntriesNumber(); i++) {
            gui.drawText(new Position(4, 6 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#EDD711" : "#FFFFFF");
        }
        gui.refresh();
    }


}
