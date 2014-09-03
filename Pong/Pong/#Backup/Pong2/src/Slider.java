
public class Slider {
	
	//[0][0] = [top left corner] [coordinate x]
	//[1][1] = bottom right corner
	int[][] sliderCoordinates;
	
	
	public Slider(Pong pong, boolean player1) {
		sliderCoordinates = new int[2][2];
		if(player1){
			sliderCoordinates[0][0] = 145;
			sliderCoordinates[0][1] = 50;
			
			sliderCoordinates[1][0] = 150;
			sliderCoordinates[1][1] = 70;
		}
		else{
			sliderCoordinates[0][0] = 8;
			sliderCoordinates[0][1] = 50;
			
			sliderCoordinates[1][0] = 13;
			sliderCoordinates[1][1] = 70;
		}
	}

	public void paint(Pong pong){
		for(int i = sliderCoordinates[0][0]; i < sliderCoordinates[1][0]; i++){
			for(int j = sliderCoordinates[0][1]; j < sliderCoordinates[1][1]; j++){
				pong.Layer1[i][j] = pong.tiles[1];
			}
		}
	}
	
	public void moveUp(Pong pong){
		if(sliderCoordinates[0][1] > 0){
			sliderCoordinates[0][1]-=1;
			sliderCoordinates[1][1]-=1;
			updateSlider(pong, true);
		}
	}
	
	public void moveDown(Pong pong){
		if(sliderCoordinates[1][1] < 120){
			sliderCoordinates[0][1]+=1;
			sliderCoordinates[1][1]+=1;
			updateSlider(pong, false);
		}
	}
	
	public void updateSlider(Pong pong, boolean up){
		if(up){
			for(int i = sliderCoordinates[0][0]; i < sliderCoordinates[1][0]; i++){
				for(int j = sliderCoordinates[0][1]; j < sliderCoordinates[0][1]+1; j++){
					pong.Layer1[i][j] = pong.tiles[1];
				}
			}
			for(int i = sliderCoordinates[0][0]; i < sliderCoordinates[1][0]; i++){
				for(int j = sliderCoordinates[1][1]; j < sliderCoordinates[1][1]+1; j++){
					pong.Layer1[i][j] = pong.tiles[0];
				}
			}
		}
		else{
			for(int i = sliderCoordinates[0][0]; i < sliderCoordinates[1][0]; i++){
				for(int j = sliderCoordinates[0][1]-1; j < sliderCoordinates[0][1]; j++){
					pong.Layer1[i][j] = pong.tiles[0];
				}
			}
			for(int i = sliderCoordinates[0][0]; i < sliderCoordinates[1][0]; i++){
				for(int j = sliderCoordinates[1][1]-1; j < sliderCoordinates[1][1]; j++){
					pong.Layer1[i][j] = pong.tiles[1];
				}
			}
		}
	}

}
