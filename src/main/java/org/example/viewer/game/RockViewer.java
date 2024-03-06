package org.example.viewer.game;

import org.example.viewer.gui.GUI;
import org.example.model.game.elements.Rock;

public class RockViewer implements ElementViewer<Rock>{
    @Override
    public void draw(Rock rock, GUI gui){
        gui.drawRock(rock.getPosition());
    }
}
