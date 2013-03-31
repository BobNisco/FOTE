/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package order.test.read;

import fote.entry.Entry;
import fote.entry.User;
import fote.util.MongoHelper;
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
public class UserRead {
    private User[] users = {
      new User("Evan", "Van Dam"),
      new User("Bob", "Nisco"),
      new User("Jason", "Parraga")
    };
    
    public UserRead() {
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
        
        for(User user : users) {
            if(!MongoHelper.save(user, "users"))
                TestHelper.failed("save user failed");
            
        }
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void test() {
         MongoHelper.setDB("fote");
         Iterable<Entry> queryUsers = MongoHelper.query("{id:{$gte:0}}", User.class, "users");
         int count = 0;
         for(Entry entry : queryUsers) {
             User user = (User) entry;
             System.out.println("retrieved user id: " + user.getId() + " " + user.getFirstName() + " " + user.getLastName());
             
             count++;
         }
         TestHelper.asserting(count == users.length);
     }
}