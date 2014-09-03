package GameIO;

import java.io.BufferedWriter;
import java.io.FileWriter;

import GraphicsController.Graphics;

public class WriteLoginData {
	
	public WriteLoginData(String nameToAdd, Graphics graphics, String file){
		
		ReadLoginData temp = new ReadLoginData(nameToAdd, "registry");
		
		if(temp.taken){
			graphics.legitLogin = false;
			return;
		}
		
		try{
			FileWriter fstream = new FileWriter("gameData\\" + file + ".txt", true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.newLine();
			out.write(nameToAdd);
			//Close the output stream
			out.close();
			
			graphics.mainMenuScreen = false;
        	graphics.worldCreaterScreen = false;
            graphics.optionsScreen = false;
            graphics.difficultyScreen = false;
            graphics.worldSelectorScreen = false;
            graphics.loginScreen = false;
            graphics.gameScreen = false;
            graphics.characterTypeScreen = true;
            
            graphics.game.username = nameToAdd.toLowerCase();

			graphics.confirmation = true;
			graphics.repaint();
			
		}catch (Exception e){}
	}
	
	public WriteLoginData(String nameToAdd, Graphics graphics, String file, boolean temp){
		
		try{
			FileWriter fstream = new FileWriter("gameData\\" + file + ".txt", true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.newLine();
			out.write(nameToAdd);
			//Close the output stream
			out.close();
			
			graphics.mainMenuScreen = true;
        	graphics.worldCreaterScreen = false;
            graphics.optionsScreen = false;
            graphics.difficultyScreen = false;
            graphics.worldSelectorScreen = false;
            graphics.loginScreen = false;
            graphics.gameScreen = false;
            graphics.characterTypeScreen = false;

			graphics.confirmation = true;
			graphics.repaint();
			
		}catch (Exception e){}
	}

}
