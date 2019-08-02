package movie;

import java.util.Date;

public interface IMovie {
    String getName();
    MovieType getType();
    MovieStatus getMovieStatus();
    MovieCategory getCategory();
    Integer getDuration();


}
