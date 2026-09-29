package main;

import java.util.Scanner;

import model.Admin;
import model.Booking;
import model.Customer;
import model.Movie;
import model.Person;
import service.BookingService;
import service.MovieService;

public class MovieTicketApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MovieService movieService = new MovieService();
        BookingService bookingService = new BookingService();

        System.out.println("==============================================");
        System.out.println("       MOVIE TICKET BOOKING SYSTEM");
        System.out.println("==============================================");

        // Get customer details
       // Get and validate customer details

String name;

while (true) {
    System.out.print("Enter your name: ");
    name = scanner.nextLine().trim();

    if (!name.isEmpty() && name.matches("[a-zA-Z ]+")) {
        break;
    }

    System.out.println(
            "Invalid name. Please enter letters only."
    );
}

String phone;

while (true) {
    System.out.print("Enter your phone number: ");
    phone = scanner.nextLine().trim();

    if (phone.matches("\\d{10}")) {
        break;
    }

    System.out.println(
            "Invalid mobile number. Please enter exactly 10 digits."
    );
}

String email;

while (true) {
    System.out.print("Enter your email: ");
    email = scanner.nextLine().trim();

    if (email.contains("@")
            && email.contains(".")
            && !email.startsWith("@")
            && !email.endsWith(".")) {
        break;
    }

    System.out.println(
            "Invalid email. Please enter a valid email address."
    );
}

        // String method demonstration
        if (name.contains(" ")) {
            System.out.println("Welcome, " + name + "!");
        } else {
            System.out.println("Welcome, " + name + "!");
        }

        Customer customer = new Customer(
                name,
                phone,
                email
        );

        // Dynamic binding demonstration
        Person person = customer;
        person.displayRole();

        // Another subclass object
        Admin admin = new Admin(
                "System Admin",
                "9999999999",
                "ADM001"
        );

        Person adminReference = admin;

        System.out.println("\nSystem Administrator:");
        adminReference.displayRole();

        boolean running = true;

        while (running) {

            System.out.println("\n=============== MAIN MENU ===============");
            System.out.println("1. View Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. Customer Details");
            System.out.println("4. Exit");
            System.out.println("==========================================");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(
                        scanner.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                continue;
            }

            switch (choice) {

                case 1:

                    movieService.displayMovies();

                    break;

                case 2:

                    movieService.displayMovies();

                    System.out.print(
                            "\nEnter Movie ID: "
                    );

                    int movieId;

                    try {
                        movieId = Integer.parseInt(
                                scanner.nextLine().trim()
                        );

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid Movie ID."
                        );

                        break;
                    }

                    Movie selectedMovie =
                            movieService.findMovie(movieId);

                    if (selectedMovie == null) {

                        System.out.println(
                                "Movie not found."
                        );

                        break;
                    }

                    System.out.print(
                            "Enter number of tickets: "
                    );

                    int numberOfTickets;

                    try {

                        numberOfTickets =
                                Integer.parseInt(
                                        scanner.nextLine().trim()
                                );

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid number of tickets."
                        );

                        break;
                    }

                    Booking booking =
                            bookingService.createBooking(
                                    customer,
                                    selectedMovie,
                                    numberOfTickets
                            );

                    if (booking == null) {

                        System.out.println(
                                "Booking failed."
                        );

                        System.out.println(
                                "Please check the ticket quantity "
                                + "or available seats."
                        );

                        break;
                    }

                    System.out.println(booking);

                    bookingService.displayPayment(
                            booking
                    );

                    // Type conversion / casting
                    int roundedAmount =
                            (int) booking.calculateTotal();

                    System.out.println(
                            "Rounded amount: Rs."
                                    + roundedAmount
                    );

                    break;

                case 3:

                    System.out.println(
                            "\n========== CUSTOMER DETAILS =========="
                    );

                    customer.displayPersonDetails();

                    System.out.println(
                            "Email : " + customer.getEmail()
                    );

                    // String method demonstration
                    if (customer.getEmail()
                            .toLowerCase()
                            .contains("@")) {

                        System.out.println(
                                "Email format appears valid."
                        );

                    } else {

                        System.out.println(
                                "Email format may be invalid."
                        );
                    }

                    break;

                case 4:

                    running = false;

                    System.out.println(
                            "\nThank you for using "
                            + "Movie Ticket Booking System!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please select 1-4."
                    );
            }
        }

        scanner.close();
    }
}