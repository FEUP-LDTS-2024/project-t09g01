package com.t09g01.projeto.view.elements.blocks;

import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.blocks.Water;
import com.t09g01.projeto.view.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class WaterViewerTester {
    private WaterViewer waterViewer;
    private GUI gui;
    private Water water;
    private Viewer viewer;
    private BufferedImage bufferedImage;
    private TextImage textImage;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        gui = mock(GUI.class);
        water = mock(Water.class);
        viewer = mock(Viewer.class);
        bufferedImage = mock(BufferedImage.class);
        textImage = mock(TextImage.class);

        when(viewer.convertTextImage(gui, bufferedImage)).thenReturn(textImage);

        waterViewer = new WaterViewer();
        Field viewerField = WaterViewer.class.getDeclaredField("viewer");
        viewerField.setAccessible(true);
        viewerField.set(waterViewer, viewer);

        Field bufferedImageField = WaterViewer.class.getDeclaredField("bufferedImage");
        bufferedImageField.setAccessible(true);
        bufferedImageField.set(waterViewer, bufferedImage);
    }

    @Test
    void testConstructor() {
        assertNotNull(waterViewer);
    }

    @Test
    void testDraw() {
        Position position = new Position(1, 1);
        when(water.getPosition()).thenReturn(position);

        waterViewer.draw(water, gui);

        verify(gui).drawStatic(eq(position), any(TextImage.class));
    }
}