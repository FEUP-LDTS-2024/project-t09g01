package com.t09g01.projeto.view.elements.blocks;

import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.blocks.Goo;
import com.t09g01.projeto.view.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GooViewerTester {
    private GooViewer gooViewer;
    private GUI gui;
    private Goo goo;
    private Viewer viewer;
    private BufferedImage bufferedImage;
    private TextImage textImage;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        gui = mock(GUI.class);
        goo = mock(Goo.class);
        viewer = mock(Viewer.class);
        bufferedImage = mock(BufferedImage.class);
        textImage = mock(TextImage.class);

        when(viewer.convertTextImage(gui, bufferedImage)).thenReturn(textImage);

        gooViewer = new GooViewer();
        Field viewerField = GooViewer.class.getDeclaredField("viewer");
        viewerField.setAccessible(true);
        viewerField.set(gooViewer, viewer);

        Field bufferedImageField = GooViewer.class.getDeclaredField("bufferedImage");
        bufferedImageField.setAccessible(true);
        bufferedImageField.set(gooViewer, bufferedImage);
    }

    @Test
    void testConstructor() {
        assertNotNull(gooViewer);
    }

    @Test
    void testDraw() {
        Position position = new Position(1, 1);
        when(goo.getPosition()).thenReturn(position);

        gooViewer.draw(goo, gui);

        verify(gui).drawStatic(eq(position), any(TextImage.class));
    }
}