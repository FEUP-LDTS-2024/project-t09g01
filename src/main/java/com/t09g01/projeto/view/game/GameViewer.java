package com.t09g01.projeto.view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Element;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.view.elements.*;

import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.List;



public class GameViewer extends ScreenViewer<Temple> {
    private BasicTextImage background;

    public GameViewer(Temple temple) {
        super(temple);
        this.background =  new BasicTextImage(temple.getHeight(), temple.getWidth());
    }

    public final static TextColor.RGB windowColor = new TextColor.RGB(76, 68, 87);


    @Override
    public void draw(GUI gui) throws IOException {

        gui.clear();

        gui.drawRectangle(0, 0, 320, 192, windowColor);
        drawElements(gui, getModel().getBlueDiamond(), new BlueDiamondViewer());
        drawElements(gui, getModel().getRedDiamond(), new RedDiamondViewer());
        drawElement(gui, getModel().getWatergirl(), new WatergirlViewer());
        drawElement(gui, getModel().getFireboy(), new FireboyViewer());
        drawElements(gui, getModel().getBlocks(), new BlockViewer());
        drawElements(gui, getModel().getLava(), new LavaViewer());
        drawElements(gui, getModel().getWater(), new WaterViewer());
        drawElements(gui, getModel().getGoo(), new GooViewer());


        gui.refresh();
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) throws IOException {
        viewer.draw(element, gui);
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) throws IOException {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }



}