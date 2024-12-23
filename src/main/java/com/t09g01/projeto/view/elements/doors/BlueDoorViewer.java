package com.t09g01.projeto.view.elements.doors;

import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.view.Viewer;
import com.t09g01.projeto.model.game.elements.doors.BlueDoor;
import com.t09g01.projeto.view.elements.ElementViewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class BlueDoorViewer implements ElementViewer<BlueDoor> {
    private final Viewer viewer;
    private final BufferedImage bufferedImage;

    public BlueDoorViewer() throws IOException {
        viewer = new Viewer("doors/waterdoor.png");
        bufferedImage = Viewer.loadImage("doors/waterdoor.png");
    }

    @Override
    public void draw(BlueDoor blueDoor, GUI gui) {
        TextImage textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(blueDoor.getPosition(), textImage);
    }
}
