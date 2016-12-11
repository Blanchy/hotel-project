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
	
	/**
	 * constructor method
	 * @param h Hotel object to retrieve information from
	 */
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

	/**
	 * gets all rooms of hotel
	 * @return all hotel rooms
	 */
	@Override
	public ArrayList<Room> getRooms() {
		ArrayList<Room> roomList = (ArrayList<Room>) Arrays.asList(hotel.getRooms());
		return roomList;
	}

	@Override
	public void loadReservations() {

	}

	@Override
	public void viewInformation() {

	}

	@Override
	public void saveReservations() {

	}

	@Override
	public void addReservation() {

	}

	@Override
	public String viewReservation() {
		return null;
	}

	@Override
	public void deleteReservation() {

	}

	/**
	 * Sets the current date to the specified date
	 * @param date date to be changed to.
	 */
	public void setCurrentDate(int[] date) {
		currentDate = date;
		notifyViews();
	}

	/**
	 * Sets the current room viewed to the specified room.
	 * @param roomNum desired room to be viewed.
	 */
	public void setCurrentRoom(int roomNum) {
		currentRoom = roomNum;
		notifyViews();
	}
	
	/**
	 * gets current date for view
	 * @return current date as array in {MM,DD,YYYY}
	 */
	public int[] getCurrentDate() { return currentDate; }
	
	/**
	 * gets current room being viewed
	 * @return index of current room being viewed
	 */
	public int getCurrentRoom() { return currentRoom; }
	
	/**
	 * attaches a ChangeListener to this model
	 * precondition: l is a ChangeListener
	 * postcondition: l is added to arrayList of ChangeListeners
	 */
	public void attach(ChangeListener l) {
		listeners.add(l);
	}
	
	/**
	 * notifies ChangeListeners to change views
	 * precondition: arrayList of listeners contains ChangeListeners
	 * postcondition: listeners are notified
	 */
	public void notifyViews() {
		for (ChangeListener l : listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}

}
