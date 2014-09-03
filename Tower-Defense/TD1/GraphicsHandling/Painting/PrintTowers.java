package Painting;

import GameController.Coordinates;
import GraphicsController.Graphics;
import TowerController.Tower;

public class PrintTowers {
	public PrintTowers(Graphics graphics, java.awt.Graphics g){
		 //print all the towers 
		graphics.printingTowers = true;
		
        for(Tower tower : graphics.towersToPaint ) { 
            Coordinates trueLocation = Coordinates.convert(tower.location.getX(), tower.location.getY()); 
            g.drawImage(graphics.towerbase, (int)trueLocation.getX(), (int)trueLocation.getY(), null); 
            g.drawImage(tower.towerCopy, (int)trueLocation.getX(), (int)trueLocation.getY(), null); 
        }
        
        graphics.printingTowers = false;
	}
}
