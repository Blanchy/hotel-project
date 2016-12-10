import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ScreenGuestOptions extends JPanel {

	private HotelView view;
	
	public ScreenGuestOptions(HotelView v) {
		view = v;
		setPreferredSize(new Dimension(200,300));
		setLayout(new GridLayout(3,1));
		JButton makeRes = new JButton("Make a Reservation");
		JButton viewDelete = new JButton("View/Delete Reservations");
		JButton signOut = new JButton("Sign out of Guest User");
		
		makeRes.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenMakeRes(view, false));

			}

		});
		viewDelete.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenReservations(view));
			}

		});
		signOut.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenInitial(view));

			}

		});
		
		add(makeRes);
		add(viewDelete);
		add(signOut);
	}

}
