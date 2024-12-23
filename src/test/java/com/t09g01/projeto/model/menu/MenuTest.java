package com.t09g01.projeto.model.menu;

import com.t09g01.projeto.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MenuTest {
    private Menu menu;
    private Entry entry1;
    private Entry entry2;
    private Entry entry3;

    @BeforeEach
    void setUp() {
        this.entry1 = new Entry(new Position(0, 0), Entry.TYPE.RETURN_MENU);
        this.entry2 = new Entry(new Position(1, 1), Entry.TYPE.RETURN_MENU);
        this.entry3 = new Entry(new Position(2, 2), Entry.TYPE.RETURN_MENU);

        menu = Mockito.spy(new Menu() {
            @Override
            protected List<Entry> createEntries() {
                return Arrays.asList(entry1, entry2, entry3);
            }
        });
    }

    @Test
    void testInitialization() {
        assertNotNull(menu.getEntries(), "Entries list should not be null.");
        //assertEquals(3, menu.getEntries(), "Menu should have exactly 3 entries.");
    }

    @Test
    void testGetCurrentEntry() {
        assertEquals(entry1, menu.getCurrentEntry(), "Initial current entry should be entry1.");
    }

    @Test
    void testNextEntryCyclesThroughEntries() {
        menu.nextEntry();
        assertEquals(entry2, menu.getCurrentEntry(), "Current entry should be entry2 after one nextEntry call.");

        menu.nextEntry();
        assertEquals(entry3, menu.getCurrentEntry(), "Current entry should be entry3 after two nextEntry calls.");

        menu.nextEntry();
        assertEquals(entry1, menu.getCurrentEntry(), "Current entry should cycle back to entry1 after three nextEntry calls.");
    }

    @Test
    void testPreviousEntryCyclesThroughEntries() {
        menu.previousEntry();
        assertEquals(entry3, menu.getCurrentEntry(), "Current entry should cycle to entry3 when previousEntry is called from entry1.");

        menu.previousEntry();
        assertEquals(entry2, menu.getCurrentEntry(), "Current entry should cycle to entry2 when previousEntry is called again.");

        menu.previousEntry();
        assertEquals(entry1, menu.getCurrentEntry(), "Current entry should cycle back to entry1 when previousEntry is called again.");
    }

}
