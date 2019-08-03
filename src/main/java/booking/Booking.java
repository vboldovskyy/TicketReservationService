package booking;

import cinema.Seat;
import movie.IMovieShow;
import user.IUser;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class Booking implements IBooking {
    private boolean isPaid;
    private final IMovieShow bookedMovieShow;
    private final Integer numberOfSeats;
    private final Integer bookingId;
    private final IUser bookedBy;
    private final Date bookedUntil;
    private final Integer price;
    private final List<Seat> seats;

    public Booking(boolean isPaid, IMovieShow movieShow, IUser bookedBy, List<Seat> seats, Integer price) {
        this.bookingId = Math.abs(new Random().nextInt());
        this.isPaid = isPaid;
        this.bookedMovieShow = movieShow;
        this.numberOfSeats = seats.size();
        this.seats = seats;
        this.price = price;
        this.bookedBy = bookedBy;
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
        this.bookedUntil = calendar.getTime();
    }

    public Date getBookedDate() {
        return bookedMovieShow.getMovieStartDate();
    }

    public void setPaid() {
        this.isPaid = true;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public IMovieShow getBookedMovieShow() {
        return bookedMovieShow;
    }

    public Integer getNumberOfBookings() {
        return numberOfSeats;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    @Override
    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public Date getBookedUntil() {
        return bookedUntil;
    }

    @Override
    public Integer getTotalPrice() {
        return price;
    }

    public void printBooking() {
        System.out.println("---------------------");
        System.out.println("BOOKED TO: " + bookedBy.getName() + " " + bookedBy.getSurname() + " " + bookedBy.getEmail());
        System.out.println("TOTAL PRICE: " + getTotalPrice());
        System.out.println("PAID: " + (isPaid() ? "YES" : "NO"));
        System.out.println("CINEMA: " + getBookedMovieShow().getCinemaHall().getCinema());
        System.out.println("HALL: " + getBookedMovieShow().getCinemaHall());
        System.out.println("MOVIE: " + getBookedMovieShow().getMovie());
        System.out.println("START TIME: " + getBookedMovieShow().getMovieStartDate());
        System.out.println("SEATS: ");
        for (Seat seat : getSeats())
            System.out.println(seat);
        System.out.println("---------------------");
    }
}
