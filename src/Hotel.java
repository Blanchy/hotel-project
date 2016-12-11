import java.io.*;

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
     /** Constructor for Hotel
     *
     * Creates a new hotel, using a 1D array as the data structure.
     * indexes 0-9 are luxury ($200), 10-19 are economy ($80).
     */
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

    /**
     * Adds a reservation to respective room.
     * Gets room index information from the reservation. For more information, look at Reservation.java.
     * @param r reservation to add
     */
    public void addReservation(Reservation r)
    {
        rooms[r.getRoomIndex()].addReservation(r);
    }

    /**
     * Clears all reservations from the hotel.
     */
    public void deleteAllReservations()
    {
        for (int i = 0; i < rooms.length; i++)
        {
            rooms[i].deleteAllReservation();
        }
    }

    /**
     * Deletes a reservation from a room, based on the start date of the reservation.
     * @param roomIndex room to delete resevation from.
     * @param reservationStartDate start date of reservation to be deleted.
     */
    public void deleteReservation(int roomIndex, String reservationStartDate)
    {
    	rooms[roomIndex].deleteReservation(reservationStartDate);
        System.out.println(rooms);
    	/* assuming roomIndex goes 0-19 */
    }

    /**
     * Loads reservation data from a text file.
     */
    public void loadReservations()
    {

    }


    /**
     * Saves all reservation data to a text file, "reservations.txt"
     */
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

    /**
     * Returns a string representation of the hotel.
     *
     * @return
     */
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



    /*
    public static void main(String[] args)
    {
        int rows = 4;
        int columns = 5;
        int [][] hotel = new int[rows][columns];

        System.out.println("Signifies rooms. 1-10 are luxury, 11-20 are economy");
        int count = 1;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                hotel[i][j] = count;
                System.out.print("[" + hotel[i][j] + "] ");
                count++;
            }
            System.out.println();
        }
    }
    */


}
