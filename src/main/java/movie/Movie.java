package movie;

import java.util.Date;

public class Movie implements IMovie {
    private final String name;
    private final MovieType type;
    private final Integer duration;
    private final MovieStatus status;
    private final MovieCategory category;

    public Movie( String name, MovieType type, Integer duration, MovieStatus status, MovieCategory category){
        this.name=name;
        this.type=type;
        this.duration=duration;
        this.status=status;
        this.category=category;
    }

    public String getName () {
        return name;
    }

    public MovieType getType () {
        return type;
    }

    public MovieStatus getMovieStatus () {
        return status;
    }

    public MovieCategory getCategory () {
        return category;
    }

    @Override
    public Integer getDuration() {
        return duration;
    }
}
