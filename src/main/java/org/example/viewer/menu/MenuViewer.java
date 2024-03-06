package org.example.viewer.menu;

import org.example.viewer.gui.GUI;
import org.example.model.Position;
import org.example.model.menu.Menu;
import org.example.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }
    @Override
    public void drawElements(GUI gui){
        gui.drawText(new Position(5, 4), "DigDug", "#F5FF2E");
        gui.drawText(new Position(5, 5), "Menu", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FF0000" : "#FFFFFF");
    }
}
