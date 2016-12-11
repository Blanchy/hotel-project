import java.io.*;
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
    private String fileName = "load/Reservations";

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

    public void loadReservations()
    {
        try{
            File file = new File("reservations.txt");

            if (file.exists()) {
                ArrayList<String> temp = new ArrayList<String>();
                FileInputStream fin = new FileInputStream(file);

                BufferedReader reader = new BufferedReader(new InputStreamReader(fin));

                String buffer = null;

                while ((buffer = reader.readLine()) != null) {
                    temp.add(buffer);
                }

                for(int y = 0; y < temp.size(); y++){
                    String[] load = temp.get(y).split("#");
                    addReservation(new Reservation(Integer.parseInt(load[1]), load[0], load[2], load[3]));
                }

            } else {
                System.out.println("This is the first time running, so there's nothing to load.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveReservations() {


        try{
            File fileOut = new File("reservations.txt");

            FileOutputStream output = new FileOutputStream(fileOut);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(output));

            for(int i = 0; i < rooms.length; i++){
                //    public Reservation(int arrayIndex, String userID, String startDate, String endDate)
                for(int x = 0; x < rooms[i].getAllReservations().size(); x++){

                    String temp = rooms[i].getAllReservations().get(x).getUserID() + "#" +
                            rooms[i].getAllReservations().get(x).getRoomIndex() + "#" +
                            rooms[i].getAllReservations().get(x).getStartDate() + "#" +
                            rooms[i].getAllReservations().get(x).getEndDate();

                    out.write(temp);
                    out.newLine();

                }
            }

            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        {

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

}
