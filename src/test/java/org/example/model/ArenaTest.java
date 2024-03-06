package org.example.model;

import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.arena.LoaderArenaBuilder;
import org.example.model.game.elements.Hero;
import org.example.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArenaTest {
    GameState gamestate;
    Arena arena;
    Hero hero;

    @BeforeEach
    void init() throws IOException {
        gamestate = new GameState(new LoaderArenaBuilder(0).createArena());
        arena = gamestate.getModel();
    }

    @Test
    void levelEntitiesToArenaElements_Empty() {
        //verify that there are no walls in the middle of the level
        Position empty_position = new Position(2,2);
        assertEquals(true, arena.isEmpty(empty_position));
    }

    @Test
    void levelEntitiesToArenaElements_Sand() {
        //verify there is sand at position (3,3) of the test level
        Position sand_position = new Position(4,2);
        assertEquals(true, arena.isSand(sand_position));
    }
    @Test
    void levelEntitiesToArenaElements_Wall() {
        //verify there is a wall at the edge of the test level
        Position wall_position = new Position(0,0);
        assertEquals(true, arena.isWall(wall_position));
    }
    @Test
    void levelEntitiesToArenaElements_Monster() {
        //verify there is a monster at position of the test level
        Position monster_position = new Position(2,2);
        assertEquals(true, arena.isMonster(monster_position));
    }
    void levelEntitiesToArenaElements_Hero() {
        //verify there is a hero at position of the test level
        Position hero_position = new Position(2,2);
        assertEquals(true, arena.isMonster(hero_position));
    }
}
