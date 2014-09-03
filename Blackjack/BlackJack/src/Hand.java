
import java.util.Vector;




public class Hand {
	

	private Vector<Hand> splits = new Vector<Hand>();
	private Vector<Integer> cards = new Vector<Integer>();
	private Vector<Integer> sums = new Vector<Integer>();
	private Vector<Boolean> doubleDowns = new Vector<Boolean>();
	private Hand parent = null;
	private int currentHandIndex = 0;
	private boolean soft = false;
	private boolean busted = false;
	private boolean hasNotHit = true;
	


	
	
	Hand(int Card1, int Card2) {
	
		splits.add(new Hand(Card1, Card2, this));

		
	}
	
	private Hand(int Card1, int Card2, Hand parent) {
		if((Card1 == 1) || (Card2 == 1)) 
			soft = true;
		if((Card1 == 1) && (Card2 == 1))
			soft = false;
		
		cards.add(new Integer(Card1));
		cards.add(new Integer(Card2));
		this.parent = parent;
		parent.doubleDowns.add(false);
	}
	
	public void newHand(int Card1, int Card2) {
		splits = new Vector<Hand>();
		cards = new Vector<Integer>();
		sums = new Vector<Integer>();
		doubleDowns = new Vector<Boolean>();
		soft = false;
		busted = false;
		hasNotHit = true;
		
		splits.add(new Hand(Card1, Card2, this));
	}
	
	public void split(int newCard1, int newCard2) {
		splits.elementAt(currentHandIndex).SplitHand(newCard1, newCard2);
	}
	
	private void SplitHand(int newCard1, int newCard2) {
		int origionalCard2 = cards.remove(1);
		cards.add(new Integer(newCard1));
		parent.splits.add(parent.splits.indexOf(this)+1, new Hand(origionalCard2, newCard2, parent));
	}
	/*
	public int getDealerCard() {
		int card = splits.elementAt(currentHandIndex).cards.elementAt(0);
		if (card >= 10)
			card = 10;
		return card;
	}
	*/
	public int getNoneAceCard() {
		int card = 0;
		
		if(splits.elementAt(currentHandIndex).cards.elementAt(0).intValue() == 1) {
			card = splits.elementAt(currentHandIndex).cards.elementAt(1);
		} else if (splits.elementAt(currentHandIndex).cards.elementAt(1).intValue() == 1) {
			card = splits.elementAt(currentHandIndex).cards.elementAt(0);
		}
		if(card >= 10) {
			card = 10;
		}
		
		return card;
	}
	
	public boolean isPair() {
		if(splits.elementAt(currentHandIndex).cards.elementAt(0).intValue() == splits.elementAt(currentHandIndex).cards.elementAt(1).intValue())
			return true;
		else return false;
	}
	
	public int getFirstCard() {
		int card = splits.elementAt(currentHandIndex).cards.elementAt(0);
		if (card >= 10)
			card = 10;
		return card;
	}
	
	public int getSecondCard() {
		int card = splits.elementAt(currentHandIndex).cards.elementAt(1);
		if (card >= 10)
			card = 10;
		return card;
	}
	
	public boolean handsExist() {
		if(currentHandIndex >= splits.size())
			return false;
		else return true;
	}
	
	public int[] getSums() {
		int retsums[] = new int[sums.size()];
		
		for(int i = 0; i < sums.size(); i++) {
			retsums[i] = sums.elementAt(i).intValue();
		}
		return retsums;
	}
	
	public int getNumHands() {
		return splits.size();
	}
	
	public boolean isBusted() {
		return splits.elementAt(currentHandIndex).busted;
	}
	
	public boolean hasNotHit() {
		return splits.elementAt(currentHandIndex).hasNotHit;
	}
	
	void printHand() {
	System.out.println("Hands:");
	
		for(Hand h : splits) {
			//System.out.println("N");
			for(Integer i : h.cards) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}
	
	void stand() {

		sums.add(new Integer(getCurrentSum()));
	
		currentHandIndex++;
	}
	
	int hit(int card) {
		splits.elementAt(currentHandIndex).hasNotHit = false;
		splits.elementAt(currentHandIndex).cards.add(new Integer(card));
		
		if(getCurrentSum() > 21) {
			if(splits.elementAt(currentHandIndex).soft) {
			   splits.elementAt(currentHandIndex).soft = false;
			   return 1;
			} else {
				splits.elementAt(currentHandIndex).busted = true;
				return 0;
			}
		} 
		return 1;
	}
	
	void doubleDown(int card) {
		splits.elementAt(currentHandIndex).hasNotHit = false;
		splits.elementAt(currentHandIndex).cards.add(new Integer(card));
		
		if(getCurrentSum() > 21) {
			if(splits.elementAt(currentHandIndex).soft) {
				splits.elementAt(currentHandIndex).soft = false;
			   
			} else {
				splits.elementAt(currentHandIndex).busted = true;
				
			}
		} 
		
		
		doubleDowns.remove(currentHandIndex);
		doubleDowns.add(currentHandIndex, new Boolean(true));
	}
	
	boolean[] getDoubleDowns() {
		boolean b[] = new boolean[doubleDowns.size()];
		for(int i = 0; i<doubleDowns.size(); i++) {
			b[i] = doubleDowns.elementAt(i);
		}
		
		return b;
		
	}
	
	int getCurrentSum() {
		if(currentHandIndex >= splits.size()) {
			return 0;
		}
		
		int sum = 0;
		boolean verifySum = false;
		
		for(Integer i : splits.elementAt(currentHandIndex).cards) {
			if(i == 1) {
				if(splits.elementAt(currentHandIndex).soft)  {
				   sum += 11;
				}
				else {
					sum += 1;
					verifySum = true;
				}
			} 
			
			if(i >= 10) {
				sum += 10;
			} 
			
			if(i>1 && i<10) {
				sum += i;
			}
			
		}
		
		if(verifySum) {
			if(sum<=11) {
				sum+=10;
			}
		}
		
		return sum;
	}
	
	boolean isSoft() {
		return splits.elementAt(currentHandIndex).soft;
	}
}


