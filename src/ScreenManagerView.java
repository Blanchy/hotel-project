import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class ScreenManagerView extends JPanel {

	private HotelView view;
	private JPanel body;
	private JPanel buttons;
	private ManagerSession ms;
	private Dimension textAreaSize;
	
	boolean viewMode; /* false if on room view, true if on month view */
	
	public ScreenManagerView(HotelView v) {
		view = v;
		ms = (ManagerSession) view.getUserSession();
		viewMode = false;
		textAreaSize = new Dimension(300, 400);
		
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
				viewMode = true;
				drawMonthView(ms.getCurrentDate());
			}
		});
		
		toRoom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewMode = false;
				drawRoomView(ms.getCurrentRoom());
			}
		});
		
		ChangeListener l = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (viewMode) {
					drawMonthView(ms.getCurrentDate());
				}
				else {
					drawRoomView(ms.getCurrentRoom());
				}
				repaint();
			}
		}
		ms.attach(l);
		
		drawRoomView(ms.getCurrentRoom());
		
		add(body);
		buttons.add(toRoom);
		buttons.add(toMonth);
		buttons.add(back);
		add(buttons);
		
	}
	
	public void drawMonthView(int[] date) {
		body.removeAll();
		body.repaint();
		JPanel left = drawMonth(date);
		JPanel right = drawMonthInfo(date);
		body.add(left);
		body.add(right);
		body.repaint();
	
		invalidate();
		validate();
		repaint();
	}
	
	public void drawRoomView(int room) {
		body.removeAll();
		body.repaint();
		JPanel left = drawMonth(room);
		JPanel right = drawMonthInfo(room);
		body.add(left);
		body.add(right);
		
		body.repaint();
	}
	
	/**
	 * shows a clickable calendar, with the selected date highlighted.
	 * calendar can also be advanced by month and by year
	 * @return Jpanel containing clickable calendar
	 */
	public JPanel drawMonth(int[] date) {
		JPanel calendar = new JPanel();
		/* add stuff to calendar */
		return calendar;
	}
	
	/**
	 * for the selected day of the month, this window shows the reserved rooms
	 * as well as vacant rooms
	 * @param date array, assuming array is in form of {DD, MM, YYYY}
	 * @return
	 */
	public JPanel drawMonthInfo(int[] date) {
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		JTextArea monthInfo = new JTextArea();
		monthInfo.setPreferredSize(textAreaSize);
		
		String monthInfoText = "Rooms on " + date[0] + "/" + date[1] + "/" + date[2] + "\n";
		String vacantText = "Vacant on this day: \n";
		String reservedText = "Reserved on this day: \n";
		
		Room[] allRooms = view.getHotel().getRooms();
		
		for (Room r : allRooms) {
			if (r.isAvailable(date[0] + "/" + date[1] + "/" + date[2])) {
				vacantText = vacantText + r.getRoomNumber() + "\n";
			}
			else {
				reservedText = reservedText + r.getRoomNumber() + "\n";
			}
		}
		
		monthInfo.setText(monthInfoText
				+ vacantText
				+ reservedText);
		
		jp.add(monthInfo);
		
		return jp;
	}
	
	/**
	 * this shows ALL rooms in the hotel. this is also clickable.
	 * @return
	 */
	public JPanel drawRoom(int room) {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(5,4));
		
		for (i = 1; i <= 20; i++) {
			JLabel room = new JLabel(i + "");
			if ((i-1) == ms.getCurrentRoom()) {
				room.setFont(new Font(null, Font.BOLD, 12));
			}
			room.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					ms.setCurrentRoom(Integer.parseInt(room.getText() - 1);
				}

				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}

			});
		}
		
		return jp;
	}
	
	/**
	 * for the selected room in drawRoom, this window shows the
	 * room number, price, and (if applicable) the reservation info for each reservation (user ID, start and end dates)
	 * @return
	 */
	public JPanel drawRoomInfo(int room) {
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		JTextArea roomInfo = new JTextArea();
		roomInfo.setPreferredSize(textAreaSize);
		
		Room r = view.getHotel().getRoom(room);
		ArrayList<Reservation> reservations = r.getAllReservations();
		
		String roomNumber = "Room number: " + (r.getRoomNumber + 1);
		String price = "Price: " + r.getPrice();
		
		String reservationsString = "Reservations: \n";
		if (reservations.size() < 1) {
			reservationsString = reservationsString + "None\n";
		}
		else {
			for (Reservation rsvn : reservations) {
				reservationsString = reservationsString + 
						"User " + rsvn.getUserID() + 
						" from " + rsvn.getStartDate() + 
						" - " + rsvn.getEndDate() + "\n";
			}
		}
 			
		roomInfo.setText(
				roomNumber + "\n"
				+ price + "\n"
				+ reservationsString
				);
		
		jp.add(roomInfo);
		
		return jp;
	}

}
