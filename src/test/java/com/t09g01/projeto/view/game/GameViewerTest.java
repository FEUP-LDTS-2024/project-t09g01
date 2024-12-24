package com.t09g01.projeto.view.game;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.game.elements.Element;
import com.t09g01.projeto.model.game.elements.blocks.*;
import com.t09g01.projeto.model.game.elements.diamonds.BlueDiamond;
import com.t09g01.projeto.model.game.elements.diamonds.RedDiamond;
import com.t09g01.projeto.model.game.elements.doors.BlueDoor;
import com.t09g01.projeto.model.game.elements.doors.RedDoor;
import com.t09g01.projeto.model.game.elements.players.Fireboy;
import com.t09g01.projeto.model.game.elements.players.Watergirl;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.view.elements.ElementViewer;
import com.t09g01.projeto.view.text.ViewerProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GameViewerTest {
    private GameViewer gameViewer;
    private GUI gui;
    private Temple temple;
    private ViewerProvider viewerProvider;

    @BeforeEach
    void setUp() {
        gui = mock(GUI.class);
        temple = mock(Temple.class);
        viewerProvider = mock(ViewerProvider.class);
        gameViewer = new GameViewer(temple, viewerProvider);
    }

    @Test
    void testConstructor() {
        assertNotNull(gameViewer.getBackground());
    }

//    @Test
//    void testDraw() throws IOException {
//        when(temple.getHeight()).thenReturn(192);
//        when(temple.getWidth()).thenReturn(320);
//
//        when(temple.getBlueDiamond()).thenReturn(Collections.singletonList(mock(BlueDiamond.class)));
//        when(temple.getRedDiamond()).thenReturn(Collections.singletonList(mock(RedDiamond.class)));
//        when(temple.getWatergirl()).thenReturn(mock(Watergirl.class));
//        when(temple.getFireboy()).thenReturn(mock(Fireboy.class));
//        when(temple.getBricks()).thenReturn(Collections.singletonList(mock(Brick.class)));
//        when(temple.getLava()).thenReturn(Collections.singletonList(mock(Lava.class)));
//        when(temple.getWater()).thenReturn(Collections.singletonList(mock(Water.class)));
//        when(temple.getGoo()).thenReturn(Collections.singletonList(mock(Goo.class)));
//        when(temple.getBlueDoor()).thenReturn(mock(BlueDoor.class));
//        when(temple.getRedDoor()).thenReturn(mock(RedDoor.class));
//
//        gameViewer.draw(gui);
//
//        verify(gui).clear();
//        verify(gui).drawStatic(any(), eq(gameViewer.getBackground()));
//        verify(gui).drawRectangle(0, 0, 320, 192, GameViewer.windowColor);
//        verify(gui, atLeastOnce()).drawStatic(any(), any());
//        verify(gui, atLeastOnce()).drawStatic(any(), any());
//    }

    @Test
    void testDrawElement() {
        Element element = mock(Element.class);
        ElementViewer<Element> viewer = mock(ElementViewer.class);

        gameViewer.drawElement(gui, element, viewer);

        verify(viewer).draw(eq(element), eq(gui));
    }

    @Test
    void testDrawElements() {
        Element element1 = mock(Element.class);
        Element element2 = mock(Element.class);
        ElementViewer<Element> viewer = mock(ElementViewer.class);

        gameViewer.drawElements(gui, Arrays.asList(element1, element2), viewer);

        verify(viewer).draw(eq(element1), eq(gui));
        verify(viewer).draw(eq(element2), eq(gui));
    }
}
