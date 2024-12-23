package com.t09g01.projeto.gui;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.BasicTextImage;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.t09g01.projeto.model.Position;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import static java.awt.event.KeyEvent.*;



public class LanternaGUI implements GUI {
    private final Screen screen;
    private final Set<ACTION> currentActions = new HashSet<>();


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

        ((AWTTerminalFrame)terminal).getComponent(0).addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                ACTION action = getActionFromKeyCode(event.getKeyCode());
                if (action != ACTION.NONE) {
                    currentActions.add(action);
                }
            }
            @Override
            public void keyReleased(KeyEvent event) {
                ACTION action = getActionFromKeyCode(event.getKeyCode());
                if (action != ACTION.NONE) {
                    currentActions.remove(action);
                }
<<<<<<< HEAD
                System.out.println("key released:");
                System.out.println();
                System.out.println(action);
=======
>>>>>>> develop
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
    public Screen getScreen() {return screen;}

    public ACTION getActionFromKeyCode(int keyCode) {
        return switch (keyCode) {
            case VK_UP -> ACTION.FIREBOY_UP;
            case VK_W -> ACTION.WATERGIRL_UP;
            case VK_DOWN -> ACTION.FIREBOY_DOWN;
            case VK_S -> ACTION.WATERGIRL_DOWN;
            case VK_LEFT -> ACTION.FIREBOY_LEFT;
            case VK_A -> ACTION.WATERGIRL_LEFT;
            case VK_RIGHT -> ACTION.FIREBOY_RIGHT;
            case VK_D -> ACTION.WATERGIRL_RIGHT;
            case VK_ESCAPE -> ACTION.QUIT;
            case VK_ENTER -> ACTION.SELECT;
            default -> ACTION.NONE;
        };
    }

    @Override
    public Set<ACTION> getCurrentActions() {
        return new HashSet<>(currentActions);
    }

    @Override
    public void drawPixel(int x, int y, TextColor.RGB color){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(color);
        graphics.putString(x, y, " ");
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
    public void drawStatic(Position position, TextImage image){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.drawImage(new TerminalPosition((int)position.getX(), (int) position.getY()), image);
    }

    @Override
    public void drawMoving(Position position, BufferedImage image){
        TextGraphics graphics = screen.newTextGraphics();

        for (int x = 0; x < image.getWidth(); x++){
            for (int y = 0; y < image.getHeight(); y++){
                int a = image.getRGB(x,y);
                int alpha = (a >> 24) & 0xff;
                int red = (a >> 16) & 255;
                int green = (a >> 8) & 255;
                int blue = a & 255;

                if (alpha != 0){
                    TextCharacter c = new TextCharacter(' ', new TextColor.RGB(red, green, blue), new TextColor.RGB(red, green, blue));
                    graphics.setCharacter((int)position.getX() + x, (int)position.getY() + y, c);
                }
            }
        }
    }

    @Override
    public void drawTextImage(Position position, BufferedImage image, TextImage background){
        for (int x = 0; x < image.getWidth(); x++){
            for (int y = 0; y < image.getHeight(); y++){
                int a = image.getRGB(x,y);
                int alpha = (a >> 24) & 0xff;
                int red = (a >> 16) & 255;
                int green = (a >> 8) & 255;
                int blue = a & 255;

                if (alpha != 0){
                    TextCharacter c = new TextCharacter(' ', new TextColor.RGB(red, green, blue), new TextColor.RGB(red, green, blue));
                    background.setCharacterAt(x, y, c);
                }
            }
        }
    }

    @Override
    public TextImage createTextImage(int width, int height) {
        TerminalSize size = new TerminalSize(width, height);
        return new BasicTextImage(size);
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
<<<<<<< HEAD
=======

>>>>>>> develop
}
