package NormalTower;

import TowerController.Tower;

public class UpgradeNormalTower {
	
	public UpgradeNormalTower(Tower t){
		t.resell = t.resell+t.upgradeCost/2; 
        t.level++; 
        t.attackRadius += 1; 
        t.attackSpeed += 1; 
        
        if(t.game.playerclass.toLowerCase().equals("damage")){
        	t.damage += t.level;
        	t.damage += t.level * .15;
        }
        else
        	t.damage += t.level;
        
        
        t.upgradeTime += (t.level/2) + 1; 
        t.upgradeCost += t.level*5; 
	}
}
