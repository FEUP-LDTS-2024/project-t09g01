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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CreditsViewerTester {
    private Credits credits;
    private ViewerProvider viewerProvider;
    private GUI gui;
    private TextViewer textViewer;
    private EntryViewer entryViewer;
    private CreditsViewer<Credits> creditsViewer;

    @BeforeEach
    void setUp() {
        credits = mock(Credits.class);
        viewerProvider = mock(ViewerProvider.class);
        gui = mock(GUI.class);
        textViewer = mock(TextViewer.class);
        entryViewer = mock(EntryViewer.class);

        Screen mockScreen = mock(Screen.class);
        when(gui.getScreen()).thenReturn(mockScreen);

        when(viewerProvider.getEntryViewer()).thenReturn(entryViewer);
        when(viewerProvider.getTextViewer()).thenReturn(textViewer);

        creditsViewer = new CreditsViewer<>(credits, viewerProvider);
    }


//    @Test
//    void testDraw() throws IOException {
//        creditsViewer.draw(gui);
//
//        verify(textViewer).draw("THANKS FOR PLAYING", 127, 30, CreditsViewer.titleColor, gui);
//        verify(textViewer).draw("CLASS 09 GROUP 01", 128, 50, CreditsViewer.titleColor, gui);
//        verify(textViewer).draw("CAROLINA FERREIRA", 128, 58, CreditsViewer.titleColor, gui);
//        verify(textViewer).draw("CONSTANCA FERREIRA", 128, 64, CreditsViewer.titleColor, gui);
//        verify(textViewer).draw("MARIA LUIZA VIEIRA", 128, 70, CreditsViewer.titleColor, gui);
//
//        verify(creditsViewer, times(1)).drawEntries(eq(gui), any());
//
//        verify(gui).refresh();
//        verify(gui.getScreen()).newTextGraphics();
//
//    }

    @Test
    void testDrawEntries() {
        Entry entry1 = mock(Entry.class);
        Entry entry2 = mock(Entry.class);
        List<Entry> entries = Arrays.asList(entry1, entry2);
        when(credits.getEntries()).thenReturn(entries);
        when(credits.getCurrentEntry()).thenReturn(entry1);

        creditsViewer.drawEntries(gui, entries);

        verify(entryViewer).draw(entry1, gui, CreditsViewer.selectedColor);
        verify(entryViewer).draw(entry2, gui, CreditsViewer.unselectedColor);
    }
}