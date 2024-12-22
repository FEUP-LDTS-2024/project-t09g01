package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedDiamondTest {
    private RedDiamond redDiamond;

    @BeforeEach
    void setUp() {
        this.redDiamond = new RedDiamond(10, 20);
    }

    @Test
    void testInitialization() {
        Position position = redDiamond.getPosition();
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());
    }
}
