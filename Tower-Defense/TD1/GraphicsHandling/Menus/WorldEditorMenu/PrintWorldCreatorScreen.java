package Menus.WorldEditorMenu;

import GameController.Coordinates;
import GlobalComponents.SetAllInvisible;
import GraphicsController.Graphics;

public class PrintWorldCreatorScreen {
	public PrintWorldCreatorScreen(Graphics graphics, java.awt.Graphics g){
		
		g.drawImage(graphics.genbackground, 0, 0, null);
    	//g.drawImage(graphics.generateworld, 85, 5, null);
    	graphics.menu.setLocation(609, 518);

    	graphics.red.setVisible(true);
    	graphics.gray.setVisible(true);
    	graphics.white.setVisible(true);
    	graphics.save.setVisible(true);
    	graphics.menu.setVisible(true);
    	
    	g.drawImage(graphics.playarea, 67, 67, null);
    	
    	printEditorGlow(g, graphics);

    	printLevel(g, graphics);
	}
	
    public void printEditorGlow(java.awt.Graphics g, Graphics graphics){
    	
    	if(graphics.colorClicked){  
            if(Coordinates.revert(graphics.mouseX, graphics.mouseY).getX() >= 0 && Coordinates.revert(graphics.mouseX, graphics.mouseY).getX() <= 20){ 
                if(Coordinates.revert(graphics.mouseX, graphics.mouseY).getY() >= 0 && Coordinates.revert(graphics.mouseX, graphics.mouseY).getY() <= 17){ 
                    int discreteX = (int)Coordinates.convert(Coordinates.revert(graphics.mouseX, graphics.mouseY).getX(), (int)Coordinates.revert(graphics.mouseX, graphics.mouseY).getY()).getX(); 
                    int discreteY = (int)Coordinates.convert(Coordinates.revert(graphics.mouseX, graphics.mouseY).getX(), (int)Coordinates.revert(graphics.mouseX, graphics.mouseY).getY()).getY(); 
                    g.drawImage(graphics.glow, discreteX, discreteY, null); 
                } 
                else{ 
                    g.drawImage(graphics.glow, graphics.mouseX-25, graphics.mouseY-25, null); 
                } 
            } 
            else{ 
                g.drawImage(graphics.glow, graphics.mouseX-25, graphics.mouseY-25, null);
            } 
        }
    }
    
    public void printLevel(java.awt.Graphics g, Graphics graphics){
    	graphics.printingColors = true;
    	
    	for(int i = 0; i < 21; i++){
    		for(int j = 0; j < 18; j++){
    			int x = Coordinates.convert(i, j).getX();
    			int y = Coordinates.convert(i, j).getY();
    			if(graphics.colorGrid[i][j] == "red")
    				g.drawImage(graphics.redImage, x, y, null);
    			if(graphics.colorGrid[i][j] == "gray")
    				g.drawImage(graphics.grayImage, x, y, null);
    			if(graphics.colorGrid[i][j] == "white")
    				g.drawImage(graphics.whiteImage, x, y, null);
    		}
    	}

    	graphics.printingColors = false;
    }
}
