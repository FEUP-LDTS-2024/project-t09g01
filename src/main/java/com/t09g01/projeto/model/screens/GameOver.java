package com.t09g01.projeto.model.screens;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.menu.Entry;
import com.t09g01.projeto.model.menu.Menu;

import java.util.Arrays;
import java.util.List;

public class GameOver extends Menu {
    @Override
    protected List<Entry> createEntries() {
        Position playPosition = new Position(153, 130);
        Position quitPosition = new Position(153, 138);

        Entry play = new Entry(playPosition, Entry.TYPE.RETRY);
        Entry exit = new Entry(quitPosition, Entry.TYPE.EXIT);

        return Arrays.asList(play, exit);
    }
}
