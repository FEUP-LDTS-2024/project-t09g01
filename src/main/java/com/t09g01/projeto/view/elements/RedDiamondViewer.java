package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;

import com.t09g01.projeto.model.game.elements.RedDiamond;
import com.t09g01.projeto.model.game.elements.Watergirl;
import com.t09g01.projeto.view.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class RedDiamondViewer implements ElementViewer<RedDiamond> {
    private BufferedImage image;

    public RedDiamondViewer() throws IOException {
        image = Viewer.loadImage("diamonds/red_diamond.png");
    }

    @Override
    public void draw(RedDiamond redDiamond, GUI gui, BasicTextImage background) {
        gui.drawMoving(redDiamond.getPosition(), image);
    }
}
