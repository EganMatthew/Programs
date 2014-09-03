package Menus.LoginMenu;

import java.awt.Color;

import javax.swing.JButton;

import GraphicsController.Graphics;

public class CreateLoginComponents {
	
	public CreateLoginComponents(Graphics graphics){
		
		graphics.loginPanel.setLayout(null);

		graphics.loginPanel.setSize(400, 150);
    	graphics.loginPanel.setLocation(202, 256);
    	graphics.loginPanel.setBackground(Color.black);
    	
    	graphics.usernameL.setFont(graphics.font);
    	graphics.usernameL.setForeground(Color.white);
    	graphics.usernameL.setLocation(40, 50);
    	graphics.usernameL.setSize(100, 25);
    	
    	graphics.username.setFont(graphics.font);
    	graphics.username.setLocation(160, 50);
    	graphics.username.setSize(200, 25);
    	
    	graphics.login.setSize(150, 25); 
    	graphics.login.setText("Login");
        graphics.login.setFont(graphics.font);
        graphics.login.setLocation(25, 100);
        
        
        graphics.register.setSize(150, 25); 
        graphics.register.setText("Register");
        graphics.register.setFont(graphics.font);
        graphics.register.setLocation(220, 100);
        
        graphics.errorMessage.setFont(graphics.font);
        graphics.errorMessage.setForeground(Color.red);
        graphics.errorMessage.setSize(400, 300);
        graphics.errorMessage.setLocation(60, -130);
        graphics.errorMessage.setText("*Error: username conflict*");
                
        
        graphics.loginPanel.add(graphics.login);
        graphics.loginPanel.add(graphics.register);
    	graphics.loginPanel.add(graphics.username);
        graphics.loginPanel.add(graphics.usernameL);
        graphics.loginPanel.add(graphics.errorMessage);
        graphics.add(graphics.loginPanel);
	}

}
