package com.t09g01.projeto.model.game.elements;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;

public class Fireboy extends Player {
//    //private boolean isJumping;
//    private boolean hasLanded;
//    private boolean isFalling;
//    private Position velocity;
//    private final Position maxVelocity = new Position(2.7, 3.6);
//    private final double acceleration = 0.8;
//    private final double jump_boost = 5.0;
//    private int isJumping = 0;
//    private long jumpStart;
//    private boolean onGround;

    public Fireboy(int x, int y, Temple temple) {
        super(x, y, temple);
        //this.velocity = new Position(0, 0);
    }

    public boolean isDead() {
        return getTemple().gooCollision(getPosition()) || getTemple().waterCollision(getPosition());
    }

    public boolean isOnDoor() {
        return getTemple().redDoorCollision(getPosition());
    }

//
//    public boolean isOnGround(){
//        if (getTemple().collidesDown(getPosition(), getTemple().getBlocks())){
//            onGround = true;
//        }
//        else{
//            onGround = false;
//        }
//        return onGround;
//    }
//
//    public void startJump() {
//        if (isJumping > 0) return;
//        isJumping = 1;
//        jumpStart = System.currentTimeMillis();
//    }
//
//    public void jump(long currentTime) {
//        int jumpHeight = 6; //for now
//        long dt = currentTime - jumpStart;
//        Position startingP = getPosition();
//        int speed = 4;
//        if (isJumping == 0) return;
//        if (isJumping == 1) {
//            double newY = startingP.getY() + jumpHeight;
//            this.setPosition(new Position(startingP.getX(), newY));
//            isJumping = 2;
//            return;
//        }
//        if (isJumping == 2 && dt > 100 * speed) {
//            double newY = startingP.getY() - jumpHeight;
//            this.setPosition(new Position(startingP.getX(), newY));
//            isJumping = 3;
//            return;
//        }
//        if (isJumping == 3 && dt > 200 * speed) {
//            double newY = startingP.getY() + jumpHeight;
//            this.setPosition(new Position(startingP.getX(), newY));
//            isJumping = 4;
//            return;
//        }
//        if (isJumping == 4 && dt > 300 * speed) {
//            double newY = startingP.getY() + jumpHeight;
//            this.setPosition(new Position(startingP.getX(), newY));
//            isJumping = 0;
//            return;
//        }


    }

//    public boolean isJumping() {
//        return isJumping;
//    }
//
//    public void setJumping(boolean jumping) {
//        isJumping = jumping;
//    }
//
//    public boolean hasLanded() {
//        return hasLanded;
//    }
//
//    public void setHasLanded(boolean hasLanded) {
//        this.hasLanded = hasLanded;
//    }
//
//    public boolean isFalling() {
//        return isFalling;
//    }
//
//    public void setFalling(boolean falling) {
//        isFalling = falling;
//    }

//    public Position getVelocity() {
//        return velocity;
//    }
//
//    public void setVelocity(Position velocity) {
//        this.velocity = velocity;
//    }
//
//
//    public Position getMaxVelocity() {
//        return maxVelocity;
//    }
//
//    public double getAcceleration() {
//        return acceleration;
//    }
//
//    public double getJumpBoost() {
//        return jump_boost;
//    }


