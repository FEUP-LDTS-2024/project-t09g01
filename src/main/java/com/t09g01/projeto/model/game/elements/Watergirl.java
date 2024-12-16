package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;

public class Watergirl extends Player{
    private boolean isJumping;
    private boolean hasLanded;
    private boolean isFalling;
    private final Position maxVelocity = new Position(2.7, 3.6);
    private final double acceleration = 0.8;
    private final double jump_boost = 5.0;
    private Position velocity;


    public Watergirl(int x, int y, Temple temple){
        super(x,y, temple);
        this.velocity = new Position(0,0);
    }

    public boolean isDead(){
        return getTemple().gooCollision(getPosition()) || getTemple().lavaCollision(getPosition());
    }

    public boolean isOnDoor(){
        return getTemple().blueDoorCollision(getPosition());
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

    public void setFalling(boolean falling) {
        isFalling = falling;
    }

    public Position getVelocity() {
        return velocity;
    }

    public void setVelocity(Position velocity) {
        this.velocity = velocity;
    }

    public Position getMaxVelocity() {
        return maxVelocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getJumpBoost() {
        return jump_boost;
    }
}
