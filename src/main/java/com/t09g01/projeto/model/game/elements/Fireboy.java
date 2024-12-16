package com.t09g01.projeto.model.game.elements;
import com.t09g01.projeto.model.game.temple.Temple;

public class Fireboy extends Player{
    private boolean isJumping;
    private boolean hasLanded;
    private boolean isFalling;
    public Fireboy(int x, int y, Temple temple){
        super(x,y, temple);
    }

    public boolean isDead() {
        return getTemple().gooCollision(getPosition()) || getTemple().waterCollision(getPosition());
    }

    public boolean isOnDoor(){
        return getTemple().redDoorCollision(getPosition());
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public boolean hasLanded() {
        return hasLanded;
    }

    public void setHasLanded(boolean hasLanded) {
        this.hasLanded = hasLanded;
    }

    public boolean isFalling() {
        return isFalling;
    }

    public void setFalling(boolean falling) {
        isFalling = falling;
    }
}
