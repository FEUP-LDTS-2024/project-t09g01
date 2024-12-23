package com.t09g01.projeto.view.elements.diamonds;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.diamonds.BlueDiamond;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class BlueDiamondViewerTester {
    private BlueDiamondViewer blueDiamondViewer;
    private GUI gui;
    private BlueDiamond blueDiamond;
    private BufferedImage image;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        gui = mock(GUI.class);
        blueDiamond = mock(BlueDiamond.class);
        image = mock(BufferedImage.class);

        blueDiamondViewer = new BlueDiamondViewer();
        Field imageField = BlueDiamondViewer.class.getDeclaredField("image");
        imageField.setAccessible(true);
        imageField.set(blueDiamondViewer, image);
    }

    @Test
    void testConstructor() {
        assertNotNull(blueDiamondViewer);
    }

    @Test
    void testDraw() {
        Position position = new Position(1, 1);
        when(blueDiamond.getPosition()).thenReturn(position);

        blueDiamondViewer.draw(blueDiamond, gui);

        verify(gui).drawMoving(eq(position), eq(image));
    }
}