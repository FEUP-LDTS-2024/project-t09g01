package com.t09g01.projeto.model.gameover;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.menu.Entry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditsTest {
    @Test
    void testCreateEntries() {
        Credits credits = new Credits();

        List<Entry> entries = credits.getEntries();

        assertEquals(1, entries.size(), "Credits menu should have exactly 1 entry.");

        Entry returnEntry = entries.getFirst();
        assertEquals(new Position(153, 130), returnEntry.getPosition(), "Return entry position is incorrect.");
        assertEquals(Entry.TYPE.RETURN_MENU, returnEntry.getType(), "Return entry type is incorrect.");
    }
}
