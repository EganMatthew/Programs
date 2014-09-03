package GameIO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import CreepController.Creep;
import GameController.Coordinates;
import GameController.Game;
import GlobalComponents.AddRemoveThingstToPaint;
import GraphicsController.Graphics;
import Menus.WorldSelectorMenu.AddItemToScrollMenu;
import NormalTower.UpgradeNormalTower;
import PathFinding.FindPath;
import SplashTower.UpgradeSplashTower;
import TowerController.Tower;

public class ReadGameData {
	
	public ReadGameData(String file, Game td){
		
		File input = new File("gameData\\" + file + ".txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(input);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			// dis.available() returns 0 if the file does not have more lines.
			
			td.notPaused = false;
			
			while (dis.available() != 0) {
				String data = dis.readLine();
				
				if(data.equals("[Data]")){
					
					String temp = dis.readLine();
					String[] temp2 = temp.split(" ");
					td.waveNumber = Integer.parseInt(temp2[0]);
					td.money = Integer.parseInt(temp2[1]);
					td.numberOfLives = Integer.parseInt(temp2[2]);
					td.multiplier = Double.parseDouble(temp2[3]);
					td.multiplierCost = Integer.parseInt(temp2[4]);
					
					String[][] editedMap = new String[21][18];
					for(int i = 0; i < 21; i++){
						String row = dis.readLine();
						String[] rowElements = row.split(" ");
						for(int j = 0; j < 18; j++)
							editedMap[i][j] = rowElements[j];
					}
					
					int counter;
					for(int i = 0; i < td.graphics.listOfColorGrids.size(); i++){
						counter = 0;
						for(int j = 0; j < 21; j++){
							for(int k = 0; k < 18; k++){
								
								if(!editedMap[j][k].equals(td.graphics.listOfColorGrids.get(i)[j][k])){
									continue;
								}
								else
									counter++;
								
							}
						}
						if(counter > 377){
							td.graphics.selectedScrollItem = i;
							break;
						}
					}
				}
				
				
				if(data.equals("[Creep]")){
					String row = dis.readLine();
					
					while(!row.equals("[Creep]")){

						String[] rowElements = row.split(" ");
						dis.readLine();
						Queue<Coordinates> toBePath = new LinkedList<Coordinates>();
						
						String temp = dis.readLine();
						while(!temp.equals("[Path]")){
							
							String[] elmnts = temp.split(" ");
							toBePath.add(new Coordinates(Integer.parseInt(elmnts[0]), Integer.parseInt(elmnts[1])));
							temp = dis.readLine();
						}
											
						
						if(rowElements[0].equals("normalcreep")){
							Creep theCreep = new Creep(td.waveNumber, rowElements[0], td.graphics.playarea, td.graphics.getGrid(), td, true);
							theCreep.health = Double.parseDouble(rowElements[1]);
							theCreep.location = new Coordinates(Integer.parseInt(rowElements[2]), Integer.parseInt(rowElements[3]));
							
							for(Coordinates coords : toBePath)
								theCreep.path.add(coords);
	
							td.normalCreep.add(theCreep);
							td.armyOfCreeps.add(theCreep);
							
							new AddRemoveThingstToPaint(true, false, false, theCreep, td.graphics);
						}
						
						if(rowElements[0].equals("flyingcreep")){
							Creep theCreep = new Creep(td.waveNumber, rowElements[0], td.graphics.playarea, td.graphics.getGrid(), td, true);
							theCreep.health = Double.parseDouble(rowElements[1]);
							theCreep.location = new Coordinates(Integer.parseInt(rowElements[2]), Integer.parseInt(rowElements[3]));
							
							for(Coordinates coords : toBePath)
								theCreep.path.add(coords);
							
							td.armyOfCreeps.add(theCreep);
							td.flyingCreep.add(theCreep);
							
							new AddRemoveThingstToPaint(true, false, false, theCreep, td.graphics);
						}
						if(rowElements[0].equals("fastcreep")){
							Creep theCreep = new Creep(td.waveNumber, rowElements[0], td.graphics.playarea, td.graphics.getGrid(), td, true);
							theCreep.health = Double.parseDouble(rowElements[1]);
							theCreep.location = new Coordinates(Integer.parseInt(rowElements[2]), Integer.parseInt(rowElements[3]));
							
							for(Coordinates coords : toBePath)
								theCreep.path.add(coords);

							td.fastCreep.add(theCreep);
							td.armyOfCreeps.add(theCreep);
							
							new AddRemoveThingstToPaint(true, false, false, theCreep, td.graphics);

						}
						if(rowElements[0].equals("normalboss")){
							Creep theCreep = new Creep(td.waveNumber, rowElements[0], td.graphics.playarea, td.graphics.getGrid(), td, true);
							theCreep.health = Double.parseDouble(rowElements[1]);
							theCreep.location = new Coordinates(Integer.parseInt(rowElements[2]), Integer.parseInt(rowElements[3]));
							
							for(Coordinates coords : toBePath)
								theCreep.path.add(coords);
							
							td.normalBoss.add(theCreep);
							td.armyOfCreeps.add(theCreep);
							
							new AddRemoveThingstToPaint(true, false, false, theCreep, td.graphics);
						}
						
						
						row = dis.readLine();
					}
					
					
				}
				if(data.equals("[Tower]")){
					String row = dis.readLine();
					
					while(!row.equals("[Tower]")){
						String[] tokens = row.split(" ");
						Tower tower = new Tower(tokens[0], new Coordinates(Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4])), td);
						
						if(tower.type.equals("normalTower")){
							for(int i = 0; i < Integer.parseInt(tokens[1])+1; i++){
								new UpgradeNormalTower(tower);
							}
						}
						if(tower.type.equals("splashTower")){
							for(int i = 0; i < Integer.parseInt(tokens[1])+1; i++){
								new UpgradeSplashTower(tower);
							}
						}
						
						tower.mode = tokens[2];
						
						td.towers.add(tower);
						new AddRemoveThingstToPaint(true, false, false, tower, td.graphics);
						
						row = dis.readLine();
					}
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
