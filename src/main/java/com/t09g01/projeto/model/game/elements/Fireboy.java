package com.t09g01.projeto.model.game.elements;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;

public class Fireboy extends Player{
    private boolean isJumping;
    private boolean hasLanded;
    private boolean isFalling;
    private Position velocity;
    private final Position maxVelocity = new Position(3.0, 4.0);
    private final double acceleration = 1.0;
    private final double jump_boost = 4.0;

    public Fireboy(int x, int y, Temple temple){
        super(x,y, temple);
        this.velocity = new Position(0,0);
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
