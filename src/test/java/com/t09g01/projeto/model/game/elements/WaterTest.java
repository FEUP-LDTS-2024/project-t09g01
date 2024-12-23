package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.blocks.Water;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WaterTest {
    private Water water;

    @BeforeEach
    void setUp() {
        this.water = new Water(10, 20);
    }

    @Test
    void testInitialization() {
        Position position = water.getPosition();
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());
    }

    @Test
    void testSetPosition() {
        Position newPosition = new Position(30, 40);

        water.setPosition(newPosition);

        Position updatedPosition = water.getPosition();
        assertEquals(30, updatedPosition.getX(), "X position should be updated");
        assertEquals(40, updatedPosition.getY(), "Y position should be updated");
    }
}
