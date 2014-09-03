import java.awt.*;

public class Scene1 {
	
	Image background;
	Image frame;
	Image[] monsters;
	Character character;
	OnePieceRPG applet;
	int currentXPosition;
	int currentYPosition;
	String direction;
	String lastDirection;
	boolean leftFoot;
	int randomBattle;
	
	public Scene1(Image background, Image frame, int x, int y, OnePieceRPG applet, Character character, Image[] monsters){
		this.background = background;
		this.frame = frame;
		this.applet = applet;
		this.character = character;
		this.monsters = monsters;
		leftFoot = false;
		direction = null;
		lastDirection = null;
		currentXPosition = x;
		currentYPosition = y;
	}
	
	public void paint(Graphics gfx, Graphics g, Image buffer, int x, int y){
		
		gfx.drawImage(background, -x, -y, applet);
		gfx.drawImage(frame, 0, 0, applet);
		
		gfx.setColor(Color.red);
		gfx.drawString("lastDirection = " +lastDirection, 50, 50);
		gfx.setColor(Color.red);
		gfx.drawString("lastDirection = " +randomBattle, 100, 100);
		
		if(direction == null && lastDirection == "DOWN")
			gfx.drawImage(character.getSprite(0), 500, 275, applet);
		else if(direction == null && lastDirection == "UP")
			gfx.drawImage(character.getSprite(15), 500, 275, applet);
		else if(direction == null && lastDirection == "LEFT")
			gfx.drawImage(character.getSprite(5), 500, 275, applet);
		else if(direction == null && lastDirection == "RIGHT")
			gfx.drawImage(character.getSprite(10), 500, 275, applet);
		else
			gfx.drawImage(character.getSprite(0), 500, 275, applet);
//==========================================================================	
//==========================================================================		
		if(direction == "DOWN"){
			if(leftFoot){
				for(int i = 30; i > 15; i--){
					gfx.drawImage(background, -x, -y+i, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(1), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
				for(int i = 15; i > 0; i--){
					gfx.drawImage(background, -x, -y+i, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(2), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
			}
			else {
				for(int i = 30; i > 15; i--){
					gfx.drawImage(background, -x, -y+i, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(3), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
				for(int i = 15; i > 0; i--){
					gfx.drawImage(background, -x, -y+i, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(4), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
			}
			leftFoot = !leftFoot;
			
		}
//==========================================================================
//==========================================================================		
		if(direction == "UP"){
			if(leftFoot){
				for(int i = 30; i > 15; i--){
					gfx.drawImage(background, -x, -y-i, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(16), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
				for(int i = 15; i > 0; i--){
					gfx.drawImage(background, -x, -y-i, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(17), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
			}
			else{
				for(int i = 30; i > 15; i--){
					gfx.drawImage(background, -x, -y-i, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(18), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
				for(int i = 15; i > 0; i--){
					gfx.drawImage(background, -x, -y-i, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(19), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
			}
			leftFoot = !leftFoot;
		}
//==========================================================================		
//==========================================================================
		if(direction == "LEFT"){
			if(leftFoot){
				for(int i = 30; i > 15; i--){
					gfx.drawImage(background, -x-i, -y, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(6), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
				for(int i = 15; i > 0; i--){
					gfx.drawImage(background, -x-i, -y, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(7), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
			}
			else{
				for(int i = 30; i > 15; i--){
					gfx.drawImage(background, -x-i, -y, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(8), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
				for(int i = 15; i > 0; i--){
					gfx.drawImage(background, -x-i, -y, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(9), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
			}
			leftFoot = !leftFoot;
		}
//==========================================================================		
//==========================================================================
		if(direction == "RIGHT"){
			if(leftFoot){
				for(int i = 30; i > 15; i--){
					gfx.drawImage(background, -x+i, -y, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(11), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
				for(int i = 15; i > 0; i--){
					gfx.drawImage(background, -x+i, -y, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(12), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
			}
			else{
				for(int i = 30; i > 15; i--){
					gfx.drawImage(background, -x+i, -y, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(13), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
				for(int i = 15; i > 0; i--){
					gfx.drawImage(background, -x+i, -y, applet);
					gfx.drawImage(frame, 0, 0, applet);
					gfx.drawImage(character.getSprite(14), 500, 275, applet);
					g.drawImage(buffer, 0, 0, applet);
				}
			}
			leftFoot = !leftFoot;
		}

	}
	
	public void increaseXPosition(){
		currentXPosition += 30;
	}
	
	public void decreaseXPosition(){
		currentXPosition -= 30;
	}
	
	public void increaseYPosition(){
		currentYPosition += 30;
	}
	
	public void decreaseYPosition(){
		currentYPosition -= 30;
	}
	
	public int getYPosition(){
		return currentYPosition;
	}
	
	public int getXPosition(){
		return currentXPosition;
	}
	
	public void setWalkDirection(String direction){
		this.direction = direction;
		if(direction != null)
			lastDirection = direction;
	}
	
	public String getWalkDirection(){
		return direction;
	}
	
	public void setRandomBattle(int random){
		randomBattle = random;
		if(randomBattle < 0)
			randomBattle*=-1;
		if(randomBattle < 5)
			randomBattle = 5;
	}
	
	public void decreaseRandomBattle(){
		randomBattle--;
	}
	
	public int getRandomBattle(){
		return randomBattle;
	}
	
	public Character getLeader(){
		return character;
	}
	
}
