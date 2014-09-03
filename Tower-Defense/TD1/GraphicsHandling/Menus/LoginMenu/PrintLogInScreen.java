package Menus.LoginMenu;

import java.awt.Color;

import GraphicsController.Graphics;

public class PrintLogInScreen {
	
	public PrintLogInScreen(Graphics graphics, java.awt.Graphics g){
		
		g.drawImage(graphics.loginbackground1, 0, 0, null);
		g.setColor(Color.yellow);
		int startX = (int) graphics.loginPanel.getLocation().getX();
		int startY = (int) graphics.loginPanel.getLocation().getY();
		g.drawRect(startX-1, startY-1, graphics.loginPanel.getWidth()+1, graphics.loginPanel.getHeight()+1);
		
    	//g.drawImage(graphics.logincreate, 180, 25, null);

    	if(graphics.legitLogin){
    		graphics.errorMessage.setVisible(false);
    		graphics.loginPanel.setVisible(true);
    	}
		else{
			graphics.errorMessage.setVisible(true);
			graphics.loginPanel.setVisible(true);
		}
	}

}
