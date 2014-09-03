package Menus.MainMenu;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import GraphicsController.Graphics;

public class MainMenuComponents {
	
	public MainMenuComponents(Graphics graphics){
		
		final ImageIcon a1 = new ImageIcon("images\\play.png");
    	final ImageIcon z1 = new ImageIcon("images\\playselection.png");
        graphics.play = new JButton(); 
        graphics.play.setSize(425, 70);
        graphics.play.setIcon(a1);
        graphics.play.setLocation(188, 155);
        graphics.play.setVisible(false);
        graphics.play.setOpaque(false);
        graphics.play.setFocusPainted(false);
        graphics.play.setBorderPainted(false);
        graphics.play.setContentAreaFilled(false);
        graphics.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        graphics.play.setRolloverIcon(z1);
        graphics.play.setText(null);
        graphics.add(graphics.play);
        
        final ImageIcon a2 = new ImageIcon("images\\worldeditor.png");
        final ImageIcon z2 = new ImageIcon("images\\worldcreatorselection.png");
        graphics.worldcreater = new JButton("World Creator"); 
        graphics.worldcreater.setSize(425, 90); 
        graphics.worldcreater.setIcon(a2); 
        graphics.worldcreater.setLocation(190, 230);
        graphics.worldcreater.setVisible(false);
        graphics.worldcreater.setOpaque(false);
        graphics.worldcreater.setFocusPainted(false);
        graphics.worldcreater.setBorderPainted(false);
        graphics.worldcreater.setContentAreaFilled(false);
        graphics.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        graphics.worldcreater.setRolloverIcon(z2);
        graphics.worldcreater.setText(null);
        graphics.add(graphics.worldcreater);
        
        final ImageIcon a3 = new ImageIcon("images\\options.png");
        final ImageIcon z3 = new ImageIcon("images\\optionsselection.png");
        graphics.options = new JButton("graphics.options"); 
        graphics.options.setSize(425, 70); 
        graphics.options.setIcon(a3); 
        graphics.options.setLocation(190, 325);
        graphics.options.setVisible(false);
        graphics.options.setOpaque(false);
        graphics.options.setFocusPainted(false);
        graphics.options.setBorderPainted(false);
        graphics.options.setContentAreaFilled(false);
        graphics.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        graphics.options.setRolloverIcon(z3);
        graphics.options.setText(null);
        graphics.add(graphics.options);
        
        final ImageIcon a5 = new ImageIcon("images\\help.png");
        final ImageIcon z5 = new ImageIcon("images\\helpselection.png");
        graphics.help = new JButton("graphics.options"); 
        graphics.help.setSize(283, 210); 
        graphics.help.setIcon(a5); 
        graphics.help.setLocation(510, 370);
        graphics.help.setVisible(false);
        graphics.help.setOpaque(false);
        graphics.help.setFocusPainted(false);
        graphics.help.setBorderPainted(false);
        graphics.help.setContentAreaFilled(false);
        graphics.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        graphics.help.setRolloverIcon(z5);
        graphics.help.setText(null);
        graphics.add(graphics.help);
        
        final ImageIcon a4 = new ImageIcon("images\\exit.png");
        final ImageIcon z4 = new ImageIcon("images\\exitselection.png");
        graphics.exit = new JButton("graphics.exit"); 
        graphics.exit.setSize(425, 70); 
        graphics.exit.setIcon(a4); 
        graphics.exit.setLocation(190, 410);
        graphics.exit.setVisible(false);
        graphics.exit.setOpaque(false);
        graphics.exit.setFocusPainted(false);
        graphics.exit.setBorderPainted(false);
        graphics.exit.setContentAreaFilled(false);
        graphics.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        graphics.exit.setRolloverIcon(z4);
        graphics.exit.setText(null);
        graphics.add(graphics.exit);
		
	}

}
