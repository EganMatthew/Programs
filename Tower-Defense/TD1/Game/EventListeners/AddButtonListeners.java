package EventListeners;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import CreepController.Creep;
import GameController.Game;
import GameIO.ReadEditedMapData;
import GameIO.ReadGameData;
import GameIO.ReadLoginData;
import GameIO.ReadScoresData;
import GameIO.WriteGameData;
import GameIO.WriteLoginData;
import GlobalComponents.AddRemoveThingstToPaint;
import GraphicsController.Graphics;
import NormalTower.UpgradeNormalTower;
import SplashTower.UpgradeSplashTower;
import TowerController.Tower;

public class AddButtonListeners {
	
	public AddButtonListeners(final Graphics graphics, final Game td){

		graphics.highscores.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	JFrame temp = new JFrame();
            	temp.setSize(500, 500);
            	temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            	
            	ReadScoresData readdata = new ReadScoresData();
            	ArrayList<String> scores = new ArrayList<String>();
            	scores = readdata.getScores();
            	
            	if(scores != null){
            		Font font = new Font("Monospaced", Font.BOLD, 18);
            		Font font2 = new Font("Monospaced", Font.BOLD, 25);
            		
            		JPanel panel = new JPanel();
            		panel.setSize(temp.getWidth(), temp.getHeight());
            		panel.setBackground(Color.white);
            		panel.setLayout(null);
            		
            		for(int i = 0; (i < 10 && i  < scores.size()); i++){
            			JLabel topgames = new JLabel(scores.get(i));
            			topgames.setFont(font);
            			topgames.setSize(700, 150);
            			topgames.setBackground(new Color(0xF0F8FF));
            			topgames.setLocation(25, (i*25));
            			topgames.setFocusable(false);
            			panel.add(topgames);
            		}
            		
            		temp.add(panel);
            	}
            	
            	temp.setVisible(true);
            } 
        });
		
		graphics.multiplier.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	if(td.money - td.multiplierCost > -1){
            		td.money -= td.multiplierCost;
            		td.multiplier += .01;
            		td.multiplierCost = (int)(td.multiplierCost * 1.5);
            		td.graphics.repaint();
            	}
            } 
        });
		
		graphics.choose.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	graphics.browse.showOpenDialog(new JFrame());
            	
            	graphics.customMusic = true;
            	
            	if(graphics.browse.getSelectedFile() == null)
            		return;
            	
            	graphics.music1.stop();
            	graphics.music1 = new PlayMusic1(td.musicVolume, graphics.browse.getSelectedFile().getAbsolutePath());
            } 
        });
		
		graphics.customNormalCreep.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	graphics.browse.showOpenDialog(new JFrame());
            	
            	if(graphics.browse.getSelectedFile() == null)
            		return;
            	
            	Creep.imagePathNorm = graphics.browse.getSelectedFile().getAbsolutePath();
            } 
        });
		
		graphics.customFlyingCreep.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	graphics.browse.showOpenDialog(new JFrame());
            	
            	if(graphics.browse.getSelectedFile() == null)
            		return;
            	
            	Creep.imagePathFly = graphics.browse.getSelectedFile().getAbsolutePath();
            } 
        });
		
		graphics.customBossCreep.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	graphics.browse.showOpenDialog(new JFrame());
            	
            	if(graphics.browse.getSelectedFile() == null)
            		return;
            	
            	Creep.imagePathBoss = graphics.browse.getSelectedFile().getAbsolutePath();
            } 
        });
		
		graphics.customFastCreep.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	graphics.browse.showOpenDialog(new JFrame());
            	
            	if(graphics.browse.getSelectedFile() == null)
            		return;
            	
            	Creep.imagePathFast = graphics.browse.getSelectedFile().getAbsolutePath();
            } 
        });
		
		graphics.customNormalTower.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	graphics.browse.showOpenDialog(new JFrame());
            	
            	if(graphics.browse.getSelectedFile() == null)
            		return;
            	
            	Tower.normalTowerPath = graphics.browse.getSelectedFile().getAbsolutePath();
            	graphics.turret1.setIcon(new ImageIcon(Tower.normalTowerPath));
            } 
        });
		
		graphics.customSplashTower.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	graphics.browse.showOpenDialog(new JFrame());
            	
            	if(graphics.browse.getSelectedFile() == null)
            		return;
            	
            	Tower.splashTowerPath = graphics.browse.getSelectedFile().getAbsolutePath();
            	graphics.turret2.setIcon(new ImageIcon(Tower.splashTowerPath));
            } 
        });
		
		
		graphics.load.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {

            	graphics.worldSelectorScreen = false;
            	graphics.worldCreaterScreen = false;
                graphics.mainMenuScreen = false;
                graphics.optionsScreen = false;
                graphics.difficultyScreen = false;
                graphics.gameScreen = true;
                graphics.loginScreen = false;
                graphics.characterTypeScreen = false;
                graphics.helpMenu = false;
                new ReadGameData(td.username, td);
                graphics.repaint();
            }
        });
		
		graphics.masterVolume.addChangeListener(new ChangeListener() { 
			public void stateChanged(ChangeEvent arg0) {
				td.masterVolume = graphics.masterVolume.getValue()/100.0;
				graphics.soundVolume.setMaximum((int)(td.masterVolume*100));
				graphics.musicVolume.setMaximum((int)(td.masterVolume*100));
			}
        });
		
		graphics.soundVolume.addChangeListener(new ChangeListener() { 
			public void stateChanged(ChangeEvent arg0) {
				td.soundVolume = graphics.soundVolume.getValue()/100.0;
			}
        });
		
		graphics.musicVolume.addChangeListener(new ChangeListener() { 
			public void stateChanged(ChangeEvent arg0) {
				td.musicVolume = graphics.musicVolume.getValue()/100.0;
				graphics.music1.changeVolume(td.musicVolume);
			}
        });
		
		graphics.money.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	new WriteLoginData("Money", td.graphics, td.graphics.game.username, false);
            	graphics.game.playerclass = "Money";
            } 
        });
		
		graphics.damage.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	new WriteLoginData("Damage", td.graphics, td.graphics.game.username, false);
            	graphics.game.playerclass = "Damage";
            } 
        });
		
		graphics.feline.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	new WriteLoginData("Feline", td.graphics, td.graphics.game.username, false);
            	graphics.game.playerclass = "Feline";
            } 
        });
		
		graphics.login.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	new ReadLoginData(td.graphics.username.getText(), td.graphics, td);
            	if(graphics.legitLogin)
            		new ReadEditedMapData(td.username, td);
            	td.graphics.repaint();
            } 
        });
		
		graphics.register.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	new WriteLoginData(td.graphics.username.getText(), td.graphics, "registry");
            	td.graphics.repaint();
            } 
        });
		
		graphics.menu.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 

                if(!graphics.customMusic){
                	if(graphics.gameScreen){
                		graphics.music1.stop();
                		graphics.music1 = new PlayMusic1(td.musicVolume, "Sounds\\App Audio - Main Menu 2.wav");
                	}
                }
                
                graphics.mainMenuScreen = true;
            	graphics.worldCreaterScreen = false;
                graphics.optionsScreen = false;
                graphics.difficultyScreen = false;
                graphics.worldSelectorScreen = false;
                graphics.loginScreen = false;
                graphics.gameScreen = false;
                graphics.characterTypeScreen = false;
                graphics.helpMenu = false;
                graphics.colorGrid = new String[21][18];
                
                td.graphics.tower1Clicked = false;
                td.graphics.tower2Clicked = false; 
                td.graphics.showTowerStats = false;
                td.graphics.colorClicked = false;
            	
            	td.reset();
            	td.graphics.repaint(); 
            } 
        });
    	   	
    	graphics.red.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.colorClicked = true;
            	graphics.colorToPrint = "red";
                graphics.repaint(); 
            } 
        });
    	
    	graphics.gray.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.colorClicked = true;
            	graphics.colorToPrint = "gray";
                graphics.repaint(); 
            } 
        });
    	
    	graphics.white.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.colorClicked = true;
            	graphics.colorToPrint = "white";
                graphics.repaint(); 
            } 
        });
    	
    	graphics.save.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.mainMenuScreen = true;
            	graphics.worldCreaterScreen = false;
                graphics.optionsScreen = false;
                graphics.difficultyScreen = false;
                graphics.worldSelectorScreen = false;
                graphics.gameScreen = false;
                graphics.loginScreen = false;
                graphics.characterTypeScreen = false;
                graphics.helpMenu = false;
            	new MapEditorListeners(td);
                graphics.repaint(); 
            } 
        });
    	
    	graphics.save2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	new WriteGameData(td, td.username);
            } 
        });
    	
    	//play
    	graphics.play.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.worldSelectorScreen = true;
            	graphics.worldCreaterScreen = false;
                graphics.mainMenuScreen = false;
                graphics.optionsScreen = false;
                graphics.difficultyScreen = false;
                graphics.gameScreen = false;
                graphics.loginScreen = false;
                graphics.characterTypeScreen = false;
                graphics.helpMenu = false;
                graphics.repaint(); 
            } 
        });
    	
    	graphics.help.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.worldSelectorScreen = false;
            	graphics.worldCreaterScreen = false;
                graphics.mainMenuScreen = false;
                graphics.optionsScreen = false;
                graphics.difficultyScreen = false;
                graphics.gameScreen = false;
                graphics.loginScreen = false;
                graphics.characterTypeScreen = false;
                graphics.helpMenu = true;
                graphics.repaint(); 
            } 
        });
    	
    	//worldcreater
    	graphics.worldcreater.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	graphics.worldCreaterScreen = true;
                graphics.mainMenuScreen = false;
                graphics.optionsScreen = false;
                graphics.difficultyScreen = false;
                graphics.worldSelectorScreen = false;
                graphics.gameScreen = false;
                graphics.loginScreen = false;
                graphics.characterTypeScreen = false;
                graphics.helpMenu = false;
                graphics.repaint(); 
            } 
        });
    	    	
    	//options
    	graphics.options.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	//options to be added
            	graphics.optionsScreen = true;
            	graphics.worldCreaterScreen = false;
                graphics.mainMenuScreen = false;
                graphics.difficultyScreen = false;
                graphics.worldSelectorScreen = false;
                graphics.gameScreen = false;
                graphics.loginScreen = false;
                graphics.characterTypeScreen = false;
                graphics.helpMenu = false;
                graphics.repaint();
            } 
        });

    	//exit
    	graphics.exit.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	graphics.frame.dispose();
            	System.exit(0);
            } 
        });
    	
    	graphics.pause.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                if(td.notPaused == true){
                	td.notPaused = false;
                	if(!graphics.customMusic){
                		graphics.music1.stop();
                		graphics.music1 = new PlayMusic1(td.musicVolume, "Sounds\\App Audio - Pause Menu 2.wav");
                	}
                }
                else if(td.notPaused == false){
                	td.notPaused = true;
                	if(!graphics.customMusic){
                		graphics.music1.stop();
                		graphics.music1 = new PlayMusic1(td.musicVolume, "Sounds\\App Audio - Waves 2.wav");
                	}
                }
            } 
        });
    	
    	//nearest
    	graphics.nearest.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                graphics.towerToPrintStats.mode = "nearest";
                graphics.repaint(); 
            } 
        });
    	//farthest
    	graphics.farthest.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.towerToPrintStats.mode = "farthest";
                graphics.repaint(); 
            } 
        }); 
    	//lowest
    	graphics.lowest.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.towerToPrintStats.mode = "lowest";
                graphics.repaint(); 
            } 
        }); 
    	//highest
    	graphics.highest.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.towerToPrintStats.mode = "highest"; 
                graphics.repaint(); 
            } 
        }); 
    	
        //Set up the action listener for the tower's JButton 
        //There will be one of these for each tower button. 
        graphics.turret1.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.tower2Clicked = false; 
            	graphics.tower1Clicked = true;
                graphics.repaint(); 
            } 
        }); 
        graphics.turret2.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	graphics.tower1Clicked = false; 
                graphics.tower2Clicked = true; 
                graphics.repaint(); 
            } 
        }); 
          
        //if the next wave button is pressed unpause the game 
        //and set send a new wave. 
        graphics.nextwave.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	
            	if(!graphics.customMusic){
                	if(!graphics.gameScreen || !td.notPaused){
                		graphics.music1.stop();
                		graphics.music1 = new PlayMusic1(td.musicVolume, "Sounds\\App Audio - Waves 2.wav");
                	}
            	}
            	
                td.notPaused = true; 
                td.nextWave = true;
               
            }
        });
        
        graphics.easy.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	
            	if(td.playerclass.toLowerCase().equals("feline"))
            		td.numberOfLives = 15+9;
            	else
            		td.numberOfLives = 15;
            	
                graphics.worldCreaterScreen = false;
                graphics.mainMenuScreen = false;
                graphics.optionsScreen = false;
                graphics.difficultyScreen = false;
                graphics.worldSelectorScreen = false;
                graphics.gameScreen = true;
                graphics.loginScreen = false;
                graphics.characterTypeScreen = false;
                graphics.helpMenu = false;
                
                if(!graphics.customMusic){
                	graphics.music1.stop();
            		graphics.music1 = new PlayMusic1(td.musicVolume, "Sounds\\App Audio - Pause Menu 2.wav");
                }
                
                graphics.repaint();
            } 
        }); 
        
        graphics.medium.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	
            	if(td.playerclass.toLowerCase().equals("feline"))
            		td.numberOfLives = 10+9;
            	else
            		td.numberOfLives = 10;
            	
                graphics.worldCreaterScreen = false;
                graphics.mainMenuScreen = false;
                graphics.optionsScreen = false;
                graphics.difficultyScreen = false;
                graphics.worldSelectorScreen = false;
                graphics.gameScreen = true;
                graphics.loginScreen = false;
                graphics.characterTypeScreen = false;
                graphics.helpMenu = false;
                
                if(!graphics.customMusic){
                	graphics.music1.stop();
                	graphics.music1 = new PlayMusic1(td.musicVolume, "Sounds\\App Audio - Pause Menu 2.wav");
                }
                
                graphics.repaint();
            } 
        }); 
        
        graphics.hard.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 

            	if(td.playerclass.toLowerCase().equals("feline"))
            		td.numberOfLives = 5+9;
            	else
            		td.numberOfLives = 5;
            	
                graphics.worldCreaterScreen = false;
                graphics.mainMenuScreen = false;
                graphics.optionsScreen = false;
                graphics.difficultyScreen = false;
                graphics.worldSelectorScreen = false;
                graphics.gameScreen = true;
                graphics.loginScreen = false;
                graphics.characterTypeScreen = false;
                graphics.helpMenu = false;
                
                if(!graphics.customMusic){
                	graphics.music1.stop();
                	graphics.music1 = new PlayMusic1(td.musicVolume, "Sounds\\App Audio - Pause Menu 2.wav");
                }
                
                graphics.repaint();
            } 
        });
        graphics.upgrade.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	
            	if(td.money >= graphics.towerToPrintStats.upgradeCost){
            		td.money -= graphics.towerToPrintStats.upgradeCost;
            		if(graphics.towerToPrintStats.type.equals("normalTower"))
            			new UpgradeNormalTower(graphics.towerToPrintStats);
            		if(graphics.towerToPrintStats.type.equals("splashTower"))
            			new UpgradeSplashTower(graphics.towerToPrintStats);
            	}
            	
                graphics.repaint();
            } 
        }); 
        graphics.sell.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
            	
            	while(td.iteratingThuTowers);
            	
            	td.towers.remove(graphics.towerToPrintStats);
            	td.money += graphics.towerToPrintStats.resell;
            	new AddRemoveThingstToPaint(false, true, false, graphics.towerToPrintStats, td.graphics); 
            	graphics.showTowerStats = false;
                graphics.repaint();
            } 
        }); 
	}
}
