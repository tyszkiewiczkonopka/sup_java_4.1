package MovieLibrary;

import MovieLibrary.Models.Movie;
import MovieLibrary.Models.MovieLibrary;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private static final String MOVIES_DATA_PATH = "src/main/resources/movies.json";
    private final ObjectMapper mapper = new ObjectMapper();
    private MovieLibrary movieLibrary;

    public void showMenu() throws IOException {
        movieLibrary = mapper.readValue(new File(MOVIES_DATA_PATH), MovieLibrary.class);

        Scanner scanner = new Scanner(System.in);
        int action;

        System.out.println("""
                Welcome to my Movie Library!
                1 - Select release dates and get movie from that range
                2 - Get information about random movie
                3 - Movies with your selected actor""");
        action = scanner.nextInt();
        switch (action) {
            case 1 -> printMovieBetweenDates();
            case 2 -> printRandomMovie();
            case 3 -> printActorsMovie();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void printMovieBetweenDates() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start year: ");
        int startYear = scanner.nextInt();
        System.out.print("Enter end year: ");
        int endYear = scanner.nextInt();

        boolean movieNotFound = movieLibrary.getMovies().stream()
                .filter(movie -> movie.getReleaseYear() >= startYear && movie.getReleaseYear() <= endYear)
                .peek(movie -> System.out.println("Movie released in the range: " + movie.getTitle().toUpperCase()))
                .findAny()
                .isEmpty();

        if (movieNotFound) {
            System.out.println("No movies found");
        }
    }

    private void printRandomMovie() {
        Random random = new Random();
        Movie randomMovie = movieLibrary.getMovies().get(random.nextInt(movieLibrary.getMovies().size()));
        System.out.println(randomMovie);
    }

    private void printActorsMovie() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter actor's first name: ");
        String selectedName = scanner.nextLine();
        System.out.print("Enter actor's last name: ");
        String selectedLastName = scanner.nextLine();

        boolean foundMovies = movieLibrary.getMovies().stream()
                .filter(movie -> movie.getActors().stream()
                        .anyMatch(actor -> actor.getActorName().equals(selectedName) && actor.getActorLastName().equals(selectedLastName)))
                .peek(movie -> System.out.println("Movie with selected actor: " + movie.getTitle().toUpperCase()))
                .count() > 0;

        if (!foundMovies) {
            System.out.println("No movies found");
        }
    }
}
