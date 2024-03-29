package org.example.viewer.gui;

import org.example.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawHero(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawFlower(Position position);

    void drawRock(Position position);

    void drawPowerUp(Position position);

    void drawSky(Position position);

    void drawSand(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, SHOOT, QUIT, SELECT, NONE}
}
