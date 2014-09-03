package EventListeners;

import java.awt.event.MouseEvent;

import GameController.Coordinates;
import GameController.Game;
import GlobalComponents.AddRemoveThingstToPaint;
import TowerController.Tower;

public class ActionMouseReleased {
	
	public ActionMouseReleased(Game td, MouseEvent arg0){

    	//right clicks should clear any current selection 
        rightClickClear(td, arg0); 
  
        //if the tower 1 JButton has bee clicked continue 
        if(td.graphics.isTowerClicked()){ 
            //if it's a left click 
            if(arg0.getButton() == MouseEvent.BUTTON1) { 
                placeTurret(td);
            } 
        }
                
        if(td.graphics.colorClicked){
        	if(arg0.getButton() == MouseEvent.BUTTON1) { 
        		if(td.graphics.mainMenuScreen != true)
        			placeColor(td);
            }
        }
        
        if(arg0.getButton() == MouseEvent.BUTTON1) { 
        	
        	Coordinates mousePos = Coordinates.revert(td.mouseX, td.mouseY);
    		int mousePosX = mousePos.getX();
    		int mousePosY = mousePos.getY();
    		
        	for(Tower tower : td.towers){
    			if(tower.location.getX() == mousePosX && tower.location.getY() == mousePosY && !td.graphics.isTowerClicked()){
    				td.graphics.showTowerStats = true;
    				td.graphics.showStartingTowerStats = false;
    				td.graphics.towerToPrintStats = tower;
    			}
        	}
        	
        } 
        
        td.graphics.repaint();
	}
	
	//place a turret on the field and check if it's valid 
    private void placeTurret(Game td){ 
        //is the tower within the playfield area? 
    	Coordinates mousePos = Coordinates.revert(td.mouseX, td.mouseY);
        if(mousePos.getX() >= 0 && mousePos.getX() <= 20){ 
            if(mousePos.getY() >= 0 && mousePos.getY() <= 17){
            	
            	String level[][] = td.graphics.listOfColorGrids.get(td.graphics.selectedScrollItem);

            	if(level[mousePos.getX()][mousePos.getY()] != "gray" && level[mousePos.getX()][mousePos.getY()] != "red"){

            		if(td.graphics.tower1Clicked)
            			createNormalTower(td);
            		else if(td.graphics.tower2Clicked)
            			createSplashTower(td);
	                
            	}
            } 
        } 
    }
    
    //Clear any current selections 
    private void rightClickClear(Game td, MouseEvent arg0){ 
    	//if a right click occurs set all flags to false 
        //to let graphics know not to draw (the tower gow & radius 
        // and later some submenus) 
        if(arg0.getButton() == MouseEvent.BUTTON3) { 
            td.graphics.tower1Clicked = false;
            td.graphics.tower2Clicked = false; 
            td.graphics.showTowerStats = false;
            td.graphics.colorClicked = false;
            td.graphics.repaint(); 
        } 
    } 
    
    private void placeColor(Game td){
    	
    	Coordinates mousePos = Coordinates.revert(td.mouseX, td.mouseY);
        if(mousePos.getX() >= 0 && mousePos.getX() <= 20){ 
            if(mousePos.getY() >= 0 && mousePos.getY() <= 17){
            	while(td.graphics.printingColors);
            	new MapEditorListeners(new Coordinates(td.mouseX, td.mouseY), td.graphics.colorToPrint, td);
            }
        }
    	
    }
    
    private void createNormalTower(Game td){
    	if(td.money >= Tower.getCost("normalTower")){
    		Coordinates temp2 = Coordinates.revert(td.mouseX, td.mouseY);
            //check if the tower is already there
    		while(td.iteratingThuTowers);
    		td.iteratingThuTowers = true;
            for(Tower tower : td.towers ){ 
                if(tower.location.getX() == temp2.getX() && tower.location.getY() == temp2.getY()){  
                	td.iteratingThuTowers = false;
                    return; 
                }
            }
            
            
            td.money -= Tower.getCost("normalTower"); 
            Tower temp = new Tower("normalTower", temp2, td); 
            td.towers.add(temp); 
            while(td.graphics.printingTowers);
            new AddRemoveThingstToPaint(true, false, false, temp, td.graphics); 
            td.iteratingThuTowers = false;

            td.graphics.repaint(); 
              
        } 
    }
    
    private void createSplashTower(Game td){

    	if(td.money >= Tower.getCost("splashTower")){

            //check if the tower is already there
    		while(td.iteratingThuTowers);
    		Coordinates temp2 = Coordinates.revert(td.mouseX, td.mouseY);
    		td.iteratingThuTowers = true;
            for(Tower tower : td.towers){ 
                if(tower.location.getX() == temp2.getX() && tower.location.getY() == temp2.getY()){  
                	td.iteratingThuTowers = false;
                    return; 
                }
            }
            
            td.money -= Tower.getCost("splashTower"); 
            Tower temp = new Tower("splashTower", temp2, td); 
            td.towers.add(temp); 
            while(td.graphics.printingTowers);
            new AddRemoveThingstToPaint(true, false, false, temp, td.graphics); 
            td.iteratingThuTowers = false;
            
            td.graphics.repaint(); 
              
        } 
    }

}
