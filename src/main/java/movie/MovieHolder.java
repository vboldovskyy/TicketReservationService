package movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieHolder {
    private static Map<String, IMovie> movies = new HashMap<>();
    static{
        movies.put("Snow White", new Movie("The Snow White", MovieType.TRANSLATED, 84,
                MovieStatus.PREMIERE, MovieCategory.CARTOON, 4.1));
        movies.put("Pride and Prejudice", new Movie("Pride and Prejudice", MovieType.TRANSLATED, 117,
                MovieStatus.AVAILABLE, MovieCategory.DRAMA, 3.7));
        movies.put("The avengers",  new Movie("The avengers", MovieType.ORIGINAL, 129,
                MovieStatus.PREMIERE, MovieCategory.FANTASY, 4.9));
        movies.put("Angelina & Brad", new Movie("Angelina & Brad", MovieType.TRANSLATED, 65,
                MovieStatus.PREPREMIERE, MovieCategory.DOCUMENTARY, 3.2));
        movies.put("Idiocracy", new Movie("Idiocracy", MovieType.TRANSLATED, 98,
                MovieStatus.AVAILABLE, MovieCategory.COMEDY, 4.4));
        movies.put("Blade Runner", new Movie("Blade Runner", MovieType.ORIGINAL, 103,
                MovieStatus.AVAILABLE, MovieCategory.THRILLER, 4.7));
        movies.put("Nightmare on Elms street", new Movie("Nightmare on Elms street", MovieType.TRANSLATED, 123,
                MovieStatus.AVAILABLE, MovieCategory.HORROR, 4.8));
    }
    public static void printAll(){
        System.out.println("--------------------------");
        for(IMovie movie: movies.values()){
            System.out.println(movie);
        }
        System.out.println("--------------------------");
    }

    public static void search(){
        Scanner scan = new Scanner(System.in);
        System.out.println("To search by category press 1");
        System.out.println("To search by rating press 2");
        System.out.println("To search by name press 3");
        int choice = 0;
                while (choice<=0 || choice >3){
                    try{choice = scan.nextInt();}
                    catch(InputMismatchException e){
                        System.out.println("Try again.");
                    }
                }
                scan.nextLine();
                switch (choice){
                    case 1:{
                        MovieCategory[] cats = MovieCategory.values();
                        Map<Integer, MovieCategory> map = new HashMap<>();
                        for(int i = 1; i<=cats.length; i++){
                            map.put(i, cats[i-1]);
                            System.out.println(i+". "+cats[i-1]);
                        }
                        System.out.println("Enter category you are interested in:");
                        int catChoice =0;
                        while (catChoice<=0 || catChoice>cats.length) {
                            try {
                                catChoice = scan.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Try again.");
                            }
                        }
                        searchByCategory(cats[catChoice-1]);
                    } break;
                    case 2:{
                        System.out.println("Enter minimal rating from 0 to 5");
                        double rating = -1;
                        while (rating<=0 || rating>5) {
                            try {
                                rating = scan.nextDouble();
                            } catch (InputMismatchException e) {
                                System.out.println("Try again.");
                            }}
                            searchByRating( rating);
                    } break;
                    case 3: {
                        System.out.println("Enter keyword to search");
                        String word = scan.next();
                        searchByName(word);
                    }break;
                }

    }

    public static void searchByCategory(MovieCategory category){
        System.out.println("--------------------------");
        List<IMovie> result=movies.values().stream()
                .filter((IMovie m)-> m.getCategory().equals(category))
                .collect(Collectors.toList());
        for(IMovie movie: result)
            System.out.println(movie);
        System.out.println("--------------------------");
    }
    public static void searchByName(String name){
        System.out.println("--------------------------");
        List<IMovie> result=movies.values().stream()
                .filter((IMovie m)-> m.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        for(IMovie movie: result)
            System.out.println(movie);
        System.out.println("--------------------------");
    }
    public static void searchByRating(Double rating){
        System.out.println("--------------------------");
        List<IMovie> result=movies.values().stream()
                .filter((IMovie m)-> m.getRating()>=rating)
                .collect(Collectors.toList());
        for(IMovie movie: result)
            System.out.println(movie);
        System.out.println("--------------------------");
    }

    public static IMovie getMovie(String name){
        return movies.get(name);
    }
    public static List<IMovie> getMoviesList()
    {
        return new ArrayList<>(movies.values());
    }
}
