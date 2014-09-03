import java.awt.*;

public class MainMenu{
	
	Image background;
	Image scaledBackground;
	Image[] beam;
	Image[] scaledBeam;
	Image[] beamCorner;
	Image[] scaledBeamCorner;
	Image[] alphabet;
	Image[] scaledAlphabet;
	Image[] number;
	Image[] scaledNumber;
	Image arrow;
	Image scaledArrow;
	Pong pong;
	Dimension resolution;
	double largeAlphaWidthRatio;
	double smallAlphaWidthRatio;
	double arrowWidthRatio;
	double beamCornerWidthRatio;
	double beamWidthRatio;
	double beamWidthRatio2;
	
	double largeAlphaHeightRatio;
	double smallAlphaHeightRatio;
	double arrowHeightRatio;
	double beamCornerHeightRatio;
	double beamHeightRatio;
	double beamHeightRatio2;
	int currentYPosition;
	boolean onePlayerSelected;
	boolean twoPlayerSelected;
	
	public MainMenu(Image background, Image[] beam, Image beamCorner[], Image alphabet[], Image arrow, Image[] number, Pong pong){
		this.background = background;
		this.arrow = arrow;
		this.beam = beam;
		this.beamCorner = beamCorner;
		this.alphabet = alphabet;
		this.number = number;
		this.pong = pong;
		onePlayerSelected = false;
		twoPlayerSelected = false;
		currentYPosition = 0;
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		resolution = toolkit.getScreenSize();
		
		largeAlphaWidthRatio = 119.0/1024.0;
		smallAlphaWidthRatio = 44.0/1024.0;
		arrowWidthRatio = 59.0 / 1024.0;
		beamCornerWidthRatio = 33.0 / 1024.0;
		beamWidthRatio = 77.0 / 1024.0;
		beamWidthRatio2 = 33.0 / 1024.0;
		
		largeAlphaHeightRatio = 150.0/768.0;
		smallAlphaHeightRatio = 58.0/768.0;
		arrowHeightRatio = 44.0 / 768.0;
		beamCornerHeightRatio = 33.0 / 768.0;
		beamHeightRatio = 33.0 / 768.0;
		beamHeightRatio2 =  77.0 / 768.0;
		
		scaledBackground = background.getScaledInstance(resolution.width, resolution.height, Image.SCALE_DEFAULT);
		scaledArrow = arrow.getScaledInstance((int)(resolution.width*arrowWidthRatio), (int)(resolution.height*arrowHeightRatio), Image.SCALE_DEFAULT);
		scaledAlphabet = new Image[10];
		for(int i = 0; i < 4; i++)
			scaledAlphabet[i] = alphabet[i].getScaledInstance((int)(resolution.width*largeAlphaWidthRatio), (int)(resolution.height*largeAlphaHeightRatio), Image.SCALE_DEFAULT);
		for(int i = 4; i < 10; i++)
			scaledAlphabet[i] = alphabet[i].getScaledInstance((int)(resolution.width*smallAlphaWidthRatio), (int)(resolution.height*smallAlphaHeightRatio), Image.SCALE_DEFAULT);
		scaledBeamCorner = new Image[4];
		for(int i = 0; i < 4; i++)
			scaledBeamCorner[i] = beamCorner[i].getScaledInstance((int)(resolution.width*beamCornerWidthRatio), (int)(resolution.height*beamCornerHeightRatio), Image.SCALE_DEFAULT);
		scaledBeam = new Image[2];
		scaledBeam[0] = beam[0].getScaledInstance((int)(resolution.width*beamWidthRatio), (int)(resolution.height*beamHeightRatio), Image.SCALE_DEFAULT);
		scaledBeam[1] = beam[1].getScaledInstance((int)(resolution.width*beamWidthRatio2), (int)(resolution.height*beamHeightRatio2), Image.SCALE_DEFAULT);
		
		scaledNumber = new Image[2];
		for(int i = 0; i < 2; i++)
			scaledNumber[i] = number[i].getScaledInstance((int)(resolution.width*smallAlphaWidthRatio), (int)(resolution.height*smallAlphaHeightRatio), Image.SCALE_DEFAULT);
	
	}
	
