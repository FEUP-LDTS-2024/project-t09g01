package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Fireboy;
import com.t09g01.projeto.view.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class FireboyViewer implements ElementViewer <Fireboy>{

    private final BufferedImage image;

    public FireboyViewer() throws IOException {
        image = Viewer.loadImage("fireboy/fire.png");
    }

    @Override
    public void draw(Fireboy fireboy, GUI gui, BasicTextImage background) {
        gui.drawMoving(fireboy.getPosition(), image);
    }

}
