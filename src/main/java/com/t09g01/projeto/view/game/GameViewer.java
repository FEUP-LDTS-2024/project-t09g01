package com.t09g01.projeto.view.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.Element;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.view.elements.*;
import com.t09g01.projeto.view.elements.blocks.BrickViewer;
import com.t09g01.projeto.view.elements.blocks.GooViewer;
import com.t09g01.projeto.view.elements.blocks.LavaViewer;
import com.t09g01.projeto.view.elements.blocks.WaterViewer;
import com.t09g01.projeto.view.elements.diamonds.BlueDiamondViewer;
import com.t09g01.projeto.view.elements.diamonds.RedDiamondViewer;
import com.t09g01.projeto.view.elements.doors.BlueDoorViewer;
import com.t09g01.projeto.view.elements.doors.RedDoorViewer;
import com.t09g01.projeto.view.elements.players.FireboyViewer;
import com.t09g01.projeto.view.elements.players.WatergirlViewer;
import com.t09g01.projeto.view.screens.ScreenViewer;
import com.t09g01.projeto.view.text.ViewerProvider;

import java.io.IOException;
import java.util.List;

public class GameViewer extends ScreenViewer<Temple> {
    private final BasicTextImage background;

    public GameViewer(Temple temple, ViewerProvider viewerProvider) {
        super(temple);
        this.background =  new BasicTextImage(temple.getHeight(), temple.getWidth());
    }

    public final static TextColor.RGB windowColor = new TextColor.RGB(76, 68, 87);

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.drawStatic(new Position(320,192), background);
        gui.drawRectangle(0, 0, 320, 192, windowColor);
        drawElements(gui, getModel().getBlueDiamond(), new BlueDiamondViewer());
        drawElements(gui, getModel().getRedDiamond(), new RedDiamondViewer());
        drawElement(gui, getModel().getWatergirl(), new WatergirlViewer());
        drawElement(gui, getModel().getFireboy(), new FireboyViewer());
        drawElements(gui, getModel().getBricks(), new BrickViewer());
        drawElements(gui, getModel().getLava(), new LavaViewer());
        drawElements(gui, getModel().getWater(), new WaterViewer());
        drawElements(gui, getModel().getGoo(), new GooViewer());
        drawElement(gui, getModel().getBlueDoor(), new BlueDoorViewer());
        drawElement(gui, getModel().getRedDoor(), new RedDoorViewer());
        gui.refresh();
    }

    public BasicTextImage getBackground() { return background; }

    <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }



}