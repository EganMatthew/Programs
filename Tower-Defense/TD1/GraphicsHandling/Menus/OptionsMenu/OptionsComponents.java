package Menus.OptionsMenu;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JSlider;

import GameController.Game;
import GraphicsController.Graphics;

public class OptionsComponents {
	
	public OptionsComponents(Graphics graphics, Game game){
		
		graphics.optionsPanel.setLayout(null);
		graphics.optionsPanel.setSize(500, 250);
    	graphics.optionsPanel.setLocation(50, 120);
    	graphics.optionsPanel.setBackground(Color.BLACK);
		
    	graphics.masterVolume = new JSlider(JSlider.HORIZONTAL, 0, 100, 100);
    	graphics.soundVolume = new JSlider(JSlider.HORIZONTAL, 0, (int)(game.masterVolume*100), (int)(game.soundVolume*100));
    	graphics.musicVolume = new JSlider(JSlider.HORIZONTAL, 0, (int)(game.masterVolume*100), (int)(game.musicVolume*100));
    	
    	graphics.masterVolumeLabel.setFont(graphics.font);
    	graphics.masterVolumeLabel.setForeground(Color.white);
    	graphics.masterVolumeLabel.setLocation(10, 35);
    	graphics.masterVolumeLabel.setSize(225, 25);
    	graphics.masterVolumeLabel.setText("Master Volume");

		graphics.masterVolume.setMajorTickSpacing(10);
		graphics.masterVolume.setMinorTickSpacing(1);
		graphics.masterVolume.setPaintTicks(true);
		graphics.masterVolume.setPaintLabels(true);
		graphics.masterVolume.setSize(300, 100);
		graphics.masterVolume.setLocation(175, 10);
		graphics.masterVolume.setBackground(Color.black);
		graphics.masterVolume.setForeground(Color.white);
    	
    	graphics.musicVolumeLabel.setFont(graphics.font);
    	graphics.musicVolumeLabel.setForeground(Color.white);
    	graphics.musicVolumeLabel.setLocation(10, 115);
    	graphics.musicVolumeLabel.setSize(225, 25);
    	graphics.musicVolumeLabel.setText("Music Volume");

		graphics.musicVolume.setMajorTickSpacing(10);
		graphics.musicVolume.setMinorTickSpacing(1);
		graphics.musicVolume.setPaintTicks(true);
		graphics.musicVolume.setPaintLabels(true);
		graphics.musicVolume.setSize(300, 100);
		graphics.musicVolume.setLocation(175, 90);
		graphics.musicVolume.setBackground(Color.black);
		graphics.musicVolume.setForeground(Color.white);
		
		graphics.soundVolumeLabel.setFont(graphics.font);
    	graphics.soundVolumeLabel.setForeground(Color.white);
    	graphics.soundVolumeLabel.setLocation(10, 195);
    	graphics.soundVolumeLabel.setSize(225, 25);
    	graphics.soundVolumeLabel.setText("Sound Volume");
    	
    	graphics.soundVolume = new JSlider(JSlider.HORIZONTAL, 0, 100, (int)(game.musicVolume*100));
		graphics.soundVolume.setMajorTickSpacing(10);
		graphics.soundVolume.setMinorTickSpacing(1);
		graphics.soundVolume.setPaintTicks(true);
		graphics.soundVolume.setPaintLabels(true);
		graphics.soundVolume.setSize(300, 100);
		graphics.soundVolume.setLocation(175, 180);
		graphics.soundVolume.setBackground(Color.black);
		graphics.soundVolume.setForeground(Color.white);

		
		graphics.optionsPanel.add(graphics.musicVolume);
		graphics.optionsPanel.add(graphics.musicVolumeLabel);
		graphics.optionsPanel.add(graphics.masterVolume);
		graphics.optionsPanel.add(graphics.masterVolumeLabel);
		graphics.optionsPanel.add(graphics.soundVolumeLabel);
		graphics.optionsPanel.add(graphics.soundVolume);
		graphics.add(graphics.optionsPanel);
		
		graphics.choose = new JButton("Browse");
		graphics.choose.setFont(graphics.font);
		graphics.choose.setSize(100, 25);
		graphics.choose.setLocation(650, 155);
		graphics.choose.setVisible(false);
		graphics.add(graphics.choose);
		
		graphics.customNormalCreep = new JButton("Browse");
		graphics.customNormalCreep.setFont(graphics.font);
		graphics.customNormalCreep.setSize(100, 25);
		graphics.customNormalCreep.setLocation(650, 185);
		graphics.customNormalCreep.setVisible(false);
		graphics.add(graphics.customNormalCreep);
		
		graphics.customFastCreep = new JButton("Browse");
		graphics.customFastCreep.setFont(graphics.font);
		graphics.customFastCreep.setSize(100, 25);
		graphics.customFastCreep.setLocation(650, 215);
		graphics.customFastCreep.setVisible(false);
		graphics.add(graphics.customFastCreep);
		
		graphics.customBossCreep = new JButton("Browse");
		graphics.customBossCreep.setFont(graphics.font);
		graphics.customBossCreep.setSize(100, 25);
		graphics.customBossCreep.setLocation(650, 245);
		graphics.customBossCreep.setVisible(false);
		graphics.add(graphics.customBossCreep);
		
		graphics.customFlyingCreep = new JButton("Browse");
		graphics.customFlyingCreep.setFont(graphics.font);
		graphics.customFlyingCreep.setSize(100, 25);
		graphics.customFlyingCreep.setLocation(650, 275);
		graphics.customFlyingCreep.setVisible(false);
		graphics.add(graphics.customFlyingCreep);
		
		graphics.customNormalTower = new JButton("Browse");
		graphics.customNormalTower.setFont(graphics.font);
		graphics.customNormalTower.setSize(100, 25);
		graphics.customNormalTower.setLocation(650, 305);
		graphics.customNormalTower.setVisible(false);
		graphics.add(graphics.customNormalTower);
		
		graphics.customSplashTower = new JButton("Browse");
		graphics.customSplashTower.setFont(graphics.font);
		graphics.customSplashTower.setSize(100, 25);
		graphics.customSplashTower.setLocation(650, 335);
		graphics.customSplashTower.setVisible(false);
		graphics.add(graphics.customSplashTower);
		
		graphics.highscores = new JButton("High scores");
		graphics.highscores.setFont(graphics.font);
		graphics.highscores.setSize(250, 25);
		graphics.highscores.setLocation(500, 400);
		graphics.highscores.setVisible(false);
		graphics.add(graphics.highscores);
	}

}
