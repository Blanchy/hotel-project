import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
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
