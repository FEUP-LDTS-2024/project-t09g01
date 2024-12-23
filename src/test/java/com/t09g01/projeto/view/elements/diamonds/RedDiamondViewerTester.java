package com.t09g01.projeto.view.elements.diamonds;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.diamonds.RedDiamond;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class RedDiamondViewerTester {
    private RedDiamondViewer redDiamondViewer;
    private GUI gui;
    private RedDiamond redDiamond;
    private BufferedImage image;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        gui = mock(GUI.class);
        redDiamond = mock(RedDiamond.class);
        image = mock(BufferedImage.class);

        redDiamondViewer = new RedDiamondViewer();
        Field imageField = RedDiamondViewer.class.getDeclaredField("image");
        imageField.setAccessible(true);
        imageField.set(redDiamondViewer, image);
    }

    @Test
    void testConstructor() {
        assertNotNull(redDiamondViewer);
    }

    @Test
    void testDraw() {
        Position position = new Position(1, 1);
        when(redDiamond.getPosition()).thenReturn(position);

        redDiamondViewer.draw(redDiamond, gui);

        verify(gui).drawMoving(eq(position), eq(image));
    }
}