package Menus.WorldEditorMenu;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import GraphicsController.Graphics;

public class WorldEditorComponents {
	
	public WorldEditorComponents(Graphics graphics){
		final ImageIcon b1 = new ImageIcon("images\\red.png"); 
    	graphics.red = new JButton(); 
    	graphics.red.setSize(28, 28); 
    	graphics.red.setIcon(b1); 
    	graphics.red.setLocation(655, 195);
        graphics.red.setVisible(false);
        graphics.add(graphics.red);
        
        final ImageIcon b2 = new ImageIcon("images\\gray.png"); 
        graphics.gray = new JButton(); 
        graphics.gray.setSize(28, 28); 
        graphics.gray.setIcon(b2); 
        graphics.gray.setLocation(655, 250);
        graphics.gray.setVisible(false);
        graphics.add(graphics.gray);
        
        final ImageIcon b3 = new ImageIcon("images\\white.png"); 
        graphics.white = new JButton(); 
        graphics.white.setSize(28, 28); 
        graphics.white.setIcon(b3); 
        graphics.white.setLocation(655, 315);
        graphics.white.setVisible(false);
        graphics.add(graphics.white);
        
        final ImageIcon b4 = new ImageIcon("images\\save.png"); 
        final ImageIcon z5 = new ImageIcon("images\\saveselection.png");
        graphics.save = new JButton(); 
        graphics.save.setSize(183, 70); 
        graphics.save.setIcon(b4); 
        graphics.save.setLocation(609, 463);
        graphics.save.setOpaque(false);
        graphics.save.setFocusPainted(false);
        graphics.save.setBorderPainted(false);
        graphics.save.setContentAreaFilled(false);
        graphics.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        graphics.save.setVisible(false);
        graphics.save.setRolloverIcon(z5);
        graphics.add(graphics.save);
	}

}
