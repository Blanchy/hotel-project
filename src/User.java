import java.util.ArrayList;


public interface User {
	public ArrayList<Room> getRooms();
/**
 * Created by JonWong on 11/7/16.
 */
    public void loadReservations();
    public void viewInformation();
    public void saveReservations();
    public void addReservation();
    public String viewReservation();
    public void deleteReservation();
}
