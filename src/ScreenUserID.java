import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 * Prompts the Guest to enter a user ID.
 * GuestSession of interface User is then created with that ID.
 *
 **/
public class ScreenUserID extends JPanel {

	private HotelView view;
	
	/**
	 * Constructor for classes of this object.
	 * @param v HotelView object upon which this JPanel is mounted.
	 */
	public ScreenUserID(HotelView v) {
		view = v;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel userPrompt = new JLabel("Enter User ID (numbers and letters ONLY):");
		JTextField input = new JTextField();
		JButton enter = new JButton("Continue");
		
		enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.changeScreen(new ScreenGuestOptions(view));
				view.setUserSession(new GuestSession(view.getHotel(), input.getText()));
			}

		});
		
		add(userPrompt);
		add(input);
		add(enter);
	}
}
