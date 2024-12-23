package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.diamonds.BlueDiamond;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlueDiamondTest {
    private BlueDiamond blueDiamond;

    @BeforeEach
    void setUp() {
        this.blueDiamond = new BlueDiamond(10, 20);
    }

    @Test
    void testInitialization() {
        Position position = blueDiamond.getPosition();
        assertEquals(10, position.getX());
        assertEquals(20, position.getY());
    }
}
