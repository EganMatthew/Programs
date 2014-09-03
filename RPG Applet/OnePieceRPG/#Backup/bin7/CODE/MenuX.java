import java.awt.*;

public class MenuX {
	
	//===============CHARACTER CREATOR ATRIBUTES===================
	private static int numberOfItemsOnList = 5;
	
	//===============DRAWING THE SCREEN===================
	Image frame;
	OnePieceRPG applet;
	Image menuXBackground;
	Image arrow;
	Image arrow2;
	int currentYPosition;
	Object object;
	Color color;
	Font font;
	boolean onTheRight;
	boolean changeRow;
	
	public MenuX(Image menuXBackground, Image frame, Image arrow, Image arrow2, Object object, OnePieceRPG applet){
		this.frame = frame;
		this.applet = applet;
		this.object = object;
		this.menuXBackground = menuXBackground;
		this.arrow = arrow;
		this.arrow2 = arrow2;
		currentYPosition = 0;
		color = new Color(0, 0, 150);
		onTheRight = true;	
		changeRow = false;
	}
	
	public void paint(Graphics g){
		
		font = new Font("Gungsuh", Font.PLAIN, 25);
		g.setFont(font);
		
		g.drawImage(menuXBackground, 0, 0, applet);
		g.drawImage(frame, 0, 0, applet);
		
		for(int i = 0; i < applet.getCurrentPartyInControl().getNumberOfMembers(); i++){
			if(applet.getCurrentPartyInControl().getParty()[i].getFrontRow())
				g.drawImage(applet.getCurrentPartyInControl().getParty()[i].getPortrait(0), 200, 90+(i*95), applet);
			else
				g.drawImage(applet.getCurrentPartyInControl().getParty()[i].getPortrait(0), 150, 90+(i*95), applet);
		}
		
		for(int i = 0; i < applet.getCurrentPartyInControl().getNumberOfMembers(); i++){
			g.drawString("" +applet.getCurrentPartyInControl().getParty()[i].getName(), 300, 110+(i*95));
			g.drawString("HP:   " +applet.getCurrentPartyInControl().getParty()[i].currentHP
					+"  /  " +applet.getCurrentPartyInControl().getParty()[i].HP, 300, 130+(i*95));
			g.drawString("AP:   " +applet.getCurrentPartyInControl().getParty()[i].currentAP
					+"  /  " +applet.getCurrentPartyInControl().getParty()[i].AP, 300, 150+(i*95));
		}
		
		g.setColor(Color.black);
		
			g.drawString("Items", 750, 120+(0*35));
			g.drawString("Skills", 750, 120+(1*35));
			g.drawString("Equip", 750, 120+(2*35));
			g.drawString("Status", 750, 120+(3*35));
			g.drawString("Options", 750, 120+(4*35));
			
			if(applet.getCurrentPartyInControl().getAtSavePoint()){
				g.drawString("Save", 750, 120+(5*35));
				numberOfItemsOnList = 6;
			}
		
		if(onTheRight){
			for(int i = 0; i < numberOfItemsOnList; i++)
				if(currentYPosition == i)
					g.drawImage(arrow, 700, 89+(i*35), applet);
		}
		else if(!changeRow){
			for(int i = 0; i < applet.getCurrentPartyInControl().getNumberOfMembers(); i++)
				if(currentYPosition == i)
					g.drawImage(arrow, 100, 110+(i*95), applet);
		}
		else if(changeRow){
			for(int i = 0; i < applet.getCurrentPartyInControl().getNumberOfMembers(); i++)
				if(currentYPosition == i)
					g.drawImage(arrow2, 100, 110+(i*95), applet);
		}
		
		
	}
	
	public Object getCalledObject(){
		return object;
	}
	
	public void increaseXPosition(){
		if(!changeRow){
			onTheRight = true;
			currentYPosition = 0;
		}
		else
			applet.getCurrentPartyInControl().getParty()[currentYPosition].setFrontRow(true);
	}
	public void decreaseXPosition(){
		if(!changeRow){
			onTheRight = false;
			currentYPosition = 0;
		}
		else
			applet.getCurrentPartyInControl().getParty()[currentYPosition].setFrontRow(false);
	}
	public void increaseYPosition(){
		
		if(!changeRow){
			if(onTheRight){
				currentYPosition++;
				if(currentYPosition > numberOfItemsOnList-1)
					currentYPosition = 0;
			}
			else{
				currentYPosition++;
				if(currentYPosition > applet.getCurrentPartyInControl().getNumberOfMembers()-1)
					currentYPosition = 0;
			}
		}
	
	}
	public void decreaseYPosition(){
		if(!changeRow){
			if(onTheRight){
			currentYPosition--;
				if(currentYPosition < 0)
					currentYPosition = numberOfItemsOnList-1;
			}
			else{
				currentYPosition--;
				if(currentYPosition < 0)
					currentYPosition = applet.getCurrentPartyInControl().getNumberOfMembers()-1;
			}
		}
	}
	
	public boolean getOnTheRight(){
		return onTheRight;
	}
	
	public void setChangeRow(boolean temp){
		changeRow = temp;
	}
	
	public int getYPosition(){
		return currentYPosition;
	}
	
}
