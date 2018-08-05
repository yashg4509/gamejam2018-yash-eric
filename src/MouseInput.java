import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;


public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		// Play
		if (mx >= SolarEmpire.WIDTH / 2 + 120 && mx <= SolarEmpire.WIDTH / 2 + 220) {
			if (my >= 150 & my <= 200) {
				// Pressed Play Button
				SolarEmpire.currentState = State.Game;
			}
		}
		
		//Help
		if (mx >= SolarEmpire.WIDTH / 2 + 120 && mx <= SolarEmpire.WIDTH / 2 + 220) {
			
			if(my >= 250 & my <= 400) {
				SolarEmpire.currentState = State.Help;
			}
			
		}

		// Quit
		if (mx >= SolarEmpire.WIDTH / 2 + 120 && mx <= SolarEmpire.WIDTH / 2 + 220) {
			if (my >= 350 & my <= 400) {
				// Pressed Quit Button
				System.exit(1);
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
