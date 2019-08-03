package movie;

import java.util.Date;

public class Movie implements IMovie {
    private final String name;
    private final MovieType type;
    private final Integer duration;
    private final MovieStatus status;
    private final MovieCategory category;
    private final Double rating;

    public Movie(String name, MovieType type, Integer duration, MovieStatus status, MovieCategory category, Double rating) {
        this.name = name;
        this.type = type;
        this.duration = duration;
        this.status = status;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public MovieType getType() {
        return type;
    }

    public MovieStatus getMovieStatus() {
        return status;
    }

    public MovieCategory getCategory() {
        return category;
    }

    @Override
    public Integer getDuration() {
        return duration;
    }

    @Override
    public Double getRating() {
        return rating;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(getName()).append(", Type:").append(getType());
        sb.append(", Duration: ").append(getDuration()).append(" mins. ");
        sb.append("Status: ").append(getMovieStatus()).append(", Category: ").append(getCategory());
        sb.append(" Rating: ").append(getRating());
        return sb.toString();
    }
}
