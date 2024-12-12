package com.t09g01.projeto.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.model.Position;

import java.awt.image.BufferedImage;
import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;

    void drawPixel(int x, int y, TextColor.RGB color);

    void drawText(Position position, String text, String color);

    void drawRectangle(double x, double y, int width, int height, TextColor color);

    public void drawStatic(Position position, TextImage image);

    public void drawMoving(Position position, BufferedImage image);

    public TextImage createTextImage(int width, int height);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}
