package nl.jojoxd.theChernoGame.graphics;

public class Sprite {
	
	public final int SIZE;
	private int x, y;
	public int[] pixels;
	
	private SpriteSheet sheet;
	
	public static Sprite grass = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite flowerGrass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite stone1 = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite stone2 = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite wood1 = new Sprite(16, 4, 0, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	private void load(){
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
