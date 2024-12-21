package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Water;
import com.t09g01.projeto.view.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class WaterViewer implements ElementViewer<Water> {

    private Viewer viewer;
    private TextImage textImage;
    private BufferedImage bufferedImage;

    public WaterViewer() throws IOException {
        viewer = new Viewer("blocks/agua.png");
        bufferedImage = Viewer.loadImage("blocks/agua.png");
    }

    @Override
    public void draw(Water water, GUI gui, BasicTextImage background) {
        textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(water.getPosition(), textImage);
    }
}
