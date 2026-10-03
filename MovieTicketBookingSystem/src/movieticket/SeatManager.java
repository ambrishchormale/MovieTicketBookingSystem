package movieticket;

public class SeatManager {
    // 2 movies x 5 rows x 5 seats - FIXED BUG
    public boolean[][][] seats = new boolean[2][5][5];

    public void showSeats(int currentMovie, String movieName) {
        System.out.println("\nMovie Name: " + movieName);
        System.out.println("Available Seats: [A]=Available [B]=Booked");
        System.out.println("           1  2  3  4  5 <- Seat Number");
        for (int i = 0; i < 5; i++) {
            char rowLabel = (char)('A' + i);
            System.out.print("Row " + rowLabel + " | ");
            for (int j = 0; j < 5; j++) {
                if (!seats[currentMovie][i][j]) System.out.print("[A] ");
                else System.out.print("[B] ");
            }
            System.out.println();
        }
    }

    public boolean isBooked(int movie, int r, int c) {
        return seats[movie][r][c];
    }

    public void book(int movie, int r, int c) {
        seats[movie][r][c] = true;
    }

    public void cancel(int movie, int r, int c) {
        seats[movie][r][c] = false;
    }
}