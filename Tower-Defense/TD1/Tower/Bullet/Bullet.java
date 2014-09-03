package Bullet;

import java.util.ArrayList;

import CreepController.Creep;
import GameController.Coordinates;

public class Bullet {
	
	private Creep creep;
	private ArrayList<Creep> creeps;
	private Coordinates location;
	private double radians;
	private double xAccumulator;
	private double yAccumulator;
	private double damage;
	String type;
	
	public Bullet(Coordinates location, Creep creep, double damage){
		this.type = "normal";
		this.location = location;
		this.creep = creep;
		this.damage = damage;
	}
	
	public Bullet(Coordinates location, Creep creep, double damage, ArrayList<Creep> creeps){
		this.type = "splash";
		this.location = location;
		this.creeps = creeps;
		this.creep = creep;
		this.damage = damage;
	}
	
	public boolean[] updateBullet(){
		
		boolean[] temp = new boolean[2];
		
		int creepX = creep.location.getX();
        int creepY = creep.location.getY();
        
        
	    if(Math.abs(creepX - location.getX()) < 10 && Math.abs(creepY - location.getY()) < 10){
	    	
	    	if(type == "splash")
		    	for(Creep creep : creeps){
		    		creep.takeDamage(damage);
		    	}
	    	else if(type == "normal")
	    		creep.takeDamage(damage);
	    	
	     	
	      	temp[0] = true;
	      	return temp;
	    }
        
        radians = Math.atan2(creepY-location.getY(), creepX-location.getX());
        
        xAccumulator += Math.cos(radians);
        yAccumulator += Math.sin(radians);
        
        int xMove = 0;
        int yMove = 0;
        
        if(xAccumulator > 1){
        	xAccumulator -= 1;
        	xMove = 1;
        }
        if(xAccumulator < -1){
        	xAccumulator += 1;
        	xMove = -1;
        }
        if(yAccumulator > 1){
        	yAccumulator -=1;
        	yMove = 1;
        }
        if(yAccumulator < -1){
        	yAccumulator += 1;
        	yMove = -1;
        }        
        
        location = new Coordinates(location.getX()+xMove, location.getY()+yMove);
        
        temp[0] = false;
        return temp;
	}
		
	public Coordinates getLocation(){
		return location;
	}

}
