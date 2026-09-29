package service;

import model.Booking;
import model.Customer;
import model.Movie;
import model.Payable;
import model.Ticket;

public class BookingService {

    // Static field
    private static int ticketCounter = 500;

    // Create a booking
    public Booking createBooking(
            Customer customer,
            Movie movie,
            int numberOfTickets) {

        // Validate ticket quantity
        if (numberOfTickets <= 0) {
            return null;
        }

        if (numberOfTickets > Ticket.MAX_TICKETS) {
            return null;
        }

        // Check available seats
        if (numberOfTickets > movie.getAvailableSeats()) {
            return null;
        }

        ticketCounter++;

        Ticket ticket = new Ticket(
                ticketCounter,
                movie,
                numberOfTickets
        );

        Booking booking = new Booking(
                customer,
                ticket
        );

        // Apply 10% discount for 5 or more tickets
        if (numberOfTickets >= 5) {

            double discount =
                    ticket.calculateTotal() * 0.10;

            booking.setDiscount(discount);
        }

        // Reduce available seats
        movie.setAvailableSeats(
                movie.getAvailableSeats() - numberOfTickets
        );

        return booking;
    }

    // Display payment using interface reference
    public void displayPayment(Booking booking) {

        Payable payment = booking;

        System.out.printf(
                "\nFinal Amount: Rs.%.2f%n",
                payment.calculateTotal()
        );
    }
}