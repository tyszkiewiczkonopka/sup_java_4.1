package MovieLibrary.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person {
    protected String firstName;
    protected String lastName;

    public Person(String firstName, String lastName) {
    }
    public Person(){
    }
}
