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

    Set<ACTION> getCurrentActions();

    void drawPixel(int x, int y, TextColor.RGB color);

    void drawRectangle(double x, double y, int width, int height, TextColor color);

    void drawStatic(Position position, TextImage image);

    void drawMoving(Position position, BufferedImage image);

    void drawTextImage(Position position, BufferedImage image, TextImage background);

    TextImage createTextImage(int width, int height);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

}
