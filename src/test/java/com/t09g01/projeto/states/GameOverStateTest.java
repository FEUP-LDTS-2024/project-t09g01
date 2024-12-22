package com.t09g01.projeto.states;

import com.t09g01.projeto.control.Controller;
import com.t09g01.projeto.control.screens.GameOverController;
import com.t09g01.projeto.model.gameover.GameOver;
import com.t09g01.projeto.view.ImageLoader;
import com.t09g01.projeto.view.game.ScreenViewer;
import com.t09g01.projeto.view.screens.GameOverViewer;
import com.t09g01.projeto.view.text.ViewerProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GameOverStateTest {
    private GameOver gameOver;
    private ImageLoader imageLoader;
    private ViewerProvider viewerProvider;
    private GameOverState gameOverState;

    @BeforeEach
    void setUp() throws IOException {
        this.gameOver = mock(GameOver.class);
        this.imageLoader = mock(ImageLoader.class);
        this.viewerProvider = mock(ViewerProvider.class);

        gameOverState = new GameOverState(gameOver, imageLoader);
    }

    @Test
    void testGameOverStateConstructor() {
        assertNotNull(gameOverState);
    }

    @Test
    void testGetController() {
        Controller<GameOver> controller = gameOverState.getController();

        assertNotNull(controller);
        assert(controller instanceof GameOverController);
}

    @Test
    void testGetScreenViewer() {
        ScreenViewer<GameOver> screenViewer = gameOverState.getScreenViewer(viewerProvider);

        assertNotNull(screenViewer);
        assert(screenViewer instanceof GameOverViewer);
    }
}
