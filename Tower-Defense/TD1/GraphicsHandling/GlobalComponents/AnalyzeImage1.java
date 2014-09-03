package GlobalComponents;

import java.util.ArrayList;

import GameController.Coordinates;
import GraphicsController.Graphics;
import Menus.WorldSelectorMenu.AddItemToScrollMenu;

public class AnalyzeImage1 {
	
	public AnalyzeImage1(Graphics graphics){
		
		for(int i = 0; i < 21; i++){
    		for(int j = 0; j < 18; j++){
    			
    			Coordinates pixles = Coordinates.convert(i, j);
	    		
		    	int color = graphics.mattsLevel.getRGB(pixles.getX()-66, pixles.getY()-66);
				int  red = (color & 0x00ff0000) >> 16;
				int  green = (color & 0x0000ff00) >> 8;
				int  blue = color & 0x000000ff;
								
				if(red == 127 && green == 127 && blue == 127){
					graphics.colorGrid[i][j] = "gray";
				}
				else if(red == 237 && green == 28 && blue == 36){
					graphics.colorGrid[i][j] = "red";
				}
				else if(red == 255 && green == 255 && blue == 255){
					graphics.colorGrid[i][j] = "white";
				}
			
    		}
    	}
    	new AddItemToScrollMenu(graphics, graphics.colorGrid);
    	graphics.listOfColorGrids.add(graphics.colorGrid);
    	graphics.colorGrid = new String[21][18];
		
	}

}
