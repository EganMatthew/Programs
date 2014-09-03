import java.awt.*;


public class Battle {
	
	Image background;
	Image frame;
	Image arrow;
	Object object;
	OnePieceRPG applet;
	Monster monster;
	GameOver gameOver;
	Image monsterImage;
	Character leader;
	Character[] fighters;
	int returnX;
	int returnY;
	int currentYPosition;
	int textBoxLoop;
	int[] attackQueue;
	int endOfQueue;
	boolean doThisOnlyOnce;
	boolean drawComplete;
	boolean enterPressed;
	boolean activeTrueWaitFalse;
	boolean addToQueueToggle;
	Color color;
	Font font;
	Font font2;
	
	public Battle(Image background, Image frame, Image arrow, Object object, int x, int y, OnePieceRPG applet, Character leader){
		this.background = background;
		this.arrow = arrow;
		this.object = object;
		this.applet = applet;
		this.frame = frame;
		this.fighters = leader.getParty();
		this.leader = leader;
		attackQueue = new int[10];
		attackQueue[0] = 50;
		attackQueue[1] = 50;
		attackQueue[2] = 50;
		attackQueue[3] = 50;
		attackQueue[4] = 50;
		attackQueue[5] = 50;
		attackQueue[6] = 50;
		attackQueue[7] = 50;
		attackQueue[8] = 50;
		attackQueue[9] = 50;
		currentYPosition = 0;
		color = new Color(0, 0, 150);
		doThisOnlyOnce = true;
		drawComplete = false;
		enterPressed = false;
		addToQueueToggle = false;
		endOfQueue = 0;
		activeTrueWaitFalse = applet.activeOrWait;
		returnX = x;
		returnY = y;
		if(object == applet.scene1)
			monsterImage = applet.monsters[applet.generator.nextInt()%1];
		monster = new Monster(leader.bounty, leader);
	}
	
