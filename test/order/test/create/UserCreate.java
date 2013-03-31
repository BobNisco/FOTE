/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package order.test.create;

import fote.util.MongoHelper;
import fote.entry.User;
import order.test.util.TestHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Evan
 */
public class UserCreate {
    private User[] users = {
      new User("Evan", "Van Dam"),
      new User("Bob", "Nisco"),
      new User("Jason", "Parraga")
    };
    
    public UserCreate() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        TestHelper.signon(this);
        MongoHelper.setDB("fote");
        MongoHelper.getCollection("users").drop();
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void test() {
         for(User user : users) {
            if(!MongoHelper.save(user, "users"))
                TestHelper.failed("save failed");
            System.out.println("saved user id: " + user.getId() + " " + user.toString());
         } 
         TestHelper.passed();
     }
}