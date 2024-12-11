package com.t09g01.projeto.view;

import com.googlecode.lanterna.TextColor;
import com.t09g01.projeto.gui.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Viewer {

    BufferedImage image;

    public Viewer(String filepath) throws IOException {
        URL resource = getClass().getClassLoader().getResource(filepath);
        System.out.println(resource);
        assert resource != null;
        image = ImageIO.read(new File(resource.getFile()));
    }



    public void draw(GUI gui, double a, double b){                           // a e b representam as coordenadas de início onde a imagem deve ser desenhada na tela
        for (int y = 0; y < image.getHeight(); y++) {                  // x e y são as coordenadas dos pixels dentro da imagem
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);                         // valor do RGB do pixel
                if (rgb >> 24 == 0){                                   // checar transparência
                    continue;
                }
                TextColor.RGB color = getLanternaColor(rgb);          // mapear para cor no Lanterna
                gui.drawPixel((int)a + x,(int)b + y, color);              // desenhar o pixel
            }
        }
    }

    public TextColor.RGB getLanternaColor(int rgb){
        int red = (rgb >> 16) & 0xFF;
        int green = (rgb >> 8) & 0xFF;
        int blue = rgb & 0xFF;
        return new TextColor.RGB(red, green, blue);
    }


}
