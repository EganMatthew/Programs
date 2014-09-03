package UpdateCreeps;

import java.util.ArrayList;

import CreepController.Creep;
import GameController.Coordinates;
import GameController.Game;
import GameIO.WriteScoresData;
import GlobalComponents.AddRemoveThingstToPaint;

public class UpdateFlyingCreeps {
	
	public UpdateFlyingCreeps(Game td, long creepdelay){
		//update all the creeps with their new position 

        if(System.nanoTime() - creepdelay > Creep.speedOfCreeps("flyingcreep")){
        	ArrayList<Creep> toRemove = new ArrayList<Creep>();
            for(Creep creep : td.flyingCreep){ 
                if(!updateCreep(creep)){
                	toRemove.add(creep);
                }
            }
            for(Creep creep : toRemove){ 
            	//numberOfLives--;
            	if(td.numberOfLives < 1){
            		new WriteScoresData(td);
            		td.reset();
            		continue;
            	}
                td.armyOfCreeps.remove(creep);
                td.flyingCreep.remove(creep);
                while(td.graphics.printingCreeps);
                new AddRemoveThingstToPaint(false, true, false, creep, td.graphics);
                creep = null;
            }
            toRemove = null;
            td.flyingcreepdelay = System.nanoTime(); 
        }
	}
	
	 //this whole method probably needs to be reworked to incorporate diagnols. 
    //in general its changing the creeps location toward some point given in the list. 
    private boolean updateCreep(Creep creep){ 

        if(creep.path.isEmpty()){
        	creep.td.numberOfLives--;
            return false; 
        }
                
        //Coordinates gameLoc = Coordinates.revert(location.getX(), location.getY());
        Coordinates pathLoc = Coordinates.convert(creep.path.peek().getX(), creep.path.peek().getY());  
        
        if(pathLoc.getX() == creep.location.getX() && pathLoc.getY() == creep.location.getY()){
        	creep.path.remove();
        	return true;
        }
         
      
        creep.radians = Math.atan2(pathLoc.getY()-creep.location.getY(), pathLoc.getX()-creep.location.getX());
        
        creep.xAccumulator += Math.cos(creep.radians);
        creep.yAccumulator += Math.sin(creep.radians);
        
        int xMove = 0;
        int yMove = 0;
        
        if(creep.xAccumulator > 1){
        	creep.xAccumulator -= 1;
        	xMove = 1;
        }
        if(creep.xAccumulator < -1){
        	creep.xAccumulator += 1;
        	xMove = -1;
        }
        if(creep.yAccumulator > 1){
        	creep.yAccumulator -=1;
        	yMove = 1;
        }
        if(creep.yAccumulator < -1){
        	creep.yAccumulator += 1;
        	yMove = -1;
        }
        
        creep.location = new Coordinates(creep.location.getX()+xMove, creep.location.getY()+yMove);
        
        return true;
        
    } 
}
