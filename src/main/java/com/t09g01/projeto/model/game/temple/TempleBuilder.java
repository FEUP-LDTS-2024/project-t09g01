package com.t09g01.projeto.model.game.temple;

import com.t09g01.projeto.model.game.elements.blocks.*;
import com.t09g01.projeto.model.game.elements.diamonds.BlueDiamond;
import com.t09g01.projeto.model.game.elements.diamonds.RedDiamond;
import com.t09g01.projeto.model.game.elements.doors.BlueDoor;
import com.t09g01.projeto.model.game.elements.doors.RedDoor;
import com.t09g01.projeto.model.game.elements.players.Fireboy;
import com.t09g01.projeto.model.game.elements.players.Watergirl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TempleBuilder {

    List<String> lines;
    private final int level;
    List<Block> blocks = new ArrayList<>();

    public TempleBuilder(int level) throws IOException {
        this.level = level;
        URL resource = TempleBuilder.class.getResource("/levels/level" + level + ".lvl");
        if (resource == null) {
            throw new IOException("Level file not found: /levels/level" + level + ".lvl");
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
        temple.setBricks(createBricks());
        temple.setLava(createLava());
        temple.setWater(createWater());
        temple.setGoo(createGoo());
        temple.setRedDoor(createRedDoor());
        temple.setBlueDoor(createBlueDoor());
        temple.setBlocks(blocks);

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
        return lines.getFirst().length();
    }

    private int getHeight() {
        return lines.size();
    }

    void validateLevel() {
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

    Fireboy createFireboy(Temple temple) {
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

    Watergirl createWatergirl(Temple temple) {
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

    private List<Brick> createBricks() {
        List<Brick> bricks = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) { // Fixed inner loop increment
                if (line.charAt(x) == '#') {
                    Brick brick = new Brick(x*8, y*8);
                    bricks.add(brick);
                    blocks.add(brick);
                }
            }
        }
        return bricks;
    }

    private List<Lava> createLava() {
        List<Lava> lavas = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'L') {
                    Lava lava = new Lava(x*8, y*8);
                    lavas.add(lava);
                    blocks.add(lava);
                }
            }
        }
        return lavas;
    }

    private List<Water> createWater() {
        List<Water> waters = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'A') {
                    Water water = new Water(x*8, y*8);
                    waters.add(water);
                    blocks.add(water);
                }
            }
        }
        return waters;
    }

    private List<Goo> createGoo() {
        List<Goo> goos = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'G') {
                    Goo goo = new Goo(x*8, y*8);
                    goos.add(goo);
                    blocks.add(goo);
                }
            }
        }
        return goos;
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

    BlueDoor createBlueDoor() {
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


    RedDoor createRedDoor() {
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
