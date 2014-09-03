import java.awt.*;


public class Character {

	//===============CHARACTER STATUS===================
	String name;
	Image[] characterSprite;
	Image[] characterPortrait;
	Image[] characterRegularAttack;
	Image[] characterExtras;
	int nameLength;
	int STR;
	int currentSTR;
	int DEF;
	int currentDEF;
	int WIS;
	int currentWIS;
	int AP;
	int currentAP;
	int HP;
	int currentHP;
	int SPEED;
	int currentSPEED;
	String FRUIT;
	int[] ABILITIES;
	int bounty;
	
	//===============CONTROL VARIABLES===================
	Character[] partyMembers;
	int memberSpot;
	boolean frontRow;
	boolean readyToAttack;
	boolean atSavePoint;
	int waitTime;
	OnePieceRPG applet;
	
	public Character(char[] name, int nameLength, Object object, OnePieceRPG applet, Image[] characterSprite, Image[] characterPortrait, Image[] characterRegularAttack, Image[] characterExtras){
		this.name = new String(name);
		this.nameLength = nameLength;
		this.characterSprite = characterSprite;
		this.characterPortrait = characterPortrait;
		this.characterRegularAttack = characterRegularAttack;
		this.characterExtras = characterExtras;
		this.applet = applet;
		frontRow = true;
		partyMembers = new Character[9];
		memberSpot = 0;
		readyToAttack = false;
		atSavePoint = false;
		waitTime = 500;
		bounty = 0;
		
		if(object == applet.mainMenu){
			STR = 4;
			DEF = 2;
			WIS = 0;
			AP = 10;
			HP = 20;
			SPEED = 3;
			currentSTR = STR;
			currentDEF = DEF;
			currentWIS = WIS;
			currentAP = AP;
			currentHP = HP;
			currentSPEED = SPEED;
		}

	}
	
	public Character[] getParty(){
		return partyMembers;
	}
	
	public void addToParty(Character temp){
		
		if(memberSpot == 4){
			//Party is full error Message
			return;
		}
			
		partyMembers[memberSpot] = temp;
		memberSpot++;
	}
	
	public void removeFromParty(Character temp){
		
		if(partyMembers[memberSpot] == temp){
			partyMembers[memberSpot] = null;
			memberSpot--;
			return;
		}
		
		for(int i = 0; i < memberSpot; i++){
			if(partyMembers[i] == temp){
				partyMembers[i] = partyMembers[i+1];
				if(partyMembers[i+2] != null){
					partyMembers[i+1] = partyMembers[i+2];
					memberSpot--;
					return;
				}
				memberSpot--;
				return;
			}
		}
	}
	
	public int getNumberOfMembers(){
		return memberSpot;
	}
	
	public Image getSprite(int temp){
		return characterSprite[temp];
	}
	
	public Image getPortrait(int temp){
		return characterPortrait[temp];
	}
	
	public boolean getFrontRow(){
		return frontRow;
	}
	
	public void setFrontRow(boolean temp){
		frontRow = temp;
	}
	
	public boolean getReadyToAttack(){
		return readyToAttack;
	}
	
	public void setReadyToAttack(boolean temp){
		readyToAttack = temp;
		if(!readyToAttack)
			waitTime = 500;
		else
			waitTime = -50;
	}
	
	public String getName(){
		return name;
	}
	
	public int getNameLength(){
		return nameLength;
	}
	
	public void decreaseWaitTime(){
		waitTime -= 1 + currentSPEED*(.1);
		if(waitTime < 0)
			waitTime = 0;
	}
	
	public int getWaitTime(){
		return waitTime;
	}
	
	public void setAtSavePoint(boolean temp){
		atSavePoint = temp;
	}
	
	public boolean getAtSavePoint(){
		return atSavePoint;
	}
	
	public int dealDamage(Monster monster){
		int result;
		result = currentSTR - monster.currentDEF/2;
		if(result < 0)
			result = 1;
		
		return result;
	}
	
	public boolean acceptDamage(int damage){
		currentHP -= damage;
		
		if(currentHP > 0)
			return true;
		if(currentHP <= 0)
			return false;
		
		return false;

	}

}
