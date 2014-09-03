package PathFinding;

import java.util.Random;
import CreepController.Creep;
import GameController.Coordinates;

public class FindPath {
	
	Creep creep;
	
	public FindPath(Creep creep){
		this.creep = creep;
		
		Random generator = new Random(System.currentTimeMillis());
    	int randomNumber = Math.abs(generator.nextInt() % 8);
    	findStartingEdges(randomNumber);
    	
    	if(creep.pathTemp == null || creep.pathTemp == null)
    		return;
    	if(creep.playarea2[creep.pathTemp.getX()][creep.pathTemp.getY()] == null)
    		return;

    	while(!creep.playarea2[creep.pathTemp.getX()][creep.pathTemp.getY()].equals("red")){
    		randomNumber = Math.abs(generator.nextInt() % 8);
    		findRandomPath(randomNumber);
    	}
    	
    	if(creep.flying){
    		Coordinates temp = null;
    		Coordinates temp2 = creep.path.remove();
    		while(!creep.path.isEmpty())
    			temp = creep.path.remove();
    		
    		if(temp2 != null && temp != null){
	    		creep.path.add(temp2);
	    		creep.path.add(temp);
    		}
    	}
	}
	
    private void findRandomPath(int random){
    	if(random == 0){
	    	searchUp();
	    	searchLeft();
	    	searchRight();
	    	searchDown();
	    	return;
    	}
    	if(random == 1){
	    	searchUp();
	    	searchRight();
	    	searchLeft();
	    	searchDown();
	    	return;
    	}
    	if(random == 2){
	    	searchDown();
	    	searchRight();
	    	searchLeft();
	    	searchUp();
	    	return;
    	}
    	if(random == 3){
	    	
	    	searchDown();
	    	searchLeft();
	    	searchRight();
	    	searchUp();
	    	return;
    	}
    	if(random == 4){
    		searchLeft();
	    	searchUp();
	    	searchDown();
	    	searchRight();
	    	return;
    	}
    	if(random == 5){
	    	searchLeft();
	    	searchDown();
	    	searchUp();
	    	searchRight();
	    	return;
    	}
    	if(random == 6){
	    	searchRight();
	    	searchDown();
	    	searchUp();
	    	searchLeft();
	    	return;
    	}
    	if(random == 7){
	    	searchRight();
	    	searchUp();
	    	searchDown();
	    	searchLeft();
	    	return;
    	}
    } 
    
    private boolean searchLeft(){

    	if(creep.pathTemp.getX()-1 > -1 && creep.direction != "right"){
			int x = creep.pathTemp.getX()-1;
			int y = creep.pathTemp.getY();
			
			if(creep.playarea2[Math.abs(x)][Math.abs(y)] != null){
				if(creep.playarea2[Math.abs(x)][Math.abs(y)].equals("gray") || creep.playarea2[Math.abs(x)][Math.abs(y)].equals("red")){
					creep.direction = "left";
					creep.path.add(new Coordinates(x, y));
					creep.pathTemp = new Coordinates(x, y);
					return true;
				}
			}
			
		}
    	return false;
    }
    private boolean searchRight(){

    	if(creep.pathTemp.getX()+1 < 20 && creep.direction != "left"){
			int x = creep.pathTemp.getX()+1;
			int y = creep.pathTemp.getY();
			
			if(creep.playarea2[Math.abs(x)][Math.abs(y)] != null){
				if(creep.playarea2[Math.abs(x)][Math.abs(y)].equals("gray") || creep.playarea2[Math.abs(x)][Math.abs(y)].equals("red")){
					creep.pathTemp = new Coordinates(x, y);
					creep.direction = "right";
					creep.path.add(new Coordinates(x, y));
					return true;
				}
			}
			
		}
    	return false;
    }
    private boolean searchUp(){
    	
    	
    	if(creep.pathTemp.getY()-1 > -1 && creep.direction != "down"){
			int x = creep.pathTemp.getX();
			int y = creep.pathTemp.getY()-1;
			if(creep.playarea2[Math.abs(x)][Math.abs(y)] != null){
				if(creep.playarea2[Math.abs(x)][Math.abs(y)].equals("gray") || creep.playarea2[Math.abs(x)][Math.abs(y)].equals("red")){
					creep.pathTemp = new Coordinates(x, y);
					creep.direction = "up";
					creep.path.add(new Coordinates(x, y));
					return true;
				}
			}
		}
    	return false;
    }
    private boolean searchDown(){
    	if(creep.pathTemp.getY()+1 < 17 && creep.direction != "up"){
			int x = creep.pathTemp.getX();
			int y = creep.pathTemp.getY()+1;
			
			if(creep.playarea2[Math.abs(x)][Math.abs(y)] != null){
				if(creep.playarea2[Math.abs(x)][Math.abs(y)].equals("gray") || creep.playarea2[Math.abs(x)][Math.abs(y)].equals("red")){
					creep.pathTemp = new Coordinates(x, y);
					creep.direction = "down";
					creep.path.add(new Coordinates(x, y));
					return true;
				}
			}
			
		}
    	return false;
    }
    
