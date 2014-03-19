package nl.jojoxd.theChernoGame.level.tile;

import nl.jojoxd.theChernoGame.graphics.Screen;
import nl.jojoxd.theChernoGame.graphics.Sprite;

public class Stone2Tile extends Tile {

	public Stone2Tile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this);
	}

}
