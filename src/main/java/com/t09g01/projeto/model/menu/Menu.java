package com.t09g01.projeto.model.menu;

import java.util.List;
import java.util.Arrays;

public abstract class Menu {
    private final List<Entry> entries;
    private int currentEntry = 0;

    public Menu() {this.entries = createEntries();}

    protected abstract List<Entry> createEntries();

    public List<Entry> getEntries() {
        return entries;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public void nextEntry(){
        currentEntry++;
        if (currentEntry > this.entries.size() - 1){
            currentEntry = 0;
        }
    }

    public void previousEntry(){
        currentEntry--;
        if(currentEntry < 0){
            currentEntry = this.entries.size() - 1;
        }
    }

    public Entry getCurrentEntry() {
        return entries.get(currentEntry);
    }
}
