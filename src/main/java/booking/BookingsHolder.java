package booking;

import java.util.HashMap;
import java.util.Map;

public class BookingsHolder {
private static Map<Integer, IBooking> allBookings = new HashMap<>();
public static IBooking getBooking(Integer id){
    return allBookings.get(id);
}
public static void putBooking(IBooking booking){
    allBookings.put(booking.getBookingId(), booking);
}
}
