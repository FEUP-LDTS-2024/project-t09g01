package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Goo;
import com.t09g01.projeto.view.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class GooViewer implements ElementViewer<Goo> {

    private Viewer viewer;
    private TextImage textImage;
    private BufferedImage bufferedImage;

    public GooViewer() throws IOException {
        viewer = new Viewer("blocks/goo.png");
        bufferedImage = Viewer.loadImage("blocks/goo.png");
    }

    @Override
    public void draw(Goo goo, GUI gui, BasicTextImage background) {
        textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(goo.getPosition(), textImage);
    }
}
