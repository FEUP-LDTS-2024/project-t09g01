package com.t09g01.projeto.model.game.temple;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.*;

import java.util.List;

public class Temple {
    private int width;
    private int height;

    private Watergirl watergirl;
    private Fireboy fireboy;

    private List<Block> blocks;

    private Water water;
    private Lava lava;
    private Goo goo;

    private final double gravity;


    public Temple(int width, int height){
        this.width = width;
        this.height = height;
        this.gravity = 0.3;
    }

    // Width and Height
    public int getHeight() {return height;}
    public void setHeight(int height) { this.height = height; }
    public int getWidth() {return width;}
    public void setWidth(int width) { this.width = width; }

    // Players
    public Watergirl getWatergirl() {return watergirl;}
    public void setWatergirl(Watergirl watergirl) {this.watergirl = watergirl;}
    public Fireboy getFireboy() {return fireboy;}
    public void setFireboy(Fireboy fireboy) {this.fireboy = fireboy;}

    // Walls and Floors
    public void setBlocks(List<Block> blocks) {this.blocks = blocks;}
    public List<Block> getBlocks() {return blocks;}

    // Fluids
    public Water getWater() { return water; }
    public void setWater(Water water) { this.water = water; }
    public Lava getLava() { return lava; }
    public void setLava(Lava lava) { this.lava = lava; }
    public Goo getGoo() { return goo; }
    public void setGoo(Goo goo) { this.goo = goo; }

    public boolean checkCollisions(Position position) {
        double playerX = position.getX();
        double playerY = position.getY();

        for (Block block : blocks) {
            Position blockPosition = block.getPosition();
            double blockX = blockPosition.getX();
            double blockY = blockPosition.getY();

            // Check if the player's 8x8 area overlaps with the block's 8x8 area
            if (playerX < blockX + 8 && playerX + 7 > blockX &&
                    playerY < blockY + 8 && playerY + 8 > blockY) {
                return true;
            }
        }
        return false;
    }

    public boolean floorCollision(Position position) {
        double playerX = position.getX();
        double playerY = position.getY();

        for (Block block : blocks) {
            Position blockPosition = block.getPosition();
            double blockX = blockPosition.getX();
            double blockY = blockPosition.getY();

            // Check if the player's feet are on top of the block
            if (playerX < blockX + 8 && playerX + 7 > blockX &&
                    playerY + 8 == blockY) {
                return true;
            }
        }
        return false;
    }
}
