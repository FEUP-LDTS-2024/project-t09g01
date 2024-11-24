package com.t09g01.projeto.model.game.temple;

import com.t09g01.projeto.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TempleBuilder {

    List<String> lines;

    public Temple createTemple(){
        Temple temple = new Temple(getWidth(), getHeight());
        temple.setFireboy(createFireboy());
        temple.setWatergirl(createWatergirl());
        temple.setBlocks(createBlocks());

        return temple;
    }

    public TempleBuilder() throws IOException{
        URL resource = TempleBuilder.class.getResource("/levels/level1.lvl");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        lines = readLines(br);
    }

    public List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null;) {
            lines.add(line);
        }
        return lines;

    }

    private int getWidth(){
        return lines.getFirst().length();
    }

    private int getHeight(){
        return lines.size();
    }

    private Fireboy createFireboy(){
        for(int y = 0; y < lines.size(); y++){
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'F') {
                    return new Fireboy(x, y);
                }
            }
        }
        return null;
    }

    private Watergirl createWatergirl(){
        for(int y = 0; y < lines.size(); y++){
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == 'W') {
                    return new Watergirl(x, y);
                }
            }
        }
        return null;
    }

    private List<Block> createBlocks(){
        List<Block> blocks = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++){
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++){
                if (line.charAt(x) == '#'){
                    blocks.add(new Block(x,y));
                }
            }
        }
        return blocks;
    }


}
