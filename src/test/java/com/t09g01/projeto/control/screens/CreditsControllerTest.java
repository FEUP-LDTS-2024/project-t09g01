package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.gameover.Credits;
import com.t09g01.projeto.view.ImageLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import static org.mockito.Mockito.when;

public class CreditsControllerTest {
    private Game game;
    private CreditsController controller;
    private EntryController entry;

    @BeforeEach
    public void setup() {
        this.game = Mockito.mock(Game.class);
        Credits credits = Mockito.mock(Credits.class);
        ImageLoader spriteLoader = Mockito.mock(ImageLoader.class);
        when(game.getImageLoader()).thenReturn(spriteLoader);

        this.entry = Mockito.mock(EntryController.class);
        this.controller = new CreditsController(credits, entry);
    }

    @Test
    public void stepWithoutQuit() throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> actions = Set.of(ACTION.NONE);

        controller.step(game, actions, 0);
        Mockito.verify(game, Mockito.times(0)).setState(Mockito.any());
    }

    @Test
    public void stepWithQuit() throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> actions = Set.of(ACTION.QUIT);

        controller.step(game, actions, 0);
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }
}
