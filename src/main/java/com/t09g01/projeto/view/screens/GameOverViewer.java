package com.t09g01.projeto.view.screens;

import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.gameover.GameOver;
import com.t09g01.projeto.model.menu.Entry;
import com.t09g01.projeto.view.Viewer;
import com.t09g01.projeto.view.game.ScreenViewer;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.view.text.TextViewer;
import com.t09g01.projeto.view.text.ViewerProvider;

import java.io.IOException;
import java.util.List;

public class GameOverViewer<T extends Menu> extends ScreenViewer<GameOver> {

    private final EntryViewer entryViewer;
    private final TextViewer textViewer;

    public static final TextColor unselectedColor = new TextColor.RGB(255, 255, 255);
    public static final TextColor selectedColor = new TextColor.RGB(255, 195, 0);
    public static final TextColor backgroundColor = new TextColor.RGB(0, 10, 32);
    public static final TextColor titleColor = new TextColor.RGB(209, 41, 29);

    public GameOverViewer(GameOver gameOver, ViewerProvider viewerProvider) {
        super(gameOver);
        this.entryViewer  = viewerProvider.getEntryViewer();
        this.textViewer = viewerProvider.getTextViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawBackground(gui, backgroundColor);
        textViewer.draw("GAME OVER", 145, 60, titleColor, gui);

        drawEntries(gui, getModel().getEntries());
        gui.refresh();
    }

    private void drawEntries(GUI gui, List<Entry> entries) {
        for(Entry entry : entries)
            entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
    }
}
