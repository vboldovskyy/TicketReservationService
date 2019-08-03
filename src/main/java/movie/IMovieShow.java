package movie;

import cinema.CinemaHall;

import java.util.Date;

public interface IMovieShow {
    Date getMovieStartDate();

    Date getMovieEndDate();

    CinemaHall getCinemaHall();

    void setCinemaHall(CinemaHall hall);

    Integer getPrice();

    IMovie getMovie();

    Integer getFreePlaces();

    void decreaseFreePlaces(int places);

    void printAvailableSeats();

    Boolean isBooked(int row, int seat);

    void setBooked(int row, int seat);

    void setFree(int row, int seat);
}
