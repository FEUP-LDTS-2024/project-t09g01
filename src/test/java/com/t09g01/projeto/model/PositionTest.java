package com.t09g01.projeto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @Test
    void testConstructorAndGetters() {
        Position position = new Position(10.0, 20.0);

        assertEquals(10.0, position.getX(), "X coordinate should be 10.0");
        assertEquals(20.0, position.getY(), "Y coordinate should be 20.0");
    }

    @Test
    void testSetters() {
        Position position = new Position(10.0, 20.0);
        position.setX(15.0);
        position.setY(25.0);

        assertEquals(15.0, position.getX(), "X coordinate should be updated to 15.0");
        assertEquals(25.0, position.getY(), "Y coordinate should be updated to 25.0");
    }

    @Test
    void testGetUp() {
        Position position = new Position(10.0, 20.0);
        Position upPosition = position.getUp();

        assertEquals(new Position(10.0, 18.0), upPosition, "getUp should decrease the Y coordinate by 2");
    }

    @Test
    void testGetDown() {
        Position position = new Position(10.0, 20.0);
        Position downPosition = position.getDown();

        assertEquals(new Position(10.0, 22.0), downPosition, "getDown should increase the Y coordinate by 2");
    }

    @Test
    void testGetRight() {
        Position position = new Position(10.0, 20.0);
        Position rightPosition = position.getRight();

        assertEquals(new Position(12.0, 20.0), rightPosition, "getRight should increase the X coordinate by 2");
    }

    @Test
    void testGetLeft() {
        Position position = new Position(10.0, 20.0);
        Position leftPosition = position.getLeft();

        assertEquals(new Position(8.0, 20.0), leftPosition, "getLeft should decrease the X coordinate by 2");
    }

    @Test
    void testEquals() {
        Position position1 = new Position(10.0, 20.0);
        Position position2 = new Position(10.0, 20.0);
        Position position3 = new Position(15.0, 25.0);

        assertTrue(position1.equals(position1), "A Position object should be equal to itself");
        assertTrue(position1.equals(position2), "Positions with the same coordinates should be equal");
        assertFalse(position1.equals(position3), "Positions with different coordinates should not be equal");
        assertFalse(position1.equals(null), "Position should not be equal to null");
        assertFalse(position1.equals("NotAPosition"), "Position should not be equal to an object of a different type");
    }
}
