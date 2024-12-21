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
    private final int level;

    public TempleBuilder(int level) throws IOException {
        this.level = level;
        URL resource = TempleBuilder.class.getResource("/levels/level" + level + ".lvl");
        if (resource == null) {
            throw new IOException("Level file not found: /levels/level1.lvl");
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.openStream()))) {
            lines = readLines(br);
        }
        validateLevel();
    }

    public Temple createTemple() {
        Temple temple = new Temple(getWidth(), getHeight(), level);
        temple.setBlueDiamonds(createBlueDiamonds());
        temple.setRedDiamonds(createRedDiamonds());
        temple.setFireboy(createFireboy(temple));
        temple.setWatergirl(createWatergirl(temple));
        temple.setBlocks(createBlocks());
        temple.setLava(createLava());
        temple.setWater(createWater());
        temple.setGoo(createGoo());
        temple.setRedDoor(createRedDoor());
        temple.setBlueDoor(createBlueDoor());

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

    private Fireboy createFireboy(Temple temple) {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'F') {
                    return new Fireboy(x * 8, y * 8, temple);
                }
            }
        }
        throw new IllegalStateException("Fireboy position not found in level file!");
    }

    private Watergirl createWatergirl(Temple temple) {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'W') {
                    return new Watergirl(x * 8, y * 8, temple);
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

    private List<Lava> createLava() {
        List<Lava> lava = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'L') {
                    lava.add(new Lava(x*8, y*8));
                }
            }
        }
        return lava;
    }

    private List<Water> createWater() {
        List<Water> water = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'A') {
                    water.add(new Water(x*8, y*8));
                }
            }
        }
        return water;
    }

    private List<Goo> createGoo() {
        List<Goo> goo = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'G') {
                    goo.add(new Goo(x*8, y*8));
                }
            }
        }
        return goo;
    }

    private List<BlueDiamond> createBlueDiamonds() {
        List<BlueDiamond> blueDiamonds = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'B') {
                    blueDiamonds.add(new BlueDiamond(x*8, y*8));
                }
            }
        }
        return blueDiamonds;
    }

    private List<RedDiamond> createRedDiamonds() {
        List<RedDiamond> redDiamonds = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'R') {
                    redDiamonds.add(new RedDiamond(x*8, y*8));
                }
            }
        }
        return redDiamonds;
    }

    private BlueDoor createBlueDoor() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'D') {
                    return new BlueDoor(x * 8, y * 8);
                }
            }
        }
        throw new IllegalStateException("BlueDoor position not found in level file!");
    }


    private RedDoor createRedDoor() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'P') {
                    return new RedDoor(x * 8, y * 8);
                }
            }
        }
        throw new IllegalStateException("RedDoor position not found in level file!");
    }
}
