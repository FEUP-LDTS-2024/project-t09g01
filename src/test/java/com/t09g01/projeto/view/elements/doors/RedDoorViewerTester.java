package com.t09g01.projeto.view.elements.doors;

import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.doors.RedDoor;
import com.t09g01.projeto.view.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class RedDoorViewerTester {
    private RedDoorViewer redDoorViewer;
    private GUI gui;
    private RedDoor redDoor;
    private Viewer viewer;
    private BufferedImage bufferedImage;
    private TextImage textImage;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        gui = mock(GUI.class);
        redDoor = mock(RedDoor.class);
        viewer = mock(Viewer.class);
        bufferedImage = mock(BufferedImage.class);
        textImage = mock(TextImage.class);

        when(viewer.convertTextImage(gui, bufferedImage)).thenReturn(textImage);

        redDoorViewer = new RedDoorViewer();
        Field viewerField = RedDoorViewer.class.getDeclaredField("viewer");
        viewerField.setAccessible(true);
        viewerField.set(redDoorViewer, viewer);

        Field bufferedImageField = RedDoorViewer.class.getDeclaredField("bufferedImage");
        bufferedImageField.setAccessible(true);
        bufferedImageField.set(redDoorViewer, bufferedImage);
    }

    @Test
    void testConstructor() {
        assertNotNull(redDoorViewer);
    }

    @Test
    void testDraw() {
        Position position = new Position(1, 1);
        when(redDoor.getPosition()).thenReturn(position);

        redDoorViewer.draw(redDoor, gui);

        verify(gui).drawStatic(eq(position), any(TextImage.class));
    }
}