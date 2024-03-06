package org.example.controller;

import org.example.controller.game.HeroController;
import org.example.controller.game.MonsterController;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.arena.LoaderArenaBuilder;
import org.example.model.game.elements.Hero;
import org.example.model.game.elements.Monster;
import org.example.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonsterControllerTest {
    GameState gamestate;
    Arena arena;
    MonsterController monsterController;
    Monster monster;

    @BeforeEach
    void init() throws IOException {
        gamestate = new GameState(new LoaderArenaBuilder(0).createArena());
        arena = gamestate.getModel();
        monsterController = new MonsterController(arena);

        //get only monster
        monster = arena.getMonsters().get(0);
    }

    @Test
    void moveToSand() {
        Position initial_position = monster.getPosition();
        monsterController.moveMonster(monster, monster.getPosition().getDown());
        //monster position must remain the same as they can't move into sand
        assertEquals(initial_position, monster.getPosition());
    }

    @Test
    void moveToEmpty() {
        Position final_position = monster.getPosition().getLeft();
        monsterController.moveMonster(monster, monster.getPosition().getLeft());
        //monster position must update as they are able to move into empty blocks
        assertEquals(final_position, monster.getPosition());
    }

    @Test
    void moveToWall() {
        Position initial_position = monster.getPosition();
        monsterController.moveMonster(monster, monster.getPosition().getLeft().getLeft());
        //monster position must remain the same as they can't move into walls
        assertEquals(initial_position, monster.getPosition());
    }

    @Test
    void moveToPlayer() {
        Position final_position = monster.getPosition().getRight();
        monsterController.moveMonster(monster, monster.getPosition().getRight());
        //monster position must update as they are able to move into players
        assertEquals(final_position, monster.getPosition());
    }

    @Test
    void moveToRock(){
        Position final_position = monster.getPosition();
        monsterController.moveMonster(monster, monster.getPosition().getUp());
        //monster position must remain the same as they can't move into rocks
        assertEquals(final_position, monster.getPosition());
    }


}
