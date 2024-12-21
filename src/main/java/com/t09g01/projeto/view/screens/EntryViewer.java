package com.t09g01.projeto.view.screens;

import com.t09g01.projeto.gui.GUI;
import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.view.text.TextViewer;
import com.t09g01.projeto.model.menu.Entry;

public class EntryViewer {
    private final TextViewer textViewer;

    public EntryViewer(TextViewer textViewer) {
        this.textViewer = textViewer;
    }

    public void draw(Entry model, GUI gui, TextColor color) {
        String entryText = switch (model.getType()) {
            case PLAY -> "PLAY";
            case EXIT -> "EXIT";
            case RETRY -> "RETRY";
            case RETURN_MENU -> "RETURN TO MENU";
        };

        textViewer.draw(entryText, (int) model.getPosition().getX(), (int) model.getPosition().getY(), color, gui);

    }
}
