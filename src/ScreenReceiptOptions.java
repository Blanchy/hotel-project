import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

/**
 * Allows receipt to be chosen between Simple and Comprehensive.
 *
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 *Allows Guest to choose which reciept format to print.
 **/
public class ScreenReceiptOptions extends JPanel {

	private HotelView view;

    /**
     * Constructor for Receipt Options
     * @param v JFrame Component of the Program
     * @param gs User Session Information.
     */
	public ScreenReceiptOptions(HotelView v, GuestSession gs) {
		view  = v;

		setPreferredSize(new Dimension(200,300));

		setLayout(new GridLayout(4,1));

		setLayout(new GridLayout(0,1));


		JLabel option = new JLabel("Choose format of receipt:",SwingConstants.CENTER);
		JButton simple = new JButton("Simple");
		JButton comprehensive = new JButton("Comprehensive");
		JButton menu = new JButton("Back to Guest menu");


        /**
         * Brings User back to the main menu.
         */
		menu.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                view.changeScreen(new ScreenGuestOptions(view));
                gs.eraseNewReservations();
            }
        });


        /**
         * Creates a new window with a receipt formatted with simple receipt.
         */
		simple.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

                ArrayList guestInfo = new ArrayList();
                guestInfo.add(gs.getID());
                guestInfo.add(gs.getAllReservations());
                guestInfo.add(gs.getNewRooms());

				ReceiptContext context = new ReceiptContext(new SimpleReceipt(guestInfo));

			}

		});

        /**
         * Creates a new window with a receipt formatted with comprehensive receipt.
         */
        comprehensive.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

                ArrayList guestInfo = new ArrayList();
                guestInfo.add(gs.getID());
                guestInfo.add(gs.getAllReservations());
                guestInfo.add(gs.getAllRooms());

				ReceiptContext context = new ReceiptContext(new ComprehensiveReceipt(guestInfo));

			}

		});

		add(option);
		add(simple);
		add(comprehensive);

        add(menu);

	}
}
