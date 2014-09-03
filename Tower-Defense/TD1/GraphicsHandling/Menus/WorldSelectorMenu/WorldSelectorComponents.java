package Menus.WorldSelectorMenu;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import GraphicsController.Graphics;

public class WorldSelectorComponents {
	
	public WorldSelectorComponents(Graphics graphics){
		
		final ImageIcon b4 = new ImageIcon("images\\load.png"); 
	    final ImageIcon z5 = new ImageIcon("images\\loadselection.png");
	    graphics.load = new JButton(); 
	    graphics.load.setSize(225, 70); 
	    graphics.load.setIcon(b4); 
	    graphics.load.setLocation(580, 150);
	    graphics.load.setOpaque(false);
	    graphics.load.setFocusPainted(false);
	    graphics.load.setBorderPainted(false);
	    graphics.load.setContentAreaFilled(false);
	    graphics.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
	    graphics.load.setVisible(false);
	    graphics.load.setRolloverIcon(z5);
	    graphics.add(graphics.load);
		
	}

}
