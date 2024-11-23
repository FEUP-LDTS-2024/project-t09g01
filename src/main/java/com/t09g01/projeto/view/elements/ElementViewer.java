package com.t09g01.projeto.view.elements;

import com.t09g01.projeto.gui.GUI;

public interface ElementViewer <T> {
    void draw(T element, GUI gui);
}
