package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.model.game.elements.players.Fireboy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class FireboyTest {
    private Fireboy fireboy;
    private Temple temple;

    @BeforeEach
    void setUp() {
        temple = Mockito.mock(Temple.class);
        fireboy = new Fireboy(5, 10, temple);
    }

    @Test
    void testInitialization() {
        Position position = fireboy.getPosition();
        assertEquals(5, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    void testIsDead() {
        Mockito.when(temple.gooCollision(fireboy.getPosition())).thenReturn(true);
        assertTrue(fireboy.isDead());

        Mockito.when(temple.gooCollision(fireboy.getPosition())).thenReturn(false);
        Mockito.when(temple.waterCollision(fireboy.getPosition())).thenReturn(true);
        assertTrue(fireboy.isDead());

        Mockito.when(temple.waterCollision(fireboy.getPosition())).thenReturn(false);
        assertFalse(fireboy.isDead());
    }

    @Test
    void testIsOnDoor() {
        Mockito.when(temple.redDoorCollision(fireboy.getPosition())).thenReturn(true);
        assertTrue(fireboy.isOnDoor());

        Mockito.when(temple.redDoorCollision(fireboy.getPosition())).thenReturn(false);
        assertFalse(fireboy.isOnDoor());
    }
}
