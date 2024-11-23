package com.t09g01.projeto.view.elements;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Watergirl;
import com.t09g01.projeto.view.Viewer;

import java.io.IOException;

public class WatergirlViewer implements ElementViewer <Watergirl>{

    private Viewer viewer;

    public WatergirlViewer() throws IOException {
        viewer = new Viewer("watergirl/watergirl.png");
    }

    @Override
    public void draw(Watergirl watergirl, GUI gui) { viewer.draw(gui, watergirl.getPosition().getX(), watergirl.getPosition().getY()); }

}
