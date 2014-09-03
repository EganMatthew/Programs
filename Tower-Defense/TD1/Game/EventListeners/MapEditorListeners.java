package EventListeners;

import java.util.ArrayList;

import GameController.Coordinates;
import GameController.Game;
import GameIO.WriteEditedMapData;
import Menus.WorldSelectorMenu.AddItemToScrollMenu;

public class MapEditorListeners {
	
	public MapEditorListeners(){
		
	}
	
	public MapEditorListeners(Coordinates location, String color, Game td){
    	Coordinates temp = Coordinates.revert(location.getX(), location.getY());
		td.graphics.colorGrid[temp.getX()][temp.getY()] = color;
    }
        
    public MapEditorListeners(Game td){ 
    	
       	new WriteEditedMapData(td.graphics.colorGrid, td.username.toLowerCase());
       	
    	td.graphics.listOfColorGrids.add(td.graphics.colorGrid);
    	
    	new AddItemToScrollMenu(td.graphics, td.graphics.colorGrid);
    	td.graphics.colorGrid = new String[21][18];
    }

}
