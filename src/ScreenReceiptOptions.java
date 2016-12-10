import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ScreenReceiptOptions extends JPanel {

	private HotelView view;

	public ScreenReceiptOptions(HotelView v) {
		view  = v;

		setPreferredSize(new Dimension(200,300));
		setLayout(new GridLayout(3,1));

		JLabel option = new JLabel("Choose format of reciept:",SwingConstants.CENTER);
		JButton simple = new JButton("Simple");
		JButton comprehensive = new JButton("Comprehensive");

		simple.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//view.getUserSession().getNewReservations();

				ReceiptContext context = new ReceiptContext(new SimpleReceipt());

			}

		});
		comprehensive.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//view.getUserSession().getReservations();
				ReceiptContext context = new ReceiptContext(new ComprehensiveReceipt());

			}

		});

		add(option);
		add(simple);
		add(comprehensive);
	}
}
