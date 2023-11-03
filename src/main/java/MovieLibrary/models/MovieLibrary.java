package MovieLibrary.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class MovieLibrary {
    private List<Movie> movies = new ArrayList<>();

    public MovieLibrary() {
    }

}
