import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Pong extends Applet implements KeyListener, Runnable{
	
//MAINMENU VARIABLES************
	Image[][] Layer1;
	Image[][] Layer2;
	Image[] tiles;
	Image arrow;			  
	MainMenu mainMenu;		  
	PlayingField playingField;
	boolean mainMenuActive;	  
	boolean gameActive;
//******************************
//CONTROL VARIABLES************************
	int ENTER = KeyEvent.VK_ENTER;		//*
	int UP = KeyEvent.VK_UP;			//*
	int DOWN = KeyEvent.VK_DOWN;		//*
//*****************************************
	long startTime, endTime, framePeriod;
	Thread thread;
	BufferedImage buffer;
	Graphics g;
	
	public Pong(){
		startTime = 0;
		endTime = 0;
		framePeriod = 25;
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		g = buffer.getGraphics();
		thread = new Thread(this);
		thread.start();
		
		
		
		tiles = new Image[4];
		tiles[0] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/Tile1.png");
		tiles[1] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/Tile2.png");
		tiles[2] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/Tile3.png");
		tiles[3] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/Tile4.png");
		Layer1 = new Image[160][120];
		Layer2 = new Image[160][120];
		
		
		mainMenu = new MainMenu(this);
		mainMenuActive = true;
		gameActive = false;
		addKeyListener(this);
	}
	
	

	public static void main(String[] args){
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pong pong = new Pong();
		window.getContentPane().add(pong, BorderLayout.CENTER);
		window.setSize(new Dimension(800, 600));
		//window.setExtendedState(Frame.MAXIMIZED_BOTH);
		//window.setUndecorated(true);
		window.setVisible(true);

	}

	
	public void paint(Graphics gfx) {
		if(mainMenuActive)
			mainMenu.paint(this);
		if(gameActive)
			playingField.paint(this);
		
		gfx.drawImage(buffer, 0, 0, this);
		buffer.flush();

	}
	
	public void start(){
		
	}
	
	public void stop(){
		//Pause the game
	}
	
	public void destroy(){
		//if in a saveable location - save in the autosave slot
	}
	
	public void update(Graphics gfx){
		paint(gfx);
	}


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == UP){
			if(gameActive){
				playingField.player1.moveUp(this);
			}
		}
		
		
		else if(e.getKeyCode() == DOWN){
			if(gameActive){
				playingField.player1.moveDown(this);
			}
		}
		
		else if(e.getKeyCode() == ENTER){
			if(mainMenuActive){
				playingField = new PlayingField(this);
				mainMenuActive = false;
				gameActive = true;
			}
		}		
	}


	public void keyReleased(KeyEvent e) {
		
	}


	public void keyTyped(KeyEvent e) {

		
	}


	public void run(){	
		for(;;){
			startTime = System.currentTimeMillis();
			repaint();
			
			try{
				endTime = System.currentTimeMillis();
				if(framePeriod - (endTime - startTime) > 0)
					Thread.sleep(framePeriod - (endTime - startTime));
			}catch(InterruptedException e){
			}
		}
		
	}


}
