import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieLibrary {
    private final List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public static void printMoviesCreatedBetweenDates(MovieLibrary movieLibrary, int startDate, int finishDate) {
        List<String> selectedTitles = movieLibrary.getMovieList().stream()
                .filter(movie -> Integer.parseInt(movie.getProductionDate()) >= startDate)
                .filter(movie -> Integer.parseInt(movie.getProductionDate()) <= finishDate)
                .map(Movie::getTitle)
                .collect(Collectors.toList());

        if (selectedTitles.isEmpty()) {
            System.out.println("Biblioteka nie posiada filmów wyprodukowanych w tym okresie");
        } else {
            System.out.println("Filmy z biblioteki wyprodukowane pomiędzy " + startDate + ", a " + finishDate + " rokiem to:");
            selectedTitles.forEach(System.out::println);
        }

    }

    public static void printAllMoviesWhereActorPlayed(MovieLibrary movieLibrary,
                                                      String actorsFirstName,
                                                      String actorsLastName) {
        List<String> titlesList = movieLibrary.getMovieList().stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.getFirstName().equals(actorsFirstName) && actor.getLastName().equals(actorsLastName)))
                .map(Movie::getTitle)
                .collect(Collectors.toList());

        if (titlesList.isEmpty()) {
            System.out.println("W bibliotece nie ma filmów w których wystąpił ten aktor");
        } else {
            System.out.println("Filmy w których wystąpił " + actorsFirstName + " " + actorsLastName + " to:");
            titlesList.forEach(System.out::println);
        }
    }
}
