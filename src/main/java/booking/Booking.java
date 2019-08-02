package booking;

import cinema.Seat;
import movie.IMovieShow;
import user.User;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class Booking implements IBooking {
    private boolean isPaid;
    private final IMovieShow bookedMovieShow;
    private final Integer numberOfSeats;
    private final Integer bookingId;
    private final User bookedBy;
    private final Date bookedUntil;
    private final Integer price;
    private final List<Seat> seats;

    public Booking(boolean isPaid, IMovieShow movieShow, User bookedBy, List<Seat> seats, Integer price) {
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
}
