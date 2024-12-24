package com.t09g01.projeto.view.image;

import com.t09g01.projeto.view.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameImageLoaderTester {
    private GameImageLoader gameImageLoader;

    @BeforeEach
    void setUp() {
        gameImageLoader = new GameImageLoader();
    }

    @Test
    void testConstructor() {
        assertNotNull(gameImageLoader);
        assertNotNull(gameImageLoader.imageMap);
    }

    @Test
    void testGetImage() throws IOException {
        String filepath = "fonts/font1.png";
        Viewer viewer = mock(Viewer.class);
        gameImageLoader.imageMap.put(filepath, viewer);

        Viewer result = gameImageLoader.get(filepath);

        assertNotNull(result);
        assertEquals(viewer, result);
        verify(spy(gameImageLoader), never()).get(filepath);
    }

    @Test
    void testGetImageWhenNotCached() throws IOException {
        String filepath = "fonts/font1.png";

        gameImageLoader.imageMap.clear();
        Viewer result = gameImageLoader.get(filepath);

        assertNotNull(result);
        assertTrue(gameImageLoader.imageMap.containsKey(filepath));
        assertNotNull(gameImageLoader.imageMap.get(filepath));
    }



}