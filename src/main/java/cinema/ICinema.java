package cinema;

import movie.IMovie;
import java.util.List;

public interface ICinema {
    String getName();
    String getAddress();
    Double getRating();
    List<IMovie> getListOfMovies();
    List<ICinemaHall> getCinemaHalls();

}
