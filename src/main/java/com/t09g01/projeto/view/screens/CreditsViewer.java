package com.t09g01.projeto.view.screens;

import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.menu.Entry;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.view.text.TextViewer;
import com.t09g01.projeto.view.text.ViewerProvider;
import com.t09g01.projeto.model.screens.Credits;

import java.io.IOException;
import java.util.List;


public class CreditsViewer<T extends Menu> extends ScreenViewer<Credits> {
    private final EntryViewer entryViewer;
    private final TextViewer textViewer;

    public static final TextColor unselectedColor = new TextColor.RGB(255, 255, 255);
    public static final TextColor selectedColor = new TextColor.RGB(255, 195, 0);
    public static final TextColor backgroundColor = new TextColor.RGB(0, 0, 0);
    public static final TextColor titleColor = new TextColor.RGB(179, 67, 204);

    public CreditsViewer(Credits credits, ViewerProvider viewerProvider) {
        super(credits);
        this.entryViewer  = viewerProvider.getEntryViewer();
        this.textViewer = viewerProvider.getTextViewer();
    }

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        drawBackground(gui, backgroundColor);
        textViewer.draw("THANKS FOR PLAYING", 127, 30, titleColor, gui);
        textViewer.draw("CLASS 09 GROUP 01", 128, 50, titleColor, gui);
        textViewer.draw("CAROLINA FERREIRA", 128, 58, titleColor, gui);
        textViewer.draw("CONSTANCA FERREIRA", 128, 64, titleColor, gui);
        textViewer.draw("MARIA LUIZA VIEIRA", 128, 70, titleColor, gui);
        drawEntries(gui, getModel().getEntries());
        gui.refresh();
    }

    private void drawEntries(GUI gui, List<Entry> entries) {
        for(Entry entry : entries)
            entryViewer.draw(entry, gui, getModel().getCurrentEntry() == entry ? selectedColor : unselectedColor);
    }
}
