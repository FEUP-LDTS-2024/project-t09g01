package com.t09g01.projeto.view.screens;

import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.view.game.ScreenViewer;
import com.t09g01.projeto.view.text.ViewerProvider;
import com.t09g01.projeto.model.menu.Entry;

import java.io.IOException;
import java.util.List;

public class MenuViewer<T extends Menu> extends ScreenViewer<T> {
    private final EntryViewer entryViewer;
    private final LogoViewer logoViewer;

    public static final TextColor unselectedColor = new TextColor.RGB(255, 255, 255);
    public static final TextColor selectedColor = new TextColor.RGB(255, 195, 0);
    public static final TextColor backgroundColor = new TextColor.RGB(0, 0, 0);


    public MenuViewer (T menu, ViewerProvider viewerProvider){
        super(menu);
        this.entryViewer = viewerProvider.getEntryViewer();
        this.logoViewer = viewerProvider.getLogoViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawBackground(gui, backgroundColor);
        drawEntries(gui, getModel().getEntries());
        logoViewer.draw(gui, 112, 30);
        gui.refresh();
    }

    private void drawEntries(GUI gui, List<Entry> entries) {
        for(Entry entry : entries)
            entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
    }
}
