package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.gameover.GameOver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameOverControllerTest {
    private Game game;
    private GameOver gameOver;
    private EntryController entryController;
    private GameOverController gameOverController;

    @BeforeEach
    public void setup() {
        this.game = Mockito.mock(Game.class);
        this.gameOver = Mockito.mock(GameOver.class);
        this.entryController = Mockito.mock(EntryController.class);
        this.gameOverController = new GameOverController(gameOver, entryController);
    }

    @Test
    public void testQuitAction() throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> actions = Set.of(ACTION.QUIT);

        gameOverController.step(game, actions, System.currentTimeMillis());

        verify(game, times(1)).setState(null);
    }

    @Test
    public void testNoQuitAction() throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> actions = Set.of(ACTION.NONE);

        gameOverController.step(game, actions, System.currentTimeMillis());

        verify(game, times(0)).setState(null);
    }
}