	public boolean paint(Graphics g, Graphics gfx, Image buffer){
//==========================================================================
//==START OF PAINT FUNCTION=================================================
//==========================================================================
		font = new Font("Gungsuh", Font.PLAIN, 25);
		font2 = new Font("Gungsuh", Font.BOLD, 15);
		gfx.setFont(font);
		
		if(doThisOnlyOnce == true){
			drawBlackBox(g, gfx, buffer);
			drawRightBlueBox(g, gfx, buffer);
			//prints partyMembers name
			drawWaitBoxNames(g);
			//prints wait box
			drawWaitBoxBorder(g);
			//prints white fill in wait box
			drawFillWaitBoxBorder(g);
		}
		doThisOnlyOnce = false;
//==========================================================================		
//==========================================================================

			for(int i = 0; i < leader.getNumberOfMembers(); i++){
				g.drawImage(leader.getParty()[i].getSprite(10), 200-(i*30), 100+(i*50), applet);
			}

		
			g.drawImage(monsterImage, 700, 150, applet);
		
		
		
		
//==========================================================================				
//==========================================================================
//==THIS FOR LOOP CONTROLS IT ALL===========================================
//==========================================================================
//==========================================================================
		for(int i = 0; i < leader.getNumberOfMembers(); i++){
			for(int j = 0; j < leader.getNumberOfMembers(); j++)
				drawWaitBoxProgress(g, j, true);
			
//==========================================================================
//==IF READY TO ATTACK SHOW THE ACTION BOX (ON THE LEFT)====================
//==========================================================================
			if(fighters[i].getReadyToAttack() && drawComplete == false && i == attackQueue[0]){
				g.setColor(color);
				int displacement = 0;
				for(textBoxLoop = 400; textBoxLoop > 0; textBoxLoop-=7){
					
					g.fillRect(290-displacement, 340, 400-textBoxLoop, 135);
					if(textBoxLoop%2 == 0)
						displacement+=7;
					if(displacement == 455)
						displacement = 454;
					gfx.drawImage(buffer, 0, 0, applet);
				}
				
				printLeftBoxText(g, i);
				
				drawComplete = true;
			}

			drawWaitBoxProgress(g, i, false);

//==========================================================================
//==PRINTS THE ARROWS=======================================================
//==========================================================================
			if(fighters[i].getReadyToAttack()){
				g.setColor(color);
				g.fillRect(200, 340, 50, 130);
				
				for(int j = 0; j < 3; j++)
					if(currentYPosition == j){
						g.drawImage(arrow, 200, 340+(j*30), applet);
					}
			}
			
//==========================================================================
//==IF NOT READY ENTER IS NOT PRESSED=======================================
//==========================================================================
			if(enterPressed){
				if(!fighters[0].getReadyToAttack() && !fighters[1].getReadyToAttack() && !fighters[2].getReadyToAttack() && !fighters[3].getReadyToAttack())
					enterPressed = false;
			}
			
//==========================================================================
//==MONSTER IS ATTACKING===================================================
//==========================================================================
			//add monster attack queue
			if(monster.getReadyToAttack()){
				int randomFighter = applet.generator.nextInt()%(leader.getNumberOfMembers());
				int damageDone = monster.dealDamage(fighters[randomFighter]);
				boolean gameOverOrNot = true;
				monsterAttackAnimation(g, gfx, buffer, damageDone, randomFighter, i);
				
				
				if(fighters[randomFighter].acceptDamage(damageDone)){
					gfx.setColor(Color.red);
					gfx.drawString("" +damageDone, 300, 170);
				}
				else{
					for(int j = 0; j < leader.getNumberOfMembers(); j++){
						if(fighters[j].currentHP > 0){
							gameOverOrNot = false;
						}
					}
					if(gameOverOrNot == true){
						monster = null;
						//in game over set battle to null && called object;
						gameOver = new GameOver();
					}
					
					//remove fighter[randomFighter] from battle
					
				}
				
				monster.setReadyToAttack(false);
			}
			
//==========================================================================
//==PLAYER IS ATTACKING=====================================================
//==========================================================================
			if(fighters[i].getReadyToAttack() && currentYPosition == 0 && enterPressed  && i == attackQueue[0]){
				
				int damageDone = fighters[i].dealDamage(monster);
				luffyRegularAttackAnimation(g, gfx, buffer, i, damageDone);
				
				if(monster.acceptDamage(damageDone)){
					gfx.setColor(Color.red);
					gfx.drawString("" +damageDone, 670, 170);
				}
				else{
					if(applet.scene1 == object){
						monster = null;
						for(int j = 0; j < leader.getNumberOfMembers(); j++){
							fighters[j].setReadyToAttack(false);
						}
						return true;
					}
				}

				fighters[i].setReadyToAttack(false);
				removeFromQueue();
				drawComplete = false;
				enterPressed = false;
				
				callLotsOfFunctions(g, i, 0,  0, false);
			}
			
//==========================================================================
//==READY TO ATTACK YET????=================================================
//==========================================================================
			if(fighters[i].waitTime < 1 && fighters[i].waitTime > -5){
				fighters[i].setReadyToAttack(true);
				addToQueueToggle = true;
			}
			
			if(monster.waitTime < 1 && monster.waitTime > -5){
				monster.setReadyToAttack(true);
			}
			
			if(fighters[i].getReadyToAttack() && addToQueueToggle == true){
				addToQueue(i);
				addToQueueToggle = false;
			}
		}
//==========================================================================
//==END OF PAINT FUNCTION===================================================
//==========================================================================
			
		//g.setColor(Color.red);
		//g.drawString("" +monster.waitTime, 50, 50);
		//printQueue(g);
		//printReadyToAttack(g);
		
		return false;
	}
	
//==========================================================================
//==BASIC FUNCTIONS=========================================================
//==========================================================================
	public void increaseYPosition(){
		currentYPosition++;
		if(currentYPosition > 2)
			currentYPosition = 2;
	}
	
	public void decreaseYPosition(){
		currentYPosition--;
		if(currentYPosition < 0)
			currentYPosition = 0;
	}
	
	public void setEnterPressed(boolean temp){
		enterPressed = temp;
	}
	
//==========================================================================
//==QUEUE FUNCTIONS=========================================================
//==========================================================================
	public void addToQueue(int i){		
		attackQueue[endOfQueue] = i;
		endOfQueue++;
		if(endOfQueue > 9)
			endOfQueue = 9;
	}
	
