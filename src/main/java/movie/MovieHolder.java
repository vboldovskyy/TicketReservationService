package movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieHolder {
    private static Map<String, IMovie> movies = new HashMap<>();
    static{
        movies.put("Snow White", new Movie("The Snow White", MovieType.TRANSLATED, 84,
                MovieStatus.PREMIERE, MovieCategory.CARTOON));
        movies.put("Pride and Prejudice", new Movie("Pride and Prejudice", MovieType.TRANSLATED, 117,
                MovieStatus.AVAILABLE, MovieCategory.DRAMA));
        movies.put("The avengers",  new Movie("The avengers", MovieType.ORIGINAL, 129,
                MovieStatus.PREMIERE, MovieCategory.FANTASY));
        movies.put("Angelina & Brad", new Movie("Angelina & Brad", MovieType.TRANSLATED, 65,
                MovieStatus.PREPREMIERE, MovieCategory.DOCUMENTARY));
        movies.put("Idiocracy", new Movie("Idiocracy", MovieType.TRANSLATED, 98,
                MovieStatus.AVAILABLE, MovieCategory.COMEDY));
        movies.put("Blade Runner", new Movie("Blade Runner", MovieType.ORIGINAL, 103,
                MovieStatus.AVAILABLE, MovieCategory.THRILLER));
        movies.put("Nightmare on Elms street", new Movie("Nightmare on Elms street", MovieType.TRANSLATED, 123,
                MovieStatus.AVAILABLE, MovieCategory.HORROR));
    }
    public static IMovie getMovie(String name){
        return movies.get(name);
    }
    public static List<IMovie> getMoviesList()
    {
        return new ArrayList<>(movies.values());
    }
}
