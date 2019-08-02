import java.util.Scanner;

public class AppRunner {

    private static final int ALL_CINEMAS = 1;
    private static final int MORE_INFORMATION = 2;
    private static final int ALL_MOVIES = 3;
    private static final int MOVIES_BY_NAME = 4;
    private static final int MOVIES_BY_FACTORS = 5;
    private static final int BUY_TICKETS = 6;
    private static final int SEE_ALL_INFORMATION = 7;
    private static final int EXIT = 8;

    public static void run() {

        System.out.println("Hello. Enter your choice:");
        System.out.println("Enter 1 to see the list of cinemas ");
        System.out.println("Enter 2 to a list of movies in a cinema");
        System.out.println("Enter 3 to see a list of all movies ");
        System.out.println("Enter 4 for additional information about a movie");
        System.out.println("Enter 5 to search for a movie");
        System.out.println("Enter 6 to book or buy a ticket");
        System.out.println("Enter 7 to view your bookings");
        System.out.println("Enter 8 to exit");

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        while (input != EXIT) {
            switch (input) {

                case ALL_CINEMAS:

                    break;

                case MORE_INFORMATION:

                    break;

                case ALL_MOVIES:

                    break;

                case MOVIES_BY_NAME:

                    break;

                case MOVIES_BY_FACTORS:

                    break;

                case BUY_TICKETS:

                    break;
                case SEE_ALL_INFORMATION:

                    break;
            }
            input = scan.nextInt();
        }
    }
}
