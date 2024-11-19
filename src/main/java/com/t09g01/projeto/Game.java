package com.t09g01.projeto;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;

    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(20, 12);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);         // we don't need a cursor
        screen.startScreen();                   // screens must be started
        screen.doResizeIfNecessary();           // resize screen if necessary

        // arena = new Arena(40,20);

    }

    private void draw() throws IOException {
        screen.clear();
        screen.setCharacter(10, 10, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();  // Draw the character at the current position
            KeyStroke key = screen.readInput();  // Wait for a key press
            if(key.getKeyType() == KeyType.EOF ) {
                screen.close();
                break;
            }
            processKey(key);  // Process the key to update position
        }
    }

    private void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
    }
}
