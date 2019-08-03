package booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingsHolder {
    private static Map<Integer, IBooking> allBookings = new HashMap<>();

    public static IBooking getBooking(Integer id) {
        return allBookings.get(id);
    }

    public static void putBooking(IBooking booking) {
        allBookings.put(booking.getBookingId(), booking);
    }

    public static List<IBooking> getAllBookings() {
        return new ArrayList<>(allBookings.values());
    }
}
