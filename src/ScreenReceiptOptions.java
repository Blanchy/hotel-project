import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class ScreenReceiptOptions extends JPanel {

	private HotelView view;

	public ScreenReceiptOptions(HotelView v, GuestSession gs) {
		view  = v;

		setPreferredSize(new Dimension(200,300));
		setLayout(new GridLayout(0,1));

		JLabel option = new JLabel("Choose format of reciept:",SwingConstants.CENTER);
		JButton simple = new JButton("Simple");
		JButton comprehensive = new JButton("Comprehensive");
		JButton menu = new JButton("Back to Guest menu");


		menu.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                view.changeScreen(new ScreenGuestOptions(view));
            }
        });

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
