import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
        movieLibrary.getMovieList().stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.firstName.equals(actorsFirstName) && actor.lastName.equals(actorsLastName)))
                .map(Movie::getTitle)
                .forEach(System.out::println);
    }
}
