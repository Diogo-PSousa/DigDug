package org.example.viewer.game;

import org.example.viewer.gui.GUI;
import org.example.model.game.elements.PowerUp;

public class PowerUpViewer implements ElementViewer<PowerUp>{
    @Override
    public void draw(PowerUp powerUp, GUI gui) {
        gui.drawPowerUp(powerUp.getPosition());
    }
}
