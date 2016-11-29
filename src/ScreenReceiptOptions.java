import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ScreenReceiptOptions extends JPanel {

	private HotelView view;
	
	public ScreenReceiptOptions(HotelView v) {
		view  = v;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel option = new JLabel("Choose format of reciept:");
		JButton simple = new JButton("Simple");
		JButton comprehensive = new JButton("Comprehensive");
		
		simple.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenReceipt(view));

			}

		});
		comprehensive.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenReceipt(view));

			}

		});
		
		add(option);
		add(simple);
		add(comprehensive);
	}
}
