package MovieLibrary.Models;

import MovieLibrary.Models.Actor;
import MovieLibrary.Models.Director;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Movie {
    private Director director;
    private String title;
    @JsonAlias({"date"})
    private int releaseYear;
    private String genre;
    private List<Actor> actors;
    public Movie() {
    }
    public Movie(Director director, String title, int releaseYear, String genre, List<Actor> actors) {
        this.director = director;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.actors = actors;
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
    @Override
    public String toString() {
        return title.toUpperCase() + "\n" +
                director + "\n" +
                "Release year: " + releaseYear + "\n" +
                "Genre: " + genre + "\n" +
                "Main actors: " + actors + "\n\n";
    }
}
