import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.event.ChangeEvent;

/**
 * 
 * @author blanchypolangcos
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
		currentRoom = 0;
		currentDate[] = new int[3];
		cal = new GregorianCalendar();
	}

	@Override
	public ArrayList<Room> getRooms() {
		ArrayList<Room> roomList = Arrays.asList(hotel.getRooms());
		return roomList;
	}
	
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
