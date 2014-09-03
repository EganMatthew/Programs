package GlobalComponents;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import GraphicsController.Graphics;

public class GlobalComponents {
	
	public GlobalComponents(Graphics graphics){

        final ImageIcon b5 = new ImageIcon("images\\menu.png"); 
        final ImageIcon z6 = new ImageIcon("images\\menuselection.png");
        graphics.menu = new JButton(); 
        graphics.menu.setSize(183, 70); 
        graphics.menu.setIcon(b5); 
        graphics.menu.setLocation(580, 220);
        graphics.menu.setOpaque(false);
        graphics.menu.setFocusPainted(false);
        graphics.menu.setBorderPainted(false);
        graphics.menu.setContentAreaFilled(false);
        graphics.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        graphics.menu.setVisible(false);
        graphics.menu.setRolloverIcon(z6);
        graphics.add(graphics.menu);
        
	}

}
