import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ScreenManager extends JPanel {

	private HotelView view;
	
	public ScreenManager(HotelView view) {
		this.view = view;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel manageOption = new JLabel("Manager Options:", SwingConstants.CENTER);
		JButton load = new JButton("Load"); // add pop-up confirming successful load
		JButton v = new JButton("View");
		JButton save = new JButton("Save"); // add pop-up confirming successful save
		JButton quit = new JButton("Quit");
		
		v.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.changeScreen(new ScreenManagerView(view));			
			}
		});
		
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		
		//ADD LISTENER FOR LOAD
		
		// ADD LISTENER FOR SAVE
		
		add(manageOption);
		add(load);
		add(v);
		add(save);
		add(quit);
	}

}
