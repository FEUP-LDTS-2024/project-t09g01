package com.t09g01.projeto.model.game.arena;

import com.t09g01.projeto.model.game.elements.*;

public class Arena {
    private int width;
    private int height;

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
}
