package Menus.Movies;

import GraphicsController.Graphics;

public class CreateAndLoadMovie1 {
	
	public CreateAndLoadMovie1(boolean temp, Graphics graphics){
		if(temp){
			for(int i = 0; i < graphics.numSplits; i++)
            	setAlpha(graphics.alpha, graphics);
		}
		else {
			playMovie1(graphics);
		}
			
	}
	
	
	public void setAlpha(byte alpha, Graphics graphics) {
    	
    	int startingNum = 11;
    	startingNum += graphics.split;
    	
	    for (int cx=124;cx<673;cx++) {          
	        for (int cy=startingNum;cy<569;cy+=graphics.numSplits) {
	        	if(graphics.intro != null){
		            int color = graphics.intro.getRGB(cx, cy);
		            color &= 0x00FFFFFF;
		            int mc = (alpha << 24) & 0xFF000000;
		            int newcolor = color | mc;
		            graphics.intro.setRGB(cx, cy, newcolor);  
	          	}
	        }
	    }
	    graphics.split++;
    	if(graphics.split > graphics.numSplits-1)
    		graphics.split = 0;
    }
	
	public void playMovie1(Graphics graphics){
    	
    	long time = System.nanoTime();
    	
    	while(graphics.alpha != -1){
	    	while(System.nanoTime() - time > 2000000){
	    		setAlpha(graphics.alpha, graphics);
	    		if(graphics.alpha == 127)
	    			graphics.alpha = -127;
	    		graphics.alpha++;
	    		if(graphics.alpha == -1)
	    			break;
	    		graphics.repaint();
	    		time = System.nanoTime();
	    	}
	    	graphics.repaint();
    	}
    	graphics.alpha = -1;
    	while(graphics.alpha != 0){
	    	while(System.nanoTime() - time > 1000000){
	    		setAlpha(graphics.alpha, graphics);
	    		if(graphics.alpha == -127)
	    			graphics.alpha = 127;
	    		graphics.alpha--;
	    		if(graphics.alpha == 0)
	    			break;
	    		graphics.repaint();
	    		time = System.nanoTime();
	    	}
	    	graphics.repaint();
    	}
    	//time = System.nanoTime();
    	//while(System.nanoTime() - time < 50000);
    	
    	graphics.introScreen = false;
    	graphics.mainMenuScreen = false;
    	graphics.worldCreaterScreen = false;
        graphics.optionsScreen = false;
        graphics.difficultyScreen = false;
        graphics.worldSelectorScreen = false;
        graphics.gameScreen = false;
        graphics.loginScreen = true;
    }
}
