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

    private List<Water> waters;
    private List<Lava> lavas;
    private List<Goo> goos;

    private List<RedDiamond> redDiamonds;
    private List<BlueDiamond> blueDiamonds;

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
    public List<Water> getWater() {return waters;}
    public void setWater (List<Water> waters) { this.waters = waters; }
    public List<Lava> getLava() { return lavas; }
    public void setLava(List<Lava> lavas) { this.lavas = lavas; }
    public List<Goo> getGoo() { return goos; }
    public void setGoo(List<Goo> goos) { this.goos = goos; }

    // Diamonds
    public List<RedDiamond> getRedDiamond() {return redDiamonds;}
    public List<BlueDiamond> getBlueDiamond() {return blueDiamonds;}
    public void setRedDiamonds(List<RedDiamond> redDiamonds) {this.redDiamonds = redDiamonds;}
    public void setBlueDiamonds(List<BlueDiamond> blueDiamonds) {this.blueDiamonds = blueDiamonds;}

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

    public boolean gooCollision(Position position) {
        double playerX = position.getX();
        double playerY = position.getY();

        for (Goo goo : goos) {
            Position gooPosition = goo.getPosition();
            double gooX = gooPosition.getX();
            double gooY = gooPosition.getY();

            // Check if the player's feet are on top of the block
            if (playerX < gooX + 8 && playerX + 7 > gooX &&
                    playerY + 8 == gooY) {
                return true;
            }
        }
        return false;
    }

    public boolean lavaCollision(Position position) {       //watergirl position
        double watergirlX = position.getX();
        double watergirlY = position.getY();

        for (Lava lava : lavas) {
            Position gooPosition = lava.getPosition();
            double lavaX = gooPosition.getX();
            double lavaY = gooPosition.getY();

            // Check if the player's feet are on top of the block
            if (watergirlX < lavaX + 8 && watergirlY + 7 > lavaX &&
                    watergirlY + 8 == lavaY) {
                return true;
            }
        }
        return false;
    }

    public boolean waterCollision(Position position) {
        double fireboyX = position.getX();
        double fireboyY = position.getY();

        for (Water water : waters) {
            Position gooPosition = water.getPosition();
            double waterX = gooPosition.getX();
            double waterY = gooPosition.getY();

            // Check if the player's feet are on top of the block
            if (fireboyX < waterX + 8 && fireboyX + 7 > waterX &&
                    fireboyY + 8 == waterY) {
                return true;
            }
        }
        return false;
    }
}