	public void paint(Graphics g){		
		
		g.drawImage(scaledBackground, 0, 0, pong);
		drawGlowBox(g, resolution.width/4, resolution.height/3, resolution.width/2, (5*resolution.height)/12);
		drawTitle(g);
		drawOptions(g, resolution.width/3, resolution.height/3);
		drawArrow(g, resolution.width/3, resolution.height/3);
		preformAction();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public void drawGlowBox(Graphics g, int xStart, int yStart, int width, int height){
		//largest dimensions
		//drawGlowBox(g, 0, 0, resolution.width-33, resolution.height-33);
		//smallest dimensions
		//drawGlowBox(g, 100, 100, 185, 185);
		int widescreen = 25;
		int widescreen2 = 10;
		
		height += yStart;
		width += xStart;
		
		g.drawImage(scaledBeamCorner[3], xStart, yStart, pong);
		g.drawImage(scaledBeamCorner[2], xStart, height, pong);
		g.drawImage(scaledBeamCorner[0], width, yStart, pong);
		g.drawImage(scaledBeamCorner[1], width, height, pong);

		g.drawImage(scaledBeam[0], width-77-widescreen, yStart, pong);
		g.drawImage(scaledBeam[0], width-77-widescreen, height, pong);
		g.drawImage(scaledBeam[1], xStart, height-77, pong);
		g.drawImage(scaledBeam[1], width, height-77, pong);
		
		g.drawImage(scaledBeam[1], xStart, height-(77*2), pong);
		g.drawImage(scaledBeam[1], width, height-(77*2), pong);
		
		g.drawImage(scaledBeam[0], width-(77*2), yStart, pong);
		g.drawImage(scaledBeam[0], width-(77*2), height, pong);
			
		for(int i = 1; i < (width - (xStart))/77; i++){
			g.drawImage(scaledBeam[0], (xStart)+33+widescreen2+(77*(i-1)), yStart, pong);
			g.drawImage(scaledBeam[0], (xStart)+33+widescreen2+(77*(i-1)), height, pong);
		}
		for(int i = 1; i < (height - (yStart))/77; i++){
			g.drawImage(scaledBeam[1], xStart, (yStart)+33+((i-1)*77), pong);
			g.drawImage(scaledBeam[1], width, (yStart)+33+((i-1)*77), pong);	
		}
	}
	
	public void drawTitle(Graphics g){
		
		int spaceBetweenLetters = (int) (135.0 * resolution.width / 1024);
		int leftSkew = (int) (45.0 * resolution.width / 1024);
		int rightSkew = (int) (90.0 * resolution.width / 1024);
				
		g.drawImage(scaledAlphabet[0], (resolution.width/2)-(2*spaceBetweenLetters)+leftSkew, resolution.height/20, pong);
		g.drawImage(scaledAlphabet[1], (resolution.width/2)-(1*spaceBetweenLetters)+leftSkew, resolution.height/20, pong);	
		g.drawImage(scaledAlphabet[2], (resolution.width/2)-(-1*spaceBetweenLetters)-rightSkew, resolution.height/20, pong);	
		g.drawImage(scaledAlphabet[3], (resolution.width/2)-(-2*spaceBetweenLetters)-rightSkew, resolution.height/20, pong);	
		
	}
	
	public void drawOptions(Graphics g, int xStart, int yStart){
		
		int spaceBetweenLetters = (int) (45.0 * resolution.width / 1024);
		int leftSkew = (int) (100.0 * resolution.width / 1024);
		int upSkew = (int) (90.0 * resolution.width / 1024);
		
		for(int i = 0; i < 2; i++)
			g.drawImage(scaledNumber[i], (xStart)+leftSkew, yStart+upSkew*(i+1), pong);
		
		for(int i = 0; i < 6; i++){
			g.drawImage(scaledAlphabet[4+i], (xStart)+((i+1)*spaceBetweenLetters)+leftSkew, yStart+upSkew, pong);
			g.drawImage(scaledAlphabet[4+i], (xStart)+((i+1)*spaceBetweenLetters)+leftSkew, yStart+upSkew*2, pong);	
		}

	}
	
	public void drawArrow(Graphics g, int xStart, int yStart){
		
		int leftSkew = (int) (20.0 * resolution.width / 1024);
		int upSkew = (int) (95.0 * resolution.width / 1024);
		
		for(int i = 0; i < 2; i++){
			if(currentYPosition == i){
				g.drawImage(scaledArrow, (xStart)+leftSkew, yStart+upSkew*(i+1), pong);
			}
		}
	}
	
	public void preformAction(){
		if(onePlayerSelected){
			//new Game
		}
		else if(twoPlayerSelected){
			//newGame
		}
	}
	
	public void increaseYPosition(){
		currentYPosition++;
		if(currentYPosition > 1)
			currentYPosition = 0;
	}
	
	public void decreaseYPosition(){
		currentYPosition--;
		if(currentYPosition < 0)
			currentYPosition = 1;
	}
}






