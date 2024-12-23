package com.t09g01.projeto.view.elements.players;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.players.Watergirl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class WatergirlViewerTester {
    private WatergirlViewer watergirlViewer;
    private GUI gui;
    private Watergirl watergirl;
    private BufferedImage image;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        gui = mock(GUI.class);
        watergirl = mock(Watergirl.class);
        image = mock(BufferedImage.class);

        watergirlViewer = new WatergirlViewer();
        Field imageField = WatergirlViewer.class.getDeclaredField("image");
        imageField.setAccessible(true);
        imageField.set(watergirlViewer, image);
    }

    @Test
    void testConstructor() {
        assertNotNull(watergirlViewer);
    }

    @Test
    void testDraw() {
        Position position = new Position(1, 1);
        when(watergirl.getPosition()).thenReturn(position);

        watergirlViewer.draw(watergirl, gui);

        verify(gui).drawMoving(eq(position), eq(image));
    }
}
