package com.t09g01.projeto.model.game.elements;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.t09g01.projeto.model.Position;

import java.awt.*;

public abstract class Element {
    private Position position;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {this.position = position;}

}