package org.example.controller.game;

import org.example.Game;
import org.example.viewer.gui.GUI;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.Monster;

import java.io.IOException;

public class MonsterController extends GameController{

    private long lastMovement;

    public MonsterController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 400) {
            for (Monster monster : getModel().getMonsters()){
                moveMonster(monster, monster.getPosition().getRandomNeighbour());
            }
            this.lastMovement = time;
        }
    }

    public void moveMonster(Monster monster, Position position) {
        if (getModel().isEmpty(position) && getModel().isSandEmpty(position)) {
            if (getModel().isRockEmpty(position)) {
                monster.setPosition(position);
                if (getModel().getHero().getPosition().equals(position))
                    getModel().getHero().decreaseEnergy();
            }
        }
    }



}
