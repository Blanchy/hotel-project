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
 * Window where a guest can make a reservation, view/delete reservations,
 * or sign out.
 **/
public class ScreenGuestOptions extends JPanel {

	private HotelView view;

	/**
	 * Constructor for classes of this object.
	 * @param v HotelView object upon which this JPanel is mounted.
	 */
	public ScreenGuestOptions(HotelView v) {
		view = v;
		setPreferredSize(new Dimension(200,300));
		setLayout(new GridLayout(4,1));
		JLabel guestOpt = new JLabel("Guest Options:" , SwingConstants.CENTER);
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

				view.getHotel().saveReservations();
				view.changeScreen(new ScreenInitial(view));

			}

		});

		add(guestOpt);
		add(makeRes);
		add(viewDelete);
		add(signOut);
	}

}
