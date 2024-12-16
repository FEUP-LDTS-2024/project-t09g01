package com.t09g01.projeto.model.game.elements;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.t09g01.projeto.model.Position;

import java.awt.*;

public abstract class Element {
    private Position position;
    protected Polygon hitbox;

    public Element(int x, int y) {
        this.position = new Position(x, y);
        this.hitbox = new Polygon();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {

        double oldX = this.position.getX();
        double oldY = this.position.getY();

        this.position = position;

        int deltaX = (int) (this.position.getX() - oldX);
        int deltaY = (int) (this.position.getY() - oldY);

        hitbox.translate(deltaX, deltaY);
    }

    public Polygon getPolygon() {
        return hitbox;
    }

}