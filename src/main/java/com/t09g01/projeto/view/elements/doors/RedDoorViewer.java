package com.t09g01.projeto.view.elements.doors;

import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.doors.RedDoor;
import com.t09g01.projeto.view.Viewer;
import com.t09g01.projeto.view.elements.ElementViewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class RedDoorViewer implements ElementViewer<RedDoor> {
    private final Viewer viewer;
    private final BufferedImage bufferedImage;

    public RedDoorViewer() throws IOException {
        viewer = new Viewer("doors/firedoor.png");
        bufferedImage = Viewer.loadImage("doors/firedoor.png");
    }

    @Override
    public void draw(RedDoor redDoor, GUI gui) {
        TextImage textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(redDoor.getPosition(), textImage);
    }
}
