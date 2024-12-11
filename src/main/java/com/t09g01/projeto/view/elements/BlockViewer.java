package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Block;
import com.t09g01.projeto.model.game.elements.Watergirl;
import com.t09g01.projeto.view.Viewer;

import java.io.IOException;

public class BlockViewer implements ElementViewer<Block> {

    private Viewer viewer;

    public BlockViewer() throws IOException {
        viewer = new Viewer("blocks/brick.png");
    }

    @Override
    public void draw(Block block, GUI gui) {
        viewer.draw(gui, block.getPosition().getX(), block.getPosition().getY());
    }

}
