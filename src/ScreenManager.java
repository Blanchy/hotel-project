import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ScreenManager extends JPanel {


	private HotelView view;

	public ScreenManager(HotelView v) {
		this.view = v;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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
				view.getHotel().saveReservations(); //save quits as well
				System.exit(0);
			}
		});


		load.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				System.out.println(null, "Reservations loaded from file.", "Message", 
						JOptionPane.INFORMATION_MESSAGE);
						*/
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
