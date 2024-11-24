package com.t09g01.projeto.control;

import com.t09g01.projeto.Game;
import com.t09g01.projeto.control.game.FireboyController;
import com.t09g01.projeto.control.game.TempleController;
import com.t09g01.projeto.control.game.WatergirlController;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.game.temple.Temple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TempleControllerTest {
    private Temple temple;
    private TempleController templeController;
    private FireboyController fireboyController;
    private WatergirlController watergirlController;
    private Game game;

    @BeforeEach
    public void setup() {
        temple = mock(Temple.class);
        game = mock(Game.class);
        fireboyController = mock(FireboyController.class);
        watergirlController = mock(WatergirlController.class);

        this.templeController = new TempleController(temple, fireboyController, watergirlController);
    }

    @Test
    public void testStep() {
        ACTION action = ACTION.NONE;
        templeController.step(game, action, 0);
        verify(fireboyController, times(1)).step(game, action, 0);
        verify(watergirlController, times(1)).step(game, action, 0);
    }

}
