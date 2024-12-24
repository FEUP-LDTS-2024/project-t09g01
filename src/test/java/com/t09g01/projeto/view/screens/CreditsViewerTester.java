package com.t09g01.projeto.view.screens;


import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.menu.Entry;
import com.t09g01.projeto.model.screens.Credits;
import com.t09g01.projeto.view.text.TextViewer;
import com.t09g01.projeto.view.text.ViewerProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CreditsViewerTester {
    private CreditsViewer<Credits> creditsViewer;
    private GUI gui;
    private Credits credits;
    private ViewerProvider viewerProvider;
    private TextViewer textViewer;
    private EntryViewer entryViewer;
    private Screen screen;
    private TextGraphics textGraphics;


    @BeforeEach
    void setUp() {
        gui = mock(GUI.class);
        credits = mock(Credits.class);
        viewerProvider = mock(ViewerProvider.class);
        textViewer = mock(TextViewer.class);
        entryViewer = mock(EntryViewer.class);
        screen = mock(Screen.class);
        textGraphics = mock(TextGraphics.class);

        when(viewerProvider.getTextViewer()).thenReturn(textViewer);
        when(viewerProvider.getEntryViewer()).thenReturn(entryViewer);
        when(gui.getScreen()).thenReturn(screen);
        when(screen.newTextGraphics()).thenReturn(textGraphics);


        creditsViewer = new CreditsViewer<>(credits, viewerProvider);
    }

    @Test
    void testConstructor() {
        assertNotNull(creditsViewer);
    }
//
//    @Test
//    void testDraw() throws IOException {
//        Entry entry1 = mock(Entry.class);
//        Entry entry2 = mock(Entry.class);
//        when(credits.getEntries()).thenReturn(Arrays.asList(entry1, entry2));
//        when(credits.getCurrentEntry()).thenReturn(entry1);
//
//        creditsViewer.draw(gui);
//
//        verify(gui).clear();
//        verify(textViewer).draw("THANKS FOR PLAYING", 130, 30, CreditsViewer.titleColor, gui);
//        verify(textViewer).draw("CLASS 09 GROUP 01", 130, 50, CreditsViewer.titleColor, gui);
//        verify(textViewer).draw("CAROLINA FERREIRA", 130, 58, CreditsViewer.titleColor, gui);
//        verify(textViewer).draw("CONSTANCA FERREIRA", 130, 64, CreditsViewer.titleColor, gui);
//        verify(textViewer).draw("MARIA LUIZA VIEIRA", 130, 72, CreditsViewer.titleColor, gui);
//        verify(entryViewer).draw(entry1, gui, CreditsViewer.selectedColor);
//        verify(entryViewer).draw(entry2, gui, CreditsViewer.unselectedColor);
//        verify(gui).refresh();
//    }
}