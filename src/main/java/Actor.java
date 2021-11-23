import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    private String firstName;
    private String lastName;

    public static String getActorsName(List<Actor> actors) {
        return actors.toString();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;

    }

    public static void printAllMoviesWhereActorPlayed(MovieLibrary movieLibrary,
                                                      String actorsFirstName,
                                                      String actorsLastName) {
        List<String> titlesList = movieLibrary.getMovieList().stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.firstName.equals(actorsFirstName) && actor.lastName.equals(actorsLastName)))
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
