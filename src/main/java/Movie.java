import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Movie {
    private String title;
    private Director director;
    private Genre genre;
    private String productionDate;
    private List<Actor> actors;

    public static void printRandomMovieInfo(MovieLibrary movieLibrary) {
        System.out.println(movieLibrary.getMovieList().get(new Random().nextInt(movieLibrary.getMovieList().size())));
    }

    public static void printMoviesCreatedBetweenDates(MovieLibrary movieLibrary, int startDate, int finishDate) {
        movieLibrary.getMovieList().stream()
                .filter(movie -> Integer.parseInt(movie.productionDate) >= startDate)
                .filter(movie -> Integer.parseInt(movie.productionDate) <= finishDate)
                .map(Movie::getTitle)
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "title: " + title + "\n" +
                "director: " + director.getFirstName() + " " + director.getLastName() + "\n" +
                "genre: " + genre.toString() + "\n" +
                "date: " + productionDate + "\n" +
                "actors: " + Actor.getActorsName(actors) + "\n";

    }
}
