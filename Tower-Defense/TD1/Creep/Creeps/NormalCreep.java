package Creeps;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import CreepController.Creep;
import GameController.Game;

public class NormalCreep {
	
	public NormalCreep(Creep c, int wave, Game game){
		
        c.health = (int)(20 + wave*20);
        c.maxHealth = c.health;
        
        try {c.creepImage = ImageIO.read(new File(Creep.imagePathNorm));} catch (IOException e) {}
        
        if(game.playerclass.toLowerCase().equals("money")){
        	double equation = wave;
        	c.value = (int) equation;
        	c.value += (int)(.15*equation);
        }
        else
        	c.value = wave;
                      
        c.flying = false; 
		
	}
}
