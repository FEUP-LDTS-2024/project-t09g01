package com.t09g01.projeto;

import com.t09g01.projeto.gui.LanternaGUI;
import com.t09g01.projeto.states.State;

import java.io.IOException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws IOException {
        this.gui = new LanternaGUI(640, 360);
        //this.state = new GameState(new Temple(20, 12));
    }

    public static void main(String[] args) throws IOException {
        new Game().start();
    }

    public void setState(State state) {this.state = state;}

    private void start() throws IOException {
        int FPS = 30;
        int frameTime = 1000 / FPS;

        while(this.state != null){
            long startTime = System.currentTimeMillis();
            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0){
                    Thread.sleep(sleepTime);
                }
            } catch (InterruptedException e) {
            }

        }
        gui.close();
    }
}
