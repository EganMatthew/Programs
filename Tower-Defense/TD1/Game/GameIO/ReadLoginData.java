package GameIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import GameController.Game;
import GraphicsController.Graphics;

public class ReadLoginData {
	
	public ReadLoginData(String nameToCheck, Graphics graphics, Game td){
		File input = new File("gameData\\registry.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		
		if(nameToCheck.equals("")){
			graphics.legitLogin = false;
			return;
		}

		try {
			fis = new FileInputStream(input);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			// dis.available() returns 0 if the file does not have more lines.
			while (dis.available() != 0) {
				String name = dis.readLine();
				if(name.toLowerCase().equals(nameToCheck.toLowerCase())){
					
					readType(name.toLowerCase(), td);
					
					graphics.mainMenuScreen = true;
                	graphics.worldCreaterScreen = false;
                    graphics.optionsScreen = false;
                    graphics.difficultyScreen = false;
                    graphics.worldSelectorScreen = false;
                    graphics.loginScreen = false;
                    graphics.gameScreen = false;
                    graphics.characterTypeScreen = false;
                    graphics.game.username = name.toLowerCase();

					graphics.confirmation = true;
					graphics.repaint();
					return;
				}
				
			}
			graphics.legitLogin = false;
			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();
			  
		} catch (FileNotFoundException e) {return;}
		  catch (IOException e) { return;}
	}
	
	public boolean taken = false;
	
	public ReadLoginData(String nameToCheck, String file){
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
				String name = dis.readLine();
				if(name.toLowerCase().equals(nameToCheck.toLowerCase())){
					taken = true;
					return;
				}
			}
			taken = false;
			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();
			  
		} catch (FileNotFoundException e) {return;}
		  catch (IOException e) { return;}
	}
	
	public void readType(String name, Game td){
		File input = new File("gameData\\" + name + ".txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(input);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			// dis.available() returns 0 if the file does not have more lines.
			dis.readLine();
			String type = dis.readLine();
			
			td.playerclass = type;
			// dispose all the resources after using them.
			fis.close();
			bis.close();
			dis.close();
			  
		} catch (FileNotFoundException e) {return;}
		  catch (IOException e) { return;}
	}

}
