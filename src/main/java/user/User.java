package user;

import booking.IBooking;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class User implements IUser{
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String phoneNumber;
    private List<IBooking> bookings;
    private boolean isStudent;
    private static Scanner scanner = new Scanner (System.in);
    private static final Integer DEFAULT_AGE= 18;
    private static final String AFFIRMATIVE_ANSWER = "yes";

    public User(String name, String surname, Integer age, String email, String phoneNumber, boolean isStudent){
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.bookings=new ArrayList<IBooking>();
        this.isStudent=isStudent;
    }

    public User(String email){
        this.email=email;
        System.out.println ("You seem to be a new user. Please enter your name:");
        this.name=scanner.nextLine();
        System.out.println ("Please enter your surname:");
        this.surname=scanner.nextLine();
        System.out.println("Enter your age:");
        try{
            this.age=Math.abs(Math.min(100, scanner.nextInt()));
            scanner.nextLine();
        } catch (InputMismatchException e){
            System.out.println ("Incorrect input, we'll assume you are 18.");
            this.age=DEFAULT_AGE;
            scanner.nextLine();
        }
        System.out.println ("Now enter your phone number:");
        this.phoneNumber=scanner.nextLine();
        System.out.println ("Are you a student? (type \"yes\" if so)");
        this.isStudent=scanner.nextLine().equals(AFFIRMATIVE_ANSWER);
        this.bookings=new ArrayList<IBooking>();
    }

    public String getName () {
        return name;
    }

    public String getSurname () {
        return surname;
    }

    public Integer getAge () {
        return age;
    }

    public String getEmail () {
        return email;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }
    public Boolean isStudent(){
        return isStudent();
    }

    @Override
    public List<IBooking> getBookings () {
        return bookings;
    }
}
