package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class MenuControllerTest {
    private Game game;
    private Menu menu;
    private EntryController entryController;
    private MenuController<Menu> menuController;

    @BeforeEach
    public void setup() {
        this.game = Mockito.mock(Game.class);
        this.menu = Mockito.mock(Menu.class);
        this.entryController = Mockito.mock(EntryController.class);

        this.menuController = new MenuController<>(menu, entryController) {
            @Override
            protected void quit(Game game) throws IOException, FontFormatException, URISyntaxException {
                game.setState(null);  // Mocked quit behavior for testing
            }
        };
    }

    @Test
    public void testUp() throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> actions = Set.of(ACTION.FIREBOY_UP);

        menuController.step(game, actions, System.currentTimeMillis());

        verify(menu, times(1)).previousEntry();
    }

    @Test
    public void testDown() throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> actions = Set.of(ACTION.FIREBOY_DOWN);

        menuController.step(game, actions, System.currentTimeMillis());

        verify(menu, times(1)).nextEntry();
    }

    @Test
    public void testQuit() throws IOException, FontFormatException, URISyntaxException {
        Set<ACTION> actions = Set.of(ACTION.QUIT);

        menuController.step(game, actions, System.currentTimeMillis());

        verify(game, times(1)).setState(null);
    }

    @Test
    public void testQuitExceptionHandling() {
        Set<ACTION> actions = Set.of(ACTION.QUIT);

        try {
            menuController.step(game, actions, System.currentTimeMillis());
        } catch (RuntimeException | IOException | URISyntaxException | FontFormatException e) {
            assert e.getCause() instanceof FontFormatException;
        }
    }

    @Test
    public void testDefaultCase() throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> actions = Set.of(ACTION.WATERGIRL_DOWN);

        menuController.step(game, actions, System.currentTimeMillis());

        verify(entryController, times(1)).step(Mockito.any(Game.class), Mockito.eq(actions), Mockito.anyLong());
    }

    @Test
    public void testFontFormatExceptionHandling() throws IOException, URISyntaxException, FontFormatException {
        Set<ACTION> actions = Set.of(ACTION.QUIT);

        MenuController<Menu> menuController = Mockito.spy(new MenuController<>(menu, entryController) {
            @Override
            protected void quit(Game game) throws IOException, FontFormatException, URISyntaxException {
                throw new FontFormatException("Font format issue");
            }
        });

        try {
            menuController.step(game, actions, System.currentTimeMillis());
        } catch (RuntimeException e) {
            assertTrue(e.getCause() instanceof FontFormatException);
            assertEquals("Font format issue", e.getCause().getMessage());
        }

        verify(menuController, times(1)).quit(game);
    }
}
