import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ScreenInitial extends JPanel {

	private HotelView view;

	public ScreenInitial(HotelView v) {
		view = v;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel userType = new JLabel("User Type:");
		JButton manager = new JButton("Manager");
		JButton guest = new JButton("Guest");

		manager.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.changeScreen(new ScreenManager(view));				
			}
		});
		guest.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenGuest(view));

			}

		});

		add(userType);
		add(manager);
		add(guest);
	}

}
