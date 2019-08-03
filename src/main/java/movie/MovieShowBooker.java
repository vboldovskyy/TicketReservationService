package movie;

import booking.Booking;
import booking.BookingsHolder;
import booking.IBooking;
import cinema.*;
import user.IUser;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MovieShowBooker {
    private static final double VIP_PREMIUM = 1.5;
    private static final double PREMIUM_PREMIUM = 1.2;
    private static final double STUDENT_DISCOUNT = 0.9;
    private static final double AFTER_PREMIERE_DISCOUNT = 0.85;
    private static final String AFFIRMATIVE_ANSWER = "yes";

    private static Scanner scan = new Scanner(System.in);

    public static IBooking bookTickets(IUser user) {
        if (!user.canBookMore()) {
            System.out.println("Sorry, you have more than 2 unpaid bookings. No more booking allowed");
            return null;
        }
        IMovieShow show = getMovieShow();
        System.out.println("The basic price per seat is " + show.getPrice());
        System.out.println("Premium seats are 20%,  and VIP seats are 50% more expensive");
        System.out.println("Prices are subject to 10% student discount");
        if (show.getMovie().getMovieStatus().equals(MovieStatus.AVAILABLE))
            System.out.println("And this show is subject to 15% after premiere discount");
        System.out.println("Available places: " + show.getFreePlaces());
        int reserve = 0;
        System.out.println("Enter how many tickets you want to book (1-5)");
        while (reserve <= 0 || reserve > Math.min(show.getFreePlaces(), 5)) {
            reserve = getInt();
        }
        List<Seat> seats = new ArrayList<>();
        int totalPrice = 0;
        while (reserve != 0) {
            show.printAvailableSeats();
            System.out.println("Enter the row in which you would like to book a seat(1-9)");
            int row = 0;
            int seat = 0;
            while (row <= 0 || row > MovieShow.ROWS) {
                row = getInt();
            }
            System.out.println("Enter the seat which you would like to book (1-9)");
            while (seat <= 0 || seat > MovieShow.ROWS) {
                seat = getInt();
            }
            if (show.isBooked(row, seat)) {
                System.out.println("This place is booked. Try again");
                continue;
            } else {
                show.setBooked(row, seat);
                Seat seatToBook = new Seat(row, seat);
                seats.add(seatToBook);
                int pricePerSeat = calculatePrice(user, show, seatToBook);
                System.out.println("This will cost " + pricePerSeat);
                totalPrice += pricePerSeat;
            }
            reserve--;
        }
        System.out.println("Total price for your bookings is " + totalPrice);
        System.out.println("Would you like to pay now? Type yes to pay.");
        scan.nextLine();
        boolean isPaid = false;
        if (scan.nextLine().equalsIgnoreCase(AFFIRMATIVE_ANSWER))
            isPaid = true;
        IBooking booking = new Booking(isPaid, show, user, seats, totalPrice);
        user.addBooking(booking);
        BookingsHolder.putBooking(booking);
        return booking;
    }

    private static Integer calculatePrice(IUser user, IMovieShow show, Seat seatToBook) {
        double basePrice = Double.valueOf(show.getPrice());
        if (seatToBook.getPlaceType() == PlaceType.VIP)
            basePrice *= VIP_PREMIUM;
        if (seatToBook.getPlaceType() == PlaceType.PREMIUM)
            basePrice *= PREMIUM_PREMIUM;
        if (show.getMovie().getMovieStatus() == MovieStatus.AVAILABLE)
            basePrice *= AFTER_PREMIERE_DISCOUNT;
        if (user.isStudent())
            basePrice *= STUDENT_DISCOUNT;
        return (int) basePrice;
    }

    private static int getInt() {
        int choice = -1;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Try again");
            scan.nextLine();
        }
        return choice;
    }

    private static IMovieShow getMovieShow() {
        List<ICinema> cinemas = CinemaHolder.getCinemas();
        for (int i = 1; i <= cinemas.size(); i++)
            System.out.println(i + ". " + cinemas.get(i - 1));

        System.out.println("Enter your choice:");
        int choice = 0;
        while (choice <= 0 || choice > cinemas.size()) {
            choice = getInt();
        }
        List<ICinemaHall> halls = cinemas.get(choice - 1).getCinemaHalls();
        for (int i = 1; i <= halls.size(); i++)
            System.out.println(i + ". Hall " + halls.get(i - 1).getNumber());
        System.out.println("Enter your choice:");
        int hall = 0;
        while (hall <= 0 || hall > halls.size()) {
            hall = getInt();
        }
        ICinemaHall cinemaHall = halls.get(hall - 1);
        List<IMovieShow> shows = cinemaHall.getMovieShows();
        for (int i = 1; i <= shows.size(); i++)
            System.out.println(i + ". " + shows.get(i - 1));
        System.out.println("Enter your choice:");
        int movieShow = 0;
        while (movieShow <= 0 || movieShow > shows.size()) {
            movieShow = getInt();
        }
        return shows.get(movieShow - 1);
    }
}
