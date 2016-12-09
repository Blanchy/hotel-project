import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ScreenManagerView extends JPanel {

	private HotelView view;
	private JPanel body;
	private JPanel buttons;
	
	public ScreenManagerView(HotelView v) {
		view = v;
		
		body = new JPanel();
		buttons = new JPanel();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		body.setLayout(new GridLayout(1,2));
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		
		JButton back = new JButton("Go Back");
		JButton toMonth = new JButton("See By Month");
		JButton toRoom = new JButton("See All Rooms");
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.changeScreen(new ScreenManager(view));
			}
		});
		
		toMonth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawMonthView();
			}
		});
		
		toRoom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				drawRoomView();
			}
		});
		
		drawRoomView();
		
		add(body);
		buttons.add(toRoom);
		buttons.add(toMonth);
		buttons.add(back);
		add(buttons);
		
	}
	
	public void drawMonthView() {
		body.removeAll();
		body.repaint();
		JPanel left = drawMonth();
		JPanel right = drawMonthInfo();
		body.add(left);
		body.add(right);
		body.repaint();
	
		invalidate();
		validate();
		repaint();
	}
	
	public void drawRoomView() {
		body.removeAll();
		body.repaint();
		JPanel left = drawMonth();
		JPanel right = drawMonthInfo();
		body.add(left);
		body.add(right);
		
		body.repaint();
	}
	
	/**
	 * shows a clickable calendar, with the selected date highlighted.
	 * calendar can also be advanced by month and by year
	 * @return Jpanel containing clickable calendar
	 */
	public JPanel drawMonth() {
		JPanel calendar = new JPanel();
		/* add stuff to calendar */
		return calendar;
	}
	
	/**
	 * for the selected day of the month, this window shows the reserved rooms
	 * as well as vacant rooms
	 * @return
	 */
	public JPanel drawMonthInfo() {
		
		return null;
	}
	
	/**
	 * this shows ALL rooms in the hotel. this is also clickable.
	 * @return
	 */
	public JPanel drawRoom() {
		JPanel jp = new JPanel();
		jp.add(new JTextArea("tester"));
		return jp;
	}
	
	/**
	 * for the selected room in drawRoom, this window shows the
	 * room number, price, and (if applicable) the reservation info for each reservation (user ID, start and end dates)
	 * @return
	 */
	public JPanel drawRoomInfo() {
		JPanel jp = new JPanel();
		jp.add(new JTextArea("tester"));
		return jp;
	}

}
