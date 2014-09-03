package CreepController; 
  
import java.awt.image.BufferedImage;
import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Random;
import java.util.Stack;
  













import Creeps.BossCreep;
import Creeps.FastCreep;
import Creeps.FlyingCreep;
import Creeps.NormalCreep;
import GameController.Coordinates;
import GameController.Game;
import PathFinding.FindPath;
  
public class Creep { 
      
    //creeps locations are always represented in pixels 
      
    public String type;
    
    public static String imagePathNorm = "images\\creep1.png";
    public static String imagePathFast = "images\\fastcreep.png";
    public static String imagePathBoss = "images\\boss1.png";
    public static String imagePathFly = "images\\flyingcreep.png";
    
    public BufferedImage creepImage;
      
    public double health;
    public double maxHealth;
    public int value;
    
    public Game td;
      
    public boolean flying; 
      
    public Queue<Coordinates> path = new LinkedList<Coordinates>();
    public Coordinates pathTemp;
    
    public Coordinates location; 
      
    public double radians; 
    
    public double xAccumulator;
    public double yAccumulator;
    
    public double distance;
    
    public BufferedImage playarea;
    public String playarea2[][];
    public String direction = null;
      
    public Creep(int wave, String type, BufferedImage playarea, String[][] playarea2, Game td){
    	this.td = td;
        this.type = type; 
        this.playarea = playarea;
        this.playarea2 = playarea2;
        flying = false;
          
        if( type.toLowerCase().equals("normalcreep")){ 
            new NormalCreep(this, wave, td);  
        }
        else if(type.toLowerCase().equals("normalboss")){
        	new BossCreep(this, wave, td);
        }
        else if(type.toLowerCase().equals("flyingcreep")){
        	new FlyingCreep(this, wave, td);
        }
        else if(type.toLowerCase().equals("fastcreep")){
        	new FastCreep(this, wave, td);
        }
        else{
        	
        }
        
        new FindPath(this);
    }
    
    public Creep(int wave, String type, BufferedImage playarea, String[][] playarea2, Game td, boolean temp){
    	
    	this.td = td;
        this.type = type; 
        this.playarea = playarea;
        this.playarea2 = playarea2;
        flying = false;
          
        if( type.toLowerCase().equals("normalcreep")){ 
            new NormalCreep(this, wave, td);  
        }
        else if(type.toLowerCase().equals("normalboss")){
        	new BossCreep(this, wave, td);
        }
        else if(type.toLowerCase().equals("flyingcreep")){
        	new FlyingCreep(this, wave, td);
        }
        else if(type.toLowerCase().equals("fastcreep")){
        	new FastCreep(this, wave, td);
        }
        else{
        	
        }
        
    }
      
    public void findDistance(Coordinates source){
    	int xdest = location.getX();
    	int ydest = location.getY();
    	int xsource = source.getX();
    	int ysource = source.getY();
    	
    	distance = Math.sqrt(Math.pow(xdest-xsource, 2) + Math.pow(ydest-ysource, 2));
    }
    
    public static int numberOfCreeps(String a){

    	if(a != null){
	    	if(a.toLowerCase().equals("normalcreep"))
	    		return 15;
	    	if(a.toLowerCase().equals("normalboss"))
	    		return 2;
	    	if(a.toLowerCase().equals("flyingcreep"))
	    		return 10;
	    	if(a.toLowerCase().equals("fastcreep"))
	    		return 20;
    	}
    	return 0;
    }
    
    public static int speedOfCreeps(String a){
    	if(a.toLowerCase().equals("normalcreep"))
    		return 10000000;
    	if(a.toLowerCase().equals("normalboss"))
    		return 20000000;
    	if(a.toLowerCase().equals("flyingcreep"))
    		return 20000000;
    	if(a.toLowerCase().equals("fastcreep"))
    		return 5000000;
    	
    	return 0;    	
    }
    
    public static int spaceBetweenCreeps(String a){
    	if(a.toLowerCase().equals("normalcreep"))
    		return 150;
    	if(a.toLowerCase().equals("normalboss"))
    		return 300;
    	if(a.toLowerCase().equals("flyingcreep"))
    		return 300;
    	if(a.toLowerCase().equals("fastcreep"))
    		return 75;
    	
    	return 0;
    }
    
    int counter = 0;      
      
   
      
    public void takeDamage(double damage){
        health -= damage; 
        if(health < 0)
        	creepImage = null;
    } 
    
} 