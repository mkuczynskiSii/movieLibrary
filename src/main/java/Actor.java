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
}
