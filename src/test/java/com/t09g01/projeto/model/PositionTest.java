package com.t09g01.projeto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private Position position;

    @BeforeEach
    public  void setUp() {
        position = new Position(3,5);
    }

    // Initializing
    @Test
    public void testConstructor() {
        assertEquals(3, position.getX());
        assertEquals(5, position.getY());
    }

    // Movements
    @Test
    public void testGetUp() {
        Position up = position.getUp();
        assertEquals(new Position(3, 6), up);
    }

    @Test
    public void testGetDown() {
        Position down = position.getDown();
        assertEquals(new Position(3, 4), down);
    }

    @Test
    public void testGetRight() {
        Position right = position.getRight();
        assertEquals(new Position(4, 5), right);
    }

    @Test
    public void testGetLeft() {
        Position left = position.getLeft();
        assertEquals(new Position(2, 5), left);
    }

    // Equal method
    @Test
    public void testEquals() {
        Position samePosition = position;
        Position diffPosition = new Position(1,2);
        
        assertTrue(position.equals(samePosition));
        assertFalse(position.equals(diffPosition));
    }
}
