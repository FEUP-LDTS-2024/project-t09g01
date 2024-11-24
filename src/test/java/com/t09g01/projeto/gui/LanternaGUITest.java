package com.t09g01.projeto.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;

    @BeforeEach
    public void setUp() {
        screen = mock(Screen.class);
        gui = new LanternaGUI(screen);
    }

    // getNextAction
    @Test
    public void testArrowKeys() throws IOException {
        KeyStroke upKey = new KeyStroke(KeyType.ArrowUp);
        KeyStroke downKey = new KeyStroke(KeyType.ArrowDown);
        KeyStroke leftKey = new KeyStroke(KeyType.ArrowLeft);
        KeyStroke rightKey = new KeyStroke(KeyType.ArrowRight);

        when(screen.pollInput()).thenReturn(upKey, downKey, leftKey, rightKey);

        assertEquals(ACTION.FIREBOY_UP, gui.getNextAction());
        assertEquals(ACTION.FIREBOY_DOWN, gui.getNextAction());
        assertEquals(ACTION.FIREBOY_LEFT, gui.getNextAction());
        assertEquals(ACTION.FIREBOY_RIGHT, gui.getNextAction());
    }

    @Test
    public void testCharacterKeys() throws IOException {
        KeyStroke wKey = new KeyStroke('w', false, false);
        KeyStroke sKey = new KeyStroke('s', false, false);
        KeyStroke aKey = new KeyStroke('a', false, false);
        KeyStroke dKey = new KeyStroke('d', false, false);

        when(screen.pollInput()).thenReturn(wKey, sKey, aKey, dKey);

        assertEquals(ACTION.FIREBOY_UP, gui.getNextAction());
        assertEquals(ACTION.FIREBOY_DOWN, gui.getNextAction());
        assertEquals(ACTION.FIREBOY_LEFT, gui.getNextAction());
        assertEquals(ACTION.FIREBOY_RIGHT, gui.getNextAction());
    }

    @Test
    public void testEofAndOtherKeys() throws IOException {
        KeyStroke eofKey = new KeyStroke(KeyType.EOF);
        KeyStroke unmappedKey = new KeyStroke(KeyType.Enter);

        when(screen.pollInput()).thenReturn(eofKey, unmappedKey);

        assertEquals(ACTION.QUIT, gui.getNextAction());
        assertEquals(ACTION.NONE, gui.getNextAction());
    }

    // drawPixel
    @Test
    public void testDrawPixel() {
        TextGraphics textGraphics = mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);

        LanternaGUI gui = new LanternaGUI(screen);
        TextColor.RGB color = new TextColor.RGB(255, 0, 0);

        gui.drawPixel(5, 10, color);

        verify(textGraphics, times(1)).setBackgroundColor(color);
        verify(textGraphics, times(1)).putString(5, 10, " ");
    }

    // clear
    @Test
    public void testClear() {
        gui.clear();
        verify(screen, times(1)).clear();
    }

    // refresh
    @Test
    public void testRefresh() throws IOException {
        gui.refresh();
        verify(screen, times(1)).refresh();
    }

    // close
    @Test
    public void testClose() throws IOException {
        gui.close();
        verify(screen, times(1)).close();
    }

}
