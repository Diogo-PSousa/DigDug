package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.viewer.gui.GUI;
import org.example.model.game.arena.LoaderArenaBuilder;
import org.example.model.menu.HowToPlay;
import org.example.model.menu.Menu;
import org.example.states.GameState;
import org.example.states.HowToPlayState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
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
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                if (getModel().isSelectedHowToPlay()) game.setState(new HowToPlayState(new HowToPlay()));
        }
    }
}
