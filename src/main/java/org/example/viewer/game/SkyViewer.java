package org.example.viewer.game;

import org.example.viewer.gui.GUI;
import org.example.model.game.elements.Sky;

public class  SkyViewer implements ElementViewer<Sky> {
    @Override
    public void draw(Sky sky, GUI gui) {
        gui.drawSky(sky.getPosition());
    }
}
