package org.example.viewer.game;

import org.example.viewer.gui.GUI;
import org.example.model.game.elements.Flower;

public class FlowerViewer implements ElementViewer<Flower>{
    @Override
    public void draw(Flower flower, GUI gui){
        gui.drawFlower(flower.getPosition());
    }
}
