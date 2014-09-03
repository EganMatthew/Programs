package Menus.WorldSelectorMenu;

import GlobalComponents.SetAllInvisible;
import GraphicsController.Graphics;

public class PrintWorldSelectorScreen {
	
	public PrintWorldSelectorScreen(Graphics graphics, java.awt.Graphics g){
		
		g.drawImage(graphics.background2, 0, 0, null);
    	//g.drawImage(graphics.chooseworld, 200, 25, null);
    	
		graphics.load.setLocation(200, 464);
    	graphics.load.setVisible(true);
    	graphics.menu.setLocation(403, 464);
    	graphics.menu.setVisible(true);
    	graphics.panelParent.setVisible(true);
    	
    	
	}

}
