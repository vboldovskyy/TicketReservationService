package cinema;

import movie.IMovie;
import movie.IMovieShow;
import movie.MovieHolder;
import movie.MovieShow;

import java.text.SimpleDateFormat;
import java.util.*;

public class CinemaHolder {
    private static List<Cinema> cinemas = new ArrayList<>();
    private static final int PLACES_IN_A_HALL = 81;
    static{

        cinemas.add(new Cinema("Blockbuster", "Peremohy avenue 20", 4.5, generateHalls(3)));
        cinemas.add(new Cinema("CinemaCity", "Shevchenka boulevard 35", 4.7, generateHalls(2)));
        cinemas.add(new Cinema("Kyivska Rus", "Sichovyh Striltsiv 92", 3.9, generateHalls(2)));
    }

    public static List<Cinema> getCinemas(){
        return cinemas;
    }
    public static void printCinemas()
    {
        for (Cinema cinema:cinemas)
            System.out.println(cinema);
    }

    public static void printMovieShows()
    {
      for (int i = 1; i<=cinemas.size(); i++){
        System.out.println(i + ". " +cinemas.get(i-1));}

        Scanner scan = new Scanner(System.in);
          System.out.println("Enter cinema number you are interested in:");
          int choice = 0;
          while(choice<=0 || choice >cinemas.size()){
              try{choice = scan.nextInt();}
              catch(InputMismatchException e){
                  System.out.println("Try again");
              }
          }
          ICinema cinema = cinemas.get(choice-1);
        SimpleDateFormat format = new SimpleDateFormat(" d MMM yyyy HH:mm");
          for(ICinemaHall hall: cinema.getCinemaHalls()){
              for(IMovieShow show : hall.getMovieShows()){
                  StringBuilder sb = new StringBuilder();
                  sb.append("Hall ").append(hall.getNumber()).append(": ").append(format.format(show.getMovieStartDate()));
                  sb.append(" "+show.getMovie().getName()).append(" "+show.getMovie().getCategory())
                          .append(" ").append(show.getMovie().getDuration()).append(" mins.");
                  System.out.println(sb);
              }
              System.out.println("-----------------------");
          }
    }


    private static List<ICinemaHall> generateHalls(int number){
        List<ICinemaHall> halls = new ArrayList<>();
        for(int i = 1; i<=number; i++) {
            CinemaHall toAdd = new CinemaHall(i, PLACES_IN_A_HALL, generateRandomSchedule(5));
            for(IMovieShow show: toAdd.getMovieShows()){
                show.setCinemaHall(toAdd);
            }
            halls.add(toAdd);
        }
        return halls;
    }

    private static List<IMovieShow> generateRandomSchedule( int numberOfDays){
        List<Date> showDates = new ArrayList<>();
        Calendar calendar =new GregorianCalendar();
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        for (int days = 1; days<=numberOfDays; days++){
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
