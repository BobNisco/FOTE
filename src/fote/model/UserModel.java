package fote.model;

import fote.entry.Entry;
import fote.entry.User;

import sun.misc.BASE64Encoder;

/**
 * Helper class that handles Users
 * @author Bob Nisco
 */
public class UserModel extends BaseModel {
    public UserModel() {
        super("users", User.class);
    }
    /**
     * 
     * @param u
     * @return whether or not the parameter is a valid User
     */
    public static boolean isValidUser(User u) {
        return handleIsValidUser(u.getId());
    }
    /**
     * 
     * @param u ID of the user
     * @return whether or not the User is valid
     */
    public static boolean isValidUser(Integer u) {
        return handleIsValidUser(u);
    }
    /**
     * Check if the user is valid by attempting to query it
     * @param u
     * @return whether or not a user was found
     */
    private static boolean handleIsValidUser(Integer u) {
        if (u < 0) {
            System.err.println("Not a valid user");
            return false;
        } else {
            UserModel userModel = new UserModel();
            Iterable<Entry> userQuery = userModel.query("{id:" + u + "}");
            if (!userQuery.iterator().hasNext()) {
                System.err.println("Not a valid user");
                return false;
            }
        }
        return true;
    }
    /**
     * 
     * @param i
     * @return The user with the specified ID
     */
    public User getUser(Integer i) {
        User result = new User();
        Iterable<Entry> userQuery = this.query("{id:" + i + "}");
        
        if (userQuery.iterator().hasNext()) {
            for (Entry user : userQuery) {
                result = (User) user;
            }
        }
        return result;
    }
    /**
     * 
     * @param p
     * @return a new encoded password
     */
    public static String encodePassword(String p) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encodeBuffer(p.getBytes());
    }
}
