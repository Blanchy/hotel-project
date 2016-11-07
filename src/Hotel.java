import java.util.ArrayList;

/**
 * Created by JonWong on 11/5/16.
 */
public class Hotel {

    private Room[] rooms;
    ArrayList<Reservation> allReservations;

    public Hotel()
    {
        rooms = new Room[20];
        for (int i = 0; i < 20; i++)
        {
            int price = 200; //first 10 are luxury, second 10 are economy
            if (i >= 10) { price = 100; }
            rooms[i] = new Room(i, price);
        }
    }

    public void addReservation(int roomNumber, Reservation r)
    {
        allReservations.add(r);
        rooms[roomNumber-1].addReservation(r); //ex: addReservation(2, r) should reserve the 2nd room (index 1)
    }

    public void deleteAllReservations()
    {
        allReservations.clear();
    }

    public void deleteReservation(int roomIndex, String reservationStartDate)
    {

    }

    public void loadReservations()
    {

    }

    //save to a file
    public void saveReservations()
    {

    }


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
}
