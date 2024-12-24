package com.t09g01.projeto.view.text;

import com.t09g01.projeto.view.elements.blocks.*;
import com.t09g01.projeto.view.elements.diamonds.*;
import com.t09g01.projeto.view.elements.doors.*;
import com.t09g01.projeto.view.elements.players.*;
import com.t09g01.projeto.view.image.ImageLoader;
import com.t09g01.projeto.view.screens.EntryViewer;
import com.t09g01.projeto.view.screens.LogoViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class ViewerProviderTester {
    private ViewerProvider viewerProvider;
    private ImageLoader imageLoader;

    @BeforeEach
    void setUp() throws IOException {
        imageLoader = mock(ImageLoader.class);
        viewerProvider = new ViewerProvider(imageLoader);
    }

    @Test
    void testFireboyViewer() {
        assertNotNull(viewerProvider.getFireboyViewer());
    }

    @Test
    void testWatergirlViewer() {
        assertNotNull(viewerProvider.getWatergirlViewer());
    }

    @Test
    void testBrickViewer() {
        assertNotNull(viewerProvider.getBrickViewer());
    }

    @Test
    void testLavaViewer() {
        assertNotNull(viewerProvider.getLavaViewer());
    }

    @Test
    void testWaterViewer() {
        assertNotNull(viewerProvider.getWaterViewer());
    }

    @Test
    void testGooViewer() {
        assertNotNull(viewerProvider.getGooViewer());
    }

    @Test
    void testBlueDiamondViewer() {
        assertNotNull(viewerProvider.getBlueDiamondViewer());
    }

    @Test
    void testRedDiamondViewer() {
        assertNotNull(viewerProvider.getRedDiamondViewer());
    }

    @Test
    void testBlueDoorViewer() {
        assertNotNull(viewerProvider.getBlueDoorViewer());
    }

    @Test
    void testRedDoorViewer() {
        assertNotNull(viewerProvider.getRedDoorViewer());
    }

    @Test
    void testEntryViewer() {
        assertNotNull(viewerProvider.getEntryViewer());
    }

    @Test
    void testTextViewer() {
        assertNotNull(viewerProvider.getTextViewer());
    }

    @Test
    void testLogoViewer() {
        assertNotNull(viewerProvider.getLogoViewer());
    }
}