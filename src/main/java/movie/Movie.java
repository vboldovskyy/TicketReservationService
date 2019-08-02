package movie;

import java.util.Date;

public class Movie implements IMovie {
    private String name;
    private MovieType type;
    private Date startTime;
    private Date endTime;
    private MovieStatus status;
    private MovieCategory category;
    private Integer price;

    public Movie( String name, MovieType type, Date start, Date end, MovieStatus status, MovieCategory category, Integer price){
        this.name=name;
        this.type=type;
        this.startTime=start;
        this.endTime=end;
        this.status=status;
        this.category=category;
        this.price=price;
    }

    public String getName () {
        return name;
    }

    public MovieType getType () {
        return type;
    }

    public Date getMovieDurationFrom () {
        return startTime;
    }

    public Date getMovieDurationTo () {
        return endTime;
    }

    public MovieStatus getMovieStatus () {
        return status;
    }

    public MovieCategory getCategory () {
        return category;
    }

    public Integer getPrice () {
        return price;
    }
}
