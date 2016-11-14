import javax.swing.*;


public class ScreenReservations extends JPanel {

	HotelController controller;
	
	public ScreenReservations() {
		controller = new HotelController();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JTextArea reservations = new JTextArea("reservations should be clickable(?)");
		JButton delete = new JButton("Delete Reservation");
		JButton menu = new JButton("Return to Guest Menu");
		
		menu.addActionListener(controller.changeScreen(new ScreenGuestOptions()));
		// delete.addActionListener
		
		add(reservations);
		add(delete);
		add(menu);
	}

}
