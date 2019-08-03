import booking.BookingsHolder;
import booking.IBooking;
import cinema.Seat;
import movie.IMovieShow;

import java.util.Date;

public class BookingCanceller extends Thread {
    private static final long ONE_MINUTE = 60000;

    public void run() {
        while (true) {
            Date now = new Date();
            for (IBooking booking : BookingsHolder.getAllBookings()) {
                if (!booking.isPaid() && now.after(booking.getBookedUntil())) {
                    IMovieShow show = booking.getBookedMovieShow();
                    for (Seat seat : booking.getSeats()) {
                        show.setFree(seat.getRow(), seat.getPlace());
                    }
                }
            }
            try {
                Thread.sleep(ONE_MINUTE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
