package MovieLibrary.services;

import java.io.IOException;

public class MenuService {
    private final MovieService movieService;
    private final ScannerService scannerService;

    public MenuService() throws IOException {
        movieService = new MovieService();
        scannerService = new ScannerService();
    }

    public void showMenu(){
        System.out.println("""
                Welcome to my Movie Library!
                1 - Select release dates and get movie from that range
                2 - Get information about random movie
                3 - Movies with your selected actor""");
        int action = scannerService.readAction();
        switch (action) {
            case 1 -> movieService.printMovieBetweenDates();
            case 2 -> movieService.printRandomMovie();
            case 3 -> movieService.printActorsMovie();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

}
