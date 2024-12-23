package com.t09g01.projeto.view.elements.blocks;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.blocks.Brick;
import com.t09g01.projeto.view.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class BrickViewerTester {
    private BrickViewer brickViewer;
    private GUI gui;
    private Brick brick;
    private Viewer viewer;
    private BufferedImage bufferedImage;
    private TextImage textImage;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        gui = mock(GUI.class);
        brick = mock(Brick.class);
        viewer = mock(Viewer.class);
        bufferedImage = mock(BufferedImage.class);
        textImage = mock(TextImage.class);

        when(viewer.convertTextImage(gui, bufferedImage)).thenReturn(textImage);

        brickViewer = new BrickViewer();
        // use reflection to set the private final fields
        Field viewerField = BrickViewer.class.getDeclaredField("viewer");
        viewerField.setAccessible(true);
        viewerField.set(brickViewer, viewer);

        Field bufferedImageField = BrickViewer.class.getDeclaredField("bufferedImage");
        bufferedImageField.setAccessible(true);
        bufferedImageField.set(brickViewer, bufferedImage);
    }

    @Test
    void testConstructor() throws IOException {
        assertNotNull(brickViewer);
    }

    @Test
    void testDraw() throws IOException {
        Position position = new Position(1, 1);
        when(brick.getPosition()).thenReturn(position);

        brickViewer.draw(brick, gui);

        verify(gui).drawStatic(eq(position), any(TextImage.class));
    }
}