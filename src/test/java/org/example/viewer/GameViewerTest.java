
package org.example.viewer;

import org.example.controller.game.HeroController;
import org.example.viewer.gui.GUI;
import org.example.model.game.arena.Arena;
import org.example.model.game.arena.LoaderArenaBuilder;
import org.example.model.game.elements.*;
import org.example.states.GameState;
import org.example.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class GameViewerTest {

    private Monster monster;
    private GameViewer viewer;
    private GUI gui;

    GameState gamestate;
    Arena arena;
    HeroController heroController;
    Hero hero;


    @BeforeEach
    void setUp() throws IOException {
        //instantiating arena
        gamestate = new GameState(new LoaderArenaBuilder(0).createArena());
        arena = gamestate.getModel();
        hero = arena.getHero();

        monster = new Monster(20, 10);
        viewer = new GameViewer(arena);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawHero() throws IOException {
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawHero(hero.getPosition());
    }

    @Test
    void drawWalls() {  //all walls should be drawn
        viewer.drawElements(gui);
        for (Wall wall: arena.getWalls()) {
            Mockito.verify(gui, Mockito.times(1)).drawWall(wall.getPosition());
        }
    }

    @Test
    void drawSand() {   //all the sand should be drawn
        viewer.drawElements(gui);
        for (Sand sand: arena.getSand()) {
            Mockito.verify(gui, Mockito.times(1)).drawSand(sand.getPosition());
        }
    }

    @Test
    void drawFlowers() {   //all the flowers should be drawn
        viewer.drawElements(gui);
        for (Flower flower: arena.getFlowers()) {
            Mockito.verify(gui, Mockito.times(1)).drawFlower(flower.getPosition());
        }
    }

    @Test
    void drawPowerups() {   //all the flowers should be drawn
        //FEATURE STILL NOT IMPLEMENTED
        viewer.drawElements(gui);
        for (PowerUp powerUp: arena.getPowerUps()) {
            Mockito.verify(gui, Mockito.times(1)).drawPowerUp(powerUp.getPosition());
        }
    }

    @Test
    void drawSky() {
        viewer.drawElements(gui);
        for (Sky sky: arena.getSky()) {
            Mockito.verify(gui, Mockito.times(1)).drawSky(sky.getPosition());
        }
    }
}