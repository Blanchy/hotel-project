import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * @author blanchypolangcos
 * 
 * HotelView contains a JFrame. 
 * It initializes with the JPanel ScreenInitial, and the panel is added to the frame. 
 * Each screen has buttons with action listeners.
 * 
 * The action listeners call for the controller to change the HotelView's panel
 * to a different Screen.
 */

public class HotelView {

	JFrame frame;
	JPanel currentPan;
	
	Hotel hotel;

	private int	WIDTH = 500;
	private int HEIGHT = 500;
	
	public HotelView(Hotel h) {
		hotel = h;

		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setPreferredSize(new Dimension(500,500));

		currentPan = new ScreenInitial(this);
		frame.add(currentPan, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		HotelView tester = new HotelView();
	}

	public void changeScreen(JPanel jp) {
		
		frame.setContentPane(jp);
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	/**
	 * formats data from model to suit the upcoming screen
	 * @param jp upcoming JPanel
	 */
	public void getData(JPanel jp) {
		if (jp instanceof ScreenVacancies) {
			/* this retrieves data from user session */
		}
		else if (jp instanceof ScreenReciept) {
			/* this retrieves data from user session */
		}
		else if (jp instanceof ScreenManagerView) {
			/* info from Hotel */
		}
		else if (jp instanceof ScreenReservations) {
			/* info from user session (this is looking at a particular
			 * guest's reservations)
			 */
		}
	}

}
