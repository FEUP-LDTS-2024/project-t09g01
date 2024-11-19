package com.t09g01.projeto.model.game.arena;

import com.t09g01.projeto.model.game.elements.*;

import java.util.List;

public class Arena {
    private int width;
    private int height;

    private Watergirl watergirl;
    private Fireboy fireboy;

    private List<Wall> walls;
    private List<Floor> floors;

    private Water water;
    private Lava lava;
    private Goo goo;


    public Arena(int width, int height){
        this.width = width;
        this.height = height;
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
    public void setWalls(List<Wall> walls) {this.walls = walls;}
    public List<Wall> getWalls() {return walls;}
    public void setFloors(List<Floor> floors) {this.floors = floors;}
    public List<Floor> getFloors() {return floors;}

    // Fluids
    public Water getWater() { return water; }
    public void setWater(Water water) { this.water = water; }
    public Lava getLava() { return lava; }
    public void setLava(Lava lava) { this.lava = lava; }
    public Goo getGoo() { return goo; }
    public void setGoo(Goo goo) { this.goo = goo; }
}
