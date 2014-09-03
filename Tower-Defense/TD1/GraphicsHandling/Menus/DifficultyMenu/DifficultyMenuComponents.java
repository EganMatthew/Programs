package Menus.DifficultyMenu;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import GraphicsController.Graphics;

public class DifficultyMenuComponents {
	
	public DifficultyMenuComponents(Graphics graphics){
		final ImageIcon ysae = new ImageIcon("images\\easy.png");
		final ImageIcon ysaesel = new ImageIcon("images\\easysel.png"); 
        graphics.easy = new JButton(); 
        graphics.easy.setSize(370, 170); 
        graphics.easy.setIcon(ysae); 
        graphics.easy.setLocation(220, 105);
        graphics.easy.setVisible(false);
        graphics.easy.setBorderPainted(false);
        graphics.easy.setContentAreaFilled(false);
        graphics.easy.setRolloverIcon(ysaesel);
        graphics.add(graphics.easy);
        
        final ImageIcon muidem = new ImageIcon("images\\medium.png"); 
        final ImageIcon muidemsel = new ImageIcon("images\\mediumsel.png"); 
        graphics.medium = new JButton(); 
        graphics.medium.setSize(370, 170); 
        graphics.medium.setIcon(muidem); 
        graphics.medium.setLocation(220, 205);
        graphics.medium.setVisible(false);
        graphics.medium.setBorderPainted(false);
        graphics.medium.setContentAreaFilled(false);
        graphics.medium.setRolloverIcon(muidemsel);
        graphics.add(graphics.medium); 
        
        final ImageIcon drah = new ImageIcon("images\\hard.png");
        final ImageIcon drahsel = new ImageIcon("images\\hardsel.png"); 
        graphics.hard = new JButton(); 
        graphics.hard.setSize(370, 170); 
        graphics.hard.setIcon(drah); 
        graphics.hard.setLocation(220, 305);
        graphics.hard.setVisible(false);
        graphics.hard.setBorderPainted(false);
        graphics.hard.setContentAreaFilled(false);
        graphics.hard.setRolloverIcon(drahsel);
        graphics.add(graphics.hard); 
	}

}
