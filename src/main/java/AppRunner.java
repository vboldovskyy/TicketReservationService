import booking.BookingsHolder;
import booking.IBooking;
import cinema.CinemaHolder;
import movie.MovieHolder;
import movie.MovieShowBooker;
import user.IUser;
import user.User;
import user.UserHolder;

import java.util.Scanner;

class AppRunner {

    private static final int ALL_CINEMAS = 1;
    private static final int MORE_INFORMATION = 2;
    private static final int ALL_MOVIES = 3;
    private static final int MOVIES_SEARCH = 4;
    private static final int BUY_TICKETS = 5;
    private static final int SEE_ALL_INFO = 6;
    private static final int EXIT = 7;
    private static IUser user;
    private static Scanner scanner = new Scanner(System.in);

    static void run() {

        new BookingCanceller().start();

        System.out.println("Hello. Enter your choice:");

        while (true) {
            System.out.println("Enter 1 to see the list of cinemas ");
            System.out.println("Enter 2 to a list of movies in a cinema");
            System.out.println("Enter 3 to see a list of all movies ");
            System.out.println("Enter 4 to search for a movie");
            System.out.println("Enter 5 to book or buy a ticket");
            System.out.println("Enter 6 to view your bookings");
            System.out.println("Enter 7 to exit");
            int input = scanner.nextInt();
            switch (input) {

                case ALL_CINEMAS:
                    CinemaHolder.printCinemas();
                    break;

                case MORE_INFORMATION:
                    CinemaHolder.printMovieShows();
                    break;

                case ALL_MOVIES:
                    MovieHolder.printAll();
                    break;

                case MOVIES_SEARCH:
                    MovieHolder.search();
                    break;

                case BUY_TICKETS:
                    if (user == null) {
                        user = getUser();
                    }
                    MovieShowBooker.bookTickets(user);
                    break;

                case SEE_ALL_INFO:
                    if (user == null) {
                        user = getUser();
                    }
                    user.printAllBookings();
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    System.exit(0);
            }
        }
    }

    private static IUser getUser() {
        System.out.println("Please enter your email:");
        scanner.nextLine(); //getting rid of trailing \n
        String userEmail = scanner.nextLine();
        user = UserHolder.getUser(userEmail);
        if (user == null)
            user = new User(userEmail);
        UserHolder.addUser(user);
        return user;
    }
}

