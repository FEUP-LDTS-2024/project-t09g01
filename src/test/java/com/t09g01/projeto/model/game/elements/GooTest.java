package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GooTest {
    private Goo goo;

    @BeforeEach
    void setUp() {
        this.goo = new Goo(10, 20);
    }

    @Test
    void testInitialization() {
        Position position = goo.getPosition();
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());
    }
}
