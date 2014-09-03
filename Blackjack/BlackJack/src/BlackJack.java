import java.util.Scanner;


public class BlackJack {
	
	//rules
	public BlackJack(){

	}
	
	public boolean checkBreakPoint(Table ID, int numberOfCards){
		if(numberOfCards > ID.getDeck().getNumberOfDecks()*52/2)
			return true;
		
		return false;
	}
	
	public boolean checkForBlackJack(Table ID){
		
		if(ID.getDealerHand().getFirstCard() == 1){
			offerInsurance(ID);
			
			if(ID.getDealerHand().getSecondCard() > 9){
				
				for(int i = 0; i < ID.getNumberOfSeats(); i++){
					if(ID.isSitting(i)){
						if(!ID.getInsurance(i)){
							ID.getPlayer(i).subMoney();
						}
					}
				}
				return true;
				
			}
			return false;
		}
		if(ID.getDealerHand().getFirstCard() > 9 && ID.getDealerHand().getSecondCard() == 1){
			
			for(int i = 0; i < ID.getNumberOfSeats(); i++)
				if(ID.isSitting(i))
					ID.getPlayer(i).subMoney();
			return true;
		}
		
		return false;
		
	}
	
	public void offerInsurance(Table ID){
		for(int i = 0; i < ID.getNumberOfSeats(); i++){
			if(ID.isSitting(i)){
				if(ID.getPlayer(i).doStrategy() == 'Y'){
					
					//SUB PROPER INSURANCE AMMOUNT
					ID.setInsurance(i, true);
				}
			}
		}
		
	}
	
	public void checkForWinners(Table ID){
		
		for(int seat = 0; seat < ID.getNumberOfSeats(); seat++){
			if(ID.isSitting(seat)){
				for(int hand = 0; hand < ID.getHands(seat).getNumHands(); hand++){
					if(ID.getHands(seat).getSums()[hand] > 21){
						ID.getPlayer(seat).subMoney();
						continue;
					}
					
					if(ID.getDealerHand().getSums()[0] > 21){
						ID.getPlayer(seat).addMoney();
						continue;
					}
					
					if(ID.getDealerHand().getSums()[0] > ID.getHands(seat).getSums()[hand]){
						ID.getPlayer(seat).subMoney();
						continue;
					}
					
					if(ID.getDealerHand().getSums()[0] < ID.getHands(seat).getSums()[hand]){
						ID.getPlayer(seat).addMoney();
						continue;
					}
				}
			}
		}
		
	}
	
	public void hit(Table ID, int seat){
		//System.out.println("HIT: ");
		ID.getHands(seat).hit(ID.getDeck().drawCard());
		if(ID.getHands(seat).isBusted())
			stand(ID, seat);
	}
	
	public void hit(Table ID){
		//System.out.println("DEALER HIT: ");
		ID.getDealerHand().hit(ID.getDeck().drawCard());
		if(ID.getDealerHand().isBusted())
			stand(ID);
	}
	
	public void stand(Table ID, int seat){
		//System.out.println("STAND: ");
		ID.getHands(seat).stand();
	}
	
	public void stand(Table ID){
		//System.out.println("DEALER STAND: ");
		ID.getDealerHand().stand();
	}
	
	public void split(Table ID, int seat){
		//temp
		//System.out.println("SPLIT: ");
		ID.getHands(seat).split(ID.getDeck().drawCard(), ID.getDeck().drawCard());
	}
	
	public void split(Table ID){
		hit(ID);
	}
	
	public void doubleDown(Table ID, int seat){
		if(!ID.getHands(seat).hasNotHit()){
			//System.out.println("OVERRIDE: ");
			hit(ID, seat);
			return;
		}
		//System.out.println("DOUBLEDOWN: ");
		hit(ID, seat);
		stand(ID, seat);
	}
	
	public void doubleDown(Table ID){
		hit(ID);
	}
	
	public void dealGame(Table ID){
		int temp = ID.getNumberOfSeats();
		
		for(int seat = 0; seat < temp; seat++)
			if(ID.getDeck().cardsLeft())
				if(ID.isSitting(seat))
						ID.getHands(seat).newHand(ID.getDeck().drawCard(), ID.getDeck().drawCard());
		
		ID.getDealerHand().newHand(ID.getDeck().drawCard(), ID.getDeck().drawCard());
	}

}
