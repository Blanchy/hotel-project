import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ScreenMakeRes extends JPanel {

	private HotelView view;
	
	public ScreenMakeRes(HotelView v) {
		view = v;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel instructions = new JLabel("Note: Reservations may not exceed 60 days");
		
		JLabel checkIn = new JLabel("Check in (MM/DD/YYYY):");
		JTextField checkInDate = new JTextField();
		
		JLabel checkOut = new JLabel("Check out (MM/DD/YYYY):");
		JTextField checkOutDate = new JTextField();
		
		JPanel buttonPan = new JPanel();
		buttonPan.setLayout(new FlowLayout());
		
		JButton seeLuxuryRooms = new JButton("See Luxury Rooms");	
		JButton seeEconomicRooms = new JButton("See Economic Rooms");
		
		seeLuxuryRooms.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				this.dispose();
				ScreenVacancies sv = new ScreenVacancies(view);
				// set up sv so that it gets the appropriate rooms
				// send textfield and jbutton input somewhere
				// check validity of input
				view.changeScreen(sv);
			}

		});
		
		seeEconomicRooms.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				this.dispose();
				ScreenVacancies sv = new ScreenVacancies(view);
				// set up sv so that it gets the appropriate rooms
				// send textfield and jbutton input somewhere
				// check validity of input
				view.changeScreen(sv);
			}

		});
		
		add(instructions);
		add(checkIn);
		add(checkInDate);
		add(checkOut);
		add(checkOutDate);
		
		buttonPan.add(seeLuxuryRooms);
		buttonPan.add(seeEconomicRooms);
		add(buttonPan);
	}

}
