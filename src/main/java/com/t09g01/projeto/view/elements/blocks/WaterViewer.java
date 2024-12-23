package com.t09g01.projeto.view.elements.blocks;

import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.blocks.Water;
import com.t09g01.projeto.view.Viewer;
import com.t09g01.projeto.view.elements.ElementViewer;

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
    public void draw(Water water, GUI gui) {
        textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(water.getPosition(), textImage);
    }
}
