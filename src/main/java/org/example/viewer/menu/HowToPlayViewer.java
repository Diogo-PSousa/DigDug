package org.example.viewer.menu;

import org.example.viewer.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.HowToPlay;
import org.example.viewer.Viewer;

public class HowToPlayViewer extends Viewer<HowToPlay> {
    public HowToPlayViewer(HowToPlay howToPlay) {
        super(howToPlay);
    }
    @Override
    public void drawElements(GUI gui){
        gui.drawText(new Position(5, 4), "How To Play", "#F5FF2E");
        gui.drawText(new Position(5, 6), "Movement - Arrows", "#FFFFFF");
        gui.drawText(new Position(5, 7), "Shoot - Space", "#FFFFFF");
        gui.drawText(new Position(5, 8), "Leave - Esc", "#FFFFFF");



        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 10 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}