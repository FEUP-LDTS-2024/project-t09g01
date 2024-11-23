package com.t09g01.projeto.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;
import com.t09g01.projeto.model.Position;
import org.w3c.dom.Text;

import java.io.IOException;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen){
        this.screen = screen;
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        switch(keyStroke.getKeyType()) {
            case ArrowUp:
                return ACTION.FIREBOY_UP;
            case ArrowDown:
                return ACTION.FIREBOY_DOWN;
            case ArrowLeft:
                return ACTION.FIREBOY_LEFT;
            case ArrowRight:
                return ACTION.FIREBOY_RIGHT;
            case Character:
                char ch = keyStroke.getCharacter();
                if (ch == 'w' || ch == 'W') {
                    return ACTION.FIREBOY_UP;
                } else if (ch == 's' || ch == 'S') {
                    return ACTION.FIREBOY_DOWN;
                } else if (ch == 'a' || ch == 'A') {
                    return ACTION.FIREBOY_LEFT;
                } else if (ch == 'd' || ch == 'D') {
                    return ACTION.FIREBOY_RIGHT;
                } else {
                    return ACTION.NONE;
                }

            case EOF:
                return ACTION.QUIT;
            default:
                return ACTION.NONE;
        }
    }

    @Override
    public void drawPixel(int x, int y, TextColor.RGB color){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(color);
        graphics.putString(x, y, " ");
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

}
