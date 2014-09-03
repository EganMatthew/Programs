
public class Dealer {
	
	private int ID;
	private Table table;
	private Strategy strategy;
	
	public Dealer(int ID, Table table){
		this.ID = ID;
		this.table = table;
		strategy = new Strategy();
	}
	
	public int getID(){
		return ID;
	}
	
	public Table getTable(){
		return table;
	}
	
	public char doStrategy(){
		
		//strategy.getStrategy(mySum, myCard, soft, pair, pairCard, dealerCard);
		char temp = strategy.getStrategy(table.getDealerHand().getCurrentSum());
		
		//System.out.print(temp);
		
		if(temp == 'H')
			table.getGameType().hit(table);
		if(temp == 'S')
			table.getGameType().stand(table);
		
		return temp;
	}

}
