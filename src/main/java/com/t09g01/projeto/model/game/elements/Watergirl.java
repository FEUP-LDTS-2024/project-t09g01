package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;

public class Watergirl extends Player{

    public Watergirl(int x, int y, Temple temple){
        super(x,y, temple);
    }

//    public boolean isDead(){
//        return temple.gooCollision(getPosition());
//    }
}
