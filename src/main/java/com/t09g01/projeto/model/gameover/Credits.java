package com.t09g01.projeto.model.gameover;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.menu.Entry;
import com.t09g01.projeto.model.menu.Menu;

import java.util.Arrays;
import java.util.List;

public class Credits extends Menu {
    @Override
    protected List<Entry> createEntries() {
        Position returnPosition = new Position(153, 130);

        Entry returning = new Entry(returnPosition, Entry.TYPE.RETURN_MENU);

        return Arrays.asList(returning);
    }
}
