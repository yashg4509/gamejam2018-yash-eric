import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	public Window(int w, int h, String title, TownEscape game) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(w, h));
		frame.setMaximumSize(new Dimension(w, h));
		frame.setMinimumSize(new Dimension(w, h));
		
		frame.add(game);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
}
