package org.example.model.game.arena;

import org.example.model.Position;
import org.example.model.game.elements.*;

import java.util.List;

public class Arena {

    private final int width;

    private final int height;

    private Hero hero;

    private List<Monster> monsters;

    private List<Wall> walls;

    private List<Rock> rocks;

    private List<Flower> flowers;


    private List<Sand> sand;

    private List<Sky> sky;

    private Rock rock;

    private List<PowerUp> powerUps;




    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Rock> getRocks() {return this.rocks;}

    public Rock getRock() {return  this.rock;}

    public void setRocks(List<Rock> rocks){this.rocks = rocks;}

    public List<Flower> getFlowers(){return this.flowers;}

    public void setFlowers(List<Flower> flowers){this.flowers = flowers;}

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }


    public List<Sky> getSky(){
        return this.sky;
    }

    public List<Sand> getSand(){
        return this.sand;
    }

    public void setSand(List<Sand> sand){
        this.sand = sand;
    }

    public void setSky(List<Sky> sky){
        this.sky = sky;
    }


    public List<PowerUp> getPowerUps() {
        return this.powerUps;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isSandEmpty(Position position) {
        for(Sand sandi: sand)
            if (sandi.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isWall(Position position) {
        for(Wall wall: walls)
            if (wall.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isSand(Position position) {
        for(Sand sandi: sand)
            if (sandi.getPosition().equals(position))
                return true;
        return false;
    }

    public boolean isRockEmpty(Position position) {
        for(Rock rocki: rocks)
            if (rocki.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean removeSand(Position position) {
        for(Sand sandi: sand){
            if (sandi.getPosition().equals(position)){
                sand.remove(sandi);
                return true;
            }
        }
        return false;
    }

    public boolean rockFalls(Position position) {
        int x = position.getX();
        int y = position.getY()+1;
        Position position2 = new Position(x,y);

        for(Rock rock: rocks){
            //if there are no walls or sand
            if(isEmpty(position2) && isSandEmpty(position2)){
                return true;
            }
        }
        return false;
    }


    public boolean isRockEmptyBelow(Position position) {
        Position p1 = new Position(position.getX() + 1 - 1, position.getY() + 1);
        if (isEmpty(p1)) {
            return true;
        } else {
            return false;
        }
    }
    public void removeMonster(Monster monster){
        monsters.remove(monster);

    }}

