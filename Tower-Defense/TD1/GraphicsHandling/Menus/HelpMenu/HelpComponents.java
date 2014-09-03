package Menus.HelpMenu;

import java.awt.Color;

import javax.swing.JPanel;

import GraphicsController.Graphics;

public class HelpComponents{
	
	public HelpComponents(final Graphics graphics){
	
		
		graphics.helpPanel = new JPanel(){
    		
    		public void paintComponent(java.awt.Graphics g){
    			super.paintComponent(g);
    			
    			g.setColor(Color.white);
    	    	g.setFont(graphics.font);
    			
    			g.drawString("Rules for WORLD EDITOR", 25, 100);
    	    	g.drawString("Path START ALWAYS occurs on map edge", 25, 125);
    	    	g.drawString("Path START NEVER occurs on map corner", 25, 150);
    	    	g.drawString("Path END ALWAYS uses the map end tile", 25, 175);
    	    	g.drawString("MULTIPLE paths allowed", 25, 200);
    	    	g.drawString("Paths MUST NOT start on the same edge", 25, 225);
    	    	g.drawString("Paths may NOT cross to form a loop", 25, 250);
    	    	g.drawString("MAXIMUM of 4 paths", 25, 275);
    	    	
    		}
    		
    	};
		
		graphics.helpPanel.setLayout(null);
		graphics.helpPanel.setSize(500, 350);
    	graphics.helpPanel.setLocation(50, 50);
    	graphics.helpPanel.setBackground(Color.black);
    	
    	graphics.add(graphics.helpPanel);
	}
}
