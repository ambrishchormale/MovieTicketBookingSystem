package movieticket;
import java.util.Scanner;

public class BookingService {
    private Scanner sc;
    private SeatManager seatManager;
    private Movie movie;
    final int BASE_PRICE = 150;

    public BookingService(Scanner sc, SeatManager seatManager, Movie movie) {
        this.sc = sc;
        this.seatManager = seatManager;
        this.movie = movie;
    }

    public void bookTicket() {
        System.out.print("Enter Row (A-E): ");
        char rowChar = sc.next().toUpperCase().charAt(0);
        int r = rowChar - 'A';
        System.out.print("Enter Seat Number (1-5): ");
        int c = sc.nextInt() - 1;

        if (r < 0 || r >= 5 || c < 0 || c >= 5) {
            System.out.println("Invalid seat!");
            return;
        }
        if (seatManager.isBooked(movie.currentMovie, r, c)) {
            System.out.println("Already Booked! Row " + rowChar + " Seat " + (c+1) + " is booked");
            return;
        }

        double price = BASE_PRICE;
        System.out.print("Is it Weekend? (yes/no): ");
        String weekend = sc.next();
        if (weekend.equalsIgnoreCase("yes")) {
            price += 50;
            System.out.println("Weekend Pricing Applied +50");
        }

        System.out.print("Enter Coupon Code (MOVIE50 / NO): ");
        String coupon = sc.next();
        if (coupon.equalsIgnoreCase("MOVIE50")) {
            price -= 50;
            System.out.println("Coupon Applied! -50 Rs");
        }

        System.out.print("Rate Movie (1-5): ");
        double rating = sc.nextDouble();
        System.out.println("Thanks for rating " + rating + "/5");

        seatManager.book(movie.currentMovie, r, c);
        System.out.println("Ticket booked successfully!");
        System.out.println("Movie: " + movie.getCurrentMovieName());
        System.out.println("Ticket Price = Rs. " + price);
    }

    public void cancelTicket() {
        System.out.print("Enter row (A-E): ");
        char rowChar = sc.next().toUpperCase().charAt(0);
        int r = rowChar - 'A';
        System.out.print("Enter seat number (1-5): ");
        int c = sc.nextInt() - 1;

        if (r < 0 || r >= 5 || c < 0 || c >= 5) {
            System.out.println("Invalid seat!");
            return;
        }
        if (!seatManager.isBooked(movie.currentMovie, r, c)) {
            System.out.println("Seat already empty!");
        } else {
            seatManager.cancel(movie.currentMovie, r, c);
            System.out.println("Ticket cancelled successfully.");
        }
    }
}
