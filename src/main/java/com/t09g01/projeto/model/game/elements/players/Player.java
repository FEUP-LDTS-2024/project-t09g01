package com.t09g01.projeto.model.game.elements.players;

import com.t09g01.projeto.model.game.elements.Element;
import com.t09g01.projeto.model.game.temple.Temple;


public class Player extends Element {

    private final int WIDTH = 7;
    private final int HEIGHT = 8;
    private final Temple temple;

    public Player(int x, int y, Temple temple){
        super(x,y);
        this.temple = temple;
    }

    public int getWidth() {return WIDTH;}
    public int getHeight() {return HEIGHT;}

    public Temple getTemple() {
        return temple;
    }

}
