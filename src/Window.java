import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	static JFrame window;
	
	Window(int w, int h, String title, SolarEmpire game) {
		window = new JFrame(title);
		window.add(game);
		window.pack();
		window.setSize(new Dimension(w, h));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		game.start();
	}
	
}
