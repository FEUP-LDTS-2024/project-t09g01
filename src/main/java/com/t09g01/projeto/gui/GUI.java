package com.t09g01.projeto.gui;

import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.model.Position;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawPixel(int x, int y, TextColor.RGB color);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}
