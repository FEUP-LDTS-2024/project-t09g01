package com.t09g01.projeto.view.screens;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.menu.Entry;
import com.t09g01.projeto.model.screens.GameOver;
import com.t09g01.projeto.view.text.TextViewer;
import com.t09g01.projeto.view.text.ViewerProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GameOverViewerTester {
    private GameOverViewer<GameOver> gameOverViewer;
    private GUI gui;
    private GameOver gameOver;
    private ViewerProvider viewerProvider;
    private TextViewer textViewer;
    private EntryViewer entryViewer;
    private Screen screen;
    private TextGraphics textGraphics;


    @BeforeEach
    void setUp() {
        gui = mock(GUI.class);
        gameOver = mock(GameOver.class);
        viewerProvider = mock(ViewerProvider.class);
        textViewer = mock(TextViewer.class);
        entryViewer = mock(EntryViewer.class);
        screen = mock(Screen.class);
        textGraphics = mock(TextGraphics.class);

        when(viewerProvider.getTextViewer()).thenReturn(textViewer);
        when(viewerProvider.getEntryViewer()).thenReturn(entryViewer);
        when(gui.getScreen()).thenReturn(screen);
        when(screen.newTextGraphics()).thenReturn(textGraphics);

        gameOverViewer = new GameOverViewer<>(gameOver, viewerProvider);
    }

    @Test
    void testConstructor() {
        assertNotNull(gameOverViewer);
    }

    @Test
    void testDraw() throws IOException {
        Entry entry1 = mock(Entry.class);
        Entry entry2 = mock(Entry.class);
        when(gameOver.getEntries()).thenReturn(Arrays.asList(entry1, entry2));
        when(gameOver.getCurrentEntry()).thenReturn(entry1);

        gameOverViewer.draw(gui);

        verify(gui).clear();
        verify(textViewer).draw("GAME OVER", 145, 60, GameOverViewer.titleColor, gui);
        verify(entryViewer).draw(entry1, gui, GameOverViewer.selectedColor);
        verify(entryViewer).draw(entry2, gui, GameOverViewer.unselectedColor);
        verify(gui).refresh();
    }
}