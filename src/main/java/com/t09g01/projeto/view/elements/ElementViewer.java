package com.t09g01.projeto.view.elements;

import com.googlecode.lanterna.graphics.BasicTextImage;
import com.t09g01.projeto.gui.GUI;

public interface ElementViewer <T> {
    void draw(T element, GUI gui, BasicTextImage background);
}
