package nl.jojoxd.theChernoGame.entity.mob;

import nl.jojoxd.theChernoGame.graphics.Screen;
import nl.jojoxd.theChernoGame.input.Keyboard;

public class Player extends Mob{
	
	private Keyboard input;
	
	
	public Player(Keyboard input){
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input){
		this.input = input;
		this.x = x;
		this.y = y;
	}
	
	public void update(){
		int xa = 0, ya = 0;
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		// RUN FORREST RUN
		if(input.up && input.shift) ya -= 1.25;
		if(input.down && input.shift) ya += 1.25;
		if(input.left && input.shift) xa -= 1.25;
		if(input.right && input.shift) xa += 1.25;
		
		if(xa != 0 || ya != 0) move(xa, ya);
	}
	
	public void render(Screen screen){
		int xx = x - 16;
		int yy = y - 16;
		screen.renderPlayer(xx, yy, sprite.player0);
		screen.renderPlayer(xx + 16, yy, sprite.player1);
		screen.renderPlayer(xx, yy + 16, sprite.player2);
		screen.renderPlayer(xx + 16, yy + 16, sprite.player3);
	}
}
