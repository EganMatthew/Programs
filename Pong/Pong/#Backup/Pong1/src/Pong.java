import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Pong extends Applet implements KeyListener, Runnable{
	
//MAINMENU VARIABLES************
	Image mainMenuBackground; //*
	Image[] beam;		  	  //*
	Image[] beamCorner;		  //*
	Image[] alphabet;		  //*
	Image[] number;			  //*
	Image arrow;			  //*
	MainMenu mainMenu;		  //*
	PlayingField playingField;//*
	boolean mainMenuActive;	  //*
	boolean gameActive;		  //*
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
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		startTime = 0;
		endTime = 0;
		framePeriod = 25;
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		g = buffer.getGraphics();
		thread = new Thread(this);
		thread.start();
		
		mainMenuBackground = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/MainMenuBackground.png");
		arrow = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/SmallArrow.png");
		alphabet = new Image[10];
		alphabet[0] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/CapP.png");
		alphabet[1] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/CapO.png");
		alphabet[2] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/CapN.png");
		alphabet[3] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/CapG.png");
		alphabet[4] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/SmallCapP.png");
		alphabet[5] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/SmallCapL.png");
		alphabet[6] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/SmallCapA.png");
		alphabet[7] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/SmallCapY.png");
		alphabet[8] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/SmallCapE.png");
		alphabet[9] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/SmallCapR.png");
		
		beam = new Image[2];
		beam[0] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/Beam1.png");
		beam[1] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/Beam2.png");
		
		number = new Image[2];
		number[0] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/SmallOne.png");
		number[1] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/SmallTwo.png");
		
		beamCorner = new Image[4];
		beamCorner[0] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/BeamCorner1.png");
		beamCorner[1] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/BeamCorner2.png");
		beamCorner[2] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/BeamCorner3.png");
		beamCorner[3] = Toolkit.getDefaultToolkit().getImage("C:/Users/Mammoth/workspace/Pong/bin/BeamCorner4.png");
		
		
		mainMenu = new MainMenu(mainMenuBackground, beam, beamCorner, alphabet, arrow, number, this);
		
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
			mainMenu.paint(g);
		if(gameActive)
			playingField.paint(g);
		
		
		gfx.drawImage(buffer, 0, 0, this);

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
			if(mainMenuActive){
				mainMenu.increaseYPosition();
			}
		}
		
		
		else if(e.getKeyCode() == DOWN){
			if(mainMenuActive){
				mainMenu.decreaseYPosition();
			}
		}
		
		
		
		else if(e.getKeyCode() == ENTER){
			if(mainMenuActive){
				if(mainMenu.currentYPosition == 0){
					mainMenu.onePlayerSelected = true;
				}
				else if(mainMenu.currentYPosition == 1){
					mainMenu.twoPlayerSelected = true;
					mainMenuActive = false;
					gameActive = true;
					playingField= new PlayingField(mainMenuBackground, beam, beamCorner, this);
				}
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
