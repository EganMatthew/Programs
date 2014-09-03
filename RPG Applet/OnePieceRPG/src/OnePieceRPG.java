import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;




public class OnePieceRPG extends Applet implements KeyListener, Runnable {
	
	MainMenu mainMenu;
	CharacterCreator characterCreator;
	Character currentPartyInControl;
	Character Luffy;
	Character Luffy2;
	Character Luffy3;
	Character Luffy4;
	Settings settings;
	GameSettings gameSettings;
	LoadGame loadGame;
	Scene1 scene1;
	Battle battle;
	MenuX menuX;
	Image mainMenuBackground, arrow, arrow2, characterBackground, sceneOneBackground;
	Image settingsBackground, settingsFill, battleBackground, menuXBackground, gameSettingsBackground;
	Image frame;
	Image[] luffySprite;
	Image[] luffyPortrait;
	Image[] luffyRegularAttack;
	Image[] luffyAttackExtras;
	Image[] monsters;
	Image loadGameBackground, loadGameMenuArrow;
	Image cursor, backspace, imageToShake;
	char[] defaultLetters;
	Image buffer;
	boolean gameActive, mainMenuActive, settingsActive, loadGameActive, newGameActive, sceneOneActive, fadeActive;
	boolean validName, shakeActive, controlsActive, battleActive, menuXActive, gameSettingsActive;
	boolean characterCurrentlyWalking;
	long startTime, endTime, framePeriod;
	Thread thread;
	Dimension dim;
	Graphics g;
	Graphics2D fade;
	float alpha;
	int xShake, yShake, numberOfShakes;
	long shakeDelay;
	Random generator = new Random();

	
//==========================================================================
//CONTROLS:
	boolean upArrow, downArrow, leftArrow, rightArrow;
	boolean enterKey, escapeKey;
	
	int A = KeyEvent.VK_D;
	int B = KeyEvent.VK_S;
	int X = KeyEvent.VK_W;
	int Y = KeyEvent.VK_A;
	int START = KeyEvent.VK_ENTER;
	int SELECT = KeyEvent.VK_SPACE;
	int UP = KeyEvent.VK_UP;
	int DOWN = KeyEvent.VK_DOWN;
	int LEFT = KeyEvent.VK_LEFT;
	int RIGHT = KeyEvent.VK_RIGHT;
	int LTRIGGER = KeyEvent.VK_Q;
	int RTRIGGER = KeyEvent.VK_E;
	
