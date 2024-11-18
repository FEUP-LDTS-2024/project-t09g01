package com.t09g01.projeto.model.game.arena;

import com.t09g01.projeto.model.game.elements.*;

import java.util.List;

public class Arena {
    private int width;
    private int height;
    private List<Wall> walls;
    private List<Floor> floors;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getHeight() {return height;}
    public int getWidth() {return width;}

    private Watergirl watergirl;
    private Fireboy fireboy;

    public Watergirl getWatergirl() {return watergirl;}
    public Fireboy getFireboy() {return fireboy;}

    public void setWalls(List<Wall> walls) {this.walls = walls;}
    public List<Wall> getWalls() {return walls;}

    public void setFloors(List<Floor> floors) {this.floors = floors;}
    public List<Floor> getFloors() {return floors;}
}
