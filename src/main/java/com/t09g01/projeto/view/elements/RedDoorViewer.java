package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.RedDoor;
import com.t09g01.projeto.view.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class RedDoorViewer implements ElementViewer<RedDoor>{
    private Viewer viewer;
    private TextImage textImage;
    private BufferedImage bufferedImage;

    public RedDoorViewer() throws IOException {
        viewer = new Viewer("doors/firedoor.png");
        bufferedImage = Viewer.loadImage("doors/firedoor.png");
    }

    @Override
    public void draw(RedDoor redDoor, GUI gui, BasicTextImage background) {
        textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(redDoor.getPosition(), textImage);
    }
}
