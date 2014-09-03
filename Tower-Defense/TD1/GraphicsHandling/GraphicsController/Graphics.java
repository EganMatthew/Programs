package GraphicsController; 
  
import java.awt.Dimension; 
import java.awt.Font;
import java.awt.Image; 
import java.awt.image.BufferedImage; 
import java.io.File; 
import java.io.IOException; 
import java.util.ArrayList; 

import javax.imageio.ImageIO; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JSlider;
import javax.swing.JTextField;

import Bullet.Bullet;
import CreepController.Creep;
import EventListeners.PlayMusic1;
import GameController.Coordinates;
import GameController.Game;
import GlobalComponents.AnalyzeImage1;
import GlobalComponents.GlobalComponents;
import GlobalComponents.SetAllInvisible;
import Menus.CharacterMenu.CreateCharacterComponenets;
import Menus.CharacterMenu.PrintCharacterTypeScreen;
import Menus.DifficultyMenu.DifficultyMenuComponents;
import Menus.DifficultyMenu.PrintDifficultyMenu;
import Menus.GameMenu.GameMenuComponents;
import Menus.GameMenu.PrintGame;
import Menus.HelpMenu.HelpComponents;
import Menus.HelpMenu.PrintHelp;
import Menus.LoginMenu.CreateLoginComponents;
import Menus.LoginMenu.PrintLogInScreen;
import Menus.MainMenu.MainMenuComponents;
import Menus.MainMenu.PrintMainMenu;
import Menus.Movies.CreateAndLoadMovie1;
import Menus.Movies.PrintPlayMovie1;
import javax.swing.JFileChooser;
import Menus.OptionsMenu.OptionsComponents;
import Menus.OptionsMenu.PrintOptionsScreen;
import Menus.WorldEditorMenu.PrintWorldCreatorScreen;
import Menus.WorldEditorMenu.WorldEditorComponents;
import Menus.WorldSelectorMenu.CreateScrollMenu;
import Menus.WorldSelectorMenu.PrintWorldSelectorScreen;
import Menus.WorldSelectorMenu.WorldSelectorComponents;
import TowerController.Tower;
  
public class Graphics extends JPanel{ 
    
	public Game game;
    public JFrame frame = new JFrame();

    public BufferedImage background; 
    public BufferedImage background1; 
    public BufferedImage background2;
    public BufferedImage background3;
    public BufferedImage loginbackground1;
    public BufferedImage loginbackground2;
    public BufferedImage difficultybackground;
    public BufferedImage genbackground;
    public BufferedImage helpscreen;
    public BufferedImage playarea; 
    public BufferedImage towerbase; 
    public BufferedImage glow; 
    public BufferedImage redradius; 
    public BufferedImage bullet1;
    public BufferedImage redImage;
    public BufferedImage grayImage;
    public BufferedImage whiteImage;
    public Image scaledRadiusGlow; 
    public int scaledImageSize; 
    public BufferedImage mattsLevel;
    public BufferedImage goldenTD;
    public BufferedImage skullMusic;
    public BufferedImage generateworld;
    public BufferedImage chooseworld;
    public BufferedImage intro;
    public BufferedImage introbackground;
    public BufferedImage logincreate;
    public BufferedImage pickclass;
    public BufferedImage optionsImage;
    
    public ArrayList<BufferedImage> intromovie = new ArrayList<BufferedImage>();
    

    public boolean printingCreeps;
    public boolean printingBullets;
    public boolean printingTowers;
    public boolean printingColors;
    
    public boolean colorClicked;
    public String colorToPrint;
    
    public boolean showStartingTowerStats = false;
    public boolean currentlyAnimating;
    
    public boolean tower1Clicked;
    public boolean tower2Clicked; 
    public boolean showTowerStats;
    public Tower towerToPrintStats = null;
    
    public int mouseX; 
    public int mouseY;
    
    public boolean customMusic = false;
    
    public PlayMusic1 music1;
    public JFileChooser browse = new JFileChooser();
    
    //<--- OBJECTS TO PAINT --->//
    	public ArrayList<Tower> towersToPaint = new ArrayList<Tower>(); 
    	public ArrayList<Creep> creepsToPaint = new ArrayList<Creep>(); 
    	public ArrayList<Bullet> bulletsToPaint = new ArrayList<Bullet>();
    	    	
        public String[][] colorGrid = new String[21][18];
        public ArrayList<String[][]> listOfColorGrids = new ArrayList<String[][]>();
    //<--- OBJECTS TO PAINT --->//
    
    public JButton menu;
    //<--- MENU SCREENS --->//
    	public boolean helpMenu = false;
    			public JPanel helpPanel;
    	
