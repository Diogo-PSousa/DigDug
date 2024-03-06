package org.example.controller.game;

import org.example.Game;
import org.example.viewer.gui.GUI;
import org.example.model.game.arena.Arena;
import org.example.model.menu.GameOver;
import org.example.states.GameOverState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;
    private final MonsterController monsterController;
    private final RockController rockController;

    public ArenaController(Arena arena) {
        super(arena);
        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
        this.rockController = new RockController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() == 0)
            game.setState(new GameOverState(new GameOver()));
        else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
            rockController.step(game, action, time);
        }
    }


}
