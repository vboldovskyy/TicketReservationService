package cinema;

import movie.IMovie;

import java.util.ArrayList;
import java.util.List;

public class CinemaHall implements ICinemaHall {

    private Cinema cinema;
    private Integer number;
    private Integer numberOfPlaces;
    private PlaceType placeType;
    private List<IMovie> moviesRunning;
    private List<Integer> freeSeatsLeft;

    public CinemaHall(Cinema cinema, Integer number, Integer numberOfPlaces, PlaceType placeType, List<IMovie> movies){
        this.cinema=cinema;
        this.number=number;
        this.numberOfPlaces=numberOfPlaces;
        this.placeType=placeType;
        this.moviesRunning=movies;
        freeSeatsLeft=new ArrayList<Integer> (moviesRunning.size());
        for (IMovie movie:moviesRunning){
            freeSeatsLeft.add(numberOfPlaces);
        }
    }


    public ICinema getCinema () {
        return cinema;
    }

    public Integer getNumber () {
        return number;
    }

    public Integer getNumberOfPlaces () {
        return numberOfPlaces;
    }

    public PlaceType getPlaceType () {
        return placeType;
    }
}
