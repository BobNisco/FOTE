package fote;

import fote.entry.Proposal;
import fote.entry.Suggestion;
import fote.entry.User;
import fote.entry.Vote;
import fote.gui.Login;
import fote.util.MongoHelper;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Bob Nisco
 */
public class FOTE {

    // The user which has logged in
    private static User user;
    
    public static void setUser(User user){
        FOTE.user = user;
    }
    
    public static User getUser(){
        return FOTE.user;
    }
    
    public static void main(String[] args) {
        // Set the DB to fote 
        MongoHelper.setDB("fote");
        // add user to logon...
        MongoHelper.getCollection("users").drop();
        MongoHelper.save(new User("Test", "Name", "admin", "admin"), "users");
        MongoHelper.getCollection("proposals").drop();
        MongoHelper.save(new Proposal(new Date(), "Test subject", "Test description", 5, new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject1", "Test description", 4, new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject2", "Test description", 3, new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject3", "Test description", 2, new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject4", "Test description", 1, new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject5", "Test description", 1, new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.getCollection("suggestions").drop();
        MongoHelper.save(new Suggestion("test subject", "test description", 0, new ArrayList<Integer>(), new ArrayList<Integer>()), "suggestions");
        new Login().setVisible(true);
    }
}
