import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class PlayingField {
	
	Pong pong;
	Image background;
	Image[] beam;
	Image[] beamCorner;
	Image scaledBackground;
	Image[] scaledBeamCorner;
	Image[] scaledBeam;
	Dimension resolution;

	double beamCornerWidthRatio;
	double beamWidthRatio;
	double beamWidthRatio2;

	double beamCornerHeightRatio;
	double beamHeightRatio;
	double beamHeightRatio2;

	
	
	public PlayingField(Image background,  Image[] beam, Image beamCorner[], Pong pong){
		this.background = background;
		this.pong = pong;
		this.beam = beam;
		this.beamCorner = beamCorner;
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		resolution = toolkit.getScreenSize();
		
		beamCornerWidthRatio = 33.0 / 1024.0;
		beamWidthRatio = 77.0 / 1024.0;
		beamWidthRatio2 = 33.0 / 1024.0;
		
		beamCornerHeightRatio = 33.0 / 768.0;
		beamHeightRatio = 33.0 / 768.0;
		beamHeightRatio2 =  77.0 / 768.0;
		
		scaledBackground = background.getScaledInstance(resolution.width, resolution.height, Image.SCALE_DEFAULT);
		scaledBeamCorner = new Image[4];
		for(int i = 0; i < 4; i++)
			scaledBeamCorner[i] = beamCorner[i].getScaledInstance((int)(resolution.width*beamCornerWidthRatio), (int)(resolution.height*beamCornerHeightRatio), Image.SCALE_DEFAULT);
		scaledBeam = new Image[2];
		scaledBeam[0] = beam[0].getScaledInstance((int)(resolution.width*beamWidthRatio), (int)(resolution.height*beamHeightRatio), Image.SCALE_DEFAULT);
		scaledBeam[1] = beam[1].getScaledInstance((int)(resolution.width*beamWidthRatio2), (int)(resolution.height*beamHeightRatio2), Image.SCALE_DEFAULT);
		
		
		Ball ball = new Ball();
		Slider player1 = new Slider();
		Slider player2 = new Slider();
	}
	
	public void paint(Graphics g){
		g.drawImage(scaledBackground, 0, 0, pong);
		
		drawField(g);
	}
	
	public void drawField(Graphics g){
		for(int i = 0; i < 10; i++)
			g.drawImage(scaledBeam[1], resolution.width/2-20,(100*i), pong);
		for(int i = 0; i < 20; i++){
			g.drawImage(scaledBeam[0],(i*100), 0, pong);
			g.drawImage(scaledBeam[0],(i*100), resolution.height-33, pong);
		}
		
	}

}
