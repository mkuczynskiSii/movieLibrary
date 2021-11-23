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

    public static void printMoviesCreatedBetweenDates(MovieLibrary movieLibrary, int startDate, int finishDate) {
        List<String> selectedTitles = movieLibrary.getMovieList().stream()
                .filter(movie -> Integer.parseInt(movie.productionDate) >= startDate)
                .filter(movie -> Integer.parseInt(movie.productionDate) <= finishDate)
                .map(Movie::getTitle)
                .collect(Collectors.toList());

        if (selectedTitles.isEmpty()) {
            System.out.println("Biblioteka nie posiada filmów wyprodukowanych w tym okresie");
        } else {
            System.out.println("Filmy z biblioteki wyprodukowane pomiędzy " + startDate + ", a " + finishDate + " rokiem to:");
            selectedTitles.forEach(System.out::println);
        }

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
