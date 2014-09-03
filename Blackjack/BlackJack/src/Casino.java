import java.util.Scanner;


public class Casino {
	
	static int numberOfGames = 1000000;
	
	Player players[];
	Table tables[];
	
	public Casino(int maxPopulation, int numberOfTables){
		players = new Player[maxPopulation];
		tables = new Table[numberOfTables];
	}
	
	public static void main(String Args[]){
		
		Casino casino = new Casino(1000, 20);
		
		casino.createTable(0, 7, new Deck(8), new BlackJack());
		casino.tables[0].setDealer(new Dealer(0, casino.tables[0]));
		
		casino.createPlayer(0);
		casino.createPlayer(1);
		casino.createPlayer(2);
		casino.createPlayer(3);
		casino.createPlayer(4);
		casino.createPlayer(5);
		casino.createPlayer(6);
		
		casino.players[0].sitDown(casino.tables[0], 0);
		casino.players[1].sitDown(casino.tables[0], 1);
		casino.players[2].sitDown(casino.tables[0], 2);
		casino.players[3].sitDown(casino.tables[0], 3);
		casino.players[4].sitDown(casino.tables[0], 4);
		casino.players[5].sitDown(casino.tables[0], 5);
		casino.players[6].sitDown(casino.tables[0], 6);
		
		casino.tables[0].getGameType().dealGame(casino.tables[0]);
		int counter = 0;
		for(int loop = 0; loop < numberOfGames; loop++){
			//System.out.println(loop);
			//if(casino.tables[0].getGameType().checkForBlackJack(casino.tables[0])){
			//	casino.tables[0].reDeal();
			//	continue;
			//}
			
			//handle players
			for(int i = 0; i < casino.tables[0].getNumberOfSeats(); i++){
				if(casino.tables[0].isSitting(i)){
					
					while(casino.tables[0].getHands(i).handsExist()){
												
						casino.getPlayer(i).setStrategy(casino.tables[0].getDeck().getCount());
						casino.tables[0].getPlayer(i).doStrategy();
						
					}
				}
			}
			
			//handle dealer
			while(casino.tables[0].getDealerHand().handsExist()){

				casino.tables[0].getDealer().doStrategy();
				//System.out.print("test");
			}
			
			//System.out.print("test");
			casino.tables[0].getGameType().checkForWinners(casino.tables[0]);
			casino.tables[0].reDeal();

		}	
		int temp = 0;
		int min = casino.tables[0].getPlayer(0).getMoney();
		int max = casino.tables[0].getPlayer(0).getMoney();
		for(int i = 0; i < casino.tables[0].getNumberOfSeats(); i++){
			System.out.println("Player in seat " + i + ":      " + casino.tables[0].getPlayer(i).getMoney());
			temp += casino.tables[0].getPlayer(i).getMoney();
			if(casino.tables[0].getPlayer(i).getMoney() < min)
				min = casino.tables[0].getPlayer(i).getMoney();
			if(casino.tables[0].getPlayer(i).getMoney() > max)
				max = casino.tables[0].getPlayer(i).getMoney();
		}
		System.out.println("Average:   " + temp/casino.tables[0].getNumberOfSeats());
		System.out.println("Min:       " + min);
		System.out.println("Max:       " + max);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void createPlayer(int i){
		players[i] = new Player();
	}
	
	public void createTable(int tableNumber, int numberOfSeats, Deck deck, BlackJack gameType){
		 tables[tableNumber] = new Table(tableNumber, numberOfSeats, deck, gameType);
	}
	
	public Player getPlayer(int i){
		return players[i];
	}
	
	

}
