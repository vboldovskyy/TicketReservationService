import cinema.CinemaHolder;
import movie.MovieHolder;
import user.IUser;
import user.User;
import user.UserHolder;

import java.util.Scanner;

public class AppRunner {

    private static final int ALL_CINEMAS = 1;
    private static final int MORE_INFORMATION = 2;
    private static final int ALL_MOVIES = 3;
    private static final int MOVIES_BY_NAME = 4;
    private static final int MOVIES_SEARCH = 5;
    private static final int BUY_TICKETS = 6;
    private static final int SEE_ALL_INFO = 7;
    private static final int EXIT = 8;
    private static IUser user;
    private static Scanner scanner = new Scanner(System.in);

    public static void run() {

        System.out.println("Hello. Enter your choice:");

        while (true) {
            System.out.println("Enter 1 to see the list of cinemas ");
            System.out.println("Enter 2 to a list of movies in a cinema");
            System.out.println("Enter 3 to see a list of all movies ");
            System.out.println("Enter 4 for additional information about a movie");
            System.out.println("Enter 5 to search for a movie");
            System.out.println("Enter 6 to book or buy a ticket");
            System.out.println("Enter 7 to view your bookings");
            System.out.println("Enter 8 to exit");
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

                case MOVIES_BY_NAME:

                    break;

                case MOVIES_SEARCH:
                    MovieHolder.search();
                    break;

                case BUY_TICKETS:
                    System.out.println ("Please enter your email:");
                    scanner.nextLine(); //getting rid of trailing \n
                    String userEmail = scanner.nextLine();
                    user= UserHolder.getUser(userEmail);
                    if (user==null)
                        user=new User(userEmail);
                    break;
                case SEE_ALL_INFO:

                    break;
                case EXIT:
                    System.out.println ("Goodbye!");
                    System.exit(0);

            }

        }
    }
}
