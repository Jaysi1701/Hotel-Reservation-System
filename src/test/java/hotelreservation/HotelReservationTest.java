package hotelreservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {

    @Test
    public void givenRewardCustomer_WhenChecked_ShouldReturnCheapestBestRatedHotel() {

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

        Assertions.assertEquals(
                "Ridgewood",
                hotel.hotelName);
    }

    @Test
    public void givenRegularCustomer_WhenChecked_ShouldReturnCheapestBestRatedHotel() {

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
                        false);

        Assertions.assertEquals(
                "Bridgewood",
                hotel.hotelName);
    }
}