package com.t09g01.projeto.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.t09g01.projeto.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics textGraphics;
    private Terminal terminal;


    @BeforeEach
    public void setUp() throws IOException {
        this.screen = mock(Screen.class);
        this.textGraphics = mock(TextGraphics.class);
        this.terminal = mock(Terminal.class);
        this.gui = new LanternaGUI(screen);


        when(screen.newTextGraphics()).thenReturn(textGraphics);
        when(terminal.newTextGraphics()).thenReturn(mock(TextGraphics.class));
        when(terminal.getTerminalSize()).thenReturn(new TerminalSize(10, 10));
    }

    @Test
    public void testCreatesScreen() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(10, 10);
        assertNotNull(gui.getScreen());
    }


    @Test
    public void testGetScreen() {
        assertEquals(screen, gui.getScreen());
    }

    @Test
    public void testGetCurrentActions() {
        Set<ACTION> actions = gui.getCurrentActions();

        actions.add(ACTION.FIREBOY_LEFT);
        actions.add(ACTION.WATERGIRL_RIGHT);

        assertTrue(actions.contains(ACTION.FIREBOY_LEFT));
        assertTrue(actions.contains(ACTION.WATERGIRL_RIGHT));
    }

    @Test
    public void testDrawPixel() {
        TextGraphics textGraphics = mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui.drawPixel(5, 10, new TextColor.RGB(255, 0, 0));

        verify(textGraphics).setBackgroundColor(new TextColor.RGB(255, 0, 0));
        verify(textGraphics).putString(5, 10, " ");
    }

//    @Test
//    public void testDrawText() {
//        TextGraphics textGraphics = mock(TextGraphics.class);
//        when(screen.newTextGraphics()).thenReturn(textGraphics);
//
//        String text = "Hello";
//        String color = "#FFFFFF";
//        Position position = new Position(10, 15);
//
//        gui.drawText(position, text, color);
//
//        verify(textGraphics).setForegroundColor(TextColor.Factory.fromString(color));
//        verify(textGraphics).putString(10, 15, text);
//    }

    @Test
    public void testDrawRectangle() {
        TextGraphics textGraphics = mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);

        gui.drawRectangle(10, 10, 5, 5, TextColor.ANSI.RED);

        verify(textGraphics).setBackgroundColor(TextColor.ANSI.RED);
        verify(textGraphics).fillRectangle(new TerminalPosition(10, 10), new TerminalSize(5, 5), ' ');
    }

    @Test
    public void testDrawStatic() {
        TextImage textImage = mock(TextImage.class);
        TextGraphics textGraphics = mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);

        Position position = new Position(10, 10);

        gui.drawStatic(position, textImage);

        verify(textGraphics).drawImage(new TerminalPosition(10, 10), textImage);
    }

    @Test
    public void testDrawMoving() {
        BufferedImage bufferedImage = mock(BufferedImage.class);
        when(bufferedImage.getWidth()).thenReturn(5);
        when(bufferedImage.getHeight()).thenReturn(5);

        when(bufferedImage.getRGB(0, 0)).thenReturn(0xFFFFFFFF);

        Position position = new Position(10, 10);

        gui.drawMoving(position, bufferedImage);

        verify(textGraphics).setCharacter(10, 10, new TextCharacter(' ', new TextColor.RGB(255, 255, 255), new TextColor.RGB(255, 255, 255)));
    }

    @Test
    public void testCreateTextImage() {
        TextImage textImage = gui.createTextImage(10, 10);
        assertNotNull(textImage);
    }

    @Test
    public void testClear() {
        gui.clear();
        verify(screen).clear();
    }

    @Test
    public void testRefresh() throws IOException {
        gui.refresh();
        verify(screen).refresh();
    }

    @Test
    public void testClose() throws IOException {
        gui.close();
        verify(screen).close();
    }

    //getActionFromKeyCode
    @Test
    public void testVK_UP() {
        ACTION action = gui.getActionFromKeyCode(KeyEvent.VK_UP);
        assertEquals(ACTION.FIREBOY_UP, action);
    }

    @Test
    public void testVK_W() {
        ACTION action = gui.getActionFromKeyCode(KeyEvent.VK_W);
        assertEquals(ACTION.WATERGIRL_UP, action);
    }

    @Test
    public void testVK_DOWN() {
        ACTION action = gui.getActionFromKeyCode(KeyEvent.VK_DOWN);
        assertEquals(ACTION.FIREBOY_DOWN, action);
    }

    @Test
    public void testVK_S() {
        ACTION action = gui.getActionFromKeyCode(KeyEvent.VK_S);
        assertEquals(ACTION.WATERGIRL_DOWN, action);
    }

    @Test
    public void testVK_LEFT() {
        ACTION action = gui.getActionFromKeyCode(KeyEvent.VK_LEFT);
        assertEquals(ACTION.FIREBOY_LEFT, action);
    }

    @Test
    public void testVK_A() {
        ACTION action = gui.getActionFromKeyCode(KeyEvent.VK_A);
        assertEquals(ACTION.WATERGIRL_LEFT, action);
    }

    @Test
    public void testVK_RIGHT() {
        ACTION action = gui.getActionFromKeyCode(KeyEvent.VK_RIGHT);
        assertEquals(ACTION.FIREBOY_RIGHT, action);
    }

    @Test
    public void testVK_D() {
        ACTION action = gui.getActionFromKeyCode(KeyEvent.VK_D);
        assertEquals(ACTION.WATERGIRL_RIGHT, action);
    }

    @Test
    public void testVK_ESCAPE() {
        ACTION action = gui.getActionFromKeyCode(KeyEvent.VK_ESCAPE);
        assertEquals(ACTION.QUIT, action);
    }

    @Test
    public void testVK_ENTER() {
        ACTION action = gui.getActionFromKeyCode(KeyEvent.VK_ENTER);
        assertEquals(ACTION.SELECT, action);
    }

    @Test
    public void testDefault() {
        ACTION action = gui.getActionFromKeyCode(9999);  // Non-existent key code
        assertEquals(ACTION.NONE, action);
    }

}
