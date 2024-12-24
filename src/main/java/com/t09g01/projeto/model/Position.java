package com.t09g01.projeto.model;

import java.util.Objects;

public class Position {
    private double x;
    private double y;
    private final int velocity = 2;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}
    public double getY() {return y;}
    public void setY(double y) { this.y = y; }

    public Position getUp() {
        return new Position(x, y - velocity);
    }
    public Position getDown() {
        return new Position(x, y + velocity);
    }
    public Position getRight() {
        return new Position(x + velocity, y);
    }
    public Position getLeft() {
        return new Position(x - velocity, y);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
