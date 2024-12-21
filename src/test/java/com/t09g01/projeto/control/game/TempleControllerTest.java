package com.t09g01.projeto.control.game;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.game.FireboyController;
import com.t09g01.projeto.control.game.TempleController;
import com.t09g01.projeto.control.game.WatergirlController;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.game.elements.Fireboy;
import com.t09g01.projeto.model.game.elements.Watergirl;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.states.CreditsState;
import com.t09g01.projeto.states.GameOverState;
import com.t09g01.projeto.states.GameState;
import com.t09g01.projeto.states.MainMenuState;
import com.t09g01.projeto.view.ImageLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Set;

import static org.mockito.Mockito.*;

public class TempleControllerTest {
    private Temple temple;
    private FireboyController fireboyController;
    private WatergirlController watergirlController;
    private TempleController templeController;
    private Game game;
    private Fireboy fireboy;
    private Watergirl watergirl;

    @BeforeEach
    void setUp() {
        this.temple = Mockito.mock(Temple.class);
        this.fireboyController = Mockito.mock(FireboyController.class);
        this.watergirlController = Mockito.mock(WatergirlController.class);
        this.fireboy = Mockito.mock(Fireboy.class);
        this.watergirl = Mockito.mock(Watergirl.class);
        this.game = Mockito.mock(Game.class);
        ImageLoader imageLoader = Mockito.mock(ImageLoader.class);

        Mockito.when(temple.getFireboy()).thenReturn(fireboy);
        Mockito.when(temple.getWatergirl()).thenReturn(watergirl);
        Mockito.when(game.getImageLoader()).thenReturn(imageLoader);

        templeController = new TempleController(temple, fireboyController, watergirlController);
    }

    @Test
    void testQuit() throws IOException {
        templeController.step(game, Set.of(ACTION.QUIT), System.currentTimeMillis());

        Mockito.verify(game).setState(any(MainMenuState.class));
        Mockito.verifyNoInteractions(fireboyController, watergirlController);
    }

//    @Test
//    void testFireboyDead() throws IOException {
//        Mockito.when(fireboy.isDead()).thenReturn(true);
//        Mockito.when(watergirl.isDead()).thenReturn(false);
//
//        templeController.step(game, Set.of(), System.currentTimeMillis());
//
//        Mockito.verify(game, times(1)).setState(Mockito.any(GameOverState.class));
//    }
//
//    @Test
//    void testWatergirlDead() throws IOException {
//        when(fireboy.isDead()).thenReturn(false);
//        when(watergirl.isDead()).thenReturn(true);
//
//        templeController.step(game, Set.of(), System.currentTimeMillis());
//
//        verify(game).setState(any(GameOverState.class));
//    }
//
//    @Test
//    void testNextLevel() throws IOException {
//        when(fireboy.isOnDoor()).thenReturn(true);
//        when(watergirl.isOnDoor()).thenReturn(true);
//        when(temple.allDiamondsCollected()).thenReturn(true);
//        when(temple.getLevel()).thenReturn(1);
//        when(game.getNumberOfLevels()).thenReturn(3);
//
//        templeController.step(game, Set.of(), System.currentTimeMillis());
//
//        verify(game).setState(any(GameState.class));
//    }
//
//    @Test
//    void testCredits() throws IOException {
//        when(fireboy.isOnDoor()).thenReturn(true);
//        when(watergirl.isOnDoor()).thenReturn(true);
//        when(temple.allDiamondsCollected()).thenReturn(true);
//        when(temple.getLevel()).thenReturn(3);
//        when(game.getNumberOfLevels()).thenReturn(3);
//
//        templeController.step(game, Set.of(), System.currentTimeMillis());
//
//        verify(game).setState(any(CreditsState.class));
//    }
}
