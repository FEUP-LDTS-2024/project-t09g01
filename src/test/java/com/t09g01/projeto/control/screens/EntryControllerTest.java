package com.t09g01.projeto.control.screens;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.menu.Entry;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.states.GameState;
import com.t09g01.projeto.states.MainMenuState;
import com.t09g01.projeto.view.ImageLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import static org.mockito.Mockito.*;

public class EntryControllerTest {
    private Game game;
    private Menu menu;
    private EntryController entryController;
    private ImageLoader imageLoader;

    @BeforeEach
    public void setup() {
        this.game = Mockito.mock(Game.class);
        this.imageLoader = Mockito.mock(ImageLoader.class);
        this.menu = Mockito.mock(Menu.class);

        when(game.getImageLoader()).thenReturn(imageLoader);
        this.entryController = new EntryController(menu);
    }

    @Test
    public void testPlayAction() throws IOException, URISyntaxException, FontFormatException {
        Entry entry = Mockito.mock(Entry.class);
        when(entry.getType()).thenReturn(Entry.TYPE.PLAY);
        when(menu.getCurrentEntry()).thenReturn(entry);

        Set<ACTION> actions = Set.of(ACTION.SELECT);
        entryController.step(game, actions, System.currentTimeMillis());

        verify(game, times(1)).setState(Mockito.any(GameState.class));
    }

    @Test
    public void testExitAction() throws IOException, URISyntaxException, FontFormatException {
        Entry entry = Mockito.mock(Entry.class);
        when(entry.getType()).thenReturn(Entry.TYPE.EXIT);
        when(menu.getCurrentEntry()).thenReturn(entry);

        Set<ACTION> actions = Set.of(ACTION.SELECT);
        entryController.step(game, actions, System.currentTimeMillis());

        verify(game, times(1)).setState(null);
    }

    @Test
    public void testRetryAction() throws IOException, URISyntaxException, FontFormatException {
        Entry entry = Mockito.mock(Entry.class);
        when(entry.getType()).thenReturn(Entry.TYPE.RETRY);
        when(menu.getCurrentEntry()).thenReturn(entry);

        Set<ACTION> actions = Set.of(ACTION.SELECT);
        entryController.step(game, actions, System.currentTimeMillis());

        verify(game, times(1)).setState(Mockito.any(GameState.class));
    }

    @Test
    public void testReturnMenuAction() throws IOException, URISyntaxException, FontFormatException {
        Entry entry = Mockito.mock(Entry.class);
        when(entry.getType()).thenReturn(Entry.TYPE.RETURN_MENU);
        when(menu.getCurrentEntry()).thenReturn(entry);

        Set<ACTION> actions = Set.of(ACTION.SELECT);
        entryController.step(game, actions, System.currentTimeMillis());

        verify(game, times(1)).setState(Mockito.any(MainMenuState.class));
    }

    @Test
    public void testPlayNoAction() throws IOException, URISyntaxException, FontFormatException {
        Entry entry = Mockito.mock(Entry.class);
        when(entry.getType()).thenReturn(Entry.TYPE.PLAY);
        when(menu.getCurrentEntry()).thenReturn(entry);

        Set<ACTION> actions = Set.of(ACTION.NONE);
        entryController.step(game, actions, System.currentTimeMillis());

        verify(game, times(0)).setState(Mockito.any());
    }

    @Test
    public void testExitNoAction() throws IOException, URISyntaxException, FontFormatException {
        Entry entry = Mockito.mock(Entry.class);
        when(entry.getType()).thenReturn(Entry.TYPE.EXIT);
        when(menu.getCurrentEntry()).thenReturn(entry);

        Set<ACTION> actions = Set.of(ACTION.NONE);
        entryController.step(game, actions, System.currentTimeMillis());

        verify(game, times(0)).setState(Mockito.any());
    }

    @Test
    public void testRetryNoAction() throws IOException, URISyntaxException, FontFormatException {
        Entry entry = Mockito.mock(Entry.class);
        when(entry.getType()).thenReturn(Entry.TYPE.RETRY);
        when(menu.getCurrentEntry()).thenReturn(entry);

        Set<ACTION> actions = Set.of(ACTION.NONE);
        entryController.step(game, actions, System.currentTimeMillis());

        verify(game, times(0)).setState(Mockito.any());
    }

    @Test
    public void testMenuNoAction() throws IOException, URISyntaxException, FontFormatException {
        Entry entry = Mockito.mock(Entry.class);
        when(entry.getType()).thenReturn(Entry.TYPE.RETURN_MENU);
        when(menu.getCurrentEntry()).thenReturn(entry);

        Set<ACTION> actions = Set.of(ACTION.NONE);
        entryController.step(game, actions, System.currentTimeMillis());

        verify(game, times(0)).setState(Mockito.any());
    }

    @Test
    public void testMultipleActions() throws IOException, URISyntaxException, FontFormatException {
        Entry entry = Mockito.mock(Entry.class);
        when(entry.getType()).thenReturn(Entry.TYPE.PLAY);
        when(menu.getCurrentEntry()).thenReturn(entry);

        Set<ACTION> actions = Set.of(ACTION.SELECT, ACTION.NONE);
        entryController.step(game, actions, System.currentTimeMillis());

        verify(game, times(1)).setState(Mockito.any(GameState.class));
    }
}
