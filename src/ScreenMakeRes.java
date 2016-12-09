import java.awt.Dimension;
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
	private GuestSession gs;

	public ScreenMakeRes(HotelView v, boolean pp) {
		popup = pp;
		view = v;
		gs = (GuestSession) view.getUserSession();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Dimension tf = new Dimension(200,25);
		
		JLabel instructions = new JLabel("Note: Reservations may not exceed 60 days");
		
		JLabel checkIn = new JLabel("Check in (MM/DD/YYYY):");
		JTextField checkInDate = new JTextField();
		checkInDate.setPreferredSize(tf);
		
		JLabel checkOut = new JLabel("Check out (MM/DD/YYYY):");
		JTextField checkOutDate = new JTextField();
		checkOutDate.setPreferredSize(tf);
		
		JPanel buttonPan = new JPanel();
		buttonPan.setLayout(new FlowLayout());
		
		JButton seeLuxuryRooms = new JButton("See Luxury Rooms");	
		JButton seeEconomicRooms = new JButton("See Economic Rooms");
		
		seeLuxuryRooms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gs.setPrice(200);
				gs.setStart(checkInDate.getText());
				gs.setEnd(checkOutDate.getText());
				
				if (popup) { /*if popup, then it just closes */
					((JFrame) (((JComponent) e.getSource()).getTopLevelAncestor())).dispose(); 
				}
				else {
					gs.eraseNewReservations();
					view.changeScreen(new ScreenVacancies(view));
				}
			}

		});
		
		seeEconomicRooms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gs.setPrice(80);
				gs.setStart(checkInDate.getText());
				gs.setEnd(checkOutDate.getText());
				
				if (popup) { /*if popup, then it just closes */
					((JFrame) (((JComponent) e.getSource()).getTopLevelAncestor())).dispose(); 
				}
				else {
					gs.eraseNewReservations();
					view.changeScreen(new ScreenVacancies(view));
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
