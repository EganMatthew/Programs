package Menus.WorldSelectorMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import EventListeners.PlaySound1;
import GraphicsController.Graphics;

public class AddItemToScrollMenu {
	
	public AddItemToScrollMenu(final Graphics graphics, final String[][] colorGrid){
		graphics.numberOfScrollItems++;
			
    	JPanel test = new JPanel(){
    		
    		public void paintComponent(java.awt.Graphics g){
    			super.paintComponent(g);
    			for(int i = 0; i < 21; i++){
    				for(int j = 0; j < 18; j++){
    					if(colorGrid[i][j] == null || colorGrid[i][j].equals("white"))
	    					g.setColor(Color.white);
    					else if(colorGrid[i][j].equals("gray"))
	    					g.setColor(Color.gray);
	    				else if(colorGrid[i][j].equals("red"))
	    					g.setColor(Color.red);
	    				
	    				g.fillRect(i*5, j*5, 4, 4);
    				}
    			}
    	    }
    		
    	};
    	test.setBackground(Color.black);
        test.setMaximumSize(new Dimension(500, 90));
        test.setPreferredSize(new Dimension(300, 90));
    	test.setLayout(null);
		final ImageIcon h1 = new ImageIcon("images\\select.png");
    	final ImageIcon g1 = new ImageIcon("images\\selectselection.png");
        final JButton select = new JButton();
        select.setName(graphics.numberOfScrollItems.toString());
        
        select.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
            	graphics.selectedScrollItem = Integer.parseInt(select.getName());
            	graphics.worldCreaterScreen = false;
                graphics.mainMenuScreen = false;
                graphics.optionsScreen = false;
                graphics.difficultyScreen = true;
                graphics.worldSelectorScreen = false;
                graphics.gameScreen = false;
                graphics.characterTypeScreen = false;
                graphics.loginScreen = false;
            	graphics.repaint(); 
            } 
        });
        
        select.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {
				new PlaySound1(graphics.game.soundVolume);
			}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
    	});
        
        select.setSize(135, 80);
        select.setIcon(h1);
        select.setLocation(120, 10);
        //select.setVisible(false);
        select.setOpaque(false);
        select.setFocusPainted(false);
        select.setBorderPainted(false);
        select.setContentAreaFilled(false);
        graphics.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        select.setRolloverIcon(g1);
        test.add(select);
    	
        graphics.panel.add(test);
        graphics.panel.add( Box.createVerticalStrut(20) );
		
	}
}
