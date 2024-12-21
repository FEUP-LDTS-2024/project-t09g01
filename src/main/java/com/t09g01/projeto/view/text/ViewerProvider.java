package com.t09g01.projeto.view.text;

import com.t09g01.projeto.view.ImageLoader;
import com.t09g01.projeto.view.elements.*;
import com.t09g01.projeto.view.screens.EntryViewer;
import com.t09g01.projeto.view.screens.LogoViewer;

import java.io.IOException;

public class ViewerProvider {
    private final FireboyViewer fireboyViewer;
    private final WatergirlViewer watergirlViewer;
    private final BrickViewer brickViewer;
    private final LavaViewer lavaViewer;
    private final WaterViewer waterViewer;
    private final GooViewer gooViewer;
    private final BlueDiamondViewer blueDiamondViewer;
    private final RedDiamondViewer redDiamondViewer;
    private final BlueDoorViewer blueDoorViewer;
    private final RedDoorViewer redDoorViewer;
    private final EntryViewer entryViewer;
    private final TextViewer textViewer;
    private final LogoViewer logoViewer;

    public ViewerProvider(ImageLoader imageLoader) throws IOException {
        this.fireboyViewer = new FireboyViewer();
        this.watergirlViewer = new WatergirlViewer();
        this.brickViewer = new BrickViewer();
        this.lavaViewer = new LavaViewer();
        this.waterViewer = new WaterViewer();
        this.gooViewer = new GooViewer();
        this.blueDiamondViewer = new BlueDiamondViewer();
        this.redDiamondViewer = new RedDiamondViewer();
        this.blueDoorViewer = new BlueDoorViewer();
        this.redDoorViewer = new RedDoorViewer();
        this.textViewer = new GameTextViewer();
        this.entryViewer = new EntryViewer(textViewer);
        this.logoViewer = new LogoViewer(imageLoader);
    }

    public FireboyViewer getFireboyViewer() {
        return fireboyViewer;
    }

    public WatergirlViewer getWatergirlViewer() {
        return watergirlViewer;
    }

    public BrickViewer getBrickViewer() {
        return brickViewer;
    }

    public LavaViewer getLavaViewer() {
        return lavaViewer;
    }

    public WaterViewer getWaterViewer() {
        return waterViewer;
    }

    public GooViewer getGooViewer() {
        return gooViewer;
    }

    public BlueDiamondViewer getBlueDiamondViewer() {
        return blueDiamondViewer;
    }

    public RedDiamondViewer getRedDiamondViewer() {
        return redDiamondViewer;
    }

    public BlueDoorViewer getBlueDoorViewer() {
        return blueDoorViewer;
    }

    public RedDoorViewer getRedDoorViewer() {
        return redDoorViewer;
    }

    public EntryViewer getEntryViewer() {
        return entryViewer;
    }

    public TextViewer getTextViewer() {
        return textViewer;
    }

    public LogoViewer getLogoViewer() {return logoViewer;}
}
