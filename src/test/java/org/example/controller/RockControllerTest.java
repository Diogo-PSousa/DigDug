package org.example.controller;

import org.example.controller.game.HeroController;
import org.example.controller.game.RockController;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.arena.LoaderArenaBuilder;
import org.example.model.game.elements.Hero;
import org.example.model.game.elements.Rock;
import org.example.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RockControllerTest {
    GameState gamestate;
    Arena arena;
    Rock rock;
    RockController rockController;
    HeroController heroController;
    Hero hero;

    @BeforeEach
    void init() throws IOException {
        gamestate = new GameState(new LoaderArenaBuilder(0).createArena());
        arena = gamestate.getModel();
        rockController = new RockController(arena);
        heroController = new HeroController(arena);
        hero = arena.getHero();
        rock = arena.getRocks().get(0);
    }

    @Test
    void RockFall_PositionTest() {
        Position final_pos = rock.getPosition().getDown();
        rockController.fallRock(rock);
        assertEquals(final_pos, rock.getPosition());
    }
    @Test
    void RockFall_MonsterEliminatedTest() {
        rockController.fallRock(rock);
        assertEquals(0, arena.getMonsters().size());
    }

    @Test
    void RockFall_TestPlayerColisionTest() {
        rockController.fallRock(rock);
        heroController.moveHeroDown();
        heroController.moveHeroLeft();
        //making rock fall on top of player and checking if energy level decreased
        int final_hero_energy = hero.getEnergy()-1;
        rockController.fallRock(rock);
        assertEquals(final_hero_energy, hero.getEnergy());
    }
}
