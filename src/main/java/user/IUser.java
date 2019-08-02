package user;

import booking.IBooking;

import java.util.List;

public interface IUser {
    String getName();
    String getSurname();
    Integer getAge();
    String getEmail();
    String getPhoneNumber();
    Boolean isStudent();
    List<IBooking> getBookings();
}
