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
        return switch(keyStroke.getKeyType()) {
            case ArrowUp -> ACTION.UP;
            case ArrowDown -> ACTION.DOWN;
            case ArrowLeft -> ACTION.LEFT;
            case ArrowRight -> ACTION.RIGHT;

            case EOF -> ACTION.QUIT;
            default -> ACTION.NONE;
        };
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
