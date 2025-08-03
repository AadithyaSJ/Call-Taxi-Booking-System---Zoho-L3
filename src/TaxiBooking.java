import java.io.IOException;
import java.util.*;

public class TaxiBooking {
    static int customerId = 1;
    static List<Taxi> taxiList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        System.out.println("Enter number of Taxis: ");
        int numTaxi = sc.nextInt();
        initializeTaxi(numTaxi);

        while(true) {
            System.out.println("Choices\n1. Book a taxi\n2.Taxi Details\n3. Exit");
            System.out.print("\n Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    taxiDetail();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, try again");
            }
        }
    }

    public static void initializeTaxi(int numTaxi) {
        for(int i = 0; i < numTaxi; i++) {
            taxiList.add(new Taxi(i + 1));
        }
    }

    public static void bookTaxi() {
        System.out.println("Enter your pickup point: ");
        char pickupPoint = sc.next().toUpperCase().charAt(0);
        System.out.println("Enter your drop point: ");
        char dropPoint = sc.next().toUpperCase().charAt(0);
        System.out.println("Enter pickup time: ");
        int pickupTime = sc.nextInt();
        int minDistance = Integer.MAX_VALUE;
        Taxi selectedTaxi = null;
        for(Taxi t: taxiList) {
            int distance = Math.abs(t.currentPoint - pickupPoint);
            if(t.isAvailable(pickupTime)) {
                if(distance < minDistance || (minDistance == distance && selectedTaxi.totalEarnings > t.totalEarnings)) {
                    selectedTaxi = t;
                    minDistance = distance;
                }
            }
        }
        if(selectedTaxi == null) {
            System.out.println("No taxi available");
            return;
        }
        int Id = customerId++;
        int bookingId = selectedTaxi.bookingsList.size() + 1;
        int dropTime = pickupTime + Math.abs(pickupPoint - dropPoint);
        int amount = selectedTaxi.calculateEarnings(pickupPoint, dropPoint);
        Booking booking = new Booking(bookingId, customerId, pickupTime, dropTime, amount, pickupPoint, dropPoint);
        selectedTaxi.addBooking(booking);
        System.out.println("Taxi Id: " + selectedTaxi.Id + " is Booked successfully");
    }

    public static void taxiDetail() {
        for(Taxi t: taxiList) {
            System.out.println("Taxi Id: " + t.Id + " Total Earnings: " + t.totalEarnings);
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                    "BookingId", "CustomerId", "PickupTime", "DropTime", "Amount", "From", "To");
            for(Booking booking: t.bookingsList) {
                System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                        booking.bookingId, booking.customerId, booking.pickupTime, booking.dropTime, booking.amount, booking.from, booking.to);
            }
        }
    }
}
