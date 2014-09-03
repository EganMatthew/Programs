package Menus.CharacterMenu;

import java.awt.Color;

import GraphicsController.Graphics;

public class CreateCharacterComponenets {
	
	public CreateCharacterComponenets(Graphics graphics){
		
		graphics.characterPanel.setLayout(null);
		
		graphics.characterPanel.setSize(400, 300);
    	graphics.characterPanel.setLocation(203, 169);
    	graphics.characterPanel.setBackground(Color.black);

		graphics.money.setFont(graphics.font);
		graphics.money.setText("<html>MONEY PERK<br>+15% money</html>");
		graphics.money.setSize(255, 70); 
		graphics.money.setBackground(Color.white);
		graphics.money.setLocation(75, 25);
		graphics.money.setFocusPainted(false);
		
		graphics.damage.setFont(graphics.font);
		graphics.damage.setText("<html>DAMAGE PERK<br>+15% damage</html>");
		graphics.damage.setSize(255, 70); 
		graphics.damage.setBackground(Color.white);
		graphics.damage.setLocation(75, 115);
		graphics.damage.setFocusPainted(false);
		
		graphics.feline.setFont(graphics.font);
		graphics.feline.setText("<html>9 LIVES PERK<br>&nbsp&nbsp+9 lives</html>");
		graphics.feline.setSize(255, 70); 
		graphics.feline.setBackground(Color.white);
		graphics.feline.setLocation(75, 205);
		graphics.feline.setFocusPainted(false);
		
		graphics.characterPanel.add(graphics.money);
		graphics.characterPanel.add(graphics.damage);
		graphics.characterPanel.add(graphics.feline);
		graphics.add(graphics.characterPanel);
	}

}
