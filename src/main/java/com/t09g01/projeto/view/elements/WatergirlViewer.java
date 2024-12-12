package com.t09g01.projeto.view.elements;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Watergirl;
import com.t09g01.projeto.view.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class WatergirlViewer implements ElementViewer <Watergirl>{

    private BufferedImage image;

    public WatergirlViewer() throws IOException {
        image = Viewer.loadImage("watergirl/water.png");
    }

    @Override
    public void draw(Watergirl watergirl, GUI gui) {
        gui.drawMoving(watergirl.getPosition(), image);
    }

}
