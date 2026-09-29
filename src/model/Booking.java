package model;

public class Booking implements Payable {

    // Static field - shared by all Booking objects
    private static int bookingCounter = 1000;

    private int bookingId;
    private Customer customer;
    private Ticket ticket;
    private double discount;

    // Parameterized constructor
    public Booking(Customer customer, Ticket ticket) {

        bookingCounter++;

        this.bookingId = bookingCounter;
        this.customer = customer;
        this.ticket = ticket;
        this.discount = 0.0;
    }

    // Getters

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public double getDiscount() {
        return discount;
    }

    // Setter

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Implementation of Payable interface
    @Override
    public double calculateTotal() {

        double ticketAmount = ticket.calculateTotal();

        /*
         * Operator precedence demonstration:
         * multiplication is performed before addition/subtraction.
         */
        double total = ticketAmount
                + ticketAmount * Movie.GST_RATE
                - discount;

        return total;
    }

    // Overriding toString()
    @Override
    public String toString() {

        return "\n========== BOOKING DETAILS ==========\n"
                + "Booking ID : " + bookingId + "\n"
                + "Customer   : " + customer.getName() + "\n"
                + "Movie      : " + ticket.getMovie().getTitle() + "\n"
                + "Tickets    : " + ticket.getNumberOfTickets() + "\n"
                + "Discount   : Rs."
                + String.format("%.2f", discount) + "\n"
                + "Total      : Rs."
                + String.format("%.2f", calculateTotal()) + "\n"
                + "=====================================";
    }
}