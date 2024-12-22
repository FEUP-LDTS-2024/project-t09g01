package com.t09g01.projeto.model.game.temple;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.elements.*;

import java.util.List;

public class Temple {
    private int width;
    private int height;
    private int level;

    private Watergirl watergirl;
    private Fireboy fireboy;

    private List<Block> blocks;

    private List<Water> waters;
    private List<Lava> lavas;
    private List<Goo> goos;

    private List<RedDiamond> redDiamonds;
    private List<BlueDiamond> blueDiamonds;

    private final double gravity;

    private BlueDoor blueDoor;
    private RedDoor redDoor;

    public Temple(int width, int height, int level){
        this.width = width;
        this.height = height;
        this.gravity = 0.8;
        this.level = level;
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

    // Doors
    public RedDoor getRedDoor() {return redDoor;}
    public BlueDoor getBlueDoor() {return blueDoor;}
    public void setRedDoor(RedDoor redDoor) {this.redDoor = redDoor;}
    public void setBlueDoor(BlueDoor blueDoor) {this.blueDoor = blueDoor;}

    public int getLevel() {return level;}


    private boolean checkCollision(Position topLeft, Position bottomRight, List<Block> blocks) {
        for (Block block : blocks) {
            double blockLeft = block.getPosition().getX();
            double blockRight = block.getPosition().getX() + 8;
            double blockTop = block.getPosition().getY();
            double blockBottom = block.getPosition().getY() + 8;

            boolean overlaps = !(topLeft.getX() >= blockRight ||
                    bottomRight.getX() <= blockLeft ||
                    topLeft.getY() >= blockBottom ||
                    bottomRight.getY() <= blockTop);

            if (overlaps) {
                return true;
            }
        }

        for (Lava lava : lavas){
            double blockLeft = lava.getPosition().getX();
            double blockRight = lava.getPosition().getX() + 8;
            double blockTop = lava.getPosition().getY();
            double blockBottom = lava.getPosition().getY() + 8;

            boolean overlaps = !(topLeft.getX() >= blockRight ||
                    bottomRight.getX() <= blockLeft ||
                    topLeft.getY() >= blockBottom ||
                    bottomRight.getY() <= blockTop);

            if (overlaps) {
                return true;
            }
        }

        for (Water water : waters){
            double blockLeft = water.getPosition().getX();
            double blockRight = water.getPosition().getX() + 8;
            double blockTop = water.getPosition().getY();
            double blockBottom = water.getPosition().getY() + 8;

            boolean overlaps = !(topLeft.getX() >= blockRight ||
                    bottomRight.getX() <= blockLeft ||
                    topLeft.getY() >= blockBottom ||
                    bottomRight.getY() <= blockTop);

            if (overlaps) {
                return true;
            }
        }

        for (Goo goo : goos){
            double blockLeft = goo.getPosition().getX();
            double blockRight = goo.getPosition().getX() + 8;
            double blockTop = goo.getPosition().getY();
            double blockBottom = goo.getPosition().getY() + 8;

            boolean overlaps = !(topLeft.getX() >= blockRight ||
                    bottomRight.getX() <= blockLeft ||
                    topLeft.getY() >= blockBottom ||
                    bottomRight.getY() <= blockTop);

            if (overlaps) {
                return true;
            }
        }
        return false;
    }

    public boolean collidesLeft(Position position, List<Block> blocks) {
        Position topLeft = position;
        Position bottomRight = new Position(position.getX() + 1, position.getY() + 8 - 1);
        return checkCollision(topLeft, bottomRight, blocks);
    }

    public boolean collidesRight(Position position, List<Block> blocks) {
        Position topLeft = new Position(position.getX() + 8 - 1, position.getY());
        Position bottomRight = new Position(position.getX() + 8, position.getY() + 8 - 1);
        return checkCollision(topLeft, bottomRight, blocks);
    }

    public boolean collidesUp(Position position, List<Block> blocks) {
        Position topLeft = position;
        Position bottomRight = new Position(position.getX() + 8 - 1, position.getY() + 1);
        return checkCollision(topLeft, bottomRight, blocks);
    }

    public boolean collidesDown(Position position, List<Block> blocks) {
        Position topLeft = new Position(position.getX(), position.getY() + 8 -1);
        Position bottomRight = new Position(position.getX() + 8 - 1, position.getY() + 8 );
        return checkCollision(topLeft, bottomRight, blocks);
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
            Position lavaPosition = lava.getPosition();
            double lavaX = lavaPosition.getX();
            double lavaY = lavaPosition.getY();

            // Check if the player's feet are on top of the block
            if (watergirlX < lavaX + 8 && watergirlX + 7 > lavaX &&
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
            Position waterPosition = water.getPosition();
            double waterX = waterPosition.getX();
            double waterY = waterPosition.getY();

            // Check if the player's feet are on top of the block
            if (fireboyX < waterX + 8 && fireboyX + 7 > waterX &&
                    fireboyY + 8 == waterY) {
                return true;
            }
        }
        return false;
    }

    public void retrieveBlueDiamonds(Position position){

        double watergirlX = position.getX();
        double watergirlY = position.getY();

        for (BlueDiamond blueDiamond : blueDiamonds) {
            Position blueDiamondPosition = blueDiamond.getPosition();
            double blueDiamondX = blueDiamond.getPosition().getX();
            double blueDiamondY = blueDiamond.getPosition().getY();

            if (watergirlX < blueDiamondX + 6 && watergirlX + 8 > blueDiamondX + 3 &&
                    watergirlY - 3 < blueDiamondY + 3 && watergirlY + 8 > blueDiamondY) {
                blueDiamonds.remove(blueDiamond);
                break;
            }
        }

    }

    public void retrieveRedDiamonds(Position position){
        double fireboyX = position.getX();
        double fireboyY = position.getY();

        for (RedDiamond redDiamond : redDiamonds) {
            Position redDiamondPosition = redDiamond.getPosition();
            double blueDiamondX = redDiamond.getPosition().getX();
            double blueDiamondY = redDiamond.getPosition().getY();

            if (fireboyX < blueDiamondX + 6 && fireboyX + 8 > blueDiamondX + 3 &&
                    fireboyY - 3 < blueDiamondY + 3 && fireboyY + 8 > blueDiamondY) {
                redDiamonds.remove(redDiamond);
                break;
            }
        }

    }

    public boolean redDoorCollision(Position position){
        return position.getX() < redDoor.getPosition().getX() + 8 &&
                position.getX() + 8 > redDoor.getPosition().getX() &&
                position.getY() < redDoor.getPosition().getY() + 8 &&
                position.getY() + 8 > redDoor.getPosition().getY();
    }

    public boolean blueDoorCollision(Position position) {
        return position.getX() < blueDoor.getPosition().getX() + 8 &&
                position.getX() + 8 > blueDoor.getPosition().getX() &&
                position.getY() < blueDoor.getPosition().getY() + 8 &&
                position.getY() + 8 > blueDoor.getPosition().getY();
    }

    public boolean allDiamondsCollected(){
        return blueDiamonds.isEmpty() && redDiamonds.isEmpty();
    }

}
