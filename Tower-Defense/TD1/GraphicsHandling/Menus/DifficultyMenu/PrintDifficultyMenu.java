package Menus.DifficultyMenu;

import GlobalComponents.SetAllInvisible;
import GraphicsController.Graphics;

public class PrintDifficultyMenu {
	public PrintDifficultyMenu(Graphics graphics, java.awt.Graphics g){
		g.drawImage(graphics.difficultybackground, 0, 0, null);
		graphics.menu.setLocation(312, 465);
    	    	
		graphics.easy.setVisible(true);
		graphics.medium.setVisible(true);
		graphics.hard.setVisible(true);
		graphics.menu.setVisible(true);
	}
}
