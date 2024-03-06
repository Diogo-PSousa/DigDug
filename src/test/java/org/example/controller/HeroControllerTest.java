package org.example.controller;

import org.example.controller.game.ArenaController;
import org.example.controller.game.HeroController;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.arena.LoaderArenaBuilder;
import org.example.model.game.elements.Hero;
import org.example.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HeroControllerTest {
    GameState gamestate;
    Arena arena;
    HeroController heroController;
    Hero hero;

    @BeforeEach
    void init() throws IOException {
        gamestate = new GameState(new LoaderArenaBuilder(0).createArena());
        arena = gamestate.getModel();
        heroController = new HeroController(arena);
        hero = arena.getHero();
    }

    @Test
    void moveRight() {
        Position initial_pos = hero.getPosition();
        heroController.moveHeroRight();
        assertEquals(initial_pos.getRight(), hero.getPosition());
    }
    @Test
    void moveDown() {
        Position initial_pos = hero.getPosition();
        heroController.moveHeroDown();
        assertEquals(initial_pos.getDown(), hero.getPosition());
    }
    @Test
    void moveLeft() {
        Position initial_pos = hero.getPosition();
        heroController.moveHeroLeft();
        assertEquals(initial_pos.getLeft(), hero.getPosition());
    }
    @Test
    void moveUp() {
        Position initial_pos = hero.getPosition();
        heroController.moveHeroUp();
        assertEquals(initial_pos.getUp(), hero.getPosition());
    }
    @Test
    void moveHeroToSand() {
        heroController.moveHeroRight();
        //sand must disappear
        assertEquals(false, arena.isSand(hero.getPosition()));
    }
    @Test
    void moveHeroToMonster() {
        int initial_energylevel = hero.getEnergy();
        heroController.moveHeroLeft();
        //energy must drop by 1
        assertEquals(initial_energylevel-1, hero.getEnergy());
    }
    @Test
    void moveHeroToWall() {
        heroController.moveHeroUp();
        Position initial_pos = hero.getPosition();
        heroController.moveHeroRight();
        //Position must stay the same
        assertEquals(initial_pos, hero.getPosition());
    }

    @Test
    void moveHeroToRock(){
        Position final_position = hero.getPosition().getUp();
        heroController.moveHeroUp();
        heroController.moveHeroLeft();
        //Hero position must be (2,1) as he can't move into the rock at (1,1)
        assertEquals(final_position, hero.getPosition());
    }

    @Test
    void moveHeroToEmpty(){
        Position final_position = hero.getPosition().getLeft();
        heroController.moveHeroLeft();
        //monster position must update as they are able to move into empty blocks
        assertEquals(final_position, hero.getPosition());
    }
}
