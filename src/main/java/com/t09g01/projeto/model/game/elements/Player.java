package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;

public class Player extends Element {

    private Position velocity;

    private final Position maxVelocity;
    private final double acceleration;
    private final double jumpboost;

    private boolean isJumping;
    private boolean hasLanded;
    private boolean isFalling;


    public Player(int x, int y){
        super(x,y);
        this.velocity = new Position(0,0);
        this.maxVelocity = new Position(1.5,2.5);
        this.acceleration = 0.4;
        this.jumpboost = 3;
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

    public double getJumpboost() {
        return jumpboost;
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

    public void setHasLanded(boolean landed) {
        hasLanded = landed;
    }

    public boolean isFalling() {
        return isFalling;
    }

    public void setFalling(boolean falling) {
        isFalling = falling;
    }

}
