import java.awt.Image;


public class Font {
	
	public void printLetterP(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i][y+j] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width; j++)
				layer[x+i][y+j] = tiles;
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i][y+j+thickness*2] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i+width-thickness][y+j+thickness] = tiles;
	}
	
	public void printLetterL(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
		for(int i = 0; i < width - thickness; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i][y+j+thickness*2+2] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness; j++)
				layer[x+i][y+j] = tiles;
	}
	
	public void printLetterA(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness; j++)
				layer[x+i][y+j+1] = tiles;
		for(int i = 0; i < width - thickness; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i][y+j] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness+1; j++)
				layer[x+i+width-thickness][y+j] = tiles;
		for(int i = 0; i < width - thickness; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i][y+j+2] = tiles;
	}
	
	public void printLetterY(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness-1; j++)
				layer[x+i+(width-thickness)/2][y+j+2] = tiles;
		layer[x+thickness][y+1] = tiles;
		layer[x+thickness+2][y+1] = tiles;
		layer[x+thickness-1][y] = tiles;
		layer[x+thickness+3][y] = tiles;
	}
	
	public void printLetterO(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i][y+j] = tiles;
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i][y+j+thickness*2] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i][y+j+thickness] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i+width-thickness][y+j+thickness] = tiles;
	}
	
	public void printLetterN(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness; j++)
				layer[x+i][y+j] = tiles;
		
		for(int k = 0; k < width - thickness - 1; k++)
			for(float i = -3; i < 2; i += .5)
				for(float j = (float) .5; j < 2; j += .5)
					layer[(int) (x+thickness+i+k)][(int) (y+j+k)] = tiles;
		
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness; j++)
				layer[x+i+width-thickness][y+j] = tiles;
	}
	
	public void printLetterG(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i][y+j] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < width - thickness; j++)
				layer[x+i][y+j] = tiles;
		for(int i = 0; i < width; i++)
			for(int j = 0; j < thickness; j++)
				layer[x+i][y+j+thickness+thickness] = tiles;
		for(int i = 0; i < thickness; i++)
			for(int j = 0; j < (width - thickness)/2; j++)
				layer[x+i+width-thickness][y+j+thickness+thickness/2] = tiles;
	}
	
	public void printLetter0(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
		
	}
	public void printLetter1(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
		
	}
	public void printLetter2(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
	
	}
	public void printLetter3(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
	
	}
	public void printLetter4(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
	
	}
	public void printLetter5(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
	
	}
	public void printLetter6(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
	
	}
	public void printLetter7(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
	
	}
	public void printLetter8(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
	
	}
	public void printLetter9(Pong pong, Image tiles, int x, int y, int width, int thickness, Image[][] layer){
	
	}

}
