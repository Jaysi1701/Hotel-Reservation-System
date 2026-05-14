package hotelreservation;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HotelReservation {

    ArrayList<Hotel> hotelList = new ArrayList<>();

    public void addHotel(String hotelName,
                         int weekdayRate,
                         int weekendRate,
                         int rating,
                         int rewardWeekdayRate,
                         int rewardWeekendRate) {

        Hotel hotel =
                new Hotel(hotelName,
                        weekdayRate,
                        weekendRate,
                        rating,
                        rewardWeekdayRate,
                        rewardWeekendRate);

        hotelList.add(hotel);
    }

    public static void main(String[] args)
            throws HotelReservationException {

        System.out.println("Welcome to Hotel Reservation Program");

        HotelReservation reservation =
                new HotelReservation();

        reservation.addHotel(
                "Lakewood",
                110,
                90,
                3,
                80,
                80);

        reservation.addHotel(
                "Bridgewood",
                150,
                50,
                4,
                110,
                50);

        reservation.addHotel(
                "Ridgewood",
                220,
                150,
                5,
                100,
                40);

        Hotel hotel =
                reservation.getCheapestBestRatedHotel(
                        1,
                        1,
                        true);

        System.out.println(
                hotel.hotelName +
                        " Rating: " +
                        hotel.rating);
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

    public String bestRatedHotel(int weekdays,
                                 int weekends) {

        Hotel bestHotel = hotelList.get(0);

        for (Hotel hotel : hotelList) {

            if (hotel.rating > bestHotel.rating) {

                bestHotel = hotel;
            }
        }

        int totalCost =
                weekdays * bestHotel.weekdayRate +
                        weekends * bestHotel.weekendRate;

        return bestHotel.hotelName +
                " Total Rates: $" +
                totalCost;
    }

    public String cheapestBestRatedRewardHotel(
            int weekdays,
            int weekends) {

        int minimumCost = Integer.MAX_VALUE;

        Hotel cheapestHotel = null;

        for (Hotel hotel : hotelList) {

            int totalCost =
                    weekdays * hotel.rewardWeekdayRate +
                            weekends * hotel.rewardWeekendRate;

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

    public Hotel getCheapestBestRatedHotel(
            int weekdays,
            int weekends,
            boolean rewardCustomer) {

        return hotelList.stream()

                .min((hotel1, hotel2) -> {

                    int cost1;
                    int cost2;

                    if (rewardCustomer) {

                        cost1 =
                                weekdays * hotel1.rewardWeekdayRate +
                                        weekends * hotel1.rewardWeekendRate;

                        cost2 =
                                weekdays * hotel2.rewardWeekdayRate +
                                        weekends * hotel2.rewardWeekendRate;

                    } else {

                        cost1 =
                                weekdays * hotel1.weekdayRate +
                                        weekends * hotel1.weekendRate;

                        cost2 =
                                weekdays * hotel2.weekdayRate +
                                        weekends * hotel2.weekendRate;
                    }

                    if (cost1 == cost2) {

                        return hotel2.rating -
                                hotel1.rating;
                    }

                    return cost1 - cost2;

                }).orElse(null);
    }

    public LocalDate validateDate(String date)
            throws HotelReservationException {

        try {

            return LocalDate.parse(
                    date,
                    DateTimeFormatter.ofPattern("ddMMMyyyy"));

        } catch (Exception e) {

            throw new HotelReservationException(
                    "Invalid Date");
        }
    }

}