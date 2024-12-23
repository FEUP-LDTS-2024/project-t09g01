package com.t09g01.projeto;

import com.t09g01.projeto.gui.LanternaGUI;
import com.t09g01.projeto.states.MainMenuState;
import com.t09g01.projeto.states.State;
import com.t09g01.projeto.view.image.GameImageLoader;
import com.t09g01.projeto.view.image.ImageLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.lang.reflect.Field;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() throws IOException, FontFormatException, URISyntaxException {
        game = new Game();
    }

    @Test
    void testInitialization() throws IOException, FontFormatException, URISyntaxException {
        assertNotNull(game.getGUI(), "GUI should be initialized.");
        assertNotNull(game.getImageLoader(), "ImageLoader should be initialized.");
        assertTrue(game.getImageLoader() instanceof GameImageLoader, "ImageLoader should be an instance of GameImageLoader.");
        assertTrue(game.getState() instanceof MainMenuState, "Initial state should be MainMenuState.");
    }

    @Test
    void testSetState() {
        State newState = Mockito.mock(State.class);
        game.setState(newState);
        assertSame(newState, game.getState(), "State should be updated to the new state.");
    }

    @Test
    void testGetNumberOfLevels() {
        assertEquals(3, game.getNumberOfLevels(), "Number of levels should be 3.");
    }

    @Test
    void testMainLoop() throws IOException, URISyntaxException, FontFormatException, InterruptedException {
        State mockState = Mockito.mock(State.class);
        game.setState(mockState);

        Thread gameThread = new Thread(() -> {
            try {
                game.start();
            } catch (IOException | URISyntaxException | FontFormatException e) {
                fail("Exception should not be thrown during game start.");
            }
        });

        gameThread.start();
        Thread.sleep(100); // Let the game loop run for a short time
        game.setState(null); // Stop the game loop
        gameThread.join();

        Mockito.verify(mockState, Mockito.atLeastOnce()).step(Mockito.any(Game.class), Mockito.any(LanternaGUI.class), Mockito.anyLong());
    }

    @Test
    void testGetGUI() {
        assertNotNull(game.getGUI(), "GUI should be returned.");
    }

    @Test
    void testGetImageLoader() {
        assertNotNull(game.getImageLoader(), "ImageLoader should be returned.");
    }

    @Test
    void testMainMethod() throws IOException, URISyntaxException, FontFormatException {
        Game.main(new String[]{});
    }
}