package Menus.GameMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import GameController.Coordinates;
import GlobalComponents.SetAllInvisible;
import GraphicsController.Graphics;
import Painting.PrintBullets;
import Painting.PrintCreeps;
import Painting.PrintGameLevel;
import Painting.PrintTowers;
import TowerController.Tower;

public class PrintGame {
	
	public PrintGame(Graphics graphics, java.awt.Graphics g){
		graphics.menu.setLocation(40, 525);
       
		graphics.turret1.setVisible(true);
		graphics.turret2.setVisible(true);
		graphics.nextwave.setVisible(true);
		graphics.pause.setVisible(true);
		graphics.menu.setVisible(true);
		graphics.save2.setVisible(true);
        
        new PrintGameLevel(graphics, g, graphics.game);
    	new PrintTowers(graphics, g);
        new PrintCreeps(graphics, g);
        new PrintBullets(graphics, g);
        printPlaceTower(g, graphics);
        printShowTowerStats(g, graphics);
	}
	
	public void printShowTowerStats(java.awt.Graphics g, Graphics graphics){
    	
    	if(graphics.showTowerStats){
    		int offset = 20;
    		
    		if(!graphics.showStartingTowerStats){
    			Coordinates tpx = Coordinates.convert(graphics.towerToPrintStats.location.getX(), graphics.towerToPrintStats.location.getY());
    			g.drawImage(graphics.glow, tpx.getX(), tpx.getY(), null);
    		}
    		
    		Font font = new Font("Dialog", Font.PLAIN, 18);
    		g.setFont(font);
    		g.setColor(Color.yellow);
    		g.drawRect(612, 229, 176, 351);
    		g.setColor(Color.black);
    		g.fillRect(613, 230, 175, 350);
    		g.setColor(Color.orange);
    		g.drawString("Level: " + graphics.towerToPrintStats.level, 620, 250);
    		g.drawString("Sell: " + graphics.towerToPrintStats.resell, 620, 270);
    		g.drawString("Upgrade Cost: " + graphics.towerToPrintStats.upgradeCost, 620, 290);
    		g.drawString("Upgrade Time: " + graphics.towerToPrintStats.upgradeTime, 620, 310);
    		g.drawString("Damage: " + graphics.towerToPrintStats.damage, 620, 330);
    		g.drawString("Attack Speed: " + graphics.towerToPrintStats.attackSpeed, 620, 350);
    		g.drawString("Fire Radius: " + graphics.towerToPrintStats.attackRadius, 620, 370);
    		
    		if(graphics.showStartingTowerStats){
    			g.drawString("Cost: " + Tower.getCost(graphics.towerToPrintStats.type), 620, 410);
    			g.drawString("Tower Type: ", 620, 450);
    			g.drawString(graphics.towerToPrintStats.type, 620, 470);
    		}
    		
    		if(!graphics.showStartingTowerStats){
    			graphics.sell.setVisible(true);
    			graphics.upgrade.setVisible(true);
    			graphics.nearest.setVisible(true);
    			graphics.farthest.setVisible(true);
    			graphics.highest.setVisible(true);
    			graphics.lowest.setVisible(true);
	    		g.drawString("Mode: " + graphics.towerToPrintStats.mode, 620, 500);
    		}
    	}
    	else{
    		graphics.sell.setVisible(false);
    		graphics.upgrade.setVisible(false);
    		graphics.nearest.setVisible(false);
    		graphics.farthest.setVisible(false);
    		graphics.highest.setVisible(false);
    		graphics.lowest.setVisible(false);
    	}
    }
	
	
	public void printPlaceTower(java.awt.Graphics g, Graphics graphics){
    	//if tower1 had been clicked show the glow 
        //Also show the attack radius 
        if(graphics.tower1Clicked || graphics.tower2Clicked){
        	if(graphics.tower1Clicked){
        		setRadiusSize(Tower.getAttackRadius("normalTower"), graphics);
        		graphics.towerToPrintStats = new Tower("normalTower", null, graphics.game);
        		graphics.showTowerStats = true;
        		graphics.showStartingTowerStats = true;
                //printShowTowerStats(g);
        	}
        	else if(graphics.tower2Clicked){
        		setRadiusSize(Tower.getAttackRadius("splashTower"), graphics);
        		graphics.towerToPrintStats = new Tower("splashTower", null, graphics.game);
        		graphics.showTowerStats = true;
        		graphics.showStartingTowerStats = true;
        	}
        	
        	Coordinates temp = Coordinates.revert(graphics.mouseX, graphics.mouseY);
        	Coordinates temp2 = Coordinates.convert(temp.getX(), (int)temp.getY());
            if(temp.getX() >= 0 && temp.getX() <= 20){ 	
                if(temp.getY() >= 0 && temp.getY() <= 17){
                    int discreteX = (int)temp2.getX();
                    int discreteY = (int)temp2.getY();
                    g.drawImage(graphics.glow, discreteX, discreteY, null); 
                    g.drawImage(graphics.scaledRadiusGlow, discreteX+12-graphics.scaledImageSize/2, discreteY+12-graphics.scaledImageSize/2, null); 
                } 
                else{ 
                    g.drawImage(graphics.glow, graphics.mouseX-25, graphics.mouseY-25, null); 
                    g.drawImage(graphics.scaledRadiusGlow, graphics.mouseX-12-graphics.scaledImageSize/2, graphics.mouseY-12-graphics.scaledImageSize/2, null); 
                } 
            } 
            else{ 
                g.drawImage(graphics.glow, graphics.mouseX-25, graphics.mouseY-25, null); 
                g.drawImage(graphics.scaledRadiusGlow, graphics.mouseX-12-graphics.scaledImageSize/2, graphics.mouseY-12-graphics.scaledImageSize/2, null); 
            } 
        } 
    }
	
	//set the radius of the glow 
    public void setRadiusSize(int s, Graphics graphics){ 
        graphics.scaledImageSize = s; 
        graphics.scaledRadiusGlow = graphics.redradius.getScaledInstance(graphics.scaledImageSize, graphics.scaledImageSize, Image.SCALE_DEFAULT); 
    }

}