	boolean activeOrWait;
	
	
	public void init(){
		System.out.println("Test");
		this.resize(1000, 550);
		mainMenuBackground = getImage(getDocumentBase(), getParameter("MainMenu"));
		settingsBackground = getImage(getDocumentBase(), getParameter("Settings"));
		settingsFill = getImage(getDocumentBase(), getParameter("SettingsFill"));
		arrow = getImage(getDocumentBase(), getParameter("Arrow"));
		arrow2 = getImage(getDocumentBase(), getParameter("Arrow2"));
		characterBackground = getImage(getDocumentBase(), getParameter("NewCharacter"));
		sceneOneBackground = getImage(getDocumentBase(), getParameter("SceneOneWorld"));
		frame = getImage(getDocumentBase(), getParameter("Frame"));
		cursor = getImage(getDocumentBase(), getParameter("Cursor"));
		backspace = getImage(getDocumentBase(), getParameter("Back_Space"));
		loadGameBackground = getImage(getDocumentBase(), getParameter("LoadGameMenu"));
		loadGameMenuArrow = getImage(getDocumentBase(), getParameter("LoadGameMenuArrow"));
		battleBackground = getImage(getDocumentBase(), getParameter("BattleBackground"));
		menuXBackground = getImage(getDocumentBase(), getParameter("MenuXBackground"));
		gameSettingsBackground = getImage(getDocumentBase(), getParameter("GameSettingsBackground"));
		
		luffySprite = new Image[20];
		luffySprite[0] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Down_0"));
		luffySprite[1] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Down_1"));
		luffySprite[2] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Down_2"));
		luffySprite[3] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Down_3"));
		luffySprite[4] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Down_4"));
		luffySprite[5] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Left_0"));
		luffySprite[6] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Left_1"));
		luffySprite[7] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Left_2"));
		luffySprite[8] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Left_3"));
		luffySprite[9] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Left_4"));
		luffySprite[10] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Right_0"));
		luffySprite[11] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Right_1"));
		luffySprite[12] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Right_2"));
		luffySprite[13] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Right_3"));
		luffySprite[14] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Right_4"));
		luffySprite[15] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Up_0"));
		luffySprite[16] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Up_1"));
		luffySprite[17] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Up_2"));
		luffySprite[18] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Up_3"));
		luffySprite[19] = getImage(getDocumentBase(), getParameter("Luffy_Walk_Up_4"));
		
		luffyPortrait = new Image[5];
		luffyPortrait[0] = getImage(getDocumentBase(), getParameter("LuffyHappy1"));
		luffyPortrait[1] = getImage(getDocumentBase(), getParameter("LuffyHappy2"));
		luffyPortrait[2] = getImage(getDocumentBase(), getParameter("LuffyAngry1"));
		luffyPortrait[3] = getImage(getDocumentBase(), getParameter("LuffyAngry2"));
		luffyPortrait[4] = getImage(getDocumentBase(), getParameter("LuffySad"));
		
		luffyRegularAttack = new Image[5];
		luffyRegularAttack[0] = getImage(getDocumentBase(), getParameter("LuffyRegularAttack0"));
		luffyRegularAttack[1] = getImage(getDocumentBase(), getParameter("LuffyRegularAttack1"));
		luffyRegularAttack[2] = getImage(getDocumentBase(), getParameter("LuffyRegularAttack2"));
		luffyRegularAttack[3] = getImage(getDocumentBase(), getParameter("LuffyRegularAttack3"));
		luffyRegularAttack[4] = getImage(getDocumentBase(), getParameter("LuffyRegularAttack4"));
		
		luffyAttackExtras = new Image[4];
		luffyAttackExtras[0] = getImage(getDocumentBase(), getParameter("LuffyArmExtension"));
		luffyAttackExtras[1] = getImage(getDocumentBase(), getParameter("LuffyRightFist"));
		luffyAttackExtras[2] = getImage(getDocumentBase(), getParameter("LuffyRightFist2"));
		luffyAttackExtras[3] = getImage(getDocumentBase(), getParameter("LuffyRegularAttackResult"));
		
		monsters = new Image[1];
		monsters[0] = getImage(getDocumentBase(), getParameter("Monster0"));
				
		defaultLetters = new char[7];
		defaultLetters[0] = 'L';
		defaultLetters[1] = 'u';
		defaultLetters[2] = 'f';
		defaultLetters[3] = 'f';
		defaultLetters[4] = 'y';
		defaultLetters[5] = ' ';
		defaultLetters[6] = ' ';

		mainMenu = new MainMenu(mainMenuBackground, arrow, 0, this);
		gameActive = false;
		mainMenuActive = true;
		loadGameActive = false;
		settingsActive = false;
		newGameActive = false;
		sceneOneActive = false;
		fadeActive = true;
		shakeActive = false;
		validName = true;
		controlsActive = false;
		battleActive = false;
		menuXActive = false;
		activeOrWait = false;
		characterCurrentlyWalking = false;
		gameSettingsActive = false;
		startTime = 0;
		endTime = 0;
		framePeriod = 25;
		dim = getSize();
		buffer = createImage(dim.width, dim.height);
		g = buffer.getGraphics();
		thread = new Thread(this);
		thread.start();
		alpha = 0.0f;
		addKeyListener(this);
		xShake = 0;
		yShake = 0;
		numberOfShakes = 5;
		shakeDelay = 0;
		upArrow = false;
		downArrow = false;
		rightArrow = false;
		leftArrow = false;
		enterKey = false;
		escapeKey = false;
	}
	
	public void start(){
		
	}
	
	public void stop(){
		//Pause the game
	}
	
	public void destroy(){
		//if in a saveable location - save in the autosave slot
	}

