package org.example.controller.menu;

import org.example.Game;
import org.example.controller.Controller;
import org.example.viewer.gui.GUI;
import org.example.model.menu.HowToPlay;
import org.example.model.menu.Menu;
import org.example.states.MenuState;

import java.io.IOException;

public class HowToPlayController extends Controller<HowToPlay> {
    public HowToPlayController(HowToPlay howToPlay) {
        super(howToPlay);
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
                if (getModel().isSelectedBackToMenu()) game.setState(new MenuState(new Menu()));;
        }
    }
}