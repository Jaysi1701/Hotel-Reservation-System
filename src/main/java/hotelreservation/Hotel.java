package hotelreservation;

public class Hotel {

    String hotelName;
    int weekdayRate;
    int weekendRate;
    int rating;

    int rewardWeekdayRate;
    int rewardWeekendRate;

    public Hotel(String hotelName,
                 int weekdayRate,
                 int weekendRate,
                 int rating,
                 int rewardWeekdayRate,
                 int rewardWeekendRate) {

        this.hotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating;

        this.rewardWeekdayRate = rewardWeekdayRate;
        this.rewardWeekendRate = rewardWeekendRate;
    }
}