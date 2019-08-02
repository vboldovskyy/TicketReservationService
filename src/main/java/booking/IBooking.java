package booking;

import movie.IMovieShow;

import java.util.Date;

public interface IBooking {
Date getBookedDate();
boolean isPaid();
IMovieShow getBookedMovieShow();
Integer getNumberOfBookings();
Integer getBookingId();
}
