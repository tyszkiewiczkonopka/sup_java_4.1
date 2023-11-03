package MovieLibrary.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Director extends Person {

    public Director(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Director() {
    }

    @Override
    public String toString() {
        return "Director: " + super.getFirstName() + " " + super.getLastName();
    }
}
