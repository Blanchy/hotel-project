import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * 
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
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
	
	User session;
	
	Hotel hotel;

	private int	WIDTH = 500;
	private int HEIGHT = 500;
	
	public HotelView(Hotel h) {
		hotel = h;

		frame = new JFrame();
		frame.setLayout(new BorderLayout());
//		frame.setPreferredSize(new Dimension(500,500));

		currentPan = new ScreenInitial(this);
		frame.add(currentPan, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		HotelView tester = new HotelView(new Hotel());
	}

	public void changeScreen(JPanel jp) {
		
		frame.setContentPane(jp);
		frame.pack();
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
	/**
	 * 
	 * @return Hotel object
	 */
	public Hotel getHotel() {
		return hotel;
	}
	
	/**
	 * 
	 * @param u GuestSession or ManagerSession
	 */
	public void setUserSession(User u) {
		session = u;
	}
	
	/**
	 * 
	 * @return the GuestSession or ManagerSession
	 */
	public User getUserSession() {
		return session;
	}

}
