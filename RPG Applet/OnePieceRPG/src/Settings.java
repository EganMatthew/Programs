import java.awt.*;
import java.awt.event.*;

public class Settings {
	
	Image background;
	Image Fill;
	Image arrow;
	Image arrow2;
	OnePieceRPG applet;
	Object object;
	int xArrow;
	int yArrow;
	int yControl;
	int yDisplacement;
	int yDisplacement2;
	int xDisplacement;
	int currentXPosition;
	int currentYPosition;
	boolean enterPressed;
	boolean changeControlsMode;
	boolean defaultSelected;
	int letter;
	Font font;
	
	public Settings(Image background, Image Fill, Image arrow, Image arrow2,Object object, OnePieceRPG applet){
		this.background = background;
		this.Fill = Fill;
		this.applet = applet;
		this.arrow = arrow;
		this.arrow2 = arrow2;
		this.object = object;
		xArrow = 70;
		yArrow = 114;
		yControl = 119;
		yDisplacement = 26;
		yDisplacement2 = 26;
		xDisplacement = 215;
		currentXPosition = 0;
		currentYPosition = -1;
		enterPressed = false;
		changeControlsMode = false;
		defaultSelected = false;
		letter = 0;
	}

	public void paint(Graphics gfx){
		gfx.drawImage(background, 0, 0, applet);
		gfx.drawImage(Fill, 0, 0, applet);
		font = new Font("Gungsuh", Font.PLAIN, 25);
		gfx.setFont(font);
		gfx.setColor(Color.black);	
		
		//gfx.setColor(Color.red);
		//gfx.drawString("letter = " + KeyEvent.getKeyText(letter), 500, 100);

		if(changeControlsMode == false && defaultSelected == true){
			applet.setDefaultControls();
			defaultSelected = false;
		}
		
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("A")), xArrow + xDisplacement, yControl + yDisplacement2*1);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("B")), xArrow + xDisplacement, yControl + yDisplacement2*2);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("X")), xArrow + xDisplacement, yControl + yDisplacement2*3);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("Y")), xArrow + xDisplacement, yControl + yDisplacement2*4);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("START")), xArrow + xDisplacement, yControl + yDisplacement2*5);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("SELECT")), xArrow + xDisplacement, yControl + yDisplacement2*6);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("UP")), xArrow + xDisplacement, yControl + yDisplacement2*7);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("DOWN")), xArrow + xDisplacement, yControl + yDisplacement2*8);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("LEFT")), xArrow + xDisplacement, yControl + yDisplacement2*9);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("RIGHT")), xArrow + xDisplacement, yControl + yDisplacement2*10);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("LTRIGGER")), xArrow + xDisplacement, yControl + yDisplacement2*11);
		gfx.drawString("" +KeyEvent.getKeyText(applet.getControls("RTRIGGER")), xArrow + xDisplacement, yControl + yDisplacement2*12);
		
		if(changeControlsMode == true && enterPressed == true && defaultSelected == false){
			//responsible for printing red arrow
			for(int i = 0; i < 12; i++){
				if(currentXPosition == 0 && currentYPosition == i)
					gfx.drawImage(arrow2, xArrow, yArrow + yDisplacement*i, applet);
			}
			applet.setControlsActive(true);
		}
		
		else if(changeControlsMode == false && defaultSelected == false){
			//responsible for printing regular arrow
			for(int i = 0; i < 13; i++){
				if(currentXPosition == 0 && currentYPosition == i)
					gfx.drawImage(arrow, xArrow, yArrow + yDisplacement*i, applet);
			}
			
			if(currentXPosition == 0 && currentYPosition == -1)
				gfx.drawImage(arrow, 68, 62, applet);
			else if(currentXPosition == 1 && currentYPosition == -1)
				gfx.drawImage(arrow, 68+270, 62, applet);

		}
		
		if(changeControlsMode == true && defaultSelected == false){
			//responsible for changing new control
			if(letter == 0)
				return;
			for(int i = 0; i < 12; i++){
				if(currentYPosition == i)
					gfx.drawString("" + KeyEvent.getKeyText(letter), xArrow + xDisplacement, yControl + yDisplacement2*(i+1));	
			}
		}
	}
	
	public Object getCalledObject(){
		if(object != null)
			return object;
		else
			return null;
	}
	
	public void increaseXPosition(){
		currentXPosition++;
		if(currentXPosition > 3)
			currentXPosition = 3;
	}
	
	public void decreaseXPosition(){
		currentXPosition--;
		if(currentXPosition < 0)
			currentXPosition = 0;
	}
	
	public void increaseYPosition(){
		if(currentXPosition < 1){
			currentYPosition++;
			if(currentYPosition > 12)
				currentYPosition = -1;
		}
	}
	
	public void decreaseYPosition(){
		if(currentXPosition < 1){
			currentYPosition--;
			if(currentYPosition < -1)
				currentYPosition = 12;
		}
	}
	
	public int getXPosition(){
		return currentXPosition;
	}
	
	public int getYPosition(){
		return currentYPosition;
	}
	
	public boolean getChangeControlsMode(){
		return changeControlsMode;
	}
	
	public void setChangeControlsMode(boolean temp){
		changeControlsMode = temp;
	}
	
	public void setEnterPressed(boolean temp){
		enterPressed = temp;
		
		if(enterPressed == true)
			changeControlsMode = true;
	}
	
	public void setLetter(int letter){
		this.letter = letter;
		if(letter != 0)
			changeControlsMode = false;
	}
	
	public void setDefaultSelected(boolean temp){
		defaultSelected = temp;
	}
	
	public boolean getDefaultSelected(){
		return defaultSelected;
	}
	
	
	public void setControlMode(boolean temp){
		changeControlsMode = temp;
	}
	

}
