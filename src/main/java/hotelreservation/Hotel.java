package hotelreservation;

public class Hotel {

    String hotelName;
    int weekdayRate;
    int weekendRate;
    int rating;

    public Hotel(String hotelName,
                 int weekdayRate,
                 int weekendRate,
                 int rating) {

        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating;
    }
}