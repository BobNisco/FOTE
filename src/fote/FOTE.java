package fote;

import fote.entry.Proposal;
import fote.entry.Suggestion;
import fote.entry.User;
import fote.entry.Vote;
import fote.gui.Login;
import fote.gui.MainFrame;
import fote.util.MongoHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    
    public static void main(String[] args) throws ParseException {
        // Set the DB to fote 
        MongoHelper.setDB("fote");
        // add some fake data
        MongoHelper.getCollection("users").drop();
        MongoHelper.getCollection("votes").drop();
        MongoHelper.save(new User("Bob", "Nisco", "robert.nisco1@marist.edu", "password123"), "users");
        MongoHelper.save(new User("Jason", "Parraga", "jason.parraga1@marist.edu", "password123"), "users");
        MongoHelper.save(new User("Evan", "Van Dam", "Evan.VanDam1@marist.edu", "password123"), "users");
        MongoHelper.save(new User("ADMIN", "ADMIN", "admin", "admin"), "users");
        MongoHelper.getCollection("proposals").drop();
        ArrayList<String> options = new ArrayList<String>();
        options.add("Yes");
        options.add("No");
        MongoHelper.getCollection("comments").drop();
        ArrayList<Integer> comments = new ArrayList<Integer>();
        comments.add(new Integer(0));
        comments.add(new Integer(1));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        MongoHelper.save(new Proposal(sdf.parse("2013/08/29"), "Build a New Cafeteria?", "We have listened to the thoughts of students and realized that a new cafeteria would be beneficial.",
                4, new Integer(0), options, new ArrayList<Vote>(), comments, new ArrayList<String>()), "proposals");
        MongoHelper.save(new Proposal(sdf.parse("2013/01/01"), "Renovate 3rd Floor of Lowell Thomas", "We recently renovated the basement and second floor, but we should also renovate the third floor.",
                5, new Integer(1), options, new ArrayList<Vote>(), comments, new ArrayList<String>()), "proposals");
        MongoHelper.save(new Proposal(sdf.parse("2014/05/01"), "Build a Parking Garage", "Build a parking garage where the current McCann Center parking lot is. Would improve parking area for commuters and during game days.",
                3, new Integer(2), options, new ArrayList<Vote>(), comments, new ArrayList<String>()), "proposals");
        MongoHelper.getCollection("suggestions").drop();
        MongoHelper.save(new Suggestion("Purchase Solar Panels", "Put solar panels on top of Hancock Center to be more eco-friendly", 0, new ArrayList<Integer>(), new ArrayList<String>()), "suggestions");
        setMainFrame(new MainFrame());
        new Login(FOTE.getMainFrame(), true).setVisible(true);
    }
}
