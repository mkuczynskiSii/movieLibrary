import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return "title: " + title + "\n" +
                "director: " + director.getFirstName() + " " + director.getLastName() + "\n" +
                "genre: " + genre.toString() + "\n" +
                "date: " + productionDate + "\n" +
                "actors: " + Actor.getActorsName(actors) + "\n";

    }
}
