package nl.jojoxd.theChernoGame;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import nl.jojoxd.theChernoGame.graphics.Screen;
import nl.jojoxd.theChernoGame.input.Keyboard;

public class Game extends Canvas implements Runnable {
	// continue @ http://www.youtube.com/watch?v=-XclQ0Tp0d4&list=ELshNxV9QFUOo (ep 30 :D)
	private static final long serialVersionUID = 1L;
	public static int width = 300;
	public static int height = 192;
	public static int scale = 3;
	public final String title = "TheChernogame [Test]";

	private Thread gameThread;
	private JFrame frame;
	private Keyboard key;
	private boolean running = false;

	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private Screen screen;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		frame = new JFrame();
		screen = new Screen(width, height);
		key = new Keyboard();
		addKeyListener(key);
	}

	public synchronized void start() {
		running = true;
		gameThread = new Thread(this, "gameThread");
		gameThread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while (running == true) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps.");
				frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	public void update() {
		// this will run @ 60x/second
		key.update();
		if(key.up == true) y--;
		if(key.down == true) y++;
		if(key.left == true) x--;
		if(key.right == true) x++;
	}
	
	int x = 0, y = 0;
	public void render() {
		// this will run @ *x/second (== the fps)
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		
		screen.clear();
		screen.render(x , y);
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
