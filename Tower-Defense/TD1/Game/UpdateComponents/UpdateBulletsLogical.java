package UpdateComponents;

import java.util.ArrayList;

import UpdateCreeps.RemoveCreeps;
import Bullet.Bullet;
import CreepController.Creep;
import GameController.Game;
import GlobalComponents.AddRemoveThingstToPaint;

public class UpdateBulletsLogical {
	
	public UpdateBulletsLogical(Game td, long bulletFireDelay, int bulletSpeedDelay){
		//This handles updating the bullets
        if(System.nanoTime()  - bulletFireDelay > bulletSpeedDelay){
        	ArrayList<Bullet> bulletsToRemove = new ArrayList<Bullet>();
        	ArrayList<Creep> creepsToRemove = new ArrayList<Creep>();
        	for(Bullet bullet : td.bullets){
        		boolean[] temp = bullet.updateBullet();
        		//bullet met target
        		if(temp[0]){
        			bulletsToRemove.add(bullet);
        			//creep died
        			for(Creep creeps : td.armyOfCreeps){
        				if(creeps.health < 1)
        					creepsToRemove.add(creeps);
        			}
        		}
        	}
        	for(Bullet bullet : bulletsToRemove){
        		td.bullets.remove(bullet);
        		while(td.graphics.printingBullets);
        		new AddRemoveThingstToPaint(false, true, false, bullet, td.graphics);
        		bullet = null;
        	}

        	for(Creep creep : creepsToRemove){
        		new RemoveCreeps(td, creep);
        		
        		td.money += creep.value;
        		while(td.graphics.printingCreeps);
        		new AddRemoveThingstToPaint(false, true, false, creep, td.graphics);
        	}
        	
        	creepsToRemove = null;
        	bulletsToRemove = null;
        	td.bulletFireDelay = System.nanoTime();
        }
	}
}
