package org.example.model.game.arena;

import org.example.model.Position;
import org.example.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {

    public Arena createArena(){
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setHero(createHero());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setSand(createSands());
        arena.setRocks(createRocks());
        arena.setSky(createSky());
        arena.setFlowers(createFlowers());
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Hero createHero();

    protected abstract List<Rock> createRocks();

    protected abstract List<Flower> createFlowers();

    protected  abstract List<Sand> createSands();

    protected abstract List<Sky> createSky();

    protected abstract List<Sand>  deleteSand(Position position);
}
