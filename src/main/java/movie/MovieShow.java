package movie;

import cinema.CinemaHall;

import java.util.Date;

public class MovieShow implements IMovieShow{
    private final IMovie movie;
    private final Date startDate;
    private final Integer price;
    private final boolean[][] bookedPlaces;
    private CinemaHall hall;
    private static final int ROWS = 9;
    private static final int SEATS_PER_ROW = 9;
    private static final int MINUTE_IN_MILLISECONDS = 60000;

    public MovieShow (IMovie movie, Date startDate, Integer price){
        this.movie=movie;
        this.price=price;
        this.startDate=startDate;
        this.bookedPlaces = new boolean[ROWS][SEATS_PER_ROW];
    }

    public void setCinemaHall(CinemaHall cinemaHall){
        hall=cinemaHall;
    }
    public CinemaHall getCinemaHall(){
        return hall;
    }
    public IMovie getMovie(){
        return movie;
    }

    @Override
    public Date getMovieStartDate() {
        return startDate;
    }

    @Override
    public Date getMovieEndDate() {
        return new Date(startDate.getTime()+MINUTE_IN_MILLISECONDS*movie.getDuration());
    }

    @Override
    public Integer getPrice() {
        return null;
    }
}
