package com.t09g01.projeto.model.game.temple;

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
}
