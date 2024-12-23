package com.t09g01.projeto.model.game.elements;
import com.t09g01.projeto.model.game.temple.Temple;

public class Fireboy extends Player {

    public Fireboy(int x, int y, Temple temple) {
        super(x, y, temple);
    }

    public boolean isDead() {
        return getTemple().gooCollision(getPosition()) || getTemple().waterCollision(getPosition());
    }

    public boolean isOnDoor() {
        return getTemple().redDoorCollision(getPosition());
    }
}




