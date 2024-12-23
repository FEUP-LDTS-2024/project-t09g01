package com.t09g01.projeto.control;

import com.t09g01.projeto.control.game.FireboyController;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.players.Fireboy;
import com.t09g01.projeto.model.game.temple.Temple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FireboyControllerTest {
    private Temple temple;
    private FireboyController controller;
    private Fireboy fireboy;

    @BeforeEach
    void setUp() {
        temple = Mockito.mock(Temple.class);
        fireboy = Mockito.mock(Fireboy.class);
        when(temple.getFireboy()).thenReturn(fireboy);
        when(fireboy.getPosition()).thenReturn(new Position(5,5));

        controller = new FireboyController(temple);
    }

    @Test
    void testMoveRight() {
        controller.moveFireboyRight();
        verify(fireboy).setPosition(new Position(6,5));
    }

    @Test
    void testMoveLeft() {
        controller.moveFireboyLeft();
        verify(fireboy).setPosition(new Position(4,5));
    }

    @Test
    void testMoveUp() {
        controller.moveFireboyUp();
        verify(fireboy).setPosition(new Position(5,6));
    }

    @Test
    void testMoveDown() {
        controller.moveFireboyDown();
        verify(fireboy).setPosition(new Position(5,4));
    }

//    @Test
//    void testStep() {
//        controller.step(null, ACTION.FIREBOY_LEFT, 100);
//        verify(fireboy).setPosition(new Position(4,5));
//    }
}
