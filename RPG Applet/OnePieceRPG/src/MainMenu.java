import java.awt.*;

public class MainMenu{
	
	Image background;
	Image arrow;
	OnePieceRPG applet;
	int currentYPosition;
	
	
	public MainMenu(Image background, Image arrow, int arrowSpot, OnePieceRPG applet){
		this.background = background;			//background
		this.arrow = arrow;		//arrow
		this.applet = applet;
		currentYPosition = arrowSpot;
	}
	
	public void paint(Graphics gfx){
		gfx.drawImage(background, 0, 0, applet);
		
		if(currentYPosition == 0)
			gfx.drawImage(arrow, 410, 217, applet);
		else if(currentYPosition == 1)
			gfx.drawImage(arrow, 410, 254, applet);
		else if(currentYPosition == 2)
			gfx.drawImage(arrow, 410, 293, applet);
	}
	
	public void decreaseYPosition(){
		currentYPosition--;
		if(currentYPosition < 0)
			currentYPosition = 2;
	}
	
	public void increaseYPosition(){
		currentYPosition++;
		if(currentYPosition > 2)
			currentYPosition = 0;
	}
	
	public int getYPosition(){
		return currentYPosition;
	}
}
