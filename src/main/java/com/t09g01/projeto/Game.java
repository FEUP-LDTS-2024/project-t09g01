package com.t09g01.projeto;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.gui.LanternaGUI;
import com.t09g01.projeto.model.game.temple.Temple;
import com.t09g01.projeto.model.game.temple.TempleBuilder;
import com.t09g01.projeto.model.menu.MainMenu;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.states.GameState;
import com.t09g01.projeto.states.MainMenuState;
import com.t09g01.projeto.states.State;
import com.t09g01.projeto.view.GameImageLoader;
import com.t09g01.projeto.view.ImageLoader;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private final ImageLoader imageLoader;
    public int getNumberOfLevels() {
        return 3;
    }

    public Game() throws IOException, FontFormatException, URISyntaxException {
        this.gui = new LanternaGUI(320, 192);
        this.imageLoader = new GameImageLoader();
        this.state = new MainMenuState(new MainMenu(), imageLoader);
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {this.state = state;}

    private void start() throws IOException, URISyntaxException, FontFormatException {
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

    public ImageLoader getImageLoader() {return imageLoader;}

    public GUI getGUI() {
        return gui;
    }
}
