package UpdateCreeps;

import CreepController.Creep;
import GameController.Game;

public class AddCreeps {
	
	public AddCreeps(Game td, Creep temp){
		td.armyOfCreeps.add(temp);
        if(temp.type.toLowerCase().equals("normalcreep"))
        	td.normalCreep.add(temp);
        if(temp.type.toLowerCase().equals("normalboss"))
        	td.normalBoss.add(temp);
        if(temp.type.toLowerCase().equals("flyingcreep"))
        	td.flyingCreep.add(temp);
        if(temp.type.toLowerCase().equals("fastcreep"))
        	td.fastCreep.add(temp);
        
        temp = null;
	}

}
