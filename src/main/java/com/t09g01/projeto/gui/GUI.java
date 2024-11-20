package com.t09g01.projeto.gui;

import com.t09g01.projeto.model.Position;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException

    void drawFireboy(Position position);

    void drawWatergirl(Position position);

    void drawBlock(Position position);

    void clear();

    void refresh();

    void close();
}
