package org.example.viewer;

import org.example.viewer.gui.GUI;
import org.example.model.game.elements.Monster;
import org.example.viewer.game.MonsterViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MonsterDrawerTest {

    private Monster monster;
    private MonsterViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp(){
        monster = new Monster(20, 10);
        viewer = new MonsterViewer();
        gui = Mockito.mock(GUI.class);
    }


    @Test
    void drawElement() {
        viewer.draw(monster, gui);
        Mockito.verify(gui, Mockito.times(1)).drawMonster(monster.getPosition());
    }
}
