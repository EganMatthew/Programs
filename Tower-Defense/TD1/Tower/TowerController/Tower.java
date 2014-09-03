package TowerController; 
  
import java.awt.geom.AffineTransform; 
import java.awt.image.AffineTransformOp; 
import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException; 
  
import java.util.ArrayList;

import javax.imageio.ImageIO; 
  











import Bullet.Bullet;
import CreepController.Creep;
import EventListeners.PlaySound1;
import GameController.Coordinates;
import GameController.Game;
import NormalTower.NormalTower;
import SplashTower.SplashTower;
  
public class Tower { 
    
	public Game game;
	
	public static String normalTowerPath = "images\\tower1.png";
	public static String splashTowerPath = "images\\tower2.png";
	
    public String type;
    public String mode;
    public int cost; 
    public int resell; 
    public int level; 
    public int attackRadius; 
    public int attackSpeed; 
    public double damage; 
    public int upgradeTime;    //seconds 
    public int upgradeCost; 
      
    public boolean attackFlying; 
    public boolean bonusVsFlying; 
    public int bonusVsFlyingDamage; 
      
    public boolean attackland; 
    public boolean bonusVsLand; 
    public int bonusVsLandDamage; 
      
    public boolean splash; 
    public int splashDamage; 
    public int splashRadius; 
      
    public BufferedImage tower; 
    public BufferedImage towerCopy; 
      
    public Coordinates location; 
    public double radians; 
      
  
    public Tower( String type, Coordinates location, Game game){ 
        this.game = game;
        this.type = type;
        this.location = location; 
        mode = "lowest";

        if( type.equals("normalTower")){
        	new NormalTower(this, game);
        } 
        else if( type.equals("splashTower")){ 
        	new SplashTower(this, game);
        } 
        else { 
        	
        } 
    }
    
      
    public boolean isCreepInRange(Coordinates creep){ 
        Coordinates towerPLocation = Coordinates.convert((int)location.getX(), (int)location.getY()); 

        if(Math.pow(creep.getX()-towerPLocation.getX(), 2) + Math.pow(creep.getY()-towerPLocation.getY(), 2) <= Math.pow(attackRadius/2, 2)){ 
            return true; 
        } 
          
        return false; 
    } 

    public Bullet fire(Creep creep){ 
    	Coordinates pixleLocation = Coordinates.convert(location.getX(), location.getY());
    	//new PlaySound1(game.soundVolume, true);
    	return new Bullet(pixleLocation, creep, damage);
    } 
    
    public Bullet fire(Creep creep, ArrayList<Creep> splashTargets){ 
    	Coordinates pixleLocation = Coordinates.convert(location.getX(), location.getY());
    	//new PlaySound1(game.soundVolume, true);
    	return new Bullet(pixleLocation, creep, damage, splashTargets);
    } 
      
    public void findAngle(Coordinates creep){ 
        //creep coords are in pixels 
          
        double xdest = creep.getX(); 
        double ydest = creep.getY(); 
          
        //convert tower coords to pixels 
        Coordinates realloc = Coordinates.convert((int)location.getX(), (int)location.getY()); 
        double xloc = realloc.getX(); 
        double yloc = realloc.getY(); 
          
        double xlength = xdest - xloc; 
        double ylength = ydest - yloc; 
          
        if(ylength == 0) 
            if(xlength > 0) 
                radians = 0; 
            else 
                radians = Math.PI; 
        else if(xlength == 0) 
            if(ylength > 0) 
                radians = Math.PI/2; 
            else 
                radians = -Math.PI/2; 
        else 
            radians = Math.atan(xlength/ylength); 
          
        if(xlength < 0 && ylength > 0) 
            radians = 2*Math.PI - radians + Math.PI/2; 
        if(xlength < 0 && ylength < 0) 
            radians = 2*Math.PI - radians - Math.PI/2; 
        if(xlength > 0 && ylength > 0) 
            radians = 2*Math.PI - radians + Math.PI/2; 
        if(xlength > 0 && ylength < 0) 
            radians = 2*Math.PI - radians - Math.PI/2; 
    } 
      
    public void rotateTower(double value){ 
        //replace copy with origional 
        towerCopy = tower; 
        //do the rotation 
        AffineTransform tx = new AffineTransform(); 
        tx.rotate(value, tower.getWidth()/2, tower.getHeight()/2); 
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR); 
        //set the copy to the rotated tower 
        towerCopy = op.filter(towerCopy, null); 
    } 
      
    public static int getAttackRadius(String tower){ 
        if(tower == "normalTower") 
            return 150;
        if(tower == "splashTower") 
            return 300; 
          
        return 0; 
    } 
       
    public static int getCost(String type){ 
        if(type == "normalTower")
            return 5;
        if(type == "splashTower")
            return 10; 
          
        return 10000; 
    }      

} 