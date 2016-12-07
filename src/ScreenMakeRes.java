import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ScreenMakeRes extends JPanel {

	private HotelView view;
	private boolean popup; /* if ScreenMakeRes was created by
	 						  on ScreenVacancies then it is a
	 						  popup that closes when the buttons
	 						  are pressed and leads ScreenVacancies
	 						  to update */

	public ScreenMakeRes(HotelView v, boolean pp) {
		popup = pp;
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
				
				ScreenVacancies sv = new ScreenVacancies(view);
				// set up sv so that it gets the appropriate rooms
				// send textfield and jbutton input somewhere
				// check validity of input
				view.changeScreen(sv);
				
				if (popup) {
					((JFrame) (((JComponent) e.getSource()).getTopLevelAncestor())).dispose(); 
				}
			}

		});
		
		seeEconomicRooms.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				
				ScreenVacancies sv = new ScreenVacancies(view);
				// set up sv so that it gets the appropriate rooms
				// send textfield and jbutton input somewhere
				// check validity of input
				view.changeScreen(sv);
				
				if (popup) {
					((JFrame) (((JComponent) e.getSource()).getTopLevelAncestor())).dispose(); 
				}
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
