import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ScreenReservations extends JPanel {

	HotelView view;
	
	public ScreenReservations(HotelView v) {
		view = v;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JTextArea reservations = new JTextArea("reservations should be clickable(?)");
		JButton delete = new JButton("Delete Reservation");
		JButton menu = new JButton("Return to Guest Menu");
		
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenGuestOptions(view));

			}

		});
		
		// delete.addActionListener
		
		add(reservations);
		add(delete);
		add(menu);
	}

}
