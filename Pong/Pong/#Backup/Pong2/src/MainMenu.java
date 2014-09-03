import java.awt.*;

public class MainMenu{
	int sizeOfTiles = 5;
	
	public MainMenu(Pong pong){
		buildDisplay(pong);
	}
	
	public void paint(Pong pong){
		
		for(int i = 0; i < 160; i++){
			for(int j = 0; j < 120; j++){
				pong.g.drawImage(pong.Layer1[i][j], (sizeOfTiles*i), (sizeOfTiles*j), pong);
			}
		}
		
	}
	
	public void buildDisplay(Pong pong){
		
		for(int i = 0; i < 160; i++){
			for(int j = 0; j < 120; j++){
				pong.Layer1[i][j] = pong.tiles[0];
			}
		}
		
		spellPong(pong, 32, 25, 20, 5, 4);
		spellPlay(pong, 64, 70, 5, 1, 3, pong.tiles[1]);
		createBox(pong, 60, 66, 35, 12, pong.tiles[2]);		
	}
	
	public void createBox(Pong pong, int x, int y, int length, int width, Image tiles){
		for(int i = 0; i < length; i++)
			pong.Layer1[x+i][y] = tiles;
		for(int i = 0; i < width; i++)
			pong.Layer1[x][y+i] = tiles;
		for(int i = 0; i < length; i++)
			pong.Layer1[x+i][y+width] = tiles;
		for(int i = 0; i < width+1; i++)
			pong.Layer1[x+length][y+i] = tiles;
	}
	
	public void spellPong(Pong pong, int x, int y, int width, int thickness, int spaceBetweenLetters){
		spaceBetweenLetters = width+spaceBetweenLetters;
		
		printLetterP(pong, pong.tiles[1], x, y, width, thickness);
		printLetterO(pong, x+spaceBetweenLetters, y, width, thickness);
		printLetterN(pong, x+spaceBetweenLetters+spaceBetweenLetters, y, width, thickness);
		printLetterG(pong, x+spaceBetweenLetters+spaceBetweenLetters+spaceBetweenLetters, y, width, thickness);
	}
	
	public void spellPlay(Pong pong, int x, int y, int width, int thickness, int spaceBetweenLetters, Image tiles){
		spaceBetweenLetters = width+spaceBetweenLetters;
		
		printLetterP(pong, tiles, x, y, width, thickness);
		printLetterL(pong, tiles, x+spaceBetweenLetters, y, width, thickness);
		printLetterA(pong, tiles, x+spaceBetweenLetters+spaceBetweenLetters-thickness, y, width, thickness);
		printLetterY(pong, tiles, x+spaceBetweenLetters+spaceBetweenLetters+spaceBetweenLetters-thickness, y, width, thickness);
	}
	
	public void printLetterP(Pong pong, Image tiles, int x, int y, int width, int thickness){
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i][y+j] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width; j++)
				pong.Layer1[x+i][y+j] = tiles;
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i][y+j+thickness*2] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i+width-thickness][y+j+thickness] = tiles;
	}
	
	public void printLetterL(Pong pong, Image tiles, int x, int y, int width, int thickness){
		for(int i = 0; i < width - thickness; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i][y+j+thickness*2+2] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness; j++)
				pong.Layer1[x+i][y+j] = tiles;
	}
	
	public void printLetterA(Pong pong, Image tiles, int x, int y, int width, int thickness){
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness; j++)
				pong.Layer1[x+i][y+j+1] = tiles;
		for(int i = 0; i < width - thickness; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i][y+j] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness+1; j++)
				pong.Layer1[x+i+width-thickness][y+j] = tiles;
		for(int i = 0; i < width - thickness; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i][y+j+2] = tiles;
	}
	
	public void printLetterY(Pong pong, Image tiles, int x, int y, int width, int thickness){
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness-1; j++)
				pong.Layer1[x+i+(width-thickness)/2][y+j+2] = tiles;
		pong.Layer1[x+thickness][y+1] = tiles;
		pong.Layer1[x+thickness+2][y+1] = tiles;
		pong.Layer1[x+thickness-1][y] = tiles;
		pong.Layer1[x+thickness+3][y] = tiles;
	}
	
	public void printLetterO(Pong pong, int x, int y, int width, int thickness){
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i][y+j] = pong.tiles[1];
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i][y+j+thickness*2] = pong.tiles[1];
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i][y+j+thickness] = pong.tiles[1];
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i+width-thickness][y+j+thickness] = pong.tiles[1];
	}
	
	public void printLetterN(Pong pong, int x, int y, int width, int thickness){
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness; j++)
				pong.Layer1[x+i][y+j] = pong.tiles[1];
		
		for(int k = 0; k < width - thickness - 1; k++)
			for(float i = -3; i < 2; i += .5)
				for(float j = (float) .5; j < 2; j += .5)
					pong.Layer1[(int) (x+thickness+i+k)][(int) (y+j+k)] = pong.tiles[1];
		
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness; j++)
				pong.Layer1[x+i+width-thickness][y+j] = pong.tiles[1];
	}
	
	public void printLetterG(Pong pong, int x, int y, int width, int thickness){
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i][y+j] = pong.tiles[1];
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness; j++)
				pong.Layer1[x+i][y+j] = pong.tiles[1];
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				pong.Layer1[x+i][y+j+thickness+thickness] = pong.tiles[1];
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < (width - thickness)/2; j++)
				pong.Layer1[x+i+width-thickness][y+j+thickness+thickness/2] = pong.tiles[1];
	}
}






