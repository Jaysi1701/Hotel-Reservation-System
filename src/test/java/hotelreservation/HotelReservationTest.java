package hotelreservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {

    @Test
    public void givenDateRange_WhenChecked_ShouldReturnCheapestBestRatedHotel() {

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

        String cheapestHotel =
                reservation.cheapestBestRatedHotel(1,1);

        Assertions.assertEquals(
                "Bridgewood Rating: 4 Total Rates: $200",
                cheapestHotel);
    }

    @Test
    public void givenDateRange_WhenChecked_ShouldReturnBestRatedHotel() {

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

        String bestHotel =
                reservation.bestRatedHotel(1,1);

        Assertions.assertEquals(
                "Ridgewood Total Rates: $370",
                bestHotel);
    }
}