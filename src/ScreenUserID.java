import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ScreenUserID extends JPanel {

	private HotelView view;
	
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
