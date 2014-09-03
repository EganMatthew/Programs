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
	Image[][] Layer3;
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
	
	boolean upActive, downActive, wActive, sActive, enterActive;
	
	public Pong(){
		startTime = 0;
		endTime = 0;
		framePeriod = 25;
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		g = buffer.getGraphics();
		thread = new Thread(this);
		thread.start();
		
		upActive = false;
		downActive = false;
		wActive = false;
		sActive = false;
		enterActive = false;
		
		tiles = new Image[4];
		tiles[0] = Toolkit.getDefaultToolkit().getImage("Tile1.png");
		tiles[1] = Toolkit.getDefaultToolkit().getImage("Tile2.png");
		tiles[2] = Toolkit.getDefaultToolkit().getImage("Tile3.png");
		tiles[3] = Toolkit.getDefaultToolkit().getImage("Tile4.png");
		Layer1 = new Image[160][120];
		Layer2 = new Image[160][120];
		Layer3 = new Image[160][120];
		initializeLayers();
		
		
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
	
	public void initializeLayers(){
		for(int i = 0; i < 160; i++){
			for(int j = 0; j < 120; j++){
				Layer1[i][j] = tiles[0];
				Layer2[i][j] = tiles[3];
				Layer3[i][j] = tiles[3];
			}
		}
	}
	
	public void start(){}
	public void stop(){}
	public void destroy(){}
	public void update(Graphics gfx){paint(gfx);}
	public void keyTyped(KeyEvent e) {}


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == UP)
			upActive = true;	
		if(e.getKeyCode() == KeyEvent.VK_W)
			wActive = true;
		if(e.getKeyCode() == KeyEvent.VK_S)
			sActive = true;		
		if(e.getKeyCode() == DOWN)
			downActive = true;
		if(e.getKeyCode() == ENTER)
			enterActive = true;
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == UP)
			upActive = false;		
		if(e.getKeyCode() == KeyEvent.VK_W)
			wActive = false;		
		if(e.getKeyCode() == KeyEvent.VK_S)
			sActive = false;		
		if(e.getKeyCode() == DOWN)
			downActive = false;
		if(e.getKeyCode() == ENTER)
			enterActive = false;
	}
	
	public void preformAction(){
		if(upActive){
			if(gameActive){
				playingField.player1.moveUp(this);
				if(wActive)
					playingField.player2.moveUp(this);
				if(sActive)
					playingField.player2.moveDown(this);
			}
		}
		
		if(wActive){
			if(gameActive){
				playingField.player2.moveUp(this);
				if(upActive)
					playingField.player1.moveUp(this);
				if(downActive)
					playingField.player1.moveDown(this);
			}
		}
		
		if(sActive){
			if(gameActive){
				playingField.player2.moveDown(this);
				if(downActive)
					playingField.player1.moveDown(this);
				if(upActive)
					playingField.player1.moveUp(this);
			}
		}
		
		if(downActive){
			if(gameActive){
				playingField.player1.moveDown(this);
				if(sActive)
					playingField.player2.moveDown(this);
				if(wActive)
					playingField.player2.moveUp(this);
			}
		}
		
		if(enterActive){
			if(mainMenuActive){
				playingField = new PlayingField(this);
				mainMenuActive = false;
				gameActive = true;
			}
		}
	}


	public void run(){	
		for(;;){
			startTime = System.currentTimeMillis();
			preformAction();
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
