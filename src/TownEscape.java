import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class TownEscape extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	private boolean running = false;
	
	private Thread thread;
	private Handler handler;
	
	private BufferedImage level = null;
	
	
	public TownEscape() {
		new Window(1000, 563, "Town Escape", this);
		start();
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		level = loader.loadImage("/town.png");
		
		loadLevel(level);
	}
	
	private void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	private void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TownEscape();
	}

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
			}
		}
		stop();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.red);
		g.fillRect(0, 0, 1000, 563);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
		
	}
	
	//loading level
	
	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		for (int xx = 0; xx < w; xx++) {
			for (int yy = 0; yy < h; yy++) {
				int pixel = image.getRGB(xx, yy);
				
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255) {
					handler.addObject(new Block(xx * 32, yy * 32, ID.Block));
				}
				
				if(blue == 255) {
					handler.addObject(new Player(xx*32, yy*32, ID.Player, handler));
					
				}
			}
			
		}
	}

	public void tick() {
		handler.tick();
	}
}
