package org.example.model.game.arena;

import org.example.model.Position;
import org.example.model.game.elements.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class LoaderArenaBuilder extends ArenaBuilder {
    private final int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;

        InputStream resource = LoaderArenaBuilder.class.getResourceAsStream("/levels/level" + level + ".lvl");
        try(InputStreamReader fr = new InputStreamReader(resource);
            BufferedReader br = new BufferedReader(new InputStreamReader(resource))){
                lines = readLines(br);
            }


    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new Wall(x, y));
        }
        return walls;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'M') monsters.add(new Monster(x, y));
        }
        return monsters;
    }

    @Override
    protected Hero createHero() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new Hero(x, y);
        }
        return null;
    }

    @Override
    protected List<Rock> createRocks(){
        List<Rock> rocks = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'R') rocks.add(new Rock(x, y));
        }
        return rocks;
    }

    @Override
    protected List<Flower> createFlowers(){
        List<Flower> flowers = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'F') flowers.add(new Flower(x, y));
        }
        return flowers;
    }

    @Override
    protected List<Sand> createSands() {
        List<Sand> sand = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '&') sand.add(new Sand(x, y));
        }
        return sand;
    }

    @Override
    protected List<Sand>  deleteSand(Position position) {
        List<Sand> sand = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++) {
                Sand sand2 = new Sand(x,y);
                if (line.charAt(x) == '&') sand.add(sand2);
                if (position.getX()==x && position.getY()==y) sand.remove(sand2);
            }
        }
        return sand;
    }

    @Override
    protected List<Sky> createSky() {
        List<Sky> sky = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'S') sky.add(new Sky(x, y));
        }
        return sky;
    }




}
