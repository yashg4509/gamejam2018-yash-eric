import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SolarEmpire extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L; //ignore
	
	final static int WIDTH = 800;
	final int HEIGHT = 600;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	public BufferedImage menuBackground;
	
	private boolean running = false;
	
	private Menu m;
	private Thread thread;
	
	public static State currentState = State.Menu;
	
	
	public void init() {
		try {
			menuBackground = ImageIO.read(this.getClass().getResourceAsStream("menuBackground.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		m = new Menu();
	}
	
	public void start() {
		if(running) { //If running is false, break out of the stop method
			return;
		}

		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 800);

//		g.drawImage(background, 0, 0, null);
		
		if(currentState == State.Menu) {
			g.drawImage(menuBackground, 0,0, this);
			m.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Window(800, 600, "Solar Empire", new SolarEmpire());
	}

	public void run() { //game loop
		init();
		long lastTime = System.nanoTime(); 
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis(); //Current time in millisecond return

		while(running) { //GAME LOOP
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now; //Sets lastTime to current time
			if (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
//				System.out.println(String.format("%d Ticks, FPS: %d",
//						updates, frames));
				updates = 0; //Resets updates
				frames = 0; //Resets frames
			}
		}

		stop();
		
	}

	public void stop() {
		if(!running) { //If running is false, break out of the start method
			return;
		}

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}

	public void tick() {
		if(currentState == State.Game) {
			System.out.println("Playing...");
		}
		
	}

	
	
}
