package com.t09g01.projeto.model.game.temple;

import com.t09g01.projeto.model.game.elements.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TempleBuilder {

    private final List<String> lines;

    public TempleBuilder() throws IOException {
        URL resource = TempleBuilder.class.getResource("/levels/level1.lvl");
        if (resource == null) {
            throw new IOException("Level file not found: /levels/level1.lvl");
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()))) {
            lines = readLines(br);
        }
        validateLevel();
    }

    public Temple createTemple() {
        Temple temple = new Temple(getWidth(), getHeight());
        temple.setFireboy(createFireboy());
        temple.setWatergirl(createWatergirl());
        temple.setBlocks(createBlocks());
        return temple;
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; ) {
            lines.add(line);
        }
        return lines;
    }

    private int getWidth() {
        return lines.get(0).length();
    }

    private int getHeight() {
        return lines.size();
    }

    private void validateLevel() {
        if (lines.isEmpty()) {
            throw new IllegalStateException("Level file is empty!");
        }
        int width = getWidth();
        for (String line : lines) {
            if (line.length() != width) {
                throw new IllegalStateException("Inconsistent line lengths in level file!");
            }
        }
    }

    private Fireboy createFireboy() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'F') {
                    return new Fireboy(x * 8, y * 8);
                }
            }
        }
        throw new IllegalStateException("Fireboy position not found in level file!");
    }

    private Watergirl createWatergirl() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'W') {
                    return new Watergirl(x * 8, y * 8);
                }
            }
        }
        throw new IllegalStateException("Watergirl position not found in level file!");
    }

    private List<Block> createBlocks() {
        List<Block> blocks = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) { // Fixed inner loop increment
                if (line.charAt(x) == '#') {
                    blocks.add(new Block(x*8, y*8));
                }
            }
        }
        return blocks;
    }
}
