package cinema;

import movie.IMovie;
import movie.IMovieShow;
import movie.MovieHolder;
import movie.MovieShow;

import java.util.*;

public class CinemaHolder {
    private static List<Cinema> cinemas = new ArrayList<>();
    static{

        cinemas.add(new Cinema("Blockbuster", "Peremohy avenue 20", 4.5, generateHalls(3)));
        cinemas.add(new Cinema("CinemaCity", "Shevchenka boulevard 35", 4.7, generateHalls(2)));
        cinemas.add(new Cinema("Kyivska Rus", "Sichovyh Striltsiv 92", 3.9, generateHalls(2)));
    }

    public List<Cinema> getCinemas(){
        return cinemas;
    }

    private static List<ICinemaHall> generateHalls(int number){
        List<ICinemaHall> halls = new ArrayList<>();
        for(int i = 1; i<=number; i++) {
            CinemaHall toAdd = new CinemaHall(1, 81, generateRandomSchedule());
            for(IMovieShow show: toAdd.getMovieShows()){
                show.setCinemaHall(toAdd);
            }
            halls.add(toAdd);
        }
        return halls;
    }

    private static List<IMovieShow> generateRandomSchedule(){
        List<Date> showDates = new ArrayList<>();
        Calendar calendar =new GregorianCalendar();
        for (int days = 1; days<=7; days++){
            calendar.roll(Calendar.DAY_OF_MONTH, 1);
            for (int hours=12; hours<24; hours+=3){
                calendar.set(Calendar.HOUR_OF_DAY, hours);
                showDates.add(calendar.getTime());
            }
        };
        List<IMovie> movies = MovieHolder.getMoviesList();
        Random r = new Random();
        List<IMovieShow> result = new ArrayList<>();
        for (Date showDate:showDates){
            result.add(new MovieShow(movies.get(r.nextInt(movies.size())), showDate, 50+r.nextInt(21)*5));
        }
        return result;
    }
}
