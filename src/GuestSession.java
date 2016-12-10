import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author blanchypolangcos
 *
 * Guest session which is created when a user enters their ID. 
 * Retrieves pre-existing reservations upon creation.
 * 
 * Stores reservations, pre-existing or newly created.
 * Stores preferred reservation dates and room type when looking
 * up vacant rooms.
 * 
 * Updates ScreenVacancies.java.
 * Sends data for receipt.
 * Sends data for ScreenReservations.
 */
public class GuestSession implements User {

	private Hotel hotel;
	private String id;
	private ArrayList<ChangeListener> listeners;
	
	private ArrayList<Reservation> newRes;
	private String startDate;
	private String endDate;
	private int price;
	
	private ArrayList<Reservation> allRes;
	
	public GuestSession(Hotel h, String id) {
		hotel = h;
		this.id = id;
		
		newRes = new ArrayList<Reservation>();
		
		allRes = new ArrayList<Reservation>();
		
		Room[] allRooms = hotel.getRooms();
		for (Room r : allRooms) {
			ArrayList<Reservation> allReservations = r.getAllReservations();
			for (Reservation rsv : allReservations) {
				if (rsv.getUserID().equals(this.id)) {
					allRes.add(rsv);
				}
			}
		}
		
		
		startDate = "";
		endDate = "";
		
		listeners = new ArrayList<ChangeListener>();
	}
	
	/**
	 * adds a new reservation to BOTH Reservation ArrayLists
	 * but does not add it to the hotel itself yet.
	 * then notifies view.
	 * 
	 * @param roomNum index of array of rooms
	 */
	public void addReservation(int roomNum) {
		Reservation r =  new Reservation(roomNum, id, startDate, endDate);
		newRes.add(r);
		allRes.add(r);
		notifyView();
	}
	
	/**
	 * gets AVAILABLE rooms for the startDate and endDate
	 * @return vacant rooms
	 */
	public ArrayList<Room> getRooms() {
		Room[] rooms = hotel.getRooms();
		
		ArrayList<Room> available = new ArrayList<Room>();
		for (Room r : rooms) {
			/*
			 * first check if the (r.getPrice() == this.price), then
			 * check if room r is available between startDate and endDate,
			 * and if so then available.add(r)
			 */
		}
		return available;
	}

	/**
	 * 
	 * @param date
	 */
	public void setStart(String date) {
		startDate = date;
		notifyView();
	}
	
	/**
	 * 
	 * @param date
	 */
	public void setEnd(String date) {
		endDate = date;
		notifyView();
	}
	
	/**
	 * 
	 * @param p
	 */
	public void setPrice(int p) {price = p;}
	
	/**
	 * 
	 * @return
	 */
	public String getStart() {return startDate;}
	
	/**
	 * 
	 * @return
	 */
	public String getEnd() {return endDate;}
	
	/**
	 * 
	 */
	public String getID() { return id;}
	
	/**
	 * retrieves the reservations made during a particular transaction. 
	 * used in Simple Receipt.
	 * 
	 * @return arraylist of new reservations
	 */
	public ArrayList<Reservation> getNewReservations() {
		return newRes;
	}
	
	/**
	 * retrieves ALL reservations made under the user ID. used in Comprehensive receipt
	 * @return all reservations
	 */
	public ArrayList<Reservation> getAllReservations() {
		return allRes;
	}
	
	/**
	 * clears newRes arraylist. called right before entering transaction screen.
	 */
	public void eraseNewReservations() {
		newRes.clear();
	}
	
	/**
	 * sets off changelistener and updates views
	 */
	public void notifyView() {
		for (ChangeListener l : listeners) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
	
	/**
	 * attach changelisteners
	 * @param l changelistener to be added
	 */
	public void attach(ChangeListener l) {
		listeners.add(l);
	}
	
}
