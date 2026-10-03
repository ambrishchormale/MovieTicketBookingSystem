package movieticket;
import java.util.Scanner;

public class MovieTicket {
    static Scanner sc = new Scanner(System.in);
    static Movie movie = new Movie();
    static SeatManager seatManager = new SeatManager();
    static BookingService bookingService = new BookingService(sc, seatManager, movie);

    public static void selectMovie() {
        System.out.println("\nSelect Movie:");
        System.out.println("1. " + movie.movies[0]);
        System.out.println("2. " + movie.movies[1]);
        System.out.print("Enter choice (1-2): ");
        int choice = sc.nextInt();
        if(choice == 1 || choice == 2) {
            movie.currentMovie = choice - 1;
            System.out.println("Selected: " + movie.getCurrentMovieName());
        }
    }

    public static void main(String[] args) {
        selectMovie();

        while (true) {
            System.out.println("\n===== MOVIE TICKET BOOKING =====");
            System.out.println("1. Show Available Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Change Movie");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: seatManager.showSeats(movie.currentMovie, movie.getCurrentMovieName()); break;
                case 2: bookingService.bookTicket(); break;
                case 3: bookingService.cancelTicket(); break;
                case 4: selectMovie(); break;
                case 5: System.out.println("Thank you!"); return;
                default: System.out.println("Invalid choice");
            }
        }
    }
}