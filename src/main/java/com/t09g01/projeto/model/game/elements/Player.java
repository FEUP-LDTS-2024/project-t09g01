package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;

public class Player extends Element {

    private final int WIDTH = 7;
    private final int HEIGHT = 8;
    private Position velocity;
    private Temple temple;

    private final Position MAX_VELOCITY = new Position(1.5,2.5);
    private final double ACCELERATION = 0.4;
    private final double JUMP_BOOST = 3;

    private boolean isJumping;
    private boolean hasLanded;
    private boolean isFalling;


    public Player(int x, int y, Temple temple){
        super(x,y);
        this.temple = temple;
        this.velocity = new Position(0,0);
    }

    public int getWidth() {return WIDTH;}

    public int getHeight() {return HEIGHT;}

    public Position getVelocity() {
        return velocity;
    }

    public void setVelocity(Position velocity) {
        this.velocity = velocity;
    }

    public Position getMaxVelocity() {
        return MAX_VELOCITY;
    }

    public double getAcceleration() {
        return ACCELERATION;
    }

    public double getJumpboost() {
        return JUMP_BOOST;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public void jump(){
        velocity.setY(5.0)
    }

    public boolean isOnGround(){
        return temple.floorCollision(getPosition());
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
