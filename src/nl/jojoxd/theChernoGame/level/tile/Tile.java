package nl.jojoxd.theChernoGame.level.tile;

import nl.jojoxd.theChernoGame.graphics.Screen;
import nl.jojoxd.theChernoGame.graphics.Sprite;

public abstract class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	
	public Tile(Sprite sprite){
		this.sprite = sprite;
		
	}
	
	public void render(int x, int y, Screen screen){
	}
	
	
	public boolean solid(){
		return false;
	}

}
