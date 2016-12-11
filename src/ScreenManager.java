import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 * 
 * Window for a manager user to Load reservations from a file, view reservations, save reservations
 * to file, or quit the system.
 **/
public class ScreenManager extends JPanel {


	private HotelView view;

	/**
	 * Constructor for classes of this object.
	 * @param v HotelView object upon which this JPanel is mounted.
	 */
	public ScreenManager(HotelView v) {
		this.view = v;
		setLayout(new GridLayout(0,1));

		JLabel manageOption = new JLabel("Manager Options:", SwingConstants.CENTER);
		JButton load = new JButton("Load"); // add pop-up confirming successful load
		JButton vw = new JButton("View");
		JButton save = new JButton("Save"); // add pop-up confirming successful save
		JButton quit = new JButton("Quit");
		JButton menu = new JButton("Sign out manager");
		
		vw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.changeScreen(new ScreenManagerView(view));			
			}
		});
		
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				view.getHotel().saveReservations(); //quit saves as well
				System.exit(0);
			}
		});


		load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Reservations loaded from file.", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				view.getHotel().loadReservations();
			}
		});

		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Reservations saved to file.", "Message", 
						JOptionPane.INFORMATION_MESSAGE);
				view.getHotel().saveReservations();
			}
		});
		
		menu.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				view.changeScreen(new ScreenInitial(view));
			}
		});

		add(manageOption);
		add(load);
		add(vw);
		add(save);
		add(menu);
		add(quit);
	}

}
