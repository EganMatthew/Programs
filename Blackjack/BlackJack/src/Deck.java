import java.util.*;

public class Deck {
	
	private int[] decks;
	private int totalNumberOfCardsInDeck;
	private Random generator;
	private int randomDraw;
	private int numberOfCardsDealt;
	private int numberOfDecks;
	private int count;
	
	public Deck(int numberOfDecks){
		this.numberOfDecks = numberOfDecks;
		totalNumberOfCardsInDeck = 52*numberOfDecks;
		decks = new int[totalNumberOfCardsInDeck];
		initializeDecks();
	}
	
	public void shuffle(){
		initializeDecks();
	}
	
	public int getCount(){
		return count;
	}
	
	public int drawCard(){
		randomDraw = generator.nextInt(Integer.MAX_VALUE)%totalNumberOfCardsInDeck;
		
		while(numberOfCardsDealt < totalNumberOfCardsInDeck){
			if(decks[randomDraw] != 0){
				decks[randomDraw] = 0;
				numberOfCardsDealt++;
				
				if((randomDraw%13)+1 > 9)
					count++;
				if((randomDraw%13)+1 < 6 && (randomDraw%13)+1 != 1)
					count--;
				
				return (randomDraw%13)+1;
			}
			else
				randomDraw = generator.nextInt(Integer.MAX_VALUE)%totalNumberOfCardsInDeck;
			
		}
		return -1;
	}
	
	public int getNumberOfCardsDealt(){
		return numberOfCardsDealt;
	}
	
	public boolean cardsLeft(){
		if(numberOfCardsDealt < totalNumberOfCardsInDeck)
			return true;
		
		return false;
	}
	
	private void initializeDecks(){
		generator = new Random(System.currentTimeMillis());
		for (int i = 0; i < totalNumberOfCardsInDeck; i++)
			decks[i] = 1;
		numberOfCardsDealt = 0;
		count = 0;
	}
	
	public int getNumberOfDecks(){
		return numberOfDecks;
	}
	
}
