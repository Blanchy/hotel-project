import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 

public class ScreenReceipt extends JPanel {

	private HotelView view;

	public ScreenReceipt(HotelView v) {
		view = v;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JTextArea receipt = new JTextArea("Formatted reciept printed here");
		JButton menu = new JButton("Return to Guest Menu");

		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				view.changeScreen(new ScreenGuestOptions(view));

			}

		});

		add(receipt);
		add(menu);
	}

}
