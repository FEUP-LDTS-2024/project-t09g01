package com.t09g01.projeto.view.screens;

import com.t09g01.projeto.gui.GUI;
import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.gameover.GameOver;
import com.t09g01.projeto.view.Viewer;
import com.t09g01.projeto.view.game.ScreenViewer;

import java.io.IOException;

public class GameOverViewer extends ScreenViewer<GameOver> {

    public GameOverViewer(GameOver gameOver) {super(gameOver);}

    @Override
    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.drawText(new Position(4, 4), "Game Over", "#FFFFFF");

        for (int i = 0; i < getModel().getEntriesNumber(); i++) {
            gui.drawText(new Position(4, 6 + i), getModel().getEntry(i), getModel().isSelected(i) ? "#EDD711" : "#FFFFFF");
        }
        gui.refresh();

    }
}
