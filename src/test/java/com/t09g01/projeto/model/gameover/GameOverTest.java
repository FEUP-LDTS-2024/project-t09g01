package com.t09g01.projeto.model.gameover;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.menu.Entry;
import com.t09g01.projeto.model.menu.Menu;
import com.t09g01.projeto.model.screens.GameOver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverTest {
    @Test
    void testCreateEntries() {
        Menu gameOverMenu = new GameOver();

        List<Entry> entries = gameOverMenu.getEntries();

        assertEquals(2, entries.size(), "GameOver menu should have exactly 2 entries.");

        Entry retryEntry = entries.getFirst();
        assertEquals(new Position(153, 130), retryEntry.getPosition(), "Retry entry position is incorrect.");
        assertEquals(Entry.TYPE.RETRY, retryEntry.getType(), "Retry entry type is incorrect.");

        Entry exitEntry = entries.get(1);
        assertEquals(new Position(153, 138), exitEntry.getPosition(), "Exit entry position is incorrect.");
        assertEquals(Entry.TYPE.EXIT, exitEntry.getType(), "Exit entry type is incorrect.");
    }
}
