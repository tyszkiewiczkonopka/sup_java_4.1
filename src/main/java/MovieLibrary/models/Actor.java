package MovieLibrary.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Actor extends Person {

    public Actor() {
    }

    public Actor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return super.getFirstName() + " " + super.getLastName();
    }
}
