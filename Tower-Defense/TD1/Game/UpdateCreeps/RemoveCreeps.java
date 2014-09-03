package UpdateCreeps;

import CreepController.Creep;
import GameController.Game;

public class RemoveCreeps {
	
	public RemoveCreeps(Game td, Creep creep){
		
		td.armyOfCreeps.remove(creep);
		if(creep.type.equals("normalcreep"))
			td.normalCreep.remove(creep);
		if(creep.type.equals("flyingcreep"))
			td.flyingCreep.remove(creep);
		if(creep.type.equals("normalboss"))
			td.normalBoss.remove(creep);
		if(creep.type.equals("fastcreep"))
			td.fastCreep.remove(creep);
		
		creep = null;
	}

}
