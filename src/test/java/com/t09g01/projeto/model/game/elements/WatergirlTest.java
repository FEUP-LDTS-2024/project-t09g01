package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.players.Watergirl;
import com.t09g01.projeto.model.game.temple.Temple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class WatergirlTest {
    private Watergirl watergirl;
    private Temple temple;

    @BeforeEach
    void setUp() {
        temple = Mockito.mock(Temple.class);
        watergirl = new Watergirl(5, 10, temple);
    }

    @Test
    void testInitialization() {
        Position position = watergirl.getPosition();
        assertEquals(5, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    void testIsDead() {
        Mockito.when(temple.gooCollision(watergirl.getPosition())).thenReturn(true);
        assertTrue(watergirl.isDead());

        Mockito.when(temple.gooCollision(watergirl.getPosition())).thenReturn(false);
        Mockito.when(temple.lavaCollision(watergirl.getPosition())).thenReturn(true);
        assertTrue(watergirl.isDead());

        Mockito.when(temple.lavaCollision(watergirl.getPosition())).thenReturn(false);
        assertFalse(watergirl.isDead());
    }

    @Test
    void testIsOnDoor() {
        Mockito.when(temple.blueDoorCollision(watergirl.getPosition())).thenReturn(true);
        assertTrue(watergirl.isOnDoor());

        Mockito.when(temple.blueDoorCollision(watergirl.getPosition())).thenReturn(false);
        assertFalse(watergirl.isOnDoor());
    }
}
