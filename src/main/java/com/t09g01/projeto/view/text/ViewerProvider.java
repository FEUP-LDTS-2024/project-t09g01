package com.t09g01.projeto.view.text;

import com.t09g01.projeto.view.ImageLoader;
import com.t09g01.projeto.view.elements.*;

import java.io.IOException;

public class ViewerProvider {
    private final FireboyViewer fireboyViewer;
    private final WatergirlViewer watergirlViewer;
    private final BlockViewer blockViewer;
    private final LavaViewer lavaViewer;
    private final WaterViewer waterViewer;
    private final GooViewer gooViewer;
    private final BlueDiamondViewer blueDiamondViewer;
    private final RedDiamondViewer redDiamondViewer;
    private final BlueDoorViewer blueDoorViewer;
    private final RedDoorViewer redDoorViewer;

    public ViewerProvider(ImageLoader imageLoader) throws IOException {
        this.fireboyViewer = new FireboyViewer();
        this.watergirlViewer = new WatergirlViewer();
        this.blockViewer = new BlockViewer();
        this.lavaViewer = new LavaViewer();
        this.waterViewer = new WaterViewer();
        this.gooViewer = new GooViewer();
        this.blueDiamondViewer = new BlueDiamondViewer();
        this.redDiamondViewer = new RedDiamondViewer();
        this.blueDoorViewer = new BlueDoorViewer();
        this.redDoorViewer = new RedDoorViewer();
    }

    public FireboyViewer getFireboyViewer() {
        return fireboyViewer;
    }

    public WatergirlViewer getWatergirlViewer() {
        return watergirlViewer;
    }

    public BlockViewer getBlockViewer() {
        return blockViewer;
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

}
