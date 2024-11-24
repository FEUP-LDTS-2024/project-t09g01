package com.t09g01.projeto;

import com.t09g01.projeto.gui.LanternaGUI;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.model.game.temple.TempleBuilder;
import com.t09g01.projeto.states.GameState;
import com.t09g01.projeto.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws IOException, FontFormatException, URISyntaxException {
        this.gui = new LanternaGUI(20, 12);
        this.state = new GameState(new TempleBuilder().createTemple());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
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
