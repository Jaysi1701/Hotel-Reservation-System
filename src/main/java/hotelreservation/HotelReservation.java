package hotelreservation;

import java.util.ArrayList;

public class HotelReservation {

    ArrayList<Hotel> hotelList = new ArrayList<>();

    public void addHotel(String hotelName,
                         int weekdayRate,
                         int weekendRate) {

        Hotel hotel =
                new Hotel(hotelName,
                        weekdayRate,
                        weekendRate);

        hotelList.add(hotel);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation Program");

        HotelReservation reservation =
                new HotelReservation();

        reservation.addHotel("Lakewood",110,90);

        reservation.addHotel("Bridgewood",150,50);

        reservation.addHotel("Ridgewood",220,150);

        System.out.println("Hotels Added Successfully");

        System.out.println(
                reservation.findCheapestHotel(1,1));
    }

    public String findCheapestHotel(int weekdays,
                                    int weekends) {

        int minimumCost = Integer.MAX_VALUE;

        String cheapestHotel = "";

        for (Hotel hotel : hotelList) {

            int totalCost =
                    weekdays * hotel.weekdayRate +
                            weekends * hotel.weekendRate;

            if (totalCost < minimumCost) {

                minimumCost = totalCost;

                cheapestHotel = hotel.hotelName;
            }
        }

        return cheapestHotel +
                " Total Rate: $" +
                minimumCost;
    }

}