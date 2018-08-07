import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		//movement
		if(handler.isUp()) {
			velY = -5;
		} else if(!handler.isDown()) {
			velY = 0;
		} 
		
		if(handler.isDown()) {
			velY = 5;
		} else if(!handler.isUp()) {
			velY = 0;
		}
		
		if(handler.isRight()) {
			velX = 5;
		} else if(!handler.isLeft()) {
			velX = 0;
		}
		
		if(handler.isLeft()) {
			velX = -5;
		} else if(!handler.isRight()) {
			velX = 0;
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 48);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle(x, y, 32, 48);
	}

}
