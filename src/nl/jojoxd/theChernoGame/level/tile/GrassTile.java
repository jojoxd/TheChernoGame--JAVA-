package nl.jojoxd.theChernoGame.level.tile;

import nl.jojoxd.theChernoGame.graphics.Screen;
import nl.jojoxd.theChernoGame.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x, y, this);
	}

}
