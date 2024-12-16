package com.t09g01.projeto.model;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}
    public double getY() {return y;}
    public void setY(double y) { this.y = y; }

    public Position getUp() {
        return new Position(x, y - 2);
    }
    public Position getDown() {
        return new Position(x, y +2);
    }
    public Position getRight() {
        return new Position(x + 2, y);
    }
    public Position getLeft() {
        return new Position(x - 2, y);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }
}
