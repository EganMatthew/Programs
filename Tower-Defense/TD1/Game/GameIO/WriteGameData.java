package GameIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import CreepController.Creep;
import GameController.Coordinates;
import GameController.Game;
import GraphicsController.Graphics;
import TowerController.Tower;

public class WriteGameData {
	
	public WriteGameData(Game td, String file){
		
		
		
		try{
			FileWriter fstream = new FileWriter("gameData\\tmp.txt", true);
			BufferedWriter out = new BufferedWriter(fstream);
			
			out.newLine();
			out.write(td.playerclass);
			out.newLine();
			out.write("[Data]");
			out.newLine();
			out.write(td.waveNumber + " ");
			out.write(td.money + " ");
			out.write(td.numberOfLives + " ");
			out.write(td.multiplier + " ");
			out.write(td.multiplierCost + " ");
			out.newLine();
			for(int i = 0; i < 21; i++){
				for(int j = 0; j < 18; j++){
					if(td.graphics.listOfColorGrids.get(td.graphics.selectedScrollItem)[i][j] == null)
						out.write("white ");
					else
						out.write(td.graphics.listOfColorGrids.get(td.graphics.selectedScrollItem)[i][j] + " ");
				}
				out.newLine();
			}
			out.write("[Creep]");
			out.newLine();
			for(Creep creep : td.armyOfCreeps){
				out.write(creep.type + " ");
				out.write(creep.health + " ");
				out.write(creep.location.getX() + " ");
				out.write(creep.location.getY() + " ");
				out.newLine();
				out.write("[Path]");
				out.newLine();
				for(Coordinates path : creep.path){
					out.write(path.getX() + " " + path.getY());
					out.newLine();
				}
				out.write("[Path]");
				out.newLine();
			}
			
			
			out.write("[Creep]");
			out.newLine();
			out.write("[Tower]");
			out.newLine();
			for(Tower tower : td.towers){
				out.write(tower.type + " ");
				out.write(tower.level + " ");
				out.write(tower.mode + " ");
				out.write(tower.location.getX() + " ");
				out.write(tower.location.getY() + " ");
				out.newLine();
			}
			out.write("[Tower]");
			out.newLine();
			out.close();
			
			new ReadEditedMapData(td.username);
			
			
			
			File file2 = new File("gameData\\" + td.username + ".txt");
			file2.delete();
			File file3 = new File("gameData\\tmp.txt");
			file3.renameTo(new File("gameData\\" + td.username + ".txt"));
			

			
			
			
			
		}catch (Exception e){}
	}

}
