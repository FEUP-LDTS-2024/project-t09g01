package com.t09g01.projeto.view.screens;

import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.menu.Entry;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.view.Viewer;
import com.t09g01.projeto.view.image.ImageLoader;
import com.t09g01.projeto.view.text.TextViewer;
import com.t09g01.projeto.view.text.ViewerProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class EntryViewerTester {
    private EntryViewer entryViewer;
    private TextViewer textViewer;
    private GUI gui;
    private Entry entry;
    private LogoViewer logoViewer;
    private ImageLoader imageLoader;
    private Viewer viewer;
    private Menu menu;

    @BeforeEach
    void setUp() throws IOException {
        textViewer = mock(TextViewer.class);
        gui = mock(GUI.class);
        entry = mock(Entry.class);
        entryViewer = new EntryViewer(textViewer);

        imageLoader = mock(ImageLoader.class);
        viewer = mock(Viewer.class);
        when(imageLoader.get("fonts/logo.png")).thenReturn(viewer);
        logoViewer = new LogoViewer(imageLoader);
    }

    @Test
    void testLogoViewerDraw() throws IOException {
        logoViewer.draw(gui, 100, 200);
        verify(viewer).draw(gui, 100, 200);
    }

    @Test
    void testDrawPlayEntry() {
        when(entry.getType()).thenReturn(Entry.TYPE.PLAY);
        when(entry.getPosition()).thenReturn(new Position(10, 20));
        TextColor color = TextColor.ANSI.RED;

        entryViewer.draw(entry, gui, color);

        verify(textViewer).draw("PLAY", 10, 20, color, gui);
    }

    @Test
    void testDrawExitEntry() {
        when(entry.getType()).thenReturn(Entry.TYPE.EXIT);
        when(entry.getPosition()).thenReturn(new Position(15, 25));
        TextColor color = TextColor.ANSI.GREEN;

        entryViewer.draw(entry, gui, color);

        verify(textViewer).draw("EXIT", 15, 25, color, gui);
    }

    @Test
    void testDrawRetryEntry() {
        when(entry.getType()).thenReturn(Entry.TYPE.RETRY);
        when(entry.getPosition()).thenReturn(new Position(20, 30));
        TextColor color = TextColor.ANSI.BLUE;

        entryViewer.draw(entry, gui, color);

        verify(textViewer).draw("RETRY", 20, 30, color, gui);
    }

    @Test
    void testDrawReturnMenuEntry() {
        when(entry.getType()).thenReturn(Entry.TYPE.RETURN_MENU);
        when(entry.getPosition()).thenReturn(new Position(25, 35));
        TextColor color = TextColor.ANSI.YELLOW;

        entryViewer.draw(entry, gui, color);

        verify(textViewer).draw("RETURN TO MENU", 25, 35, color, gui);
    }
}