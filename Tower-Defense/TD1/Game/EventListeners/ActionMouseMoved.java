package EventListeners;

import GameController.Game;

public class ActionMouseMoved {
	
	public ActionMouseMoved(Game td){
		
		if(td != null){
			if(td.graphics != null) {
	    		
	    		if(td.graphics.getMousePosition() != null){
			        td.mouseX = (int) td.graphics.getMousePosition().getX(); 
			        td.mouseY = (int) td.graphics.getMousePosition().getY();
			        td.graphics.setMousePosition(td.mouseX, td.mouseY);
			        td.graphics.repaint();
	    		}
	    	}
		}
	}
}
