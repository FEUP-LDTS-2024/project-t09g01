package com.t09g01.projeto.model.game.temple;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.blocks.*;
import com.t09g01.projeto.model.game.elements.players.*;
import com.t09g01.projeto.model.game.elements.diamonds.*;
import com.t09g01.projeto.model.game.elements.doors.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TempleTest {
    private Temple temple;
    private Watergirl watergirl;
    private Fireboy fireboy;
    private Goo goo;
    private BlueDoor blueDoor;
    private List<Block> blocks;
    private List<String> lines;
    private TempleBuilder templeBuilder;

    @BeforeEach
    void setUp() throws IOException {
        temple = new Temple(100, 100, 1);
        watergirl = new Watergirl(10, 20, temple);
        fireboy = new Fireboy(10,20, temple);
        blueDoor = new BlueDoor(5,5);
        templeBuilder = new TempleBuilder(3);
    }

    @Test
    void testWidthAndHeight() {
        temple.setWidth(100);
        assertEquals(100, temple.getWidth());

        temple.setHeight(50);
        assertEquals(50, temple.getHeight());
    }

    @Test
    void testWatergirlAndFireboy() {
        temple.setWatergirl(watergirl);
        assertEquals(watergirl, temple.getWatergirl());

        temple.setFireboy(fireboy);
        assertEquals(fireboy, temple.getFireboy());
    }

    @Test
    void testBlocks() {Block block = new Block(5, 5);
        List<Block> blocks = Collections.singletonList(block);

        temple.setBlocks(blocks);
        assertEquals(blocks, temple.getBlocks());
    }

    @Test
    void testBlocks2() {
        Brick brick = new Brick (0, 0);
        Water water = new Water(10, 10);
        Lava lava = new Lava(20, 20);
        Goo goo = new Goo(30, 30);

        List<Brick> bricks = Collections.singletonList(brick);
        List<Water> waters = Collections.singletonList(water);
        List<Lava> lavas = Collections.singletonList(lava);
        List<Goo> goos = Collections.singletonList(goo);

        temple.setBricks(bricks);
        assertEquals(bricks, temple.getBricks());
        temple.setWater(waters);
        assertEquals(waters, temple.getWater());

        temple.setLava(lavas);
        assertEquals(lavas, temple.getLava());

        temple.setGoo(goos);
        assertEquals(goos, temple.getGoo());
    }

    @Test
    void testDiamonds() {
        RedDiamond redDiamond = new RedDiamond(5, 5);
        BlueDiamond blueDiamond = new BlueDiamond(10, 10);

        List<RedDiamond> redDiamonds = Collections.singletonList(redDiamond);
        List<BlueDiamond> blueDiamonds = Collections.singletonList(blueDiamond);

        temple.setRedDiamonds(redDiamonds);
        assertEquals(redDiamonds, temple.getRedDiamond());

        temple.setBlueDiamonds(blueDiamonds);
        assertEquals(blueDiamonds, temple.getBlueDiamond());
    }


    @Test
    void testDoors() {
        RedDoor redDoor = new RedDoor(5, 5);
        BlueDoor blueDoor = new BlueDoor(10, 10);

        temple.setRedDoor(redDoor);
        assertEquals(redDoor, temple.getRedDoor());

        temple.setBlueDoor(blueDoor);
        assertEquals(blueDoor, temple.getBlueDoor());
    }

    @Test
    void testLevel() {
        assertEquals(1, temple.getLevel());
    }


    @Test
    void testGooCollision() {
        goo = new Goo(10, 28);
        temple.setGoo(Collections.singletonList(goo));

        Position watergirlPosition = watergirl.getPosition();
        assertTrue(temple.gooCollision(watergirlPosition));
    }

    @Test
    void testNoGooCollision() {
        goo = new Goo(50, 50);
        temple.setGoo(Collections.singletonList(goo));

        Position watergirlPosition = watergirl.getPosition();
        assertFalse(temple.gooCollision(watergirlPosition));
    }

    @Test
    void testLavaCollision() {
        Lava lava = new Lava(10, 28);
        temple.setLava(Collections.singletonList(lava));

        Position watergirlPosition = watergirl.getPosition();
        assertTrue(temple.lavaCollision(watergirlPosition));
    }

    @Test
    void testNoLavaCollision() {
        Lava lava = new Lava(50, 50);
        temple.setLava(Collections.singletonList(lava));

        Position watergirlPosition = watergirl.getPosition();
        assertFalse(temple.lavaCollision(watergirlPosition));
    }

    @Test
    void testWaterCollision() {
        Water water = new Water(10, 28);
        temple.setWater(Collections.singletonList(water));

        Position fireboyPosition = fireboy.getPosition();
        assertTrue(temple.waterCollision(fireboyPosition));
    }

    @Test
    void testNoWaterCollision() {
        Water water = new Water(50, 50);
        temple.setWater(Collections.singletonList(water));

        Position fireboyPosition = fireboy.getPosition();
        assertFalse(temple.waterCollision(fireboyPosition));
    }

    @Test
    void testRetrieveBlueDiamond() {
        BlueDiamond blueDiamond = new BlueDiamond(10, 28);
        BlueDiamond blueDiamond2 = new BlueDiamond(20, 28);
        List<BlueDiamond> blueDiamondList = new ArrayList<>();
        blueDiamondList.add(blueDiamond);
        blueDiamondList.add(blueDiamond2);

        temple.setBlueDiamonds(blueDiamondList);

        watergirl.setPosition(new Position(10, 28));
        temple.retrieveBlueDiamonds(watergirl.getPosition());

        assertTrue(temple.getBlueDiamond().size() == 1);

        watergirl.setPosition(new Position(20, 28));
        temple.retrieveBlueDiamonds(watergirl.getPosition());

        assertTrue(temple.getBlueDiamond().isEmpty());

        assertTrue(temple.getBlueDiamond().isEmpty());
    }

    @Test
    void testRetrieveRedDiamond() {
        RedDiamond redDiamond = new RedDiamond(10, 28);
        RedDiamond redDiamond2 = new RedDiamond(20, 28);
        List<RedDiamond> redDiamondList = new ArrayList<>();
        redDiamondList.add(redDiamond);
        redDiamondList.add(redDiamond2);

        temple.setRedDiamonds(redDiamondList);

        fireboy.setPosition(new Position(10, 28));
        temple.retrieveRedDiamonds(fireboy.getPosition());

        assertTrue(temple.getRedDiamond().size() == 1);

        fireboy.setPosition(new Position(20, 28));
        temple.retrieveRedDiamonds(fireboy.getPosition());

        assertTrue(temple.getRedDiamond().isEmpty());

        assertTrue(temple.getRedDiamond().isEmpty());
    }


    @Test
    void testBlueDoorCollision() {
        BlueDoor blueDoor = new BlueDoor(10, 28);
       temple.setBlueDoor(blueDoor);

        Position insidePosition = new Position(blueDoor.getPosition().getX() + 1, blueDoor.getPosition().getY() + 1);
        assertTrue(temple.blueDoorCollision(insidePosition), "Should detect collision when inside the blue door.");

        Position outsidePosition = new Position(blueDoor.getPosition().getX() - 10, blueDoor.getPosition().getY() - 10);
        assertFalse(temple.blueDoorCollision(outsidePosition), "Should not detect collision when far outside the blue door.");

        Position edgePositionRight = new Position(blueDoor.getPosition().getX() + 7, blueDoor.getPosition().getY());
        assertTrue(temple.blueDoorCollision(edgePositionRight), "Should detect collision when on the right edge of the blue door.");

        Position edgePositionBottom = new Position(blueDoor.getPosition().getX(), blueDoor.getPosition().getY() + 7);
        assertTrue(temple.blueDoorCollision(edgePositionBottom), "Should detect collision when on the bottom edge of the blue door.");

        Position outsideLeftPosition = new Position(blueDoor.getPosition().getX() - 10, blueDoor.getPosition().getY());
        assertFalse(temple.blueDoorCollision(outsideLeftPosition), "Should not detect collision when to the left of the blue door.");

        Position outsideAbovePosition = new Position(blueDoor.getPosition().getX(), blueDoor.getPosition().getY() - 10);
        assertFalse(temple.blueDoorCollision(outsideAbovePosition), "Should not detect collision when above the blue door.");

        Position partiallyOverlapLeft = new Position(blueDoor.getPosition().getX() + 3, blueDoor.getPosition().getY() + 3);
        assertTrue(temple.blueDoorCollision(partiallyOverlapLeft), "Should detect collision when partially overlapping on the left.");

        Position partiallyOverlapRight = new Position(blueDoor.getPosition().getX() + 6, blueDoor.getPosition().getY() + 3);
        assertTrue(temple.blueDoorCollision(partiallyOverlapRight), "Should detect collision when partially overlapping on the right.");

        Position partiallyOverlapTop = new Position(blueDoor.getPosition().getX() + 3, blueDoor.getPosition().getY() + 3);
        assertTrue(temple.blueDoorCollision(partiallyOverlapTop));

        Position partiallyOverlapBottom = new Position(blueDoor.getPosition().getX() + 3, blueDoor.getPosition().getY() + 6);
        assertTrue(temple.blueDoorCollision(partiallyOverlapBottom));
    }


    @Test
    void testRedDoorCollision() {
        RedDoor redDoor = new RedDoor(10, 28);
        temple.setRedDoor(redDoor);

        Position insidePosition = new Position(redDoor.getPosition().getX() + 1, redDoor.getPosition().getY() + 1);
        assertTrue(temple.redDoorCollision(insidePosition));

        Position outsidePosition = new Position(redDoor.getPosition().getX() - 10, redDoor.getPosition().getY() - 10);
        assertFalse(temple.redDoorCollision(outsidePosition));

        Position edgePosition = new Position(redDoor.getPosition().getX() + 7, redDoor.getPosition().getY() + 7);
        assertTrue(temple.redDoorCollision(edgePosition));
    }


    @Test
    void testAllDiamondsCollected() {
        temple.setBlueDiamonds(Collections.emptyList());
        temple.setRedDiamonds(Collections.emptyList());
        assertTrue(temple.allDiamondsCollected());

        BlueDiamond blueDiamond = new BlueDiamond(10, 28);
        temple.setBlueDiamonds(Collections.singletonList(blueDiamond));
        temple.setRedDiamonds(Collections.emptyList());
        assertFalse(temple.allDiamondsCollected());

        RedDiamond redDiamond = new RedDiamond(20, 28);
        temple.setBlueDiamonds(Collections.emptyList());
        temple.setRedDiamonds(Collections.singletonList(redDiamond));
        assertFalse(temple.allDiamondsCollected());

        temple.setBlueDiamonds(Collections.singletonList(blueDiamond));
        temple.setRedDiamonds(Collections.singletonList(redDiamond));
        assertFalse(temple.allDiamondsCollected());
    }


    @Test
    void testCollidesLeft() {
        Block block = new Block(5, 5);
        List<Block> blocks = Collections.singletonList(block);

        Position playerPosition = new Position(5, 4);

        assertTrue(temple.collidesLeft(playerPosition, blocks));
    }

    @Test
    void testCollidesRight() {
        Block block = new Block(5, 5);
        List<Block> blocks = Collections.singletonList(block);

        Position playerPosition = new Position(4, 5);
        assertTrue(temple.collidesRight(playerPosition, blocks));
    }

    @Test
    void testCollidesUp() {
        Block block = new Block(5, 5);
        List<Block> blocks = Collections.singletonList(block);

        Position playerPosition = new Position(5, 5);

        assertTrue(temple.collidesUp(playerPosition, blocks));
    }

    @Test
    void testCollidesDown() {
        Block block = new Block(5, 5);
        List<Block> blocks = Collections.singletonList(block);

        Position playerPosition = new Position(5, 5);

        assertTrue(temple.collidesDown(playerPosition, blocks));
    }

    @Test
    void testCheckCollisionReturnsFalse() {
        blocks = new ArrayList<>();
        blocks.add(new Block(10, 10));
        blocks.add(new Block(20,20));
        Position topLeft = new Position(30, 30);  // Outside the blocks (no collision)
        Position bottomRight = new Position(35, 35);

        // No block overlaps with this bounding box
        assertFalse(temple.checkCollision(topLeft, bottomRight, blocks), "Collision should not be detected.");
    }


    @Test
    void testTempleBuilderIOException() {
        assertThrows(IOException.class, () -> {new TempleBuilder(999);});
    }

    @Test
    void testValidateLevelWithEmptyFile() {
        // Use a local variable to simulate the empty file scenario
        List<String> lines = Collections.emptyList();  // Empty lines
        templeBuilder.lines = lines;  // Set directly if accessible or use reflection

        // Assert that an IllegalStateException is thrown when validating the level
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            templeBuilder.validateLevel();  // Should throw "Level file is empty!" exception
        });

        // Assert the exception message
        assertEquals("Level file is empty!", exception.getMessage());
    }

    @Test
    void testValidateLevelWithInconsistentLineLengths() {
        // Use a local variable to simulate inconsistent line lengths scenario
        List<String> lines = Arrays.asList(
                "..........",  // length 10
                "........",    // length 8 (inconsistent)
                ".........."   // length 10
        );
        templeBuilder.lines = lines;  // Set directly if accessible or use reflection

        // Assert that an IllegalStateException is thrown when validating the level
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            templeBuilder.validateLevel();  // Should throw "Inconsistent line lengths in level file!" exception
        });

        // Assert the exception message
        assertEquals("Inconsistent line lengths in level file!", exception.getMessage());
    }

    @Test
    void testCreateFireboyWithMissingPosition() {
        // Simulating the level lines with no 'F' for Fireboy
        List<String> lines = Arrays.asList(
                "..........",  // no 'F' here
                "..........",  // no 'F' here
                ".........."
        );
        templeBuilder.lines = lines;  // Set directly if accessible or use reflection

        // Assert that an IllegalStateException is thrown when trying to create Fireboy
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            templeBuilder.createFireboy(temple);  // Should throw "Fireboy position not found in level file!" exception
        });

        // Assert the exception message
        assertEquals("Fireboy position not found in level file!", exception.getMessage());
    }

    @Test
    void testCreateWatergirlWithMissingPosition() {
        // Simulating the level lines with no 'W' for Watergirl
        List<String> lines = Arrays.asList(
                "..........",  // no 'W' here
                "..........",  // no 'W' here
                ".........."
        );
        templeBuilder.lines = lines;  // Set directly if accessible or use reflection

        // Assert that an IllegalStateException is thrown when trying to create Watergirl
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            templeBuilder.createWatergirl(temple);  // Should throw "Watergirl position not found in level file!" exception
        });

        // Assert the exception message
        assertEquals("Watergirl position not found in level file!", exception.getMessage());
    }

    @Test
    void testCreateBlueDoorWithMissingPosition() {
        // Simulating the level lines with no 'D' for BlueDoor
        List<String> lines = Arrays.asList(
                "..........",  // no 'D' here
                "..........",  // no 'D' here
                ".........."
        );
        templeBuilder.lines = lines;  // Set directly if accessible or use reflection

        // Assert that an IllegalStateException is thrown when trying to create BlueDoor
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            templeBuilder.createBlueDoor();  // Should throw "BlueDoor position not found in level file!" exception
        });

        // Assert the exception message
        assertEquals("BlueDoor position not found in level file!", exception.getMessage());
    }

    // Test Case 2: Test RedDoor creation when 'P' is not found in the level file
    @Test
    void testCreateRedDoorWithMissingPosition() {
        // Simulating the level lines with no 'P' for RedDoor
        List<String> lines = Arrays.asList(
                "..........",  // no 'P' here
                "..........",  // no 'P' here
                ".........."
        );
        templeBuilder.lines = lines;  // Set directly if accessible or use reflection

        // Assert that an IllegalStateException is thrown when trying to create RedDoor
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            templeBuilder.createRedDoor();  // Should throw "RedDoor position not found in level file!" exception
        });

        // Assert the exception message
        assertEquals("RedDoor position not found in level file!", exception.getMessage());
    }
}
