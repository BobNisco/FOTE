package order.test.update;

import fote.entry.User;
import fote.util.MongoHelper;
import order.test.util.TestHelper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Evan
 */
public class UserUpdate {
    private User myUser = new User();
    public UserUpdate() {
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
        MongoHelper.save(myUser, "users");
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
         User user = (User) MongoHelper.fetch(myUser, "users");
         if(user == null)
             TestHelper.failed("user not found");
         
         user.setFirstName("Evan");
         if(!MongoHelper.save(user, "users"))
             TestHelper.failed("first name update failed");
         
         user.setLastName("Van Dam");
         if(!MongoHelper.save(user, "users"))
             TestHelper.failed("last name update failed");
         
         User fetchedUser = (User) MongoHelper.fetch(user, "users");

         TestHelper.asserting(user.getFirstName().equals(fetchedUser.getFirstName()) && 
                 user.getLastName().equals(fetchedUser.getLastName()));
         System.out.println("updated user id: " + user.getId());
         
         TestHelper.passed();
     }
}