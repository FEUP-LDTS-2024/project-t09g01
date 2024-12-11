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
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.t09g01.projeto.model.Position;
import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import static java.awt.event.KeyEvent.*;



public class LanternaGUI implements GUI {
    private final Screen screen;
    private KeyEvent arrowKeyPressed;
    private KeyEvent WADKeyPressed;
    private KeyEvent primaryKeyPressed;


    public LanternaGUI(Screen screen){
        this.screen = screen;
        this.arrowKeyPressed = null;
        this.WADKeyPressed = null;
        this.primaryKeyPressed = null;
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

        ((AWTTerminalFrame)terminal).getComponent(0).addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                switch (event.getKeyCode()) {
                    case VK_LEFT, VK_RIGHT -> arrowKeyPressed = event;
                    case VK_D, VK_A -> WADKeyPressed = event;
                    default -> primaryKeyPressed = event;
                }
            }
            @Override
            public void keyReleased(KeyEvent event) {
                switch (event.getKeyCode()) {
                    case VK_LEFT, VK_RIGHT -> arrowKeyPressed = null;
                    case VK_D, VK_A -> WADKeyPressed = null;
                    default -> primaryKeyPressed = null;
                }
            }
        });

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
        if (primaryKeyPressed != null){
            int primaryKeyCode = primaryKeyPressed.getKeyCode();
            primaryKeyPressed = null;
            return switch (primaryKeyCode){
                case VK_UP -> ACTION.FIREBOY_UP;
                case VK_W -> ACTION.WATERGIRL_UP;
                case VK_DOWN -> ACTION.FIREBOY_DOWN;
                case VK_S -> ACTION.WATERGIRL_DOWN;
                case VK_ESCAPE -> ACTION.QUIT;
                case VK_ENTER -> ACTION.SELECT;
                default -> ACTION.NONE;
            };

        }

        if (arrowKeyPressed != null) {
            return switch (arrowKeyPressed.getKeyCode()) {
                case VK_LEFT -> ACTION.FIREBOY_LEFT;
                case VK_RIGHT -> ACTION.FIREBOY_RIGHT;
                default -> ACTION.NONE;
            };
        };

        if (WADKeyPressed != null) {
            return switch (WADKeyPressed.getKeyCode()) {
                case VK_A -> ACTION.WATERGIRL_LEFT;
                case VK_D -> ACTION.WATERGIRL_RIGHT;
                default -> ACTION.NONE;
            };
        }

        return ACTION.NONE;
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
