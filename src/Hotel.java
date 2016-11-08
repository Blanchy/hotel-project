import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by JonWong on 11/5/16. this is a comment
 */
public class Hotel {

    private Room[] rooms;

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
        //ex: addReservation(2, r) should reserve the 2nd room (index 1)
        rooms[roomNumber-1].addReservation(r);
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
