package fote;

import fote.entry.Comment;
import fote.entry.Proposal;
import fote.entry.Suggestion;
import fote.entry.User;
import fote.entry.Vote;
import fote.gui.Login;
import fote.gui.MainFrame;
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
    private static MainFrame mf;
    
    public static void setUser(User user){
        FOTE.user = user;
    }
    
    public static User getUser() {
        System.out.println(FOTE.user.toString());
        return FOTE.user;
    }
    
    public static MainFrame getMainFrame() {
        return FOTE.mf;
    }
    
    public static void setMainFrame(MainFrame mf) {
        FOTE.mf = mf;
    }
    
    public static void main(String[] args) {
        // Set the DB to fote 
        MongoHelper.setDB("fote");
        // add user to logon...
        MongoHelper.getCollection("users").drop();
        MongoHelper.save(new User("Test", "Name", "admin", "admin"), "users");
        MongoHelper.getCollection("proposals").drop();
        ArrayList<String> options = new ArrayList<String>();
        options.add("yes");
        options.add("no");
        MongoHelper.getCollection("comments").drop();
        MongoHelper.save(new Comment("swag", new Integer(1)), "comments");
        MongoHelper.save(new Comment("derp", new Integer(2)), "comments");
        ArrayList<Integer> comments = new ArrayList<Integer>();
        comments.add(new Integer(1));
        comments.add(new Integer(2));
        MongoHelper.save(new Proposal(new Date(), "Test subject", "Test description", 5, new Integer(0), options, new ArrayList<Vote>(), comments, new ArrayList<String>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject1", "Test description", 4, new Integer(0), options, new ArrayList<Vote>(), comments, new ArrayList<String>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject2", "Test description", 3, new Integer(0), options, new ArrayList<Vote>(), comments, new ArrayList<String>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject3", "Test description", 2, new Integer(0), options, new ArrayList<Vote>(), comments, new ArrayList<String>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject4", "Test description", 1, new Integer(0), options, new ArrayList<Vote>(), comments, new ArrayList<String>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject5", "Test description", 1, new Integer(0), options, new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<String>()), "proposals");
        MongoHelper.getCollection("suggestions").drop();
        MongoHelper.save(new Suggestion("test subject", "test description", 0, new ArrayList<Integer>(), new ArrayList<Integer>()), "suggestions");
        setMainFrame(new MainFrame());
        new Login(FOTE.getMainFrame(), true).setVisible(true);
    }
}
