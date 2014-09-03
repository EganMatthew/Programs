

public class PlayingField {
	int sizeOfTiles = 5;
	Ball ball;
	Slider player1;
	Slider player2;
	
	public PlayingField(Pong pong){
		ball = new Ball(pong);
		player1 = new Slider(pong, true);
		player2 = new Slider(pong, false);
		buildDisplay(pong);
	}
	
	public void paint(Pong pong){
		
		for(int i = 0; i < 160; i++){
			for(int j = 0; j < 120; j++){
				pong.g.drawImage(pong.Layer1[i][j], (sizeOfTiles*i), (sizeOfTiles*j), pong);
			}
		}
		
		ball.paint(pong);
		player1.paint(pong);
		player2.paint(pong);
		
	}
	
	public void buildDisplay(Pong pong){
		drawField(pong);
		drawLine(pong);
	}
	
	public void drawField(Pong pong){
		for(int i = 0; i < 160; i++){
			for(int j = 0; j < 120; j++){
				pong.Layer1[i][j] = pong.tiles[0];
			}
		}
	}
	
	public void drawLine(Pong pong){
		for(int k = 0; k < 6; k++)
			for(int i = 79; i < 81; i++){
				for(int j = 0+k*20; j < 10+k*20; j++){
					pong.Layer1[i][j] = pong.tiles[1];
				}
			}
	}

}
