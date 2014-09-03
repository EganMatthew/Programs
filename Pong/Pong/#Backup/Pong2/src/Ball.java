

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
		
		// (x - 5)^2 + (y - 5)^2 = 3^2
		
		//circle w/ radius
		for(int k = 0; k < radius; k++){
			for(int i = 0; i < 160; i++){
				for(int j = 0; j < 120; j++){
					if(Math.pow(i - location[0], 2) + Math.pow(j - location[1], 2) == Math.pow(radius-k, 2))
						pong.Layer1[i][j] = pong.tiles[2];
				}
			}
		}
		
		//3x3box
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				pong.Layer1[i+location[0]-1][j+location[1]-1] = pong.tiles[2];
			}
		}
		
		moveBall(pong);
	}
	
	public void moveBall(Pong pong){
		if(location[0] < 155)
			location[0]+=velocity[0];
		if(location[1] < 115)
			location[1]+=velocity[1];
		
		updateBall(pong);
	}
	
	public void updateBall(Pong pong){
		
	}
	
	


}
