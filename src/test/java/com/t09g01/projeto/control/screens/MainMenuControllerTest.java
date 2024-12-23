package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.screens.GameOver;
import com.t09g01.projeto.model.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainMenuControllerTest {
    private Game game;
    private MainMenu mainMenu;
    private EntryController entryController;
    private MainMenuController mainMenuController;

    @BeforeEach
    public void setup() {
        this.game = Mockito.mock(Game.class);
        this.mainMenu = Mockito.mock(MainMenu.class);
        this.entryController = Mockito.mock(EntryController.class);
        this.mainMenuController = new MainMenuController(mainMenu, entryController);
    }

    @Test
    public void testQuitAction() throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> actions = Set.of(ACTION.QUIT);

        mainMenuController.step(game, actions, System.currentTimeMillis());

        verify(game, times(1)).setState(null);
    }

    @Test
    public void testNoQuitAction() throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> actions = Set.of(ACTION.NONE);

        mainMenuController.step(game, actions, System.currentTimeMillis());

        verify(game, times(0)).setState(null);
    }
}
