package com.t09g01.projeto.model.gameover;

import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final List<String> entries;
    private int currentEntry = 0;

    public GameOver() {this.entries = Arrays.asList("Play Again", "Exit");}

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

    public String getEntry(int x) {return entries.get(x);}
    public boolean isSelected(int x) {return currentEntry == x;}
    public boolean isSelectedPlayAgain() {return currentEntry == 0;}
    public boolean isSelectedExit() {return currentEntry == 1;}
    public int getEntriesNumber() {return this.entries.size();}
}
