package Painting;

import java.awt.Color;

import CreepController.Creep;
import GraphicsController.Graphics;

public class PrintCreeps {
	
	public PrintCreeps(Graphics graphics, java.awt.Graphics g){
		//print all the creeps
		graphics.printingCreeps = true;
        for(Creep creep : graphics.creepsToPaint ) {
        	if(creep == null || creep.location == null)
        		return;
        	
        	g.drawImage(creep.creepImage, (int)creep.location.getX()-0, (int)creep.location.getY()-0, null);
            g.setColor(Color.black);
            g.drawRect((int)creep.location.getX()+3, (int)creep.location.getY()+20, 15, 5);
               
            g.setColor(Color.green);
            //a bar of length 14 is filled
            double barLength = (double)creep.health/(double)creep.maxHealth*14;
            g.fillRect((int)creep.location.getX()+4, (int)creep.location.getY()+21, (int)barLength, 4);
            g.setColor(Color.black);
        }
        
        graphics.printingCreeps = false;
	}

}
