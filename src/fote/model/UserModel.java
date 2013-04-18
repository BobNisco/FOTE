package fote.model;

import fote.entry.Entry;
import fote.entry.User;

/**
 *
 * @author Bob Nisco
 */
public class UserModel extends BaseModel {
    public UserModel() {
        super("users", User.class);
    }
    
    public static boolean isValidUser(User u) {
        return handleIsValidUser(u.getId());
    }
    
    public static boolean isValidUser(Integer u) {
        return handleIsValidUser(u);
    }
    
    private static boolean handleIsValidUser(Integer u) {
        if (u <= 0) {
            return false;
        } else {
            UserModel userModel = new UserModel();
            Iterable<Entry> userQuery = userModel.query("{id:"+ u +"}");
            if (!userQuery.iterator().hasNext()) {
                return false;
            }
        }
        return true;
    }
}
