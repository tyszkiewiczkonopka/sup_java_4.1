package MovieLibrary.services;

import MovieLibrary.models.Movie;
import MovieLibrary.models.MovieLibrary;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MovieService {
    private static final String MOVIES_DATA_PATH = "src/main/resources/movies.json";
    private final MovieLibrary movieLibrary;
    private final ScannerService scannerService;
    private final Random random;

    public MovieService() throws IOException {
        scannerService = new ScannerService();
        ObjectMapper mapper = new ObjectMapper();
        movieLibrary = mapper.readValue(new File(MOVIES_DATA_PATH), MovieLibrary.class);
        random = new Random();
    }

    public void printMovieBetweenDates() {
        int startYear = scannerService.readStartYear();
        int endYear = scannerService.readEndYear();

        boolean movieNotFound = movieLibrary.getMovies().stream()
                .filter(movie -> movie.getDate() >= startYear && movie.getDate() <= endYear)
                .peek(movie -> System.out.println("Movie released in the range: " + movie.getTitle().toUpperCase()))
                .findAny()
                .isEmpty();

        if (movieNotFound) {
            System.out.println("No movies found");
        }
    }

    public void printRandomMovie() {
        Movie randomMovie = movieLibrary.getMovies().get(random.nextInt(movieLibrary.getMovies().size()));
        System.out.println(randomMovie);
    }

    public void printActorsMovie() {
        String providedFirstName = scannerService.readFirstName();
        String providedLastName = scannerService.readLastName();

        boolean foundMovies = movieLibrary.getMovies().stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.getFirstName().equals(providedFirstName)
                                && actor.getLastName().equals(providedLastName)))
                .peek(movie -> System.out.println("Movie with selected actor: " + movie.getTitle().toUpperCase()))
                .count() > 0;

        if (!foundMovies) {
            System.out.println("No movies found");
        }
    }
}