	public void removeFromQueue(){
		int j = 0;
		while(j != 9 && j != 50){
			attackQueue[j] = attackQueue[j+1];
			j++;
		}
		attackQueue[9] = 50;
		endOfQueue--;
	}
	
	
	
//==========================================================================
//==FUNCTION HUB============================================================
//==========================================================================	
	public void callLotsOfFunctions(Graphics g, int i, int randomFighter, int damageDone, boolean monsterAttacking){
		g.drawImage(background, 0, 0, applet);
		g.drawImage(frame, 0, 0, applet);
		g.setColor(Color.red);
		
		if(!monsterAttacking)
			g.drawImage(monsterImage, 700, 150, applet);
		if(damageDone > 0 && !monsterAttacking)
			g.drawString(""+damageDone, 700, 150);
		else if(damageDone > 0 && monsterAttacking)
			g.drawString(""+damageDone, 200-(randomFighter*30), 100+(randomFighter*50));
		
		g.setColor(Color.black);
		g.fillRect(59, 329, 884, 158);
		g.setColor(color);
		g.fillRect(522, 340, 400, 135);
		drawWaitBoxNames(g);
		drawWaitBoxBorder(g);
		drawFillWaitBoxBorder(g);
		
		if(!monsterAttacking){
			drawWaitBoxProgress(g, i, true);
			for(int j = 0; j < leader.getNumberOfMembers(); j++){
				if(fighters[i] != fighters[j])
					g.drawImage(leader.getParty()[j].getSprite(10), 200-(j*30), 100+(j*50), applet);
			}
		}
		else{
			for(int j = 0; j < leader.getNumberOfMembers(); j++){
				g.drawImage(leader.getParty()[j].getSprite(10), 200-(j*30), 100+(j*50), applet);
			}
			//g.setColor(color);
			//g.fillRect(75, 340, 400, 135);
			//printLeftBoxText(g, i);

		}
	}
	
	
//==========================================================================
//==LUFFY ATTACK ANIMATION==================================================
//==========================================================================
	//add this method to character class
	public void luffyRegularAttackAnimation(Graphics g, Graphics gfx, Image buffer, int i, int damageDone){
		if(leader.getNumberOfMembers() > 2){
			final long delay = 10;
			long temp = System.currentTimeMillis();
			for(int j = 0; j < 20; j++){

				g.drawImage(leader.getParty()[i].characterRegularAttack[0], 200-(i*30)+(j), 100+(i*50), applet);
				gfx.drawImage(buffer, 0, 0, applet);
				callLotsOfFunctions(g, i, 0, damageDone, false);
				
				while(System.currentTimeMillis() == temp + delay){}
			}
			temp = System.currentTimeMillis();
			for(int j = 20; j < 30; j++){
				g.drawImage(leader.getParty()[i].characterRegularAttack[1], 200-(i*30)+(j), 100+(i*50), applet);
				gfx.drawImage(buffer, 0, 0, applet);
				callLotsOfFunctions(g, i, 0, damageDone, false);
				while(System.currentTimeMillis() == temp + delay){}
			}
			temp = System.currentTimeMillis();
			for(int j = 30; j < 35; j++){
				callLotsOfFunctions(g, i, 0, damageDone, false);
				g.drawImage(leader.getParty()[i].characterRegularAttack[2], 200-(i*30)+(j), 100+(i*50), applet);
				gfx.drawImage(buffer, 0, 0, applet);
				while(System.currentTimeMillis() == temp + delay){}
			}
			temp = System.currentTimeMillis();
			for(int j = 30; j < 80; j++){
				
				callLotsOfFunctions(g, i, 0, damageDone, false);
				
				g.drawImage(leader.getParty()[i].characterRegularAttack[2], 200-(i*30)+(34), 100+(i*50), applet);
				for(int k = 30; k < j; k++)
					g.drawImage(leader.getParty()[i].characterExtras[0], 260-(i*30)-(k), 123+(i*50), applet);
				g.drawImage(leader.getParty()[i].characterExtras[2], 252-(i*30)-(j), 120+(i*50), applet);
				gfx.drawImage(buffer, 0, 0, applet);
				while(System.currentTimeMillis() == temp + delay){}
			}
			temp = System.currentTimeMillis();
			for(int j = 80; j > 30; j--){
				
				callLotsOfFunctions(g, i, 0, damageDone, false);
				
				g.drawImage(leader.getParty()[i].characterRegularAttack[2], 200-(i*30)+(34), 100+(i*50), applet);
				for(int k = 30; k < j; k++)
					g.drawImage(leader.getParty()[i].characterExtras[0], 260-(i*30)-(k), 123+(i*50), applet);
				g.drawImage(leader.getParty()[i].characterExtras[2], 252-(i*30)-(j), 120+(i*50), applet);
				gfx.drawImage(buffer, 0, 0, applet);
				while(System.currentTimeMillis() == temp + delay){}
			}
			temp = System.currentTimeMillis();
			for(int j = 30; j < 40; j++){
				callLotsOfFunctions(g, i, 0, damageDone, false);
				g.drawImage(leader.getParty()[i].characterRegularAttack[3], 200-(i*30)+(j), 100+(i*50), applet);
				gfx.drawImage(buffer, 0, 0, applet);
				while(System.currentTimeMillis() == temp + delay){}
			}
			temp = System.currentTimeMillis();
			for(int j = 30; j < 40; j++){
				callLotsOfFunctions(g, i, 0, damageDone, false);
				g.drawImage(leader.getParty()[i].characterRegularAttack[4], 200-(i*30)+(j), 100+(i*50), applet);
				gfx.drawImage(buffer, 0, 0, applet);
				while(System.currentTimeMillis() == temp + delay){}
			}
			temp = System.currentTimeMillis();
			for(int j = 40; j < 80; j++){
				
				callLotsOfFunctions(g, i, 0, damageDone, false);
				
				g.drawImage(leader.getParty()[i].characterRegularAttack[4], 200-(i*30)+(34), 100+(i*50), applet);
				for(int k = 40; k < j; k++)
					g.drawImage(leader.getParty()[i].characterExtras[0], 230-(i*30)+(k), 116+(i*50), applet);
				g.drawImage(leader.getParty()[i].characterExtras[1], 235-(i*30)+(j), 113+(i*50), applet);
				gfx.drawImage(buffer, 0, 0, applet);
				while(System.currentTimeMillis() == temp + delay){}
			}
			temp = System.currentTimeMillis();
			for(int j = 80; j > 40; j--){
				
				callLotsOfFunctions(g, i, 0, damageDone, false);
				
				g.drawImage(leader.getParty()[i].characterRegularAttack[4], 200-(i*30)+(34), 100+(i*50), applet);
				for(int k = 40; k < j; k++)
					g.drawImage(leader.getParty()[i].characterExtras[0], 230-(i*30)+(k), 116+(i*50), applet);
				g.drawImage(leader.getParty()[i].characterExtras[1], 235-(i*30)+(j), 113+(i*50), applet);
				gfx.drawImage(buffer, 0, 0, applet);
				while(System.currentTimeMillis() == temp + delay){}
			}
			temp = System.currentTimeMillis();
			for(int j = 40; j > 0; j--){
				callLotsOfFunctions(g, i, 0, damageDone, false);
				g.drawImage(leader.getParty()[i].characterSprite[0], 200-(i*30)+(j), 100+(i*50), applet);
				gfx.drawImage(buffer, 0, 0, applet);
				while(System.currentTimeMillis() == temp + delay){}
			}
			
			callLotsOfFunctions(g, i, 0, damageDone, false);	
		}
		
	}
	
//==========================================================================
//==MONSTER ATTACK ANIMATION================================================
//==========================================================================
	//add this method to monster class
	public void monsterAttackAnimation(Graphics g, Graphics gfx, Image buffer, int damageDone, int randomFighter, int currentFighter){
		
		
		for(int i = 0; i < 20; i++){
			callLotsOfFunctions(g, currentFighter, randomFighter, damageDone, true);
			g.drawImage(monsterImage, 700-i, 150, applet);
			for(int j = 0; j < leader.getNumberOfMembers(); j++)
				drawWaitBoxProgress(g, j, true);
			gfx.drawImage(buffer, 0, 0, applet);
		}
		for(int i = 20; i > 0; i--){
			callLotsOfFunctions(g, currentFighter, randomFighter, damageDone, true);
			g.drawImage(monsterImage, 700-i, 150, applet);
			for(int j = 0; j < leader.getNumberOfMembers(); j++)
				drawWaitBoxProgress(g, j, true);
			gfx.drawImage(buffer, 0, 0, applet);
		}
		

		callLotsOfFunctions(g, currentFighter, randomFighter, damageDone, true);
		
	}
	
//==========================================================================
//==PRINT AND DRAW FUNCTIONS================================================
//==========================================================================
	public void printLeftBoxText(Graphics g, int i){
		g.setColor(Color.white);
		g.drawString(""+fighters[i].getName(), 100, 370);
		g.setFont(font2);
		g.drawString("HP: "+fighters[i].currentHP +" / "+fighters[i].HP, 100, 390);
		g.drawString("AP: "+fighters[i].currentAP +" / "+fighters[i].AP, 100, 410);
		g.setFont(font);
		g.drawString("Attack", 250, 370);
		g.drawString("Abilities", 250, 400);
		g.drawString("Items", 250, 430);
	}
	
