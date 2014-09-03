package UpdateComponents;

import UpdateCreeps.AddCreeps;
import CreepController.Creep;
import GameController.Game;
import GlobalComponents.AddRemoveThingstToPaint;

public class UpdateNextWave {
	public UpdateNextWave(Game td, long spawnCreepDelay, int nextWaveDelay, long addCreepDelay){
		//if either 40 seconds have passed or the next wave button has been pressed 
        //add 15 new creeps to the army. 
		
		
		int numberOfCreeps = Creep.numberOfCreeps(td.waveOrder.peek());
		//System.out.println(td.waveOrder.peek());
		
        if((System.currentTimeMillis() - spawnCreepDelay > nextWaveDelay || td.nextWave) && td.numberOfCreepsCount < numberOfCreeps){
        	td.nextWave = true;
            if(System.currentTimeMillis() - addCreepDelay > Creep.spaceBetweenCreeps(td.waveOrder.peek())){
            	if(td.increaseWaveNumber){
            		td.waveNumber++;
            		td.updateScore();
            		td.increaseWaveNumber = false;
            	}
            	
                Creep temp = new Creep(td.waveNumber, td.waveOrder.peek(), td.graphics.playarea, td.graphics.getGrid(), td); 
                
                new AddCreeps(td, temp);
                
                
                while(td.graphics.printingCreeps);
                new AddRemoveThingstToPaint(true, false, false, temp, td.graphics);
                temp = null;
                td.addCreepDelay = System.currentTimeMillis(); 
                td.numberOfCreepsCount++; 
            } 
        } 
        //when 15 creeps have been made reset the variables to be reused 
        if(td.numberOfCreepsCount > numberOfCreeps-1 && td.nextWave == true){ 
            td.nextWave = false; 
            td.numberOfCreepsCount = 0; 
            td.spawnCreepDelay = System.currentTimeMillis();
            td.increaseWaveNumber = true;
            
            if(!td.waveOrder.isEmpty()){
	            String temp = td.waveOrder.remove();
	            td.waveOrder.add(temp);
            }
        } 
	}
}
