package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.view.Viewer;
import com.t09g01.projeto.model.game.elements.BlueDoor;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class BlueDoorViewer implements ElementViewer<BlueDoor>{
    private Viewer viewer;
    private TextImage textImage;
    private BufferedImage bufferedImage;

    public BlueDoorViewer() throws IOException {
        viewer = new Viewer("doors/waterdoor.png");
        bufferedImage = Viewer.loadImage("doors/waterdoor.png");
    }

    @Override
    public void draw(BlueDoor blueDoor, GUI gui) {
        textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(blueDoor.getPosition(), textImage);
    }
}