	public void printQueue(Graphics g){
		int j = 0;
		g.drawImage(frame, 0, 0, applet);
		while(j != 9){
			g.setColor(Color.cyan);
			g.drawString(""+attackQueue[j], 600+(j*50), 25);
			j++;
		}
	}
	

	public void printReadyToAttack(Graphics g){
		g.setColor(Color.black);
		g.fillRect(630, 65, 350, 40);
		for(int i = 0; i < 4; i++){
			g.setColor(Color.red);
			g.drawString("" +fighters[i].waitTime, 650+(i*75), 40);
			g.setColor(Color.red);
			g.drawString("" +monster.waitTime, 650+(i*75), 80);
			g.setColor(Color.red);
			g.drawString("" +monster.readyToAttack, 650+(i*75), 120);
		}
	}
	
	public void drawBlackBox(Graphics g, Graphics gfx, Image buffer){
		int displacement = 0;
		g.setColor(Color.black);
		//change textBoxLoop -= to a greater value to make the box draw faster,
		//change the displacement += in the same way
		for(textBoxLoop = 884; textBoxLoop > 0; textBoxLoop-=9){
			g.drawImage(background, 0, 0, applet);
			g.drawImage(frame, 0, 0, applet);
			
			g.fillRect(500-displacement, 329, 884-textBoxLoop, 158);
			
			if(textBoxLoop%2 == 0)
				displacement+=9;
			if(displacement == 455)
				displacement = 454;
			gfx.drawImage(buffer, 0, 0, applet);
		}
	}
	
	
	
	
	
