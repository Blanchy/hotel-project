/**
 *
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 * Class just used to test various methods. feel free to ignore this class.
 */
public class numDaysTester {
    public static void main(String[] args)
    {
        Reservation test = new Reservation(1, "userID", "1/06/2015", "1/16/2015");
//        System.out.println("startDate: " + test.getCalOne());
//        System.out.println("endDate: " + test.getCalTwo());
        System.out.println("1/20/2015 available?: " + test.isResAvailable("1/20/2015"));
        System.out.println("1/10/2015 availale?: " + test.isResAvailable("1/10/2015"));
        Room testRoom = new Room(1, 100);
        testRoom.addReservation(test);
        System.out.println(testRoom.toString());
        System.out.print("is room available on 1/20/2016? ");
        System.out.println(testRoom.isRoomAvailable("1/20/2015"));
        System.out.print("is room available between 1/10/2015 and 1/30/2015? ");
        System.out.println(testRoom.isRoomAvailable("1/10/2015", "1/30/2015"));
        //System.out.println("days in between : " + test.getNumberOfDays(test.getStartDate(), test.getEndDate()));

    }
}
