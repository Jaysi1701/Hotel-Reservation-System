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
}