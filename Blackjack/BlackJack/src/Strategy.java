import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Strategy {
	
	private char strategy[][];
	
	private char strategy0[];
	private char strategies[][][];
	private int count[];
	private int numberOfStrategies;
	
	char hit = 'H';
	char split = 'X';
	char down = 'D';
	char stand = 'S';
	
	
	public Strategy(){
		strategy = new char[11][41];
		strategy0 = new char[100];
		count = new int[50];
		
		initialize();
		initialize0();
	}
	
	public void setStrategy(int count, Player player){
		
		//if(count < -19)
		//	player.setWager(50);
		//else
		//	player.setWager(5);
		
		//for(int i = numberOfStrategies-1; i > 0; i--){
			//if(count >= this.count[i]){
				
				//strategy = strategies[i];
				
				//break;
			//}
			//else
				strategy = strategies[0];
		//}
	}
	
	public void initialize(){
		
		BufferedReader inFile = null;
		
					
			try {
				inFile = new BufferedReader(new FileReader("strategy.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}

			
			try {
				
				String stringOfNumbers;
				String[] delimitedStringOfNumbers;
				stringOfNumbers = inFile.readLine();
				delimitedStringOfNumbers = stringOfNumbers.split(" ");
				numberOfStrategies = Integer.parseInt(delimitedStringOfNumbers[1]);
				strategies = new char[numberOfStrategies][11][41];
				
				for(int k = 0; k < numberOfStrategies; k++){
					inFile.readLine();
					inFile.readLine();
					stringOfNumbers = inFile.readLine();
					delimitedStringOfNumbers = stringOfNumbers.split(" ");
					count[k] = Integer.parseInt(delimitedStringOfNumbers[1]) * -1;
					inFile.readLine();
					inFile.readLine();
					
					for(int i = 0; i < 36; i++){
						stringOfNumbers = inFile.readLine();
						delimitedStringOfNumbers = stringOfNumbers.split(" ");
						for(int j = 0; j < 12; j++){
							if(j != 0 && j != 1){
								//System.out.print(delimitedStringOfNumbers[j].charAt(0));
								strategies[k][j-1][i+5] = delimitedStringOfNumbers[j].charAt(0);
							}
						}
					}
				
				}
				
				
	
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public char getStrategy(int mySum, int myCard, boolean soft, boolean pair, int pairCard, int dealerCard){
		
		if(pair){
			return strategy[dealerCard][30+pairCard];
		}
		if(!soft)
			return strategy[dealerCard][mySum];
		
		return strategy[dealerCard][20+myCard];
	}
	
	public char getStrategy(int dealerSum){
		
		//System.out.print(strategy0[dealerSum]);
		
		return strategy0[dealerSum];

	}
	
	public void initialize0(){
				//hard
				strategy0[2] = hit; strategy0[4] = hit; strategy0[3] = hit;
				strategy0[5] = hit; strategy0[6] = hit; strategy0[7] = hit; strategy0[8] = hit; strategy0[9] = hit;
				strategy0[10] = hit; strategy0[11] = hit; strategy0[12] = hit; strategy0[13] = hit; strategy0[14] = hit;
				strategy0[15] = hit; strategy0[16] = hit; strategy0[17] = stand; strategy0[18] = stand; strategy0[19] = stand;
				strategy0[20] = stand; strategy0[21] = stand;
	}
		
}
