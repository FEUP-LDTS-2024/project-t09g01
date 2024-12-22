package com.t09g01.projeto.model.menu;

import com.t09g01.projeto.model.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuTest {
    @Test
    void testCreateEntries() {
        MainMenu mainMenu = new MainMenu();

        List<Entry> entries = mainMenu.getEntries();

        assertEquals(2, entries.size(), "MainMenu should have exactly 2 entries.");

        Entry playEntry = entries.getFirst();
        assertEquals(new Position(153, 130), playEntry.getPosition(), "Play entry position is incorrect.");
        assertEquals(Entry.TYPE.PLAY, playEntry.getType(), "Play entry type is incorrect.");

        Entry exitEntry = entries.get(1);
        assertEquals(new Position(153, 138), exitEntry.getPosition(), "Exit entry position is incorrect.");
        assertEquals(Entry.TYPE.EXIT, exitEntry.getType(), "Exit entry type is incorrect.");
    }
}
