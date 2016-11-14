import java.awt.Dimension;

import javax.swing.*;


public class ScreenInitial extends JPanel {

	private HotelController controller;
	
	public ScreenInitial() {
		controller = new HotelController();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel userType = new JLabel("User Type:");
		JButton manager = new JButton("Manager");
		JButton guest = new JButton("Guest");
		
		manager.addActionListener(controller.changeScreen(new ScreenManager()));
		guest.addActionListener(controller.changeScreen(new ScreenGuest()));
		
		add(userType);
		add(manager);
		add(guest);
	}
	
}
