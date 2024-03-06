package org.example.viewer.menu;

import org.example.viewer.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.GameOver;
import org.example.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameOver) {
        super(gameOver);
    }
    @Override
    public void drawElements(GUI gui){
        gui.drawText(new Position(5, 4), "GAME OVER", "#F5FF2E");


        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 10 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}