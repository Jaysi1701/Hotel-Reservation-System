package hotelreservation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HotelReservationTest {

    @Test
    public void givenHotelDetails_WhenAdded_ShouldReturnTrue() {

        HotelReservation reservation =
                new HotelReservation();

        reservation.addHotel("Lakewood",110);

        Assertions.assertEquals(1,
                reservation.hotelList.size());
    }

    @Test
    public void givenHotelRates_WhenChecked_ShouldReturnCheapestHotel() {

        HotelReservation reservation =
                new HotelReservation();

        reservation.addHotel("Lakewood",110);
        reservation.addHotel("Bridgewood",150);
        reservation.addHotel("Ridgewood",220);

        String cheapestHotel =
                reservation.findCheapestHotel();

        Assertions.assertEquals(
                "Lakewood",
                cheapestHotel);
    }
}