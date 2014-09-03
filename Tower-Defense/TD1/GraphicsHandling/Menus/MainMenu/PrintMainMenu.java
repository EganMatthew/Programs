package Menus.MainMenu;

import EventListeners.PlayMusic1;
import EventListeners.PlaySound1;
import GlobalComponents.SetAllInvisible;
import GraphicsController.Graphics;


public class PrintMainMenu {
	
	public PrintMainMenu(Graphics graphics, java.awt.Graphics g){
		g.drawImage(graphics.background1, 0, 0, null);
    	//g.drawImage(graphics.goldenTD, 225, 25, null);
    	
        graphics.play.setVisible(true);
        graphics.worldcreater.setVisible(true);
        graphics.options.setVisible(true);
        graphics.help.setVisible(true);
    	graphics.exit.setVisible(true);
	}
}
