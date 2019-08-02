package user;

import booking.Booking;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser{
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String phoneNumber;
    private List<Booking> bookings;

    public User(String name, String surname, Integer age, String email, String phoneNumber){
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.bookings=new ArrayList<Booking>();
    }

    public String getName () {
        return null;
    }

    public String getSurname () {
        return null;
    }

    public Integer getAge () {
        return null;
    }

    public String getEmail () {
        return null;
    }

    public String getPhoneNumber () {
        return null;
    }
}
