package com.t09g01.projeto.view.elements.players;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.players.Watergirl;
import com.t09g01.projeto.view.Viewer;
import com.t09g01.projeto.view.elements.ElementViewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class WatergirlViewer implements ElementViewer<Watergirl> {

    private final BufferedImage image;

    public WatergirlViewer() throws IOException {
        image = Viewer.loadImage("watergirl/water.png");
    }

    @Override
    public void draw(Watergirl watergirl, GUI gui, BasicTextImage background) {
        gui.drawMoving(watergirl.getPosition(), image);
    }

}
