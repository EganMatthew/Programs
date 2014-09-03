package UpdateComponents;

import GameController.Game;
import TowerController.Tower;

public class UpdateRepaint {
	public UpdateRepaint(Game td, long repaintdelay, int updateGraphicsDelay){
		//for each tower if there is a creep in range, have the tower point 
        //at the creep. Also this is where the graphics are updated. 
        if(System.nanoTime() - repaintdelay > updateGraphicsDelay){

            td.repaintdelay = System.nanoTime();
            td.graphics.repaint();
        }
	}
}
