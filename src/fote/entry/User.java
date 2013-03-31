package fote.entry;

/**
 * This class implements a User
 * @author Bob Nisco
 */
public class User extends Entry {
    private String firstName, lastName;

    /**
     *
     */
    public User() {
        super();
        this.firstName = "";
        this.lastName = "";
    }

    /**
     *
     * @param firstName
     * @param lastName
     */
    public User(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     *
     * @return the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param firstName a new first name for this user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param lastName a new last name for this user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     *
     * @return a String representation of this user
     */
    @Override
    public String toString() {
        return "First Name: " + this.getFirstName() +
               " Last Name: " + this.getLastName();
    }
}
