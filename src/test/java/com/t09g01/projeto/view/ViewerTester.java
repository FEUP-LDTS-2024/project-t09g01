package com.t09g01.projeto.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ViewerTester {
    private Viewer viewer;
    private GUI gui;
    private BufferedImage image;
    private TextImage textImage;
    private TextGraphics textGraphics;

    @BeforeEach
    void setUp() throws IOException {
        gui = Mockito.mock(GUI.class);
        textImage = Mockito.mock(TextImage.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        when(gui.createTextImage(anyInt(), anyInt())).thenReturn(textImage);
        when(textImage.newTextGraphics()).thenReturn(textGraphics);

        URL resource = getClass().getClassLoader().getResource("fire.png");
        assert resource != null;
        image = ImageIO.read(new File(resource.getFile()));
        viewer = new Viewer("fire.png");
    }

    @Test
    void testConstructor() throws IOException {
        assertNotNull(viewer.image);
    }

    @Test
    void testLoadImage() throws IOException {
        BufferedImage loadedImage = Viewer.loadImage("fire.png");
        assertNotNull(loadedImage);
    }

    @Test
    void testMissingResource() {
        Exception exception = assertThrows(Exception.class, () -> new Viewer("nonexistent.png"));
        assertEquals("Resource not found: nonexistent.png", exception.getMessage());
    }

    @Test
    void testLoadImageFileNotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Viewer.loadImage("nonexistent.png"));
        assertEquals("Resource not found: nonexistent.png", exception.getMessage());
    }



    @Test
    void testConvertTextImage() {
        TextImage textImage = viewer.convertTextImage(gui, image);
        assertNotNull(textImage);
    }

    @Test
    void testDraw() {
        doNothing().when(gui).drawPixel(anyInt(), anyInt(), any(TextColor.RGB.class));
        viewer.draw(gui, 0, 0);
        verify(gui, atLeastOnce()).drawPixel(anyInt(), anyInt(), any(TextColor.RGB.class));
    }

    @Test
    void testGetLanternaColor() {
        int rgb = 0xFF123456;
        TextColor.RGB color = viewer.getLanternaColor(rgb);
        assertEquals(new TextColor.RGB(18, 52, 86), color);
    }
}
