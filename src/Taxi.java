import java.util.*;

public class Taxi {
    int Id;
    int totalEarnings;
    char currentPoint = 'A';
        List<Booking> bookingsList = new ArrayList<>();


    public Taxi(int id) {
        this.Id = id;
    }

    public boolean isAvailable(int requestedTime) {
        if(bookingsList.isEmpty()) return true;
        return bookingsList.get(bookingsList.size() - 1).dropTime <= requestedTime;
    }

    public int calculateEarnings(char pickup, char drop) {
        int distance = Math.abs(pickup - drop) * 15;
        return 100 + (10 * Math.max(distance - 5, 0));
    }

    public void addBooking(Booking booking) {
        bookingsList.add(booking);
        totalEarnings += booking.amount;
        currentPoint = booking.to;
    }
}
