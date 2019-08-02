package movie;

import cinema.CinemaHall;

import java.util.Date;

public interface IMovieShow {
    Date getMovieStartDate();
    Date getMovieEndDate();
    CinemaHall getCinemaHall();
    void setCinemaHall(CinemaHall hall);
    Integer getPrice();
}
