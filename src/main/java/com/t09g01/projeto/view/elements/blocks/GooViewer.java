package com.t09g01.projeto.view.elements.blocks;

import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.blocks.Goo;
import com.t09g01.projeto.view.Viewer;
import com.t09g01.projeto.view.elements.ElementViewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class GooViewer implements ElementViewer<Goo> {

    private final Viewer viewer;
    private final BufferedImage bufferedImage;

    public GooViewer() throws IOException {
        viewer = new Viewer("blocks/goo.png");
        bufferedImage = Viewer.loadImage("blocks/goo.png");
    }

    @Override
    public void draw(Goo goo, GUI gui) {
        TextImage textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(goo.getPosition(), textImage);
    }
}
