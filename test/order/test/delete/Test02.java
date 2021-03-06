package order.test.delete;

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
public class Test02 {
    private User[] users = {
      new User("Evan", "Van Dam", "evan@marist.edu", "password123"),
      new User("Bob", "Nisco", "bob@marist.edu", "password123"),
      new User("Jason", "Parraga", "jason@marist.edu", "password123")
    };
    
    public Test02() {
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
                TestHelper.failed("user save failed!");
        }
    }
    
    @After
    public void tearDown() {
        TestHelper.signoff(this);
    }
    
     @Test
     public void test() {
         for(User user : users) {
            if(!MongoHelper.delete(user, "users"))
                TestHelper.failed("delete failed");

            if(MongoHelper.fetch(user, "users") != null)
                TestHelper.failed("user was not deleted");

            System.out.println("Deleted user id: " + user.getId());
         }
         TestHelper.passed();
     }
}