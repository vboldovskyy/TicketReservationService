package booking;

import movie.IMovie;

import java.util.Date;

public interface IBooking {
Date getBookedDate();
boolean isPaid();
IMovie getBookedMovie();
Integer getNumberOfBookings();
Integer getBookingId();
}
