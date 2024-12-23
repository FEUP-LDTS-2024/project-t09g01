package com.t09g01.projeto.view.elements.players;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.players.Fireboy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class FireboyViewerTester {
    private FireboyViewer fireboyViewer;
    private GUI gui;
    private Fireboy fireboy;
    private BufferedImage image;

    @BeforeEach
    void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        gui = mock(GUI.class);
        fireboy = mock(Fireboy.class);
        image = mock(BufferedImage.class);

        fireboyViewer = new FireboyViewer();
        Field imageField = FireboyViewer.class.getDeclaredField("image");
        imageField.setAccessible(true);
        imageField.set(fireboyViewer, image);
    }

    @Test
    void testConstructor() {
        assertNotNull(fireboyViewer);
    }

    @Test
    void testDraw() {
        Position position = new Position(1, 1);
        when(fireboy.getPosition()).thenReturn(position);

        fireboyViewer.draw(fireboy, gui);

        verify(gui).drawMoving(eq(position), eq(image));
    }
}