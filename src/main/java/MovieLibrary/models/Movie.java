package MovieLibrary.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie {
    private Director director;
    private String title;
    private int date;
    private String genre;
    private List<Actor> actors;

    public Movie() {
    }

    public Movie(Director director, String title, int releaseYear, String genre, List<Actor> actors) {
        this.director = director;
        this.title = title;
        this.date = releaseYear;
        this.genre = genre;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return title.toUpperCase() + "\n" +
                director + "\n" +
                "Release year: " + date + "\n" +
                "Genre: " + genre + "\n" +
                "Main actors: " + actors + "\n\n";
    }
}
