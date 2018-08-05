
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playButton = new Rectangle(SolarEmpire.WIDTH / 4 + 130, 150, 100, 50);
	public Rectangle helpButton = new Rectangle(SolarEmpire.WIDTH / 4 + 130, 250, 100, 50);
	public Rectangle quitButton = new Rectangle(SolarEmpire.WIDTH / 4 + 130, 350, 100, 50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
		Font fnt0 = new Font("monospaced", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.BLACK);
		g.drawString("Solar Empire", 200, 80);
		
		Font fnt1 = new Font("timesroman", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 23, playButton.y + 32);
		g.drawString("Quit", quitButton.x + 23, quitButton.y + 32);
		
		Font fnt2 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt2);
		g.drawString("Help", helpButton.x + 23, helpButton.y + 32);
		
		g2d.draw(playButton);
		g2d.draw(helpButton);
		g2d.draw(quitButton);
	}
}
