package com.t09g01.projeto.view.text;

import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GameTextViewerTester {
    private GameTextViewer gameTextViewer;
    private GUI gui;
    private BufferedImage font;
    private Map<Character, CharPosition> charMap;

    @BeforeEach
    void setUp() throws IOException {
        gui = mock(GUI.class);
        gameTextViewer = new GameTextViewer();
    }

    @Test
    void testConstructor() throws IOException {
        assertNotNull(gameTextViewer);
    }

    @Test
    void testDrawKnownChar() {
        char character = 'A';
        double x = 10;
        double y = 20;
        TextColor color = new TextColor.RGB(255, 0, 0);

        gameTextViewer.draw(character, x, y, color, gui);

        verify(gui, atLeastOnce()).drawPixel(anyInt(), anyInt(), any(TextColor.RGB.class));
    }

    @Test
    void testDrawUnknownChar() {
        char character = '?';
        double x = 10;
        double y = 20;
        TextColor color = new TextColor.RGB(255, 0, 0);

        gameTextViewer.draw(character, x, y, color, gui);

        verify(gui).drawRectangle(x, y, GameTextViewer.getCharWidth(), GameTextViewer.getCharHeight(), color);
    }

    @Test
    void testDrawString() {
        String string = "HELLO";
        double x = 10;
        double y = 20;
        TextColor color = new TextColor.RGB(255, 0, 0);

        gameTextViewer.draw(string, x, y, color, gui);

        verify(gui, atLeastOnce()).drawPixel(anyInt(), anyInt(), any(TextColor.RGB.class));
    }

    @Test
    void testGetCharHeight() {
        assertEquals(GameTextViewer.getCharHeight(), 5);
    }

    @Test
    void testGetCharWidth() {
        assertEquals(GameTextViewer.getCharWidth(), 3);
    }

    @Test
    void testGetSpacing() {
        assertEquals(GameTextViewer.getSpacing(), 1);
    }
}