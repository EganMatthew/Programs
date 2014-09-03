package SplashTower;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameController.Coordinates;
import GameController.Game;
import TowerController.Tower;

public class SplashTower {
	
	public SplashTower(Tower t, Game game){
		try {t.tower = ImageIO.read(new File(Tower.splashTowerPath));} catch (IOException e) {} 
        t.towerCopy = t.tower; 
       
        t.cost = 10; 
        t.resell = t.cost/2; 
        t.level = 0; 
        t.attackRadius = 300; 
        t.attackSpeed = 4;
        
        if(game.playerclass.toLowerCase().equals("damage"))
        	t.damage = 2 + .15;
        else
        	t.damage = 2;
        
        
        t.upgradeTime = 1; 
        t.upgradeCost = 5; 
        t.radians = 0;
        
        t.attackFlying = true; 
        t.bonusVsFlying = false; 
        t.bonusVsFlyingDamage = 0; 
        t.bonusVsLand = false; 
        t.bonusVsLandDamage = 0; 
        t.splash = false; 
        t.splashDamage = 0; 
        t.splashRadius = 0; 
		
		
	}

}
