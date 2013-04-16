/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fote;

import fote.entry.Proposal;
import fote.entry.User;
import fote.entry.Vote;
import fote.gui.Login;
import fote.util.MongoHelper;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author bobnisco
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
        MongoHelper.save(new User("Evan", "Van Dam", "evan.vandam1", "admin"), "users");
        MongoHelper.getCollection("proposals").drop();
        MongoHelper.save(new Proposal(new Date(), "Test subject", "Test description", new Integer(5), new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject1", "Test description", new Integer(5), new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject2", "Test description", new Integer(5), new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject3", "Test description", new Integer(5), new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject4", "Test description", new Integer(5), new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        MongoHelper.save(new Proposal(new Date(), "Test subject5", "Test description", new Integer(5), new Integer(0), new ArrayList<String>(), new ArrayList<Vote>(), new ArrayList<Integer>(), new ArrayList<Integer>()), "proposals");
        new Login().setVisible(true);
    }
}
