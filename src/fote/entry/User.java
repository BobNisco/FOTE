package fote.entry;

/**
 * This class implements a User
 * @author Bob Nisco
 */
public class User extends Entry {
    private String firstName, lastName, maristID;

    /**
     *
     */
    public User() {
        super();
        this.firstName = "";
        this.lastName = "";
        this.maristID = "";
    }

    /**
     *
     * @param firstName
     * @param lastName
     */
    public User(String firstName, String lastName, String maristID) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.maristID = maristID;
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
     * @return the user's marist ID
     */
    public String getMaristID() {
        return maristID;
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
     * @param maristID a new maristID for this user
     */
    public void setMaristID(String maristID) {
        this.maristID = maristID;
    }
    
    
    /**
     *
     * @return a String representation of this user
     */
    @Override
    public String toString() {
        return "First Name: " + this.getFirstName() +
               "\nLast Name: " + this.getLastName() +
                "\nMarist ID: " + this.getMaristID();
    }
}
