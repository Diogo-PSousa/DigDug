package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.GameOverController;
import org.example.controller.menu.HowToPlayController;
import org.example.model.menu.GameOver;
import org.example.model.menu.HowToPlay;
import org.example.viewer.Viewer;
import org.example.viewer.menu.GameOverViewer;
import org.example.viewer.menu.HowToPlayViewer;

public class GameOverState extends State<GameOver>{
    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}