    	public boolean optionsScreen = false;
    		//<--- COMPONENTS ASSOCIATED WITH optionsScreen SCREENS --->//
    			public JSlider soundVolume;
    			public JSlider musicVolume;
    			public JSlider masterVolume;
    			public JLabel musicVolumeLabel = new JLabel();
    			public JLabel soundVolumeLabel = new JLabel();
    			public JLabel masterVolumeLabel = new JLabel();
    			public JPanel optionsPanel = new JPanel();
    			public JButton choose;
    			public JButton customNormalCreep;
    			public JButton customFastCreep;
    			public JButton customBossCreep;
    			public JButton customFlyingCreep;
    			public JButton customNormalTower;
    			public JButton customSplashTower;
    			public JButton highscores;
    	
    	public boolean characterTypeScreen = false;
			//<--- COMPONENTS ASSOCIATED WITH optionsScreen SCREENS --->//
    			public JPanel characterPanel = new JPanel();
    			public JButton money = new JButton();
    			public JButton damage = new JButton();
    			public JButton feline = new JButton();;    		
    	
    	public boolean loginScreen = false;
    		//<--- COMPONENTS ASSOCIATED WITH loginScreen SCREENS --->//
    			public JPanel loginPanel = new JPanel();
    			public JTextField username = new JTextField();
    			public JLabel usernameL = new JLabel("Username:");
    			public Font font = new Font("Monospaced", Font.BOLD, 18);
    			public JButton login = new JButton();
    			public JButton register = new JButton();
    			public boolean legitLogin = true;
    			public JLabel errorMessage = new JLabel();
    			public boolean confirmation = false;
    			    	
	    public boolean mainMenuScreen = false;
	    	//<--- COMPONENTS ASSOCIATED WITH mainMenuScreen SCREENS --->//
	    		public JButton play;
	    		public JButton worldcreater;
	    		public JButton options;
	    		public JButton exit;
	    		public JButton help;
	    		    	
	    
	    public boolean difficultyScreen = false;
	    	//<--- COMPONENTS ASSOCIATED WITH difficultyScreen SCREENS --->//
	    		public JButton easy;
	    		public JButton medium;
	    		public JButton hard;
	    
	    public boolean worldCreaterScreen = false;
	    	//<--- COMPONENTS ASSOCIATED WITH worldCreaterScreen SCREENS --->//
	    		public JButton red;
	    		public JButton gray;
	    		public JButton white;
	    		public JButton save;
	    
	    public boolean worldSelectorScreen = false;
	    	//<--- COMPONENTS ASSOCIATED WITH worldSelectorScreen SCREENS --->//
	    		public JPanel panelParent;
	    		public JPanel panel;
	    		public Integer numberOfScrollItems = -1;
	    		public int selectedScrollItem = 0;
	    		public JButton load;
	    
	    public boolean introScreen = true;
	    	//<--- COMPONENTS ASSOCIATED WITH introScreen SCREENS --->//
	    		public byte alpha = 0x00;
	    		public int split = 0;
	    	    public int numSplits = 7;
	    	        
	    public boolean gameScreen = false;
		    //<--- COMPONENTS ASSOCIATED WITH the GAME SCREEN --->//
		    	public JButton turret1;
		    	public JButton turret2;
		    	public JButton temp2;
		    	public JButton temp3;
		    	public JButton temp4;
		    	public JButton temp5;
		    	public JButton pause;
		    	public JButton nearest;
		    	public JButton farthest;
		    	public JButton lowest;
		    	public JButton highest;
		    	public JButton nextwave;
		    	public JButton sell;
		    	public JButton upgrade;
		    	public JButton save2;
		    	public JButton multiplier;
    //<--- MENU SCREENS --->//
	   


    //set the current mouse position 
    public void setMousePosition(int x, int y){ 
        mouseX = x; 
        mouseY = y; 
    } 

    public boolean isTowerClicked(){
    	return tower1Clicked || tower2Clicked;
    }

    public String[][] getGrid(){
    	return listOfColorGrids.get(selectedScrollItem);
    }    

