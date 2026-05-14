package hotelreservation;

import java.util.ArrayList;

public class HotelReservation {

    ArrayList<Hotel> hotelList = new ArrayList<>();

    public void addHotel(String hotelName,
                         int weekdayRate,
                         int weekendRate,
                         int rating) {

        Hotel hotel =
                new Hotel(hotelName,
                        weekdayRate,
                        weekendRate,
                        rating);

        hotelList.add(hotel);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Hotel Reservation Program");

        HotelReservation reservation =
                new HotelReservation();

        reservation.addHotel("Lakewood",
                110,
                90,
                3);

        reservation.addHotel("Bridgewood",
                150,
                50,
                4);

        reservation.addHotel("Ridgewood",
                220,
                150,
                5);

        System.out.println("Hotels Added Successfully");

        System.out.println(
                reservation.cheapestBestRatedHotel(1,1));
    }

    public String cheapestBestRatedHotel(int weekdays,
                                         int weekends) {

        int minimumCost = Integer.MAX_VALUE;

        Hotel cheapestHotel = null;

        for (Hotel hotel : hotelList) {

            int totalCost =
                    weekdays * hotel.weekdayRate +
                            weekends * hotel.weekendRate;

            if (totalCost < minimumCost) {

                minimumCost = totalCost;

                cheapestHotel = hotel;

            } else if (totalCost == minimumCost &&
                    hotel.rating > cheapestHotel.rating) {

                cheapestHotel = hotel;
            }
        }

        return cheapestHotel.hotelName +
                " Rating: " +
                cheapestHotel.rating +
                " Total Rates: $" +
                minimumCost;
    }

}