// Some clases modeling travel packages...
public interface Bookable { void book(); }
public class Hotel  { public void book() { ... } }
public class Flight { public void book() { ... } }
public class Car    { public void book() { ... } }


public class HotelBooker {
	public ArrayList<Hotel> getHotelNamesFor(Date from, Date to) {
		//returns hotels available in the particular date range
	}
}

public class FlightBooker {
	public ArrayList<Flight> getFlightsFor(Date from, Date to) {
		//returns flights available in the particular date range
	}
}

public class CarBooker {
	public ArrayList<Car> getCarsFor(Date from, Date to) {
		//returns flights available in the particular date range
	}
}

public class PackageBooker {
	
	private HotelBooker  hotelBooker;
	private FlightBooker flightBooker;
	private CarBooker    carBooker;

	public List<Bookable> getFlightsAndHotels(Date from, Data to)  {
		ArrayList<Flight> flights = flightBooker.getFlightsFor(from, to);
		ArrayList<Hotel> hotels = hotelBooker.getHotelsFor(from, to);
		ArrayList<Car> cars = carBooker.getCarsFor(from, to);
		//process and return
	}
}
