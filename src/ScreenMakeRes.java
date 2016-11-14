import javax.swing.*;


public class ScreenMakeRes extends JPanel {

	private HotelController controller;
	
	public ScreenMakeRes() {
		controller = new HotelController();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel instructions = new JLabel("Note: Reservations may not exceed 60 days");
		
		JLabel checkIn = new JLabel("Check in (MM/DD/YYYY):");
		JTextField checkInDate = new JTextField();
		
		JLabel checkOut = new JLabel("Check out (MM/DD/YYYY):");
		JTextField checkOutDate = new JTextField();
		
		JButton seeRooms = new JButton("See Rooms");
		
		seeRooms.addActionListener(controller.changeScreen(new ScreenVacancies()));
		
		add(instructions);
		add(checkIn);
		add(checkInDate);
		add(checkOut);
		add(checkOutDate);
		add(seeRooms);
	}

}
