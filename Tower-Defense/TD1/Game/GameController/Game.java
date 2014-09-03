package GameController; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import java.awt.event.MouseMotionListener; 
import java.util.ArrayList; 
import java.util.LinkedList;
import java.util.Queue;

import TowerController.Tower;
import UpdateComponents.UpdateBulletsLogical;
import UpdateComponents.UpdateNextWave;
import UpdateComponents.UpdateRepaint;
import UpdateComponents.UpdateTowerFiringLogical;
import UpdateCreeps.UpdateNormalBossCreep;
import UpdateCreeps.UpdateFastCreeps;
import UpdateCreeps.UpdateFlyingCreeps;
import UpdateCreeps.UpdateNormalCreeps;
import Bullet.Bullet;
import CreepController.Creep;
import EventListeners.ActionMouseMoved;
import EventListeners.ActionMouseReleased;
import EventListeners.AddButtonListeners;
import EventListeners.AddSoundListeners;
import GraphicsController.Graphics;
  
public class Game implements MouseListener, MouseMotionListener{ 

    public static void main(String[] args){ 
        Game g = new Game();
    } 
    
    volatile public Graphics graphics; 
    
    volatile public ArrayList<Creep> armyOfCreeps= new ArrayList<Creep>();
    volatile public ArrayList<Creep> normalCreep = new ArrayList<Creep>();
    volatile public ArrayList<Creep> normalBoss = new ArrayList<Creep>(); 
    volatile public ArrayList<Creep> flyingCreep = new ArrayList<Creep>(); 
    volatile public ArrayList<Creep> fastCreep = new ArrayList<Creep>(); 
    
    volatile public ArrayList<Tower> towers = new ArrayList<Tower>();
    volatile public ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    public int waveNumber; 
    public Queue<String> waveOrder = new LinkedList<String>(); 
    volatile public int money;  
    public int numberOfLives;
    volatile public boolean notPaused; 
    volatile public boolean nextWave;
    volatile public int mouseX; 
    volatile public int mouseY; 
    volatile public boolean iteratingThuTowers;
    public boolean increaseWaveNumber = true;
    public int numberOfCreepsCount = 0; 
    public Creep creepToAimAt = null;
    
    public long normalcreepdelay;
    public long normalbosscreepdelay;
    public long flyingcreepdelay;
    public long fastcreepdelay;
    public long towerdelay;
    public long repaintdelay;
    public long addCreepDelay;
    public long spawnCreepDelay; 
    public long bulletFireDelay;
    
    public int nextWaveDelay = 10000; 
    public int towerFireDelay = 1000; 
    public int updateGraphicsDelay = 1200000; 
    public int bulletSpeedDelay = 2500000; //5,000,000
    //public int numberOfCreeps = 1500;
    
    public double soundVolume = .05;
    public double musicVolume = .05;
    public double masterVolume = 1;
    
    public String username = "Default";
    public String playerclass;
    
    public int score = 0;
    public double multiplier = 1.01;
    public int multiplierCost = 100;
  
    public Game(){

        notPaused = false; 
        money = 50; 
        waveNumber = 0; 
        graphics = new Graphics(this);
        
        waveOrder.add("normalcreep");
        waveOrder.add("fastcreep");
        waveOrder.add("flyingcreep");
        waveOrder.add("normalboss");
        
        graphics.addMouseListener(this); 
        graphics.addMouseMotionListener(this); 
        graphics.turret1.addMouseListener(this); 
        graphics.turret2.addMouseListener(this); 
        graphics.easy.addMouseListener(this); 
        graphics.medium.addMouseListener(this); 
        graphics.hard.addMouseListener(this); 
        graphics.nearest.addMouseListener(this);
        graphics.farthest.addMouseListener(this);
        graphics.lowest.addMouseListener(this);
        graphics.highest.addMouseListener(this);
        graphics.menu.addMouseListener(this);
        
        new AddButtonListeners(graphics, this);
        AddSoundListeners soundHandler = new AddSoundListeners(graphics, this);
        
        start();
    }
    
    public void reset(){
    	graphicsReset();
    	
    	armyOfCreeps = new ArrayList<Creep>(); 
    	normalCreep = new ArrayList<Creep>(); 
    	normalBoss = new ArrayList<Creep>(); 
    	flyingCreep = new ArrayList<Creep>(); 
    	fastCreep = new ArrayList<Creep>(); 
    	
    	towers = new ArrayList<Tower>();
    	bullets = new ArrayList<Bullet>();
    	waveOrder = new LinkedList<String>();
    	waveOrder.add("normalcreep");
    	waveOrder.add("fastcreep");
    	waveOrder.add("flyingcreep");
    	waveOrder.add("normalboss");
    	money = 50;
    	waveNumber = 0;
    	notPaused = false;
    	numberOfCreepsCount = 0;
    	graphics.repaint();
    	multiplier = 1.01;
    	multiplierCost = 100;
    }
    
    public void graphicsReset(){
    	graphics.towersToPaint = new ArrayList<Tower>(); 
    	graphics.creepsToPaint = new ArrayList<Creep>();
    	graphics.bulletsToPaint = new ArrayList<Bullet>();
    	graphics.difficultyScreen = true;
    }
    
    public void updateScore(){
    	//(((wave #)/5)*% multiplier )*(total gold(money))
    	double temp = (double)waveNumber/5.0;
    	double temp2 = temp * multiplier;
    	double temp3 = temp2 * money;
    	score = (int)temp3;
    }
      
    public void start(){
    	
    	normalcreepdelay = System.nanoTime();
    	normalbosscreepdelay = System.nanoTime();
    	flyingcreepdelay = System.nanoTime();
    	fastcreepdelay = System.nanoTime();
        towerdelay= System.currentTimeMillis(); 
        repaintdelay = System.nanoTime(); 
        addCreepDelay = System.currentTimeMillis(); 
        spawnCreepDelay = System.currentTimeMillis(); 
        bulletFireDelay = System.nanoTime();
    	
        while(true){
        	while(!notPaused);

        	new UpdateFastCreeps(this, fastcreepdelay);
        	new UpdateNormalCreeps(this, normalcreepdelay);
        	new UpdateNormalBossCreep(this, normalbosscreepdelay);
        	new UpdateFlyingCreeps(this, flyingcreepdelay);
        	
        	
        	new UpdateBulletsLogical(this, bulletFireDelay, bulletSpeedDelay);
        	new UpdateTowerFiringLogical(this, towerdelay, towerFireDelay);
        	new UpdateRepaint(this, repaintdelay, updateGraphicsDelay);
        	new UpdateNextWave(this, spawnCreepDelay, nextWaveDelay, addCreepDelay);
        }
    }

    public void mouseClicked(MouseEvent arg0) {} 
    public void mouseEntered(MouseEvent arg0) {} 
    public void mouseExited(MouseEvent arg0) {} 
    public void mouseDragged(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {} 
    public void mouseReleased(MouseEvent arg0) {
    	new ActionMouseReleased(this, arg0);
    }
    public void mouseMoved(MouseEvent arg0) { 
        new ActionMouseMoved(this);
    }

}