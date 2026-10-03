package movieticket;

public class Movie {
    public String[] movies = {"Dhurandhar", "Paradise"};
    public int currentMovie = 0;

    public String getCurrentMovieName() {
        return movies[currentMovie];
    }
}