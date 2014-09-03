package Painting;

import Bullet.Bullet;
import GraphicsController.Graphics;

public class PrintBullets {
	
	public PrintBullets(Graphics graphics, java.awt.Graphics g){
		graphics.printingBullets = true;
    	//print all the bullets
      	for(Bullet bullet : graphics.bulletsToPaint ) {
      		g.drawImage(graphics.bullet1, (int)bullet.getLocation().getX()+12, (int)bullet.getLocation().getY()+12, null); 
      	}
      	graphics.printingBullets = false;
	}

}
