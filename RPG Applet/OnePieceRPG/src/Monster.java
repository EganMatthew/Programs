import java.awt.Image;


public class Monster {
	
	
	//===============MONSTER STATUS===================
	int leaderBounty;
	int monsterBounty;
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
	
	//===============CONTROL VARIABLES===================
	Character[] partyMembers;
	Character leader;
	int memberSpot;
	boolean frontRow;
	boolean readyToAttack;
	int waitTime;
	
	public Monster(int leaderBounty, Character leader){
		this.leaderBounty = leaderBounty;
		this.leader = leader;
		readyToAttack = false;
		waitTime = 500;
		
		if(leaderBounty < 1000){
			STR = 4+(leaderBounty/25);
			DEF = 2+(leaderBounty/25);
			WIS = 0+(leaderBounty/25);
			AP = 10+(leaderBounty/25);
			HP = 20+(leaderBounty/25);
			SPEED = 3+(leaderBounty/25);
			currentSTR = STR;
			currentDEF = DEF;
			currentWIS = WIS;
			currentAP = AP;
			currentHP = HP;
			currentSPEED = SPEED;
		}
		else{
			//buy my expansion pack, hahahaha
		}
	}
	
	public boolean acceptDamage(int damage){
		currentHP -= damage;
		
		if(currentHP > 0)
			return true;
		if(currentHP <= 0)
			return false;
		
		return false;

	}
	
	public boolean getReadyToAttack(){
		return readyToAttack;
	}
	
	public void decreaseWaitTime(){
		waitTime -= 1 + currentSPEED*(.1);
		if(waitTime < 0)
			waitTime = 0;
	}
	
	public void setReadyToAttack(boolean temp){
		readyToAttack = temp;
		if(!readyToAttack)
			waitTime = 500;
		else
			waitTime = -50;
	}
	
	public int dealDamage(Character character){
		int result;
		result = currentSTR - character.currentDEF/2;
		if(result < 0)
			result = 1;
		
		return result;
	}

}
