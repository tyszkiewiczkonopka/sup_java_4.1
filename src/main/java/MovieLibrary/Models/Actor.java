package MovieLibrary;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Actor {
    @JsonAlias({"firstName"})
    private String actorName;
    @JsonAlias({"lastName"})
    private String actorLastName;

    public Actor() {
    }
    public Actor(String actorName, String actorLastName) {
        this.actorName = actorName;
        this.actorLastName = actorLastName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActorLastName() {
        return actorLastName;
    }

    public void setActorLastName(String actorLastName) {
        this.actorLastName = actorLastName;
    }

    @Override
    public String toString() {
        return actorName + " " + actorLastName;
    }
}
