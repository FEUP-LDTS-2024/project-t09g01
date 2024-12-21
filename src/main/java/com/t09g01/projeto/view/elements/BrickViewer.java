package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Brick;
import com.t09g01.projeto.view.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class BrickViewer implements ElementViewer<Brick> {

    private final Viewer viewer;
    private final BufferedImage bufferedImage;


    public BrickViewer() throws IOException {
        viewer = new Viewer("blocks/brick.png");
        bufferedImage = Viewer.loadImage("blocks/brick.png");
    }

    @Override
    public void draw(Brick brick, GUI gui, BasicTextImage background) {
        TextImage textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(brick.getPosition(), textImage);
    }

}
