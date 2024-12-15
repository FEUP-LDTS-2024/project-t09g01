package com.t09g01.projeto.view.elements;


import com.googlecode.lanterna.graphics.BasicTextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.BlueDiamond;
import com.t09g01.projeto.view.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class BlueDiamondViewer implements ElementViewer<BlueDiamond> {
    private BufferedImage image;

    public BlueDiamondViewer() throws IOException {
        image = Viewer.loadImage("diamonds/blue_diamond.png");
    }

    @Override
    public void draw(BlueDiamond blueDiamond, GUI gui, BasicTextImage background) {
        gui.drawMoving(blueDiamond.getPosition(), image);
    }

}
