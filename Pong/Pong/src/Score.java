
public class Score extends MainMenu{
	
	public Score(Pong pong) {
		super(pong);
		buildDisplay(pong);
	}

	public void paint(Pong pong){
		for(int i = 0; i < 160; i++){
			for(int j = 0; j < 120; j++){
				pong.g.drawImage(pong.Layer3[i][j], (sizeOfTiles*i), (sizeOfTiles*j), pong);
			}
		}
	}
	
	public void buildDisplay(Pong pong){
		printLetterO(pong, pong.tiles[1], 50, 10, 20, 5, pong.Layer3);
	}

}
