package org.example.viewer;

import org.junit.jupiter.api.Test;
import org.example.viewer.gui.GUI;
import org.example.model.game.elements.Hero;
import org.example.viewer.game.CharacterViewer;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class HeroDrawerTester {
    private Hero hero;

    private CharacterViewer viewer;

    private GUI gui;

    @BeforeEach
    void setUp(){
        hero = new Hero(20, 10);
        viewer = new CharacterViewer();
        gui = Mockito.mock(GUI.class);
    }


    @Test
    void drawElement() {
        viewer.draw(hero, gui);
        Mockito.verify(gui, Mockito.times(1)).drawHero(hero.getPosition());
    }
}
