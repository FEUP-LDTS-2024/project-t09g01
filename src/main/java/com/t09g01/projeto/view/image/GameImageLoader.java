package com.t09g01.projeto.view.image;

import com.t09g01.projeto.view.Viewer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameImageLoader implements ImageLoader {
    final Map<String, Viewer> imageMap;

    public GameImageLoader() {
        imageMap = new HashMap<>();
    }

    @Override
    public Viewer get(String filepath) throws IOException {
        if (!imageMap.containsKey(filepath))
            imageMap.put(filepath, new Viewer(filepath));
        return imageMap.get(filepath);
    }
}
