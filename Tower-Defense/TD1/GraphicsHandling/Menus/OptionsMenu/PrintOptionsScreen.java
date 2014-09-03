package Menus.OptionsMenu;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import GraphicsController.Graphics;

public class PrintOptionsScreen {
	
	public PrintOptionsScreen(Graphics graphics, java.awt.Graphics g){
		g.drawImage(graphics.background3, 0, 0, null);
    	//g.drawImage(graphics.optionsImage, 250, 25, null);
    	
    	graphics.optionsPanel.setVisible(true);
    	graphics.choose.setVisible(true);
    	graphics.customNormalCreep.setVisible(true);
		graphics.customFastCreep.setVisible(true);
		graphics.customBossCreep.setVisible(true);
		graphics.customFlyingCreep.setVisible(true);
		graphics.customNormalTower.setVisible(true);
		graphics.customSplashTower.setVisible(true);
		
		graphics.highscores.setVisible(true);

    	graphics.menu.setLocation(20, 520);
    	graphics.menu.setVisible(true);
    	g.drawImage(graphics.skullMusic, 57, 387, null);
    	
    	g.setColor(Color.black);
    	g.fillRect(540, 150, 150, 300);
    	g.setColor(Color.red);
    	g.setFont(graphics.font);
    	g.drawString("Music:", 570, 175);
    	g.drawString("NormCrp:", 570, 205);
    	g.drawString("FstCrp:", 570, 235);
    	g.drawString("BossCrp:", 570, 265);
    	g.drawString("FlyCrp:", 570, 295);
    	
    	g.drawString("NormTwr:", 570, 325);
    	g.drawString("SpshTwr:", 570, 355);
    	
    	//graphics.choose = null;
	}

}
