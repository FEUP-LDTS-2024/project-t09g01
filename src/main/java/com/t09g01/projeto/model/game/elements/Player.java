package com.t09g01.projeto.model.game.elements;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.game.temple.Temple;

public class Player extends Element {

    private final int WIDTH = 7;
    private final int HEIGHT = 8;
    private Position velocity;
    private final Temple temple;
    private Position lastPosition;
    //private int isJumping = 0;
    private long jumpStart;
    private int jumpHeight = 50;

    private boolean isJumping;

    private boolean hasLanded;
    private boolean isFalling;
    private boolean isFacingRight;

    private final Position maxVelocity = new Position(2.0, 3.0) ;
    private final double acceleration = 0.5;
    private final double jump_boost = 4.0;
//    private final double GRAVITY = -0.2;

    private boolean onGround;

    public Player(int x, int y, Temple temple){
        super(x,y);
        this.velocity = new Position(1,1);
        this.temple = temple;

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
        return maxVelocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getJumpBoost() {
        return jump_boost;
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





    public boolean isOnGround(){
        if (temple.floorCollision(getPosition())){
            onGround = true;
        }
        return onGround;
    }

//    public void jump(){
//        isOnGround();
//        if (onGround){
//            velocity.setY(JUMP_BOOST);
//            this.onGround = false;
//        }
//    }
//
//    public void defyingGravity(){       //that's my line! OOOOOOOOOOOAAAAAAAAAAHHHHHH
//        if (!onGround){
//            velocity.setY(velocity.getY() + GRAVITY);
//        }
//    }

//    public void startJump(){
//        if(isJumping>0) return ;
//        isJumping=1;
//        jumpStart = System.currentTimeMillis();
//    }
//
//    public void jump(long currentTime) {
//        long dt = currentTime - jumpStart;
//        double jumpDuration = 500; // Total duration of the jump in milliseconds
//        double jumpHeight = 8; // Maximum height of the jump in pixels
//
//        if (isJumping == 0) return;
//
//        double progress = dt / jumpDuration;
//        if (progress >= 1) {
//            isJumping = 0;
//            return;
//        }
//
//        double newY;
//        if (progress < 0.5) {
//            // Ascending part of the jump
//            newY = getPosition().getY() - (jumpHeight * (1 - Math.sin(Math.PI * progress)));
//        } else {
//            // Descending part of the jump
//            newY = getPosition().getY() - (jumpHeight * (1 - Math.sin(Math.PI * (1 - progress))));
//        }
//
//        this.setPosition(new Position(getPosition().getX(), newY));
//    }

//    public void jump(long currentTime) {
//        int jumpHeight = 5; //for now
//        long dt = currentTime - jumpStart;
//        Position startingP = getPosition();
//        int speed = 5;
//        if (isJumping == 0) return;
//        if (isJumping == 1) {
//            double newY = startingP.getY() - jumpHeight;
//            this.setPosition(new Position(startingP.getX(), newY));
//            isJumping = 2;
//            return;
//        }
//        if (isJumping == 2 && dt > 100*speed) {
//            double newY = startingP.getY() - jumpHeight;
//            this.setPosition(new Position(startingP.getX(), newY));
//            isJumping = 3;
//            return;
//        }
//        if (isJumping == 3 && dt > 200*speed) {
//            double newY = startingP.getY() + jumpHeight;
//            this.setPosition(new Position(startingP.getX(), newY));
//            isJumping = 4;
//            return;
//        }
//        if (isJumping == 4 && dt > 300*speed) {
//            double newY = startingP.getY() + jumpHeight;
//            this.setPosition(new Position(startingP.getX(), newY));
//            isJumping = 0;
//            return;
//        }
//    }


    public void move(){
        Position nextPosition = new Position(getPosition().getX() + velocity.getX(), getPosition().getY() + velocity.getY());

        Position horizontalPos = new Position(nextPosition.getX(), getPosition().getY());
        if (temple.checkCollisions(horizontalPos)){
            velocity.setX(0);
        }
        else {
            this.lastPosition = getPosition();
            setPosition(new Position(horizontalPos.getX(), getPosition().getY()));
        }

        Position verticalPos = new Position(getPosition().getX(), nextPosition.getY());
        if (temple.checkCollisions(verticalPos)) {
            velocity.setY(0);
        }
        else{
            this.lastPosition = getPosition();
            setPosition(new Position(getPosition().getX(), verticalPos.getY()));
        }
    }

//    public void moveLeft() {
//        setVelocity(new Position(
//                getVelocity().getX() - getAcceleration(),
//                getVelocity().getY()
//        ));
//    }
//
//    public void moveRight() {
//        setVelocity(new Position(
//                getVelocity().getX() + getAcceleration(),
//                getVelocity().getY()
//        ));
//    }

//    public void jump() {
//        if (isOnGround()) {
//            setVelocity(updateVelocity(new Vector(
//                    getVelocity().x(),
//                    getVelocity().y() - getJumpBoost()
//            )));
//        }
//    }


//    public void updatep() {
//        setVelocity(updateVelocity(getVelocity()));
//        setPosition(updatePosition());
//    }

//    private Position updatePosition() {
//        return new Position(getPosition().getX() + velocity.getX(), getPosition().getY() + velocity.getY());
//    }

//    private Position updateVelocity(Position velocity) {
//        Position newVelocity = new Position(
//                velocity.getX() ,
//                velocity.getY() + temple.getGravity()
//        );
//        return limitVelocity(applyCollisions(newVelocity));
//    }

//    private void handleCollisions(){
//        isOnGround();
//    }
//
//    public void update() {
//        defyingGravity();
//        move();
//        // handlecollisions
////        setPosition(new Position(getPosition().getX() + velocity.getX(), getPosition().getY() + velocity.getY()));
////        isOnGround();
////        if (onGround) {
////            velocity.setY(0);
////        }
//    }

    protected Temple getTemple() {
        return temple;
    }





}
