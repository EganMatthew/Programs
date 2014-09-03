

public class Ball {
	
	int radius;
	//vectors
	double[] velocity;
	double[] acceleration;
	int[] location;
	
	public Ball(Pong pong){
		radius = 2;
		location = new int[2];
		location[0] = 80;
		location[1] = 10;
		velocity = new double[2];
		velocity[0] = 1;
		velocity[1] = 1;
	}
	
	public void paint(Pong pong){
		
		for(int i = 0; i < 160; i++){
			for(int j = 0; j < 120; j++){
				pong.Layer2[i][j] = pong.tiles[3];
			}
		}
		
		// (x - 5)^2 + (y - 5)^2 = 3^2
		
		//circle w/ radius
		for(int k = 0; k < radius; k++){
			for(int i = 0; i < 160; i++){
				for(int j = 0; j < 120; j++){
					if(Math.pow(i - location[0], 2) + Math.pow(j - location[1], 2) == Math.pow(radius-k, 2))
						pong.Layer2[i][j] = pong.tiles[2];
				}
			}
		}
		
		//3x3box
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				pong.Layer2[i+location[0]-1][j+location[1]-1] = pong.tiles[2];
			}
		}
		
		moveBall(pong);
	}
	
	public void moveBall(Pong pong){
		
		location[0]+=velocity[0];
		location[1]+=velocity[1];
		
		detectCollisions(pong);
	}
	
	public void detectCollisions(Pong pong){
		
		//ball is traveling down & right
		if(velocity[0] > 0 && velocity[1] > 0){
			for(int i = 0; i < 20; i++)
				if(Math.pow(pong.playingField.player1.sliderCoordinates[0][0] - location[0], 2) + Math.pow(pong.playingField.player1.sliderCoordinates[0][1]+i - location[1], 2) == Math.pow(radius, 2)){
					velocity[0] = -1;
					velocity[1] = 1;
				}
			if(location[1] < 120 && location[1] > 113){
				velocity[0] = 1;
				velocity[1] = -1;
			}
		}
		
		//ball is traveling up & right
		else if(velocity[0] > 0 && velocity[1] < 0){
			if(location[1] > 0 && location[1] < 2){
				velocity[0] = 1;
				velocity[1] = 1;
			}
			for(int i = 0; i < 20; i++)
				if(Math.pow(pong.playingField.player1.sliderCoordinates[0][0] - location[0], 2) + Math.pow(pong.playingField.player1.sliderCoordinates[0][1]+i - location[1], 2) == Math.pow(radius, 2)){
					velocity[0] = -1;
					velocity[1] = -1;
				}
		}
		
		//ball is traveling down & left
		else if(velocity[0] < 0 && velocity[1] > 0){
			for(int i = 0; i < 20; i++)
				if(Math.pow(pong.playingField.player2.sliderCoordinates[1][0] - location[0], 2) + Math.pow(pong.playingField.player2.sliderCoordinates[0][1]+i - location[1], 2) == Math.pow(radius, 2)){
					velocity[0] = 1;
					velocity[1] = 1;
				}
			if(location[1] < 120 && location[1] > 113){
				velocity[0] = -1;
				velocity[1] = -1;
			}
			//for(int i = 0; i < 20; i++)
			//	System.out.println("Num: " +(int)Math.pow(pong.playingField.player2.sliderCoordinates[1][0] - location[0], 2) + Math.pow(pong.playingField.player2.sliderCoordinates[0][1]+i - location[1], 2));
				
		}
		
		//ball is traveling up & left
		else if(velocity[0] < 0 && velocity[1] < 0){
			for(int i = 0; i < 20; i++)
				if(Math.pow(pong.playingField.player2.sliderCoordinates[1][0] - location[0], 2) + Math.pow(pong.playingField.player2.sliderCoordinates[0][1]+i - location[1], 2) == Math.pow(radius, 2)){
					velocity[0] = 1;
					velocity[1] = -1;
				}
			if(location[1] > 0 && location[1] < 2){
				velocity[0] = -1;
				velocity[1] = 1;
			}
			//for(int i = 0; i < 20; i++)
			//	System.out.println("Num: " +Math.pow(pong.playingField.player2.sliderCoordinates[1][0] - location[0], 2) + Math.pow(pong.playingField.player2.sliderCoordinates[0][1]+i - location[1], 2));
				
		}
		
		if(location[0] < 3 || location[0] > 157){
			velocity[0] = 1;
			velocity[1] = 1;
			location[0] = 80;
			location[1] = 10;
		}
		
	}
	
	


}
