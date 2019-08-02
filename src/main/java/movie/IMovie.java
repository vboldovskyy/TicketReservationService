package movie;

import java.util.Date;

public interface IMovie {
    String getName();
    MovieType getType();
    Date getMovieDurationFrom();
    Date getMovieDurationTo();
    MovieStatus getMovieStatus();
    MovieCategory getCategory();
    Integer getPrice();

}
