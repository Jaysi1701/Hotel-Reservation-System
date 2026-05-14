package hotelreservation;

public class Hotel {

    String hotelName;
    int weekdayRate;
    int weekendRate;

    public Hotel(String hotelName,
                 int weekdayRate,
                 int weekendRate) {

        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }
}