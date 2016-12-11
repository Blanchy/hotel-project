import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 **/
public class ScreenInitial extends JPanel {

	private HotelView view;

	public ScreenInitial(HotelView v) {

		view = v;

		setLayout(new GridLayout(3,1));
		setPreferredSize(new Dimension(200,300));
		JLabel userType = new JLabel("User Type:", SwingConstants.CENTER);
		JButton manager = new JButton("Manager");
		JButton guest = new JButton("Guest");

		manager.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.changeScreen(new ScreenManager(view));	
				view.setUserSession(new ManagerSession(view.getHotel()));
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
