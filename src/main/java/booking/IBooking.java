package booking;

import cinema.Seat;
import movie.IMovieShow;

import java.util.Date;
import java.util.List;

public interface IBooking {
    Date getBookedDate();

    boolean isPaid();

    IMovieShow getBookedMovieShow();

    Integer getNumberOfBookings();

    Integer getBookingId();

    List<Seat> getSeats();

    Date getBookedUntil();

    Integer getTotalPrice();

    void printBooking();
}
