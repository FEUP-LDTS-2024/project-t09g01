package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Lava;
import com.t09g01.projeto.view.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class LavaViewer implements ElementViewer<Lava> {

    private final Viewer viewer;
    private final BufferedImage bufferedImage;

    public LavaViewer() throws IOException {
        viewer = new Viewer("blocks/lava.png");
        bufferedImage = Viewer.loadImage("blocks/lava.png");
    }

    @Override
    public void draw(Lava lava, GUI gui, BasicTextImage background) {
        TextImage textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(lava.getPosition(), textImage);
    }
}
