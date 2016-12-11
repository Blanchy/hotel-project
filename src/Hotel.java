import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 * Created by JonWong on 11/5/16. this is a comment
 */
public class Hotel {

    private Room[] rooms;

    /**
     * Constructor for Hotel 
     **/
    public Hotel()
    {
        rooms = new Room[20];
        for (int i = 0; i < 20; i++)
        {
            int price = 200; //first 10 are luxury, second 10 are economy
            if (i >= 10) { price = 80; }
            rooms[i] = new Room(i, price);
        }
    }

    public void addReservation(Reservation r)
    {
        //ex: addReservation(2, r) should reserve the 2nd room (index 1)
        rooms[r.getRoomIndex()].addReservation(r);
    }

    public void deleteAllReservations()
    {
        for (int i = 0; i < rooms.length; i++)
        {
            rooms[i].deleteAllReservation();
        }
    }

    public void deleteReservation(int roomIndex, String reservationStartDate)
    {
        //no specification of userID, how to delete?
    	// because a room can only have one reservation on a given date, we dont have to specify
    	// which user made it
    	/*
    	boolean roomFound = false;
    	int i = 0;
    	while (!roomFound) {
    		if (rooms[i] == roomIndex) {
    			
    			rooms[i].deleteReservation(reservationStartDate);
    			roomFound = true;
    		}
    		i++;
    	}
    	*/
    	rooms[roomIndex].deleteReservation(reservationStartDate);
    	/* assuming roomIndex goes 0-19 */
    }

    public void loadReservations()
    {
        //not done
    }


    public void saveReservations()
    {
        try {
            PrintWriter writer = new PrintWriter("reservations.txt");
            for (Room r : rooms) {
                writer.println(r.toString());
            }
        }
        catch (IOException IOE)
        {
            System.out.println("IOException!");
        }
    }

    public String toString()
    {
        String rtn = "HOTEL: \n";
        for (Room r : rooms)
        {
            rtn += r.toString();
        }
        return rtn;
    }

    /**
     * returns all rooms of the hotel
     * @return all rooms of this hotel
     */
    public Room[] getRooms() {
    	return rooms;
    }

    /**
     * returns the specified room
     * @return Room in specified array index
     */
    public Room getRoom(int roomNum) {
    	return rooms[roomNum];
    }
    

}