    private void findStartingEdges(int selection){
    	if(selection == 0){
	    	topEdgeStart();
	    	bottomEdgeStart();
	    	leftEdgeStart();
	    	rightEdgeStart();
    	}
    	else if(selection == 1){
    		bottomEdgeStart();
	    	topEdgeStart();
	    	leftEdgeStart();
	    	rightEdgeStart();
    	}
    	else if(selection == 2){
    		bottomEdgeStart();
	    	topEdgeStart();
	    	rightEdgeStart();
	    	leftEdgeStart();
    	}
    	else if(selection == 3){
    		leftEdgeStart();
	    	topEdgeStart();
	    	rightEdgeStart();
	    	bottomEdgeStart();
    	}
    	else if(selection == 4){
    		leftEdgeStart();
    		rightEdgeStart();
	    	topEdgeStart();
	    	bottomEdgeStart();
    	}
    	else if(selection == 5){
    		rightEdgeStart();
    		leftEdgeStart();
	    	topEdgeStart();
	    	bottomEdgeStart();
    	}
    	else if(selection == 6){
    		rightEdgeStart();
    		leftEdgeStart();
    		bottomEdgeStart();
	    	topEdgeStart();
    	}
    	else if(selection == 7){
	    	topEdgeStart();
	    	rightEdgeStart();
	    	leftEdgeStart();
	    	bottomEdgeStart();
    	}
    	
    }
    
    private void topEdgeStart(){
    	for(int i = 0; i < 21; i++){
    		//top edge
    		if(creep.playarea2[i][0] != null){
	    		if(creep.playarea2[i][0].equals("gray")){
	    			Coordinates temp = Coordinates.convert(i, 0);
	    			creep.location = new Coordinates(temp.getX(), temp.getY()); 
	    			creep.pathTemp = new Coordinates(i, 0);
	    			break;
	    		}
    		}
    	}
    }
    private void bottomEdgeStart(){

    	for(int i = 0; i < 21; i++){
    		//botom edge
    		if(creep.playarea2[i][17] != null){
	    		if(creep.playarea2[i][17].equals("gray")){
	    			Coordinates temp = Coordinates.convert(i, 17);
	    			creep.location = new Coordinates(temp.getX(), temp.getY()); 
	    			creep.pathTemp = new Coordinates(i, 17);
	    			break;
	    		}
    		}
    	}
    }
    private void leftEdgeStart(){
    	for(int i = 0; i < 18; i++){
    		//left edge
    		if(creep.playarea2[0][i] != null){
	    		if(creep.playarea2[0][i].equals("gray")){
	    			Coordinates temp = Coordinates.convert(0, i);
	    			creep.location = new Coordinates(temp.getX(), temp.getY()); 
	    			creep.pathTemp = new Coordinates(0, i);
	    			break;
	    		}
    		}
    	}
    }
    private void rightEdgeStart(){
    	for(int i = 0; i < 18; i++){
    		//right edge
    		if(creep.playarea2[20][i] != null){
	    		if(creep.playarea2[20][i].equals("gray")){
	    			Coordinates temp = Coordinates.convert(20, i);
	    			creep.location = new Coordinates(temp.getX(), temp.getY()); 
	    			creep.pathTemp = new Coordinates(20, i);	
	    			break;
	    		}
    		}
    	}
    }
}
