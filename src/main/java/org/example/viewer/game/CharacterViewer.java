package org.example.viewer.game;

import org.example.viewer.gui.GUI;
import org.example.model.game.elements.Hero;

public class CharacterViewer implements ElementViewer<Hero> {
    @Override
    public void draw(Hero hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
