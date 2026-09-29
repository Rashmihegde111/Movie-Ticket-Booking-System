package model;

public class Movie {

    // Private fields demonstrate encapsulation
    private int movieId;
    private String title;
    private MovieType type;
    private double ticketPrice;
    private int availableSeats;

    // Static field
    private static int movieCount = 0;

    // Final constant
    public static final double GST_RATE = 0.18;

    // Default constructor
    public Movie() {
        this(0, "Unknown Movie", MovieType.DRAMA, 0.0, 0);
    }

    // Parameterized constructor
    public Movie(int movieId, String title, MovieType type,
                 double ticketPrice, int availableSeats) {

        this.movieId = movieId;
        this.title = title;
        this.type = type;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;

        movieCount++;
    }

    // Getters and setters

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieType getType() {
        return type;
    }

    public void setType(MovieType type) {
        this.type = type;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // Static method
    public static int getMovieCount() {
        return movieCount;
    }

    // Method overloading - version 1
    public double calculatePrice() {
        return ticketPrice;
    }

    // Method overloading - version 2
    public double calculatePrice(int numberOfTickets) {
        return ticketPrice * numberOfTickets;
    }

    // Display movie information
    public void displayMovie() {

        System.out.printf(
                "%-5d %-25s %-12s Rs.%-10.2f %-10d%n",
                movieId,
                title,
                type,
                ticketPrice,
                availableSeats
        );
    }

    // Overriding toString()
    @Override
    public String toString() {

        return "Movie ID: " + movieId
                + ", Title: " + title
                + ", Type: " + type
                + ", Price: Rs." + ticketPrice;
    }
}