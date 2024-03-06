package org.example.viewer.game;

import org.example.viewer.gui.GUI;
import org.example.model.game.elements.Sand;

public class SandViewer implements ElementViewer<Sand> {
    @Override
    public void draw(Sand sand, GUI gui) {
        gui.drawSand(sand.getPosition());
    }
}
