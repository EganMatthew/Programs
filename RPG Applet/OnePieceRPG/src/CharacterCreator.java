import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class CharacterCreator{
	
	
	//===============CHARACTER CREATOR ATRIBUTES===================
	private final static int acceptableNameLength = 7;
	//===============DRAWING THE SCREEN===================
	Image background;
	Image arrow;
	char letter;
	Image cursor;
	Image backspace;
	char[] defaultLetters;
	int currentNameSpot;
	OnePieceRPG applet;
	MainMenu mainMenu;
	Object object;
	int currentXPosition, currentYPosition;
	boolean enterPressed, backspacePressed, defaultSelected;
	Font font;
	
	//===============CHARACTER ATRIBUTES===================
	char[] characterName;		//Character name
	int characterNameLength;	//Character name length
	
	public CharacterCreator(Image background, Image arrow, Image cursor, Image backspace, char defaultLetters[], Object object, OnePieceRPG applet){
		this.background = background;			//background
		this.arrow = arrow;
		this.applet = applet;
		this.cursor = cursor;
		this.backspace = backspace;
		this.characterName = new char[acceptableNameLength];
		this.defaultLetters = defaultLetters;
		currentXPosition = 0;
		currentYPosition = 0;
		currentNameSpot = 5;
		enterPressed = false;
		backspacePressed = false;
		defaultSelected = true;
		currentXPosition = 0;
		currentYPosition = 0;
		currentNameSpot = 5;
		enterPressed = false;
		backspacePressed = false;
		defaultSelected = true;
	}
	
	public void paint(Graphics gfx){
		gfx.drawImage(background, 0, 0, applet);
		font = new Font("Gungsuh", Font.PLAIN, 25);
		gfx.setFont(font);
		gfx.setColor(Color.black);
		
		if(defaultSelected == true){
			//draws default name
			gfx.drawImage(backspace, 176, 120, applet);
			gfx.drawImage(backspace, 208, 120, applet);
			gfx.drawImage(backspace, 240, 120, applet);
			gfx.drawImage(backspace, 272, 120, applet);
			gfx.drawImage(backspace, 304, 120, applet);
			gfx.drawString("" + defaultLetters[0], 178, 137);
			characterName[0] = defaultLetters[0];
			gfx.drawString("" + defaultLetters[1], 210, 137);
			characterName[1] = defaultLetters[1];
			gfx.drawString("" + defaultLetters[2], 242, 137);
			characterName[2] = defaultLetters[2];
			gfx.drawString("" + defaultLetters[3], 274, 137);
			characterName[3] = defaultLetters[3];
			gfx.drawString("" + defaultLetters[4], 306, 137);
			characterName[4] = defaultLetters[4];
			gfx.drawImage(backspace, 336, 120, applet);
			gfx.drawImage(backspace, 368, 120, applet);
			gfx.drawImage(backspace, 400, 120, applet);
			gfx.drawImage(backspace, 432, 120, applet);
			gfx.drawImage(backspace, 464, 120, applet);
			characterName[5] = defaultLetters[5];
			characterName[6] = defaultLetters[6];
			currentNameSpot = 5;
		}
//==========================================================================		
		//responsible for printing the cursor

		for(int i = 0; i < acceptableNameLength; i++){
			if(currentNameSpot == i){
				gfx.drawImage(cursor, 178+(i*32), 143, applet);
			}
		}

//==========================================================================
		//responsible for backspacing
		if(enterPressed == true && backspacePressed == true){
			for(int i = 0; i < acceptableNameLength; i++){
				if(currentNameSpot == i)
					gfx.drawImage(backspace, 176+(i*32), 120, applet);
			}
		}
//==========================================================================
	//PRINTS THE LETTERS ON THE _ _ _ _ _ _ _ _ _ _

		if(enterPressed == true && backspacePressed == false){
			for(int i = 1; i < acceptableNameLength+1; i++){
				if(currentNameSpot == acceptableNameLength)
					gfx.drawImage(backspace, 176+((currentNameSpot-1)*32), 120, applet);
				if(currentNameSpot == i)
					gfx.drawString("" + letter, 178+(i*32)-32, 137);
			}
		}
		
//==========================================================================
		//responsible for printing the arrow
		for(int j = 0; j < 7; j++){
			for(int i = 0; i < 4; i++){
				if(currentXPosition == i && currentYPosition == j)
					gfx.drawImage(arrow, 67+(i*64), 181+(j*25), applet);
			}
		}
		
		for(int j = 0; j < 7; j++){
			for(int i = 0; i < 4; i++){
				if(currentXPosition == i+4 && currentYPosition == j)
					gfx.drawImage(arrow, 340+(i*64), 181+(j*25), applet);
			}
		}
			
		
		for(int i = 0; i < 4; i++){
			if(currentXPosition == 0 && currentYPosition == 7)
				gfx.drawImage(arrow, 57, 387, applet);
		}
		
		if(currentXPosition == 0 && currentYPosition == 7)
			gfx.drawImage(arrow, 57, 387, applet);
		else if(currentXPosition == 1 && currentYPosition == 7)
			gfx.drawImage(arrow, 167, 387, applet);
		else if(currentXPosition == 2 && currentYPosition == 7)
			gfx.drawImage(arrow, 297, 387, applet);
		else if(currentXPosition == 3 && currentYPosition == 7)
			gfx.drawImage(arrow, 442, 387, applet);
	}
	
	public int getXPosition(){
		return currentXPosition;
	}
	
	public int getYPosition(){
		return currentYPosition;
	}

	public int getCharacterNameLength(){
		return characterNameLength;
	}
	
	public boolean setCharacterNameLength(){
		
		characterNameLength = currentNameSpot;
		characterNameLength--;
		if(characterName[0] == ' '){
			characterNameLength = 0;
			defaultSelected = true;
			setLetter(' ');
			return false;
		}
		
		if(characterNameLength != 0 && characterName[characterNameLength] == ' '){
			characterNameLength--;
			if(characterNameLength != 0 && characterName[characterNameLength] == ' '){
				characterNameLength--;
				if(characterNameLength != 0 && characterName[characterNameLength] == ' '){
					characterNameLength--;
					if(characterNameLength != 0 && characterName[characterNameLength] == ' '){
						characterNameLength--;
						if(characterNameLength != 0 && characterName[characterNameLength] == ' '){
							characterNameLength--;
							if(characterNameLength != 0 && characterName[characterNameLength] == ' '){
								characterNameLength--;
							}
						}
					}
				}
			}
		}
		characterNameLength++;
		if(characterNameLength <= 0)
			return false;
		
		return true;
	}

	public char[] getCharacterName(){
		return characterName;
	}

	public void setEnterPressed(boolean temp){
		enterPressed = temp;
	}
	
	public Object getCalledObject(){
		if(object != null)
			return object;
		else
			return null;
	}
	
	public void setBackspacePressed(boolean temp){
		backspacePressed = temp;
	}
	
	public void setDefault(boolean temp){
		defaultSelected = temp;
	}
	
	public void setLetter(char temp){
		letter = temp;
	
		if(backspacePressed == true){
			currentNameSpot--;
			if(currentNameSpot < 0)
				currentNameSpot = 0;
			characterName[currentNameSpot] = letter;
		}
		else{
			if(currentNameSpot > acceptableNameLength-1)
				currentNameSpot = acceptableNameLength-1;
			characterName[currentNameSpot] = letter;
			currentNameSpot++;
		}
		
		if(currentXPosition != 3 && currentYPosition != 7)
			defaultSelected = false;
		
		enterPressed = true;
	}
	
	public void increaseXPosition(){
		currentXPosition++;
		
		if(currentXPosition == 2 && currentYPosition == 6){
			currentXPosition = 4;
			currentYPosition = 6;
		}
		else if(currentXPosition == 6 && currentYPosition == 6){
			currentXPosition = 0;
			currentYPosition = 6;
		}
		else if(currentXPosition == 4 && currentYPosition == 7){
			currentXPosition = 0;
			currentYPosition = 7;
		}
		
		if(currentXPosition > 7)
			currentXPosition = 0;
	}
	
	public void decreaseXPosition(){
		currentXPosition--;
		
		if(currentXPosition < 0 && currentYPosition == 6){
			currentXPosition = 5;
			currentYPosition = 6;
		}
		else if(currentXPosition == 3 && currentYPosition == 6){
			currentXPosition = 1;
			currentYPosition = 6;
		}
		else if(currentXPosition < 0 && currentYPosition == 7){
			currentXPosition = 3;
			currentYPosition = 7;
		}
		
		if(currentXPosition < 0)
			currentXPosition = 7;
	}
	
	public void increaseYPosition(){
		currentYPosition++;
		
		if(currentXPosition == 1 && currentYPosition == 7){
			currentXPosition = 0;
			currentYPosition = 7;
		}
		else if((currentXPosition == 2 || currentXPosition == 3) && currentYPosition == 6){
			currentXPosition = 1;
			currentYPosition = 7;
		}
		else if((currentXPosition == 4 || currentXPosition == 5) && currentYPosition == 7){
			currentXPosition = 2;
			currentYPosition = 7;
		}
		else if((currentXPosition == 6 || currentXPosition == 7) && currentYPosition == 6){
			currentXPosition = 3;
			currentYPosition = 7;
		}
		else if(currentXPosition == 0 && currentYPosition > 7){
			currentXPosition = 0;
			currentYPosition = 0;
		}
		else if(currentXPosition == 1 && currentYPosition > 7){
			currentXPosition = 2;
			currentYPosition = 0;
		}
		else if(currentXPosition == 2 && currentYPosition > 7){
			currentXPosition = 4;
			currentYPosition = 0;
		}
		else if(currentXPosition == 3 && currentYPosition > 7){
			currentXPosition = 6;
			currentYPosition = 0;
		}
	}
	
	public void decreaseYPosition(){
		currentYPosition--;


		if((currentXPosition == 0 || currentXPosition == 1) && currentYPosition < 0){
			currentXPosition = 0;
			currentYPosition = 7;
		}
		else if((currentXPosition == 2 || currentXPosition == 3) && currentYPosition < 0){
			currentXPosition = 1;
			currentYPosition = 7;
		}
		else if((currentXPosition == 4 || currentXPosition == 5) && currentYPosition < 0){
			currentXPosition = 2;
			currentYPosition = 7;
		}
		else if((currentXPosition == 6 || currentXPosition == 7) && currentYPosition < 0){
			currentXPosition = 3;
			currentYPosition = 7;
		}

		else if(currentXPosition == 0 && currentYPosition == 6){
			currentXPosition = 0;
			currentYPosition = 6;
		}
		else if(currentXPosition == 1 && currentYPosition == 6){
			currentXPosition = 2;
			currentYPosition = 5;
		}
		else if(currentXPosition == 2 && currentYPosition == 6){
			currentXPosition = 4;
			currentYPosition = 6;
		}
		else if(currentXPosition == 3 && currentYPosition == 6){
			currentXPosition = 6;
			currentYPosition = 5;
		}
	}

}
