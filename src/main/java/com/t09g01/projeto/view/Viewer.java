package com.t09g01.projeto.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.t09g01.projeto.gui.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Viewer {

    BufferedImage image;

    public Viewer(String filepath) throws IOException {
        URL resource = getClass().getClassLoader().getResource(filepath);
        assert resource != null;
        image = ImageIO.read(new File(resource.getFile()));
    }

    public static BufferedImage loadImage(String filepath) throws IOException {
        URL resource = Viewer.class.getClassLoader().getResource(filepath);
        assert resource != null;
        return ImageIO.read(new File(resource.getFile()));
    }


    public TextImage convertTextImage (GUI gui, BufferedImage image){
        TextImage textImage = gui.createTextImage(image.getWidth(), image.getHeight());
        TextGraphics graphics = textImage.newTextGraphics();

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                if (rgb >> 24 == 0){
                    continue;
                }
                TextColor.RGB color = getLanternaColor(rgb);
                graphics.setBackgroundColor(color);
                graphics.putString(x, y, " ");
            }
        }
        return textImage;
    }

    public void draw(GUI gui, int a, int b){                           // a e b representam as coordenadas de início onde a imagem deve ser desenhada na tela
        for (int y = 0; y < image.getHeight(); y++) {                  // x e y são as coordenadas dos pixels dentro da imagem
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);                         // valor do RGB do pixel
                TextColor.RGB color = getLanternaColor(rgb);          // mapear para cor no Lanterna
                if (rgb >> 24 == 0){
                    continue;
                }
                gui.drawPixel(a + x,b + y, color);              // desenhar o pixel
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
