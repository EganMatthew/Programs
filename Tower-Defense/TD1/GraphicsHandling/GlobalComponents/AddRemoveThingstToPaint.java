package GlobalComponents;

import Bullet.Bullet;
import CreepController.Creep;
import GraphicsController.Graphics;
import TowerController.Tower;

public class AddRemoveThingstToPaint {
	
	public AddRemoveThingstToPaint(){
		
	}
	
	 //Method to add/remove towers to the display. 
    //Also to show the tower animations/upgrades 
    public AddRemoveThingstToPaint(boolean buy, boolean sell, boolean upgrade, Tower tower, Graphics graphics){ 
         
        if( buy ){
        	while(graphics.printingTowers);
        	graphics.towersToPaint.add(tower); 
        } 
          
        if( sell ){ 
        	while(graphics.printingTowers);
        	graphics.towersToPaint.remove(tower);
        	tower = null;
        } 

        if( upgrade ){ 
            //invoke some animation for the upgrade 
        } 
        
    }
    
  //there will probably be an updateBullets method 
    public AddRemoveThingstToPaint(boolean birth, boolean death, boolean damage, Creep creep, Graphics graphics){ 
    	
        if( birth ){
        	while(graphics.printingCreeps);
        	graphics.creepsToPaint.add(creep); 
        } 
          
        if( death ){ 
        	while(graphics.printingCreeps);
        	graphics.creepsToPaint.remove(creep);
        	creep = null;
        } 
          
        if( damage ){ 
            //show some sort of damage bar 
        } 
          
    }
    
    public AddRemoveThingstToPaint(boolean birth, boolean death, boolean damage, Bullet bullet, Graphics graphics){
		
		if( birth ){
			while(graphics.printingBullets);
			graphics.bulletsToPaint.add(bullet);
		}
		
		if( death ){
			while(graphics.printingBullets);
			graphics.bulletsToPaint.remove(bullet);
			bullet = null;
		}
		
		if( damage ){
			
		}
		
	}

}