	public void paint(Graphics gfx){
		fade = (Graphics2D) gfx;
//==========================================================================	
		if(gameActive == false && mainMenuActive == true){
			fade(fadeActive);
			mainMenu.paint(g);
		}
//==========================================================================
		else if(gameActive == false && newGameActive == true){
			
			if(shakeActive == true)
				shake(gfx);
			else{
				fade(fadeActive);
				characterCreator.paint(g);
			}
		}
//==========================================================================
		else if(settingsActive == true){
			fade(fadeActive);
			settings.paint(g);
			
			if(shakeActive == true)
				shake(gfx);
		}
//==========================================================================
		else if(loadGameActive == true){
			fade(fadeActive);
			loadGame.paint(g);
		}
//==========================================================================		
		else if(gameActive == true && sceneOneActive == true){
			
			if(fadeActive == true){
				fade(fadeActive);			
				scene1.paint(g, gfx, buffer, scene1.getXPosition(), scene1.getYPosition());
			}
			
			if(scene1.getRandomBattle() < 0){
				battle = new Battle(battleBackground, frame, arrow, scene1, scene1.getXPosition(), scene1.getYPosition(), this, Luffy);
				sceneOneActive = false;
				battleActive = true;
				return;
			}
				
			characterCurrentlyWalking = false;
			scene1.paint(g, gfx, buffer, scene1.getXPosition(), scene1.getYPosition());
			scene1.setWalkDirection(null);
		}
//==========================================================================
		else if(battleActive){	
			if(fadeActive == true){
				fade(fadeActive);			
				battle.paint(g, gfx, buffer);
			}
			boolean temp;
			temp = battle.paint(g, gfx, buffer);
			
			if(temp){
				if(battle.object == scene1){
					battleActive = false;
					sceneOneActive = true;
					battle = null;
					scene1.setRandomBattle(generator.nextInt()%30);
				}
			}
		}
//==========================================================================
		else if(menuXActive){
			
			fade(fadeActive);			
			menuX.paint(g);
		}
//==========================================================================
		else if(gameSettingsActive){
			
			fade(fadeActive);
			gameSettings.paint(g);
		}
		
		gfx.drawImage(buffer, xShake, yShake, this);
	}
	
