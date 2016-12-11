/**
 * @author BlanchyPolangcos
 * @author ChristopherNavy
 * @author JonathanWong
 *
 * The main class which runs the hotel reservation system.
 **/

public class HotelReservationSystem {

	/**
	 * main method to run hotel reservation system
	 * @param args
	 */
	public static void main(String[] args) {
		Hotel model = new Hotel();
		HotelView test = new HotelView(model);
	}

}
