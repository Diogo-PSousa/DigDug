package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.viewer.gui.GUI;
import org.example.model.menu.GameOver;
import org.example.model.menu.Menu;
import org.example.states.MenuState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedNewGame()) game.setState(new MenuState(new Menu()));;
        }
    }
}