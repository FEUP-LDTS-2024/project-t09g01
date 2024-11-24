package com.t09g01.projeto.view.game;

import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Element;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.view.elements.BlockViewer;
import com.t09g01.projeto.view.elements.ElementViewer;
import com.t09g01.projeto.view.elements.FireboyViewer;
import com.t09g01.projeto.view.elements.WatergirlViewer;

import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.List;

public class GameViewer extends ScreenViewer<Temple> {
    public GameViewer(Temple temple) {
        super(temple);
    }

    @Override
    public void draw(GUI gui) throws IOException {

        gui.clear();

        TextColor.RGB windowColor = new TextColor.RGB(125, 110, 95);

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j< 24; j++) {
                gui.drawPixel(i, j, windowColor);
            }
        }
        drawElement(gui, getModel().getWatergirl(), new WatergirlViewer());
        drawElement(gui, getModel().getFireboy(), new FireboyViewer());
        drawElements(gui, getModel().getBlocks(), new BlockViewer());

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