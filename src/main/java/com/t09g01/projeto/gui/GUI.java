package com.t09g01.projeto.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.model.Position;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Set;
import com.googlecode.lanterna.screen.Screen;

public interface GUI {
    Screen getScreen();

    public Set<ACTION> getCurrentActions();
//    ACTION getNextAction() throws IOException;

    void drawPixel(int x, int y, TextColor.RGB color);

    void drawText(Position position, String text, String color);

    void drawRectangle(double x, double y, int width, int height, TextColor color);

    public void drawStatic(Position position, TextImage image);

    public void drawMoving(Position position, BufferedImage image);

    public void drawTextImage(Position position, BufferedImage image, TextImage background);

    public TextImage createTextImage(int width, int height);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}
