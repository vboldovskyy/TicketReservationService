package cinema;

import movie.IMovie;

import java.util.List;

public class Cinema implements ICinema {
    private String name;
    private String address;
    private Double rating;
    private List<IMovie> listOfMovies;

    public Cinema(String name, String address, Double rating, List<IMovie> listOfMovies){
        this.name=name;
        this.address=address;
        this.rating=rating;
        this.listOfMovies=listOfMovies;
    }

    public String getName () {
        return null;
    }

    public String getAddress () {
        return null;
    }

    public Double getRating () {
        return null;
    }

    public List<IMovie> getListOfMovies () {
        return null;
    }
}
