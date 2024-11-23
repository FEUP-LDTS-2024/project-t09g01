package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Block;

public class BlockViewer implements ElementViewer<Block> {

    @Override
    public void draw(Block block, GUI gui) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gui.drawPixel(block.getPosition().getX() + i, block.getPosition().getY() + j, new TextColor.RGB(28, 46, 22));
            }
        }
    }
}
