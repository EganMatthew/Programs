import java.awt.*;

public class GameSettings{
	
	
	//===============DRAWING THE SCREEN===================
	Object object;
	OnePieceRPG applet;
	Image background;
	Image frame;
	Image arrow;
	Image arrow2;
	int currentXPosition;
	int currentYPosition;
	Font font;
	boolean enterPressed;
	boolean changeOptionsMode;
	
	public GameSettings(Image background, Image frame, Image arrow, Image arrow2, Object object, OnePieceRPG applet){
		this.object = object;
		this.applet = applet;
		this.background = background;
		this.frame = frame;
		this.arrow = arrow;
		this.arrow2 = arrow2;
		enterPressed = false;
		changeOptionsMode = false;
		currentXPosition = 1;
		currentYPosition = -1;
		
	}
	
	public void paint(Graphics g){
		
		
		font = new Font("Gungsuh", Font.PLAIN, 25);
		g.setFont(font);		
		g.drawImage(background, 0, 0, applet);
		g.drawImage(frame, 0, 0, applet);
		
		if(applet.activeOrWait == true){
			g.setColor(Color.red);
			g.drawString("Active", 150, 180);
			g.setColor(Color.black);
			g.drawString("Wait", 250, 180);
		}
		else {
			g.setColor(Color.black);
			g.drawString("Active", 150, 180);
			g.setColor(Color.red);
			g.drawString("Wait", 250, 180);
		}
		
		if(changeOptionsMode && enterPressed){
			if(currentXPosition == 1 && currentYPosition == 0)
				g.drawImage(arrow2, 100, 150, applet);
			applet.setControlsActive(true);
		}
		else {
			if(currentXPosition == 0 && currentYPosition == -1)
				g.drawImage(arrow, 68, 62, applet);
			else if(currentXPosition == 1 && currentYPosition == -1)
				g.drawImage(arrow, 68+270, 62, applet);
			else if(currentXPosition == 2 && currentYPosition == -1)
				g.drawImage(arrow, 68+465, 62, applet);
			
			else if(currentXPosition == 1 && currentYPosition == 0)
				g.drawImage(arrow, 100, 150, applet);
		}
		
		
		
	}
	
	public Object getCalledObject(){
		return object;
	}
	
	public void increaseXPosition(){
		if(currentYPosition < 0){
			currentXPosition++;
			if(currentXPosition > 3)
				currentXPosition = 3;
		}
	}
	
	public void decreaseXPosition(){
		if(currentYPosition < 0){
			currentXPosition--;
			if(currentXPosition < 0)
				currentXPosition = 0;
		}
	}
	
	public void increaseYPosition(){
			currentYPosition++;
			if(currentYPosition > 0)
				currentYPosition = -1;
	}
	
	public void decreaseYPosition(){
			currentYPosition--;
			if(currentYPosition < -1)
				currentYPosition = 0;
	}
	
	public int getXPosition(){
		return currentXPosition;
	}
	
	public int getYPosition(){
		return currentYPosition;
	}
	
	public void setEnterPressed(boolean temp){
		enterPressed = temp;
	}
	
	public void setChangeOptionsMode(boolean temp){
		changeOptionsMode = temp;
	}
	
	public boolean getChangeOptionsMode(){
		return changeOptionsMode;
	}
	
	public boolean getEnterPressed(){
		return enterPressed;
	}

}
