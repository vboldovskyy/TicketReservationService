package cinema;

import movie.IMovie;

import java.util.List;

public class Cinema implements ICinema {
    private String name;
    private String address;
    private Double rating;
    private List<ICinemaHall> cinemaHalls;
    private List<IMovie> listOfMovies;

    Cinema(String name, String address, Double rating, List<ICinemaHall> cinemaHalls) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.cinemaHalls = cinemaHalls;
        for (ICinemaHall hall : cinemaHalls) {
            hall.setCinema(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public List<IMovie> getListOfMovies() {

        return null;
    }

    public String toString() {
        return name + " at " + address + ". Rating " + rating;

    }

    public List<ICinemaHall> getCinemaHalls() {
        return cinemaHalls;
    }

}
