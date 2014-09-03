package Creeps;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import CreepController.Creep;
import GameController.Game;

public class BossCreep {
	
	public BossCreep(Creep c, int wave, Game game){
		
        c.health = (int)(100 + wave*80);
        c.maxHealth = c.health;
        
        try {c.creepImage = ImageIO.read(new File(Creep.imagePathBoss));} catch (IOException e) {}
        
        if(game.playerclass.toLowerCase().equals("money")){
        	double equation = wave + wave/2;
        	c.value = (int)equation;
        	c.value += (int)(.15*equation);
        }
        else
        	c.value = wave + wave/2;
                      
        c.flying = false; 
		
	}
}
