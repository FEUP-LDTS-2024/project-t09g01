package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedDoorTest {
    private RedDoor redDoor;

    @BeforeEach
    void setUp() {
        this.redDoor = new RedDoor(10, 20);
    }

    @Test
    void testRedDoorInitialization() {
        Position position = redDoor.getPosition();
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());
    }
}
