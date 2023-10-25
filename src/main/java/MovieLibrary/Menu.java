package MovieLibrary;

import MovieLibrary.Models.Movie;
import MovieLibrary.Models.MovieLibrary;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    ObjectMapper mapper = new ObjectMapper();
    String path = "src/main/resources/movies.json";
    MovieLibrary movieLibrary = mapper.readValue(new File(path), MovieLibrary.class);

    public Menu() throws IOException {
    }

    public void showMenu() {

        Scanner scanner = new Scanner(System.in);
        int action;

        System.out.println("Welcome to my Movie Library!\n" +
                "1 - Select release dates and get movie from that range\n" +
                "2 - Get information about random movie\n" +
                "3 - Movies with your selected actor");
        action = scanner.nextInt();
        switch (action) {
            case 1 -> movieBetweenDates();
            case 2 -> randomMovie();
            case 3 -> actorsMovie();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void movieBetweenDates() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start year: ");
        int startYear = scanner.nextInt();
        System.out.print("Enter end year: ");
        int endYear = scanner.nextInt();

        boolean isMovieFound = movieLibrary.getMovies().stream()
                .filter(movie -> movie.getReleaseYear() >= startYear && movie.getReleaseYear() <= endYear)
                .peek(movie -> System.out.println("Movie released in the range: " + movie.getTitle().toUpperCase()))
                .count() > 0;

        if (!isMovieFound) {
            System.out.println("No movies found");
        }
    }

    private void randomMovie() {
        Random random = new Random();
        Movie randomMovie = movieLibrary.getMovies().get(random.nextInt(movieLibrary.getMovies().size()));
        System.out.println(randomMovie);
    }

    private void actorsMovie() {

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
