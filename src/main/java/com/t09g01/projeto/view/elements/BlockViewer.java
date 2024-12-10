package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Block;

public class BlockViewer implements ElementViewer<Block> {

    @Override
    public void draw(Block block, GUI gui) {

        gui.drawPixel(block.getPosition().getX() * 32 , block.getPosition().getY() * 32, new TextColor.RGB(28, 46, 22));
    }
}