    public void paintComponent(java.awt.Graphics g){ 

        super.paintComponent(g);

	        if(introScreen){
	        	new SetAllInvisible(this, "intro");
	        	new PrintPlayMovie1(this, g);
	        }
	        else if(loginScreen){
	        	new SetAllInvisible(this, "login");
	        	new PrintLogInScreen(this, g);
	        }
	        else if(characterTypeScreen){
	        	new SetAllInvisible(this, "character");
	        	new PrintCharacterTypeScreen(this, g);
	        }
	        else if(mainMenuScreen){
	        	new SetAllInvisible(this, "mainmenu");
	        	new PrintMainMenu(this, g);
	        }
	        else if(difficultyScreen){
	        	new SetAllInvisible(this, "diff");
	        	new PrintDifficultyMenu(this, g);
	        }
	        else if(worldCreaterScreen){
	        	new SetAllInvisible(this, "creator");
	        	new PrintWorldCreatorScreen(this, g);
	        }
	        else if(worldSelectorScreen){
	        	new SetAllInvisible(this, "selector");
	        	new PrintWorldSelectorScreen(this, g);
	        }
	        else if(optionsScreen){
	        	new SetAllInvisible(this, "options");
	        	new PrintOptionsScreen(this, g);
	        }
	        else if(helpMenu){
	        	new SetAllInvisible(this, "help");
	        	new PrintHelp(this, g);
	        }
	        else if(gameScreen){
	        	new SetAllInvisible(this, "game");
	        	new PrintGame(this, g);
	        }
	        else{
	        	//NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	        }

        
    }
          
      
    //Get some basics up and running 
    public Graphics(Game game) { 
    	this.game = game;
    	this.setLayout(null);
        frame.setSize(new Dimension(800, 635)); 
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
        try { 
            //Load the images 
            background = ImageIO.read(new File("images\\background.png"));         
            background1 = ImageIO.read(new File("images\\background1.png")); 
            background2 = ImageIO.read(new File("images\\background2.png"));
            background3 = ImageIO.read(new File("images\\background3.png"));
            loginbackground1 = ImageIO.read(new File("images\\loginscreen.png")); 
            loginbackground2 = ImageIO.read(new File("images\\loginscreen2.png"));
            difficultybackground = ImageIO.read(new File("images\\background4.png")); 
            genbackground = ImageIO.read(new File("images\\genbackground.png"));
            helpscreen = ImageIO.read(new File("images\\helpscreen.png")); 
            playarea = ImageIO.read(new File("images\\playarea.png")); 
            towerbase = ImageIO.read(new File("images\\towerbase.png")); 
            //sidepanel = ImageIO.read(new File("images\\panel.png")); 
            glow = ImageIO.read(new File("images\\glow.png")); 
            redradius = ImageIO.read(new File("images\\radiusglow.png")); 
            bullet1 = ImageIO.read(new File("images\\bullet.png"));
            redImage = ImageIO.read(new File("images\\red.png"));
            grayImage = ImageIO.read(new File("images\\gray.png"));
            whiteImage = ImageIO.read(new File("images\\white.png"));
            skullMusic = ImageIO.read(new File("images\\menuskull.png"));
            goldenTD = ImageIO.read(new File("images\\goldenTD.png"));
            generateworld = ImageIO.read(new File("images\\generateworld.png"));
            chooseworld = ImageIO.read(new File("images\\chooseworld.png"));
            intro = ImageIO.read(new File("images\\intro.png"));
            introbackground = ImageIO.read(new File("images\\introbackground.png"));
            logincreate = ImageIO.read(new File("images\\logincreate.png"));
            pickclass = ImageIO.read(new File("images\\class.png"));
            optionsImage = ImageIO.read(new File("images\\optionsImage.png"));
            
            new CreateAndLoadMovie1(true, this);
            mattsLevel = ImageIO.read(new File("images\\mattslevel.png"));
            
            
            new CreateScrollMenu(this);
            new AnalyzeImage1(this);
            new GlobalComponents(this);
            
            new CreateLoginComponents(this);
            new CreateCharacterComponenets(this);
            new MainMenuComponents(this);
            new GameMenuComponents(this);
            new DifficultyMenuComponents(this);
            new WorldEditorComponents(this);
            new OptionsComponents(this, game);
            new WorldSelectorComponents(this);
            new HelpComponents(this);

            frame.add(this); 
            frame.setVisible(true);
            new CreateAndLoadMovie1(false, this);

            music1 = new PlayMusic1(game.musicVolume, "Sounds\\App Audio - Main Menu 2.wav");
            
            //music1.stop();
        	//music1 = new PlayMusic1(game.musicVolume, "Sounds\\App Audio - Pause Menu 2.wav");
        	//music1.stop();
        	//music1 = new PlayMusic1(game.musicVolume, "Sounds\\App Audio - Waves 2.wav");
        	//music1.stop();
        	//music1 = new PlayMusic1(game.musicVolume, "Sounds\\App Audio - Main Menu 2.wav");
  
        }catch (IOException e) { e.printStackTrace();} 
    }
} 
  
