import java.awt.*;

public class MainMenu extends Font{
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
		
		printLetterP(pong, pong.tiles[1], x, y, width, thickness, pong.Layer1);
		printLetterO(pong, pong.tiles[1], x+spaceBetweenLetters, y, width, thickness, pong.Layer1);
		printLetterN(pong, pong.tiles[1], x+spaceBetweenLetters+spaceBetweenLetters, y, width, thickness, pong.Layer1);
		printLetterG(pong, pong.tiles[1], x+spaceBetweenLetters+spaceBetweenLetters+spaceBetweenLetters, y, width, thickness, pong.Layer1);
	}
	
	public void spellPlay(Pong pong, int x, int y, int width, int thickness, int spaceBetweenLetters, Image tiles){
		spaceBetweenLetters = width+spaceBetweenLetters;
		
		printLetterP(pong, tiles, x, y, width, thickness, pong.Layer1);
		printLetterL(pong, tiles, x+spaceBetweenLetters, y, width, thickness, pong.Layer1);
		printLetterA(pong, tiles, x+spaceBetweenLetters+spaceBetweenLetters-thickness, y, width, thickness, pong.Layer1);
		printLetterY(pong, tiles, x+spaceBetweenLetters+spaceBetweenLetters+spaceBetweenLetters-thickness, y, width, thickness, pong.Layer1);
	}
}






