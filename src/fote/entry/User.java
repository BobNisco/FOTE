package fote.entry;

/**
 * This class implements a User
 * @author Bob Nisco
 */
public class User extends Entry {
    private String firstName, lastName;

    public User() {
        super();
        this.firstName = "";
        this.lastName = "";
    }

    public User(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return "First Name: " + this.getFirstName() +
               " Last Name: " + this.getLastName();
    }
}
