package hotelreservation;

import java.util.ArrayList;

public class HotelReservation {

    ArrayList<Hotel> hotelList = new ArrayList<>();

    public void addHotel(String hotelName,
                         int regularRate) {

        Hotel hotel =
                new Hotel(hotelName, regularRate);

        hotelList.add(hotel);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation Program");

        HotelReservation reservation =
                new HotelReservation();

        reservation.addHotel("Lakewood",110);
        reservation.addHotel("Bridgewood",150);
        reservation.addHotel("Ridgewood",220);

        System.out.println("Hotels Added Successfully");

        System.out.println(
                reservation.findCheapestHotel());
    }

    public String findCheapestHotel() {

        Hotel cheapestHotel = hotelList.get(0);

        for (Hotel hotel : hotelList) {

            if (hotel.regularRate <
                    cheapestHotel.regularRate) {

                cheapestHotel = hotel;
            }
        }

        return cheapestHotel.hotelName;
    }
}