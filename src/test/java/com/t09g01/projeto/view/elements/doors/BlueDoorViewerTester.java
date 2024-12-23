package com.t09g01.projeto.view.elements.doors;

import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.doors.BlueDoor;
import com.t09g01.projeto.view.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class BlueDoorViewerTester {
    private BlueDoorViewer blueDoorViewer;
    private GUI gui;
    private BlueDoor blueDoor;
    private Viewer viewer;
    private BufferedImage bufferedImage;
    private TextImage textImage;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        gui = mock(GUI.class);
        blueDoor = mock(BlueDoor.class);
        viewer = mock(Viewer.class);
        bufferedImage = mock(BufferedImage.class);
        textImage = mock(TextImage.class);

        when(viewer.convertTextImage(gui, bufferedImage)).thenReturn(textImage);

        blueDoorViewer = new BlueDoorViewer();
        Field viewerField = BlueDoorViewer.class.getDeclaredField("viewer");
        viewerField.setAccessible(true);
        viewerField.set(blueDoorViewer, viewer);

        Field bufferedImageField = BlueDoorViewer.class.getDeclaredField("bufferedImage");
        bufferedImageField.setAccessible(true);
        bufferedImageField.set(blueDoorViewer, bufferedImage);
    }

    @Test
    void testConstructor() {
        assertNotNull(blueDoorViewer);
    }

    @Test
    void testDraw() {
        Position position = new Position(1, 1);
        when(blueDoor.getPosition()).thenReturn(position);

        blueDoorViewer.draw(blueDoor, gui);

        verify(gui).drawStatic(eq(position), any(TextImage.class));
    }
}