	public void drawRightBlueBox(Graphics g, Graphics gfx, Image buffer){
		g.setColor(color);
		int displacement = 0;
		for(textBoxLoop = 400; textBoxLoop > 0; textBoxLoop-=7){
			
			//g.fillRect(290-displacement, 340, 400-textBoxLoop, 135);
			g.fillRect(725-displacement, 340, 400-textBoxLoop, 135);
			if(textBoxLoop%2 == 0)
				displacement+=7;
			if(displacement == 455)
				displacement = 454;
			gfx.drawImage(buffer, 0, 0, applet);
		}		
	}
	
	
	
	
	public void drawWaitBoxBorder(Graphics g){
		g.setColor(Color.black);
		for(int j = 0; j < leader.getNumberOfMembers(); j++)
			for(int i = 0; i < leader.getNumberOfMembers(); i++){
				g.drawRect(650, 352+i+(j*30), 250, 20);
		}
	}
	
	
	
	
	public void drawFillWaitBoxBorder(Graphics g){
		g.setColor(Color.darkGray);
		for(int j = 0; j < leader.getNumberOfMembers(); j++)
			for(int i = 0; i < leader.getNumberOfMembers(); i++){
				g.fillRect(651, 355+i+(j*30), 248, 16);
		}
	}
	
	
	
	
	public void drawWaitBoxNames(Graphics g){
		g.setColor(Color.white);
		for(int i = 0; i < leader.getNumberOfMembers(); i++){
			g.drawString(""+fighters[i].getName(), 550, 370+(i*30));
		}
	}
	
	
	public void drawWaitBoxProgress(Graphics g, int i, boolean displayOnly){
		boolean temp = false;
		for(int j = 0; j < leader.getNumberOfMembers(); j++){
			if(fighters[j].readyToAttack)
				temp = true;
		}
		
		if(activeTrueWaitFalse || (!activeTrueWaitFalse && !temp)){
			if(!displayOnly){
				fighters[i].decreaseWaitTime();
				monster.decreaseWaitTime();
			}
			g.setColor(Color.cyan);
			for(int j = 0; j < leader.getNumberOfMembers(); j++){
				if(leader.getParty()[i].waitTime > -40 && !fighters[i].readyToAttack)
					g.fillRect(651, 356+(i*30), 248-(fighters[i].getWaitTime()/2), 17);
				else
					g.fillRect(651, 356+(i*30), 248, 17);
			}		
		}
	}
	

}
