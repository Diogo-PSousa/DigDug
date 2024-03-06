package org.example.states;

import org.example.controller.Controller;
import org.example.controller.menu.HowToPlayController;
import org.example.controller.menu.MenuController;
import org.example.model.menu.HowToPlay;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;
import org.example.viewer.menu.HowToPlayViewer;
import org.example.viewer.menu.MenuViewer;

public class HowToPlayState extends State<HowToPlay>{
    public HowToPlayState(HowToPlay model) {
        super(model);
    }

    @Override
    protected Viewer<HowToPlay> getViewer() {
        return new HowToPlayViewer(getModel());
    }

    @Override
    protected Controller<HowToPlay> getController() {
        return new HowToPlayController(getModel());
    }
}
