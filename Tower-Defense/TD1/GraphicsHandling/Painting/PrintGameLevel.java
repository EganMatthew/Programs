package Painting;

import java.awt.Color;
import java.awt.Font;

import GameController.Coordinates;
import GameController.Game;
import GraphicsController.Graphics;

public class PrintGameLevel {
	
	public PrintGameLevel(Graphics graphics, java.awt.Graphics g, Game game){
		g.drawImage(graphics.background, 0, 0, null); 
        g.drawImage(graphics.playarea, 67, 67, null); 
        graphics.multiplier.setVisible(true);
        
        
		
		graphics.printingColors = true;
		String[][] temp = graphics.listOfColorGrids.get(graphics.selectedScrollItem);
		
		for(int i = 0; i < 21; i++){
    		for(int j = 0; j < 18; j++){
    			Coordinates temp2 = Coordinates.convert(i, j);
    			int x = temp2.getX();
    			int y = temp2.getY();
    			if(temp[i][j] == null || temp[i][j].equals("white"))
    				g.drawImage(graphics.whiteImage, x, y, null);
    			else if(temp[i][j].equals("gray"))
    				g.drawImage(graphics.grayImage, x, y, null);
    			else if(temp[i][j].equals("red"))
    				g.drawImage(graphics.redImage, x, y, null);
    			
    		}
    	}
    	graphics.printingColors = false;
    	printMoney(game, g);
	}
	
	private void printMoney(Game game, java.awt.Graphics g){
    	Font font = new Font("Dialog", Font.PLAIN, 18);
		g.setFont(font);
		g.setColor(Color.orange);
		g.drawString("Score: " + game.score, 100, 25);
    	g.drawString("Money: " + game.money, 100, 50);
    	g.drawString("Lives: " + game.numberOfLives, 250, 50);
    	g.drawString("Wave: " + game.waveNumber, 400, 50);
    	g.drawString("Multiplier Cost (+1%): " + game.multiplierCost, 300, 25);
    }

}
