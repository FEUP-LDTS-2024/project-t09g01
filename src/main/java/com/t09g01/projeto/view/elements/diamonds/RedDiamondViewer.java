package com.t09g01.projeto.view.elements.diamonds;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.diamonds.RedDiamond;
import com.t09g01.projeto.view.Viewer;
import com.t09g01.projeto.view.elements.ElementViewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class RedDiamondViewer implements ElementViewer<RedDiamond> {
    private final BufferedImage image;

    public RedDiamondViewer() throws IOException {
        image = Viewer.loadImage("diamonds/red_diamond.png");
    }

    @Override
    public void draw(RedDiamond redDiamond, GUI gui, BasicTextImage background) {
        gui.drawMoving(redDiamond.getPosition(), image);
    }
}
