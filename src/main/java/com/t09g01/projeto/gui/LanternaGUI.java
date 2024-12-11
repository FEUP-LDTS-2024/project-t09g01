package com.t09g01.projeto.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.t09g01.projeto.model.Position;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen){
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        Terminal terminal = createTerminal(width, height);
        this.screen = createScreen(terminal);
    }

    private Terminal createTerminal(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

        File fontFile = new File(getClass().getResource("/fonts/square.ttf").toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(4f);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(font);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);

        terminalFactory.setForceAWTOverSwing(true);
        Terminal terminal = terminalFactory.createTerminal();

        return terminal;
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

        if (keyStroke == null) {
            return ACTION.NONE;
        }

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
                    return ACTION.WATERGIRL_UP;
                } else if (ch == 's' || ch == 'S') {
                    return ACTION.WATERGIRL_DOWN;
                } else if (ch == 'a' || ch == 'A') {
                    return ACTION.WATERGIRL_LEFT;
                } else if (ch == 'd' || ch == 'D') {
                    return ACTION.WATERGIRL_RIGHT;
                } else {
                    return ACTION.NONE;
                }
            case Enter:
                return ACTION.SELECT;
            case EOF, Escape:
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
    public void drawText(Position position, String text, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString((int)position.getX(), (int)position.getY(), text);
    }

    @Override
    public void drawRectangle(double x, double y, int width, int height, TextColor color) {
        if (width > 0 && height > 0) {
            TextGraphics graphics = screen.newTextGraphics();
            graphics.setBackgroundColor(color);
            graphics.fillRectangle(new TerminalPosition((int)x, (int)y), new TerminalSize(width, height), ' ');
        }

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
