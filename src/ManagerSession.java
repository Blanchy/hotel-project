import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * 
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 * model for the ScreenManagerView.java class
 */
public class ManagerSession implements User {

	private Hotel hotel;
	private ArrayList<ChangeListener> listeners;
	
	private int currentRoom;
	
	private GregorianCalendar cal;
	private int[] currentDate;
	
	public ManagerSession(Hotel h) {
		hotel = h;
		listeners = new ArrayList<ChangeListener>();
		currentRoom = 0;
		currentDate = new int[3];
		cal = new GregorianCalendar();
		currentDate[0] = cal.get(Calendar.MONTH);
		currentDate[1] = cal.get(Calendar.DATE);
		currentDate[2] = cal.get(Calendar.YEAR);
	}

	@Override
	public ArrayList<Room> getRooms() {
		ArrayList<Room> roomList = (ArrayList<Room>) Arrays.asList(hotel.getRooms());
		return roomList;
	}
	
	/**
	 * sets the current date being viewed.
	 * @param date an int[] of the date in the format {MM, DD, YYYY}
	 */
	public void setCurrentDate(int[] date) {
		currentDate = date;
		notifyViews();
	}
	
	public void setCurrentRoom(int roomNum) {
		currentRoom = roomNum;
		notifyViews();
	}
	
	public int[] getCurrentDate() { return currentDate; }
	
	public int getCurrentRoom() { return currentRoom; }
	
	public void attach(ChangeListener l) {
		listeners.add(l);
	}
	
	public void notifyViews() {
		for (ChangeListener l : listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}

}
