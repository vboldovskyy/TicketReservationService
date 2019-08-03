package cinema;

import movie.IMovieShow;

import java.util.List;

public class CinemaHall implements ICinemaHall {

    private Integer number;
    private Integer numberOfPlaces;
    private List<IMovieShow> moviesRunning;
    private ICinema cinema;

    @Override
    public String toString() {
        return "Hall " + number;
    }

    CinemaHall(Integer number, Integer numberOfPlaces, List<IMovieShow> movieShows) {
        this.number = number;
        this.numberOfPlaces = numberOfPlaces;
        this.moviesRunning = movieShows;

    }

    public List<IMovieShow> getMovieShows() {
        return moviesRunning;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public ICinema getCinema() {
        return cinema;
    }

    public void setCinema(ICinema cinema) {
        this.cinema = cinema;
    }
}
