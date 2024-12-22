package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player player;
    private Temple temple;

    @BeforeEach
    void setUp() {
        this.temple = Mockito.mock(Temple.class);
        player = new Player(5, 10, temple);
    }

    @Test
    void testPlayerInstantiation() {
        Position position = player.getPosition();  // Assuming Player has a method getPosition()
        assertEquals(5, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    void testGetWidth() {
        assertEquals(7, player.getWidth());
    }

    @Test
    void testGetHeight() {
        assertEquals(8, player.getHeight());
    }

    @Test
    void testTempleAssociation() {
        assertNotNull(player.getTemple());
        assertSame(temple, player.getTemple());
    }

//    @Test
//    void testMaxVelocity() {
//        Position maxVelocity = player.getMaxVelocity();
//        assertEquals(3.0, maxVelocity.getX());
//        assertEquals(4.0, maxVelocity.getY());
//    }
//
//    @Test
//    void testAcceleration() {
//        assertEquals(1.0, player.getAcceleration());
//    }
//
//    @Test
//    void testJumpBoost() {
//        assertEquals(4.0, player.getJumpBoost());
//    }
}
