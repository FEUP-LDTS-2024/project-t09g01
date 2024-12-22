package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlueDoorTest {
    private BlueDoor blueDoor;

    @BeforeEach
    void setUp() {
        blueDoor = new BlueDoor(10, 20);
    }

    @Test
    void testBlueDoorInitialization() {
        Position position = blueDoor.getPosition();
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());
    }
}
