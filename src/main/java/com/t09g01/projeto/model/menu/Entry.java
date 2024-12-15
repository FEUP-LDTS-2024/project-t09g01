package com.t09g01.projeto.model.menu;

import com.t09g01.projeto.model.Position;

public class Entry {
    public enum TYPE { PLAY, EXIT};

    private final Position position;
    private final TYPE type;

    public Entry(Position position, TYPE type) {
        this.position = position;
        this.type = type;
    }

    public Position getPosition() {return position;}

    public TYPE getType() {return type;}

}
