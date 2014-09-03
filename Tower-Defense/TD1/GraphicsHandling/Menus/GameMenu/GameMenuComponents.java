package Menus.GameMenu;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import GraphicsController.Graphics;
import TowerController.Tower;

public class GameMenuComponents {
	
	public GameMenuComponents(Graphics graphics){
		final ImageIcon t88 = new ImageIcon("images\\multiplier.png"); 
		final ImageIcon t90 = new ImageIcon("images\\multipliersel.png");
        graphics.multiplier = new JButton(); 
        graphics.multiplier.setSize(61, 61); 
        graphics.multiplier.setIcon(t88); 
        graphics.multiplier.setLocation(520, 5);
        graphics.multiplier.setVisible(false);
        graphics.multiplier.setBorderPainted(false);
        graphics.multiplier.setContentAreaFilled(false);
        graphics.multiplier.setRolloverIcon(t90);
        graphics.add(graphics.multiplier); 
        
		final ImageIcon t1 = new ImageIcon(Tower.normalTowerPath); 
        graphics.turret1 = new JButton(); 
        graphics.turret1.setSize(28, 28); 
        graphics.turret1.setIcon(t1); 
        graphics.turret1.setLocation(625, 100);
        graphics.turret1.setVisible(false);
        graphics.add(graphics.turret1); 
        
        //filler
        final ImageIcon t2 = new ImageIcon(Tower.splashTowerPath); 
        graphics.turret2 = new JButton(); 
        graphics.turret2.setSize(28, 28); 
        graphics.turret2.setIcon(t2); 
        graphics.turret2.setLocation(675, 100);
        graphics.turret2.setVisible(false);
        graphics.add(graphics.turret2);
        
        final ImageIcon t3 = new ImageIcon("images\\tower1.png"); 
        graphics.temp2 = new JButton(); 
        graphics.temp2.setSize(28, 28); 
        graphics.temp2.setIcon(t3); 
        graphics.temp2.setLocation(725, 100);
      graphics.temp2.setVisible(false);
        graphics.add(graphics.temp2); 
        
        final ImageIcon t4 = new ImageIcon("images\\tower1.png"); 
        graphics.temp3 = new JButton(); 
        graphics.temp3.setSize(28, 28); 
        graphics.temp3.setIcon(t4); 
        graphics.temp3.setLocation(625, 150);
      graphics.temp3.setVisible(false);
        graphics.add(graphics.temp3); 
        
        final ImageIcon t5 = new ImageIcon("images\\tower1.png"); 
        graphics.temp4 = new JButton(); 
        graphics.temp4.setSize(28, 28); 
        graphics.temp4.setIcon(t5); 
        graphics.temp4.setLocation(675, 150);
      graphics.temp4.setVisible(false);
        graphics.add(graphics.temp4);
        
        final ImageIcon t6 = new ImageIcon("images\\tower1.png"); 
        graphics.temp5 = new JButton(); 
        graphics.temp5.setSize(28, 28); 
        graphics.temp5.setIcon(t6); 
        graphics.temp5.setLocation(725, 150);
      graphics.temp5.setVisible(false);
      graphics.add(graphics.temp5);
        
        final ImageIcon t7 = new ImageIcon("images\\tower1.png"); 
        graphics.nearest = new JButton(); 
        graphics.nearest.setSize(28, 28); 
        graphics.nearest.setIcon(t7); 
        graphics.nearest.setLocation(625, 510);
        graphics.nearest.setVisible(false);
        graphics.add(graphics.nearest);
        
        final ImageIcon t8 = new ImageIcon("images\\tower1.png"); 
        graphics.farthest = new JButton(); 
        graphics.farthest.setSize(28, 28); 
        graphics.farthest.setIcon(t8); 
        graphics.farthest.setLocation(660, 510);
        graphics.farthest.setVisible(false);
        graphics.add(graphics.farthest);
        
        final ImageIcon t9 = new ImageIcon("images\\tower1.png"); 
        graphics.lowest = new JButton(); 
        graphics.lowest.setSize(28, 28); 
        graphics.lowest.setIcon(t9); 
        graphics.lowest.setLocation(695, 510);
        graphics.lowest.setVisible(false);
        graphics.add(graphics.lowest);
        
        final ImageIcon t10 = new ImageIcon("images\\tower1.png"); 
        graphics.highest = new JButton(); 
        graphics.highest.setSize(28, 28); 
        graphics.highest.setIcon(t10); 
        graphics.highest.setLocation(730, 510);
        graphics.highest.setVisible(false);
        graphics.add(graphics.highest);
        
        final ImageIcon pause = new ImageIcon("images\\pause.png");
        final ImageIcon pausesel = new ImageIcon("images\\pausesel.png"); 
        graphics.pause = new JButton(); 
        graphics.pause.setSize(90, 32); 
        graphics.pause.setIcon(pause); 
        graphics.pause.setLocation(625, 15);
        graphics.pause.setVisible(false);
        graphics.pause.setBorderPainted(false);
        graphics.pause.setContentAreaFilled(false);
        graphics.pause.setRolloverIcon(pausesel);
        graphics.add(graphics.pause);
          
        final ImageIcon nextwave = new ImageIcon("images\\nextwave.png");
        final ImageIcon nwsel = new ImageIcon("images\\nextwavesel.png"); 
        graphics.nextwave = new JButton(); 
        graphics.nextwave.setSize(153, 33); 
        graphics.nextwave.setIcon(nextwave); 
        graphics.nextwave.setLocation(625, 50); 
        graphics.nextwave.setVisible(false);
        graphics.nextwave.setBorderPainted(false);
        graphics.nextwave.setContentAreaFilled(false);
        graphics.nextwave.setRolloverIcon(nwsel);
        graphics.add(graphics.nextwave);
        
        final ImageIcon edargpu = new ImageIcon("images\\upgrade.png");
        final ImageIcon edargpu1 = new ImageIcon("images\\upgrade1.png"); 
        graphics.upgrade = new JButton(); 
        graphics.upgrade.setSize(114, 35); 
        graphics.upgrade.setIcon(edargpu); 
        graphics.upgrade.setLocation(620, 395);
        graphics.upgrade.setVisible(false);
        graphics.upgrade.setBorderPainted(false);
        graphics.upgrade.setContentAreaFilled(false);
        graphics.upgrade.setRolloverIcon(edargpu1);
        graphics.add(graphics.upgrade); 
        
        final ImageIcon lles = new ImageIcon("images\\sell.png");
        final ImageIcon lles1 = new ImageIcon("images\\sell1.png"); 
        graphics.sell = new JButton(); 
        graphics.sell.setSize(52, 33); 
        graphics.sell.setIcon(lles); 
        graphics.sell.setLocation(620, 435);
        graphics.sell.setVisible(false);
        graphics.sell.setBorderPainted(false);
        graphics.sell.setContentAreaFilled(false);
        graphics.sell.setRolloverIcon(lles1);
        graphics.add(graphics.sell);
        
        final ImageIcon b4 = new ImageIcon("images\\save.png"); 
        final ImageIcon z5 = new ImageIcon("images\\saveselection.png");
        graphics.save2 = new JButton(); 
        graphics.save2.setSize(225, 70); 
        graphics.save2.setIcon(b4); 
        graphics.save2.setLocation(175, 525);
        graphics.save2.setOpaque(false);
        graphics.save2.setFocusPainted(false);
        graphics.save2.setBorderPainted(false);
        graphics.save2.setContentAreaFilled(false);
        graphics.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        graphics.save2.setVisible(false);
        graphics.save2.setRolloverIcon(z5);
        graphics.add(graphics.save2);
	}

}
