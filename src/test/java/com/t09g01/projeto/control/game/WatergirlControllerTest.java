package com.t09g01.projeto.control;

import com.t09g01.projeto.control.game.WatergirlController;
import com.t09g01.projeto.gui.ACTION;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.Watergirl;
import com.t09g01.projeto.model.game.temple.Temple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WatergirlControllerTest {
    private Temple temple;
    private WatergirlController controller;
    private Watergirl watergirl;

    @BeforeEach
    void setUp() {
        temple = Mockito.mock(Temple.class);
        watergirl = Mockito.mock(Watergirl.class);
        when(temple.getWatergirl()).thenReturn(watergirl);
        when(watergirl.getPosition()).thenReturn(new Position(5,5));

        controller = new WatergirlController(temple);
    }

    @Test
    void testMoveRight() {
        controller.moveWatergirlRight();
        verify(watergirl).setPosition(new Position(6,5));
    }

    @Test
    void testMoveLeft() {
        controller.moveWatergirlLeft();
        verify(watergirl).setPosition(new Position(4,5));
    }

    @Test
    void testMoveUp() {
        controller.moveWatergirlUp();
        verify(watergirl).setPosition(new Position(5,6));
    }

    @Test
    void testMoveDown() {
        controller.moveWatergirlDown();
        verify(watergirl).setPosition(new Position(5,4));
    }

//    @Test
//    void testStep() {
//        controller.step(null, ACTION.WATERGIRL_LEFT, 100);
//        verify(watergirl).setPosition(new Position(4,5));
//    }
}
