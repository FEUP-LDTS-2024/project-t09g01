package com.t09g01.projeto.model;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.Element;
import com.t09g01.projeto.model.game.elements.Fireboy;
import com.t09g01.projeto.model.game.elements.Watergirl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ElementTest {
    private Element element;

    @Test
    void testGet() {
        element = new Fireboy(5,5);
        assertNotNull(element.getPosition());
        assertEquals(5, element.getPosition().getX());
        assertEquals(5, element.getPosition().getY());
    }

    @Test
    void testSet() {
        element = new Watergirl(5,5);
        element.setPosition(new Position(3,2));
        assertEquals(3, element.getPosition().getX());
        assertEquals(2, element.getPosition().getY());
    }
}
