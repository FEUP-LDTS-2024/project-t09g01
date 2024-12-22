package com.t09g01.projeto.model.game.temple;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TempleTest {
    private Temple temple;
    private Watergirl watergirl;
    private Fireboy fireboy;
    private Goo goo;

    @BeforeEach
    void setUp() {
        temple = new Temple(100, 100, 1);
        watergirl = new Watergirl(10, 20, temple);
        fireboy = new Fireboy(10,20, temple);
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
    void testBlocks() {
        Block block = new Block(5, 5);
        List<Block> blocks = Collections.singletonList(block);

        temple.setBlocks(blocks);
        assertEquals(blocks, temple.getBlocks());
    }

    @Test
    void testFluids() {
        Water water = new Water(10, 10);
        Lava lava = new Lava(20, 20);
        Goo goo = new Goo(30, 30);

        List<Water> waters = Collections.singletonList(water);
        List<Lava> lavas = Collections.singletonList(lava);
        List<Goo> goos = Collections.singletonList(goo);

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
        assertTrue(temple.gooCollision(watergirlPosition), "Watergirl should collide with goo");
    }

    @Test
    void testNoGooCollision() {
        goo = new Goo(50, 50);
        temple.setGoo(Collections.singletonList(goo));

        Position watergirlPosition = watergirl.getPosition();
        assertFalse(temple.gooCollision(watergirlPosition), "Watergirl should not collide with goo");
    }

    @Test
    void testLavaCollision() {
        Lava lava = new Lava(10, 28);
        temple.setLava(Collections.singletonList(lava));

        Position watergirlPosition = watergirl.getPosition();
        assertTrue(temple.lavaCollision(watergirlPosition), "Watergirl should collide with lava");
    }

    @Test
    void testNoLavaCollision() {
        Lava lava = new Lava(50, 50);
        temple.setLava(Collections.singletonList(lava));

        Position watergirlPosition = watergirl.getPosition();
        assertFalse(temple.lavaCollision(watergirlPosition), "Watergirl should not collide with lava");
    }

    @Test
    void testWaterCollision() {
        Water water = new Water(10, 28);
        temple.setWater(Collections.singletonList(water));

        Position fireboyPosition = fireboy.getPosition();
        assertTrue(temple.waterCollision(fireboyPosition), "Fireboy should collide with water");
    }

    @Test
    void testNoWaterCollision() {
        Water water = new Water(50, 50);
        temple.setWater(Collections.singletonList(water));

        Position fireboyPosition = fireboy.getPosition();
        assertFalse(temple.waterCollision(fireboyPosition), "Fireboy should not collide with water");
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

        assertTrue(temple.getBlueDiamond().size() == 1, "One blue diamond should be removed after retrieval");

        watergirl.setPosition(new Position(20, 28));
        temple.retrieveBlueDiamonds(watergirl.getPosition());

        assertTrue(temple.getBlueDiamond().isEmpty(), "Second blue diamond should be removed after retrieval");

        assertTrue(temple.getBlueDiamond().isEmpty(), "Blue diamonds should be empty after both retrieved");
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

        assertTrue(temple.getRedDiamond().size() == 1, "One red diamond should be removed after retrieval");

        fireboy.setPosition(new Position(20, 28));
        temple.retrieveRedDiamonds(fireboy.getPosition());

        assertTrue(temple.getRedDiamond().isEmpty(), "Second red diamond should be removed after retrieval");

        assertTrue(temple.getRedDiamond().isEmpty(), "Red diamonds should be empty after both retrieved");
    }


    @Test
    void testBlueDoorCollision() {
        BlueDoor blueDoor = new BlueDoor(10, 28);
        temple.setBlueDoor(blueDoor);

        Position insidePosition = new Position(blueDoor.getPosition().getX() + 1, blueDoor.getPosition().getY() + 1);
        assertTrue(temple.blueDoorCollision(insidePosition), "Position should collide with the blue door");

        Position outsidePosition = new Position(blueDoor.getPosition().getX() - 10, blueDoor.getPosition().getY() - 10);
        assertFalse(temple.blueDoorCollision(outsidePosition), "Position should not collide with the blue door");

        Position edgePosition = new Position(blueDoor.getPosition().getX() + 7, blueDoor.getPosition().getY() + 7);
        assertTrue(temple.blueDoorCollision(edgePosition), "Position on the edge should collide with the blue door");
    }

    @Test
    void testRedDoorCollision() {
        RedDoor redDoor = new RedDoor(10, 28);
        temple.setRedDoor(redDoor);

        Position insidePosition = new Position(redDoor.getPosition().getX() + 1, redDoor.getPosition().getY() + 1);
        assertTrue(temple.redDoorCollision(insidePosition), "Position should collide with the red door");

        Position outsidePosition = new Position(redDoor.getPosition().getX() - 10, redDoor.getPosition().getY() - 10);
        assertFalse(temple.redDoorCollision(outsidePosition), "Position should not collide with the red door");

        Position edgePosition = new Position(redDoor.getPosition().getX() + 7, redDoor.getPosition().getY() + 7);
        assertTrue(temple.redDoorCollision(edgePosition), "Position on the edge should collide with the red door");
    }


    @Test
    void testAllDiamondsCollected() {
        temple.setBlueDiamonds(Collections.emptyList());
        temple.setRedDiamonds(Collections.emptyList());
        assertTrue(temple.allDiamondsCollected(), "All diamonds should be collected");

        BlueDiamond blueDiamond = new BlueDiamond(10, 28);
        temple.setBlueDiamonds(Collections.singletonList(blueDiamond));
        temple.setRedDiamonds(Collections.emptyList());
        assertFalse(temple.allDiamondsCollected(), "Not all diamonds should be collected");

        RedDiamond redDiamond = new RedDiamond(20, 28);
        temple.setBlueDiamonds(Collections.emptyList());
        temple.setRedDiamonds(Collections.singletonList(redDiamond));
        assertFalse(temple.allDiamondsCollected(), "Not all diamonds should be collected");

        temple.setBlueDiamonds(Collections.singletonList(blueDiamond));
        temple.setRedDiamonds(Collections.singletonList(redDiamond));
        assertFalse(temple.allDiamondsCollected(), "Not all diamonds should be collected");
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




}
