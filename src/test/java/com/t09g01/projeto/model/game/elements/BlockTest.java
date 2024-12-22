package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlockTest {
    private Block block;

    @BeforeEach
    void setUp() {
        this.block = new Block(10, 20);
    }

    @Test
    void testInitialization() {
        Position position = block.getPosition();
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());
    }
}
