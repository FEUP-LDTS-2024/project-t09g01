package com.t09g01.projeto.view.elements.blocks;

import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.blocks.Lava;
import com.t09g01.projeto.view.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class LavaViewerTester {
    private LavaViewer lavaViewer;
    private GUI gui;
    private Lava lava;
    private Viewer viewer;
    private BufferedImage bufferedImage;
    private TextImage textImage;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        gui = mock(GUI.class);
        lava = mock(Lava.class);
        viewer = mock(Viewer.class);
        bufferedImage = mock(BufferedImage.class);
        textImage = mock(TextImage.class);

        when(viewer.convertTextImage(gui, bufferedImage)).thenReturn(textImage);

        lavaViewer = new LavaViewer();
        Field viewerField = LavaViewer.class.getDeclaredField("viewer");
        viewerField.setAccessible(true);
        viewerField.set(lavaViewer, viewer);

        Field bufferedImageField = LavaViewer.class.getDeclaredField("bufferedImage");
        bufferedImageField.setAccessible(true);
        bufferedImageField.set(lavaViewer, bufferedImage);
    }

    @Test
    void testConstructor() {
        assertNotNull(lavaViewer);
    }

    @Test
    void testDraw() {
        Position position = new Position(1, 1);
        when(lava.getPosition()).thenReturn(position);

        lavaViewer.draw(lava, gui);

        verify(gui).drawStatic(eq(position), any(TextImage.class));
    }
}