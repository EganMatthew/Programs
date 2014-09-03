package UpdateComponents;

import java.util.ArrayList;

import Bullet.Bullet;
import CreepController.Creep;
import EventListeners.PlaySound1;
import GameController.Coordinates;
import GameController.Game;
import GlobalComponents.AddRemoveThingstToPaint;
import TowerController.Tower;

public class UpdateTowerFiringLogical {
	
	public UpdateTowerFiringLogical(Game td, long towerdelay, int towerFireDelay){
		//for each tower check if the creeps are in range 
        //if they are have the tower fire
		
		while(td.iteratingThuTowers);
		
		td.iteratingThuTowers = true;
		
         if(System.currentTimeMillis() - towerdelay > towerFireDelay){ 
            for(Tower tower : td.towers){ 
                td.creepToAimAt = getCreepToTarget(tower.mode, tower, td);
                
                if(td.creepToAimAt != null){
                	
                	if(tower.isCreepInRange(td.creepToAimAt.location)){
                        tower.findAngle(td.creepToAimAt.location); 
                        tower.rotateTower(tower.radians);
                	}
                	
                	Bullet temp = null;
                	if(tower.type.equals("normalTower")){
                		temp = tower.fire(td.creepToAimAt);
                		/*
                		if(tower == td.graphics.towerToPrintStats){
                			//new PlaySound1(td.soundVolume);
                		}
                		*/
                		
                	}
                	else if(tower.type.equals("splashTower")){
                		temp = tower.fire(td.creepToAimAt, getSplashTargets(tower, td));
                	}
                                	
                	td.bullets.add(temp);
                	while(td.graphics.printingBullets);
                	new AddRemoveThingstToPaint(true, false, false, temp, td.graphics);
                }
            } 
            td.towerdelay = System.currentTimeMillis();
            td.iteratingThuTowers = false;
        }
         
         td.iteratingThuTowers = false;
	}
	
	private ArrayList<Creep> getSplashTargets(Tower tower, Game td){
    	
    	ArrayList<Creep> temp = new ArrayList<Creep>();

    	Coordinates tPixleLoc = Coordinates.convert(tower.location.getX(), tower.location.getY());
    	
    	for(Creep creep : td.armyOfCreeps){
            if(tower.isCreepInRange(creep.location)){ 
            	creep.findDistance(tPixleLoc);
            	temp.add(creep);
            } 
        }
    	
    	return temp;
    }
	
    public Creep getCreepToTarget(String mode, Tower tower, Game td){

    	double closest = 100000;
    	double farthest = 0;
    	double highest = 0;
    	double lowest = 100000;
    	
    	Creep close = null;
    	Creep far = null;
    	Creep low = null;
    	Creep high = null;
    	
    	ArrayList<Creep> temp = new ArrayList<Creep>();

    	Coordinates tPixleLoc = Coordinates.convert(tower.location.getX(), tower.location.getY());

    	for(Creep creep : td.armyOfCreeps){
            if(tower.isCreepInRange(creep.location)){ 
            	creep.findDistance(tPixleLoc);
            	temp.add(creep);
            } 
        }
    	
    	//find the closest & farthest creep
    	for(Creep creep : temp){
    		
    		if(creep.distance < closest){
    			closest = creep.distance;
    			close = creep;
    		}
    		if(creep.distance > farthest){
    			farthest = creep.distance;
    			far = creep;
    		}
    		if(creep.health < lowest){
    			lowest = creep.health;
    			low = creep;
    		}
    		if(creep.health > highest){
    			highest = creep.health;
    			high = creep;
    		}
    	}
    	
    	temp = null;
    	
    	if(mode.equals("nearest"))
    		return close;
    	if(mode.equals("farthest"))
    		return far;
    	if(mode.equals("lowest"))
    		return low;
    	if(mode.equals("highest"))
    		return high;
    	
    	return null;
    }

}
