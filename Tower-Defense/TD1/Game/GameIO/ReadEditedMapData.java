package GameIO;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import GameController.Game;
import GraphicsController.Graphics;
import Menus.WorldSelectorMenu.AddItemToScrollMenu;

public class ReadEditedMapData {

	public ReadEditedMapData(String file, Game td){
		File input = new File("gameData\\" + file + ".txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(input);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			// dis.available() returns 0 if the file does not have more lines.
			while (dis.available() != 0) {
				String map = dis.readLine();
				
				if(map.equals("[Map]")){
					String[][] editedMap = new String[21][18];
					for(int i = 0; i < 21; i++){
						String row = dis.readLine();
						String[] rowElements = row.split(" ");
						for(int j = 0; j < 18; j++)
							editedMap[i][j] = rowElements[j];
					}
					
					td.graphics.listOfColorGrids.add(editedMap);
			    	new AddItemToScrollMenu(td.graphics, editedMap);
				}
				
			}

			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();
			  
		} catch (FileNotFoundException e) {return;}
		  catch (IOException e) { return;}
	}
	
	public ReadEditedMapData(String file){
		File input = new File("gameData\\" + file + ".txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(input);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			// dis.available() returns 0 if the file does not have more lines.
			while (dis.available() != 0) {
				String map = dis.readLine();
				
				if(map.equals("[Map]")){
					String[][] editedMap = new String[21][18];
					for(int i = 0; i < 21; i++){
						String row = dis.readLine();
						String[] rowElements = row.split(" ");
						for(int j = 0; j < 18; j++)
							editedMap[i][j] = rowElements[j];
					}
					
					
					new WriteEditedMapData(editedMap, "tmp");
				}
				
				
				
			}

			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();
			  
		} catch (FileNotFoundException e) {return;}
		  catch (IOException e) { return;}
	}
}
