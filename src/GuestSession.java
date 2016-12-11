import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Authors:
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
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
	private ArrayList newRooms = new ArrayList();


	private String startDate;
	private String endDate;
	private int price;

	private ArrayList<Reservation> allRes;
	private ArrayList allRooms = new ArrayList();

	/**
	 * Constructor for GuestSession
	 * @param h Hotel under which Guest Session operates
	 * @param id ID of guest user
	 */
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
	 * as well as hotel
	 * then notifies view.
	 *
	 * @param roomNum index of array of rooms
	 * precondition: room number is valid in array
	 * postcondition: reservation added to room in that array index
	 */
	public void addReservation(int roomNum) {
		Reservation r =  new Reservation(roomNum, id, startDate, endDate);
		hotel.addReservation(r);
		newRes.add(r);
		newRooms.add(r.getRoomIndex());
		allRes.add(r);
		allRooms.add(r.getRoomIndex());
		notifyView();
	}

	public void deleteReservation(int rn, String sd){
		for(int i = 0; i < newRes.size(); i++){
			if(newRes.get(i).getRoomIndex() == rn && newRes.get(i).getStartDate() == sd){
				newRes.remove(i);
				newRooms.remove(i);
			}
		}
		for(int i = 0; i < allRes.size(); i++){
			if(allRes.get(i).getRoomIndex() == rn && allRes.get(i).getStartDate() == sd){
				allRes.remove(i);
				allRooms.remove(i);
			}
		}
	}

	/**
	 * gets AVAILABLE rooms for the startDate and endDate
	 * @return vacant rooms
	 */
	public ArrayList<Room> getRooms() {
		Room[] rooms = hotel.getRooms();

		ArrayList<Room> available = new ArrayList<Room>();

		for (Room r : rooms) {
			if (r.getPrice() == this.price) {
				if (r.isRoomAvailable(startDate, endDate)) {
					available.add(r);
				}
			}
		}
		return available;
	}
	
	/**
	 * sets start and end dates of potential reservation to these dates
	 * @param start starting date
	 * @param end ending date
	 * precondition: start and end are in format MM/DD/YYYY
	 * postcondition: start and end are set to this GuestSession object
	 */
	public void setDates(String start, String end) {
		setStart(start);
		setEnd(end);
		notifyView();
	}

	/**
	 * sets start of potential reservation to this date
	 * @param date starting date
	 * precondition: starting date is correct format MM/DD/YYYY
	 * postcondition: this becomes the new start date of reservation
	 */
	public void setStart(String date) {
		startDate = date;
	}

	/**
	 * sets end of potential reservation to this date
	 * @param date end date
	 * precondition: date is correct format MM/DD/YYYY
	 * postcondition: this becomes the new end date of reservation
	 */
	public void setEnd(String date) {
		endDate = date;
	}

	/**
	 * sets price of potential room to this price
	 * @param p price $200 or $80 depending on room
	 * precondition: price is either 200 or 80
	 * postcondition: this becomes the new price of the room
	 */
	public void setPrice(int p) {price = p;}

	/**
	 * gets start of reservation
	 * @return start of reservation MM/DD/YYYY
	 */
	public String getStart() {return startDate;}

	/**
	 * gets end of reservation
	 * @return end of reservation MM/DD/YYYY
	 */
	public String getEnd() {return endDate;}

	/**
	 * gets ID of user in this session
	 * @return ID of user
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
	 * gets indexes of newly reserved rooms
	 * @return indexes of reserved rooms
	 */
	public ArrayList<Integer> getNewRooms() {return newRooms;}

	/**
	 * retrieves ALL reservations made under the user ID. used in Comprehensive receipt
	 * @return all reservations
	 */
	public ArrayList<Reservation> getAllReservations() {
		return allRes;
	}


	/**
	 * retrieves all rooms reserved by the user.
	 * @return all the rooms that were reserved.
	 */
	public ArrayList<Integer> getAllRooms() {return allRooms;}

	/**
	 * clears newRes arraylist. called right before entering transaction screen.
	 * precondition: arraylist.size > 0
	 * postcondition: arraylist of new reservations is cleared
	 */
	public void eraseNewReservations() {
		newRes.clear();
		newRooms.clear();
	}

	/**
	 * sets off changelistener and updates views.
	 * precondition: arraylist of listeners has at least one element.
	 * postcondition: all listeners are notified
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
