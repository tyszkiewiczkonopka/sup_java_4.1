package MovieLibrary.Models;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Director {
    @JsonAlias({"firstName"})
    private String directorName;
    @JsonAlias({"lastName"})
    private String directorLastName;


    public Director(String directorName, String directorLastName) {
        this.directorName = directorName;
        this.directorLastName = directorLastName;
    }

    public Director() {
    }

    @Override
    public String toString() {
        return "Director: " + directorName + " " + directorLastName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorLastName() {
        return directorLastName;
    }

    public void setDirectorLastName(String directorLastName) {
        this.directorLastName = directorLastName;
    }
}
