package nl.jojoxd.theChernoGame.entity;

import java.util.Random;

import nl.jojoxd.theChernoGame.graphics.Screen;
import nl.jojoxd.theChernoGame.level.Level;

public abstract class Entity {
	
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	
	public void update(){
		
	}
	
	public void render(Screen screen){
		
	}
	
	public void remove(){
		// removed from level
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
}
