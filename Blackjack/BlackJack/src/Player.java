
public class Player {
	
	private int seat;
	private int money;
	private Table table;
	private boolean standing;
	private Strategy strategy;
	private int wager;
	
	public Player(){
		seat = -1;
		money = 100;
		wager = 5;
		standing = false;
		strategy = new Strategy();
		setStrategy(0);
	}
	
	public int getMoney(){
		return money;
	}
	
	public void addMoney(){
		money += wager;
	}
	
	public void subMoney(){
		money -= wager;
	}
	
	public void setWager(int wager){
		this.wager = wager;
	}
	
	public void sitDown(Table table, int seat){
		this.table = table;
		this.seat = seat;
		table.sitDown(seat, this);
	}
	
	public Table getTable(){
		return table;
	}
	
	public int getSeat(){
		return seat;
	}
	
	public void setStrategy(int count){
		strategy.setStrategy(count, this);
	}

	
	public char doStrategy(){
		
			char temp = strategy.getStrategy(table.getHands(seat).getCurrentSum(), table.getHands(seat).getNoneAceCard(), table.getHands(seat).isSoft(), table.getHands(seat).isPair(), table.getHands(seat).getFirstCard(), table.getDealerHand().getFirstCard());
			//System.out.print(temp);
			if(temp == 'H')
				table.getGameType().hit(table, seat);
			if(temp == 'S')
				table.getGameType().stand(table, seat);
			if(temp == 'D')
				table.getGameType().doubleDown(table, seat);
			if(temp == 'X')
				table.getGameType().split(table, seat);
		
		return temp;
	}

}
