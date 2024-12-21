package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Block;
import com.t09g01.projeto.view.Viewer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class BlockViewer implements ElementViewer<Block> {

    private final Viewer viewer;
    private final BufferedImage bufferedImage;


    public BlockViewer() throws IOException {
        viewer = new Viewer("blocks/brick.png");
        bufferedImage = Viewer.loadImage("blocks/brick.png");
    }

    @Override
    public void draw(Block block, GUI gui, BasicTextImage background) {
        TextImage textImage = viewer.convertTextImage(gui, bufferedImage);
        gui.drawStatic(block.getPosition(), textImage);
    }

}
