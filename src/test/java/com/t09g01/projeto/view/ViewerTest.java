package com.t09g01.projeto.view;

import com.t09g01.projeto.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

class ViewerTest {

    private Viewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() throws IOException {
        gui = Mockito.mock(GUI.class);
        viewer = new Viewer("fireboy.png");
    }

    @Test
    void drawElement() throws IOException {
        //viewer.draw(gui, 0, 0);
        Mockito.verify(gui, Mockito.atLeast(1)).drawPixel(Mockito.anyInt(), Mockito.anyInt(), Mockito.any());
    }
}
