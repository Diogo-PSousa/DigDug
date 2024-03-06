package org.example.model.game.elements;

public class Hero extends Element{
    private int lives;
    private int energy;


    public Hero(int x, int y) {
        super(x, y);
        this.energy = 10;
    }

    public int getLives() {
        return lives;
    }

    public int getEnergy() {
        return energy;
    }

    public void decreaseEnergy() {
        this.energy--;
    }
}
