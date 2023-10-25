package MovieLibrary.Models;

import MovieLibrary.Models.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieLibrary {
    private List<Movie> movies = new ArrayList<>();

    public MovieLibrary() {
    }
    public List<Movie> getMovies() {
        return movies;
    }
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
