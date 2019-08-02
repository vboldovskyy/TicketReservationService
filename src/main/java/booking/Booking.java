package booking;

import movie.IMovie;
import user.User;

import java.util.Date;

public class Booking implements IBooking {
    private Date bookedDate;
    private boolean isPaid;
    private IMovie bookedMovie;
    private Integer numberOfSeats;
    private Integer bookingId;
    private User bookedBy;

    public Booking(Date date, boolean isPaid, IMovie movie, Integer numberOfSeats, User bookedBy ){
        this.bookedDate=date;
        this.isPaid=isPaid;
        this.bookedMovie=movie;
        this.numberOfSeats=numberOfSeats;
        this.bookedBy=bookedBy;
    }

    public Date getBookedDate () {
        return null;
    }

    public boolean isPaid () {
        return false;
    }

    public IMovie getBookedMovie () {
        return null;
    }

    public Integer getNumberOfBookings () {
        return null;
    }

    public Integer getBookingId () {
        return null;
    }
}
