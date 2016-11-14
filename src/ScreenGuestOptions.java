import javax.swing.*;

public class ScreenGuestOptions extends JPanel {

	private HotelController controller;
	
	public ScreenGuestOptions() {
		controller = new HotelController();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton makeRes = new JButton("Make a Reservation");
		JButton viewDelete = new JButton("View/Delete Reservations");
		JButton signOut = new JButton("Sign out of Guest User");
		
		makeRes.addActionListener(controller.changeScreen(new ScreenMakeRes()));
		viewDelete.addActionListener(controller.changeScreen(new ScreenReservations()));
		signOut.addActionListener(controller.changeScreen(new ScreenInitial()));
		
		add(makeRes);
		add(viewDelete);
		add(signOut);
	}

}
