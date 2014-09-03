package Menus.HelpMenu;

import java.awt.Color;
import java.awt.Panel;

import GraphicsController.Graphics;

public class PrintHelp {
	
	public PrintHelp(Graphics graphics, java.awt.Graphics g){
		g.drawImage(graphics.helpscreen, 0, 0, null);
    	
    	
    	graphics.menu.setLocation(20, 520);
    	graphics.menu.setVisible(true);
    	//graphics.helpPanel.setVisible(true);
    	
    	
    	
    	
    	
	}

}
