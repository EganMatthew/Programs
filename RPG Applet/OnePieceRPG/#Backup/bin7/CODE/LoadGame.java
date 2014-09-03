import java.awt.*;

public class LoadGame {
	
	OnePieceRPG applet;
	Image background;
	Image arrow;
	Font font;
	
	int currentXPosition;
	boolean enterPressed;
	boolean file1, file2, file3, file4;
	
	public LoadGame(Image background, Image arrow, OnePieceRPG applet){
		this.applet = applet;
		this.background = background;
		this.arrow = arrow;
		currentXPosition = 0;
		//loop up file
		file1 = false;
		file2 = false;
		file3 = false;
		file4 = false;
	}
	
	public void paint(Graphics gfx){
		gfx.drawImage(background, 0, 0, applet);
		
		font = new Font("Gungsuh", Font.PLAIN, 23);
		gfx.setFont(font);
		gfx.setColor(Color.green);
		
		
		for(int i = 0; i < 4; i++){
			if(currentXPosition == i)
				gfx.drawImage(arrow, 248+(i*143), 201, applet);
		}
		
		
		
//==========================================================================
//==========================================================================		
		if(file1){
			
		}
		else
			gfx.drawString("No Data", 275, 270);
//==========================================================================
//==========================================================================	
		if(file2){
			
		}
		else
			gfx.drawString("No Data", 275+(1*143), 270);
//==========================================================================
//==========================================================================
		if(file3){
			
		}
		else
			gfx.drawString("No Data", 275+(2*143), 270);
//==========================================================================
//==========================================================================
		if(file4){
	
		}
		else
			gfx.drawString("No Data", 275+(3*143), 270);
	}
	
	public void increaseXPosition(){
		currentXPosition++;
		if(currentXPosition > 3){
			currentXPosition = 3;
		}
	}
	
	public void decreaseXPosition(){
		currentXPosition--;
		if(currentXPosition < 0){
			currentXPosition = 0;
		}
	}
	
	public void setEnterPressed(boolean temp){
		enterPressed = temp;
	}
	
	
	
}
