package model;

public class Ticket implements Payable {

    private int ticketId;
    private Movie movie;
    private int numberOfTickets;

    // Final constant
    public static final int MAX_TICKETS = 10;

    // Parameterized constructor
    public Ticket(int ticketId, Movie movie, int numberOfTickets) {
        this.ticketId = ticketId;
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
    }

    // Getters

    public int getTicketId() {
        return ticketId;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    // Implementation of interface method
    @Override
    public double calculateTotal() {
        return movie.calculatePrice(numberOfTickets);
    }

    // Final method: ticket validation rules should not be changed by subclasses.
    public final boolean isValidTicketCount() {
        return numberOfTickets > 0
                && numberOfTickets <= MAX_TICKETS;
    }

    // Overriding toString()
    @Override
    public String toString() {
        return "Ticket ID: " + ticketId
                + ", Movie: " + movie.getTitle()
                + ", Tickets: " + numberOfTickets;
    }
}