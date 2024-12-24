package com.t09g01.projeto.model.screens;

import com.t09g01.projeto.model.Position;
import com.t09g01.projeto.model.menu.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditsTest {
    private Credits credits;

    @BeforeEach
    void setUp() {
        credits = new Credits();
    }

    @Test
    void testCreateEntries() {
        List<Entry> entries = credits.createEntries();

        assertEquals(1, entries.size());

        Entry entry = entries.get(0);

        assertEquals(Entry.TYPE.RETURN_MENU, entry.getType());

        Position expectedPosition = new Position(132, 130);
        assertEquals(expectedPosition, entry.getPosition());
    }
}
