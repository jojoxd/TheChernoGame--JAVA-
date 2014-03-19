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
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);
	
	public static Sprite player0 = new Sprite(16, 0, 10, SpriteSheet.tiles);
	public static Sprite player1 = new Sprite(16, 1, 10, SpriteSheet.tiles);
	public static Sprite player2 = new Sprite(16, 0, 11, SpriteSheet.tiles);
	public static Sprite player3 = new Sprite(16, 1, 11, SpriteSheet.tiles);
	
	public static Sprite player = new Sprite(32, 0, 10, SpriteSheet.tiles);
	
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color){
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}
	
	private void setColor(int color){
		for (int i = 0; i < SIZE*SIZE; i++){
			pixels[i] = color;
		}
	}
	
	private void load(){
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
	}
}
