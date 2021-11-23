import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DeserializerJSON {
    public static MovieLibrary getMovieLibraryFromJSON() throws IOException {
        return new ObjectMapper().readValue(new File("src/main/resources/movies.json"), new TypeReference<>() {});
    }
}
