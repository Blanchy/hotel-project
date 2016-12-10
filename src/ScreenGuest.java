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

public class ScreenGuest extends JPanel {

	private HotelView view;
	
	public ScreenGuest(HotelView v) {
		view = v;
		setPreferredSize(new Dimension(200,300));
		setLayout(new GridLayout(4,1));
		
		JLabel guest = new JLabel("Guest User Options:", SwingConstants.CENTER);
		JButton signUp = new JButton("Sign Up");
		JButton signIn = new JButton("Sign In");
		JButton goBack = new JButton("Go Back");
		
		signUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.changeScreen(new ScreenUserID(view));
			}
		});
		signIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.changeScreen(new ScreenUserID(view));
			}
		});
		goBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.changeScreen(new ScreenInitial(view));
			}
		});
		
		add(guest);
		add(signUp);
		add(signIn);
		add(goBack);
	}
	
}
