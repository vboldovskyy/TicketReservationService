package cinema;

import movie.IMovieShow;

import java.util.List;

public interface ICinemaHall {
    Integer getNumber();

    Integer getNumberOfPlaces();

    List<IMovieShow> getMovieShows();

    ICinema getCinema();

    void setCinema(ICinema cinema);
}
