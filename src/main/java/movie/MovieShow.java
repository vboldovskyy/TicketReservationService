package movie;

import cinema.CinemaHall;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MovieShow implements IMovieShow {
    private final IMovie movie;
    private final Date startDate;
    private final Integer price;
    private final boolean[][] bookedPlaces;
    private int freePlaces;
    private CinemaHall hall;
    static final int ROWS = 9;
    private static final int SEATS_PER_ROW = 9;
    private static final int MINUTE_IN_MILLISECONDS = 60000;

    public MovieShow(IMovie movie, Date startDate, Integer price) {
        this.movie = movie;
        this.price = price;
        this.startDate = startDate;
        this.bookedPlaces = new boolean[ROWS][SEATS_PER_ROW];
        this.freePlaces = ROWS * SEATS_PER_ROW;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        hall = cinemaHall;
    }

    public CinemaHall getCinemaHall() {
        return hall;
    }

    public IMovie getMovie() {
        return movie;
    }

    @Override
    public Date getMovieStartDate() {
        return startDate;
    }

    @Override
    public Date getMovieEndDate() {
        return new Date(startDate.getTime() + MINUTE_IN_MILLISECONDS * movie.getDuration());
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    public Integer getFreePlaces() {
        return freePlaces;
    }

    public void decreaseFreePlaces(int places) {
        if (places <= freePlaces)
            freePlaces -= places;
        else freePlaces = 0;
    }

    public void printAvailableSeats() {
        for (int row = 1; row <= ROWS; row++) {
            if (row > 8)
                System.out.print("Row" + row + " VIP     ");
            else if (row < 4)
                System.out.print("Row" + row + " REGULAR ");
            else
                System.out.print("Row" + row + " PREMIUM ");
            for (int seat = 1; seat <= SEATS_PER_ROW; seat++) {
                if (!bookedPlaces[row - 1][seat - 1])
                    System.out.print(seat + " ");
                else
                    System.out.print("  ");
            }
            System.out.println();

        }
    }

    @Override
    public Boolean isBooked(int row, int seat) {
        try {
            return bookedPlaces[row - 1][seat - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
    }

    @Override
    public void setBooked(int row, int seat) {
        try {
            bookedPlaces[row - 1][seat - 1] = true;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setFree(int row, int seat) {
        try {
            bookedPlaces[row - 1][seat - 1] = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat(" d MMM yyyy HH:mm");
        StringBuilder sb = new StringBuilder();
        sb.append("Hall ").append(getCinemaHall().getNumber()).append(": ").append(format.format(getMovieStartDate()));
        sb.append(" ").append(getMovie().getName()).append(" ").append(getMovie().getCategory())
                .append(" ").append(getMovie().getDuration()).append(" mins.");
        return sb.toString();
    }
}
