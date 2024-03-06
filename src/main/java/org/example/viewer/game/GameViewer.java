package org.example.viewer.game;

import org.example.viewer.gui.GUI;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.Element;
import org.example.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {


        drawElements(gui, getModel().getSand(), new SandViewer());
        drawElements(gui, getModel().getSky(), new SkyViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getFlowers(), new FlowerViewer());
        //drawElements(gui, getModel().getPowerUps(), new PowerUpViewer());
        drawElements(gui, getModel().getRocks(), new RockViewer());
        drawElement(gui, getModel().getHero(), new CharacterViewer());

        gui.drawText(new Position(0, 0), "Energy " + getModel().getHero().getEnergy(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
