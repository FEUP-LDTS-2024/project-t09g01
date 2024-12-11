package com.t09g01.projeto.view.elements;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Fireboy;
import com.t09g01.projeto.view.Viewer;

import java.io.IOException;

public class FireboyViewer implements ElementViewer <Fireboy>{

    private Viewer viewer;

    public FireboyViewer() throws IOException {
        viewer = new Viewer("fireboy/fire.png");
    }

    @Override
    public void draw(Fireboy fireboy, GUI gui) {
        viewer.draw(gui, fireboy.getPosition().getX(), fireboy.getPosition().getY());
    }

}
