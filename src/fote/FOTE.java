/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fote;

import fote.entry.User;
import fote.gui.Login;
import fote.util.MongoHelper;
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
        new Login().setVisible(true);
    }
}
