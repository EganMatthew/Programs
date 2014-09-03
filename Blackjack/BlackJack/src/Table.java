import java.util.Scanner;


public class Table {
	
	private BlackJack gameType;
	private int numberOfSeats;
	private int tableNumber;
	private int seats[];
	private Hand hands[];
	private Hand dealerHand;
	private Deck deck;
	
	private Player players[];
	private Dealer dealer;
	
	private boolean insuranceBaught[];
	
	
	public Table(int tableNumber, int numberOfSeats, Deck deck, BlackJack gameType){
		this.numberOfSeats = numberOfSeats;
		this.tableNumber = tableNumber;
		this.deck = deck;
		this.gameType = gameType;
		seats = new int[numberOfSeats];
		hands = new Hand[numberOfSeats];	
		insuranceBaught = new boolean[numberOfSeats];
		
		
		players = new Player[numberOfSeats];
		for(int i = 0; i < numberOfSeats; i++)
			players[i] = new Player();
		
		for(int i = 0; i <numberOfSeats; i++)
			hands[i] = new Hand(0, 0);
		dealerHand = new Hand(0, 0);
		
	}
	
	public void reDeal(){
		
		//System.out.println(deck.getNumberOfCardsDealt());
		
		//Scanner scan = new Scanner(System.in);			
		//scan.nextInt();
		
		if(gameType.checkBreakPoint(this, deck.getNumberOfCardsDealt())){
			
			
			deck = null;
			deck = new Deck(8);
		}
		
		hands = null;
		dealerHand = null;
		insuranceBaught = null;
		
		hands = new Hand[numberOfSeats];	
		
		for(int i = 0; i <numberOfSeats; i++)
			hands[i] = new Hand(0, 0);
		dealerHand = new Hand(0, 0);
		insuranceBaught = new boolean[numberOfSeats];
		
		gameType.dealGame(this);
	}
	
	public void setInsurance(int seat, boolean value){
		insuranceBaught[seat] = value;
	}
	
	public boolean getInsurance(int seat){
		return insuranceBaught[seat];
	}
	
	public Hand getHands(int seat){
		if(seat > -1)
			return hands[seat];
		
		return dealerHand;
	}	
	
	public Hand getDealerHand(){
		return dealerHand;
	}
	public void sitDown(int seat, Player player){
		
		if(seat > numberOfSeats)
			return;
		if(seats[seat] != 0)
			return;
		
		players[seat] = player;
		seats[seat] = 1;
	}
	
	public void standUp(int seat){
		
		if(seat > numberOfSeats)
			return;
		
		if(seats[seat] == 1)
			seats[seat] = 0;
	}
	
	public boolean isSitting(int seat){
		if(seats[seat] == 1)
			return true;
		
		return false;
	}
	
	public int getTable(){
		return tableNumber;
	}
	
	public Deck getDeck(){
		return deck;
	}

/*
	public void print(int seat){
		System.out.print("\nSeat " + seat + ":   ");
		System.out.print("Sum:  " + cards[seat].getSum());
		for(int j = 0; j < cards[seat].getNumberOfDecks()*52; j++){
			if(cards[seat].getValue(j) > 0)
				System.out.print("  Card: " + cards[seat].getValue(j));
		}
	}
	
	public void print(){
		System.out.println("\n\nDealer: " + dealerCards.getValue(0));
		System.out.print("Dealer Sum:  " + dealerCards.getSum());
		for(int j = 0; j < dealerCards.getNumberOfDecks()*52; j++){
			if(dealerCards.getValue(j) > 0)
				System.out.print("  Card: " + dealerCards.getValue(j));
		}
	}
*/
	public int getNumberOfSeats(){
		return numberOfSeats;
	}
	
	public Player getPlayer(int seat){
		return players[seat];
	}
	
	public void setDealer(Dealer dealer){
		this.dealer = dealer;
	}
	
	public Dealer getDealer(){
		return dealer;
	}
	
	public BlackJack getGameType(){
		return gameType;
	}

}
