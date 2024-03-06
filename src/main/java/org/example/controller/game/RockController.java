package org.example.controller.game;

import org.example.Game;
import org.example.viewer.gui.GUI;
import org.example.model.Position;
import org.example.model.game.arena.Arena;
import org.example.model.game.elements.Monster;
import org.example.model.game.elements.Rock;

import java.io.IOException;
import java.util.List;

public class RockController extends GameController{

    private long lastActivation;

    public RockController(Arena arena) {
        super(arena);
    }

    //public void fallRock(){
      //  if(getModel().isEmptyBelow(getModel().getRock().getPosition())){
        //    moveRock(getModel().getRocks().);
        //}
    //}

    private void moveRock(Position position){
        List<Rock> rochas = getModel().getRocks();
        List<Rock> rochasnova;
        for(int f = 0; f<rochas.size(); f++){
            //if(getModel().isRockEmptyBelow(rochas[f])){

            }
        }
        //if(getModel().isEmpty(position)){
            //getModel().setRocks(position);
        //}
    //}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        for (Rock rock: getModel().getRocks()){
            if (getModel().rockFalls(rock.getPosition())){
                if(time - lastActivation > 1000){
                    if (lastActivation == 0){
                        this.lastActivation = time;
                    }
                    else {
                        fallRock(rock);
                    }
                }
            }

        }
    }
    public void fallRock(Rock rock){
        rock.setPosition(rock.getPosition().getDown());
        //if rock colides with player decrease energy
        if (rock.getPosition().equals(getModel().getHero().getPosition())){
            getModel().getHero().decreaseEnergy();
        }
        //if rock colides with monster kill him
        Monster monster_killed = null;
        for (Monster monster: getModel().getMonsters()){
            if (monster.getPosition().equals(rock.getPosition())){
                monster_killed = monster;
            }
        }
        if (monster_killed != null) getModel().removeMonster(monster_killed);
        
        if (!getModel().isSandEmpty(rock.getPosition().getDown()) || !getModel().isEmpty(rock.getPosition().getDown())){
            lastActivation = 0;
        }
    }
}