	public void update(Graphics gfx){
		paint(gfx);
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
	
//==========================================================================
//EVENT MANAGER:
//The purpose in checking !enterkey is as follows:
//The variables enterKey, upArrow, downArrow, leftArrow, and rightArrow
//are true when pressed down and false when released.
//
//The if(!enterkey) prevents arrows keys from being pressed while
//the enterKey is active. Any if statement involving these variables
//has the same idea behind it.
	public void keyPressed(KeyEvent e){

//==========================================================================
//ACTION: UP
			if(e.getKeyCode() == UP){
			upArrow = true;
				
				if(gameActive == false && mainMenuActive == true && !enterKey){
					mainMenu.decreaseYPosition();
				}
	//--------------------------------------------------------------
				else if(settingsActive == true && settings.getChangeControlsMode() == false && !enterKey){
					settings.setEnterPressed(false);
					settings.setDefaultSelected(false);
					settings.decreaseYPosition();
				}
				else if(gameSettingsActive && !enterKey && !gameSettings.getChangeOptionsMode()){
					gameSettings.decreaseYPosition();
					gameSettings.setEnterPressed(false);
				}
	//--------------------------------------------------------------				
				else if(gameActive == false && newGameActive == true && !enterKey){
					characterCreator.setEnterPressed(false);
					characterCreator.setBackspacePressed(false);
					characterCreator.setDefault(false);
					characterCreator.decreaseYPosition();
				}
				else if(gameActive == true && sceneOneActive == true && !downArrow && !leftArrow && !rightArrow && !characterCurrentlyWalking && !enterKey){
					scene1.decreaseRandomBattle();
					scene1.decreaseYPosition();
					characterCurrentlyWalking = true;
					scene1.setWalkDirection("UP");
				}
				else if(battleActive && !enterKey){
					battle.setEnterPressed(false);
					battle.decreaseYPosition();
				}
				else if(menuXActive && !enterKey){
					menuX.decreaseYPosition();
				}
				
				fadeActive = false;
			}
//==========================================================================
//ACTION: DOWN
			else if(e.getKeyCode() == DOWN){
			downArrow = true;
				
				if(gameActive == false && mainMenuActive == true && !enterKey){
					mainMenu.increaseYPosition();
				}
	//--------------------------------------------------------------
				else if(settingsActive == true && settings.getChangeControlsMode() == false && !enterKey){
					settings.setEnterPressed(false);
					settings.setDefaultSelected(false);
					settings.increaseYPosition();
				}
				else if(gameSettingsActive && !enterKey && !gameSettings.getChangeOptionsMode()){
					gameSettings.increaseYPosition();
					gameSettings.setEnterPressed(false);
				}
	//--------------------------------------------------------------			
				else if(gameActive == false && newGameActive == true && !enterKey){
					characterCreator.setEnterPressed(false);
					characterCreator.setBackspacePressed(false);
					characterCreator.setDefault(false);
					characterCreator.increaseYPosition();
				}
				else if(gameActive == true && sceneOneActive == true && !upArrow && !leftArrow && !rightArrow && !characterCurrentlyWalking && !enterKey){
					scene1.decreaseRandomBattle();
					scene1.increaseYPosition();
					characterCurrentlyWalking = true;
					scene1.setWalkDirection("DOWN");
				}
				else if(battleActive){
					battle.setEnterPressed(false);
					battle.increaseYPosition();
				}
				else if(menuXActive && !enterKey){
					menuX.increaseYPosition();
				}
				
				fadeActive = false;	
			}
//==========================================================================
//ACTION: LEFT
			else if(e.getKeyCode() == LEFT){
			leftArrow = true;
				
				if(gameActive == false && newGameActive == true && !enterKey){
					characterCreator.setEnterPressed(false);
					characterCreator.setBackspacePressed(false);
					characterCreator.setDefault(false);
					characterCreator.decreaseXPosition();
				}
				else if(gameActive == false && loadGameActive == true && !enterKey){
					loadGame.setEnterPressed(false);
					loadGame.decreaseXPosition();
				}
				else if(gameActive == true && sceneOneActive == true && !rightArrow && !upArrow && !downArrow && !characterCurrentlyWalking && !enterKey){
					scene1.decreaseRandomBattle();
					scene1.decreaseXPosition();
					characterCurrentlyWalking = true;
					scene1.setWalkDirection("LEFT");
				}
				else if(gameSettingsActive){
					gameSettings.decreaseXPosition();
					if(gameSettings.getXPosition() == 0 && gameSettings != null){
						settings = new Settings(settingsBackground, settingsFill, arrow, arrow2, gameSettings.getCalledObject(), this);
						gameSettingsActive = false;
						settingsActive = true;
						gameSettings = null;
					}
						
				}
				else if(battleActive){
					//battle = null;
					//battleActive = false;
					//sceneOneActive = true;
					//scene1.setRandomBattle(generator.nextInt()%30);
				}
				else if(menuXActive && !enterKey){
					menuX.decreaseXPosition();
				}
				
				fadeActive = false;
			}
//==========================================================================
//ACTION: RIGHT
			else if(e.getKeyCode() == RIGHT){
			rightArrow = true;
				
				if(gameActive == false && newGameActive == true && !enterKey){
					characterCreator.setEnterPressed(false);
					characterCreator.setBackspacePressed(false);
					characterCreator.setDefault(false);
					characterCreator.increaseXPosition();
				}
				else if(gameActive == false && loadGameActive == true && !enterKey){
					loadGame.setEnterPressed(false);
					loadGame.increaseXPosition();
				}
				else if(gameActive == true && sceneOneActive == true && !leftArrow && !upArrow && !downArrow && !characterCurrentlyWalking && !enterKey){
					scene1.decreaseRandomBattle();
					scene1.increaseXPosition();
					characterCurrentlyWalking = true;
					scene1.setWalkDirection("RIGHT");
				}
				else if(settingsActive){
					settings.increaseXPosition();
					if(settings.getXPosition() == 1){
						gameSettings = new GameSettings(gameSettingsBackground, frame, arrow, arrow2, settings.getCalledObject(), this);
						settingsActive = false;
						gameSettingsActive = true;
						settings = null;
					}
				}
				else if(battleActive){
					//battle = null;
					//battleActive = false;
					//sceneOneActive = true;
					//scene1.setRandomBattle(generator.nextInt()%30);
				}
				else if(menuXActive && !enterKey){
					menuX.increaseXPosition();
				}
				
				fadeActive = false;
			}
//==========================================================================
//ACTION: ENTER
		if(e.getKeyCode() == A){
		enterKey = true;
			
			if(gameActive == false && mainMenuActive == true && (!upArrow || !downArrow || !leftArrow || !rightArrow)){
				if(mainMenu.getYPosition() == 0){
					newGameActive = true;
					mainMenuActive = false;
					fadeActive = true;
					alpha = 0.0f;
					mainMenu = null;
					g.setColor(Color.white);
					g.fillRect(0, 0, 1000, 550);
					characterCreator = new CharacterCreator(characterBackground, arrow, cursor, backspace, defaultLetters, mainMenu, this);
					characterCreator.setDefault(true);
				}
				else if(mainMenu.getYPosition() == 1){
					loadGameActive = true;
					mainMenuActive = false;
					fadeActive = true;
					alpha = 0.0f;
					mainMenu = null;
					loadGame = new LoadGame(loadGameBackground, loadGameMenuArrow, this);
				}
				else if(mainMenu.getYPosition() == 2){
					settingsActive = true;
					mainMenuActive = false;
					fadeActive = true;
					alpha = 0.0f;
					mainMenu = null;
					settings = new Settings(settingsBackground, settingsFill, arrow, arrow2, mainMenu, this);
				}
			}
	//--------------------------------------------------------------			
			else if(gameActive == false && newGameActive == true && (!upArrow || !downArrow || !leftArrow || !rightArrow)){
				
				//prints alphabet for newGame
				for(int i = 0; i < 26; i++){
					if(characterCreator.getXPosition() == (i%4)+4 && characterCreator.getYPosition() == i/4){
						characterCreator.setLetter((char)(i+97));
					}
				}
				
				for(int i = 0; i < 26; i++){
					if(characterCreator.getXPosition() == i%4 && characterCreator.getYPosition() == i/4){
						characterCreator.setLetter((char)(i+65));
					}
				}
				
				if(characterCreator.getXPosition() == 1 && characterCreator.getYPosition() == 7)
					characterCreator.setLetter(' ');
				else if(characterCreator.getXPosition() == 2 && characterCreator.getYPosition() == 7){
					characterCreator.setBackspacePressed(true);
					characterCreator.setLetter(' ');
				}
				else if(characterCreator.getXPosition() == 3 && characterCreator.getYPosition() == 7){
					characterCreator.setDefault(true);
				}
				else if(characterCreator.getXPosition() == 0 && characterCreator.getYPosition() == 7){
					
					validName = characterCreator.setCharacterNameLength();
					if(validName == true){
						newGameActive = false;
						gameActive = true;
						sceneOneActive = true;
						fadeActive = true;
						alpha = 0.0f;
						g.setColor(Color.white);
						g.fillRect(0, 0, 1000, 550);
						Luffy = new Character(characterCreator.getCharacterName(), characterCreator.getCharacterNameLength(), characterCreator.getCalledObject(), this, luffySprite, luffyPortrait, luffyRegularAttack, luffyAttackExtras);
						Luffy2 = new Character(characterCreator.getCharacterName(), characterCreator.getCharacterNameLength(), characterCreator.getCalledObject(), this, luffySprite, luffyPortrait, luffyRegularAttack, luffyAttackExtras);
						Luffy3 = new Character(characterCreator.getCharacterName(), characterCreator.getCharacterNameLength(), characterCreator.getCalledObject(), this, luffySprite, luffyPortrait, luffyRegularAttack, luffyAttackExtras);
						Luffy4 = new Character(characterCreator.getCharacterName(), characterCreator.getCharacterNameLength(), characterCreator.getCalledObject(), this, luffySprite, luffyPortrait, luffyRegularAttack, luffyAttackExtras);
						Luffy.addToParty(Luffy);
						Luffy.addToParty(Luffy2);
						Luffy.addToParty(Luffy3);
						Luffy.addToParty(Luffy4);
						characterCreator = null;
						scene1 = new Scene1(sceneOneBackground, frame, -210, -60, this, Luffy, monsters);
						currentPartyInControl = Luffy;
						scene1.setRandomBattle(generator.nextInt()%30);
					}
					
					shakeActive = true;
					imageToShake = characterBackground;
					
					
				}
			}
	//--------------------------------------------------------------	
			else if(settingsActive == true && settings.getChangeControlsMode() == false && (!upArrow || !downArrow || !leftArrow || !rightArrow)){
				
				if(settings.getYPosition() == 12) {
					settings.setDefaultSelected(true);
					enterKey = false;
				}
				
				else if(settings.getYPosition() > -1){
					settings.setControlMode(true);
					settings.setEnterPressed(true);
				}
				
				controlsActive = false;
			}
			else if(gameSettingsActive && (!upArrow || !downArrow || !leftArrow || !rightArrow)){
				if(gameSettings.getYPosition() > -1){
					if(gameSettings.getEnterPressed()){
						gameSettings.setEnterPressed(false);
						gameSettings.setChangeOptionsMode(false);
					}
					else{
						gameSettings.setEnterPressed(true);
						gameSettings.setChangeOptionsMode(true);
					}
					controlsActive = false;
				}
			}
	//--------------------------------------------------------------
			else if(menuXActive && (!upArrow || !downArrow || !leftArrow || !rightArrow)){
				
				if(menuX.changeRow)
					menuX.setChangeRow(false);
				else{
					for(int i = 0; i < getCurrentPartyInControl().getNumberOfMembers(); i++)
						if(!menuX.getOnTheRight() && menuX.currentYPosition == i)
							menuX.setChangeRow(true);
				}
				
				if(menuX.getYPosition() == 4){
					settings = new Settings(settingsBackground, settingsFill, arrow, arrow2, menuX, this);
					menuXActive = false;
					settingsActive = true;
					fadeActive = true;
					alpha = 0.0f;
				}
					
			}
	//--------------------------------------------------------------
			else if(battleActive && (!upArrow || !downArrow || !leftArrow || !rightArrow)){
				battle.setEnterPressed(true);
			}
		}
//==========================================================================
//ACTION: ESCAPE
		if(e.getKeyCode() == B){
			escapeKey = true;
			if(gameActive == false && newGameActive == true){
				newGameActive = false;
				mainMenuActive = true;
				characterCreator = null;
				fadeActive = true;
				alpha = 0.0f;
				mainMenu = new MainMenu(mainMenuBackground, arrow, 0, this);
			}
			else if(settingsActive == true && settings.getChangeControlsMode() == false){
				if(settings.getCalledObject() == mainMenu){
					newGameActive = false;
					mainMenuActive = true;
					settingsActive = false;
					settings = null;
					fadeActive = true;
					alpha = 0.0f;
					mainMenu = new MainMenu(mainMenuBackground, arrow, 2, this);
				}
				else if(settings.getCalledObject() == menuX){
					menuXActive = true;
					settingsActive = false;
					settings = null;
					fadeActive = true;
					alpha = 0.0f;
				}
			}
			else if(gameSettingsActive){
				if(gameSettings.getCalledObject() == mainMenu){
					newGameActive = false;
					mainMenuActive = true;
					gameSettingsActive = false;
					gameSettings = null;
					fadeActive = true;
					alpha = 0.0f;
					mainMenu = new MainMenu(mainMenuBackground, arrow, 2, this);
				}
				else if(gameSettings.getCalledObject() == menuX){
					menuXActive = true;
					gameSettingsActive = false;
					gameSettings = null;
					fadeActive = true;
					alpha = 0.0f;
				}
				
			}
			else if(gameActive == false && loadGameActive == true){
				loadGameActive = false;
				mainMenuActive = true;
				loadGame = null;
				fadeActive = true;
				alpha = 0.0f;
				mainMenu = new MainMenu(mainMenuBackground, arrow, 1, this);
			}
			else if(gameActive && menuXActive){
				if(menuX.getCalledObject() == scene1 && !menuX.changeRow){
					menuXActive = false;
					sceneOneActive = true;
					menuX = null;
					fadeActive = true;
					alpha = 0.0f;
				}
				else if(menuX.changeRow){
					menuX.setChangeRow(false);
				}
			}
		}
//==========================================================================
//ACTION: X
		if(e.getKeyCode() == X){
			if(gameActive && !battleActive && sceneOneActive){
				fadeActive = true;
				alpha = 0.0f;
				menuX = new MenuX(menuXBackground, frame, arrow, arrow2, scene1, this);
				menuXActive = true;
				sceneOneActive = false;
			}
		}
//==========================================================================
//ACTION: SET CONTROLS		
		if(settingsActive == true && settings.getChangeControlsMode() == true && controlsActive == true){
			if(settings.getYPosition() == 0){
				if(e.getKeyCode() != B && e.getKeyCode() != X && e.getKeyCode() != Y
						&& e.getKeyCode() != START && e.getKeyCode() != SELECT && e.getKeyCode() != UP
						&& e.getKeyCode() != DOWN && e.getKeyCode() != LEFT && e.getKeyCode() != RIGHT
						&& e.getKeyCode() != LTRIGGER && e.getKeyCode() != RTRIGGER){
					A = e.getKeyCode();
					settings.setLetter(A);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 1){
				if(e.getKeyCode() != A && e.getKeyCode() != X && e.getKeyCode() != Y
						&& e.getKeyCode() != START && e.getKeyCode() != SELECT && e.getKeyCode() != UP
						&& e.getKeyCode() != DOWN && e.getKeyCode() != LEFT && e.getKeyCode() != RIGHT
						&& e.getKeyCode() != LTRIGGER && e.getKeyCode() != RTRIGGER){
					B = e.getKeyCode();
					settings.setLetter(B);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 2){
				if(e.getKeyCode() != A && e.getKeyCode() != B && e.getKeyCode() != Y
						&& e.getKeyCode() != START && e.getKeyCode() != SELECT && e.getKeyCode() != UP
						&& e.getKeyCode() != DOWN && e.getKeyCode() != LEFT && e.getKeyCode() != RIGHT
						&& e.getKeyCode() != LTRIGGER && e.getKeyCode() != RTRIGGER){
					X = e.getKeyCode();
					settings.setLetter(X);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 3){
				if(e.getKeyCode() != A && e.getKeyCode() != B && e.getKeyCode() != X
						&& e.getKeyCode() != START && e.getKeyCode() != SELECT && e.getKeyCode() != UP
						&& e.getKeyCode() != DOWN && e.getKeyCode() != LEFT && e.getKeyCode() != RIGHT
						&& e.getKeyCode() != LTRIGGER && e.getKeyCode() != RTRIGGER){
					Y = e.getKeyCode();
					settings.setLetter(Y);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 4){
				if(e.getKeyCode() != A && e.getKeyCode() != B && e.getKeyCode() != X
						&& e.getKeyCode() != Y && e.getKeyCode() != SELECT && e.getKeyCode() != UP
						&& e.getKeyCode() != DOWN && e.getKeyCode() != LEFT && e.getKeyCode() != RIGHT
						&& e.getKeyCode() != LTRIGGER && e.getKeyCode() != RTRIGGER){
					START = e.getKeyCode();
					settings.setLetter(START);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 5){
				if(e.getKeyCode() != A && e.getKeyCode() != B && e.getKeyCode() != X
						&& e.getKeyCode() != Y && e.getKeyCode() != START && e.getKeyCode() != UP
						&& e.getKeyCode() != DOWN && e.getKeyCode() != LEFT && e.getKeyCode() != RIGHT
						&& e.getKeyCode() != LTRIGGER && e.getKeyCode() != RTRIGGER){
					SELECT = e.getKeyCode();
					settings.setLetter(SELECT);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 6){
				if(e.getKeyCode() != A && e.getKeyCode() != B && e.getKeyCode() != X
						&& e.getKeyCode() != Y && e.getKeyCode() != START && e.getKeyCode() != SELECT
						&& e.getKeyCode() != DOWN && e.getKeyCode() != LEFT && e.getKeyCode() != RIGHT
						&& e.getKeyCode() != LTRIGGER && e.getKeyCode() != RTRIGGER){
					UP = e.getKeyCode();
					settings.setLetter(UP);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 7){
				if(e.getKeyCode() != A && e.getKeyCode() != B && e.getKeyCode() != X
						&& e.getKeyCode() != Y && e.getKeyCode() != START && e.getKeyCode() != SELECT
						&& e.getKeyCode() != UP && e.getKeyCode() != LEFT && e.getKeyCode() != RIGHT
						&& e.getKeyCode() != LTRIGGER && e.getKeyCode() != RTRIGGER){
					DOWN = e.getKeyCode();
					settings.setLetter(DOWN);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 8){
				if(e.getKeyCode() != A && e.getKeyCode() != B && e.getKeyCode() != X
						&& e.getKeyCode() != Y && e.getKeyCode() != START && e.getKeyCode() != SELECT
						&& e.getKeyCode() != UP && e.getKeyCode() != DOWN && e.getKeyCode() != RIGHT
						&& e.getKeyCode() != LTRIGGER && e.getKeyCode() != RTRIGGER){
					LEFT = e.getKeyCode();
					settings.setLetter(LEFT);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 9){
				if(e.getKeyCode() != A && e.getKeyCode() != B && e.getKeyCode() != X
						&& e.getKeyCode() != Y && e.getKeyCode() != START && e.getKeyCode() != SELECT
						&& e.getKeyCode() != UP && e.getKeyCode() != DOWN && e.getKeyCode() != LEFT
						&& e.getKeyCode() != LTRIGGER && e.getKeyCode() != RTRIGGER){
					RIGHT = e.getKeyCode();
					settings.setLetter(RIGHT);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 10){
				if(e.getKeyCode() != A && e.getKeyCode() != B && e.getKeyCode() != X
						&& e.getKeyCode() != Y && e.getKeyCode() != START && e.getKeyCode() != SELECT
						&& e.getKeyCode() != UP && e.getKeyCode() != DOWN && e.getKeyCode() != LEFT
						&& e.getKeyCode() != RIGHT && e.getKeyCode() != RTRIGGER){
					LTRIGGER = e.getKeyCode();
					settings.setLetter(LTRIGGER);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			else if(settings.getYPosition() == 11){
				if(e.getKeyCode() != A && e.getKeyCode() != B && e.getKeyCode() != X
						&& e.getKeyCode() != Y && e.getKeyCode() != START && e.getKeyCode() != SELECT
						&& e.getKeyCode() != UP && e.getKeyCode() != DOWN && e.getKeyCode() != LEFT
						&& e.getKeyCode() != RIGHT && e.getKeyCode() != LTRIGGER){
					RTRIGGER = e.getKeyCode();
					settings.setLetter(RTRIGGER);
				}
				else
					setShakeActive(true, settingsBackground);
			}
			settings.setLetter(0);
		}
		if(gameSettingsActive && gameSettings.getChangeOptionsMode()){
			if(gameSettings.getYPosition() == 0){
				if(e.getKeyCode() == LEFT)
					activeOrWait = true;
				else if(e.getKeyCode() == RIGHT)
					activeOrWait = false;
			}
		}
		
		
	}
//==========================================================================
//==========================================================================
//==========================================================================
	
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == UP)
			upArrow = false;
		if(e.getKeyCode() == LEFT)
			leftArrow = false;
		if(e.getKeyCode() == RIGHT)
			rightArrow = false;
		if(e.getKeyCode() == DOWN)
			downArrow = false;
		if(e.getKeyCode() == A)
			enterKey = false;
		if(e.getKeyCode() == B)
			escapeKey = false;
		
	}
	
	public void keyTyped(KeyEvent e){
	}
		
	public OnePieceRPG getThis(){
		return this;
	}
	
	public void fade(boolean fadeActive){
		
		if(fadeActive == true){
			fade.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		    fade.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			
			alpha += 0.05f;
		    if (alpha >= 1.0f) {
		        alpha = 0.0f;
		    } 
		    else{
		        repaint();
		    }
		}
		
	}
	
	public void shake(boolean shakeActive) {
		fade.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
	    fade.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    if(shakeActive == true){
	    	
			alpha += 0.05f;
			if (alpha >= 1.0f) {
				alpha = 0.0f;
			}
			else{
				repaint();
			}
	    }
	}
	
	public void setShake(int numberOfShakes){
		if(numberOfShakes == 5){
			xShake = -7;
			yShake = -5;
		}
		else if(numberOfShakes == 4){
			xShake = -7;
			yShake = 5;						
		}
		else if(numberOfShakes == 3){
			xShake = 7;
			yShake = 5;						
		}
		else if(numberOfShakes == 2){
			xShake = 7;
			yShake = -5;						
		}
		else if(numberOfShakes == 1){
			xShake = -7;
			yShake = -5;	
		}
	}
	
	public void setShakeActive(boolean temp, Image temp2){
		shakeActive = temp;
		imageToShake = temp2;
	}
	
	public int getControls(String control){
		
		if(control == "A")
			return A;
		else if(control == "B")
			return B;
		else if(control == "X")
			return X;
		else if(control == "Y")
			return Y;
		else if(control == "START")
			return START;
		else if(control == "SELECT")
			return SELECT;
		else if(control == "UP")
			return UP;
		else if(control == "DOWN")
			return DOWN;
		else if(control == "LEFT")
			return LEFT;
		else if(control == "RIGHT")
			return RIGHT;
		else if(control == "LTRIGGER")
			return LTRIGGER;
		else if(control == "RTRIGGER")
			return RTRIGGER;
		else
			//This is error Code 1337 - it means a leet hackor exists
			return 1337;
	}
	
	public void setControlsActive(boolean temp){
		controlsActive = temp;
	}
	
	public void shake(Graphics gfx){
		shakeDelay = System.currentTimeMillis();
		numberOfShakes = 5;

		while(numberOfShakes > 0 && System.currentTimeMillis() < shakeDelay + 25){
			if(shakeDelay == System.currentTimeMillis()){
				
				setShake(numberOfShakes);			
				shakeDelay += 25;
				numberOfShakes--;
				shake(true);
				
			    gfx.drawImage(imageToShake, xShake, yShake, this);
			}
		}
		shakeActive = false;
		xShake = 0;
		yShake = 0;
	}
	
	public void setDefaultControls(){
		A = KeyEvent.VK_D;
		B = KeyEvent.VK_S;
		X = KeyEvent.VK_W;
		Y = KeyEvent.VK_A;
		START = KeyEvent.VK_ENTER;
		SELECT = KeyEvent.VK_SPACE;
		UP = KeyEvent.VK_UP;
		DOWN = KeyEvent.VK_DOWN;
		LEFT = KeyEvent.VK_LEFT;
		RIGHT = KeyEvent.VK_RIGHT;
		LTRIGGER = KeyEvent.VK_Q;
		RTRIGGER = KeyEvent.VK_E;
	}
	
	public Character getCurrentPartyInControl(){
		return currentPartyInControl;
	}
	
}