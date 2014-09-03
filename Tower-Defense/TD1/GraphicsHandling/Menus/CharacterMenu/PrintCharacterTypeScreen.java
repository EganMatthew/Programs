package Menus.CharacterMenu;

import java.awt.Color;

import GraphicsController.Graphics;

public class PrintCharacterTypeScreen {
	
	public PrintCharacterTypeScreen(Graphics graphics, java.awt.Graphics g){
		g.drawImage(graphics.loginbackground2, 0, 0, null);
    	//g.drawImage(graphics.pickclass, 200, 25, null);
    	
    	g.setColor(Color.yellow);
		int startX = (int) graphics.characterPanel.getLocation().getX();
		int startY = (int) graphics.characterPanel.getLocation().getY();
		g.drawRect(startX-1, startY-1, graphics.characterPanel.getWidth()+1, graphics.characterPanel.getHeight()+1);
    	
    	graphics.characterPanel.setVisible(true);
    	
	}

}
