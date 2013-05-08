package fote;

import fote.entry.Proposal;
import fote.entry.Suggestion;
import fote.entry.User;
import fote.entry.Vote;
import fote.gui.Login;
import fote.gui.MainFrame;
import fote.model.UserModel;
import fote.util.MongoHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * Main class for the FOTE application
 * 
 * @author Bob Nisco
 */
public class FOTE {

    // The user which has logged in
    private static User user;
    private static MainFrame mf;
    
    /**
     * 
     * @param user current user logged into the application
     */
    public static void setUser(User user){
        FOTE.user = user;
    }
    
    /**
     * 
     * @return the current user logged in
     */
    public static User getUser() {
        return FOTE.user;
    }
    
    /**
     * 
     * @return the main swing Frame that contains all other dialogs
     */
    public static MainFrame getMainFrame() {
        return FOTE.mf;
    }
    
    /**
     * 
     * @param mf the main frame that FOTE will use. 
     * This should only be called once.
     */
    public static void setMainFrame(MainFrame mf) {
        FOTE.mf = mf;
    }
    
    public static void main(String[] args) throws ParseException {
        // Set the database to a fresh instance
        MongoHelper.setDB("fote");
        MongoHelper.dropDatabase();
        // add some users
        MongoHelper.save(new User("Bob", "Nisco", "robert.nisco1@marist.edu", UserModel.encodePassword("password123")), "users");
        MongoHelper.save(new User("Jason", "Parraga", "jason.parraga1@marist.edu", UserModel.encodePassword("password123")), "users");
        MongoHelper.save(new User("Evan", "Van Dam", "Evan.VanDam1@marist.edu", UserModel.encodePassword("password123")), "users");
        MongoHelper.save(new User("ADMIN", "ADMIN", "admin", UserModel.encodePassword("admin")), "users");
        
        // setup for adding proposals
        ArrayList<String> options = new ArrayList<String>();
        ArrayList<Integer> comments = new ArrayList<Integer>();
        options.add("Yes");
        options.add("No");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        // add some votes for the expired proposal to show off
        // that the view results functionality works
        MongoHelper.save(new Vote(0, 0, 1), "votes");
        MongoHelper.save(new Vote(1, 1, 1), "votes");
        MongoHelper.save(new Vote(2, 0, 1), "votes");
        ArrayList<Integer> votesForProposal1 = new ArrayList<Integer>() {{ 
            add(0); add(1); add(2);
        }};
        
        // add some starter proposals
        MongoHelper.save(new Proposal(sdf.parse("2013/08/29"), "Build a New Cafeteria?", "We have listened to the thoughts of students and realized that a new cafeteria would be beneficial.",
                4, new Integer(0), options, new ArrayList<Integer>(), comments, new ArrayList<String>()), "proposals");
        MongoHelper.save(new Proposal(sdf.parse("2013/01/01"), "Renovate 3rd Floor of Lowell Thomas", "We recently renovated the basement and second floor, but we should also renovate the third floor.",
                5, new Integer(1), options, votesForProposal1, comments, new ArrayList<String>()), "proposals");
        MongoHelper.save(new Proposal(sdf.parse("2014/05/01"), "Build a Parking Garage", "Build a parking garage where the current McCann Center parking lot is. Would improve parking area for commuters and during game days.",
                3, new Integer(2), options, new ArrayList<Integer>(), comments, new ArrayList<String>()), "proposals");
                
        // add some starter suggestions
        MongoHelper.save(new Suggestion("Purchase Solar Panels", "Put solar panels on top of Hancock Center to be more eco-friendly", 0, new ArrayList<Integer>(), new ArrayList<String>()), "suggestions");
        
        setMainFrame(new MainFrame());
        new Login(FOTE.getMainFrame(), true).setVisible(true);
    }
}
